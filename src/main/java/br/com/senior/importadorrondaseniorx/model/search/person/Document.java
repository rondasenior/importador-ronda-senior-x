package br.com.senior.importadorrondaseniorx.model.search.person;

import br.com.senior.importadorrondaseniorx.model.search.documenttype.DocumentType;

public class Document {
	
	private Long id;
	private DocumentType documentType;
	private String document;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DocumentType getDocumentType() {
		return documentType;
	}

	public void setDocumentType(DocumentType documentType) {
		this.documentType = documentType;
	}

	public String getDocument() {
		return document;
	}
	
	public void setDocument(String document) {
		this.document = document;
	}
}
