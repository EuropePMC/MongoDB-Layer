package uk.ac.ebi.literature.mongodb.model.annotations.sciliteapi;

public enum AnnotationSectionApi {

	TITLE("Title"), 
	ABSTRACT("Abstract"), 
	INTRODUCTION("Introduction"), 
	METHODS("Methods"), 
	RESULTS("Results"), 
	DISCUSSION("Discussion"), 
	ACKNOWLEDGEMENTS("Acknowledgments"), 
	REFERENCES("References"),
	ARTICLE("Article"),
	TABLE("Table"),
	FIGURE("Figure"),
	CASE_STUDY("Case study"),
	SUPPLEMENTARY_MATERIAL("Supplementary material"),
	CONCLUSION("Conclusion"),
	ABBREVIATION("Abbreviations"),
	COMPETING_INTEREST("Competing Interests"),
	AUTHOR_CONTRIBUTIONS("Author Contributions"),
	UNSPECIFIED("");
	
	private String label;
	private AnnotationSectionApi(String label){
		this.label=label;
	}

	public String getLabel() {
		return this.label;
	}

	public static AnnotationSectionApi getByLabel(String label){
		AnnotationSectionApi ret = AnnotationSectionApi.UNSPECIFIED;
		for (AnnotationSectionApi val : AnnotationSectionApi.values()){
			if (val.getLabel().equalsIgnoreCase(label)){
				ret=val;
				break;
			}
		}
		return ret;
	}
	
}
