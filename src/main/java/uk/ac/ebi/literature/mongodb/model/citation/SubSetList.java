package uk.ac.ebi.literature.mongodb.model.citation;

import java.io.Serializable;
import java.util.List;

import uk.ac.ebi.literature.mongodb.util.MongoDBUtility;

 
/**
 * @author jyothi
 * 25 Feb 2011  16:15:17
 */
public class SubSetList implements Serializable{

	private List<SubSet> subset;
	
	public SubSetList() {
		super();
	}

	/**
	 * @param subset the subset to set
	 */
	public void setSubset(List<SubSet> subset) {
		this.subset = subset;
	}

	/**
	 * @return the subset
	 */
	public List<SubSet> getSubset() {
		return subset;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((subset == null) ? 0 : subset.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof SubSetList))
			return false;
		SubSetList other = (SubSetList) obj;
		if (subset == null) {
			if (other.subset != null)
				return false;
		} else if (!MongoDBUtility.equalsList(subset,other.subset))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SubSetList [subset=" + subset + "]";
	}
	
	

}
