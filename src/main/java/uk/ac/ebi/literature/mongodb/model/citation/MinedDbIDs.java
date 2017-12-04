package uk.ac.ebi.literature.mongodb.model.citation;
 
import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author jyothi
 * 7 Mar 2011  11:22:46
 */
public class MinedDbIDs implements Serializable{

	private ArrayList<String> dbId;
	
	public MinedDbIDs() {
		super();
		this.dbId = new ArrayList<String>();
	}

	/**
	 * @param dbId the dbId to set
	 */
	public void setDbId(ArrayList<String> dbId) {
		this.dbId = dbId;
	}

	/**
	 * @return the dbId
	 */
	public ArrayList<String> getDbId() {
		return dbId;
	}

}
