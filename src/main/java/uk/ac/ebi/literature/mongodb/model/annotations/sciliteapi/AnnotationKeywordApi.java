package uk.ac.ebi.literature.mongodb.model.annotations.sciliteapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class AnnotationKeywordApi {
	
	public enum KW_TYPE{
		ANN_TYPE,
		ANN_ENTITY,
		ANN_PROVIDER,
		ANN_RELATION,
		ANN_SECTION_TYPE,
		ANN_SECTION
		
	}

	private String nm;
	
	private String val;
	
	private int count;
	
	private double uniqueCount;

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
	
	public AnnotationKeywordApi(String name, String value){
		this.setNm(name);
		this.setVal(value);
		this.setCount(1);
	}
	
	public AnnotationKeywordApi(){
		this.setCount(1);
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	public void incVal(){
		this.setCount(this.getCount() + 1);
	}

	public void decVal() {
		this.setCount(this.getCount() - 1);
		
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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof AnnotationKeywordApi))
			return false;
		AnnotationKeywordApi other = (AnnotationKeywordApi) obj;
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

	public double getUniqueCount() {
		return uniqueCount;
	}

	public void setUniqueCount(double uniqueCount) {
		this.uniqueCount = uniqueCount;
	}
	
	public void manageUniqueCount(Long uniqueCountIdVal){
		double nextUniqueCount= Double.parseDouble(this.getCount()+"."+uniqueCountIdVal);
		this.setUniqueCount(nextUniqueCount);
	}
}
