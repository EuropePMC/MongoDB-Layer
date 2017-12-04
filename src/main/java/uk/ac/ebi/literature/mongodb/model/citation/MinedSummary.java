package uk.ac.ebi.literature.mongodb.model.citation;

import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * @author jyothi
 * 7 Mar 2011  11:18:00
 */
@XmlType(name= "minedSummary", propOrder={"term", "count", "altNameList", "dbName", "dbIdList" })
// next line only for rest development
@JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)
public class MinedSummary implements Serializable{

	private String term;
	private int count;
	private MinedAltName altNameList;
	private String dbName;
	private MinedDbIDs dbIdList;
	
	public MinedSummary() {
		super();
	}
	/**
	 * @param name the name to set
	 */
	public void setTerm(String term) {
		this.term = term;
	}
	/**
	 * @return the name
	 */
	public String getTerm() {
		return term;
	}
	/**
	 * @param count the count to set
	 */
	public void setCount(int count) {
		this.count = count;
	}
	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}
	/**
	 * @param altNameList the altNameList to set
	 */
	public void setAltNameList(MinedAltName altNameList) {
		this.altNameList = altNameList;
	}
	/**
	 * @return the altNameList
	 */
	public MinedAltName getAltNameList() {
		return altNameList;
	}
	/**
	 * @param dbIdList the dbIdList to set
	 */
	public void setDbIdList(MinedDbIDs dbIdList) {
		this.dbIdList = dbIdList;
	}
	/**
	 * @return the dbIdList
	 */
	public MinedDbIDs getDbIdList() {
		return dbIdList;
	}
	/**
	 * @param db the db to set
	 */
	public void setDbName(String dbName) {
		this.dbName = dbName;
	}
	/**
	 * @return the db
	 */
	public String getDbName() {
		return dbName;
	}

}
