package uk.ac.ebi.literature.mongodb.model.citation;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * @author jyothi
 * 1 Dec 2010  11:01:53
 */
@XmlType(name="profile", propOrder={"name","count"})
// next line only for rest development
@JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)
public class Profile implements Serializable{
	private String name;
	private int count;
	
	  /**
	   *  Constructor - initilaize collections
	   */
	    public Profile() {
	        super();
	    }

	
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the name
	 */
	@XmlAttribute 
	public String getName() {
		return name;
	}
	/**
	 * @param count the count to set
	 */
	public void setCount(int count) {
		this.count = count;
	}
	/**
	 * @return the count
	 */
	@XmlAttribute 
	public int getCount() {
		return count;
	}
}
 
