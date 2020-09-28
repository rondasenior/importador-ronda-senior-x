package br.com.senior.importadorrondaseniorx.service;

import br.com.senior.importadorrondaseniorx.dto.CardCredentialDto;
import br.com.senior.importadorrondaseniorx.mappers.CardCredentialMapper;
import br.com.senior.importadorrondaseniorx.model.imports.cardcredential.CardCredential;

public class CardCredentialService {

	private final String urlPersistCredentialCard = "/credential/card";
	
	public CardCredentialDto persistCredentialCard(CardCredentialDto dto) {
		CardCredential cc = RestService.getInstance().postSSecure(urlPersistCredentialCard,
																  CardCredentialMapper.toEntity(dto),
																  CardCredential.class).getBody();
		return CardCredentialMapper.toDto(cc);
	}

}
