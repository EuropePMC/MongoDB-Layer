package uk.ac.ebi.literature.mongodb.model.citation;

import java.io.Serializable;
import java.util.List;

/**
 * @author jyothi
 * 26 Jan 2011  17:07:30
 */
public class ExtCommentBean implements Serializable{

	private List<ExtComment> extComment;
	
	public ExtCommentBean() {
		super();
	}

	/**
	 * @param extCommentList the extCommentList to set
	 */
	public void setExtComment(List<ExtComment> extCommentList) {
		this.extComment = extCommentList;
	}

	/**
	 * @return the extCommentList
	 */
	public List<ExtComment> getExtComment() {
		return extComment;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((extComment == null) ? 0 : extComment.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof ExtCommentBean))
			return false;
		ExtCommentBean other = (ExtCommentBean) obj;
		if (extComment == null) {
			if (other.extComment != null)
				return false;
		} else if (!extComment.equals(other.extComment))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ExtCommentBean [extComment=" + extComment + "]";
	}

	


}
