package uk.ac.ebi.literature.mongodb.model.citation;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.xml.bind.annotation.XmlAttachmentRef;
import java.io.Serializable;
import java.util.Date;

/**
 * This class represents a citation and is the central bean
 *
 * @author jyothi
 * 25 Feb 2011  11:58:35
 */


@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)

public class Result implements Serializable {

    @JsonIgnore
    private Object _id;

    private String abstractText;
    private String affiliation;
    private AuthorsList authorList;
    private AuthorIdsList authorIdList;
    private String hasData;
    private String authorString;
    private BookOrReportDetails bookOrReportDetails;
    private String brSummary;
    private ChemicalList chemicalList;
    private Integer citationId;
    private Integer citedByCount;
    private CommentCorrectionList commentCorrectionList;
    private String dateOfCompletion;
    private String dateOfCreation;
    private String dateOfRevision;
    private String electronicPublicationDate;
    private String firstPublicationDate;
    private String embargoDate;
    private String doi;
    // CRD links
    private ExtCommentBean extCommentList;
    private javax.activation.DataHandler fullText;
    private FullTextUrlList fullTextUrlList;
    private GrantsList grantsList;
    private String hasTMAccessionNumbers;
    private TMAccessionTypeList tmAccessionTypeList;
    private String hasReferences;
    private String hasTextMinedTerms;
    private String hasDbCrossReferences;
    private String hasSupplementary;
    private String hasPDF;
    private String hasFullTextXML;
    private String hasLabsLinks;
    private CrossReferencesList dbCrossReferenceList;
    private String id;
    private String inPMC;
    private String inEPMC;
    private InvestigatorList investigatorList;
    private String isOpenAccess;
    private String issue;
    private String journalIssn;
    private JournalInfo journalInfo;
    private String journalTitle;
    private String journalVolume;
    private KeywordList keywordList;
    private String language;
    private String luceneScore;
    private MeshHeadingsList meshHeadingList;
    private String pageInfo;
    private PatentDetailsInfo patentDetails;
    private String pmcid;
    private String pmid;
    private String pubModel;
    private String pubType;
    private PubTypeList pubTypeList;
    private String pubYear;
    private String source;
    private SubSetList subsetList;
    private javax.activation.DataHandler supplementaryFiles;
    private String fullTextXML;
    private String title;
    private String hasBook;
    private String bookid;
    private String hasSuppl;
    private String license;
    private String authMan;
    private String epmcAuthMan;
    private String nihAuthMan;
    private String manuscriptId;
    private Date dateUpdated;

    /**
     * Constructor - initilaize collections
     */
    public Result() {
        super();
    }

    public String getHasData() {
        return hasData;
    }

    public void setHasData(String hasData) {
        this.hasData = hasData;
    }

    /**
     * @return the hasTMAccessionNumbers
     */
    public String getHasTMAccessionNumbers() {
        return hasTMAccessionNumbers;
    }

    /**
     * @param hasTMAccessionNumbers the hasTMAccessionNumbers to set
     */
    public void setHasTMAccessionNumbers(String hasTMAccessionNumbers) {
        this.hasTMAccessionNumbers = hasTMAccessionNumbers;
    }

    public TMAccessionTypeList getTmAccessionTypeList() {
        return tmAccessionTypeList;
    }

    public void setTmAccessionTypeList(TMAccessionTypeList tmAccessionTypeList) {
        this.tmAccessionTypeList = tmAccessionTypeList;
    }

    /**
     * @return the abstractText
     */
    public String getAbstractText() {
        return abstractText;
    }

    /**
     * @param abstractText the abstractText to set
     */
    public void setAbstractText(String abstractText) {
        this.abstractText = abstractText;
    }

    /**
     * @return the affiliation
     */
    public String getAffiliation() {
        return affiliation;
    }

    /**
     * @param affiliation the affiliation to set
     */
    public void setAffiliation(String affiliation) {
        this.affiliation = affiliation;
    }

