/**
 * This class gives the list of all cross references database names
 */
package uk.ac.ebi.literature.mongodb.model.citation;

import java.io.Serializable;
import java.util.ArrayList;

import uk.ac.ebi.literature.mongodb.util.MongoDBUtility;

/**
 * @author jyothi
 * 25 Apr 2012  15:57:49
 */
public class CrossReferencesList implements Serializable{

	/* this is for searchCitations's purpose to give list of all cross reference database names 
     * for a given article
     */
	private ArrayList<String> dbName;
	
	public CrossReferencesList() {
		super();
	}

	/**
	 * @param dbName the dbName to set
	 */
	public void setDbName(ArrayList<String> dbName) {
		this.dbName = dbName;
	}

	/**
	 * @return the dbName
	 */
	public ArrayList<String> getDbName() {
		return dbName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dbName == null) ? 0 : dbName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof CrossReferencesList))
			return false;
		CrossReferencesList other = (CrossReferencesList) obj;
		if (dbName == null) {
			if (other.dbName != null)
				return false;
		} else if (!MongoDBUtility.equalsList(dbName,other.dbName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CrossReferencesList [dbName=" + dbName + "]";
	}

}
