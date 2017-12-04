package uk.ac.ebi.literature.mongodb.model.annotations.sciliteapi;

public enum AnnotationProviderApi {

	EUROPEPMC("europepmc","europepmc"), 
	GENERIF("geneRif","geneRif"), 
	OPEN_TARGET("OpenTargets","openTargets"), 
	NACTEM("nactem","nactem"), 
	NCBI("PubTator","pubtator"), 
	INTACT("IntAct","intact"), 
	DISGENET("DisGeNET","disgenet"),
	GRECO("FNL","fnl"),
	UNKNOWN("UNKNOWN","");
	
	private String label;
	private String linkBackPrefix;
	
	private AnnotationProviderApi(String label, String linkbackPrefix){
		this.label = label;
		this.linkBackPrefix=linkbackPrefix;
	}

	public String getLabel() {
		return this.label;
	}
	
	public String getLinkBackPrefix() {
		return this.linkBackPrefix;
	}
	
	public static AnnotationProviderApi getProviderType (String provider){
		for (AnnotationProviderApi val : AnnotationProviderApi.values()){
			if (val.getLabel().equalsIgnoreCase(provider)){
				return val;
			}
		}
		
		return UNKNOWN;
	}
	
	public static AnnotationProviderApi getProviderTypeByLinkback (String linkBackPrefix){
		for (AnnotationProviderApi val : AnnotationProviderApi.values()){
			if (val.getLinkBackPrefix().equalsIgnoreCase(linkBackPrefix)){
				return val;
			}
		}
		
		return UNKNOWN;
	}
	
}
