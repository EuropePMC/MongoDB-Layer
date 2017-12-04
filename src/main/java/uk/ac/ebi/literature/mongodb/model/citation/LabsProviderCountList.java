package uk.ac.ebi.literature.mongodb.model.citation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jyothi
 * 22 May 2013  10:27:31
 */
public class LabsProviderCountList implements Serializable{

private List<LabsProviderCounts> provider;
	
	public LabsProviderCountList() {
		super();
		this.setProvider(new ArrayList<LabsProviderCounts>());
	}

	/**
	 * @return the provider
	 */
	public List<LabsProviderCounts> getProvider() {
		return provider;
	}

	/**
	 * @param provider the provider to set
	 */
	public void setProvider(List<LabsProviderCounts> provider) {
		this.provider = provider;
	}

}
