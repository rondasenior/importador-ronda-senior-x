package br.com.senior.importadorrondaseniorx.model.search.role;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RoleSearchOutput {
	
	private List<RoleSearch> roles = new ArrayList<>();
	
	@JsonCreator
	public RoleSearchOutput(@JsonProperty() List<RoleSearch> roles) {
		this.roles = roles;
	}
	
	public List<RoleSearch> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleSearch> roles) {
		this.roles = roles;
	}
}
