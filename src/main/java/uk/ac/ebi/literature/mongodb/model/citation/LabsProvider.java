package uk.ac.ebi.literature.mongodb.model.citation;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jyothi
 *
 */
@XmlType (name = "labsProvider", propOrder = {"id","name","description","frontTab","link"})
@JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)
public class LabsProvider implements Serializable{

	private Integer id;	
	private String name;
	private String description;
	private String frontTab;
	private List<LabsLinks> link;
	
	public LabsProvider() {
		super();
		this.link = new ArrayList<LabsLinks>();
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the link
	 */
	public List<LabsLinks> getLink() {
		return link;
	}

	/**
	 * @param link the link to set
	 */
	public void setLink(List<LabsLinks> link) {
		this.link = link;
	}

	/**
	 * @return the frontTab
	 */
	public String getFrontTab() {
		return frontTab;
	}

	/**
	 * @param frontTab the frontTab to set
	 */
	public void setFrontTab(String frontTab) {
		this.frontTab = frontTab;
	}

}
