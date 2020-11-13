package br.com.senior.importadorrondaseniorx.mappers;

import br.com.senior.importadorrondaseniorx.dto.UserAllPreferencesDto;
import br.com.senior.importadorrondaseniorx.model.user.UserAllPreferences;

public class UserMapper {

	public static UserAllPreferencesDto userPreferencesEntityToDto(UserAllPreferences entity) {
		UserAllPreferencesDto dto = new UserAllPreferencesDto();
		dto.setOffset(entity.getLocalTimeZone().getTimeZone().getOffset());
		return dto;
	}
}
