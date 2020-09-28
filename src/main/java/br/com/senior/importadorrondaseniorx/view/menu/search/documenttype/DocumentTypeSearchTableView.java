package br.com.senior.importadorrondaseniorx.view.menu.search.documenttype;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import br.com.senior.importadorrondaseniorx.dto.DocumentTypeDto;
import br.com.senior.importadorrondaseniorx.utils.Utils;
import br.com.senior.importadorrondaseniorx.view.core.GenericTableView;

public class DocumentTypeSearchTableView extends GenericTableView {

	private static final long serialVersionUID = 4289635105530091233L;
	
	public static final String[] HEADERS = {"Id", "Nome", "Label", "Máscara", "Obrigatório", "Documento para o REP"};

	@SuppressWarnings("unchecked")
	@Override
	public void updateTable(Object objs) {
		addBadgeInTable((List<DocumentTypeDto>) objs, newDefaultTable());
		showTable();
	}
	
	private void addBadgeInTable(List<DocumentTypeDto> dtos, DefaultTableModel defaultTable) {
		if (!dtos.isEmpty()) {
			defaultTable.setColumnIdentifiers(HEADERS);
		} else {
			Utils.showDialogMessageError("Erro", "Nenhum resultado encontrado");
		}
		
		for (DocumentTypeDto dto : dtos) {
			String id = dto.getId().toString();
			String name = dto.getName();
			String label = dto.getLabel();
			String mask = dto.getMask();
			String required = dto.getRequired() ? "Sim" : "Não";
			String documentToREP = dto.getDocumentToREP() ? "Sim" : "Não";
			
			defaultTable.addRow(new Object[] {id, name, label, mask, required, documentToREP});
		}
	}

}
