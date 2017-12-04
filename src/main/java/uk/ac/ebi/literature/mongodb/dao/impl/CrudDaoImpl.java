package uk.ac.ebi.literature.mongodb.dao.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.mongojack.DBQuery.Query;
import org.mongojack.DBCursor;
import org.mongojack.DBProjection;
import org.mongojack.JacksonDBCollection;
import org.mongojack.WriteResult;

import com.mongodb.DB;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ReadPreference;
import com.mongodb.ServerAddress;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.BulkWriteOptions;
import com.mongodb.client.model.ReplaceOneModel;
import com.mongodb.client.model.UpdateOneModel;
import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

import uk.ac.ebi.literature.mongodb.dao.ICrudDAO;
import uk.ac.ebi.literature.mongodb.util.*;

public class CrudDaoImpl implements ICrudDAO {
	
	protected MONGODB_URL dbUrl;
	
	private String databaseName;
	
	private DB database;
	
	private MongoClient mongoClient;
	
	private MongoDatabase mongoDatabase;
	
	/**
	 * 
	 * @param dbUrl dbUrl to connect to. The default database is literature
	 * @throws IOException if the mongodb.properties file is not found in the resources folder
	 */
	public CrudDaoImpl (MONGODB_URL dbUrl ) throws IOException{
		this(dbUrl,"literature");
	}
	
	/**
	 * 
	 * @param dbUrl dbUrl to connect to. The default database is literature
	 * @param databaseName database to connect to
	 * @throws IOException if the mongodb.properties file is not found in the resources folder
	 */
	public CrudDaoImpl (MONGODB_URL dbUrl, String databaseName ) throws IOException{
        this.dbUrl = dbUrl;
        this.databaseName = databaseName;
		
		List<ServerAddress> listServers = new ArrayList<ServerAddress>();
		List<MongoCredential> listCredentials = new ArrayList<MongoCredential>();
		ConnectionData connectionData;
		MongoCredential credentialData;
		boolean addCredential;
        for (String dbName : dbUrl.getDbNames()){
        	connectionData = new ConnectionData(dbName);
        	listServers.add(new ServerAddress(connectionData.getHostName(), connectionData.getPort()));
        	if (MongoDBUtility.isStringEmpty(connectionData.getUserName())==false){
        		addCredential= true;
        		for (MongoCredential credential : listCredentials){
        			if (connectionData.match(credential)){
        				addCredential= false;
        				break;
        			}
        		}
        		
        		if (addCredential){
        			credentialData = MongoCredential.createCredential(connectionData.getUserName(),
        					connectionData.getDatabaseAuthentication(),
        					connectionData.getPassword().toCharArray());
        			listCredentials.add(credentialData);
        		}
        	}
        }
        
        mongoClient = new MongoClient( listServers, listCredentials);
		
		mongoClient.setReadPreference(ReadPreference.secondaryPreferred());
		
    	database = mongoClient.getDB(databaseName);
    	database.setReadPreference(ReadPreference.secondaryPreferred());
    	 
    	mongoDatabase = mongoClient.getDatabase(databaseName);
    	
	}
	
	@Override
	public void closeConnection() {
		this.mongoClient.close();
		
	}
	

	@Override
	public <T> boolean insertEntries(String collection , Class<T> modelClass, List<T> entities) {
		boolean ret= true;
		
		try{
			JacksonDBCollection<T, String> collectionData = JacksonDBCollection.wrap(database.getCollection(collection), modelClass  , String.class);
			WriteResult<T, String> result = collectionData.insert(entities);
		}catch(Exception e){
			this.logError(e);
			ret=false;
		}
	
		return ret;
	}
	
	@Override
	public <T> long deleteEntries(String collection, Class<T> modelClass, Query filter) {
		long ret;
		
		try{
			JacksonDBCollection<T, String> collectionData = JacksonDBCollection.wrap(database.getCollection(collection), modelClass  , String.class);
			WriteResult<T, String> result = collectionData.remove(filter);
			ret=result.getWriteResult().getN();
		}catch(Exception e){
			this.logError(e);
			ret=-1;
		}
		
		return ret;
	}


