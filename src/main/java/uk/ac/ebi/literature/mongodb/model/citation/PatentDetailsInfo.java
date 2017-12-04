package uk.ac.ebi.literature.mongodb.model.citation;

import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/** 
 * @author jyothi
 * 28 Feb 2011  15:19:38
 */
@XmlType (name = "patentDetailsInfo", propOrder = {"countryCode","country","typeCode","typeDescription","classifierList","application","priorityList","familyList"})
// next line only for rest development
@JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)
public class PatentDetailsInfo implements Serializable{

	private String typeCode;
	private String typeDescription;
	private String countryCode;
	private String country;
	private PatentClassifierList classifierList;
	private PatentApplication application;
	private PatentPriorityList priorityList;
	private PatentFamilyList familyList;
	
	public PatentDetailsInfo() {
		super();
	}

	/**
	 * @param typeCode the typeCode to set
	 */
	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	/**
	 * @return the typeCode
	 */
	public String getTypeCode() {
		return typeCode;
	}

	/**
	 * @param typeDescription the typeDescription to set
	 */
	public void setTypeDescription(String typeDescription) {
		this.typeDescription = typeDescription;
	}

	/**
	 * @return the typeDescription
	 */
	public String getTypeDescription() {
		return typeDescription;
	}

	/**
	 * @param countryCode the countryCode to set
	 */
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	/**
	 * @return the countryCode
	 */
	public String getCountryCode() {
		return countryCode;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param classifierList the classifierList to set
	 */
	public void setClassifierList(PatentClassifierList classifierList) {
		this.classifierList = classifierList;
	}

	/**
	 * @return the classifierList
	 */
	public PatentClassifierList getClassifierList() {
		return classifierList;
	}

	/**
	 * @param priorityList the priorityList to set
	 */
	public void setPriorityList(PatentPriorityList priorityList) {
		this.priorityList = priorityList;
	}

	/**
	 * @return the priorityList
	 */
	public PatentPriorityList getPriorityList() {
		return priorityList;
	}

	

	/**
	 * @param familyList the familyList to set
	 */
	public void setFamilyList(PatentFamilyList familyList) {
		this.familyList = familyList;
	}

	/**
	 * @return the familyList
	 */
	public PatentFamilyList getFamilyList() {
		return familyList;
	}

	/**
	 * @param application the application to set
	 */
	public void setApplication(PatentApplication application) {
		this.application = application;
	}

	/**
	 * @return the application
	 */
	public PatentApplication getApplication() {
		return application;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((application == null) ? 0 : application.hashCode());
		result = prime * result + ((classifierList == null) ? 0 : classifierList.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((countryCode == null) ? 0 : countryCode.hashCode());
		result = prime * result + ((familyList == null) ? 0 : familyList.hashCode());
		result = prime * result + ((priorityList == null) ? 0 : priorityList.hashCode());
		result = prime * result + ((typeCode == null) ? 0 : typeCode.hashCode());
		result = prime * result + ((typeDescription == null) ? 0 : typeDescription.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof PatentDetailsInfo))
			return false;
		PatentDetailsInfo other = (PatentDetailsInfo) obj;
		if (application == null) {
			if (other.application != null)
				return false;
		} else if (!application.equals(other.application))
			return false;
		if (classifierList == null) {
			if (other.classifierList != null)
				return false;
		} else if (!classifierList.equals(other.classifierList))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (countryCode == null) {
			if (other.countryCode != null)
				return false;
		} else if (!countryCode.equals(other.countryCode))
			return false;
		if (familyList == null) {
			if (other.familyList != null)
				return false;
		} else if (!familyList.equals(other.familyList))
			return false;
		if (priorityList == null) {
			if (other.priorityList != null)
				return false;
		} else if (!priorityList.equals(other.priorityList))
			return false;
		if (typeCode == null) {
			if (other.typeCode != null)
				return false;
		} else if (!typeCode.equals(other.typeCode))
			return false;
		if (typeDescription == null) {
			if (other.typeDescription != null)
				return false;
		} else if (!typeDescription.equals(other.typeDescription))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PatentDetailsInfo [typeCode=" + typeCode + ", typeDescription=" + typeDescription + ", countryCode="
				+ countryCode + ", country=" + country + ", classifierList=" + classifierList + ", application="
				+ application + ", priorityList=" + priorityList + ", familyList=" + familyList + "]";
	}

	
}
