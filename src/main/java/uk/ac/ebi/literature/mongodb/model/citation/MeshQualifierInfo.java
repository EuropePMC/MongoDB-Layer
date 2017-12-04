package uk.ac.ebi.literature.mongodb.model.citation;

import javax.xml.bind.annotation.XmlType;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import java.io.Serializable;
 
/**
 * @author jyothi
 * 1 Mar 2011  11:26:25
 */
@XmlType (name = "meshQualifierInfo", propOrder = {"abbreviation","qualifierName","majorTopic_YN"})
// next line only for rest development
@JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)
public class MeshQualifierInfo implements Serializable{
	
	private String majorTopic_YN;
	private String abbreviation;
	private String qualifierName;
	
	public MeshQualifierInfo() {
		super();
	}

	/**
	 * @param majorTopic_YN the majorTopic_YN to set
	 */
	public void setMajorTopic_YN(String majorTopic_YN) {
		this.majorTopic_YN = majorTopic_YN;
	}

	/**
	 * @return the majorTopic_YN
	 */
	public String getMajorTopic_YN() {
		return majorTopic_YN;
	}

	/**
	 * @param abbreviation the abbreviation to set
	 */
	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	/**
	 * @return the abbreviation
	 */
	public String getAbbreviation() {
		return abbreviation;
	}

	/**
	 * @param qualifierName the qualifierName to set
	 */
	public void setQualifierName(String qualifierName) {
		this.qualifierName = qualifierName;
	}

	/**
	 * @return the qualifierName
	 */
	public String getQualifierName() {
		return qualifierName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((abbreviation == null) ? 0 : abbreviation.hashCode());
		result = prime * result + ((majorTopic_YN == null) ? 0 : majorTopic_YN.hashCode());
		result = prime * result + ((qualifierName == null) ? 0 : qualifierName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof MeshQualifierInfo))
			return false;
		MeshQualifierInfo other = (MeshQualifierInfo) obj;
		if (abbreviation == null) {
			if (other.abbreviation != null)
				return false;
		} else if (!abbreviation.equals(other.abbreviation))
			return false;
		if (majorTopic_YN == null) {
			if (other.majorTopic_YN != null)
				return false;
		} else if (!majorTopic_YN.equals(other.majorTopic_YN))
			return false;
		if (qualifierName == null) {
			if (other.qualifierName != null)
				return false;
		} else if (!qualifierName.equals(other.qualifierName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MeshQualifierInfo [majorTopic_YN=" + majorTopic_YN + ", abbreviation=" + abbreviation
				+ ", qualifierName=" + qualifierName + "]";
	}

}
