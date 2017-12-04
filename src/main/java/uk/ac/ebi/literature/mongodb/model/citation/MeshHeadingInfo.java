package uk.ac.ebi.literature.mongodb.model.citation;

import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * @author jyothi
 * 1 Mar 2011  11:21:55
 */ 
@XmlType (name = "meshHeadingInfo", propOrder = {"majorTopic_YN","descriptorName","meshQualifierList"})
// next line only for rest development
@JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)
public class MeshHeadingInfo implements Serializable{

	private String majorTopic_YN;
	private String descriptorName;
	private MeshQualifierList meshQualifierList;
	
	public MeshHeadingInfo() {
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
	 * @param descriptorName the descriptorName to set
	 */
	public void setDescriptorName(String descriptorName) {
		this.descriptorName = descriptorName;
	}

	/**
	 * @return the descriptorName
	 */
	public String getDescriptorName() {
		return descriptorName;
	}

	/**
	 * @param meshQualifierList the meshQualifierList to set
	 */
	public void setMeshQualifierList(MeshQualifierList meshQualifierList) {
		this.meshQualifierList = meshQualifierList;
	}

	/**
	 * @return the meshQualifierList
	 */
	public MeshQualifierList getMeshQualifierList() {
		return meshQualifierList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descriptorName == null) ? 0 : descriptorName.hashCode());
		result = prime * result + ((majorTopic_YN == null) ? 0 : majorTopic_YN.hashCode());
		result = prime * result + ((meshQualifierList == null) ? 0 : meshQualifierList.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof MeshHeadingInfo))
			return false;
		MeshHeadingInfo other = (MeshHeadingInfo) obj;
		if (descriptorName == null) {
			if (other.descriptorName != null)
				return false;
		} else if (!descriptorName.equals(other.descriptorName))
			return false;
		if (majorTopic_YN == null) {
			if (other.majorTopic_YN != null)
				return false;
		} else if (!majorTopic_YN.equals(other.majorTopic_YN))
			return false;
		if (meshQualifierList == null) {
			if (other.meshQualifierList != null)
				return false;
		} else if (!meshQualifierList.equals(other.meshQualifierList))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MeshHeadingInfo [majorTopic_YN=" + majorTopic_YN + ", descriptorName=" + descriptorName
				+ ", meshQualifierList=" + meshQualifierList + "]";
	}

}
