package uk.ac.ebi.literature.mongodb.model.citation;

import java.io.Serializable;
 
/**
 * @author jyothi
 * 1 Mar 2011  12:12:04
 */
public class ChemicalInfo implements Serializable{

	 private String name;
	 private String registryNumber;
	 
	public ChemicalInfo() {
		super();
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param registryNumber the registryNumber to set
	 */
	public void setRegistryNumber(String registryNumber) {
		this.registryNumber = registryNumber;
	}

	/**
	 * @return the registryNumber
	 */
	public String getRegistryNumber() {
		return registryNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((registryNumber == null) ? 0 : registryNumber.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof ChemicalInfo))
			return false;
		ChemicalInfo other = (ChemicalInfo) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (registryNumber == null) {
			if (other.registryNumber != null)
				return false;
		} else if (!registryNumber.equals(other.registryNumber))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ChemicalInfo [name=" + name + ", registryNumber=" + registryNumber + "]";
	}

	
}
