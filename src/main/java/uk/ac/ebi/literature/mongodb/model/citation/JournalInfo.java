package uk.ac.ebi.literature.mongodb.model.citation;

import javax.xml.bind.annotation.XmlType;

import java.io.Serializable;

import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * @author jyothi
 * 27 Apr 2012  09:30:23
 */
@XmlType (name = "journalInfo", propOrder =  {"issue","volume","journalIssueId","dateOfPublication","monthOfPublication","yearOfPublication","printPublicationDate","journal"})
// next line only for rest development
@JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)
public class JournalInfo implements Serializable {

	private String issue;
	private String volume;
	private Integer journalIssueId;
	private String dateOfPublication;
	private Byte monthOfPublication;
	private Short yearOfPublication;
	private Journal journal;
	private String printPublicationDate ;
	
	public JournalInfo() {
		super();
	}

	/**
	 * @return the issue
	 */
	public String getIssue() {
		return issue;
	}

	/**
	 * @param issue the issue to set
	 */
	public void setIssue(String issue) {
		this.issue = issue;
	}

	/**
	 * @return the volume
	 */
	public String getVolume() {
		return volume;
	}

	/**
	 * @param volume the volume to set
	 */
	public void setVolume(String volume) {
		this.volume = volume;
	}

	/**
	 * @return the journalIssueId
	 */
	public Integer getJournalIssueId() {
		return journalIssueId;
	}

	/**
	 * @param journalIssueId the journalIssueId to set
	 */
	public void setJournalIssueId(Integer journalIssueId) {
		this.journalIssueId = journalIssueId;
	}

	/**
	 * @return the dateOfPublication
	 */
	public String getDateOfPublication() {
		return dateOfPublication;
	}

	/**
	 * @param dateOfPublication the dateOfPublication to set
	 */
	public void setDateOfPublication(String dateOfPublication) {
		this.dateOfPublication = dateOfPublication;
	}

	/**
	 * @return the monthOfPublication
	 */
	public Byte getMonthOfPublication() {
		return monthOfPublication;
	}

	/**
	 * @param monthOfPublication the monthOfPublication to set
	 */
	public void setMonthOfPublication(Byte monthOfPublication) {
		this.monthOfPublication = monthOfPublication;
	}

	/**
	 * @return the yearOfPublication
	 */
	public Short getYearOfPublication() {
		return yearOfPublication;
	}

	/**
	 * @param yearOfPublication the yearOfPublication to set
	 */
	public void setYearOfPublication(Short yearOfPublication) {
		this.yearOfPublication = yearOfPublication;
	}

	/**
	 * @return the journal
	 */
	public Journal getJournal() {
		return journal;
	}

	/**
	 * @param journal the journal to set
	 */
	public void setJournal(Journal journal) {
		this.journal = journal;
	}

	/**
	 * @return the printPublicationDate
	 */
	public String getPrintPublicationDate() {
		return printPublicationDate;
	}

	/**
	 * @param printPublicationDate the printPublicationDate to set
	 */
	public void setPrintPublicationDate(String printPublicationDate) {
		this.printPublicationDate = printPublicationDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateOfPublication == null) ? 0 : dateOfPublication.hashCode());
		result = prime * result + ((issue == null) ? 0 : issue.hashCode());
		result = prime * result + ((journal == null) ? 0 : journal.hashCode());
		result = prime * result + ((journalIssueId == null) ? 0 : journalIssueId.hashCode());
		result = prime * result + ((monthOfPublication == null) ? 0 : monthOfPublication.hashCode());
		result = prime * result + ((printPublicationDate == null) ? 0 : printPublicationDate.hashCode());
		result = prime * result + ((volume == null) ? 0 : volume.hashCode());
		result = prime * result + ((yearOfPublication == null) ? 0 : yearOfPublication.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof JournalInfo))
			return false;
		JournalInfo other = (JournalInfo) obj;
		if (dateOfPublication == null) {
			if (other.dateOfPublication != null)
				return false;
		} else if (!dateOfPublication.equals(other.dateOfPublication))
			return false;
		if (issue == null) {
			if (other.issue != null)
				return false;
		} else if (!issue.equals(other.issue))
			return false;
		if (journal == null) {
			if (other.journal != null)
				return false;
		} else if (!journal.equals(other.journal))
			return false;
		if (journalIssueId == null) {
			if (other.journalIssueId != null)
				return false;
		} else if (!journalIssueId.equals(other.journalIssueId))
			return false;
		if (monthOfPublication == null) {
			if (other.monthOfPublication != null)
				return false;
		} else if (!monthOfPublication.equals(other.monthOfPublication))
			return false;
		if (printPublicationDate == null) {
			if (other.printPublicationDate != null)
				return false;
		} else if (!printPublicationDate.equals(other.printPublicationDate))
			return false;
		if (volume == null) {
			if (other.volume != null)
				return false;
		} else if (!volume.equals(other.volume))
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
		return "JournalInfo [issue=" + issue + ", volume=" + volume + ", journalIssueId=" + journalIssueId
				+ ", dateOfPublication=" + dateOfPublication + ", monthOfPublication=" + monthOfPublication
				+ ", yearOfPublication=" + yearOfPublication + ", journal=" + journal + ", printPublicationDate="
				+ printPublicationDate + "]";
	}

}
