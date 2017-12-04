package uk.ac.ebi.literature.mongodb.model.citation;

import java.io.Serializable;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/** 
 * @author jyothi
 * 28 Feb 2011  15:27:11
 */
// next line only for rest development
@JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)
public class PatentClassifierInfo implements Serializable{

	private String classification;
	private String classificationType;
	private String hyperlink;
	
	public PatentClassifierInfo() {
		super();
	}

	/**
	 * @param classification the classification to set
	 */
	public void setClassification(String classification) {
		this.classification = classification;
	}

	/**
	 * @return the classification
	 */
	public String getClassification() {
		return classification;
	}

	/**
	 * @param classificationType the classificationType to set
	 */
	public void setClassificationType(String classificationType) {
		this.classificationType = classificationType;
	}

	/**
	 * @return the classificationType
	 */
	public String getClassificationType() {
		return classificationType;
	}

	/**
	 * @param hyperlink the hyperlink to set
	 */
	public void setHyperlink(String hyperlink) {
		this.hyperlink = hyperlink;
	}

	/**
	 * @return the hyperlink
	 */
	public String getHyperlink() {
		return hyperlink;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((classification == null) ? 0 : classification.hashCode());
		result = prime * result + ((classificationType == null) ? 0 : classificationType.hashCode());
		result = prime * result + ((hyperlink == null) ? 0 : hyperlink.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof PatentClassifierInfo))
			return false;
		PatentClassifierInfo other = (PatentClassifierInfo) obj;
		if (classification == null) {
			if (other.classification != null)
				return false;
		} else if (!classification.equals(other.classification))
			return false;
		if (classificationType == null) {
			if (other.classificationType != null)
				return false;
		} else if (!classificationType.equals(other.classificationType))
			return false;
		if (hyperlink == null) {
			if (other.hyperlink != null)
				return false;
		} else if (!hyperlink.equals(other.hyperlink))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PatentClassifierInfo [classification=" + classification + ", classificationType=" + classificationType
				+ ", hyperlink=" + hyperlink + "]";
	}
	
	

}
