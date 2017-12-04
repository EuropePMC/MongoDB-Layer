package uk.ac.ebi.literature.mongodb.model.citation;
 
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import uk.ac.ebi.literature.mongodb.util.MongoDBUtility;

/**
 * @author jyothi
 * 28 Feb 2011  15:39:30
 */
public class PatentFamilyList implements Serializable{

	private List<PatentFamilyData> family;
	public PatentFamilyList() {
		super();
		this.family = new ArrayList<PatentFamilyData>();
	}
	/**
	 * @param familyList the familyList to set
	 */
	public void setFamily(List<PatentFamilyData> family) {
		this.family = family;
	}
	/**
	 * @return the familyList
	 */
	public List<PatentFamilyData> getFamily() {
		return family;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((family == null) ? 0 : family.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof PatentFamilyList))
			return false;
		PatentFamilyList other = (PatentFamilyList) obj;
		if (family == null) {
			if (other.family != null)
				return false;
		} else if (!MongoDBUtility.equalsList(family,other.family))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "PatentFamilyList [family=" + family + "]";
	}

}
