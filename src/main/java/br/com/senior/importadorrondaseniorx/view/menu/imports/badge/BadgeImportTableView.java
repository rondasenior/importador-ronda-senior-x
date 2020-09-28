package br.com.senior.importadorrondaseniorx.view.menu.imports.badge;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import br.com.senior.importadorrondaseniorx.view.core.GenericTableView;

public class BadgeImportTableView extends GenericTableView {

	private static final long serialVersionUID = -6536061744080319988L;
	
	public static final String[] HEADERS = {"Data de Inicio", "Data de Fim", "ID da Pessoa", "Situacao", "Tecnologia", "Numero"};

	@SuppressWarnings("unchecked")
	@Override
	public void updateTable(Object objs) {
		addBadgeInTable((List<String[]>) objs, newDefaultTable());
		showTable();
	}
	
	private void addBadgeInTable(List<String[]> objs, DefaultTableModel defaultTable) {
		if (!objs.isEmpty()) {
			defaultTable.setColumnIdentifiers(HEADERS);
		}
		
		for (String[] person : objs) {
			int position = 0;
			String startDate = person[position++];
			String endDate = person[position++];
			String personId = person[position++];
			String situation = person[position++];
			String cardTechnology = person[position++];
			String cardNumber = person[position++];
			
			defaultTable.addRow(new Object[] {startDate, endDate, personId, situation, cardTechnology, cardNumber});
		}
	}

}
