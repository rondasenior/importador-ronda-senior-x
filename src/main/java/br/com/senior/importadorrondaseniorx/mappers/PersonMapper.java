package br.com.senior.importadorrondaseniorx.mappers;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import br.com.senior.importadorrondaseniorx.controller.UserController;
import br.com.senior.importadorrondaseniorx.core.MandatoryFieldEmptyException;
import br.com.senior.importadorrondaseniorx.dto.PersonDto;
import br.com.senior.importadorrondaseniorx.dto.PersonRoleDto;
import br.com.senior.importadorrondaseniorx.dto.SearchPersonDto;
import br.com.senior.importadorrondaseniorx.enums.Gender;
import br.com.senior.importadorrondaseniorx.model.imports.person.Document;
import br.com.senior.importadorrondaseniorx.model.imports.person.Email;
import br.com.senior.importadorrondaseniorx.model.imports.person.Person;
import br.com.senior.importadorrondaseniorx.model.imports.person.Phone;
import br.com.senior.importadorrondaseniorx.model.imports.personrole.PersonRole;
import br.com.senior.importadorrondaseniorx.model.search.documenttype.DocumentType;
import br.com.senior.importadorrondaseniorx.model.search.person.PersonSearch;
import br.com.senior.importadorrondaseniorx.utils.DateUtils;
import br.com.senior.importadorrondaseniorx.utils.Utils;

public class PersonMapper {

