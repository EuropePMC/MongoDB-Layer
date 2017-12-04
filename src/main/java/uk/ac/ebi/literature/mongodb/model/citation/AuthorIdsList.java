package uk.ac.ebi.literature.mongodb.model.citation;

import java.io.Serializable;
import java.util.ArrayList;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import uk.ac.ebi.literature.mongodb.util.MongoDBUtility;

/**
 * @author jyothi
 *
 */
@JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)
public class AuthorIdsList implements Serializable{

	
	private ArrayList<AuthorId> authorId;
	
	public AuthorIdsList() {
		super();
		this.setAuthorId(new ArrayList<AuthorId>());
	}

	public ArrayList<AuthorId> getAuthorId() {
		return authorId;
	}

	public void setAuthorId(ArrayList<AuthorId> authorId) {
		this.authorId = authorId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((authorId == null) ? 0 : authorId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof AuthorIdsList))
			return false;
		AuthorIdsList other = (AuthorIdsList) obj;
		if (authorId == null) {
			if (other.authorId != null)
				return false;
		} else if (!MongoDBUtility.equalsList(authorId,other.authorId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AuthorIdsList [authorId=" + authorId + "]";
	}
	
	
}
