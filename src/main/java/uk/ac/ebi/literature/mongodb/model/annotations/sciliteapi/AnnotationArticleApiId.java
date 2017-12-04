package uk.ac.ebi.literature.mongodb.model.annotations.sciliteapi;

public class AnnotationArticleApiId {
	
	public AnnotationArticleApiId(String src, String extId){
		this(src, extId, false, "");
	}
	
	public AnnotationArticleApiId(String src, String extId, boolean abstractData, String provider){
		this.setSrc(src);
		this.setExt_id(extId);
		this.setAbstractData(abstractData);
		this.setProvider(provider);
		
	}
	
	public AnnotationArticleApiId(String summary){
		String[] info = summary.split(",");
		this.setSrc(info[0]);
		this.setExt_id(info[1]);
		this.setAbstractData("abstract".equalsIgnoreCase(info[2]));
		this.setProvider(info[3]);
	}

	private String src;
	
	private String ext_id;
	
	private boolean abstractData;
	
	private String provider;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ext_id == null) ? 0 : ext_id.hashCode());
		result = prime * result + ((src == null) ? 0 : src.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof AnnotationArticleApiId))
			return false;
		AnnotationArticleApiId other = (AnnotationArticleApiId) obj;
		if (ext_id == null) {
			if (other.ext_id != null)
				return false;
		} else if (!ext_id.equals(other.ext_id))
			return false;
		if (src == null) {
			if (other.src != null)
				return false;
		} else if (!src.equals(other.src))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "[src=" + src + ", ext_id=" + ext_id + "]";
	}

	public boolean isAbstractData() {
		return abstractData;
	}

	public void setAbstractData(boolean abstractData) {
		this.abstractData = abstractData;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public String getSummary() {
		// TODO Auto-generated method stub
		String type = this.isAbstractData() ? "abstract":"fulltext";
		String summary = this.src+","+this.ext_id+","+type+","+this.provider;
		return summary;
	}

}
