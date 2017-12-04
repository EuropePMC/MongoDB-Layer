package uk.ac.ebi.literature.mongodb.model.citation;

import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import org.codehaus.jackson.map.annotate.JsonSerialize;
/** 
 * This class is for building Cited By metadata information
 * @author jyothi
 * 4 Mar 2011  16:37:15
 */
@XmlType (name = "CitationData", propOrder = {"id","source","citationType","title","authorString","journalAbbreviation",
											"pubYear","volume","ISSN","issue","pageInfo","citedByCount","text"})
// next line only for rest development
@JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)
public class CitationData implements Serializable{

	private String source;
	private String id;
	private String citationType;
	private String title;
	private String authorString;
	private String journalAbbreviation;
	private int pubYear;
	private String volume;
	private String ISSN;
	private String issue;
	private String pageInfo;
	private int citedByCount;
	private String text;
	
	public CitationData() {
		super();
	}

	
	/**
	 * @param source the source to set
	 */
	public void setSource(String source) {
		this.source = source;
	}

	/**
	 * @return the source
	 */
	public String getSource() {
		return source;
	}



	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param citationType the citationType to set
	 */
	public void setCitationType(String citationType) {
		this.citationType = citationType;
	}

	/**
	 * @return the citationType
	 */
	public String getCitationType() {
		return citationType;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param authorString the authorString to set
	 */
	public void setAuthorString(String authorString) {
		this.authorString = authorString;
	}


	/**
	 * @return the authorString
	 */
	public String getAuthorString() {
		return authorString;
	}

	/**
	 * @param journalAbbreviation the journalAbbreviation to set
	 */
	public void setJournalAbbreviation(String journalAbbreviation) {
		this.journalAbbreviation = journalAbbreviation;
	}

	/**
	 * @return the journalAbbreviation
	 */
	public String getJournalAbbreviation() {
		return journalAbbreviation;
	}

	/**
	 * @param pubYear the pubYear to set
	 */
	public void setPubYear(int pubYear) {
		this.pubYear = pubYear;
	}

	/**
	 * @return the pubYear
	 */
	public int getPubYear() {
		return pubYear;
	}

	/**
	 * @param volume the volume to set
	 */
	public void setVolume(String volume) {
		this.volume = volume;
	}

	/**
	 * @return the volume
	 */
	public String getVolume() {
		return volume;
	}

	/**
	 * @param iSSN the iSSN to set
	 */
	public void setISSN(String iSSN) {
		ISSN = iSSN;
	}

	/**
	 * @return the iSSN
	 */
	public String getISSN() {
		return ISSN;
	}

	/**
	 * @param issue the issue to set
	 */
	public void setIssue(String issue) {
		this.issue = issue;
	}

	/**
	 * @return the issue
	 */
	public String getIssue() {
		return issue;
	}

	/**
	 * @param pageInfo the pageInfo to set
	 */
	public void setPageInfo(String pageInfo) {
		this.pageInfo = pageInfo;
	}

	/**
	 * @return the pageInfo
	 */
	public String getPageInfo() {
		return pageInfo;
	}

	/**
	 * @param citedByCount the citedByCount to set
	 */
	public void setCitedByCount(int citedByCount) {
		this.citedByCount = citedByCount;
	}

	/**
	 * @return the citedByCount
	 */
	public int getCitedByCount() {
		return citedByCount;
	}

	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	
}
