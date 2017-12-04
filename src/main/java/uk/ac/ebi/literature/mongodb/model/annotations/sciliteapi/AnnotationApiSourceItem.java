package uk.ac.ebi.literature.mongodb.model.annotations.sciliteapi;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import uk.ac.ebi.literature.mongodb.model.annotations.AnnotationTag;


@JsonIgnoreProperties(ignoreUnknown=true)
@org.codehaus.jackson.annotate.JsonIgnoreProperties(ignoreUnknown=true)
public class AnnotationApiSourceItem implements Serializable {

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
		result = prime * result + ((ann_link == null) ? 0 : ann_link.hashCode());
		result = prime * result + ((exact == null) ? 0 : exact.hashCode());
		result = prime * result + ((position == null) ? 0 : position.hashCode());
		result = prime * result + ((postfix == null) ? 0 : postfix.hashCode());
		result = prime * result + ((prefix == null) ? 0 : prefix.hashCode());
		result = prime * result + ((section == null) ? 0 : section.hashCode());
		result = prime * result + ((tags == null) ? 0 : tags.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof AnnotationApiSourceItem))
			return false;
		AnnotationApiSourceItem other = (AnnotationApiSourceItem) obj;
		if (ann == null) {
			if (other.ann != null)
				return false;
		} else if (!ann.equals(other.ann))
			return false;
		if (ann_link == null) {
			if (other.ann_link != null)
				return false;
		} else if (!ann_link.equals(other.ann_link))
			return false;
		if (exact == null) {
			if (other.exact != null)
				return false;
		} else if (!exact.equals(other.exact))
			return false;
		if (position == null) {
			if (other.position != null)
				return false;
		} else if (!position.equals(other.position))
			return false;
		if (postfix == null) {
			if (other.postfix != null)
				return false;
		} else if (!postfix.equals(other.postfix))
			return false;
		if (prefix == null) {
			if (other.prefix != null)
				return false;
		} else if (!prefix.equals(other.prefix))
			return false;
		if (section == null) {
			if (other.section != null)
				return false;
		} else if (!section.equals(other.section))
			return false;
		if (tags == null) {
			if (other.tags != null)
				return false;
		} else if (!tags.equals(other.tags))
			return false;
		return true;
	}
}
