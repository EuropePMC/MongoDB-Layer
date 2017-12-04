package uk.ac.ebi.literature.mongodb.model.citation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import uk.ac.ebi.literature.mongodb.util.MongoDBUtility;
 
/**
 * @author jyothi
 * 1 Mar 2011  11:20:46
 */
public class MeshHeadingsList implements Serializable{

	private List<MeshHeadingInfo> meshHeading;
	
	public MeshHeadingsList() {
		super();
		this.meshHeading = new ArrayList<MeshHeadingInfo>();
	}
	/**
	 * @param meshHeading the meshHeading to set
	 */
	public void setMeshHeading(List<MeshHeadingInfo> meshHeading) {
		this.meshHeading = meshHeading;
	}
	/**
	 * @return the meshHeading
	 */
	public List<MeshHeadingInfo> getMeshHeading() {
		return meshHeading;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((meshHeading == null) ? 0 : meshHeading.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof MeshHeadingsList))
			return false;
		MeshHeadingsList other = (MeshHeadingsList) obj;
		if (meshHeading == null) {
			if (other.meshHeading != null)
				return false;
		} else if (!MongoDBUtility.equalsList(meshHeading,other.meshHeading))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "MeshHeadingsList [meshHeading=" + meshHeading + "]";
	}

}
