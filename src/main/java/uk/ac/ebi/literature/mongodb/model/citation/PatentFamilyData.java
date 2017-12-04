package uk.ac.ebi.literature.mongodb.model.citation;

import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import org.codehaus.jackson.map.annotate.JsonSerialize;
 
/**
 * @author jyothi
 * 28 Feb 2011  15:41:01
 */
@XmlType (name = "patentFamilyData", propOrder = {"familyNumber","orderIn"})
// next line only for rest development
@JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)
public class PatentFamilyData implements Serializable{

	private String familyNumber;
	private Short orderIn;
	
	public PatentFamilyData() {
		super();
	}

	/**
	 * @param familyNumber the familyNumber to set
	 */
	public void setFamilyNumber(String familyNumber) {
		this.familyNumber = familyNumber;
	}

	/**
	 * @return the familyNumber
	 */
	public String getFamilyNumber() {
		return familyNumber;
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
		result = prime * result + ((familyNumber == null) ? 0 : familyNumber.hashCode());
		result = prime * result + ((orderIn == null) ? 0 : orderIn.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof PatentFamilyData))
			return false;
		PatentFamilyData other = (PatentFamilyData) obj;
		if (familyNumber == null) {
			if (other.familyNumber != null)
				return false;
		} else if (!familyNumber.equals(other.familyNumber))
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
		return "PatentFamilyData [familyNumber=" + familyNumber + ", orderIn=" + orderIn + "]";
	}

	
}
