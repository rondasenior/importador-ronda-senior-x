package br.com.senior.importadorrondaseniorx.service;

import java.util.List;
import java.util.StringJoiner;

import br.com.senior.importadorrondaseniorx.dto.GroupPersonDto;
import br.com.senior.importadorrondaseniorx.dto.GroupSearchDto;
import br.com.senior.importadorrondaseniorx.mappers.GroupMapper;
import br.com.senior.importadorrondaseniorx.model.search.group.GroupSearchOutput;

public class GroupService {

	private final String urlGroupSearch = "/group";
	
	public void persistGroupPerson(GroupPersonDto dto) {
		RestService.getInstance().postSSecure(getUrlPersistGroupPerson(dto));
	}
	
	public List<GroupSearchDto> getGroupSearch() {
		GroupSearchOutput gso = RestService.getInstance().getSSecure(urlGroupSearch, GroupSearchOutput.class).getBody();
		return GroupMapper.groupSearchToDtos(gso.getGroups());
	}
	
	private String getUrlPersistGroupPerson(GroupPersonDto dto) {
		return new StringJoiner("/").add("/group").add(dto.getGroupId().toString()).add("person").add(dto.getPersonId().toString()).toString();
	}
}
