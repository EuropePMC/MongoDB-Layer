package uk.ac.ebi.literature.mongodb.model.citation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jyothi
 * 1 Mar 2011  15:39:02
 */

public class DbCrossReferenceList implements Serializable{

    private List<DbCrossReference> dbCrossReference;    

    public DbCrossReferenceList() {
    	super();
    	this.dbCrossReference = new ArrayList<DbCrossReference>();
    }

    /**
     * @param dbCrossReference the dbCrossReference to set
     */
    public void setDbCrossReference(List<DbCrossReference> dbCrossReference) {
        this.dbCrossReference = dbCrossReference;
    }

    /**
     * @return the dbCrossReference
     */
    public List<DbCrossReference> getDbCrossReference() {
        return dbCrossReference;
    }

}
