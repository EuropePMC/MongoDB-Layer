package uk.ac.ebi.literature.mongodb.model.citation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import uk.ac.ebi.literature.mongodb.util.MongoDBUtility; 

/**
 * @author jyothi
 * 28 Feb 2011  15:31:23
 */
public class PatentPriorityList implements Serializable{

	
	private List<PatentPriorityData> priority;
	public PatentPriorityList() {
		super();
		this.priority = new ArrayList<PatentPriorityData>();
	}
	/**
	 * @param priority the priority to set
	 */
	public void setPriority(List<PatentPriorityData> priority) {
		this.priority = priority;
	}
	/**
	 * @return the priority
	 */
	public List<PatentPriorityData> getPriority() {
		return priority;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((priority == null) ? 0 : priority.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof PatentPriorityList))
			return false;
		PatentPriorityList other = (PatentPriorityList) obj;
		if (priority == null) {
			if (other.priority != null)
				return false;
		} else if (!MongoDBUtility.equalsList(priority,other.priority))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "PatentPriorityList [priority=" + priority + "]";
	}
	
	

}
