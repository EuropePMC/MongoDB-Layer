package uk.ac.ebi.literature.mongodb.model.citation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
 

/**
 * @author jyothi
 * 25 Feb 2011  11:57:39
 */
public class ResultList implements Serializable{
   
    private List<Result> result;
    
     public ResultList() {
        super();
        this.result = new ArrayList<Result>();
     }



	/**
	 * @param result the result to set
	 */
	public void setResult(List<Result> result) {
		this.result = result;
	}



	/**
	 * @return the result
	 */
	public List<Result> getResult() {
		return result;
	}

  
}
