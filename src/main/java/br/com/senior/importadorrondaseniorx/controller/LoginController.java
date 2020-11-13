package br.com.senior.importadorrondaseniorx.controller;

import java.io.IOException;

import com.google.gson.JsonSyntaxException;

import br.com.senior.importadorrondaseniorx.dto.LoginDto;
import br.com.senior.importadorrondaseniorx.dto.LoginInputDto;
import br.com.senior.importadorrondaseniorx.service.LoginService;
import br.com.senior.importadorrondaseniorx.service.RestService;

public class LoginController {

	private LoginService loginService = new LoginService();
	private UserController userController = new UserController();

	public void authenticateByUserPassword(LoginInputDto loginInputDto) throws IOException, InterruptedException {
		loginService.authenticateByUserPassword(loginInputDto);
		userController.setUserPreferences();
	}

	public void authenticateByKey(LoginInputDto loginInputDto) throws JsonSyntaxException, IOException {
		loginService.authenticateByKey(loginInputDto);
	}

	public static LoginDto getToken() {
		return RestService.getInstance().getToken();
	}
	
	public static void resetToken() {
		RestService.getInstance().resetToken();
		RestService.getInstance().resetUserPreferences();
	}
	
	public static boolean isAuthenticated() {
		return RestService.getInstance().getToken() != null;
	}
}
