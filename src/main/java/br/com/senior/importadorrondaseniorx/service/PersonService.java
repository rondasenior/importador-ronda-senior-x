package br.com.senior.importadorrondaseniorx.service;

import java.text.ParseException;
import java.util.List;
import java.util.StringJoiner;

import br.com.senior.importadorrondaseniorx.dto.BulkPersonFeedbackDto;
import br.com.senior.importadorrondaseniorx.dto.PersonDto;
import br.com.senior.importadorrondaseniorx.dto.PersonRoleDto;
import br.com.senior.importadorrondaseniorx.dto.SearchPersonDto;
import br.com.senior.importadorrondaseniorx.mappers.BulkPersonFeedbackMapper;
import br.com.senior.importadorrondaseniorx.mappers.PersonMapper;
import br.com.senior.importadorrondaseniorx.model.imports.person.BulkPersonWithFeedbackInput;
import br.com.senior.importadorrondaseniorx.model.imports.person.BulkPersonWithFeedbackOutput;
import br.com.senior.importadorrondaseniorx.model.imports.personrole.PersonRole;
import br.com.senior.importadorrondaseniorx.model.search.person.PersonSearchOutput;

public class PersonService {
	private final String urlCreatePerson = "/rest/sam/application/actions/createBulkPersonWithFeedback";
	private final String urlPersonRole = "/person/role";
	
	public List<BulkPersonFeedbackDto> persistPeople(List<PersonDto> dtos) throws ParseException {
		BulkPersonWithFeedbackOutput output = RestService.getInstance().postSAM(urlCreatePerson,
																			    new BulkPersonWithFeedbackInput(PersonMapper.toEntities(dtos)),
																			    BulkPersonWithFeedbackOutput.class).getBody();
		return BulkPersonFeedbackMapper.toDtos(output.getFeedbacks());
	}

	public PersonRoleDto persistPersonRole(PersonRoleDto dto) {
		PersonRole pr = RestService.getInstance().postSSecure(urlPersonRole,
															  PersonMapper.personRoleDtoToEntity(dto),
															  PersonRole.class).getBody();
		return PersonMapper.personRoleEntityToDto(pr);
	}
	
	public List<SearchPersonDto> getPersonSearchWithTerm(String term) {
		PersonSearchOutput spo = RestService.getInstance().getSSecure(getUrlSearchPerson(term), PersonSearchOutput.class).getBody();
		return PersonMapper.searchPersonEntitiesToDtos(spo.getPeople());
	}
	
	private String getUrlSearchPerson(String term) {
		return new StringJoiner("").add("/person/search?situation=0&term=").add(term).toString();
	}

	public List<SearchPersonDto> getPersonPagedSearchAll(Integer page) {
		PersonSearchOutput spo = RestService.getInstance().getSSecure(getUrlPersonPagedSearch(page), PersonSearchOutput.class).getBody();
		return PersonMapper.searchPersonEntitiesToDtos(spo.getPeople());
	}
	
	private String getUrlPersonPagedSearch(Integer page) {
		return new StringJoiner("").add("/person/pagedsearchall?situation=0&pageSize=50&page=").add(page.toString()).toString();
	}
}
