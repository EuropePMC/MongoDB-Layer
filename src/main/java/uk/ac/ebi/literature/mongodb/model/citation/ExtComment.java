package uk.ac.ebi.literature.mongodb.model.citation;

import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * @author jyothi
 * 26 Jan 2011  16:55:33
 */
@XmlType (name = "extComment", propOrder = {"extCommentSource","info1","info2"})
// next line only for rest development
@JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)
public class ExtComment implements Serializable{

	private String extCommentSource;
	private String info1;
	private String info2;

	public ExtComment() {
		super();
	}

	/**
	 * @param extCommentSource the extCommentSource to set
	 */
	public void setExtCommentSource(String extCommentSource) {
		this.extCommentSource = extCommentSource;
	}

	/**
	 * @return the extCommentSource
	 */
	public String getExtCommentSource() {
		return extCommentSource;
	}

	/**
	 * @param info1 the info1 to set
	 */
	public void setInfo1(String info1) {
		this.info1 = info1;
	}

	/**
	 * @return the info1
	 */
	public String getInfo1() {
		return info1;
	}

	/**
	 * @param info2 the info2 to set
	 */
	public void setInfo2(String info2) {
		this.info2 = info2;
	}

	/**
	 * @return the info2
	 */
	public String getInfo2() {
		return info2;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((extCommentSource == null) ? 0 : extCommentSource.hashCode());
		result = prime * result + ((info1 == null) ? 0 : info1.hashCode());
		result = prime * result + ((info2 == null) ? 0 : info2.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof ExtComment))
			return false;
		ExtComment other = (ExtComment) obj;
		if (extCommentSource == null) {
			if (other.extCommentSource != null)
				return false;
		} else if (!extCommentSource.equals(other.extCommentSource))
			return false;
		if (info1 == null) {
			if (other.info1 != null)
				return false;
		} else if (!info1.equals(other.info1))
			return false;
		if (info2 == null) {
			if (other.info2 != null)
				return false;
		} else if (!info2.equals(other.info2))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ExtComment [extCommentSource=" + extCommentSource + ", info1=" + info1 + ", info2=" + info2 + "]";
	}

}
