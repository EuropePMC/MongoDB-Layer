package uk.ac.ebi.literature.mongodb.model.citation;
 
import java.io.Serializable;
import java.util.ArrayList;

import uk.ac.ebi.literature.mongodb.util.MongoDBUtility;

/**
 * @author jyothi
 * 25 Feb 2011  15:43:57
 */
public class PubTypeList implements Serializable{

	private ArrayList<String> pubType;
	
	public PubTypeList() {
		super();
		this.setPubType(new ArrayList<String>());
	}

	/**
	 * @param pubType the pubType to set
	 */
	public void setPubType(ArrayList<String> pubType) {
		this.pubType = pubType;
	}

	/**
	 * @return the pubType
	 */
	public ArrayList<String> getPubType() {
		return pubType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pubType == null) ? 0 : pubType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof PubTypeList))
			return false;
		PubTypeList other = (PubTypeList) obj;
		if (pubType == null) {
			if (other.pubType != null)
				return false;
		} else if (!MongoDBUtility.equalsList(pubType,other.pubType))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PubTypeList [pubType=" + pubType + "]";
	}
	
	

}
