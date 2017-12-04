package uk.ac.ebi.literature.mongodb.model.annotations;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import uk.ac.ebi.literature.mongodb.util.MongoDBUtility;

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
public class AnnotationMultipleExternal<T> extends AnnotationData {
	
	private static final long serialVersionUID = -8314014527874449665L;

	@JsonIgnore
	private Object _id;
	
	private List<T> anns;
	
	private String provider;
	
	public Object get_id() {
		return _id;
	}

	public void set_id(Object _id) {
		this._id = _id;
	}

	public List<T> getAnns() {
		return anns;
	}

	public void setAnns(List<T> annotations) {
		this.anns = annotations;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}
	
	public <E> AnnotationMultipleExternal<E> deserializeFromMap(Class<E> classType) throws InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException{
		AnnotationMultipleExternal<E> ret = new AnnotationMultipleExternal<E>(); 
		ret._id = this._id;
		ret.setProvider(this.getProvider()); 
		ret.setPmcid(this.getPmcid());
		List<E> annsData= new ArrayList<E>();
		List<AnnotationTag> tagElements;
		AnnotationTag tagVal;
		Object mapVal;
		Map<String, String> mapTagValue;
		if (this.anns.size()>0 && (this.anns.get(0) instanceof Map)){
			for (Map mapValues : (List<Map>)this.anns){
				
				mapVal = mapValues.get("e_start");
				if (mapVal!=null && mapVal instanceof String){
					mapValues.put("e_start", Integer.parseInt((String) mapVal));
				}
				
				mapVal = mapValues.get("start");
				if (mapVal!=null && mapVal instanceof String){
					mapValues.put("start", Integer.parseInt((String) mapVal));
				}
				
				mapVal = mapValues.get("tags");
				if (mapVal!=null && mapVal instanceof List){
					tagElements = new ArrayList<AnnotationTag>();
					for (Object tagElement : ((List)mapVal)){
						if (tagElement instanceof Map){
							mapTagValue = (Map) tagElement;
							tagVal = new AnnotationTag();
							tagVal.setName(mapTagValue.get("name"));
							tagVal.setUri(mapTagValue.get("uri"));
							tagElements.add(tagVal);
						}
					}
					mapValues.put("tags", tagElements);
				}
				
				annsData.add((E)MongoDBUtility.parseMap(mapValues, classType));
			}
			
		}
		
		ret.setAnns(annsData);
		
		return ret;
	}

}
