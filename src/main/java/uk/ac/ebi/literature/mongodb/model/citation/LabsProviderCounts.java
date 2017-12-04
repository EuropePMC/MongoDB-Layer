package uk.ac.ebi.literature.mongodb.model.citation;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * @author jyothi
 * 22 May 2013  10:29:52
 */
@XmlType (name = "labsProviderCounts", propOrder = {"providerName","linksCount"})
@JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)
public class LabsProviderCounts implements Serializable{

	private String providerName;
	private Integer linksCount;
	
	public LabsProviderCounts() {
		super();
	}

	/**
	 * @return the providerName
	 */
	public String getProviderName() {
		return providerName;
	}

	/**
	 * @param providerName the providerName to set
	 */
	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	/**
	 * @return the linksCount
	 */
	public Integer getLinksCount() {
		return linksCount;
	}

	/**
	 * @param linksCount the linksCount to set
	 */
	public void setLinksCount(Integer linksCount) {
		this.linksCount = linksCount;
	}

	
}
