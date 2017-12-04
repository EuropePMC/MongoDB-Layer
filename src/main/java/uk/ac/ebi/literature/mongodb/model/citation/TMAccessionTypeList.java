package uk.ac.ebi.literature.mongodb.model.citation;

import java.io.Serializable;
import java.util.ArrayList;

import uk.ac.ebi.literature.mongodb.util.MongoDBUtility;

/**
 * @author jyothi
 *
 */
public class TMAccessionTypeList implements Serializable{

	private ArrayList<String> accessionType;
	
	public TMAccessionTypeList() {
		super();
		this.setAccessionType(new ArrayList<String>());
	}

	/**
	 * @return the accessionType
	 */
	public ArrayList<String> getAccessionType() {
		return accessionType;
	}

	/**
	 * @param accessionType the accessionType to set
	 */
	public void setAccessionType(ArrayList<String> accessionType) {
		this.accessionType = accessionType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accessionType == null) ? 0 : accessionType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof TMAccessionTypeList))
			return false;
		TMAccessionTypeList other = (TMAccessionTypeList) obj;
		if (accessionType == null) {
			if (other.accessionType != null)
				return false;
		} else if (!MongoDBUtility.equalsList(accessionType,other.accessionType))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TMAccessionTypeList [accessionType=" + accessionType + "]";
	}

}
