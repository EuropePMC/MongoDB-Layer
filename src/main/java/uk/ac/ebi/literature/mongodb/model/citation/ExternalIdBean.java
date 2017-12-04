package uk.ac.ebi.literature.mongodb.model.citation;

public class ExternalIdBean {
    private String externalId;
    private String source;

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSource() {
        return source;
    }
}
