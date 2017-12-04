package uk.ac.ebi.literature.mongodb.model.citation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jyothi
 * 16 May 2012  10:27:31
 */
public class DbCountList implements Serializable{

	private List<DbCounts> db;
	
	public DbCountList() {
		super();
		this.db = new ArrayList<DbCounts>();
	}

	/**
	 * @param db the db to set
	 */
	public void setDb(List<DbCounts> db) {
		this.db = db;
	}

	/**
	 * @return the db
	 */
	public List<DbCounts> getDb() {
		return db;
	}

}
