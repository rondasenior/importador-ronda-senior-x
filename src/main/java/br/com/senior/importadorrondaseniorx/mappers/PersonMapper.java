package br.com.senior.importadorrondaseniorx.mappers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

public class PersonMapper {

	public static Person toEntity(PersonDto dto) throws ParseException {
		Person entity = new Person();
		
		entity.setName(dto.getName());
		entity.setGender(Gender.values()[dto.getGender()]);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dateBirthday = new SimpleDateFormat("dd/MM/yyyy").parse(dto.getBirthday());
		entity.setBirthday(sdf.format(dateBirthday));
		
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
	
	public static List<PersonDto> csvToDtos(List<String[]> objs) {
		List<PersonDto> dtos = new ArrayList<>();
		
		for (String[] person : objs) {
			PersonDto dto = new PersonDto();
			int position = 0;
			
			dto.setName(person[position++]);
			dto.setGender(Integer.parseInt(person[position++]));
			dto.setBirthday(person[position++]);
			dto.setRegistry(person[position++]);
			dto.setAddress(person[position++]);
			dto.setDistrict(person[position++]);
			dto.setCity(person[position++]);
			dto.setFederalState(person[position++]);
			dto.setZipCode(person[position++]);
			dto.setNationality(person[position++]);
			dto.setDocumentTypeId(Long.parseLong(person[position++]));
			dto.setDocument(person[position++]);
			dto.setEmailPreferential(Boolean.parseBoolean(person[position++]));
			dto.setEmail(person[position++]);
			dto.setPhonePreferential(Boolean.parseBoolean(person[position++]));
			dto.setPhoneDdi(Long.parseLong(person[position++]));
			dto.setPhone(person[position++]);
			
			dtos.add(dto);
		}
		
		return dtos;
	}
	
	public static List<PersonRoleDto> personRoleCsvToDtos(List<String[]> objs) {
		List<PersonRoleDto> dtos = new ArrayList<>();
		
		for (String[] person : objs) {
			PersonRoleDto dto = new PersonRoleDto();
			int position = 0;
			
			dto.setStartDate(person[position++]);
			dto.setEndDate(person[position++]);
			dto.setPersonId(Long.parseLong(person[position++]));
			dto.setRoleId(Long.parseLong(person[position++]));
			
			dtos.add(dto);
		}
		
		return dtos;
	}
	
	public static PersonRole personRoleDtoToEntity(PersonRoleDto dto) {
		PersonRole entity = new PersonRole();
		
		entity.setId(dto.getId() == null ? 0 : dto.getId());
		entity.setPersonId(dto.getPersonId());
		entity.setRoleId(dto.getRoleId());
		entity.setIntegrated(dto.isIntegrated());
		entity.setStartDate(dto.getStartDate());
		entity.setEndDate(dto.getEndDate());
		
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
