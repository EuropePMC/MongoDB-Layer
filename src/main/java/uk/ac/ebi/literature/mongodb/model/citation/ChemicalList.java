package uk.ac.ebi.literature.mongodb.model.citation;

import java.io.Serializable;
import java.util.List;

import uk.ac.ebi.literature.mongodb.util.MongoDBUtility;
 
/**
 * @author jyothi
 * 1 Mar 2011  12:11:05
 */
public class ChemicalList implements Serializable{

	private List<ChemicalInfo> chemical;
	
	public ChemicalList() {
		super();
	}

	/**
	 * @param chemical the chemical to set
	 */
	public void setChemical(List<ChemicalInfo> chemical) {
		this.chemical = chemical;
	}

	/**
	 * @return the chemical
	 */
	public List<ChemicalInfo> getChemical() {
		return chemical;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((chemical == null) ? 0 : chemical.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof ChemicalList))
			return false;
		ChemicalList other = (ChemicalList) obj;
		if (chemical == null) {
			if (other.chemical != null)
				return false;
		} else if (!MongoDBUtility.equalsList(chemical,other.chemical))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ChemicalList [chemical=" + chemical + "]";
	}
	
	

}
