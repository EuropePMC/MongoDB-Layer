package uk.ac.ebi.literature.mongodb.model.annotations.sciliteapi;

public enum AnnotationTypeApi {

	GENES_PROTEINS("GENES_PROTEINS", false), 
	ORGANISMS("ORGANISMS", false), 
	CHEMICALS("CHEMICALS", false), 
	GO_TERMS("GO_TERMS", false), 
	DISEASE("DISEASE", false), 
	EFO("EFO", false), 
	ACCESSION_NUMBERS("ACCESSION_NUMBERS", false), 
	GENERIF("GENE_FUNCTION", false),
	GENE_DISEASE("GENE_DISEASE", true),
	PPI("PROTEIN_INTERACTION",false),
	BIOLOGICAL_EVENT("BIOLOGICAL_EVENT",false),
	GENETIC_VARIATION("GENETIC_VARIATION", false),
	TRANSCRIPTION_FACTOR_TARGET_GENE("TRANSCRIPTION_FACTOR_TARGET_GENE", true),
	UNKNOWN("UNKNOWN", false);
	
	private String label;
	private boolean relationship;
	private AnnotationTypeApi(String label, boolean relationship){
		this.label=label;
		this.relationship=relationship;
	}

	public String getLabel() {
		return this.label;
	}

	public boolean isRelationship() {
		return relationship;
	}

	public static AnnotationTypeApi getByLabel(String label){
		AnnotationTypeApi ret = AnnotationTypeApi.UNKNOWN;
		for (AnnotationTypeApi val : AnnotationTypeApi.values()){
			if (val.getLabel().equalsIgnoreCase(label)){
				ret=val;
				break;
			}
		}
		return ret;
	}
	
}
