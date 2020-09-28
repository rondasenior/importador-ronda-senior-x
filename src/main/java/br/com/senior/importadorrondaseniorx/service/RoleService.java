package br.com.senior.importadorrondaseniorx.service;

import java.util.List;

import br.com.senior.importadorrondaseniorx.dto.RoleSearchDto;
import br.com.senior.importadorrondaseniorx.mappers.RoleMapper;
import br.com.senior.importadorrondaseniorx.model.search.role.RoleSearchOutput;

public class RoleService {

	private final String urlRoleSearch = "/role";
	
	public List<RoleSearchDto> getRoleSearch() {
		RoleSearchOutput rso = RestService.getInstance().getSSecure(urlRoleSearch, RoleSearchOutput.class).getBody();
		return RoleMapper.roleSearchToDtos(rso.getRoles());
	}
}
