package uk.ac.ebi.literature.mongodb.model.citation;

import javax.xml.bind.annotation.XmlType;

@XmlType(name = "SearchTerm",
        propOrder = {"term"})

public class SearchTerm implements Comparable {
    String term;

    public void setTerm(String term) {
        this.term = term;
    }

    public String getTerm() {
        return term;
    }

    @Override
    public int compareTo(Object o) {
        return term.compareTo(((SearchTerm) o).getTerm());
    }


    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof SearchTerm)) {
            return false;
        }
        final SearchTerm other = (SearchTerm) object;
        if (!(term == null ? other.term == null : term.equals(other.term))) {
            return false;
        }
        return true;
    }

}

