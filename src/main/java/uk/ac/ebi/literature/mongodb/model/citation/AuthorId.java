package uk.ac.ebi.literature.mongodb.model.citation;

import java.io.Serializable;
import javax.xml.bind.annotation.*;

import org.codehaus.jackson.map.annotate.JsonSerialize;
/**
 * @author jyothi
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)
public class AuthorId implements Serializable{

	@XmlAttribute(name="type") 
	private String type;
	@XmlValue
	private String value;
	 
	 public AuthorId() {
			super();
		}

	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof AuthorId))
			return false;
		AuthorId other = (AuthorId) obj;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "AuthorId [type=" + type + ", value=" + value + "]";
	}
	
	
}
