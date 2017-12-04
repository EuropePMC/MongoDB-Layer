package uk.ac.ebi.literature.mongodb.model.annotations;

import java.io.Serializable;
import java.util.Date;

public class AnnotationData implements Serializable {

	private static final long serialVersionUID = 8907244299225460665L;
	
	private Long pmcid;

	private Date dateUpdated;
	
	public Long getPmcid() {
		return pmcid;
	}

	public void setPmcid(Long pmcid) {
		this.pmcid = pmcid;
	}

	public Date getDateUpdated() {
		return dateUpdated;
	}

	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

}
