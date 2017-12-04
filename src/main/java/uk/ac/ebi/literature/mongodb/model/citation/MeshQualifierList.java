package uk.ac.ebi.literature.mongodb.model.citation;
 
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import uk.ac.ebi.literature.mongodb.util.MongoDBUtility;

/**
 * @author jyothi
 * 1 Mar 2011  11:25:11
 */
public class MeshQualifierList implements Serializable{

	private List<MeshQualifierInfo> meshQualifier;
	
	public MeshQualifierList() {
		super();
		this.meshQualifier = new ArrayList<MeshQualifierInfo>();
	}

	/**
	 * @param meshQualifier the meshQualifier to set
	 */
	public void setMeshQualifier(List<MeshQualifierInfo> meshQualifier) {
		this.meshQualifier = meshQualifier;
	}

	/**
	 * @return the meshQualifier
	 */
	public List<MeshQualifierInfo> getMeshQualifier() {
		return meshQualifier;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((meshQualifier == null) ? 0 : meshQualifier.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof MeshQualifierList))
			return false;
		MeshQualifierList other = (MeshQualifierList) obj;
		if (meshQualifier == null) {
			if (other.meshQualifier != null)
				return false;
		} else if (!MongoDBUtility.equalsList(meshQualifier,other.meshQualifier))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MeshQualifierList [meshQualifier=" + meshQualifier + "]";
	}

}
