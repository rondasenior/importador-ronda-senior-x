package br.com.senior.importadorrondaseniorx.view.menu.imports.badge;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import br.com.senior.importadorrondaseniorx.view.core.GenericTableView;

public class BadgeImportTableView extends GenericTableView {

	private static final long serialVersionUID = -6536061744080319988L;
	
	public static final String[] HEADERS = {"Data de Fim (dd/MM/yyyy HH:mm)", "* ID da Pessoa (Long)",
											"* Situacao (0 - Liberado, 1 - Bloqueado)", "* Tecnologia (1 - Barras, 2 - Proximidade, 3 - Smart Card)",
											"* Numero (Long)"};

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
			String endDate = person[position++];
			String personId = person[position++];
			String situation = person[position++];
			String cardTechnology = person[position++];
			String cardNumber = person[position++];
			
			defaultTable.addRow(new Object[] {endDate, personId, situation, cardTechnology, cardNumber});
		}
	}

}
