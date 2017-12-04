package uk.ac.ebi.literature.mongodb.model.citation;
 
/**
 * @author sharmila@ebi.ac.uk 23-Feb-2007  15:35:00
 */
public class Doc2LocResultBean {

    private String language;
    private String serviceProvider;
    private String format;
    private String url;
    private String type;
    private String id;
    private String source;
    private String service;
    private String availability;

    public Doc2LocResultBean() {
        super();
    }

    public void setLanguage(String language) {
        this.language = language;
    }
    public String getLanguage() {
        return this.language;
    }

    public void setServiceProvider(String serviceProvider) {
        this.serviceProvider = serviceProvider;
    }
    public String getServiceProvider() {
        return this.serviceProvider;
    }

    public void setFormat(String format) {
        this.format = format;
    }
    public String getFormat() {
        return this.format;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    public String getUrl() {
        return this.url;
    }

    public void setType(String type){
        this.type = type;
    }
    public String getType(){
        return this.type;
    }

    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return this.id;
    }

    public void setSource(String source){
        this.source = source;
    }
    public String getSource(){
        return this.source;
    }

    public void setService(String service){
        this.service = service;
    }
    public String getService() {
        return this.service;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }
    public String getAvailability(){
        return this.availability;
    }
}
