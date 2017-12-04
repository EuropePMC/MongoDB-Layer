package uk.ac.ebi.literature.mongodb.model.citation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Cited by metadata list
 * @author jyothi
 * 4 Mar 2011  16:21:05
 */
public class CitationList implements Serializable{
   
    private List<CitationData> citation;
   //ATTRIBUTE  private String type;


    public CitationList() {
    	super();
    	this.citation = new ArrayList<CitationData>();
    }


  /*  @XmlAttribute
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }*/
    
    /**
     * @param citation the citation to set
     */
    public void setCitation(List<CitationData> citation) {
        this.citation = citation;
    }


    /**
     * @return the citation
     */
    public List<CitationData> getCitation() {
        return citation;
    }



}