	@Override
	public <T> long updateEntries(String collection, Class<T> modelClass, Query filter, T updateData) {
		long ret;
		
		try{
			JacksonDBCollection<T, String> collectionData = JacksonDBCollection.wrap(database.getCollection(collection), modelClass  , String.class);
			WriteResult<T, String> result = collectionData.update(filter, updateData);
			ret=result.getWriteResult().getN();
		}catch(Exception e){
			this.logError(e);
			ret=-1;
		}
		
		return ret;
	}
	
	@Override
	public <T> com.mongodb.bulk.BulkWriteResult upsertEntries(String collection, Class<T> modelClass, List<String> fieldNameKey, List<T> entities) {
		com.mongodb.bulk.BulkWriteResult bulkWriteResult=null;
		
		try{
			JacksonDBCollection<T, String> collectionData = JacksonDBCollection.wrap(database.getCollection(collection), modelClass  , String.class);
			
			Document updateDocument;
			Map updateDocumentData;
			DBObject updateDocumentDB;
			
			List<ReplaceOneModel<Document>> updateDocuments = new ArrayList<ReplaceOneModel<Document>>();
			for (T entity : entities){
				 
				 //Update doc
			    updateDocumentDB = collectionData. convertToDbObject(entity);
			    updateDocumentData = updateDocumentDB.toMap();
			    updateDocument = new Document(updateDocumentData);
			    		
			  //Finder doc
			    Document filterDocument = new Document();
			    for (String key : fieldNameKey){
			    	filterDocument.append(key, updateDocumentDB.get(key));
			    }

			    //Update option
			    UpdateOptions updateOptions = new UpdateOptions();
			    updateOptions.upsert(true); //if true, will create a new doc in case of unmatched find
			    updateOptions.bypassDocumentValidation(false); //set true/false

			    //Prepare list of Updates
			    updateDocuments.add(
			            new ReplaceOneModel<Document>(
			                    filterDocument,
			                    updateDocument,
			                    updateOptions));
			}
			
			//Bulk write options
			BulkWriteOptions bulkWriteOptions = new BulkWriteOptions();
			bulkWriteOptions.ordered(true);
			bulkWriteOptions.bypassDocumentValidation(false);

			MongoCollection<Document> collectionMongoData = mongoDatabase.getCollection(collection);

			bulkWriteResult =collectionMongoData.bulkWrite(updateDocuments, bulkWriteOptions);
			
		}catch(Exception e){
			this.logError(e);
			bulkWriteResult=null;
		}
		
		return bulkWriteResult;
	}
	
	@Override
	public <T> Results<T> findEntries (String collection,  Class<T> modelClass, Query query){
		
		Results<T> ret =null;
		
		try{
			JacksonDBCollection<T, String> collectionData = JacksonDBCollection.wrap(database.getCollection(collection), modelClass  , String.class);
	        DBCursor<T> resultsData = collectionData.find(query);
	        ret= new ResultJackson<T> (resultsData);
		}catch(Exception e){
			this.logError(e);
			ret=null;
		}
		
		return ret;
	}
	
	@Override
	public <T> Results<T> findEntries (String collection,  Class<T> modelClass, List<String> fields, Query query){
		
		Results<T> ret =null;
		
		try{
			JacksonDBCollection<T, String> collectionData = JacksonDBCollection.wrap(database.getCollection(collection), modelClass  , String.class);
	        DBCursor<T> resultsData = collectionData.find(query, DBProjection.include(fields.toArray(new String[0])));
	        ret= new ResultJackson<T> (resultsData);
		}catch(Exception e){
			this.logError(e);
			ret=null;
		}
		
		return ret;
	}
	
