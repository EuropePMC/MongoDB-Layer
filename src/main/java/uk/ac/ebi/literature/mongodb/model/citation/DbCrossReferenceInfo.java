package uk.ac.ebi.literature.mongodb.model.citation;

import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * @author jyothi
 * 1 Jun 2012  10:38:45
 */
@XmlType (name = "dbCrossReferenceInfo", propOrder = {"info1","info2","info3","info4"})
// next line only for rest development
@JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)
public class DbCrossReferenceInfo implements Serializable{

	private String info1;
	private String info2;
	private String info3;
	private String info4;
	
	public DbCrossReferenceInfo() {
		super();
	}

	/**
	 * @return the info1
	 */
	public String getInfo1() {
		return info1;
	}

	/**
	 * @param info1 the info1 to set
	 */
	public void setInfo1(String info1) {
		this.info1 = info1;
	}

	/**
	 * @return the info2
	 */
	public String getInfo2() {
		return info2;
	}

	/**
	 * @param info2 the info2 to set
	 */
	public void setInfo2(String info2) {
		this.info2 = info2;
	}

	/**
	 * @return the info3
	 */
	public String getInfo3() {
		return info3;
	}

	/**
	 * @param info3 the info3 to set
	 */
	public void setInfo3(String info3) {
		this.info3 = info3;
	}

	/**
	 * @return the info4
	 */
	public String getInfo4() {
		return info4;
	}

	/**
	 * @param info4 the info4 to set
	 */
	public void setInfo4(String info4) {
		this.info4 = info4;
	}

}
