package uk.ac.ebi.literature.mongodb.model.citation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import uk.ac.ebi.literature.mongodb.util.MongoDBUtility;

/**
 * @author jyothi
 *
 */
public class InvestigatorList implements Serializable{

	
	private List<Authors> investigator ;
	public InvestigatorList() {
		super();
		this.setInvestigator(new ArrayList<Authors>());
	}
	/**
	 * @return the investigator
	 */
	public List<Authors> getInvestigator() {
		return investigator;
	}
	/**
	 * @param investigator the investigator to set
	 */
	public void setInvestigator(List<Authors> investigator) {
		this.investigator = investigator;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((investigator == null) ? 0 : investigator.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof InvestigatorList))
			return false;
		InvestigatorList other = (InvestigatorList) obj;
		if (investigator == null) {
			if (other.investigator != null)
				return false;
		} else if (!MongoDBUtility.equalsList(investigator,other.investigator))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "InvestigatorList [investigator=" + investigator + "]";
	}
	
	

}
