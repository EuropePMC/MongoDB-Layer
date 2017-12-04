package uk.ac.ebi.literature.mongodb.model.citation;

import java.io.Serializable;

/**
 * @author jyothi
 * 15 May 2012  09:51:15
 */
public class SubSet implements Serializable{

	private String code;
	private String name;

   public SubSet() {
      super();
   }

   /**
   * Returns the code (id) for the sub set
   * @return code
   */
   public String getCode() {
      return this.code;
   }
   
   /**
   * Returns the actual value for the subsetList
   * @return name/value
   */
   public String getName() {
      return this.name;
   }
   
   /**
   * Sets the code
   * @param code 
   */
   public void setCode(String code) {
      this.code = code;
   }
   
   /**
   * Sets the name/value
   * @param name 
   */
   public void setName(String name) {

      this.name = name;
   }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof SubSet))
			return false;
		SubSet other = (SubSet) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SubSet [code=" + code + ", name=" + name + "]";
	}

}
