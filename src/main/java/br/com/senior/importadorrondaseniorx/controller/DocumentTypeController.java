package br.com.senior.importadorrondaseniorx.controller;

import java.util.List;

import br.com.senior.importadorrondaseniorx.dto.DocumentTypeDto;
import br.com.senior.importadorrondaseniorx.service.DocumentTypeService;

public class DocumentTypeController {

	private DocumentTypeService service = new DocumentTypeService();
	
	public List<DocumentTypeDto> getAllDocumentType() {
		return service.getAllDocumentType();
	}
}
