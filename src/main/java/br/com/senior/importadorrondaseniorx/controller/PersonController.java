package br.com.senior.importadorrondaseniorx.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import org.springframework.web.client.HttpServerErrorException;

import br.com.senior.importadorrondaseniorx.core.MandatoryFieldEmptyException;
import br.com.senior.importadorrondaseniorx.core.SSecureError;
import br.com.senior.importadorrondaseniorx.dto.BulkPersonFeedbackDto;
import br.com.senior.importadorrondaseniorx.dto.PersonDto;
import br.com.senior.importadorrondaseniorx.dto.PersonRoleDto;
import br.com.senior.importadorrondaseniorx.dto.SearchPersonDto;
import br.com.senior.importadorrondaseniorx.mappers.PersonMapper;
import br.com.senior.importadorrondaseniorx.service.PersonService;
import br.com.senior.importadorrondaseniorx.utils.Utils;

public class PersonController {

	private final PersonService personService = new PersonService();
	
	public String persistPeople(List<String[]> csvReaderValues) throws ParseException, MandatoryFieldEmptyException {
		List<PersonDto> dtos = PersonMapper.csvToDtos(csvReaderValues);
		List<List<PersonDto>> datasToSend = new ArrayList<>();
		
		List<PersonDto> separateItems = new ArrayList<>();
		int stagger = 0;
		for (PersonDto dto : dtos) {
			if (stagger == 10) {
				datasToSend.add(separateItems);
				stagger = 0;
				separateItems = new ArrayList<>();
			}
			
			separateItems.add(dto);
			stagger++;
		}
		
		if (!separateItems.isEmpty()) {
			datasToSend.add(separateItems);
		}
		
		List<BulkPersonFeedbackDto> dtoResults = new ArrayList<>();
		for (List<PersonDto> values : datasToSend) {
			dtoResults.addAll(personService.persistPeople(values));
		}
		
		StringJoiner logFinal = new StringJoiner("");
		for (BulkPersonFeedbackDto result : dtoResults) {
			if (result.isPersonExists()) {
				logFinal.add(Utils.defaultLogError("Pessoa já existe"));
			} else {
				logFinal.add(Utils.defaultLogSucess(result.toString()));
			}
		}
		
		return logFinal.toString();
	}
	
	public String persistPersonRole(List<String[]> csvReaderValues) throws MandatoryFieldEmptyException {
		List<PersonRoleDto> dtos = PersonMapper.personRoleCsvToDtos(csvReaderValues);
		StringJoiner logFinal = new StringJoiner("");
		
		for (PersonRoleDto dto : dtos) {
			SSecureError error = null;
			try {
				dto.setId(personService.persistPersonRole(dto).getId());
			} catch (HttpServerErrorException e) {
				error = new SSecureError(e.getResponseBodyAsString());
			}
			
			StringJoiner log = new StringJoiner("").add(dto.toString());
			
			if (error == null) {
				logFinal.add(Utils.defaultLogSucess(log.toString()));
			} else {
				log
				.add(Utils.NEW_LINE)
				.add(Utils.NEW_LINE)
				.add(error.toString());
				logFinal.add(Utils.defaultLogError(log.toString()));
			}
		}
		
		return logFinal.toString();
	}
	
	public List<SearchPersonDto> getPersonSearchWithTerm(String term) {
		return personService.getPersonSearchWithTerm(term);
	}
	
	public List<SearchPersonDto> getPersonPagedSearchAll(Integer page) {
		return personService.getPersonPagedSearchAll(page);
	}
}
