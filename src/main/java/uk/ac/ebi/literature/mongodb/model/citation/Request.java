package uk.ac.ebi.literature.mongodb.model.citation;

import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * @author jyothi
 * 15 May 2012  11:38:47
 */
@XmlType(name = "request",
        propOrder = {"query", "internalQuery", "resultType", "profileType", "id", "source", "offSet", "cursorMark", "pageSize", "sort", "database", "semanticType", "synonym", "email", "providerId"})
public class Request implements Serializable {

    private String id;
    private String source;
    private String query;
	private String internalQuery;
	private String resultType;
	private String profileType;
	private String cursorMark;
    private Integer offSet;
	private Integer pageSize;
	private String sort;
	private Boolean synonym;
	private String email;
	private String database;
	private String semanticType;
	private String providerId;

    public Request() {
        super();
    }

    public Request(String requestedId, String source, String cursorMark, Integer pageSize, String providerId) {
        this.id = requestedId;
        this.source = source;
        this.cursorMark = cursorMark;
        this.pageSize = pageSize;
        this.providerId = providerId;
		this.offSet=null;
    }
	public Request(String requestedId, String source, Integer offSet, Integer pageSize, String providerId) {
		this.id = requestedId;
		this.source = source;
		this.offSet = offSet;
		this.pageSize = pageSize;
		this.providerId = providerId;
		this.cursorMark=null;
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
	 * @return the queryString
	 */
	public String getQuery() {
		return query;
	}

	/**
	 * @param queryString the queryString to set
	 */
	public void setQuery(String queryString) {
		this.query = queryString;
	}

    /**
   	 * @return the internalQuery
   	 */
    public String getInternalQuery() { return internalQuery; }
    /**
   	 * @param internalQuery the queryString to set
   	 */
    public void setInternalQuery(String internalQuery) { this.internalQuery = internalQuery; }

    /**
	 * @return the resultType
	 */
	public String getResultType() {
		return resultType;
	}

	/**
	 * @param resultType the resultType to set
	 */
	public void setResultType(String resultType) {
		this.resultType = resultType;
	}

	/**
	 * @param profileType the profileType to set
	 */
	public void setProfileType(String profileType) {
		this.profileType = profileType;
	}

	/**
	 * @return the profileType
	 */
	public String getProfileType() {
		return profileType;
	}

	/**
	 * @param offSet the offSet to set
	 */
	public void setOffSet(Integer offSet) {
		this.offSet = offSet;
	}

	/**
	 * @return the offSet
	 */
	public Integer getOffSet() {
		return offSet;
	}

	/**
	 * @param cursorMark the cursorMark to set
	 */
	public void setCursorMark(String cursorMark) {
		this.cursorMark = cursorMark;
	}

	/**
	 * @return the cursorMark
	 */
	public String getCursorMark() {
		return cursorMark;
	}

	/**
     * @param pageSize the pageSize to set
	 */
	public void setPageSize(Integer pageSize) { this.pageSize = pageSize;
	}

	/**
	 * @return the pageSize
	 */
	public Integer getPageSize() {
		return pageSize;
	}

	/**
     * @param sort the sort to set
	 */
	public void setSort(String sort) { this.sort = sort;
	}

	/**
	 * @return the sort
	 */
	public String getSort() {
		return sort;
	}

	 /**
	 * @return the synonym
	 */
	public Boolean getSynonym() {
		return synonym;
	}

	/**
	 * @param synonym the synonym to set
	 */
	public void setSynonym(Boolean synonym) {
		this.synonym = synonym;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @param database the database to set
	 */
	public void setDatabase(String database) {
		this.database = database;
	}

	/**
	 * @return the database
	 */
	public String getDatabase() {
		return database;
	}

	/**
	 * @param semanticType the semanticType to set
	 */
	public void setSemanticType(String semanticType) {
		this.semanticType = semanticType;
	}

	/**
	 * @return the semanticType
	 */
	public String getSemanticType() {
		return semanticType;
	}
	/**
	 * @return the providerId
	 */
	public String getProviderId() {
		return providerId;
	}
	/**
	 * @param providerId the providerId to set
	 */
	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}

}