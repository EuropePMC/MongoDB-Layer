package uk.ac.ebi.literature.mongodb.model.annotations;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
@org.codehaus.jackson.annotate.JsonIgnoreProperties(ignoreUnknown=true)
public class AnnotationItemGeneral implements Serializable {

	private String ann;
	
	private String position;
	
	private List<AnnotationTag> tags;
	
	private String prefix;
	
	private String exact;
	
	private String postfix;
	
	private String ann_link;
	
	private String section;
	
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
		if (!(obj instanceof AnnotationItemGeneral))
			return false;
		AnnotationItemGeneral other = (AnnotationItemGeneral) obj;
		if (ann == null) {
			if (other.ann != null)
				return false;
		} else if (!ann.equals(other.ann))
			return false;
		return true;
	}
}
