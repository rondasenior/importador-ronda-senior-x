package br.com.senior.importadorrondaseniorx.controller;

import java.util.List;
import java.util.StringJoiner;

import org.springframework.web.client.HttpServerErrorException;

import br.com.senior.importadorrondaseniorx.core.MandatoryFieldEmptyException;
import br.com.senior.importadorrondaseniorx.core.SSecureError;
import br.com.senior.importadorrondaseniorx.dto.GroupPersonDto;
import br.com.senior.importadorrondaseniorx.dto.GroupSearchDto;
import br.com.senior.importadorrondaseniorx.mappers.GroupMapper;
import br.com.senior.importadorrondaseniorx.service.GroupService;
import br.com.senior.importadorrondaseniorx.utils.Utils;

public class GroupController {

	private GroupService service = new GroupService();
	
	public String persistGroupPerson(List<String[]> csvReaderValues) throws MandatoryFieldEmptyException {
		List<GroupPersonDto> dtos = GroupMapper.groupPersonCsvToDtos(csvReaderValues);
		StringJoiner logFinal = new StringJoiner("");
		
		for (GroupPersonDto dto : dtos) {
			SSecureError error = null;
			try {
				service.persistGroupPerson(dto);
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
	
	public List<GroupSearchDto> getGroupSearch() {
		return service.getGroupSearch();
	}
}
