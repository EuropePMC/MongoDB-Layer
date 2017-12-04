package uk.ac.ebi.literature.mongodb.model.annotations;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * { "ann": "http://rdf.ebi.ac.uk/resource/europepmc/annotations/PMC3377538#1-1" ,
   "position": "1.1"
   "tag": "http://purl.uniprot.org/uniprot/Q08775",
   "prefix": "aaaaaa" ,
   "exact": "Runx2",
   "postfix": mediates epigenetic silencing of the bo"
   "pmcid": "3377538"
 } 
 * @author ftalo
 *
 */
public class AnnotationSingle extends AnnotationData{

	private static final long serialVersionUID = 6397689105034490829L;

	@JsonIgnore
	private Object _id;
	
	private String ann;
	
	private String position;
	
	private String tag;
	
	private String prefix;
	
	private String exact;
	
	private String postfix;
	

	public Object get_id() {
		return _id;
	}

	public void set_id(Object _id) {
		this._id = _id;
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

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
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

}
