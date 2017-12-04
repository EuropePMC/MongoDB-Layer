package uk.ac.ebi.literature.mongodb.model.citation;
 
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import uk.ac.ebi.literature.mongodb.util.MongoDBUtility;

/**
 * @author jyothi
 * 28 Feb 2011  15:25:00
 */
public class PatentClassifierList implements Serializable{

	private List<PatentClassifierInfo> classifier;
	
	public PatentClassifierList() {
		super();
		this.classifier = new ArrayList<PatentClassifierInfo>();
	}

	/**
	 * @param classifier the classifier to set
	 */
	public void setClassifier(List<PatentClassifierInfo> classifier) {
		this.classifier = classifier;
	}

	/**
	 * @return the classifier
	 */
	public List<PatentClassifierInfo> getClassifier() {
		return classifier;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((classifier == null) ? 0 : classifier.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof PatentClassifierList))
			return false;
		PatentClassifierList other = (PatentClassifierList) obj;
		if (classifier == null) {
			if (other.classifier != null)
				return false;
		} else if (!MongoDBUtility.equalsList(classifier,other.classifier))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PatentClassifierList [classifier=" + classifier + "]";
	}

	

}
