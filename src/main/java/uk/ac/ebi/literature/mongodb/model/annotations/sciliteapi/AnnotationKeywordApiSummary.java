package uk.ac.ebi.literature.mongodb.model.annotations.sciliteapi;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class AnnotationKeywordApiSummary {

	private String nm;
	
	private String val;
	
	private int count;
	
	private int progressiveNumber;

	public String getNm() {
		return nm;
	}

	public void setNm(String name) {
		this.nm = name;
	}

	public String getVal() {
		return val;
	}

	public void setVal(String value) {
		this.val = value;
	}
	
	public AnnotationKeywordApiSummary(AnnotationKeywordApi keyword){
		this.setNm(keyword.getNm());
		this.setVal(keyword.getVal());
		this.setCount(keyword.getCount());
		this.setProgressiveNumber(0);
	}
	
	public AnnotationKeywordApiSummary(){
		this.setCount(1);
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getProgressiveNumber() {
		return progressiveNumber;
	}

	public void setProgressiveNumber(int progressiveNumber) {
		this.progressiveNumber = progressiveNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + count;
		result = prime * result + ((nm == null) ? 0 : nm.hashCode());
		result = prime * result + ((val == null) ? 0 : val.hashCode());
		return result;
	}
	
	@JsonIgnore
	@com.fasterxml.jackson.annotation.JsonIgnore
	public double getNextUniqueCount(){
		progressiveNumber = progressiveNumber + 1;
		if (progressiveNumber%10==0){
			progressiveNumber = progressiveNumber + 1;
		}
		
		double nextUniqueCount= Double.parseDouble(this.getCount()+"."+this.getProgressiveNumber());
		return nextUniqueCount;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof AnnotationKeywordApiSummary))
			return false;
		AnnotationKeywordApiSummary other = (AnnotationKeywordApiSummary) obj;
		if (count != other.count)
			return false;
		if (nm == null) {
			if (other.nm != null)
				return false;
		} else if (!nm.equals(other.nm))
			return false;
		if (val == null) {
			if (other.val != null)
				return false;
		} else if (!val.equals(other.val))
			return false;
		return true;
	}
	
	
	/**public boolean isKeywordCompatible(AnnotationKeywordApi keyword){
		return ((keyword.getCount()==this.getCount()) && (keyword.getNm().equalsIgnoreCase(this.getNm())) &&  (keyword.getVal().equalsIgnoreCase(this.getVal())));
	}*/
	
}
