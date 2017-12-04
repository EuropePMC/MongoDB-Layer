package uk.ac.ebi.literature.mongodb.model.citation;

import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * @author jyothi
 * 28 Feb 2011  15:38:29
 */
@XmlType (name = "patentPriorityData", propOrder = {"priorityNumber","priorityDate","orderIn"})
// next line only for rest development
@JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)
public class PatentPriorityData implements Serializable{

	private String priorityNumber;
	private Short orderIn;
	private String priorityDate;
	
	public PatentPriorityData() {
		super();
	}

	/**
	 * @param priorityNumber the priorityNumber to set
	 */
	public void setPriorityNumber(String priorityNumber) {
		this.priorityNumber = priorityNumber;
	}

	/**
	 * @return the priorityNumber
	 */
	public String getPriorityNumber() {
		return priorityNumber;
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

	/**
	 * @param priorityDate the priorityDate to set
	 */
	public void setPriorityDate(String priorityDate) {
		this.priorityDate = priorityDate;
	}

	/**
	 * @return the priorityDate
	 */
	public String getPriorityDate() {
		return priorityDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderIn == null) ? 0 : orderIn.hashCode());
		result = prime * result + ((priorityDate == null) ? 0 : priorityDate.hashCode());
		result = prime * result + ((priorityNumber == null) ? 0 : priorityNumber.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof PatentPriorityData))
			return false;
		PatentPriorityData other = (PatentPriorityData) obj;
		if (orderIn == null) {
			if (other.orderIn != null)
				return false;
		} else if (!orderIn.equals(other.orderIn))
			return false;
		if (priorityDate == null) {
			if (other.priorityDate != null)
				return false;
		} else if (!priorityDate.equals(other.priorityDate))
			return false;
		if (priorityNumber == null) {
			if (other.priorityNumber != null)
				return false;
		} else if (!priorityNumber.equals(other.priorityNumber))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PatentPriorityData [priorityNumber=" + priorityNumber + ", orderIn=" + orderIn + ", priorityDate="
				+ priorityDate + "]";
	}

}
