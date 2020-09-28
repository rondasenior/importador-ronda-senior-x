package br.com.senior.importadorrondaseniorx.mappers;

import java.util.ArrayList;
import java.util.List;

import br.com.senior.importadorrondaseniorx.dto.RoleSearchDto;
import br.com.senior.importadorrondaseniorx.model.search.role.RoleSearch;

public class RoleMapper {

	public static RoleSearchDto roleSearchToDto(RoleSearch entity) {
		RoleSearchDto dto = new RoleSearchDto();
		
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setUsesProvisory(entity.getUsesProvisory());
		dto.setSendEmailToVisited(entity.getSendEmailToVisited());
		dto.setReceivesVisit(entity.getReceivesVisit());
		dto.setUsedBySelfServiceTerminal(entity.getUsedBySelfServiceTerminal());
		dto.setInheritSuspensionByImportedRole(entity.getInheritSuspensionByImportedRole());
		dto.setUsesFacialRecognition(entity.getUsesFacialRecognition());
		dto.setValidateLevel(entity.getValidateLevel());
		dto.setValidateAntiPassback(entity.getValidateAntiPassback());
		dto.setValidateStocking(entity.getValidateStocking());
		dto.setValidateCreditAccess(entity.getValidateCreditAccess());
		dto.setValidateScaleRange(entity.getValidateScaleRange());
		dto.setValidateTimeBand(entity.getValidateTimeBand());
		dto.setValidateAuthorizerRole(entity.getValidateAuthorizerRole());
		dto.setValidateAuthorizerPlace(entity.getValidateAuthorizerPlace());
		dto.setValidateVacancy(entity.getValidateVacancy());
		dto.setValidatePhysicallocation(entity.getValidatePhysicallocation());
		dto.setCheckCustomValidation(entity.getCheckCustomValidation());
		dto.setCheckInBetweenWorkdays(entity.getCheckInBetweenWorkdays());
		dto.setInBetweenWorkdaysTimeInHours(entity.getInBetweenWorkdaysTimeInHours());
		dto.setInBetweenWorkdaysToleranceInMinutes(entity.getInBetweenWorkdaysToleranceInMinutes());
		dto.setIntegrated(entity.getIntegrated());
		dto.setIndexPersonPhoto(entity.getIndexPersonPhoto());
		
		return dto;
	}
	
	public static List<RoleSearchDto> roleSearchToDtos(List<RoleSearch> entities) {
		List<RoleSearchDto> dtos = new ArrayList<>();
		
		for (RoleSearch entity : entities) {
			dtos.add(roleSearchToDto(entity));
		}
		
		return dtos;
	}
}
