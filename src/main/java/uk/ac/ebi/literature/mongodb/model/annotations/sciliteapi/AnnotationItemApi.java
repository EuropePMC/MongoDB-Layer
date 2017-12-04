package uk.ac.ebi.literature.mongodb.model.annotations.sciliteapi;

import java.io.Serializable;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import uk.ac.ebi.literature.mongodb.model.annotations.AnnotationTag;

@JsonIgnoreProperties(ignoreUnknown=true)
public class AnnotationItemApi implements Serializable{
	
    private String ann;
	
	private String position;
	
	private List<AnnotationTag> tags;
	
	private String prefix;
	
	private String exact;
	
	private String postfix;
	
	private String ann_link;

	private String type;
	
	private String section;
	
	private String provider;
	
	public AnnotationItemApi (AnnotationApiSourceItem input, AnnotationProviderApi provider, boolean isAbstractDocument, String src, String extId, Long pmcId){
		this.setExact(input.getExact());
		this.setPosition(input.getPosition());
		this.setPostfix(input.getPostfix());
		this.setPrefix(input.getPrefix());
		this.setTags(input.getTags());
		
		AnnotationSectionApi section = AnnotationSectionApi.getByLabel(input.getSection());
		
		if (section==AnnotationSectionApi.UNSPECIFIED && isAbstractDocument){
			section = AnnotationSectionApi.ABSTRACT;
		}else if (section==AnnotationSectionApi.UNSPECIFIED && (isAbstractDocument==false)){
			
			if (input.getSection()!=null && input.getSection().toUpperCase().startsWith("CONCL")){
				section = AnnotationSectionApi.CONCLUSION;
			}else if ((input.getSection()!=null && input.getSection().toUpperCase().startsWith("SUPPL")) || "APPENDIX".equalsIgnoreCase(input.getSection())){
				section = AnnotationSectionApi.SUPPLEMENTARY_MATERIAL;
			}else if (input.getSection()!=null && input.getSection().toUpperCase().startsWith("CASE")){
				section = AnnotationSectionApi.CASE_STUDY;
			}else if (input.getSection()!=null && input.getSection().toUpperCase().startsWith("INTRO")){
				section = AnnotationSectionApi.INTRODUCTION;
			}else if (input.getSection()!=null && input.getSection().toUpperCase().startsWith("METHODS")){
				section = AnnotationSectionApi.METHODS;
			}else if (input.getSection()!=null && input.getSection().toUpperCase().startsWith("RESULTS")){
				section = AnnotationSectionApi.RESULTS;
			}else if (input.getSection()!=null && input.getSection().toUpperCase().startsWith("DISCUSS")){
				section = AnnotationSectionApi.DISCUSSION;
			}else if (input.getSection()!=null && input.getSection().toUpperCase().startsWith("ACK_FUND")){
				section = AnnotationSectionApi.ACKNOWLEDGEMENTS;
			}else if (input.getSection()!=null && input.getSection().toUpperCase().startsWith("TABLE")){
				section = AnnotationSectionApi.TABLE;
			}else if (input.getSection()!=null && input.getSection().toUpperCase().startsWith("COMP_INT")){
				section = AnnotationSectionApi.COMPETING_INTEREST;
			}else if (input.getSection()!=null && input.getSection().toUpperCase().startsWith("ABBR")){
				section = AnnotationSectionApi.ABBREVIATION;
			}else if (input.getSection()!=null && input.getSection().toUpperCase().startsWith("AUTH_CONT")){
				section = AnnotationSectionApi.AUTHOR_CONTRIBUTIONS;
			}else{
				if ("".equalsIgnoreCase(input.getSection())==false){
					System.out.println("UNKNOWN SECTION "+input.getSection());
				}
				section = AnnotationSectionApi.ARTICLE;
			}
		}
		
		this.setSection(section.getLabel());
		this.setProvider(provider.getLabel());
		this.setType(getAnnotationType(input.getTags(), provider));
		String linkBack = this.buildAnnLink(input, provider, src, extId, pmcId);
		this.setAnn_link(linkBack);
		this.setAnn(linkBack);
	}
	
