package uk.ac.ebi.literature.mongodb.model.citation;

import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.codehaus.jackson.map.annotate.JsonSerialize;
 
/**
 * @author jyothi
 * 1 Mar 2011  15:40:23
 */
@XmlType (name = "dbCrossReference", propOrder = {"dbName","dbCount","dbCrossReferenceInfo"})
// next line only for rest development
@JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)
public class DbCrossReference implements Serializable{

	private String dbName;
	private int dbCount;
	private List<DbCrossReferenceInfo> dbCrossReferenceInfo;
	
	public DbCrossReference() {
		super();
		this.dbCrossReferenceInfo = new ArrayList<DbCrossReferenceInfo>();
	}

	/**
	 * @param dbName the dbName to set
	 */
	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	/**
	 * @return the dbName
	 */
	public String getDbName() {
		return dbName;
	}

	
	/**
	 * @return the dbCount
	 */
	public int getDbCount() {
		return dbCount;
	}

	/**
	 * @param dbCount the dbCount to set
	 */
	public void setDbCount(int dbCount) {
		this.dbCount = dbCount;
	}

	/**
	 * @return the dbCrossReferenceInfo
	 */
	public List<DbCrossReferenceInfo> getDbCrossReferenceInfo() {
		return dbCrossReferenceInfo;
	}

	/**
	 * @param dbCrossReferenceInfo the dbCrossReferenceInfo to set
	 */
	public void setDbCrossReferenceInfo(
			List<DbCrossReferenceInfo> dbCrossReferenceInfo) {
		this.dbCrossReferenceInfo = dbCrossReferenceInfo;
	}

}
