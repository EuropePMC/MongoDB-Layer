package uk.ac.ebi.literature.mongodb.model.citation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SearchTerms implements Serializable{
    
    List<SearchTerm> searchTerms;
    
    public SearchTerms() {
        super();
        this.searchTerms = new ArrayList<SearchTerm>();
     }

    public void setSearchTerms(List<SearchTerm> searchTerms) {
        this.searchTerms = searchTerms;
    }

    public List<SearchTerm> getSearchTerms() {
        return searchTerms;
    }
    

}
