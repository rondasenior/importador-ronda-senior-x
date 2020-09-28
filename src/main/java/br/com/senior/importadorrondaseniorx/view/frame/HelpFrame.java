package br.com.senior.importadorrondaseniorx.view.frame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.StringJoiner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.Highlighter;

import br.com.senior.importadorrondaseniorx.core.HighlightPainter;
import br.com.senior.importadorrondaseniorx.enums.Help;
import br.com.senior.importadorrondaseniorx.utils.Utils;

public class HelpFrame extends JFrame implements ChangeListener, ActionListener {

	private static final long serialVersionUID = -6723848833941220611L;

	private final JTextField searchField = new JTextField();
	private final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	private JTextArea textArea;
	private final JButton nextSearchButton = new JButton(Utils.getImageIcon("/images/next.png", "next"));
	private final JButton previousSearchButton = new JButton(Utils.getImageIcon("/images/previous.png", "previous"));

	private Highlighter.HighlightPainter logHighlightPainter = new HighlightPainter(Color.YELLOW);
	private String messageTextArea;
	private String frameTitle;
	
	public HelpFrame(Help help) {
		configureHelp(help);
		createFrame();
	}
	
	private void configureHelp(Help help) {
		if (help == Help.IMPORT) {
			setMessageTextAreaImport();
			frameTitle = "Ajuda - Importação";
		} else if (help == Help.SEARCH) {
			setMessageTextAreaSearch();
			frameTitle = "Ajuda - Pesquisa";
		}
	}
	
	private void createFrame() {
		setBounds(0, 0, 902, 598);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle(frameTitle);
		setResizable(Boolean.FALSE);
		getContentPane().setLayout(null);
		setVisible(true);
		setIconImage(Utils.getSeniorImage());
		
		insertComponents();
	}

	private void insertComponents() {
		tabbedPane.setBounds(10, 45, 868, 504); 
		tabbedPane.addChangeListener(this);
		getContentPane().add(tabbedPane);
		
		insertPanelTextAreaComponents();
		createSearch();
	}
	
	private void insertPanelTextAreaComponents() {
		textArea = new JTextArea(messageTextArea);
		textArea.setLocation(0, 0);
		textArea.setColumns(100);
	    textArea.setRows(10);
	    textArea.setEditable(Boolean.FALSE);
	    textArea.getCaret().setVisible(true);
		tabbedPane.add("Sobre", new JScrollPane(textArea));
	}
	
	private void createSearch() {
		searchField.setBounds(10, 12, 814, 20);
		searchField.setColumns(10);
		searchField.addActionListener(this);
		getContentPane().add(searchField);
		
		nextSearchButton.setBounds(856, 11, 22, 23);
		nextSearchButton.addActionListener(this);
		getContentPane().add(nextSearchButton);
		
		previousSearchButton.setBounds(834, 11, 22, 23);
		previousSearchButton.addActionListener(this);
		getContentPane().add(previousSearchButton);
	}
	
	@Override
	public void stateChanged(ChangeEvent e) {
		if (e.getSource() instanceof JTabbedPane) {
            if (e.getSource() == tabbedPane) {
            }
        }
	}
	
	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		if (actionEvent.getSource() == searchField) {
			HighlightPainter.highlight(textArea, searchField.getText(), logHighlightPainter);
        } else if (actionEvent.getSource() == nextSearchButton) {
			HighlightPainter.next(textArea);
        } else if (actionEvent.getSource() == previousSearchButton) {
			HighlightPainter.previous(textArea);
        }
	}
	
	private void setMessageTextAreaImport() {
		messageTextArea = new StringJoiner("\n")
		.add("Sobre a Importação")
		.add("-----------------------------------------------------------------------------------------------------------")
		.add("")
		.add("- Botões")
		.add("Log: o log será habilitado após você confirmar a importação")
		.add("Arquivo Modelo: irá fazer download de um arquivo modelo de importação da importação selecionada")
		.add("Importar: irá selecionar o arquivo que deseja importar")
		.add("Confirmar: após carregar o arquivo de importação este botão será habilitado que possa ser feito a importação")
		.toString();
	}
	
	private void setMessageTextAreaSearch() {
		messageTextArea = new StringJoiner("\n")
		.add("Sobre a Pesquisa")
		.add("-----------------------------------------------------------------------------------------------------------")
		.add("")
		.add("- Consulta de Pessoas:")
		.add("A pesquisa por padrão já vem no modo paginado, quando clicado no botão da próxima ou anterior a pesquisa é")
		.add("feita automáticamete.")
		.add("Caso queira pesquisar por nome basta selecionar o checkbox \"Pesquisar pelo nome\" onde deverá digitar o")
		.add("nome e clicar em PESQUISAR")
		.toString();
	}
}
