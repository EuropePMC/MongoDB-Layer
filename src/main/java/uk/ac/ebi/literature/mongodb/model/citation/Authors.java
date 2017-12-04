package uk.ac.ebi.literature.mongodb.model.citation;

import javax.xml.bind.annotation.XmlType;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import java.io.Serializable;

/**
 * @author jyothi
 * 25 Feb 2011  14:00:16
 */
@XmlType (name = "authors", propOrder = {"collectiveName","fullName","firstName","lastName","initials","authorId","affiliation"})
// next line only for rest development
@JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)
public class Authors implements Serializable{
	private String fullName;
    private String lastName;
    private String firstName;
    private String initials;
    private String collectiveName;
    private AuthorId authorId;
    private String affiliation;

    public Authors() {
		super();
	}

	/**
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}
	
	/**
	 * @param fullName the fullName to set
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the initials
	 */
	public String getInitials() {
		return initials;
	}

	/**
	 * @param initials the initials to set
	 */
	public void setInitials(String initials) {
		this.initials = initials;
	}

	/**
	 * @param collectiveName the collectiveName to set
	 */
	public void setCollectiveName(String collectiveName) {
		this.collectiveName = collectiveName;
	}

	/**
	 * @return the collectiveName
	 */
	public String getCollectiveName() {
		return collectiveName;
	}

	public AuthorId getAuthorId() {
		return authorId;
	}

	public void setAuthorId(AuthorId authorId) {
		this.authorId = authorId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the affiliation
	 */
	public String getAffiliation() {
		return affiliation;
	}

	/**
	 * @param affiliation the affiliation to set
	 */
	public void setAffiliation(String affiliation) {
		this.affiliation = affiliation;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((affiliation == null) ? 0 : affiliation.hashCode());
		result = prime * result + ((authorId == null) ? 0 : authorId.hashCode());
		result = prime * result + ((collectiveName == null) ? 0 : collectiveName.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((fullName == null) ? 0 : fullName.hashCode());
		result = prime * result + ((initials == null) ? 0 : initials.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Authors))
			return false;
		Authors other = (Authors) obj;
		if (affiliation == null) {
			if (other.affiliation != null)
				return false;
		} else if (!affiliation.equals(other.affiliation))
			return false;
		if (authorId == null) {
			if (other.authorId != null)
				return false;
		} else if (!authorId.equals(other.authorId))
			return false;
		if (collectiveName == null) {
			if (other.collectiveName != null)
				return false;
		} else if (!collectiveName.equals(other.collectiveName))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (fullName == null) {
			if (other.fullName != null)
				return false;
		} else if (!fullName.equals(other.fullName))
			return false;
		if (initials == null) {
			if (other.initials != null)
				return false;
		} else if (!initials.equals(other.initials))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Authors [fullName=" + fullName + ", lastName=" + lastName + ", firstName=" + firstName + ", initials="
				+ initials + ", collectiveName=" + collectiveName + ", authorId=" + authorId + ", affiliation="
				+ affiliation + "]";
	}

	
	
    }