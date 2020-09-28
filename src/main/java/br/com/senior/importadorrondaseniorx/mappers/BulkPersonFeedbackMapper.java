package br.com.senior.importadorrondaseniorx.mappers;

import java.util.ArrayList;
import java.util.List;

import br.com.senior.importadorrondaseniorx.dto.BulkPersonFeedbackDto;
import br.com.senior.importadorrondaseniorx.enums.PersonSituationType;
import br.com.senior.importadorrondaseniorx.model.imports.person.BulkPersonFeedback;

public class BulkPersonFeedbackMapper {
	
	public static BulkPersonFeedbackDto toDto(BulkPersonFeedback entity) {
		BulkPersonFeedbackDto dto = new BulkPersonFeedbackDto();
		dto.setId(entity.getId().toString());
		dto.setName(entity.getName());
		dto.setDocument(entity.getDocument());
		
		String situation = "";
		if (entity.getSituation() != null) {
			situation = entity.getSituation() == PersonSituationType.ACTIVE ? "Ativo" : "Bloqueado";
		}
		
		dto.setSituation(situation);
		dto.setMessage(entity.getMessage());
		return dto;
	}
	
	public static List<BulkPersonFeedbackDto> toDtos(List<BulkPersonFeedback> entities) {
		List<BulkPersonFeedbackDto> dtos = new ArrayList<>();
		for(BulkPersonFeedback entity : entities) {
			dtos.add(toDto(entity));
		}
		return dtos;
	}
}
