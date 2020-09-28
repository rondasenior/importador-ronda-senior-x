package br.com.senior.importadorrondaseniorx.model.imports.person;

import br.com.senior.importadorrondaseniorx.model.search.documenttype.DocumentType;

public class Document {
	
	private Long id;
	private DocumentType documentType;
	private String document;
	
	public Document(DocumentType documentType, String document) {
		this.documentType = documentType;
		this.document = document;
	}
	
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
