package uk.ac.ebi.literature.mongodb.model.annotations.sciliteapi;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import uk.ac.ebi.literature.mongodb.model.annotations.AnnotationTag;
import uk.ac.ebi.literature.mongodb.model.annotations.sciliteapi.AnnotationKeywordApi.KW_TYPE;

public class AnnotationApi implements Serializable  {
	
	private Object _id;
	
    private String src;
	
	private String ext_id;
	
	private Long uniqueCountId;
	
	private Long pmcid;
	
	private String license;
	
	private String oa;
	
	protected List<AnnotationItemApi> anns;

	protected List<AnnotationKeywordApi> kw;
	
	private Date dateUpdated;
	
	private Date dateInserted;
	
	public AnnotationApi(){
		this.kw = new ArrayList<AnnotationKeywordApi>();
		this.anns = new ArrayList<AnnotationItemApi>();
	}
	
	public AnnotationApi(String src, String extId, Long pmcid, String license, String availabilityStatus){
		super();
		this.setPmcid(pmcid);
		this.setExt_id(extId);
		this.setSrc(src);
		this.setLicense(license);
		this.setOa(availabilityStatus);
		this.kw = new ArrayList<AnnotationKeywordApi>();
		this.anns = new ArrayList<AnnotationItemApi>();
		Date now = new Date();
		this.setDateInserted(now);
		this.setDateUpdated(now);
		this.computeUniqueCountId();
	}
	
	private void computeUniqueCountId() {
		String uniqueCountIdValString="";
		int hashVal;
		Long uniqueCountIdVal;
		try{
			if ("PAT".equalsIgnoreCase(this.getSrc())){
				if (this.getExt_id().replaceAll("[^0-9]", "")!=null && (this.getExt_id().replaceAll("[^0-9]", "").isEmpty()==false)){
					uniqueCountIdValString="11"+this.getExt_id().replaceAll("[^0-9]", "")+String.valueOf(this.getExt_id().hashCode());
				}else{
					uniqueCountIdValString="11"+String.valueOf(this.getExt_id().hashCode());
				}
			}else if ("AGR".equalsIgnoreCase(this.getSrc())){
				uniqueCountIdValString="2"+this.getExt_id().replaceAll("[^0-9]", "")+String.valueOf(this.getExt_id().hashCode());
			}else if ("PMC".equalsIgnoreCase(this.getSrc())){
				uniqueCountIdValString="3"+this.getExt_id().replaceAll("PMC", "");
			}else if ("CBA".equalsIgnoreCase(this.getSrc())){
				uniqueCountIdValString="4"+this.getExt_id();
			}else if ("CIT".equalsIgnoreCase(this.getSrc())){
				uniqueCountIdValString="5"+this.getExt_id();
			}else if ("CTX".equalsIgnoreCase(this.getSrc())){
				uniqueCountIdValString="6"+this.getExt_id().replaceAll("[^0-9]", "");
			}else if ("MED".equalsIgnoreCase(this.getSrc())){
				uniqueCountIdValString="7"+this.getExt_id();
			}else if ("HIR".equalsIgnoreCase(this.getSrc())){
				uniqueCountIdValString="8"+this.getExt_id();
			}else if ("ETH".equalsIgnoreCase(this.getSrc())){
				uniqueCountIdValString="9"+this.getExt_id();
			}else if ("NBK".equalsIgnoreCase(this.getSrc())){
				hashVal = "NBK".hashCode()+Integer.parseInt(this.getExt_id().replaceAll("NBK", ""));
				uniqueCountIdValString="13"+String.valueOf(hashVal);
			}else if ("PPR".equalsIgnoreCase(this.getSrc())){
				hashVal = "PPR".hashCode()+Integer.parseInt(this.getExt_id().replaceAll("PPR", ""));
				uniqueCountIdValString="12"+String.valueOf(hashVal);
			}
		
			uniqueCountIdValString = uniqueCountIdValString.replaceAll("-", "");
			
			if (uniqueCountIdValString.length()>18){
				uniqueCountIdValString = uniqueCountIdValString.substring(0, 18);
			}
			
			uniqueCountIdVal = Long.parseLong(uniqueCountIdValString);
		
		}catch(NumberFormatException e){
			hashVal = (this.getSrc()+this.getExt_id()).hashCode();
			if (hashVal < 0){
				hashVal = hashVal * (-1);
			}
			uniqueCountIdVal = Long.valueOf(hashVal);
		}
		
		this.setUniqueCountId(uniqueCountIdVal);
	     
	}

	public List<AnnotationKeywordApi> getKw() {
		return kw;
	}

