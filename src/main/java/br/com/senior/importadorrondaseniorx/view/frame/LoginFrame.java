package br.com.senior.importadorrondaseniorx.view.frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingWorker;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.springframework.web.client.HttpClientErrorException;

import br.com.senior.importadorrondaseniorx.controller.LoginController;
import br.com.senior.importadorrondaseniorx.core.JsonParseExceptionUnauthorized;
import br.com.senior.importadorrondaseniorx.dto.LoginInputDto;
import br.com.senior.importadorrondaseniorx.utils.Utils;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTabbedPane;

public class LoginFrame extends JFrame implements ActionListener, ChangeListener {

	private static final long serialVersionUID = 9034641269185218755L;
	private static final Font FONT = new Font("Tahoma", Font.BOLD, 11);
	
	private JButton btnLoginByUser = new JButton("Entrar");
	private JButton btnLoginByKey = new JButton("Entrar");
	private final JLabel seniorImage = new JLabel(Utils.getImageIcon("/images/senior.png", "senior"));
	
	private final JPanel panelByUser = new JPanel();
	private final JLabel userLabel = new JLabel("Usuário");
	private final JTextField userField = new JTextField();
	private final JLabel userPasswordLabel = new JLabel("Senha");
	private final JPasswordField userPasswordField = new JPasswordField();
	
	private final JPanel panelByKey = new JPanel();
	private final JLabel keyLabel = new JLabel("Chave");
	private final JTextField keyField = new JTextField();
	private final JLabel keyPasswordLabel = new JLabel("Senha");
	private final JPasswordField keyPasswordField = new JPasswordField();
	private final JLabel keyTenatLabel = new JLabel("Tenant");
	private final JTextField keyTenantField = new JTextField();
	
	private final LoginController loginController = new LoginController();
	private JTabbedPane tabbedPaneLogin;
	
	public LoginFrame() {
		initialize();
		insertComponents();
	}
	
	private void initialize() {
		setBounds(100, 100, 354, 394);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Importador Ronda Senior X");
		setResizable(Boolean.FALSE);
		getContentPane().setLayout(null);
		setVisible(true);
		setIconImage(Utils.getSeniorImage());

		seniorImage.setBounds(82, 11, 173, 55);
		getContentPane().add(seniorImage);
	}
	
	private void insertComponents() {
		insertLoginByUserComponents();
		insertLoginByKeyComponents();
		insertButtons();
		insertTabbedPaneLogin();
	}
	
	private void insertLoginByUserComponents() {
		userLabel.setBounds(33, 54, 248, 20);
		userLabel.setFont(FONT);

		userField.setBounds(33, 73, 248, 20);
		
		userPasswordLabel.setBounds(33, 101, 248, 20);
		userPasswordLabel.setFont(FONT);

		userPasswordField.setBounds(33, 121, 248, 20);
		
		panelByUser.setBackground(Color.LIGHT_GRAY);
		panelByUser.setLayout(null);
		panelByUser.add(userLabel);
		panelByUser.add(userField);
		panelByUser.add(userPasswordLabel);
		panelByUser.add(userPasswordField);
	}
	
	private void insertLoginByKeyComponents() {
		keyLabel.setBounds(33, 32, 248, 20);
		keyLabel.setFont(FONT);

		keyField.setBounds(33, 51, 248, 20);
		
		keyPasswordLabel.setBounds(33, 132, 248, 20);
		keyPasswordLabel.setFont(FONT);

		keyPasswordField.setBounds(33, 152, 248, 20);
		
		keyTenatLabel.setBounds(33, 82, 248, 20);
		keyTenatLabel.setFont(FONT);

		keyTenantField.setBounds(33, 101, 248, 20);
		
		panelByKey.setBackground(Color.LIGHT_GRAY);
		panelByKey.setLayout(null);
		panelByKey.add(keyLabel);
		panelByKey.add(keyField);
		panelByKey.add(keyPasswordLabel);
		panelByKey.add(keyPasswordField);
		panelByKey.add(keyTenatLabel);
		panelByKey.add(keyTenantField);
	}
	
