package uk.ac.ebi.literature.mongodb.dao;

import uk.ac.ebi.literature.mongodb.util.Results;

import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.mongojack.DBQuery.Query;

import com.mongodb.bulk.BulkWriteResult;
import com.mongodb.DB;
import com.mongodb.DBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;

public interface ICrudDAO extends AutoCloseable {
	/**
	 * List of the MONGO db databases managed. 
	 * Once that it's necessary to add a database then make the following actions:
	 * <ol>
	 * 
	 * <li>add an enum value with a string associated </li>
	 * <li>Create in the mongodb.properties file the connection properties with the proper name. Considering for example the enum value TEST the connection values are:
	 * hostName.test=mongos-test.ebi.ac.uk
       port.test=27017
       databaseAuthentication.test=admin
       userName.test=admin_user
       password.test=admin_password 
       
       where test is the dbName associated with the enum. If the enum has more than one dbName it means that a list of seeds will be associated with the mongoDb operations</li>
	 * </ol>
	 * 
	 *
	 */
	public enum MONGODB_URL{
		/**
		 * localhost instance
		 */
		LOCALHOST(new String[]{"localhost"}),
		/**
		 * the HX test environment
		 */
		TEST(new String[]{"test"}),
		/**
		 * Connection to use to read/write in failover mode from all two PROD instances (prod_1,prod_2)
		 */
		PRODUCTION_ROUTER(new String[]{"prod_1", "prod_2"}),
		
		/**
		 * PROD_1 instance
		 */
		PROD_1(new String[]{"prod_1"}),
		
		/**
		 * PROD_2 instance
		 */
		PROD_2(new String[]{"prod_2"}),;
		
		/**
		 * list of names for which to read the connection properties into the mongodb.properties file. Every element of the array specifies one seed to connect to.
		 */
		private String[] dbNames;
		
		
		private MONGODB_URL(String[] dbNames){
			this.dbNames = dbNames;
			
		}
		
		public String[] getDbNames(){
			return this.dbNames;
		}

	}
	
	/**
	 * Method to insert a list of documents of the type modelClass in the collection specified
	 * @param collection name of the collection to insert the data into
	 * @param modelClass type of the object of the documents to insert
	 * @param entities list of documents to insert into the database
	 * @return true if all the documents are inserted correctly , otherwise false
	 */
	public <T> boolean insertEntries(String collection, Class<T> modelClass, List<T> entities);
	
	/**
	 * Method to delete some  documents from the specified collection
	 * @param collection name of the collection to remove the documents from
	 * @param modelClass type of the object of the documents to delete
	 * @param filter filter to determinate the documents to delete
	 * @return the number of documents delete, otherwise -1 if an error happened
	 */
	public <T> long deleteEntries(String collection,  Class<T> modelClass, Query filter);
	
	/**
	 * Method to update some  documents from the specified collection. It will replace all the entire documents with the entity passed
	 * @param collection name of the collection to update the documents into
	 * @param modelClass type of the object of the documents to update
	 * @param filter filter to determinate the documents to update
	 * @param updateData new value to use to update the documents
	 * @return the number of documents updated, otherwise -1 if an error happened
	 */
	public <T> long updateEntries(String collection, Class<T> modelClass, Query filter, T updateData);
	
	/**
	 * Method to update or insert the entities specified.
	 * Example fo usage:
	 * <br/>
	 * 
	 	Result T1 = dao.findEntry("citations", Result.class, DBQuery.is("citationId", 15419678));
		Result T2 =dao.findEntry("citations", Result.class, DBQuery.is("citationId", 15420459));
		Result T3 =dao.findEntry("citations", Result.class, DBQuery.is("citationId", 15421784));
		
		T1.setCitedByCount(2000000);
		
		T2.setCitedByCount(2000000);
		
		T3.setCitedByCount(3000000);
		
		BulkWriteResult result = dao.upsertEntries("citations", Result.class, Arrays.asList("citationId"), Arrays.asList(T1, T2, T3));
	 * 
	 * @param collection name of the collection to update/insert the documents into
	 * @param modelClass type of the object of the documents to update
	 * @param fieldNameKey list of the key fields used to match the entities to update. If no match is found for a specific document using the filter specified, a new document will be inserted
	 * @param entities entities to update or insert 
	 * @return BulkWriteResult. It will be null if the operation fails
	 */
	public <T> BulkWriteResult upsertEntries(String collection, Class<T> modelClass, List<String> fieldNameKey, List<T> entities);
	
	/**
	 * Method to retrieve one document according to the condition specified
	 * @param collection name of the collection to retrieve the document from
	 * @param modelClass type of the document to retrieve
	 * @param query filter to determine the object to retrieve
	 * @return the document retrieved, null if the document has not been found
	 */
    public <T> T findEntry(String collection, Class<T> modelClass, Query query);
	
