package uk.ac.ebi.literature.mongodb.test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import uk.ac.ebi.literature.mongodb.dao.ICrudDAO;
import uk.ac.ebi.literature.mongodb.dao.ICrudDAO.MONGODB_URL;
import uk.ac.ebi.literature.mongodb.dao.impl.CrudDaoImpl;

public class CrudDaoTest {

	@Test
	public void testConnection() throws IOException{
		for (MONGODB_URL dbUrl : MONGODB_URL.values()){
			if (dbUrl!=MONGODB_URL.LOCALHOST){
				ICrudDAO crudDao = new CrudDaoImpl(dbUrl);
				long llCount = crudDao.countEntries("annotationsApi", null);
				assertTrue("Numer of entities in collection annotationsMultiple is 0", llCount>=0);
			}
		}
		
	}
}