	private void insertButtons() {
		btnLoginByUser.setBounds(110, 205, 89, 23);
		btnLoginByUser.addActionListener(this);
		panelByUser.add(btnLoginByUser);
		
		btnLoginByKey.setBounds(110, 205, 89, 23);
		btnLoginByKey.addActionListener(this);
		panelByKey.add(btnLoginByKey);
	}
	
	private void insertTabbedPaneLogin() {
		tabbedPaneLogin = new JTabbedPane(JTabbedPane.TOP);
		tabbedPaneLogin.setBounds(10, 77, 319, 267);
		tabbedPaneLogin.add("Por Usuário", panelByUser);  
		tabbedPaneLogin.add("Por Chave", panelByKey); 
		tabbedPaneLogin.addChangeListener(this);
		getContentPane().add(tabbedPaneLogin);
	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		if (actionEvent.getSource() == btnLoginByUser || actionEvent.getSource() == btnLoginByKey) {
			executeAuthentication(actionEvent.getSource() == btnLoginByUser);
		}
    }
	
	private void executeAuthentication(boolean isAuthenticationByUser) {
		JDialog loading = Utils.loading();
		
		@SuppressWarnings("rawtypes")
		SwingWorker worker = new SwingWorker() {
			@Override
			protected Void doInBackground() throws Exception {
				setVisible(Boolean.FALSE);
				if (isAuthenticationByUser) {
		        	doAuthenticationByUser();
		        } else {
		        	doAuthenticationByKey();
		        }
				return null;
			}
		};
		
		worker.addPropertyChangeListener(evt -> {
			if (SwingWorker.StateValue.DONE == evt.getNewValue()) {
				loading.setVisible(Boolean.FALSE);
				if (LoginController.isAuthenticated()) {
					new AppMainFrame();
				} else {
					setVisible(Boolean.TRUE);
				}
		    }
		});

		worker.execute();
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		if (e.getSource() instanceof JTabbedPane) {
            if (e.getSource() == tabbedPaneLogin) {
                clearLogin();
            }
        }
	}
	
	private void doAuthenticationByUser() {
		if (isUserAuthenticate()) {
			try {
				LoginInputDto dto = new LoginInputDto(userField.getText(), String.valueOf(userPasswordField.getPassword()));
				loginController.authenticateByUserPassword(dto);
			} catch (IOException | InterruptedException e) {
				Utils.showDialogMessageError("Erro", "Erro inesperado: " + e.getMessage());
			} catch (HttpClientErrorException e) {
				Utils.showDialogMessageError("Falha na autenticação" , JsonParseExceptionUnauthorized.getMessage(e.getResponseBodyAsString()));
			}
		}
	}
	
	private void doAuthenticationByKey() {
		if (isKeyAuthenticate()) {
			try {
				LoginInputDto dto = new LoginInputDto(keyField.getText(), new String(keyPasswordField.getPassword()), keyTenantField.getText(), null);
				loginController.authenticateByKey(dto);
			} catch (IOException e) {
				Utils.showDialogMessageError("Erro", "Erro inesperado: " + e.getMessage());
			} catch (HttpClientErrorException e) {
				Utils.showDialogMessageError("Falha na autenticação" , JsonParseExceptionUnauthorized.getMessage(e.getMessage()));
			}
		}
	}
	
	private void clearLogin() {
		userField.setText("");
		userPasswordField.setText("");
		
		keyField.setText("");
		keyPasswordField.setText("");
		keyTenantField.setText("");
	}
	
	private boolean isUserAuthenticate() {
		return userField.getText().length() > 0 || userPasswordField.getPassword().length > 0;
	}

	private boolean isKeyAuthenticate() {
		return keyField.getText().length() > 0 || keyPasswordField.getPassword().length > 0
				|| keyTenantField.getText().length() > 0;
	}
}