    /**
	 * Method to retrieve a cursor pointing to the list of documents according to the condition specified.
	 * Example of usage:
	 * <br/>

	 * Results<AnnotationSingle> results =null;
	 * 	try(ICrudDao dao = new CrudDaoImpl(MOGODB_URL.HX_TEST);){
			
	        results = dao.findEntries("annotationsSingle", AnnotationSingle.class, DBQuery.is("pmcid", pmcId));

            if (results!=null){
				for (AnnotationSingle singleDocument : results){
					.......
				}
			}
			
			//or alternitevely results.stream()....;
			
		}finally{
			if (results!=null){
				results.closeResult();
			}
		}
	 * 
	 * 
	 * @param collection name of the collection to retrieve the documents from
	 * @param modelClass type of the documents to retrieve
	 * @param query filter to determine the objects to retrieve
	 * @return a cursor of documents retrieved, null if no document matching the criteria specified has been found
	 */
	public <T> Results<T> findEntries(String collection, Class<T> modelClass, Query query);
	
	
    /**
     * Method to retrieve a cursor pointing to the list of documents according to the condition specified in a particular order
     * Example of usage:
     * <br/>
     * 
     * <pre>{@code
     * 
     * 
     * Results<AnnotationSingle> results =null;
     *  try(ICrudDao dao = new CrudDaoImpl(MOGODB_URL.HX_TEST);){
            
            results = dao.findEntries("annotationsSingle", AnnotationSingle.class, DBQuery.is("pmcid", pmcId), DBSort.desc("date"));

            if (results!=null){
                for (AnnotationSingle singleDocument : results){
                    .......
                }
            }
            
            //or alternitevely results.stream()....;
        }finally{
            if (results!=null){
                results.closeResult();
            }
        }
       }</pre> 
	 * @param collection name of the collection to retrieve the documents from
	 * @param modelClass type of the documents to retrieve
	 * @param query filter to determine the objects to retrieve
	 * @param sort the fields by which to sort
	 * @return a cursor of documents retrieved, null if no document matching the criteria specified has been found
	 */
	public <T> Results<T> findEntries(String collection, Class<T> modelClass, Query query, DBObject sort);
	
	 /**
     * Method to retrieve a cursor pointing to the list of documents according to the condition specified in a particular order and limiting the result to a specific number
     * Example of usage:
     * <br/>
     * 
     * <pre>{@code
     * 
     * Results<AnnotationSingle> results =null;
     *  try(ICrudDao dao = new CrudDaoImpl(MOGODB_URL.HX_TEST);){
            results = dao.findEntries("annotationsSingle", AnnotationSingle.class, DBQuery.is("pmcid", pmcId), DBSort.desc("date"), 100);

            if (results!=null){
                for (AnnotationSingle singleDocument : results){
                    .......
                }
                
               //or alternitevely results.stream()....;
            }
            
        }finally{
            if (results!=null){
                results.closeResult();
            }
        }
       }</pre> 
	 * @param collection name of the collection to retrieve the documents from
	 * @param modelClass type of the documents to retrieve
	 * @param query filter to determine the objects to retrieve
	 * @param sort the fields by which to sort
	 * @param limit the maximum number of results returned
	 * @return a cursor of documents retrieved, null if no document matching the criteria specified has been found
	 */
	public <T> Results<T> findEntries(String collection, Class<T> modelClass, Query query, DBObject orderBy, int limit);
	
	
	/**
     * Method to retrieve a cursor pointing to the list of documents according to the condition specified in a particular order and limiting the result to a specific number. It is possible to specify the fields to retrieve
     * Example of usage:
     * <br/>
     * 
     * <pre>{@code
     * 
     * Results<AnnotationSingle> results =null;
     *  try(ICrudDao dao = new CrudDaoImpl(MOGODB_URL.HX_TEST);){
            results = dao.findEntries("annotationsSingle", AnnotationSingle.class, Arrays.asList("pmcid"),DBQuery.is("pmcid", pmcId), DBSort.desc("date"), 100);

            if (results!=null){
                for (AnnotationSingle singleDocument : results){
                    .......
                }
                
               //or alternitevely results.stream()....;
            }
            
        }finally{
            if (results!=null){
                results.closeResult();
            }
        }
       }</pre> 
	 * @param collection name of the collection to retrieve the documents from
	 * @param modelClass type of the documents to retrieve
	 * @param query filter to determine the objects to retrieve
	 * @param sort the fields by which to sort
	 * @param fields fields that I want to retrieve
	 * @param limit the maximum number of results returned
	 * @return a cursor of documents retrieved, null if no document matching the criteria specified has been found
	 */
	public <T> Results<T> findEntries(String collection, Class<T> modelClass,  List<String> fields, Query query, DBObject orderBy, int limit);
	
	/**
	 * Method to retrieve a cursor pointing to the list of documents according to the condition specified. It retrieves only specific fields
	 *  
	 * @param collection name of the collection to retrieve the documents from
	 * @param modelClass type of the documents to retrieve
	 * @param query filter to determine the objects to retrieve
	 * @param fields fields that I want to retrieve
	 * @return a cursor of documents retrieved, null if no document matching the criteria specified has been found
	 */
	public <T> Results<T> findEntries(String collection, Class<T> modelClass,  List<String> fields, Query query);

