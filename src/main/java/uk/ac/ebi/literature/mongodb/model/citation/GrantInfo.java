package uk.ac.ebi.literature.mongodb.model.citation;

import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import org.codehaus.jackson.map.annotate.JsonSerialize;
/**
 * @author jyothi
 * 1 Mar 2011  10:41:14
 */
@XmlType (name = "grantInfo", propOrder = {"grantId","agency","acronym","orderIn"})
// next line only for rest development
@JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)
public class GrantInfo implements Serializable{

	private String agency;
    private String acronym;
    private String grantId;
    private short orderIn;
    
	public GrantInfo() {
		super();
	}

	/**
	 * @param agency the agency to set
	 */
	public void setAgency(String agency) {
		this.agency = agency;
	}

	/**
	 * @return the agency
	 */
	public String getAgency() {
		return agency;
	}

	/**
	 * @param acronym the acronym to set
	 */
	public void setAcronym(String acronym) {
		this.acronym = acronym;
	}

	/**
	 * @return the acronym
	 */
	public String getAcronym() {
		return acronym;
	}

	/**
	 * @param grantId the grantId to set
	 */
	public void setGrantId(String grantId) {
		this.grantId = grantId;
	}

	/**
	 * @return the grantId
	 */
	public String getGrantId() {
		return grantId;
	}

	/**
	 * @param orderIn the orderIn to set
	 */
	public void setOrderIn(short orderIn) {
		this.orderIn = orderIn;
	}

	/**
	 * @return the orderIn
	 */
	public short getOrderIn() {
		return orderIn;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((acronym == null) ? 0 : acronym.hashCode());
		result = prime * result + ((agency == null) ? 0 : agency.hashCode());
		result = prime * result + ((grantId == null) ? 0 : grantId.hashCode());
		result = prime * result + orderIn;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof GrantInfo))
			return false;
		GrantInfo other = (GrantInfo) obj;
		if (acronym == null) {
			if (other.acronym != null)
				return false;
		} else if (!acronym.equals(other.acronym))
			return false;
		if (agency == null) {
			if (other.agency != null)
				return false;
		} else if (!agency.equals(other.agency))
			return false;
		if (grantId == null) {
			if (other.grantId != null)
				return false;
		} else if (!grantId.equals(other.grantId))
			return false;
		if (orderIn != other.orderIn)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "GrantInfo [agency=" + agency + ", acronym=" + acronym + ", grantId=" + grantId + ", orderIn=" + orderIn
				+ "]";
	}

}
