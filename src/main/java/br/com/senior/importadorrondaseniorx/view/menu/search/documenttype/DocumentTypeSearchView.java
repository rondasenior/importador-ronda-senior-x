package br.com.senior.importadorrondaseniorx.view.menu.search.documenttype;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.SwingWorker;

import br.com.senior.importadorrondaseniorx.controller.DocumentTypeController;
import br.com.senior.importadorrondaseniorx.utils.Utils;

public class DocumentTypeSearchView extends JPanel {

	private static final long serialVersionUID = -4012003855378734795L;

	private final DocumentTypeSearchTableView tableView = new DocumentTypeSearchTableView();
	private final DocumentTypeController controller = new DocumentTypeController();

	public DocumentTypeSearchView() {
		setBounds(0, 0, 884, 463);
		setLayout(null);
		
		addTable();
	}
	
	public void onInit() {
		loadTable();
	}
	
	private void addTable() {
		tableView.setBounds(0, 0, 884, 405);
		add(tableView);
	}

	private void loadTable() {
		JDialog loading = Utils.loading();
		
		@SuppressWarnings("rawtypes")
		SwingWorker worker = new SwingWorker() {
			@Override
			protected Void doInBackground() throws Exception {
				setVisible(Boolean.FALSE);
				tableView.updateTable(controller.getAllDocumentType());
				return null;
			}
		};
		
		worker.addPropertyChangeListener(evt -> {
			if (SwingWorker.StateValue.DONE == evt.getNewValue()) {
				loading.setVisible(Boolean.FALSE);
				setVisible(Boolean.TRUE);
		    }
		});

		worker.execute();
	}
}
