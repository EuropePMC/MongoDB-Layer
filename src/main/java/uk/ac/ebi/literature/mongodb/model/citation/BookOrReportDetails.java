package uk.ac.ebi.literature.mongodb.model.citation;

import javax.xml.bind.annotation.XmlType;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import java.io.Serializable;

/**
 * @author jyothi
 * 25 Feb 2011  16:54:45
 */
@XmlType (name = "bookOrReportDetails", propOrder = {"publisher","dayOfPublication","monthOfPublication","yearOfPublication","numberOfPages","edition","isbn10",
										"isbn13","seriesName","seriesIssn","comprisingTitle","comprisingTitleNonAscii","extraInformation"})
// next line only for rest development
@JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)
public class BookOrReportDetails implements Serializable{

	    
	    private String edition;
	    private String extraInformation;
	    private String isbn10;
	    private String isbn13;
	    private String numberOfPages;
	    private String publisher;
	    private String seriesIssn;
	    private String seriesName;
	    private String comprisingTitle;
	    private String comprisingTitleNonAscii;
	    private Byte dayOfPublication;
	    private Byte monthOfPublication;
	    private Short yearOfPublication;
    
	public BookOrReportDetails() {
		super();
	}

	/**
	 * @param edition the edition to set
	 */
	public void setEdition(String edition) {
		this.edition = edition;
	}

	/**
	 * @return the edition
	 */
	public String getEdition() {
		return edition;
	}

	/**
	 * @param extraInformation the extraInformation to set
	 */
	public void setExtraInformation(String extraInformation) {
		this.extraInformation = extraInformation;
	}

	/**
	 * @return the extraInformation
	 */
	public String getExtraInformation() {
		return extraInformation;
	}

	/**
	 * @param isbn10 the isbn10 to set
	 */
	public void setIsbn10(String isbn10) {
		this.isbn10 = isbn10;
	}

	/**
	 * @return the isbn10
	 */
	public String getIsbn10() {
		return isbn10;
	}

	/**
	 * @param isbn13 the isbn13 to set
	 */
	public void setIsbn13(String isbn13) {
		this.isbn13 = isbn13;
	}

	/**
	 * @return the isbn13
	 */
	public String getIsbn13() {
		return isbn13;
	}

	/**
	 * @param numberOfPages the numberOfPages to set
	 */
	public void setNumberOfPages(String numberOfPages) {
		this.numberOfPages = numberOfPages;
	}

	/**
	 * @return the numberOfPages
	 */
	public String getNumberOfPages() {
		return numberOfPages;
	}

	/**
	 * @param publisher the publisher to set
	 */
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	/**
	 * @return the publisher
	 */
	public String getPublisher() {
		return publisher;
	}

	/**
	 * @param seriesIssn the seriesIssn to set
	 */
	public void setSeriesIssn(String seriesIssn) {
		this.seriesIssn = seriesIssn;
	}

	/**
	 * @return the seriesIssn
	 */
	public String getSeriesIssn() {
		return seriesIssn;
	}

	/**
	 * @param seriesName the seriesName to set
	 */
	public void setSeriesName(String seriesName) {
		this.seriesName = seriesName;
	}

	/**
	 * @return the seriesName
	 */
	public String getSeriesName() {
		return seriesName;
	}

	/**
	 * @param comprisingTitle the comprisingTitle to set
	 */
	public void setComprisingTitle(String comprisingTitle) {
		this.comprisingTitle = comprisingTitle;
	}

	/**
	 * @return the comprisingTitle
	 */
	public String getComprisingTitle() {
		return comprisingTitle;
	}

	/**
	 * @param comprisingTitleNonAscii the comprisingTitleNonAscii to set
	 */
	public void setComprisingTitleNonAscii(String comprisingTitleNonAscii) {
		this.comprisingTitleNonAscii = comprisingTitleNonAscii;
	}

	/**
	 * @return the comprisingTitleNonAscii
	 */
	public String getComprisingTitleNonAscii() {
		return comprisingTitleNonAscii;
	}

	/**
	 * @param dayOfPublication the dayOfPublication to set
	 */
	public void setDayOfPublication(Byte dayOfPublication) {
		this.dayOfPublication = dayOfPublication;
	}

	/**
	 * @return the dayOfPublication
	 */
	public Byte getDayOfPublication() {
		return dayOfPublication;
	}

	/**
	 * @param monthOfPublication the monthOfPublication to set
	 */
	public void setMonthOfPublication(Byte monthOfPublication) {
		this.monthOfPublication = monthOfPublication;
	}