	public AnnotationItemApi(){
		
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	private String getAnnotationType(List<AnnotationTag> tagList, AnnotationProviderApi provider){
		AnnotationTypeApi type_ret=null;
		switch (provider){
		case EUROPEPMC:
			String url=tagList.get(0).getUri();
			if (url.startsWith("http://purl.uniprot.org/uniprot/")){
				type_ret = AnnotationTypeApi.GENES_PROTEINS;
			}else if (url.startsWith("http://identifiers.org/taxonomy/")){
				type_ret = AnnotationTypeApi.ORGANISMS;
			}else if (url.startsWith("http://purl.obolibrary.org/obo/CHEBI_")){
				type_ret = AnnotationTypeApi.CHEMICALS;
			}else if (url.startsWith("http://purl.obolibrary.org/obo/GO:") || url.startsWith("http://identifiers.org/go/GO:")){
				type_ret = AnnotationTypeApi.GO_TERMS;
			}else if (url.startsWith("http://linkedlifedata.com/resource/umls-concept/")){
				type_ret = AnnotationTypeApi.DISEASE;
			}else if (url.startsWith("http://www.ebi.ac.uk/efo/")){
				type_ret = AnnotationTypeApi.EFO;
			}else if (url.startsWith("http://identifiers.org/")){
				type_ret = AnnotationTypeApi.ACCESSION_NUMBERS;
			}
			break;
		case GENERIF:
			type_ret=AnnotationTypeApi.GENERIF;
			break;
		case OPEN_TARGET:
			type_ret=AnnotationTypeApi.GENE_DISEASE;
			break;
		case DISGENET:
			type_ret=AnnotationTypeApi.GENE_DISEASE;
			break;
		case INTACT:
			type_ret=AnnotationTypeApi.PPI;
			break;
		case NACTEM:
			type_ret=AnnotationTypeApi.BIOLOGICAL_EVENT;
			break;
		case NCBI:
			type_ret=AnnotationTypeApi.GENETIC_VARIATION;
			break;
		case GRECO:
			type_ret=AnnotationTypeApi.TRANSCRIPTION_FACTOR_TARGET_GENE;
			break;
		default:
			type_ret=AnnotationTypeApi.UNKNOWN;
			break;
		}
		
		return  type_ret.getLabel();
	}
	
	

	public String getAnn() {
		return ann;
	}

	public void setAnn(String ann) {
		this.ann = ann;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public List<AnnotationTag> getTags() {
		return tags;
	}

	public void setTags(List<AnnotationTag> tags) {
		this.tags = tags;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getExact() {
		return exact;
	}

	public void setExact(String exact) {
		this.exact = exact;
	}

	public String getPostfix() {
		return postfix;
	}

	public void setPostfix(String postfix) {
		this.postfix = postfix;
	}

	public String getAnn_link() {
		return ann_link;
	}

	public void setAnn_link(String ann_link) {
		this.ann_link = ann_link;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}
	
	@JsonIgnore
	@com.fasterxml.jackson.annotation.JsonIgnore
	public String getTypeSectionKwLabel(){
		 return getTypeSectionKwLabel(this.getType().toLowerCase(), this.getSection().toLowerCase());
	}
	
	public static String getTypeSectionKwLabel(String type, String section){
		return type.toLowerCase()+"%"+section.toLowerCase();
	}
	
	public static String getTypeFromTypeSectionKwLabel(String typeSectionLabel){
		return typeSectionLabel.split("%")[0];
	}
	
	public static String getSectionFromTypeSectionKwLabel(String typeSectionLabel){
		return typeSectionLabel.split("%")[1];
	}
	
	@JsonIgnore
	@com.fasterxml.jackson.annotation.JsonIgnore
	public boolean isAbstractSection(){
		AnnotationSectionApi section = AnnotationSectionApi.getByLabel(this.getSection());
		
		return (section==AnnotationSectionApi.TITLE) || (section==AnnotationSectionApi.ABSTRACT);
	}
	
	public static String getLinkBack(String src, String extId, Long pmcId, boolean abstractLink, String annotationId){
		String url="http://europepmc.org/";
		if (abstractLink==false){
			url+="articles/PMC"+pmcId.toString().replaceAll("PMC", "")+"#"+annotationId;
		}else{
			if ("NBK".equalsIgnoreCase(src)){
				url+="books/"+extId+"#"+annotationId;
			}else if ("DOI".equalsIgnoreCase(src)){
				url+="abstract/MED/"+extId+"#"+annotationId;
			}else if ("ETH".equalsIgnoreCase(src)){
				url+="theses/ETH/"+extId+"#"+annotationId;
			}else if ("PAT".equalsIgnoreCase(src)){
				url+="patents/PAT/"+extId+"#"+annotationId;
			}else if ("HIR".equalsIgnoreCase(src)){
				url+="guidelines/HIR/"+extId+"#"+annotationId;
			}else {
				url+="abstract/"+src.toUpperCase()+"/"+extId+"#"+annotationId;
			}
		}
		
		return url;
	}
	
	private String buildAnnLink(AnnotationApiSourceItem inputData, AnnotationProviderApi providerApi, String src, String extId, Long pmcId){
		
		boolean isAbstractAnnotation = this.isAbstractSection();
		
		HashGenerator hashGenerator = new HashGenerator();
		String hashAnnotation = hashGenerator.generateHashAnnotation(inputData);
		
		String annotationId=providerApi.getLinkBackPrefix()+"-"+hashAnnotation;
		
		String ann_link= AnnotationItemApi.getLinkBack(src, extId, pmcId, isAbstractAnnotation, annotationId);
		return ann_link;
	}
	
	private class HashGenerator{

		private MessageDigest messageDigest;

		private HashGenerator(){
			//messageDigest = MessageDigest.getInstance("SHA-256");
			try {
				messageDigest = MessageDigest.getInstance("MD5");
			} catch (NoSuchAlgorithmException e) {
			}
		}
		
		public String generateHashAnnotation(AnnotationApiSourceItem inputData) {
			String annotationId="";
			String tokenAnnotationHashCode="";
			
			if (inputData.getPrefix()!=null){
				tokenAnnotationHashCode= tokenAnnotationHashCode + this.hashValue(inputData.getPrefix());
			}
			
			if (inputData.getExact()!=null){
				tokenAnnotationHashCode= tokenAnnotationHashCode + this.hashValue(inputData.getExact());
			}
			
			if (inputData.getPostfix()!=null){
				tokenAnnotationHashCode= tokenAnnotationHashCode + this.hashValue(inputData.getPostfix());
			}
			
			
			String [] urlParts;
			for (AnnotationTag tagSource : inputData.getTags()){
				urlParts = tagSource.getUri().split("/");
				if (urlParts.length>1){
					tokenAnnotationHashCode = tokenAnnotationHashCode+"-"+this.hashValue(urlParts[urlParts.length-1]);
				}
			}
			
			annotationId= this.hashValue(tokenAnnotationHashCode);
			
			return annotationId;
		}
		
		private String hashValue(String stringToEncrypt) {
			String encryptedString=stringToEncrypt;
			try{
				messageDigest.reset();
				messageDigest.update(stringToEncrypt.getBytes("UTF-8"));
				byte[] hash = messageDigest.digest();
				encryptedString = toHex(hash);
				
			}catch(Exception e){
				encryptedString=stringToEncrypt;
			}
			return encryptedString;
		}
		
		private String toHex(byte[] array)
	    {
	        BigInteger bi = new BigInteger(1, array);
	        String hex = bi.toString(16);
	        int paddingLength = (array.length * 2) - hex.length();
	        if(paddingLength > 0)
	            return String.format("%0" + paddingLength + "d", 0) + hex;
	        else
	            return hex;
	    }
	}
}
