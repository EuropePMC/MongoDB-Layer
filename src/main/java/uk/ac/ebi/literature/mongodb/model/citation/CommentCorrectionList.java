package uk.ac.ebi.literature.mongodb.model.citation;

import java.io.Serializable;
import java.util.List;

import uk.ac.ebi.literature.mongodb.util.MongoDBUtility;

/**
 * @author jyothi
 * 1 Mar 2011  12:37:19
 */
public class CommentCorrectionList implements Serializable{

	
	private List<CommentCorrection> commentCorrection;
	
	public CommentCorrectionList() {
		super();
	}

	/**
	 * @param commentsCorrection the commentsCorrection to set
	 */
	public void setCommentCorrection(List<CommentCorrection> commentCorrection) {
		this.commentCorrection = commentCorrection;
	}

	/**
	 * @return the commentsCorrection
	 */
	public List<CommentCorrection> getCommentCorrection() {
		return commentCorrection;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((commentCorrection == null) ? 0 : commentCorrection.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof CommentCorrectionList))
			return false;
		CommentCorrectionList other = (CommentCorrectionList) obj;
		if (commentCorrection == null) {
			if (other.commentCorrection != null)
				return false;
		} else if (!MongoDBUtility.equalsList(commentCorrection,other.commentCorrection))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CommentCorrectionList [commentCorrection=" + commentCorrection + "]";
	}
	
	

}
