package uk.ac.ebi.literature.mongodb.model.annotations.sciliteapi;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import uk.ac.ebi.literature.mongodb.model.annotations.AnnotationItemGeneral;

@JsonIgnoreProperties(ignoreUnknown=true)
@org.codehaus.jackson.annotate.JsonIgnoreProperties(ignoreUnknown=true)
public class AnnotationApiSource implements Serializable {

	private Long pmcid;

	private String src;
	
	private String ext_id;
	
	private String provider;
	
	private List<AnnotationApiSourceItem> anns;
	
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

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public List<AnnotationApiSourceItem> getAnns() {
		return anns;
	}

	public void setAnns(List<AnnotationApiSourceItem> anns) {
		this.anns = anns;
	}

	public Long getPmcid() {
		return pmcid;
	}

	public void setPmcid(Long pmcid) {
		this.pmcid = pmcid;
	}

	@JsonIgnore
	@com.fasterxml.jackson.annotation.JsonIgnore
	public boolean isAbstractDocument(){
		 return (this.src!=null) && (this.src.isEmpty()==false) && (this.ext_id!=null) && (this.ext_id.isEmpty()==false);
	}
	
	
}
