package uk.ac.ebi.literature.mongodb.model.citation;

import java.io.Serializable;

/**
 * @author jyothi
 *
 */
public class LabsLinks implements Serializable{

	private String title;
	private String url;
	private String imgUrl;

    public LabsLinks() {
        super();
    }

	/**
	 *
	 * @return the image url
	 */
	public String getImgUrl() {
		return imgUrl;
	}

	/**
	 *
	 * @param imgUrl set the url to the image to display with the link
	 */
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

}
