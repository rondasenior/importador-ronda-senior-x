package br.com.senior.importadorrondaseniorx.mappers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import br.com.senior.importadorrondaseniorx.controller.UserController;
import br.com.senior.importadorrondaseniorx.core.MandatoryFieldEmptyException;
import br.com.senior.importadorrondaseniorx.dto.CardCredentialDto;
import br.com.senior.importadorrondaseniorx.model.imports.cardcredential.CardCredential;
import br.com.senior.importadorrondaseniorx.model.imports.cardcredential.InformationCardCredential;
import br.com.senior.importadorrondaseniorx.model.imports.person.Person;
import br.com.senior.importadorrondaseniorx.utils.DateUtils;
import br.com.senior.importadorrondaseniorx.utils.Utils;

public class CardCredentialMapper {

	public static List<CardCredentialDto> csvToDtos(List<String[]> objs) throws MandatoryFieldEmptyException {
		List<CardCredentialDto> dtos = new ArrayList<>();
		
		for (String[] provisoryCardCredential : objs) {
			CardCredentialDto dto = new CardCredentialDto();
			int position = 0;
			
			dto.setStartDate(provisoryCardCredential[position++]);
			
			String endDate = provisoryCardCredential[position++];
			Utils.validateMandatoryFieldEmpty(endDate, "Data de Fim");
			dto.setEndDate(endDate);
			
			String personId = provisoryCardCredential[position++];
			Utils.validateMandatoryFieldEmpty(personId, "ID da Pessoa");
			dto.setPersonId(Long.parseLong(personId));
			
			String situation = provisoryCardCredential[position++];
			Utils.validateMandatoryFieldEmpty(situation, "Sitaução");
			dto.setSituation(Integer.parseInt(situation));
			
			String cardTechnology = provisoryCardCredential[position++];
			Utils.validateMandatoryFieldEmpty(cardTechnology, "Tecnologia");
			dto.setCardTechnology(Integer.parseInt(cardTechnology));
			
			String cardNumber = provisoryCardCredential[position++];
			Utils.validateMandatoryFieldEmpty(cardNumber, "Número");
			dto.setCardNumber(Long.parseLong(cardNumber));
			
			dtos.add(dto);
		}
		
		return dtos;
	}
	
	public static CardCredential toEntity(CardCredentialDto dto) {
		CardCredential entity = new CardCredential();
		
		int offset = UserController.getUserPreferences().getOffset();
		String endDate = LocalDateTime.parse(dto.getEndDate(), DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")).toString();
		
		if (!Utils.isEmpty(dto.getStartDate())) {
			String startDate = LocalDateTime.parse(dto.getStartDate(), DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")).toString();
			entity.setStartDate(DateUtils.formatDateTimeUsingGMT(startDate, offset));
		}
		
		entity.setId(dto.getId() == null ? 0 : dto.getId());
		entity.setExpirationDate(DateUtils.formatDateTimeUsingGMT(endDate, offset));
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
