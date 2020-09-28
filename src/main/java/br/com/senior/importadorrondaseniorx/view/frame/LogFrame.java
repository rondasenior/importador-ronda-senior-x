package br.com.senior.importadorrondaseniorx.view.frame;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.Highlighter;

import br.com.senior.importadorrondaseniorx.core.HighlightPainter;
import br.com.senior.importadorrondaseniorx.utils.Utils;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class LogFrame extends JFrame implements ChangeListener, ActionListener {

	private static final long serialVersionUID = 4771880674024563230L;
	
	private final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	private final JTextField searchField = new JTextField();
	private JTextArea textArea;
	
	private String messageTextArea;
	private Highlighter.HighlightPainter logHighlightPainter = new HighlightPainter(Color.YELLOW);
	private final JButton nextSearchButton = new JButton(Utils.getImageIcon("/images/next.png", "next"));
	private final JButton previousSearchButton = new JButton(Utils.getImageIcon("/images/previous.png", "previous"));
	
	public LogFrame(String logTitle, String messageTextArea) {
		this.messageTextArea = messageTextArea;
		setTitle("Log - " + logTitle);
		initialize();
	}
	
	private void initialize() {
		setBounds(0, 0, 902, 598);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
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
	
	private void insertPanelTextAreaComponents() {
		textArea = new JTextArea(messageTextArea);
		textArea.setLocation(0, 0);
		textArea.setColumns(100);
	    textArea.setRows(10);
	    textArea.setEditable(Boolean.FALSE);
	    textArea.getCaret().setVisible(true);
		tabbedPane.add("Log", new JScrollPane(textArea));
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
}
