package br.com.senior.importadorrondaseniorx.view.menu.search.person;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JPanel;

import br.com.senior.importadorrondaseniorx.controller.PersonController;
import br.com.senior.importadorrondaseniorx.utils.Utils;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JDialog;

public class PersonSearchView extends JPanel implements ActionListener, ItemListener {

	private static final long serialVersionUID = -4012003855378734795L;

	private Integer searchPage = 1;
	
	private final PersonSearchTableView tableView = new PersonSearchTableView();
	private final PersonController controller = new PersonController();
	private final JTextField nameTextField = new JTextField();
	private final JLabel nameLabel = new JLabel("Nome");
	private final JButton searchButton = new JButton("Pesquisar");
	private final JButton nextSearchButton = new JButton(Utils.getImageIcon("/images/next.png", "next"));
	private final JButton previousSearchButton = new JButton(Utils.getImageIcon("/images/previous.png", "previous"));
	private final JLabel pageLabel = new JLabel(searchPage.toString());
	private final JCheckBox searchWithTermCheckBox = new JCheckBox();
	private final JLabel searchWithTermLabel = new JLabel("Pesquisar pelo nome");

	public PersonSearchView() {
		searchWithTermLabel.setLabelFor(searchWithTermCheckBox);
		setBounds(0, 0, 884, 488);
		setLayout(null);
		
		addTable();
		addFields();
		addLabels();
		addButtons();
		addCheckBox();
	}
	
	public void init() {
		showSearchAll();
	}
	
	private void addTable() {
		tableView.setBounds(0, 47, 884, 405);
		add(tableView);
	}
	
	
	private void addFields() {
		nameTextField.setBounds(0, 16, 415, 20);
		nameTextField.setColumns(10);
		add(nameTextField);
	}
	
	private void addLabels() {
		nameLabel.setBounds(0, 0, 46, 14);
		add(nameLabel);
		
		pageLabel.setBounds(434, 463, 28, 25);
		pageLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		pageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(pageLabel);
		
		searchWithTermLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		searchWithTermLabel.setBounds(712, 16, 149, 24);
		add(searchWithTermLabel);
	}
	
	private void addButtons() {
		searchButton.setBounds(735, 463, 149, 25);
		searchButton.addActionListener(this);
		add(searchButton);
		
		nextSearchButton.setBounds(462, 465, 22, 23);
		nextSearchButton.addActionListener(this);
		add(nextSearchButton);
		
		previousSearchButton.setBounds(413, 465, 22, 23);
		previousSearchButton.addActionListener(this);
		add(previousSearchButton);
	}
	
	private void addCheckBox() {
		searchWithTermCheckBox.setBounds(867, 17, 17, 23);
		searchWithTermCheckBox.addItemListener(this);
		add(searchWithTermCheckBox);
	}
	
	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		if (actionEvent.getSource() == searchButton) {
			loadTableWithTerm();
        } else if (actionEvent.getSource() == nextSearchButton) {
        	searchPage++;
        	previousSearchButton.setEnabled(Boolean.TRUE);
        	pageLabel.setText(searchPage.toString());
        	loadTablePaged();
        } else if (actionEvent.getSource() == previousSearchButton) {
        	previousSearchButton.setEnabled(--searchPage > 1);
        	pageLabel.setText(searchPage.toString());
        	loadTablePaged();
        }
	}

	private void loadTableWithTerm() {
		JDialog loading = Utils.loading();
		
		@SuppressWarnings("rawtypes")
		SwingWorker worker = new SwingWorker() {
			@Override
			protected Void doInBackground() throws Exception {
				setVisible(Boolean.FALSE);
				tableView.updateTable(controller.getPersonSearchWithTerm(nameTextField.getText()));
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
	
	private void loadTablePaged() {
		JDialog loading = Utils.loading();
		
		@SuppressWarnings("rawtypes")
		SwingWorker worker = new SwingWorker() {
			@Override
			protected Void doInBackground() throws Exception {
				setVisible(Boolean.FALSE);
				tableView.updateTable(controller.getPersonPagedSearchAll(searchPage));
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

	@Override
	public void itemStateChanged(ItemEvent itemEvent) {
		if (itemEvent.getSource() == searchWithTermCheckBox) {
			if (itemEvent.getStateChange() == ItemEvent.SELECTED) {
				showSearchWithTerm();
			} else {
				showSearchAll();
			}
		}
	}
	
	private void showSearchWithTerm() {
		nameLabel.setVisible(Boolean.TRUE);
		nameTextField.setVisible(Boolean.TRUE);
		searchButton.setVisible(Boolean.TRUE);
		
		pageLabel.setVisible(Boolean.FALSE);
		nextSearchButton.setVisible(Boolean.FALSE);
		previousSearchButton.setVisible(Boolean.FALSE);
		
		tableView.clearTable();
	}
	
	private void showSearchAll() {
		pageLabel.setVisible(Boolean.TRUE);
		nextSearchButton.setVisible(Boolean.TRUE);
		previousSearchButton.setVisible(Boolean.TRUE);
		
		nameLabel.setVisible(Boolean.FALSE);
		nameTextField.setVisible(Boolean.FALSE);
		searchButton.setVisible(Boolean.FALSE);
		
		searchPage = 1;
		pageLabel.setText(searchPage.toString());
		previousSearchButton.setEnabled(Boolean.FALSE);
		loadTablePaged();
	}
}
