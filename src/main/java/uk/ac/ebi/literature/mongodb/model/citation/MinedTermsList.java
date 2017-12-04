package uk.ac.ebi.literature.mongodb.model.citation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
 
/**
 * @author jyothi
 * 7 Mar 2011  11:09:40
 */
public class MinedTermsList implements Serializable{

	private List<MinedTerms> semanticType; 
	
	public MinedTermsList() {
		super();
		this.semanticType = new ArrayList<MinedTerms>();
	}

	/**
	 * @param semanticType the semanticType to set
	 */
	public void setSemanticType(List<MinedTerms> semanticType) {
		this.semanticType = semanticType;
	}

	/**
	 * @return the semanticType
	 */
	public List<MinedTerms> getSemanticType() {
		return semanticType;
	}

}