	public static Person toEntity(PersonDto dto) throws ParseException {
		Person entity = new Person();
		
		entity.setName(dto.getName());
		
		if (dto.getGender() != null) {
			entity.setGender(Gender.values()[dto.getGender()]);
		}
		
		if (!Utils.isEmpty(dto.getBirthday())) {
			entity.setBirthday(LocalDate.parse(dto.getBirthday(), DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
		}
		
		entity.setAddress(dto.getAddress());
		entity.setDistrict(dto.getDistrict());
		entity.setCity(dto.getCity());
		entity.setFederalState(dto.getFederalState());
		entity.setZipCode(dto.getZipCode());
		entity.setNationality(dto.getNationality());
		entity.getDocuments().add(new Document(new DocumentType(dto.getDocumentTypeId()), dto.getDocument()));
		entity.getEmails().add(new Email(dto.getEmailPreferential(), dto.getEmail()));
		entity.getPhones().add(new Phone(dto.getPhonePreferential(), dto.getPhoneDdi(), dto.getPhone()));
		
		return entity;
	}
	
	public static List<Person> toEntities(List<PersonDto> dtos) throws ParseException {
		List<Person> entities = new ArrayList<>();
		for (PersonDto dto : dtos) {
			entities.add(toEntity(dto));
		}
		return entities;
	}
	
	public static List<PersonDto> csvToDtos(List<String[]> objs) throws MandatoryFieldEmptyException {
		List<PersonDto> dtos = new ArrayList<>();
		
		for (String[] person : objs) {
			PersonDto dto = new PersonDto();
			int position = 0;
			
			String name = person[position++];
			Utils.validateMandatoryFieldEmpty(name, "Nome");
			dto.setName(name);
			
			String gender = person[position++];
			dto.setGender(Utils.isEmpty(gender) ? null : Integer.parseInt(gender));
			dto.setBirthday(person[position++]);
			dto.setRegistry(person[position++]);
			dto.setAddress(person[position++]);
			dto.setDistrict(person[position++]);
			dto.setCity(person[position++]);
			dto.setFederalState(person[position++]);
			dto.setZipCode(person[position++]);
			dto.setNationality(person[position++]);
			
			String documentTypeId = person[position++];
			Utils.validateMandatoryFieldEmpty(documentTypeId, "ID Tipo do Documento");
			dto.setDocumentTypeId(Long.parseLong(documentTypeId));
			
			String document = person[position++];
			Utils.validateMandatoryFieldEmpty(document, "Documento");
			dto.setDocument(document);
			
			String emailPreferential = person[position++];
			dto.setEmailPreferential(Utils.isEmpty(emailPreferential) ? null : Boolean.parseBoolean(emailPreferential));
			dto.setEmail(person[position++]);
			
			String phonePreferential = person[position++];
			dto.setPhonePreferential(Utils.isEmpty(phonePreferential) ? null : Boolean.parseBoolean(phonePreferential));
			
			String phoneDdi = person[position++];
			dto.setPhoneDdi(Utils.isEmpty(phoneDdi) ? null : Long.parseLong(phoneDdi));
			dto.setPhone(person[position++]);
			
			dtos.add(dto);
		}
		
		return dtos;
	}
	
	public static List<PersonRoleDto> personRoleCsvToDtos(List<String[]> objs) throws MandatoryFieldEmptyException {
		List<PersonRoleDto> dtos = new ArrayList<>();
		
		for (String[] obj : objs) {
			PersonRoleDto dto = new PersonRoleDto();
			int position = 0;
			
			String startDate = obj[position++];
			Utils.validateMandatoryFieldEmpty(startDate, "Data de Início");
			dto.setStartDate(startDate);
			
			dto.setEndDate(obj[position++]);
			
			String personId = obj[position++];
			Utils.validateMandatoryFieldEmpty(personId, "ID da Pessoa");
			dto.setPersonId(Long.parseLong(personId));
			
			String roleId = obj[position++];
			Utils.validateMandatoryFieldEmpty(roleId, "ID do Papel");
			dto.setRoleId(Long.parseLong(roleId));
			
			dtos.add(dto);
		}
		
		return dtos;
	}
	
	public static PersonRole personRoleDtoToEntity(PersonRoleDto dto) {
		PersonRole entity = new PersonRole();
		
		int offset = UserController.getUserPreferences().getOffset();
		String startDate = LocalDateTime.parse(dto.getStartDate(), DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")).toString();
		
		if (!Utils.isEmpty(dto.getEndDate())) {
			String endDate = LocalDateTime.parse(dto.getEndDate(), DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")).toString();
			entity.setEndDate(DateUtils.formatDateTimeUsingGMT(endDate, offset));
		}
		
		entity.setId(dto.getId() == null ? 0 : dto.getId());
		entity.setPersonId(dto.getPersonId());
		entity.setRoleId(dto.getRoleId());
		entity.setIntegrated(dto.isIntegrated());
		entity.setStartDate(DateUtils.formatDateTimeUsingGMT(startDate, offset));
		
		return entity;
	}
	
	public static PersonRoleDto personRoleEntityToDto(PersonRole entity) {
		PersonRoleDto dto = new PersonRoleDto();
		
		dto.setId(entity.getId());
		dto.setPersonId(entity.getPersonId());
		dto.setRoleId(entity.getRoleId());
		
		return dto;
	}
	
	public static SearchPersonDto searchPersonEntityToDto(PersonSearch entity) {
		SearchPersonDto dto = new SearchPersonDto();
		
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		
		if (!entity.getMandatoryDocuments().isEmpty()) {
			br.com.senior.importadorrondaseniorx.model.search.person.Document doc = entity.getMandatoryDocuments().get(0);
			dto.setDocumentId(doc.getId());
			dto.setDocument(doc.getDocument());
			dto.setDocumentTypeId(doc.getDocumentType().getId());
			dto.setDocumentTypeLabel(doc.getDocumentType().getLabel());
		}
		
		dto.setPhoneDdi(entity.getPreferentialPhone().getDdi());
		dto.setPhoneNumber(entity.getPreferentialPhone().getPhoneNumber());
		dto.setEmail(entity.getPreferentialEmail().getEmailAddress());
		
		return dto;
	}
	
	public static List<SearchPersonDto> searchPersonEntitiesToDtos(List<PersonSearch> entities) {
		List<SearchPersonDto> dtos = new ArrayList<>();
		
		for (PersonSearch person : entities) {
			dtos.add(searchPersonEntityToDto(person));
		}
		
		return dtos;
	}
}
