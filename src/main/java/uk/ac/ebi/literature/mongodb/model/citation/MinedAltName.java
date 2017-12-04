package uk.ac.ebi.literature.mongodb.model.citation;
 
import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author jyothi
 * 7 Mar 2011  11:22:27
 */
public class MinedAltName implements Serializable{

	private ArrayList<String> altName;
	
	public MinedAltName() {
		super();
		this.altName = new ArrayList<String>();
	}

	/**
	 * @param altName the altName to set
	 */
	public void setAltName(ArrayList<String> altName) {
		this.altName = altName;
	}

	/**
	 * @return the altName
	 */
	public ArrayList<String> getAltName() {
		return altName;
	}

}
