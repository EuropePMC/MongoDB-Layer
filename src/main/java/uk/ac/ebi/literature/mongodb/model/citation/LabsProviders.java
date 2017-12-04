package uk.ac.ebi.literature.mongodb.model.citation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jyothi
 *
 */
public class LabsProviders implements Serializable{

	private List<LabsProvider> provider;
	
	public LabsProviders() {
		super();
		this.provider = new ArrayList<LabsProvider>();
	}

	/**
	 * @return the provider
	 */
	public List<LabsProvider> getProvider() {
		return provider;
	}

	/**
	 * @param provider the provider to set
	 */
	public void setProvider(List<LabsProvider> provider) {
		this.provider = provider;
	}

}
