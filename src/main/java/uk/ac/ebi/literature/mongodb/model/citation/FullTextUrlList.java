package uk.ac.ebi.literature.mongodb.model.citation;
 
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import uk.ac.ebi.literature.mongodb.util.MongoDBUtility;

/**
 * @author jyothi
 * 1 Mar 2011  15:20:18
 */
public class FullTextUrlList implements Serializable{

	 private List<FullTextURLInfo> fullTextUrl;
	 
	public FullTextUrlList() {
		super();
		this.fullTextUrl = new ArrayList<FullTextURLInfo>();
	}

	/**
	 * @param fullTextUrl the fullTextUrl to set
	 */
	public void setFullTextUrl(List<FullTextURLInfo> fullTextUrl) {
		this.fullTextUrl = fullTextUrl;
	}

	/**
	 * @return the fullTextUrl
	 */
	public List<FullTextURLInfo> getFullTextUrl() {
		return fullTextUrl;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fullTextUrl == null) ? 0 : fullTextUrl.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof FullTextUrlList))
			return false;
		FullTextUrlList other = (FullTextUrlList) obj;
		if (fullTextUrl == null) {
			if (other.fullTextUrl != null)
				return false;
		} else if (!MongoDBUtility.equalsList(fullTextUrl,other.fullTextUrl))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FullTextUrlList [fullTextUrl=" + fullTextUrl + "]";
	}

}