	public void setKw(List<AnnotationKeywordApi> keywords) {
		this.kw = keywords;
	}

	public List<AnnotationItemApi> getAnns() {
		return anns;
	}

	public void setAnns(List<AnnotationItemApi> anns) {
		this.anns = anns;
	}

	public Date getDateUpdated() {
		return dateUpdated;
	}

	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}
	
	public Object get_id() {
		return _id;
	}

	public void set_id(Object _id) {
		this._id = _id;
	}
	
	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	public String getExt_id() {
		return ext_id;
	}

	public void setExt_id(String ext_id) {
		this.ext_id = ext_id;
	}

	public Long getPmcid() {
		return pmcid;
	}

	public void setPmcid(Long pmcid) {
		this.pmcid = pmcid;
	}

	public void importAnnotations(AnnotationApiSource inputData) {
		AnnotationProviderApi providerApi = AnnotationProviderApi.getProviderType(inputData.getProvider());
		
		//FIRST REMOVE annotations and keywords for that provider
		this.removeProviderAnnotations(inputData, inputData.getProvider(), inputData.isAbstractDocument());
		
		//ADD ANNOTATIONS and update keywords accordingly
		List<AnnotationItemApi> annotationItemsApi = inputData.getAnns().stream().map(annotationSource -> new AnnotationItemApi(annotationSource, providerApi, inputData.isAbstractDocument(), this.getSrc(), this.getExt_id(), this.getPmcid())).collect(Collectors.<AnnotationItemApi>toList());
		this.addAnnotations(annotationItemsApi);
		
	}
	
	private static Predicate<AnnotationApiSourceItem> macthAnnotationContent(AnnotationItemApi annotationApi, String provider){
		return annotationSource ->{
			boolean ret = annotationSource.getExact().equalsIgnoreCase(annotationApi.getExact());
			ret = ret && ((annotationSource.getPrefix()==null && annotationApi.getPrefix()==null) || (annotationSource.getPrefix()!=null && annotationSource.getPrefix().equalsIgnoreCase(annotationApi.getPrefix())));
			ret = ret && ((annotationSource.getPostfix()==null && annotationApi.getPostfix()==null) || (annotationSource.getPostfix()!=null && annotationSource.getPostfix().equalsIgnoreCase(annotationApi.getPostfix())));
			ret = ret && (annotationApi.getProvider().equalsIgnoreCase(provider));
			return ret;
		};
	}
	
	public void removeProviderAnnotations(AnnotationApiSource inputData, String provider, boolean onlyAbstract){
		List<AnnotationItemApi> annotationItemsApi = new ArrayList<AnnotationItemApi>();
		boolean matchingAnnotaion;
		Optional<AnnotationApiSourceItem> mathingAnnotationOptional=null;
		
		List<AnnotationApiSourceItem> annotationsToAdd = inputData.getAnns();
		
		for (AnnotationItemApi annotationItemApi : this.anns){
			
			if (annotationItemApi.getProvider().equalsIgnoreCase(provider)){
				mathingAnnotationOptional = annotationsToAdd.stream().filter(macthAnnotationContent(annotationItemApi, provider)).findFirst();
				matchingAnnotaion = mathingAnnotationOptional.isPresent();
			}else{
				matchingAnnotaion = false;
			}
			
			if (annotationItemApi.getProvider().equalsIgnoreCase(provider)==false){
				//keep the annotations if it is from a different provider
				annotationItemsApi.add(annotationItemApi);
			}else if (onlyAbstract && (annotationItemApi.isAbstractSection()==false) && (matchingAnnotaion==false)){
				//keep the annotations if we are updating the abstract and the annotation does not have abstract section but it is not matching with any of the one that we want to update
				annotationItemsApi.add(annotationItemApi);
			}else if ((onlyAbstract==false) && (annotationItemApi.isAbstractSection()) && (matchingAnnotaion)){
				//keep the annotation if we are updating everything and the annotation is coming from abstract and there's a match in the new dataset. In this case I will remove the match from the new list as well.
				annotationItemsApi.add(annotationItemApi);
				annotationsToAdd.remove(mathingAnnotationOptional.get());
			}else{
				//remove the annotation
				this.manageKeywordsAnnotation(annotationItemApi, false);
			}
		}
		
		inputData.setAnns(annotationsToAdd);
		
		this.setAnns(annotationItemsApi);
	}
	
	public void addAnnotations(List<AnnotationItemApi> annotationsData){
		for (AnnotationItemApi annData: annotationsData){
			if (AnnotationApi.isAnnotationAccountable(annData, this)){
				this.anns.add(annData);
				this.manageKeywordsAnnotation(annData, true);
			}
			
		}
	}
	
	public static boolean isAnnotationAccountable(AnnotationItemApi annotationItemApi, AnnotationApi articleData){
		
		List<String> licenseAllowed= Arrays.asList("cc by","cc by-nc","cc0");
		boolean ret=true;
		if ((articleData.getPmcid()!=null) && (licenseAllowed.contains(articleData.getLicense())==false) && ("O".equalsIgnoreCase(articleData.getOa())==false)){
			ret= annotationItemApi.isAbstractSection();
		}
		return ret;
	}
	
	private void manageKeywordsAnnotation( AnnotationItemApi annotationItemApi, boolean add){
		
		//if (isAnnotationAccountable(annotationItemApi, this)){
		
			this.manageKeywords(KW_TYPE.ANN_PROVIDER, annotationItemApi.getProvider(), add);
			this.manageKeywords(KW_TYPE.ANN_TYPE, annotationItemApi.getType(), add);
			for (AnnotationTag tagVal: annotationItemApi.getTags()){
				this.manageKeywords(KW_TYPE.ANN_ENTITY, tagVal.getName().toLowerCase(), add);
			}
			
			AnnotationTypeApi type = AnnotationTypeApi.getByLabel(annotationItemApi.getType());
			if (type.isRelationship()){
				this.manageKeywords(KW_TYPE.ANN_RELATION, getRelationshipLabelFromTags(annotationItemApi.getTags()), add);
			}
			
			this.manageKeywords(KW_TYPE.ANN_SECTION_TYPE, annotationItemApi.getTypeSectionKwLabel(), add);
			this.manageKeywords(KW_TYPE.ANN_SECTION, annotationItemApi.getSection(), add);
		
		//}
	}
	
	private static String getRelationshipLabelFromTags(List<AnnotationTag> tags) {
		List<String> tagsNames= new ArrayList<String>();
		
		for (AnnotationTag tagVal: tags){
			tagsNames.add(tagVal.getName().toLowerCase());
		}
		
		return getRelationshipLabel(tagsNames);
	}
	
	public static String getRelationshipLabel(List<String> entityNames){
		entityNames = entityNames.stream().map(entity->entity.toLowerCase()).collect(Collectors.<String>toList());
		Collections.sort(entityNames);
		
		StringBuilder concatTagNames = new StringBuilder("");
		for (String tagName : entityNames){
			concatTagNames.append(tagName+"%");
		}
		
		String ret = concatTagNames.toString().substring(0, concatTagNames.toString().length()-1).toLowerCase();
		
		return ret;
	}
	
	public static List<String> getEntitiesFromRelationshipLabel(String relationshipLabel){
		return Arrays.asList(relationshipLabel.split("%"));
	}

	protected void manageKeywords(AnnotationKeywordApi.KW_TYPE name, String val, boolean add) {
		if (add){
			boolean included=false;
			AnnotationKeywordApi newKwVal;
			for (AnnotationKeywordApi kwVal: this.kw){
				if ((name.name().equalsIgnoreCase(kwVal.getNm())) && (val.equalsIgnoreCase(kwVal.getVal()))){
					kwVal.incVal();
					kwVal.manageUniqueCount(this.uniqueCountId);
					included=true;
					break;
				}
			}
			
			if (included==false){
				 newKwVal = new AnnotationKeywordApi(name.name(),val);
				 newKwVal.manageUniqueCount(this.uniqueCountId);
				 this.kw.add(newKwVal);
			}
		}else{
			AnnotationKeywordApi keywordToDelete=null;
			for (AnnotationKeywordApi kwVal: this.kw){
				if ((name.name().equalsIgnoreCase(kwVal.getNm())) && (val.equalsIgnoreCase(kwVal.getVal()))){
					kwVal.decVal();
					if (kwVal.getCount()<=0){
						keywordToDelete = kwVal;
					}else{
						kwVal.manageUniqueCount(this.uniqueCountId);
					}
					break;
				}
			}
			
			if (keywordToDelete!=null){
				this.kw.remove(keywordToDelete);
			}
			
		}
		
	}

	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	public String getOa() {
		return oa;
	}

	public void setOa(String oa) {
		this.oa = oa;
	}

	public Date getDateInserted() {
		return dateInserted;
	}

	public void setDateInserted(Date dateInserted) {
		this.dateInserted = dateInserted;
	}

	public Long getUniqueCountId() {
		return uniqueCountId;
	}

	public void setUniqueCountId(Long uniqueCountId) {
		this.uniqueCountId = uniqueCountId;
	}
	
}
