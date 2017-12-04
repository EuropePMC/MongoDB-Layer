package uk.ac.ebi.literature.mongodb.model.citation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import uk.ac.ebi.literature.mongodb.util.MongoDBUtility;

/**
 * @author jyothi
 * 25 Feb 2011  13:51:18
 */
public class AuthorsList implements Serializable{

	
	private List<Authors> author;
	public AuthorsList() {
		super();
		this.author = new ArrayList<Authors>();
	}
	/**
	 * @param author the author to set
	 */
	public void setAuthor(List<Authors> author) {
		this.author = author;
	}
	/**
	 * @return the author
	 */
	public List<Authors> getAuthor() {
		return author;
	}
	
	@Override
	public String toString() {
		return "AuthorsList [author=" + author + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof AuthorsList))
			return false;
		AuthorsList other = (AuthorsList) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!MongoDBUtility.equalsList(author,other.author))
			return false;
		return true;
	}

	
}