    /**
     * @return the authorList
     */
    public AuthorsList getAuthorList() {
        return authorList;
    }

    /**
     * @param authorList the authorList to set
     */
    public void setAuthorList(AuthorsList authorList) {
        this.authorList = authorList;
    }

    public AuthorIdsList getAuthorIdList() {
        return authorIdList;
    }

    /**
     * @param authorIdList
     */
    public void setAuthorIdList(AuthorIdsList authorIdList) {
        this.authorIdList = authorIdList;
    }

    /**
     * @return the authorString
     */
    public String getAuthorString() {
        return authorString;
    }

    /**
     * @param authorString the authorString to set
     */
    public void setAuthorString(String authorString) {
        this.authorString = authorString;
    }

    /**
     * @return the investigatorList
     */
    public InvestigatorList getInvestigatorList() {
        return investigatorList;
    }

    /**
     * @param investigatorList the investigatorList to set
     */
    public void setInvestigatorList(InvestigatorList investigatorList) {
        this.investigatorList = investigatorList;
    }

    /**
     * @return the bookOrReportDetails
     */
    public BookOrReportDetails getBookOrReportDetails() {
        return bookOrReportDetails;
    }

    /**
     * @param bookOrReportDetails the bookOrReportDetails to set
     */
    public void setBookOrReportDetails(BookOrReportDetails bookOrReportDetails) {
        this.bookOrReportDetails = bookOrReportDetails;
    }

    /**
     * @return the brSummary
     */
    public String getBrSummary() {
        return brSummary;
    }

    /**
     * @param brSummary the brSummary to set
     */
    public void setBrSummary(String brSummary) {
        this.brSummary = brSummary;
    }

    /**
     * @return the chemicalList
     */
    public ChemicalList getChemicalList() {
        return chemicalList;
    }

    /**
     * @param chemicalList the chemicalList to set
     */
    public void setChemicalList(ChemicalList chemicalList) {
        this.chemicalList = chemicalList;
    }

    /**
     * @return the citationId
     */
    public Integer getCitationId() {
        return citationId;
    }

    /**
     * @param citationId the citationId to set
     */
    public void setCitationId(Integer citationId) {
        this.citationId = citationId;
    }

    /**
     * @return the citedByCount
     */
    public Integer getCitedByCount() {
        return citedByCount;
    }

    /**
     * @param citedByCount the citedByCount to set
     */
    public void setCitedByCount(Integer citedByCount) {
        this.citedByCount = citedByCount;
    }

    /**
     * @return the commentCorrectionList
     */
    public CommentCorrectionList getCommentCorrectionList() {
        return commentCorrectionList;
    }

    /**
     * @param commentCorrectionList the commentCorrectionList to set
     */
    public void setCommentCorrectionList(CommentCorrectionList commentCorrectionList) {
        this.commentCorrectionList = commentCorrectionList;
    }


    /**
     * @return the dateOfCompletion
     */
    public String getDateOfCompletion() {
        return dateOfCompletion;
    }

    /**
     * @param dateOfCompletion the dateOfCompletion to set
     */
    public void setDateOfCompletion(String dateOfCompletion) {
        this.dateOfCompletion = dateOfCompletion;
    }

    /**
     * @return the dateOfCreation
     */
    public String getDateOfCreation() {
        return dateOfCreation;
    }

