package br.com.senior.importadorrondaseniorx.controller;

import br.com.senior.importadorrondaseniorx.dto.UserAllPreferencesDto;
import br.com.senior.importadorrondaseniorx.service.RestService;
import br.com.senior.importadorrondaseniorx.service.UserService;

public class UserController {

	private UserService userService = new UserService();
	
	protected void setUserPreferences() {
		userService.setUserPreferences();
	}
	
	public static UserAllPreferencesDto getUserPreferences() {
		return RestService.getInstance().getUserPreferences();
	}
}