	/**
	 * @return the monthOfPublication
	 */
	public Byte getMonthOfPublication() {
		return monthOfPublication;
	}

	/**
	 * @param yearOfPublication the yearOfPublication to set
	 */
	public void setYearOfPublication(Short yearOfPublication) {
		this.yearOfPublication = yearOfPublication;
	}

	/**
	 * @return the yearOfPublication
	 */
	public Short getYearOfPublication() {
		return yearOfPublication;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comprisingTitle == null) ? 0 : comprisingTitle.hashCode());
		result = prime * result + ((comprisingTitleNonAscii == null) ? 0 : comprisingTitleNonAscii.hashCode());
		result = prime * result + ((dayOfPublication == null) ? 0 : dayOfPublication.hashCode());
		result = prime * result + ((edition == null) ? 0 : edition.hashCode());
		result = prime * result + ((extraInformation == null) ? 0 : extraInformation.hashCode());
		result = prime * result + ((isbn10 == null) ? 0 : isbn10.hashCode());
		result = prime * result + ((isbn13 == null) ? 0 : isbn13.hashCode());
		result = prime * result + ((monthOfPublication == null) ? 0 : monthOfPublication.hashCode());
		result = prime * result + ((numberOfPages == null) ? 0 : numberOfPages.hashCode());
		result = prime * result + ((publisher == null) ? 0 : publisher.hashCode());
		result = prime * result + ((seriesIssn == null) ? 0 : seriesIssn.hashCode());
		result = prime * result + ((seriesName == null) ? 0 : seriesName.hashCode());
		result = prime * result + ((yearOfPublication == null) ? 0 : yearOfPublication.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof BookOrReportDetails))
			return false;
		BookOrReportDetails other = (BookOrReportDetails) obj;
		if (comprisingTitle == null) {
			if (other.comprisingTitle != null)
				return false;
		} else if (!comprisingTitle.equals(other.comprisingTitle))
			return false;
		if (comprisingTitleNonAscii == null) {
			if (other.comprisingTitleNonAscii != null)
				return false;
		} else if (!comprisingTitleNonAscii.equals(other.comprisingTitleNonAscii))
			return false;
		if (dayOfPublication == null) {
			if (other.dayOfPublication != null)
				return false;
		} else if (!dayOfPublication.equals(other.dayOfPublication))
			return false;
		if (edition == null) {
			if (other.edition != null)
				return false;
		} else if (!edition.equals(other.edition))
			return false;
		if (extraInformation == null) {
			if (other.extraInformation != null)
				return false;
		} else if (!extraInformation.equals(other.extraInformation))
			return false;
		if (isbn10 == null) {
			if (other.isbn10 != null)
				return false;
		} else if (!isbn10.equals(other.isbn10))
			return false;
		if (isbn13 == null) {
			if (other.isbn13 != null)
				return false;
		} else if (!isbn13.equals(other.isbn13))
			return false;
		if (monthOfPublication == null) {
			if (other.monthOfPublication != null)
				return false;
		} else if (!monthOfPublication.equals(other.monthOfPublication))
			return false;
		if (numberOfPages == null) {
			if (other.numberOfPages != null)
				return false;
		} else if (!numberOfPages.equals(other.numberOfPages))
			return false;
		if (publisher == null) {
			if (other.publisher != null)
				return false;
		} else if (!publisher.equals(other.publisher))
			return false;
		if (seriesIssn == null) {
			if (other.seriesIssn != null)
				return false;
		} else if (!seriesIssn.equals(other.seriesIssn))
			return false;
		if (seriesName == null) {
			if (other.seriesName != null)
				return false;
		} else if (!seriesName.equals(other.seriesName))
			return false;
		if (yearOfPublication == null) {
			if (other.yearOfPublication != null)
				return false;
		} else if (!yearOfPublication.equals(other.yearOfPublication))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BookOrReportDetails [edition=" + edition + ", extraInformation=" + extraInformation + ", isbn10="
				+ isbn10 + ", isbn13=" + isbn13 + ", numberOfPages=" + numberOfPages + ", publisher=" + publisher
				+ ", seriesIssn=" + seriesIssn + ", seriesName=" + seriesName + ", comprisingTitle=" + comprisingTitle
				+ ", comprisingTitleNonAscii=" + comprisingTitleNonAscii + ", dayOfPublication=" + dayOfPublication
				+ ", monthOfPublication=" + monthOfPublication + ", yearOfPublication=" + yearOfPublication + "]";
	}

}
