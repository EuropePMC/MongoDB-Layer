package uk.ac.ebi.literature.mongodb.model.citation;

import java.io.Serializable;

/**
 * @author jyothi
 * 20 Jan 2011  13:25:13
 */
public class ProfileBean implements Serializable{

	   private ProfileListBean profileList;
	   
	   /**
	     * Constructor - initilaize collections
	     */
	    public ProfileBean() {
	        super();
	    }


	/**
	 * @param profileList the profileList to set
	 */
	public void setProfileList(ProfileListBean profileList) {
		this.profileList = profileList;
	}

	/**
	 * @return the profileList
	 */
	public ProfileListBean getProfileList() {
		return profileList;
	}
}
