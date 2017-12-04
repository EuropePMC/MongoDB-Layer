package uk.ac.ebi.literature.mongodb.model.citation;

import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import org.codehaus.jackson.map.annotate.JsonSerialize;
/**
 * @author jyothi
 * 1 Mar 2011  12:38:55
 */
@XmlType (name = "commentCorrection", propOrder = {"id","source","reference","type","note","orderIn"})
// next line only for rest development
@JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)
public class CommentCorrection implements Serializable{

	private String source;
    private String id;
    private String reference;
    private String type;
    private String note;
    private short orderIn;
    
   
    
	public CommentCorrection() {
		super();
	}

	/**
	 * @param source the source to set
	 */
	public void setSource(String source) {
		this.source = source;
	}

	/**
	 * @return the source
	 */
	public String getSource() {
		return source;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}


	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}


	/**
	 * @param reference the reference to set
	 */
	public void setReference(String reference) {
		this.reference = reference;
	}


	/**
	 * @return the reference
	 */
	public String getReference() {
		return reference;
	}


	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}


	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}


	/**
	 * @param orderIn the orderIn to set
	 */
	public void setOrderIn(short orderIn) {
		this.orderIn = orderIn;
	}


	/**
	 * @return the orderIn
	 */
	public short getOrderIn() {
		return orderIn;
	}


	/**
	 * @param note the note to set
	 */
	public void setNote(String note) {
		this.note = note;
	}


	/**
	 * @return the note
	 */
	public String getNote() {
		return note;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((note == null) ? 0 : note.hashCode());
		result = prime * result + orderIn;
		result = prime * result + ((reference == null) ? 0 : reference.hashCode());
		result = prime * result + ((source == null) ? 0 : source.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof CommentCorrection))
			return false;
		CommentCorrection other = (CommentCorrection) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (note == null) {
			if (other.note != null)
				return false;
		} else if (!note.equals(other.note))
			return false;
		if (orderIn != other.orderIn)
			return false;
		if (reference == null) {
			if (other.reference != null)
				return false;
		} else if (!reference.equals(other.reference))
			return false;
		if (source == null) {
			if (other.source != null)
				return false;
		} else if (!source.equals(other.source))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CommentCorrection [source=" + source + ", id=" + id + ", reference=" + reference + ", type=" + type
				+ ", note=" + note + ", orderIn=" + orderIn + "]";
	}

}
