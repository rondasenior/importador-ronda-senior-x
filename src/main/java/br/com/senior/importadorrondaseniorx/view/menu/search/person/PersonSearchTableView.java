package br.com.senior.importadorrondaseniorx.view.menu.search.person;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import br.com.senior.importadorrondaseniorx.dto.SearchPersonDto;
import br.com.senior.importadorrondaseniorx.utils.Utils;
import br.com.senior.importadorrondaseniorx.view.core.GenericTableView;

public class PersonSearchTableView extends GenericTableView {

	private static final long serialVersionUID = -7231211502813572941L;
	
	public static final String[] HEADERS = {"Id", "Nome", "Id do Documento", "Documento", "Id do Tipo de Documento", "Label do Tipo de Documento",
											"DDI do Telefone", "Número do Telefone", "E-mail"};

	@SuppressWarnings("unchecked")
	@Override
	public void updateTable(Object objs) {
		addBadgeInTable((List<SearchPersonDto>) objs, newDefaultTable());
		showTable();
		resizeColumnWidth();
	}
	
	private void addBadgeInTable(List<SearchPersonDto> dtos, DefaultTableModel defaultTable) {
		if (!dtos.isEmpty()) {
			defaultTable.setColumnIdentifiers(HEADERS);
		} else {
			Utils.showDialogMessageError("Erro", "Nenhum resultado encontrado");
		}
		
		for (SearchPersonDto dto : dtos) {
			String id = dto.getId().toString();
			String name = dto.getName();
			String documentId = dto.getDocumentId() == null ? "" : dto.getDocumentId().toString();
			String document = dto.getDocument();
			String documentTypeId = dto.getDocumentTypeId() == null ? "" : dto.getDocumentTypeId().toString();
			String documentTypeLabel = dto.getDocumentTypeLabel();
			String phoneDdi = dto.getPhoneDdi() == null ? "" : dto.getPhoneDdi().toString();
			String phoneNumber = dto.getPhoneNumber();
			String email = dto.getEmail();
			
			defaultTable.addRow(new Object[] {id, name, documentId, document, documentTypeId, documentTypeLabel, phoneDdi, phoneNumber, email});
		}
	}
	
	public void clearTable() {
		newDefaultTable();
		showTable();
	}
}
