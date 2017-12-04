package uk.ac.ebi.literature.mongodb.model.citation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import uk.ac.ebi.literature.mongodb.util.MongoDBUtility; 
/**
 * @author jyothi
 * 1 Mar 2011  10:40:43
 */
public class GrantsList implements Serializable{

	private List<GrantInfo> grant;
	
	public GrantsList() {
		super();
		this.grant = new ArrayList<GrantInfo>();
	}
	/**
	 * @param grant the grant to set
	 */
	public void setGrant(List<GrantInfo> grant) {
		this.grant = grant;
	}
	/**
	 * @return the grant
	 */
	public List<GrantInfo> getGrant() {
		return grant;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((grant == null) ? 0 : grant.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof GrantsList))
			return false;
		GrantsList other = (GrantsList) obj;
		if (grant == null) {
			if (other.grant != null)
				return false;
		} else if (!MongoDBUtility.equalsList(grant,other.grant))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "GrantsList [grant=" + grant + "]";
	}

}
