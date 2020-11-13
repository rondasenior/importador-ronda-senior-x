package br.com.senior.importadorrondaseniorx.service;

import br.com.senior.importadorrondaseniorx.mappers.UserMapper;
import br.com.senior.importadorrondaseniorx.model.user.UserAllPreferences;

public class UserService {
	private final String urlGetUserPreferences = "/user/preferences";

	public void setUserPreferences() {
		UserAllPreferences uap = RestService.getInstance().getSSecure(urlGetUserPreferences, UserAllPreferences.class).getBody();
		RestService.getInstance().setUserPreferences(UserMapper.userPreferencesEntityToDto(uap));
	}
}
