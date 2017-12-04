package uk.ac.ebi.literature.mongodb.model.annotations.abstracts;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import uk.ac.ebi.literature.mongodb.model.annotations.AnnotationItemGeneral;

@JsonIgnoreProperties(ignoreUnknown=true)
public class AnnotationAbstract implements Serializable {

	@JsonIgnore
	private Object _id;

	private String src;
	
	private String ext_id;
	
	private String provider;
	
	private List<AnnotationItemGeneral> anns;
	
	private Date dateUpdated;

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

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public List<AnnotationItemGeneral> getAnns() {
		return anns;
	}

	public void setAnns(List<AnnotationItemGeneral> anns) {
		this.anns = anns;
	}

	public Date getDateUpdated() {
		return dateUpdated;
	}

	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}
	
	
}
