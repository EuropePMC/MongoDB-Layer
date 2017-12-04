package uk.ac.ebi.literature.mongodb.model.annotations;

public enum AnnotationProviderEnum {

	NACTEM(AnnotationNactem.class, "nactem","nactem"),
	GENERIF(AnnotationItemGeneral.class,"geneRif","geneRif"),
	OPEN_TARGET(AnnotationItemGeneral.class,"OpenTargets","openTargets"),
	NCBI(AnnotationItemGeneral.class,"NCBI","ncbi"),
	INTACT(AnnotationItemGeneral.class,"IntAct","intact"),
	DISGENET(AnnotationItemGeneral.class,"DisGeNET","disgenet"),
	EUROPEPMC(AnnotationItemGeneral.class, "europepmc","europepmc"),;
	
	private Class<?> modelClass;
	
	private String provider;
	
	private String linkBackPrefix;
	
	private AnnotationProviderEnum (Class<?> modelClass, String provider, String linkBackPrefix){
		this.modelClass = modelClass;
		this.provider = provider;
		this.linkBackPrefix = linkBackPrefix;
	}
	
	public Class<?> getModelClass() {
		return modelClass;
	}

	public String getProvider() {
		return provider;
	}
	
	public String getLinkBackPrefix() {
		return linkBackPrefix;
	}
	
	public static AnnotationProviderEnum getProviderType (String provider){
		for (AnnotationProviderEnum val : AnnotationProviderEnum.values()){
			if (val.getProvider().equalsIgnoreCase(provider)){
				return val;
			}
		}
		
		return null;
	}
	
	public static AnnotationProviderEnum getProviderTypeByLinkback (String linkback){
		for (AnnotationProviderEnum val : AnnotationProviderEnum.values()){
			if (val.getLinkBackPrefix().equalsIgnoreCase(linkback)){
				return val;
			}
		}
		
		return null;
	}
}
