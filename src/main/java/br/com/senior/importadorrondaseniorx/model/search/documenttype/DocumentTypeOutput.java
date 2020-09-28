package br.com.senior.importadorrondaseniorx.model.search.documenttype;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DocumentTypeOutput {

	private List<DocumentType> documentsTypes = new ArrayList<>();

	@JsonCreator
	public DocumentTypeOutput(@JsonProperty() List<DocumentType> documentsTypes) {
		this.documentsTypes = documentsTypes;
	}
	
	public List<DocumentType> getDocumentsTypes() {
		return documentsTypes;
	}

	public void setDocumentsTypes(List<DocumentType> documentsTypes) {
		this.documentsTypes = documentsTypes;
	}

}