	/**
	 * Method to count the documents matching some criteria into a pecific collection
	 * @param collection name of the collection to count the documents from
	 * @param modelClass   type of the documents to count
	 * @param query filter to use to count the documents
	 * @return the count of documents matching the filter specified, otherwise -1 if an error happens
	 */
	public <T> long countEntries(String collection, Class<T> modelClass, Query query);
	
	/**
	 * Method to insert a list of documents in the collection specified
	 * @param collection name of the collection to insert the data into
	 * @param documents list of documents to insert into the database
	 * @return true if all the documents are inserted correctly , otherwise false
	 */
	public boolean insertEntries(String collection, List<Document> documents);
	
	/**
	 * Method to update partially documents with the fields specified. 
	 * Example of usage :
	 * <br/>
	 * 
	 	Document D1 = new Document().append("citationId", 15429760).append("citedByCount", 5000000);
	 	Document D2 = new Document().append("citationId", 19558047).append("citedByCount", 2000000);
	 	BulkWriteResult result = dao.updateBulkEntries("citations", Arrays.asList("citationId"), Arrays.asList(D1, D2));
	 
	 *  NB. The document MUST contain the values for the key fields specified (citationId)
	 *	
	 * @param collection name of the collection
	 * @param fieldNameKey list of the key fields used to create the filter condition for every document
	 * @param documents fields to update on the different documents. Every document MUST contain the values for all the key fielsd mentioned into the paremeter fieldNameKey
	 * @return BulkWriteResult It will be null if the operation fails
	 */
	public BulkWriteResult updateBulkEntries(String collection, List<String> fieldNameKey, List<Document> documents);
	
	/**
	 * Method to delete some  documents from the specified collection
	 * @param collection name of the collection to remove the documents from
	 * @param filter filter to determinate the documents to delete
	 * @return the number of documents delete, otherwise -1 if an error happened
	 */
	public long deleteEntries(String collection, Bson filter);
	
	/**
	 * Method to update partially some  documents from the specified collection
	 * @param collection name of the collection to update the documents into
	 * @param filter filter to determinate the documents to update
	 * @param updateData new fields values to use to update partially the documents. You need to specify only the fields value that you want to update. 
	 *         If you want to replace the entire document you need to specify all the fields or better to use the replaceOne method or the
	 *         method updateEntries(String collection, Class<T> modelClass, Query filter, T updateData)
	 *        
	 * @return the number of documents updated, otherwise -1 if an error happened
	 */
	public long updateEntries(String collection, Bson filter, Bson updateData);
	
	/**
	 * Method to replace entirely one  document from the specified collection
	 * @param collection name of the collection in which to replace the document
	 * @param filter filter to determinate the document to replace
	 * @param updateData new value to use to replace the document. You need to specify all the fields of the document.
	 * @return 1 if the document has been replace, 0 if no matching document was found, otherwise -1 if an error happened
	 */
	public long replaceOne(String collection, Bson filter, Document replacement);
	
	/**
	 * Method to retrieve a cursor pointing to the list of documents according to the condition specified.
	 * Example of usage:
	 * <br/>
	 * 
	 * ICrudDao dao=null;
	 * 	try( ICrudDao dao== new CrudDaoImpl(MOGODB_URL.HX_TEST);){
	        FindIterable<Document> results = dao.findEntries("annotationsSingle",  Filters.eq("pmcid", pmcId));

            if (results!=null){
				for (Document singleDocument : results){
					.......
				}
			}
			
		}
	 * 
	 * 
	 * @param collection name of the collection to retrieve the documents from
	 * @param query filter to determine the objects to retrieve
	 * @return a cursor of documents retrieved, null if the document has not been found
	 */
	public FindIterable<Document> findEntries(String collection, Bson filter);
	
	/**
	 * Method to count the documents matching some criteria into a specific collection
	 * @param collection name of the collection to count the documents from
	 * @param query filter to use to count the documents
	 * @return the count of documents matching the filter specified, otherwise -1 if an error happens
	 */
	public long countEntries(String collection, Bson filter);
	
	/**
	 * Method to count all the documents into a specific collection
	 * @param collection name of the collection to count the documents from
	 * @return the count of all the documents into the specified collection, otherwise -1 if an error happens
	 */
	public long countEntries(String collection);
	
	/**
	 * Method to close the connection. It has to be used into a finally clause every time that an instance of this interface is created.
	 */
	public void closeConnection();

    /**
     * Getter for The DBUrl connected with this Dao
     * @return
     */
	public MONGODB_URL getDbUrl();

	/**
	 * Getter of the database object to use with the typed entities 
	 * @return
	 */
	public DB getDatabase();

	/**
	 * Getter of the database object to use with the generic Document collections.
	 * @return
	 */
	public MongoDatabase getMongoDatabase();
	
	/**
	 * Getter of the database name 
	 * @return
	 */
	public String getDatabaseName();

	/**
	 * 
	 * @return all the connections info
	 */
	public String getConnectionInfo();
	
}
