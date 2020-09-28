package br.com.senior.importadorrondaseniorx.controller;

import java.util.List;
import java.util.StringJoiner;

import org.springframework.web.client.HttpServerErrorException;

import br.com.senior.importadorrondaseniorx.core.SSecureError;
import br.com.senior.importadorrondaseniorx.dto.CardCredentialDto;
import br.com.senior.importadorrondaseniorx.mappers.CardCredentialMapper;
import br.com.senior.importadorrondaseniorx.service.CardCredentialService;
import br.com.senior.importadorrondaseniorx.utils.Utils;

public class CardCredentialController {

	private CardCredentialService service = new CardCredentialService();
	
	public String persistCredentialCard(List<String[]> csvReaderValues) {
		List<CardCredentialDto> dtos = CardCredentialMapper.csvToDtos(csvReaderValues);
		StringJoiner logFinal = new StringJoiner("");
		
		for (CardCredentialDto dto : dtos) {
			SSecureError error = null;
			try {
				dto.setId(service.persistCredentialCard(dto).getId());
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
}
