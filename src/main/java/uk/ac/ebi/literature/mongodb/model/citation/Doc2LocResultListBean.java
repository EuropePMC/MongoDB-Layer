package uk.ac.ebi.literature.mongodb.model.citation;

import java.util.List;
import java.util.ArrayList;

/**
 * @author sharmila@ebi.ac.uk 23-Feb-2007  15:38:54
 */
public class Doc2LocResultListBean {

    private List<Doc2LocResultBean> doc2LocResultBeanCollection;

    public Doc2LocResultListBean() {
        super();
        this.doc2LocResultBeanCollection = new ArrayList<Doc2LocResultBean>();
    }

    public List<Doc2LocResultBean> getDoc2LocResultBeanCollection() {
        return this.doc2LocResultBeanCollection;
    }

    public void setDoc2LocResultBeanCollection(List<Doc2LocResultBean> doc2LocResultBeanCollection ) {
        this.doc2LocResultBeanCollection = doc2LocResultBeanCollection;
    }
}