	@Override
	public <T> T findEntry(String collection, Class<T> modelClass, Query query) {
		T ret=null;
		
		try{
	       JacksonDBCollection<T, String> collectionData = JacksonDBCollection.wrap(database.getCollection(collection), modelClass  , String.class);
	       ret = collectionData.findOne(query);
		}catch(Exception e){
			this.logError(e);
			ret=null;
		}
       
       return ret;
	}
	
	@Override
	public <T> long countEntries(String collection, Class<T> modelClass, Query query){
		long ret;
		
		try{
	       JacksonDBCollection<T, String> collectionData = JacksonDBCollection.wrap(database.getCollection(collection), modelClass  , String.class);
	       if (query!=null){
	    	   ret = collectionData.getCount(query);
	       }else{
	    	   ret = collectionData.getCount();
	       }
		}catch(Exception e){
			this.logError(e);
			ret=-1;
		}
       
       return ret;
	}
	
	@Override
	public boolean insertEntries(String collection, List<Document> documents){
		boolean ret=true;
		
		try{
			MongoCollection<Document> collectionData = mongoDatabase.getCollection(collection);
			collectionData.insertMany(documents);
		}catch(Exception e){
			this.logError(e);
			ret=false;
		}
		return ret;
	}

	@Override
	public long deleteEntries(String collection, Bson filter) {
		long ret;
		
		try{
			MongoCollection<Document> collectionData = mongoDatabase.getCollection(collection);
			DeleteResult result = collectionData.deleteMany(filter);
			ret=result.getDeletedCount();
		}catch(Exception e){
			this.logError(e);
			ret=-1;
		}
       
       return ret;
	}
	
	@Override
	public long updateEntries(String collection, Bson filter, Bson updateData) {
		long ret;
		
		try{
			MongoCollection<Document> collectionData = mongoDatabase.getCollection(collection);
			
			Document updateDocument = new Document();
			updateDocument.append("$set", updateData);
			UpdateResult result = collectionData.updateMany(filter, updateDocument);
			ret= result.getModifiedCount();
		}catch(Exception e){
			this.logError(e);
			ret=-1;
		}
       
       return ret;
	}
	
	@Override
	public long replaceOne(String collection, Bson filter, Document replacement) {
		long ret;
		
		try{
			MongoCollection<Document> collectionData = mongoDatabase.getCollection(collection);
			UpdateResult result = collectionData.replaceOne(filter, replacement);
			ret= result.getModifiedCount();
		}catch(Exception e){
			this.logError(e);
			ret=-1;
		}

		return ret;
	}

	@Override
	public FindIterable<Document> findEntries(String collection, Bson filter) {
		FindIterable<Document> ret=null;
		
		try{
			MongoCollection<Document> collectionData = mongoDatabase.getCollection(collection);
			ret =  collectionData.find(filter);
		}catch(Exception e){
			this.logError(e);
			ret=null;
		}
		
		return ret;
	}


	@Override
	public long countEntries(String collection, Bson filter) {
		long ret=-1;
		
		try{
			MongoCollection<Document> collectionData = mongoDatabase.getCollection(collection);
			if (filter!=null){
				ret =  collectionData.count(filter);
			}else{
				ret =  collectionData.count();
			}
		}catch(Exception e){
			this.logError(e);
			ret=-1;
		}
		
		return ret;
	}
	
	@Override
	public long countEntries(String collection) {
		
		return countEntries(collection, null);
	}
	
	/**
	 * Method to log an exception related to MOngoDB operations
	 * @param e exception occurred during a MongoDB operation execution
	 */
	protected void logError(Exception e) {
		Logger logger = Logger.getLogger(CrudDaoImpl.class);
		logger.error("MongoDB ERROR:"+e.getMessage(), e);
	}

	public MONGODB_URL getDbUrl() {
		return dbUrl;
	}

	public DB getDatabase() {
		return database;
	}

	public MongoDatabase getMongoDatabase() {
		return mongoDatabase;
	}

	public String getDatabaseName() {
		return databaseName;
	}

