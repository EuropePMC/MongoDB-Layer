package uk.ac.ebi.literature.mongodb.model.citation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
 
/**
 * @author jyothi
 * 1 Mar 2011  16:32:21
 */
public class ReferencesList implements Serializable{

	private List<ReferenceInfo> reference; 
	public ReferencesList() {
		super();
		this.reference = new ArrayList<ReferenceInfo>();
	}
	/**
	 * @param reference the reference to set
	 */
	public void setReference(List<ReferenceInfo> reference) {
		this.reference = reference;
	}
	/**
	 * @return the reference
	 */
	public List<ReferenceInfo> getReference() {
		return reference;
	}

}
