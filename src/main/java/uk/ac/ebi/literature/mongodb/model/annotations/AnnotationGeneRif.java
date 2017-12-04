package uk.ac.ebi.literature.mongodb.model.annotations;

public class AnnotationGeneRif {

    private String ann;
	
	private String tag;
	
	private String exact;
	
	public String getAnn() {
		return ann;
	}

	public void setAnn(String ann) {
		this.ann = ann;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
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
		if (!(obj instanceof AnnotationGeneRif))
			return false;
		AnnotationGeneRif other = (AnnotationGeneRif) obj;
		if (ann == null) {
			if (other.ann != null)
				return false;
		} else if (!ann.equals(other.ann))
			return false;
		return true;
	}
	
	
}
