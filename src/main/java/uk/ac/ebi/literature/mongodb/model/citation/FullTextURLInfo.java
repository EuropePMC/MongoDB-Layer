package uk.ac.ebi.literature.mongodb.model.citation;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlType;

import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * @author jyothi
 * 1 Mar 2011  15:21:19
 */

@XmlType (name = "fullTextURLInfo", propOrder = {"availability","availabilityCode","documentStyle","site","url"})
// next line only for rest development
@JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)
public class FullTextURLInfo implements Serializable{

	private String availability;
    private String availabilityCode;
    private String documentStyle;
    private String site;
    private String url;
        
	public FullTextURLInfo() {
		super();
	}

	/**
	 * @param availability the availability to set
	 */
	public void setAvailability(String availability) {
		this.availability = availability;
	}

	/**
	 * @return the availability
	 */
	public String getAvailability() {
		return availability;
	}

	/**
	 * @param availabilityCode the availabilityCode to set
	 */
	public void setAvailabilityCode(String availabilityCode) {
		this.availabilityCode = availabilityCode;
	}

	/**
	 * @return the availabilityCode
	 */
	public String getAvailabilityCode() {
		return availabilityCode;
	}

	/**
	 * @param documentStyle the documentStyle to set
	 */
	public void setDocumentStyle(String documentStyle) {
		this.documentStyle = documentStyle;
	}

	/**
	 * @return the documentStyle
	 */
	public String getDocumentStyle() {
		return documentStyle;
	}

	/**
	 * @param site the site to set
	 */
	public void setSite(String site) {
		this.site = site;
	}

	/**
	 * @return the site
	 */
	public String getSite() {
		return site;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((availability == null) ? 0 : availability.hashCode());
		result = prime * result + ((availabilityCode == null) ? 0 : availabilityCode.hashCode());
		result = prime * result + ((documentStyle == null) ? 0 : documentStyle.hashCode());
		result = prime * result + ((site == null) ? 0 : site.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof FullTextURLInfo))
			return false;
		FullTextURLInfo other = (FullTextURLInfo) obj;
		if (availability == null) {
			if (other.availability != null)
				return false;
		} else if (!availability.equals(other.availability))
			return false;
		if (availabilityCode == null) {
			if (other.availabilityCode != null)
				return false;
		} else if (!availabilityCode.equals(other.availabilityCode))
			return false;
		if (documentStyle == null) {
			if (other.documentStyle != null)
				return false;
		} else if (!documentStyle.equals(other.documentStyle))
			return false;
		if (site == null) {
			if (other.site != null)
				return false;
		} else if (!site.equals(other.site))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FullTextURLInfo [availability=" + availability + ", availabilityCode=" + availabilityCode
				+ ", documentStyle=" + documentStyle + ", site=" + site + ", url=" + url + "]";
	}

}
