package br.com.senior.importadorrondaseniorx.view.menu.search.documenttype;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.SwingWorker;

import br.com.senior.importadorrondaseniorx.controller.DocumentTypeController;
import br.com.senior.importadorrondaseniorx.utils.Utils;

public class DocumentTypeSearchView extends JPanel implements ActionListener {

	private static final long serialVersionUID = -4012003855378734795L;

	private final DocumentTypeSearchTableView tableView = new DocumentTypeSearchTableView();
	private final JButton searchButton = new JButton("Pesquisar");
	private final DocumentTypeController controller = new DocumentTypeController();

	public DocumentTypeSearchView() {
		setBounds(0, 0, 884, 463);
		setLayout(null);
		
		addTable();
		addButtons();
	}
	
	private void addTable() {
		tableView.setBounds(0, 0, 884, 405);
		add(tableView);
	}
	
	private void addButtons() {
		searchButton.setBounds(735, 416, 149, 25);
		searchButton.addActionListener(this);
		add(searchButton);
	}
	
	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		if (actionEvent.getSource() == searchButton) {
			loadTable();
        }
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
