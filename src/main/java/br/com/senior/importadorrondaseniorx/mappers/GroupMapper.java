package br.com.senior.importadorrondaseniorx.mappers;

import java.util.ArrayList;
import java.util.List;

import br.com.senior.importadorrondaseniorx.dto.GroupSearchDto;
import br.com.senior.importadorrondaseniorx.core.MandatoryFieldEmptyException;
import br.com.senior.importadorrondaseniorx.dto.GroupPersonDto;
import br.com.senior.importadorrondaseniorx.model.search.group.GroupSearch;
import br.com.senior.importadorrondaseniorx.utils.Utils;

public class GroupMapper {

	public static List<GroupPersonDto> groupPersonCsvToDtos(List<String[]> objs) throws MandatoryFieldEmptyException {
		List<GroupPersonDto> dtos = new ArrayList<>();
		
		for (String[] groupPerson : objs) {
			GroupPersonDto dto = new GroupPersonDto();
			int position = 0;

			String groupId = groupPerson[position++];
			Utils.validateMandatoryFieldEmpty(groupId, "ID do Grupo");
			dto.setGroupId(Long.parseLong(groupId));
			
			String personId = groupPerson[position++];
			Utils.validateMandatoryFieldEmpty(personId, "ID da Pessoa");
			dto.setPersonId(Long.parseLong(personId));
			
			dtos.add(dto);
		}
		
		return dtos;
	}
	
	public static GroupSearchDto groupSearchToDto(GroupSearch entity) {
		GroupSearchDto dto = new GroupSearchDto();
		
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setParent(entity.getParent());
		dto.setVacancyAmont(entity.getVacancyAmont());
		dto.setVacancyAmontUse(entity.getVacancyAmontUse());
		dto.setControlVacancyAmount(entity.getControlVacancyAmount());
		
		if (entity.getPhysicalLocation() != null) {
			dto.setPhysicalLocationId(entity.getPhysicalLocation().getId());
			dto.setPhysicalLocationName(entity.getPhysicalLocation().getName());
		}
		
		return dto;
	}
	
	public static List<GroupSearchDto> groupSearchToDtos(List<GroupSearch> entities) {
		List<GroupSearchDto> dtos = new ArrayList<>();
		
		for (GroupSearch entity : entities) {
			dtos.add(groupSearchToDto(entity));
		}
		
		return dtos;
	}
}
