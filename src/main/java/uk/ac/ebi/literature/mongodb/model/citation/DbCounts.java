package uk.ac.ebi.literature.mongodb.model.citation;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlType;

/**
 * @author jyothi
 * 16 May 2012  10:29:52
 */
@XmlType (name = "dbCounts", propOrder = {"dbName","count"})
public class DbCounts implements Serializable{

	private String dbName;
	private Integer count;
	
	public DbCounts() {
		super();
	}

	/**
	 * @param dbName the dbName to set
	 */
	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	/**
	 * @return the dbName
	 */
	public String getDbName() {
		return dbName;
	}

	/**
	 * @param count the count to set
	 */
	public void setCount(Integer count) {
		this.count = count;
	}

	/**
	 * @return the count
	 */
	public Integer getCount() {
		return count;
	}

}
