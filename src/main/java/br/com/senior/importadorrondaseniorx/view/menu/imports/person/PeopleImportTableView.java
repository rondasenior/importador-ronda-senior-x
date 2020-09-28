package br.com.senior.importadorrondaseniorx.view.menu.imports.person;

import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.com.senior.importadorrondaseniorx.view.core.GenericTableView;

public class PeopleImportTableView extends GenericTableView {

	private static final long serialVersionUID = 6926923076923867562L;

	public static final String[] HEADERS = {"Nome", "Genero", "Aniversario", "Matricula", "Endereco", "Bairro", "Cidade",
											"Estado", "CEP", "Nacionalidade", "ID Tipo do Documento", "Documento", 
											"E-mail Preferencial", "E-mail", "Telefone Preferencial",
											"DDI Telefone", "Telefone"};
	
	@SuppressWarnings("unchecked")
	@Override
	public void updateTable(Object objs) {
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		addPeopleInTable((List<String[]>) objs, newDefaultTable());
		showTable();
		resizeColumnWidth();
	}
	
	private void addPeopleInTable(List<String[]> objs, DefaultTableModel defaultTable) {
		if (!objs.isEmpty()) {
			defaultTable.setColumnIdentifiers(HEADERS);
		}
		
		for (String[] person : objs) {
			int position = 0;
			String name = person[position++];
			String gender = person[position++];
			String birthday = person[position++];
			String registry = person[position++];
			String address = person[position++];
			String district = person[position++];
			String city = person[position++];
			String federalState = person[position++];
			String zipCode = person[position++];
			String nationality = person[position++];
			String documentTypeId = person[position++];
			String document = person[position++];
			String emailPreferential = person[position++];
			String email = person[position++];
			String phonePreferential = person[position++];
			String phoneDdi = person[position++];
			String phone = person[position++];
			
			defaultTable.addRow(new Object[] {name, gender, birthday, registry, address, district, city,
											  federalState, zipCode, nationality, documentTypeId,
											  document, emailPreferential, email, phonePreferential,
											  phoneDdi, phone});
		}
	}
}
