package br.com.senior.importadorrondaseniorx.mappers;

import br.com.senior.importadorrondaseniorx.dto.LoginDto;
import br.com.senior.importadorrondaseniorx.model.login.Login;

public class LoginMapper {
	
	public static LoginDto toDto(Login login) {
		LoginDto dto = new LoginDto();
		dto.setScope(login.getScope());
		dto.setExpiresIn(login.getExpiresIn());
		dto.setUserName(login.getUserName());
		dto.setTokenType(login.getTokenType());
		dto.setAccessToken(login.getAccessToken());
		dto.setRefreshToken(login.getRefreshToken());
		return dto;
	}
}
