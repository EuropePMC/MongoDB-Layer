package uk.ac.ebi.literature.mongodb.model.annotations;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * { "pmcid": "3377538",
   "anns":[
        {"ann": "http://rdf.ebi.ac.uk/resource/europepmc/annotations/PMC3377538#1-1" , {
        "position": "1.1"
        "tag": "http://purl.uniprot.org/uniprot/Q08775",
        "prefix": "aaaaaa" ,
        "exact": "Runx2",
        "postfix": mediates epigenetic silencing of the bo"},
        {"ann": "http://rdf.ebi.ac.uk/resource/europepmc/annotations/PMC3377538#1-2" , {
        "position": "1.3"
        "tag": "http://purl.uniprot.org/uniprot/Q08775",
        "prefix": "bbbbbb" ,
        "exact": "Runx2sasdds",
         "postfix": mediates epigenetic silencing of the bosdsdsdsdsd"},

       ........

  ]
 } 
 * @author ftalo
 *
 */
@JsonIgnoreProperties(ignoreUnknown=true)
@org.codehaus.jackson.annotate.JsonIgnoreProperties(ignoreUnknown=true)
public class AnnotationMultiple extends AnnotationData {
	
	private static final long serialVersionUID = -8314014527874449665L;

	@JsonIgnore
	private Object _id;
	
	private List<AnnotationItem> anns;
	
	public Object get_id() {
		return _id;
	}

	public void set_id(Object _id) {
		this._id = _id;
	}

	public List<AnnotationItem> getAnns() {
		return anns;
	}

	public void setAnns(List<AnnotationItem> annotations) {
		this.anns = annotations;
	}

}
