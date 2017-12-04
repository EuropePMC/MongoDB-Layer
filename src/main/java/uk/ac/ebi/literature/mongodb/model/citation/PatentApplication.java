package uk.ac.ebi.literature.mongodb.model.citation;

import javax.xml.bind.annotation.XmlType;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import java.io.Serializable;
 
/**
 * @author jyothi
 * 1 Mar 2011  10:11:34
 */
@XmlType (name = "patentApplication", propOrder = {"applicationNumber","applicationDate","orderIn"})
// next line only for rest development
@JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)
public class PatentApplication implements Serializable{

	private String applicationNumber;
	private String applicationDate;
	private Short orderIn;
	
	public PatentApplication() {
		super();
	}

	/**
	 * @param applicationNumber the applicationNumber to set
	 */
	public void setApplicationNumber(String applicationNumber) {
		this.applicationNumber = applicationNumber;
	}

	/**
	 * @return the applicationNumber
	 */
	public String getApplicationNumber() {
		return applicationNumber;
	}

	/**
	 * @param applicationDate the applicationDate to set
	 */
	public void setApplicationDate(String applicationDate) {
		this.applicationDate = applicationDate;
	}

	/**
	 * @return the applicationDate
	 */
	public String getApplicationDate() {
		return applicationDate;
	}

	/**
	 * @param orderIn the orderIn to set
	 */
	public void setOrderIn(Short orderIn) {
		this.orderIn = orderIn;
	}

	/**
	 * @return the orderIn
	 */
	public Short getOrderIn() {
		return orderIn;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((applicationDate == null) ? 0 : applicationDate.hashCode());
		result = prime * result + ((applicationNumber == null) ? 0 : applicationNumber.hashCode());
		result = prime * result + ((orderIn == null) ? 0 : orderIn.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof PatentApplication))
			return false;
		PatentApplication other = (PatentApplication) obj;
		if (applicationDate == null) {
			if (other.applicationDate != null)
				return false;
		} else if (!applicationDate.equals(other.applicationDate))
			return false;
		if (applicationNumber == null) {
			if (other.applicationNumber != null)
				return false;
		} else if (!applicationNumber.equals(other.applicationNumber))
			return false;
		if (orderIn == null) {
			if (other.orderIn != null)
				return false;
		} else if (!orderIn.equals(other.orderIn))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PatentApplication [applicationNumber=" + applicationNumber + ", applicationDate=" + applicationDate
				+ ", orderIn=" + orderIn + "]";
	}

	
}
