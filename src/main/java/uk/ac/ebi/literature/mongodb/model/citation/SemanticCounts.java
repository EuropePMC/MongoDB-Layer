package uk.ac.ebi.literature.mongodb.model.citation;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlType;

/**
 * @author jyothi
 * 31 May 2012  15:49:13
 */
@XmlType (name = "semanticCounts", propOrder = {"name","count"})
public class SemanticCounts implements Serializable{

	private String name;
	private Integer count;
	
	public SemanticCounts() {
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
	public String getName() {
		return name;
	}

	/**
	 * @param count the count to set
	 */
	public void setCount(Integer count) {
		this.count = count;
	}

	/**
	 * @return the count
	 */
	public Integer getCount() {
		return count;
	}

}
