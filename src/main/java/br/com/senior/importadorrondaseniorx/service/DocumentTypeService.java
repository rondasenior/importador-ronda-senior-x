package br.com.senior.importadorrondaseniorx.service;

import java.util.List;

import br.com.senior.importadorrondaseniorx.dto.DocumentTypeDto;
import br.com.senior.importadorrondaseniorx.mappers.DocumentTypeMapper;
import br.com.senior.importadorrondaseniorx.model.search.documenttype.DocumentTypeOutput;

public class DocumentTypeService {

	private final String urlGetAllDocumentType = "/documenttype";
	
	public List<DocumentTypeDto> getAllDocumentType() {
		DocumentTypeOutput dts =  RestService.getInstance().getSSecure(urlGetAllDocumentType, DocumentTypeOutput.class).getBody();
		return DocumentTypeMapper.toDtos(dts.getDocumentsTypes());
	}
}
