package br.com.senior.importadorrondaseniorx.view.menu.imports.role;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import br.com.senior.importadorrondaseniorx.view.core.GenericTableView;

public class RoleImportTableView extends GenericTableView {

	private static final long serialVersionUID = 2593552259337186251L;
	
	public static final String[] HEADERS = {"* Data de Inicio (dd/MM/yyyy HH:mm)", "Data de Fim (dd/MM/yyyy HH:mm)", "* ID da Pessoa (Long)", "* ID do Papel (Long)"};

	@SuppressWarnings("unchecked")
	@Override
	public void updateTable(Object objs) {
		addRoleInTable((List<String[]>) objs, newDefaultTable());
		showTable();
	}
	
	private void addRoleInTable(List<String[]> objs, DefaultTableModel defaultTable) {
		if (!objs.isEmpty()) {
			defaultTable.setColumnIdentifiers(HEADERS);
		}
		
		for (String[] person : objs) {
			int position = 0;
			String startDate = person[position++];
			String endDate = person[position++];
			String personId = person[position++];
			String roleId = person[position++];
			
			defaultTable.addRow(new Object[] {startDate, endDate, personId, roleId});
		}
	}

}
