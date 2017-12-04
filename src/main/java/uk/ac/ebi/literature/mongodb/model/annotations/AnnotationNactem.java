package uk.ac.ebi.literature.mongodb.model.annotations;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
@org.codehaus.jackson.annotate.JsonIgnoreProperties(ignoreUnknown=true)
public class AnnotationNactem {

    private String ann;
	
	private String entity_id;
	
	private String exact;
	
	private String suffix;
	
	private String prefix;
	
	private String e_prefix;
	
	private String e_postfix;
	
	private String e_exact;
	
	private String uri;
	
	private Integer start;
	
	private Integer e_start;
	
	public String getEntity_id() {
		return entity_id;
	}

	public void setEntity_id(String entity_id) {
		this.entity_id = entity_id;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public int getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public int getE_start() {
		return e_start;
	}

	public void setE_start(Integer e_start) {
		this.e_start = e_start;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getE_prefix() {
		return e_prefix;
	}

	public void setE_prefix(String e_prefix) {
		this.e_prefix = e_prefix;
	}

	public String getE_postfix() {
		return e_postfix;
	}

	public void setE_postfix(String e_postfix) {
		this.e_postfix = e_postfix;
	}

	public String getE_exact() {
		return e_exact;
	}

	public void setE_exact(String e_exact) {
		this.e_exact = e_exact;
	}

	public String getAnn() {
		return ann;
	}

	public void setAnn(String ann) {
		this.ann = ann;
	}

	public String getExact() {
		return exact;
	}

	public void setExact(String exact) {
		this.exact = exact;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ann == null) ? 0 : ann.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof AnnotationNactem))
			return false;
		AnnotationNactem other = (AnnotationNactem) obj;
		if (ann == null) {
			if (other.ann != null)
				return false;
		} else if (!ann.equals(other.ann))
			return false;
		return true;
	}
	
	
}
