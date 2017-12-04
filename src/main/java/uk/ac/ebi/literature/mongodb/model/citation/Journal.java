package uk.ac.ebi.literature.mongodb.model.citation;

import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * @author jyothi
 * 11 May 2012  11:57:10
 */
@XmlType (name = "journal", propOrder =  {"title","ISOAbbreviation","medlineAbbreviation","NLMid","ISSN","ESSN"})
// next line only for rest development
@JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)
public class Journal implements Serializable{

	private String ESSN;
	private String ISOAbbreviation;
	private String ISSN;
	private String medlineAbbreviation;
	private String NLMid;
	private String title;

   public Journal() {
      super();
   }

/**
 * @return the eSSN
 */
public String getESSN() {
	return ESSN;
}

/**
 * @param eSSN the eSSN to set
 */
public void setESSN(String eSSN) {
	ESSN = eSSN;
}

/**
 * @return the iSOAbbreviation
 */
public String getISOAbbreviation() {
	return ISOAbbreviation;
}

/**
 * @param iSOAbbreviation the iSOAbbreviation to set
 */
public void setISOAbbreviation(String iSOAbbreviation) {
	ISOAbbreviation = iSOAbbreviation;
}

/**
 * @return the iSSN
 */
public String getISSN() {
	return ISSN;
}

/**
 * @param iSSN the iSSN to set
 */
public void setISSN(String iSSN) {
	ISSN = iSSN;
}

/**
 * @return the medlineAbbreviation
 */
public String getMedlineAbbreviation() {
	return medlineAbbreviation;
}

/**
 * @param medlineAbbreviation the medlineAbbreviation to set
 */
public void setMedlineAbbreviation(String medlineAbbreviation) {
	this.medlineAbbreviation = medlineAbbreviation;
}

/**
 * @return the nLMid
 */
public String getNLMid() {
	return NLMid;
}

/**
 * @param nLMid the nLMid to set
 */
public void setNLMid(String nLMid) {
	NLMid = nLMid;
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

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((ESSN == null) ? 0 : ESSN.hashCode());
	result = prime * result + ((ISOAbbreviation == null) ? 0 : ISOAbbreviation.hashCode());
	result = prime * result + ((ISSN == null) ? 0 : ISSN.hashCode());
	result = prime * result + ((NLMid == null) ? 0 : NLMid.hashCode());
	result = prime * result + ((medlineAbbreviation == null) ? 0 : medlineAbbreviation.hashCode());
	result = prime * result + ((title == null) ? 0 : title.hashCode());
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (!(obj instanceof Journal))
		return false;
	Journal other = (Journal) obj;
	if (ESSN == null) {
		if (other.ESSN != null)
			return false;
	} else if (!ESSN.equals(other.ESSN))
		return false;
	if (ISOAbbreviation == null) {
		if (other.ISOAbbreviation != null)
			return false;
	} else if (!ISOAbbreviation.equals(other.ISOAbbreviation))
		return false;
	if (ISSN == null) {
		if (other.ISSN != null)
			return false;
	} else if (!ISSN.equals(other.ISSN))
		return false;
	if (NLMid == null) {
		if (other.NLMid != null)
			return false;
	} else if (!NLMid.equals(other.NLMid))
		return false;
	if (medlineAbbreviation == null) {
		if (other.medlineAbbreviation != null)
			return false;
	} else if (!medlineAbbreviation.equals(other.medlineAbbreviation))
		return false;
	if (title == null) {
		if (other.title != null)
			return false;
	} else if (!title.equals(other.title))
		return false;
	return true;
}

@Override
public String toString() {
	return "Journal [ESSN=" + ESSN + ", ISOAbbreviation=" + ISOAbbreviation + ", ISSN=" + ISSN
			+ ", medlineAbbreviation=" + medlineAbbreviation + ", NLMid=" + NLMid + ", title=" + title + "]";
}

   
}
