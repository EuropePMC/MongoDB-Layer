package uk.ac.ebi.literature.mongodb.model.citation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jyothi
 * 31 May 2012  15:47:25
 */
public class SemanticTypeCounts implements Serializable{
	
	private List<SemanticCounts> semanticType;
	
	public SemanticTypeCounts() {
		super();
		this.setSemanticType(new ArrayList<SemanticCounts>());
	}

	/**
	 * @param semanticType the semanticType to set
	 */
	public void setSemanticType(List<SemanticCounts> semanticType) {
		this.semanticType = semanticType;
	}

	/**
	 * @return the semanticType
	 */
	public List<SemanticCounts> getSemanticType() {
		return semanticType;
	}

}
