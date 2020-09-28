package br.com.senior.importadorrondaseniorx.mappers;

import java.util.ArrayList;
import java.util.List;

import br.com.senior.importadorrondaseniorx.dto.DocumentTypeDto;
import br.com.senior.importadorrondaseniorx.model.search.documenttype.DocumentType;

public class DocumentTypeMapper {

	public static DocumentType toEntity(DocumentTypeDto dto) {
		DocumentType dt = new DocumentType();
		dt.setId(dto.getId());
		dt.setName(dto.getName());
		dt.setLabel(dto.getLabel());
		dt.setMask(dto.getMask());
		dt.setRequired(dto.getRequired());
		dt.setDocumentToREP(dto.getDocumentToREP());
		return dt;
	}

	public static DocumentTypeDto toDto(DocumentType dt) {
		DocumentTypeDto dto = new DocumentTypeDto();
		dto.setId(dt.getId());
		dto.setName(dt.getName());
		dto.setLabel(dt.getLabel());
		dto.setMask(dt.getMask());
		dto.setRequired(dt.getRequired());
		dto.setDocumentToREP(dt.getDocumentToREP());
		return dto;
	}
	
	public static List<DocumentTypeDto> toDtos(List<DocumentType> dts) {
		List<DocumentTypeDto> dtos = new ArrayList<>();
		for (DocumentType dt : dts) {
			dtos.add(toDto(dt));
		}
		return dtos;
	}
	
}