	@Override
	public com.mongodb.bulk.BulkWriteResult updateBulkEntries(String collection, List<String> fieldNameKey, List<Document> documents) {
		com.mongodb.bulk.BulkWriteResult bulkWriteResult=null;
		
		try{
			
			Document updateDocument;
			
			List<UpdateOneModel<Document>> updateDocuments = new ArrayList<UpdateOneModel<Document>>();
			for (Document document : documents){
				 		
			  //Finder doc
			    Document filterDocument = new Document();
			    for (String key : fieldNameKey){
			    	filterDocument.append(key, document.get(key));
			    }

			    //Update Document
			    updateDocument = new Document("$set", document);
			    
			    //Update option
			    UpdateOptions updateOptions = new UpdateOptions();
			    updateOptions.upsert(false); //if true, will create a new doc in case of unmatched find
			    updateOptions.bypassDocumentValidation(false); //set true/false

			    //Prepare list of Updates
			    updateDocuments.add(
			            new UpdateOneModel<Document>(
			                    filterDocument,
			                    updateDocument,
			                    updateOptions));
			}
			
			//Bulk write options
			BulkWriteOptions bulkWriteOptions = new BulkWriteOptions();
			bulkWriteOptions.ordered(true);
			bulkWriteOptions.bypassDocumentValidation(false);

			MongoCollection<Document> collectionMongoData = mongoDatabase.getCollection(collection);

			bulkWriteResult =collectionMongoData.bulkWrite(updateDocuments, bulkWriteOptions);
			
		}catch(Exception e){
			this.logError(e);
			bulkWriteResult=null;
		}
		
		return bulkWriteResult;
	}
	
	@Override
	public String getConnectionInfo(){
		String ret;
		/**Document serverStatus = this.mongoDatabase.runCommand(new Document("serverStatus", 1));
		Map connections = (Map) serverStatus.get("connections");
		ret="Connected to" + this.getDbUrl().name() + " "+ this.mongoClient.getConnectPoint()+ " Connection info: " +connections.toString();/*/
		
		ret="Connected to " + this.getDbUrl().name() + " : "+ this.mongoClient.getConnectPoint();
		
		return ret;
	}

    @Override
    public <T> Results<T> findEntries(String collection, Class<T> modelClass, Query query, DBObject orderBy) {
        Results<T> ret =null;
        
        try{
            JacksonDBCollection<T, String> collectionData = JacksonDBCollection.wrap(database.getCollection(collection), modelClass, String.class);
            DBCursor<T> resultsData = collectionData.find(query);
            resultsData.sort(orderBy);
            ret= new ResultJackson<T> (resultsData);
        }catch(Exception e){
            this.logError(e);
            ret=null;
        }
        
        return ret;
    }
    
    @Override
    public <T> Results<T> findEntries(String collection, Class<T> modelClass, Query query, DBObject orderBy, int limit) {
        Results<T> ret =null;
        
        try{
            JacksonDBCollection<T, String> collectionData = JacksonDBCollection.wrap(database.getCollection(collection), modelClass, String.class);
            DBCursor<T> resultsData = collectionData.find(query);
            resultsData.sort(orderBy);
            resultsData.limit(limit);
            ret= new ResultJackson<T> (resultsData);
        }catch(Exception e){
            this.logError(e);
            ret=null;
        }
        
        return ret;
    }
    
    @Override
	public <T> Results<T> findEntries(String collection, Class<T> modelClass, List<String> fields, Query query, DBObject orderBy, int limit) {
		Results<T> ret =null;
        
        try{
            JacksonDBCollection<T, String> collectionData = JacksonDBCollection.wrap(database.getCollection(collection), modelClass, String.class);
            DBCursor<T> resultsData = collectionData.find(query, DBProjection.include(fields.toArray(new String[0])));
            resultsData.sort(orderBy);
            resultsData.limit(limit);
            ret= new ResultJackson<T> (resultsData);
        }catch(Exception e){
            this.logError(e);
            ret=null;
        }
        
        return ret;
	}

	@Override
	public void close() throws Exception {
		this.closeConnection();
		
	}
	
}
