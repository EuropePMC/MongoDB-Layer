package uk.ac.ebi.literature.mongodb.model.citation;

import javax.xml.bind.annotation.XmlType;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jyothi
 * 1 Dec 2010  11:00:28
 */
@XmlType (name = "profileListBean", propOrder = {"source","pubType","subset"})
// next line only for rest development
@JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)
public class ProfileListBean implements Serializable{

	private List<Profile> source;
	private List<Profile> pubType;
	private List<Profile> subset;
	
	
	/**
     * Constructor - initilaize collections
     */
    public ProfileListBean() {
        super();
        this.setPubType(new ArrayList<Profile>());
        this.source = new ArrayList<Profile>();
        this.subset = new ArrayList<Profile>();
    }
	
	/**
	 * @param source the source to set
	 */
	public void setSource(List<Profile> source) {
		this.source = source;
	}
	/**
	 * @return the source
	 */
	public List<Profile> getSource() {
		return source;
	}
	/**
	 * @param subset the subset to set
	 */
	public void setSubset(List<Profile> subset) {
		this.subset = subset;
	}
	/**
	 * @return the subset
	 */
	public List<Profile> getSubset() {
		return subset;
	}

	/**
	 * @param pubType the pubType to set
	 */
	public void setPubType(List<Profile> pubType) {
		this.pubType = pubType;
	}

	/**
	 * @return the pubType
	 */
	public List<Profile> getPubType() {
		return pubType;
	}
	
	
}

