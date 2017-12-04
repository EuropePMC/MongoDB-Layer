package uk.ac.ebi.literature.mongodb.model.citation;

import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import org.codehaus.jackson.map.annotate.JsonSerialize;
 
/**
 * @author jyothi
 * 1 Mar 2011  16:38:43
 */
@XmlType (name = "referenceInfo", propOrder = {"id","source","citationType","title","authorString","journalAbbreviation","issue","pubYear","volume","ISSN","ESSN",
										"ISBN","pageInfo","publicationTitle","publisherLoc","publisherName","seriesName","edition","editors","doi","unstructuredInformation","externalLink",
										"comments","citedOrder","match"})
// next line only for rest development
@JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)
public class ReferenceInfo implements Serializable{

	private String source;
	private String id;	
	private String citationType;
	private String title;
	private String authorString;
	private String journalAbbreviation;
	private String issue;
	private int pubYear;
	private String volume;
	private String ISSN;
	private String ESSN;
	private String ISBN;
	private String pageInfo;
	private String publicationTitle;
	private String publisherLoc;
	private String publisherName;
	private String seriesName;
	private String edition;
	private String editors;
	private String doi;
	private String unstructuredInformation;
	private String externalLink;
	private String comments;	
	private int citedOrder;	
	private String match;
	
	
	public ReferenceInfo() {
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
	 * @param eSSN the eSSN to set
	 */
	public void setESSN(String eSSN) {
		ESSN = eSSN;
	}


	/**
	 * @return the eSSN
	 */
	public String getESSN() {
		return ESSN;
	}


	/**
	 * @param iSBN the iSBN to set
	 */
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}


	/**
	 * @return the iSBN
	 */
	public String getISBN() {
		return ISBN;
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
	 * @param publicationTitle the publicationTitle to set
	 */
	public void setPublicationTitle(String publicationTitle) {
		this.publicationTitle = publicationTitle;
	}




	/**
	 * @return the publicationTitle
	 */
	public String getPublicationTitle() {
		return publicationTitle;
	}




	/**
	 * @param publisherLoc the publisherLoc to set
	 */
	public void setPublisherLoc(String publisherLoc) {
		this.publisherLoc = publisherLoc;
	}


	/**
	 * @return the publisherLoc
	 */
	public String getPublisherLoc() {
		return publisherLoc;
	}


	/**
	 * @param publisherName the publisherName to set
	 */
	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}


	/**
	 * @return the publisherName
	 */
	public String getPublisherName() {
		return publisherName;
	}


	/**
	 * @param seriesName the seriesName to set
	 */
	public void setSeriesName(String seriesName) {
		this.seriesName = seriesName;
	}


	/**
	 * @return the seriesName
	 */
	public String getSeriesName() {
		return seriesName;
	}


	/**
	 * @param edition the edition to set
	 */
	public void setEdition(String edition) {
		this.edition = edition;
	}


	/**
	 * @return the edition
	 */
	public String getEdition() {
		return edition;
	}


	/**
	 * @param editors the editors to set
	 */
	public void setEditors(String editors) {
		this.editors = editors;
	}


	/**
	 * @return the editors
	 */
	public String getEditors() {
		return editors;
	}


	/**
	 * @param doi the doi to set
	 */
	public void setDoi(String doi) {
		this.doi = doi;
	}


	/**
	 * @return the doi
	 */
	public String getDoi() {
		return doi;
	}


	/**
	 * @param unstructuredInformation the unstructuredInformation to set
	 */
	public void setUnstructuredInformation(String unstructuredInformation) {
		this.unstructuredInformation = unstructuredInformation;
	}


	/**
	 * @return the unstructuredInformation
	 */
	public String getUnstructuredInformation() {
		return unstructuredInformation;
	}


	/**
	 * @param externalLink the externalLink to set
	 */
	public void setExternalLink(String externalLink) {
		this.externalLink = externalLink;
	}


	/**
	 * @return the externalLink
	 */
	public String getExternalLink() {
		return externalLink;
	}


	/**
	 * @param comments the comments to set
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}


	/**
	 * @return the comments
	 */
	public String getComments() {
		return comments;
	}


	/**
	 * @param citedOrder the citedOrder to set
	 */
	public void setCitedOrder(int citedOrder) {
		this.citedOrder = citedOrder;
	}


	/**
	 * @return the citedOrder
	 */
	public int getCitedOrder() {
		return citedOrder;
	}


	/**
	 * @param match the match to set
	 */
	public void setMatch(String match) {
		this.match = match;
	}


	/**
	 * @return the match
	 */
	public String getMatch() {
		return match;
	}

}
