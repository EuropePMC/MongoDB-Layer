# MongoDB Layer

The MongoDB Layer component is a JAVA implementation of a [CRUD][1] interface to interact with a MongoDB database.

The project is written in JAVA 8 and uses [Maven][2] as development tool. The artifact produced is a jar file that can be used as library component in any JAVA project running at least on JAVA 8.

Each operation of the interface has two different versions:

 1. MongoDB standard Java Driver version: it uses the standard MongoDB driver classes.
 2. A POJO Java version using the [MongoJack][3] library: it allows the usage of normal Java Beans (POJO) that will map exactly the structure of the documents inside the MongoDB collections.

The CRUD interface is represented by the class uk.ac.ebi.literature.mongodb.dao.ICrudDAO. It is possible to find comments and examples of usage of every operations defined in the interface.

The implementation of the ICrudDAO interface is contained into the class uk.ac.ebi.literature.mongodb.dao.impl.CrudDaoImpl. An example of creation of one DAO object is:

<pre>
	ICrudDAO dao = new CrudDaoImpl(MONGODB_URL.PRODUCTION_ROUTER);
</pre>

The input parameter is an element of the enum MONGODB_URL defined inside the interface ICrudDAO. Every element of this enum will translate to a MongoDB server address (or a list of them if the connection is made to a MongoDB cluster with multiple servers).
Every element of the MONGODB_URL enum has a list of dbNames associated. For example consider the following element:

<pre>
PRODUCTION_ROUTER(new String[]{"prod_1", "prod_2"})
</pre>

It has two dbNames. For each element of the dbNames list there will be a specific set of properties in the file src/main/resources/mongodb.properties that hosts the connection details to the relative  MongoDB server:

<pre> 
 #properties for prod_1 database
hostName.prod_1=mongos-prod-1.ebi.ac.uk
port.prod_1=27017
databaseAuthentication.prod_1=admin
userName.prod_1=admin_user
password.prod_1=admin_user_password
</pre>

The match between the **dbName** value and the right set of properties is determined reading the properties with name "hostName.+**dbName**" and so on.

Similarly for the **prod_2** dbName there will be a set of properties like:

<pre> 
 #properties for prod_2 database
hostName.prod_2=mongos-prod-2.ebi.ac.uk
port.prod_2=27017
databaseAuthentication.prod_2=admin
userName.prod_2=admin_user
password.prod_2=admin_user_password
</pre>
 
 This means that the DAO object created previously with the instruction
 <pre>
	ICrudDAO dao = new CrudDaoImpl(MONGODB_URL.PRODUCTION_ROUTER);
</pre>

will be connecting to a cluster of MongoDB servers composed by two single servers:  mongos-prod-1.ebi.ac.uk and mongos-prod-2.ebi.ac.uk. The connection will be performed using the specified credentials.

Modifying accordingly the enum MONGODB_URL and the property file src/main/resources/mongodb.properties it is possible to add or modify MongoDB servers connection details that can be easily used to instantiate DAO objects as shown above.
 
In the packages uk.ac.ebi.literature.mongodb.model.annotations and uk.ac.ebi.literature.mongodb.model.annotations.sciliteapi the are examples of POJO that  map the MongoDB documents used in the [Europe PMC Annotations API][4] and that can be used in conjunction with the DAO operations.


[1]: https://en.wikipedia.org/wiki/Create,_read,_update_and_delete
[2]: https://maven.apache.org/
[3]: http://mongojack.org/
[4]: https://github.com/EuropePMC/Annotations-API
