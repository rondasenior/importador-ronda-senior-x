package br.com.senior.importadorrondaseniorx.mappers;

import java.util.ArrayList;
import java.util.List;

import br.com.senior.importadorrondaseniorx.dto.CardCredentialDto;
import br.com.senior.importadorrondaseniorx.model.imports.cardcredential.CardCredential;
import br.com.senior.importadorrondaseniorx.model.imports.cardcredential.InformationCardCredential;
import br.com.senior.importadorrondaseniorx.model.imports.person.Person;

public class CardCredentialMapper {

	public static List<CardCredentialDto> csvToDtos(List<String[]> objs) {
		List<CardCredentialDto> dtos = new ArrayList<>();
		
		for (String[] provisoryCardCredential : objs) {
			CardCredentialDto dto = new CardCredentialDto();
			int position = 0;
			
			dto.setStartDate(provisoryCardCredential[position++]);
			dto.setEndDate(provisoryCardCredential[position++]);
			dto.setPersonId(Long.parseLong(provisoryCardCredential[position++]));
			dto.setSituation(Integer.parseInt(provisoryCardCredential[position++]));
			dto.setCardTechnology(Integer.parseInt(provisoryCardCredential[position++]));
			dto.setCardNumber(Long.parseLong(provisoryCardCredential[position++]));
			
			dtos.add(dto);
		}
		
		return dtos;
	}
	
	public static CardCredential toEntity(CardCredentialDto dto) {
		CardCredential entity = new CardCredential();
		
		entity.setId(dto.getId() == null ? 0 : dto.getId());
		entity.setStartDate(dto.getStartDate());
		entity.setExpirationDate(dto.getEndDate());
		entity.setPerson(new Person(dto.getPersonId()));
		entity.setSituation(dto.getSituation());
		
		InformationCardCredential icc = new InformationCardCredential();
		icc.setCardTechnology(dto.getCardTechnology());
		icc.setCardNumber(dto.getCardNumber());
		entity.getCardCredentialList().add(icc);
		
		return entity;
	}
	
	public static CardCredentialDto toDto(CardCredential entity) {
		CardCredentialDto dto = new CardCredentialDto();
		dto.setId(entity.getId());
		return dto;
	}
}
