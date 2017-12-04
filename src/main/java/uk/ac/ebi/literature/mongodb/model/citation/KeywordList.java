package uk.ac.ebi.literature.mongodb.model.citation;
 
import java.io.Serializable;
import java.util.ArrayList;

import uk.ac.ebi.literature.mongodb.util.MongoDBUtility;

/**
 * @author jyothi
 * 1 Mar 2011  12:00:33
 */
public class KeywordList implements Serializable{

	private ArrayList<String> keyword;
	
	public KeywordList() {
		super();
		this.keyword = new ArrayList<String>();
	}

	/**
	 * @param keyword the keyword to set
	 */
	public void setKeyword(ArrayList<String> keyword) {
		this.keyword = keyword;
	}

	/**
	 * @return the keyword
	 */
	public ArrayList<String> getKeyword() {
		return keyword;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((keyword == null) ? 0 : keyword.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof KeywordList))
			return false;
		KeywordList other = (KeywordList) obj;
		if (keyword == null) {
			if (other.keyword != null)
				return false;
		} else if (!MongoDBUtility.equalsList(keyword, other.keyword))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "KeywordList [keyword=" + keyword + "]";
	}
	
	

}