    /**
     * @param dateOfCreation the dateOfCreation to set
     */
    public void setDateOfCreation(String dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    /**
     * @return the dateOfRevision
     */
    public String getDateOfRevision() {
        return dateOfRevision;
    }

    /**
     * @param dateOfRevision the dateOfRevision to set
     */
    public void setDateOfRevision(String dateOfRevision) {
        this.dateOfRevision = dateOfRevision;
    }

    /**
     * @return the doi
     */
    public String getDoi() {
        return doi;
    }

    /**
     * @param doi the doi to set
     */
    public void setDoi(String doi) {
        this.doi = doi;
    }

    /**
     * @return the extCommentList
     */
    public ExtCommentBean getExtCommentList() {
        return extCommentList;
    }

    /**
     * @param extCommentList the extCommentList to set
     */
    public void setExtCommentList(ExtCommentBean extCommentList) {
        this.extCommentList = extCommentList;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the fullText
     */
    @XmlAttachmentRef
    public javax.activation.DataHandler getFullText() {
        return fullText;
    }

    /**
     * @param fullText the fullText to set
     */
    public void setFullText(javax.activation.DataHandler fullText) {
        this.fullText = fullText;
    }

    /**
     * @return the fullTextUrlList
     */
    public FullTextUrlList getFullTextUrlList() {
        return fullTextUrlList;
    }

    /**
     * @param fullTextUrlList the fullTextUrlList to set
     */
    public void setFullTextUrlList(FullTextUrlList fullTextUrlList) {
        this.fullTextUrlList = fullTextUrlList;
    }

    /**
     * @return the grantsList
     */
    public GrantsList getGrantsList() {
        return grantsList;
    }

    /**
     * @param grantsList the grantsList to set
     */
    public void setGrantsList(GrantsList grantsList) {
        this.grantsList = grantsList;
    }


    /**
     * @return the hasReferences
     */
    public String getHasReferences() {
        return hasReferences;
    }

    /**
     * @param hasReferences the hasReferences to set
     */
    public void setHasReferences(String hasReferences) {
        this.hasReferences = hasReferences;
    }

    /**
     * @return the hasTextMinedTerms
     */
    public String getHasTextMinedTerms() {
        return hasTextMinedTerms;
    }

    /**
     * @param hasTextMinedTerms the hasTextMinedTerms to set
     */
    public void setHasTextMinedTerms(String hasTextMinedTerms) {
        this.hasTextMinedTerms = hasTextMinedTerms;
    }

    /**
     * @return the hasDbCrossReferences
     */
    public String getHasDbCrossReferences() {
        return hasDbCrossReferences;
    }

    /**
     * @param hasDbCrossReferences the hasDbCrossReferences to set
     */
    public void setHasDbCrossReferences(String hasDbCrossReferences) {
        this.hasDbCrossReferences = hasDbCrossReferences;
    }

    /**
     * @return the dbCrossReferencesList
     */
    public CrossReferencesList getDbCrossReferenceList() {
        return dbCrossReferenceList;
    }

    /**
     * @param dbCrossReferenceList the dbCrossReferencesList to set
     */
    public void setDbCrossReferenceList(CrossReferencesList dbCrossReferenceList) {
        this.dbCrossReferenceList = dbCrossReferenceList;
    }

    /**
     * @return the hasSupplementary
     */
    public String getHasSupplementary() {
        return hasSupplementary;
    }

    /**
     * @param hasSupplementary the hasSupplementary to set
     */
    public void setHasSupplementary(String hasSupplementary) {
        this.hasSupplementary = hasSupplementary;
    }

    /**
     * @return the hasPDF
     */
    public String getHasPDF() {
        return hasPDF;
    }

    /**
     * @param hasPDF the hasPDF to set
     */
    public void setHasPDF(String hasPDF) {
        this.hasPDF = hasPDF;
    }

    /**
     * @return the hasFullTextXML
     */
    public String getHasFullTextXML() {
        return hasFullTextXML;
    }

    /**
     * @param hasFullTextXML the hasFullTextXML to set
     */
    public void setHasFullTextXML(String hasFullTextXML) {
        this.hasFullTextXML = hasFullTextXML;
    }

    /**
     * @return the inPmc
     */
    public String getInPMC() {
        return inPMC;
    }

    /**
     * @param inPMC the inPmc to set
     */
    public void setInPMC(String inPMC) {
        this.inPMC = inPMC;
    }

    /**
     * @return the inUkpmc
     */
    public String getInEPMC() {
        return inEPMC;
    }

    /**
     * @param inEPMC the inUkpmc to set
     */
    public void setInEPMC(String inEPMC) {
        this.inEPMC = inEPMC;
    }

    /**
     * @return the isOpenAccess
     */
    public String getIsOpenAccess() {
        return isOpenAccess;
    }

    /**
     * @param isOpenAccess the isOpenAccess to set
     */
    public void setIsOpenAccess(String isOpenAccess) {
        this.isOpenAccess = isOpenAccess;
    }

    /**
     * @return the issue
     */
    public String getIssue() {
        return issue;
    }

    /**
     * @param issue the issue to set
     */
    public void setIssue(String issue) {
        this.issue = issue;
    }

    /**
     * @return the journalIssn
     */
    public String getJournalIssn() {
        return journalIssn;
    }

    /**
     * @param journalIssn the journalIssn to set
     */
    public void setJournalIssn(String journalIssn) {
        this.journalIssn = journalIssn;
    }

    /**
     * @return the journalIssue
     */
    public JournalInfo getJournalInfo() {
        return journalInfo;
    }

    /**
     * @param journalInfo the journalIssue to set
     */
    public void setJournalInfo(JournalInfo journalInfo) {
        this.journalInfo = journalInfo;
    }

    /**
     * @return the journalTitle
     */
    public String getJournalTitle() {
        return journalTitle;
    }

    /**
     * @param journalTitle the journalTitle to set
     */
    public void setJournalTitle(String journalTitle) {
        this.journalTitle = journalTitle;
    }

    /**
     * @return the journalVolume
     */
    public String getJournalVolume() {
        return journalVolume;
    }

    /**
     * @param journalVolume the journalVolume to set
     */
    public void setJournalVolume(String journalVolume) {
        this.journalVolume = journalVolume;
    }

    /**
     * @return the keywordList
     */
    public KeywordList getKeywordList() {
        return keywordList;
    }

    /**
     * @param keywordList the keywordList to set
     */
    public void setKeywordList(KeywordList keywordList) {
        this.keywordList = keywordList;
    }

    /**
     * @return the language
     */
    public String getLanguage() {
        return language;
    }

    /**
     * @param language the language to set
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * @return the luceneScore
     */
    public String getLuceneScore() {
        return luceneScore;
    }

    /**
     * @param luceneScore the luceneScore to set
     */
    public void setLuceneScore(String luceneScore) {
        this.luceneScore = luceneScore;
    }

    /**
     * @return the meshHeadingList
     */
    public MeshHeadingsList getMeshHeadingList() {
        return meshHeadingList;
    }

    /**
     * @param meshHeadingList the meshHeadingList to set
     */
    public void setMeshHeadingList(MeshHeadingsList meshHeadingList) {
        this.meshHeadingList = meshHeadingList;
    }

    /**
     * @return the pageInfo
     */
    public String getPageInfo() {
        return pageInfo;
    }

    /**
     * @param pageInfo the pageInfo to set
     */
    public void setPageInfo(String pageInfo) {
        this.pageInfo = pageInfo;
    }

    /**
     * @return the patentDetails
     */
    public PatentDetailsInfo getPatentDetails() {
        return patentDetails;
    }

    /**
     * @param patentDetails the patentDetails to set
     */
    public void setPatentDetails(PatentDetailsInfo patentDetails) {
        this.patentDetails = patentDetails;
    }

    /**
     * @return the pmcid
     */
    public String getPmcid() {
        return pmcid;
    }

    /**
     * @param pmcid the pmcid to set
     */
    public void setPmcid(String pmcid) {
        this.pmcid = pmcid;
    }

    /**
     * @return the pmid
     */
    public String getPmid() {
        return pmid;
    }

    /**
     * @param pmid the pmid to set
     */
    public void setPmid(String pmid) {
        this.pmid = pmid;
    }

    /**
     * @return the pubModel
     */
    public String getPubModel() {
        return pubModel;
    }

    /**
     * @param pubModel the pubModel to set
     */
    public void setPubModel(String pubModel) {
        this.pubModel = pubModel;
    }

    /**
     * @return the pubType
     */
    public String getPubType() {
        return pubType;
    }

    /**
     * @param pubType the pubType to set
     */
    public void setPubType(String pubType) {
        this.pubType = pubType;
    }

    /**
     * @return the pubTypeList
     */
    public PubTypeList getPubTypeList() {
        return pubTypeList;
    }

    /**
     * @param pubTypeList the pubTypeList to set
     */
    public void setPubTypeList(PubTypeList pubTypeList) {
        this.pubTypeList = pubTypeList;
    }

    /**
     * @return the pubYear
     */
    public String getPubYear() {
        return pubYear;
    }

    /**
     * @param pubYear the pubYear to set
     */
    public void setPubYear(String pubYear) {
        this.pubYear = pubYear;
    }

    /**
     * @return the source
     */
    public String getSource() {
        return source;
    }

    /**
     * @param source the source to set
     */
    public void setSource(String source) {
        this.source = source;
    }

    /**
     * @return the subsetList
     */
    public SubSetList getSubsetList() {
        return subsetList;
    }

    /**
     * @param subsetList the subsetList to set
     */
    public void setSubsetList(SubSetList subsetList) {
        this.subsetList = subsetList;
    }

    /**
     * @return the supplementaryFiles
     */
    @XmlAttachmentRef
    public javax.activation.DataHandler getSupplementaryFiles() {
        return supplementaryFiles;
    }

    /**
     * @param supplementaryFiles the supplementaryFiles to set
     */
    public void setSupplementaryFiles(
            javax.activation.DataHandler supplementaryFiles) {
        this.supplementaryFiles = supplementaryFiles;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the fullTextXML
     */
    public String getFullTextXML() {
        return fullTextXML;
    }

    /**
     * @param fullTextXML the fullTextXML to set
     */
    public void setFullTextXML(String fullTextXML) {
        this.fullTextXML = fullTextXML;
    }

    /**
     * @return the hasLabsLinks
     */
    public String getHasLabsLinks() {
        return hasLabsLinks;
    }

    /**
     * @param hasLabsLinks the hasLabsLinks to set
     */
    public void setHasLabsLinks(String hasLabsLinks) {
        this.hasLabsLinks = hasLabsLinks;
    }

    public String getElectronicPublicationDate() {
        return electronicPublicationDate;
    }

    public void setElectronicPublicationDate(String electronicPublicationDate) {
        this.electronicPublicationDate = electronicPublicationDate;
    }

    public String getFirstPublicationDate() {
        return firstPublicationDate;
    }

    public void setFirstPublicationDate(String firstPublicationDate) {
        this.firstPublicationDate = firstPublicationDate;
    }

    public String getEmbargoDate() {
        return embargoDate;
    }

    public void setEmbargoDate(String embargoDate) {
        this.embargoDate = embargoDate;
    }

    public String getHasBook() {
        return hasBook;
    }

    public void setHasBook(String hasBook) {
        this.hasBook = hasBook;
    }

    public String getBookid() {
        return bookid;
    }

    public void setBookid(String bookid) {
        this.bookid = bookid;
    }

    public String getHasSuppl() {
        return hasSuppl;
    }

    public void setHasSuppl(String hasSuppl) {
        this.hasSuppl = hasSuppl;
    }

    public String getAuthMan() {
        return authMan;
    }

    public void setAuthMan(String authMan) {
        this.authMan = authMan;
    }

    public String getEpmcAuthMan() {
        return epmcAuthMan;
    }

    public void setEpmcAuthMan(String epmcAuthMan) {
        this.epmcAuthMan = epmcAuthMan;
    }

    public String getNihAuthMan() {
        return nihAuthMan;
    }

    public void setNihAuthMan(String nihAuthMan) {
        this.nihAuthMan = nihAuthMan;
    }

    public String getManuscriptId() {
        return manuscriptId;
    }

    public void setManuscriptId(String manuscriptId) {
        this.manuscriptId = manuscriptId;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public Object get_id() {
        return _id;
    }

    public void set_id(Object _id) {
        this._id = _id;
    }

    public Date getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(Date dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

}

