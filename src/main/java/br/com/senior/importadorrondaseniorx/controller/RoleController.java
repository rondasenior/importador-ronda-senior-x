package br.com.senior.importadorrondaseniorx.controller;

import java.util.List;

import br.com.senior.importadorrondaseniorx.dto.RoleSearchDto;
import br.com.senior.importadorrondaseniorx.service.RoleService;

public class RoleController {

	private RoleService service = new RoleService();
	
	public List<RoleSearchDto> getRoleSearch() {
		return service.getRoleSearch();
	}
}
