package uk.ac.ebi.literature.mongodb.model.citation;


import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * @author jyothi
 *         25 Feb 2011  12:00:49
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseWrapper implements Serializable {
    private Integer hitCount;
    private String nextCursorMark;
    private String version;
    private Request request;

    //modules
    private ResultList resultList;
    private CitationList citationList;
    private ReferencesList referenceList;
    private MinedTermsList semanticTypeList;
    private DbCrossReferenceList dbCrossReferenceList;
    private ProfileListBean profileList;
    private SearchTerms searchTermList;
    private LabsProviders providers;

    // count headers
    private DbCountList dbCountList;
    private SemanticTypeCounts semanticTypeCountList;
    private LabsProviderCountList linksCountList;
    public ResponseWrapper() {
        this.version = "5.0";
    }

    /**
     * @return the hitCount
     */
    public Integer getHitCount() {
        return hitCount;
    }

    /**
     * @param hitCount the hitCount to set
     */
    public void setHitCount(Integer hitCount) {
        this.hitCount = hitCount;
    }

    /**
     * @return the nextCursorMark
     */
    public String getNextCursorMark() {
        return nextCursorMark;
    }

    /**
     * @param nextCursorMark the nextCursorMark to set
     */
    public void setNextCursorMark(String nextCursorMark) {
        this.nextCursorMark = nextCursorMark;
    }

    /**
     * @return the version
     */
    public String getVersion() {
        return version;
    }

    /**
     * @param version the version to set
     */
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * @return the request
     */
    public Request getRequest() {
        return request;
    }

    /**
     * @param request the request to set
     */
    public void setRequest(Request request) {
        this.request = request;
    }

    /**
     * @return the resultList
     */
    public ResultList getResultList() {
        return resultList;
    }

    /**
     * @param resultList the resultList to set
     */
    public void setResultList(ResultList resultList) {
        this.resultList = resultList;
    }

    /**
     * @return the citationList
     */
    public CitationList getCitationList() {
        return citationList;
    }

    /**
     * @param citationList the citationList to set
     */
    public void setCitationList(CitationList citationList) {
        this.citationList = citationList;
    }

    /**
     * @return the referenceList
     */
    public ReferencesList getReferenceList() {
        return referenceList;
    }

    /**
     * @param referenceList the referenceList to set
     */
    public void setReferenceList(ReferencesList referenceList) {
        this.referenceList = referenceList;
    }

    /**
     * @param semanticTypeList the semanticTypeList to set
     */
    public void setSemanticTypeList(MinedTermsList semanticTypeList) {
        this.semanticTypeList = semanticTypeList;
    }

    /**
     * @return the semanticTypeList
     */
    public MinedTermsList getSemanticTypeList() {
        return semanticTypeList;
    }

    /**
     * @return the dbCrossReferenceList
     */
    public DbCrossReferenceList getDbCrossReferenceList() {
        return dbCrossReferenceList;
    }

    /**
     * @param dbCrossReferenceList the dbCrossReferenceList to set
     */
    public void setDbCrossReferenceList(DbCrossReferenceList dbCrossReferenceList) {
        this.dbCrossReferenceList = dbCrossReferenceList;
    }

    /**
     * @return the profileList
     */
    public ProfileListBean getProfileList() {
        return profileList;
    }

    /**
     * @param profileList the profileList to set
     */
    public void setProfileList(ProfileListBean profileList) {
        this.profileList = profileList;
    }

    /**
     * @return the searchTermList
     */
    public SearchTerms getSearchTermList() {
        return searchTermList;
    }

    /**
     * @param searchTermList the searchTermList to set
     */
    public void setSearchTermList(SearchTerms searchTermList) {
        this.searchTermList = searchTermList;
    }

    /**
     * @param semanticTypeCountList the semanticTypeCountList to set
     */
    public void setSemanticTypeCountList(SemanticTypeCounts semanticTypeCountList) {
        this.semanticTypeCountList = semanticTypeCountList;
    }

    /**
     * @return the semanticTypeCountList
     */
    public SemanticTypeCounts getSemanticTypeCountList() {
        return semanticTypeCountList;
    }

    /**
     * @param dbCountList the dbCountList to set
     */
    public void setDbCountList(DbCountList dbCountList) {
        this.dbCountList = dbCountList;
    }

    /**
     * @return the dbCountList
     */
    public DbCountList getDbCountList() {
        return dbCountList;
    }

    /**
     * @return the providers
     */
    public LabsProviders getProviders() {
        return providers;
    }

    /**
     * @param providers the providers to set
     */
    public void setProviders(LabsProviders providers) {
        this.providers = providers;
    }

    /**
     * @return the linksCountList
     */
    public LabsProviderCountList getLinksCountList() {
        return linksCountList;
    }

    /**
     * @param linksCountList the linksCountList to set
     */
    public void setLinksCountList(LabsProviderCountList linksCountList) {
        this.linksCountList = linksCountList;
    }


}
