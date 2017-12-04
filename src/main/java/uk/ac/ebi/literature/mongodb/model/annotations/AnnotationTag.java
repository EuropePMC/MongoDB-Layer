package uk.ac.ebi.literature.mongodb.model.annotations;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
@org.codehaus.jackson.annotate.JsonIgnoreProperties(ignoreUnknown=true)
public class AnnotationTag implements java.io.Serializable {
	
	private String name;
	
	private String uri;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}
	
	
}
