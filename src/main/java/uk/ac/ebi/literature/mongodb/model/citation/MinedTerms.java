package uk.ac.ebi.literature.mongodb.model.citation;

import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/** 
 * @author jyothi
 * 7 Mar 2011  11:15:52
 */
@XmlType(name= "minedTerms", propOrder={"name", "total","tmSummary" })
// next line only for rest development
@JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)
public class MinedTerms implements Serializable{

	private String name;
	private int total ;
	private List<MinedSummary> tmSummary;
	
	public MinedTerms() {
		super();
		this.tmSummary = new ArrayList<MinedSummary>();
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(int total) {
		this.total = total;
	}

	/**
	 * @return the total
	 */
	public int getTotal() {
		return total;
	}

	/**
	 * @param tmSummary the tmSummary to set
	 */
	public void setTmSummary(List<MinedSummary> tmSummary) {
		this.tmSummary = tmSummary;
	}

	/**
	 * @return the tmSummary
	 */
	public List<MinedSummary> getTmSummary() {
		return tmSummary;
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

}
