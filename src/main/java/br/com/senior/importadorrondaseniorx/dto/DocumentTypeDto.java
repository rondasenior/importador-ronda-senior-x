package br.com.senior.importadorrondaseniorx.dto;

public class DocumentTypeDto {

	private Long id;
	private String name;
	private String label;
	private String mask;
	private Boolean required;
	private Boolean documentToREP;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getLabel() {
		return label;
	}
	
	public void setLabel(String label) {
		this.label = label;
	}
	
	public String getMask() {
		return mask;
	}
	
	public void setMask(String mask) {
		this.mask = mask;
	}
	
	public Boolean getRequired() {
		return required;
	}
	
	public void setRequired(Boolean required) {
		this.required = required;
	}
	
	public Boolean getDocumentToREP() {
		return documentToREP;
	}
	
	public void setDocumentToREP(Boolean documentToREP) {
		this.documentToREP = documentToREP;
	}
}
