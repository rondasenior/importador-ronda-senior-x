package br.com.senior.importadorrondaseniorx.service;

import java.io.IOException;

import br.com.senior.importadorrondaseniorx.dto.LoginInputDto;
import br.com.senior.importadorrondaseniorx.mappers.LoginMapper;
import br.com.senior.importadorrondaseniorx.model.login.Login;

public class LoginService {
	private final String urlLogin = "/rest/platform/authentication/actions/login";
	private final String urlLoginWithKey = "/anonymous/rest/platform/authentication/actions/loginWithKey";
	
	public void authenticateByUserPassword(LoginInputDto loginInputDto) throws IOException {
		Login login = RestService.getInstance().postSAM(urlLogin, loginInputDto, Login.class).getBody();
		RestService.getInstance().setToken(LoginMapper.toDto(login));
	}

	public void authenticateByKey(LoginInputDto loginInputDto) throws IOException {
		Login login = RestService.getInstance().postSAM(urlLoginWithKey, loginInputDto, Login.class).getBody();
		RestService.getInstance().setToken(LoginMapper.toDto(login));
	}
}
