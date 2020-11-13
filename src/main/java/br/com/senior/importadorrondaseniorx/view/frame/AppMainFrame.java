package br.com.senior.importadorrondaseniorx.view.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import br.com.senior.importadorrondaseniorx.controller.LoginController;
import br.com.senior.importadorrondaseniorx.enums.Help;
import br.com.senior.importadorrondaseniorx.utils.Utils;
import br.com.senior.importadorrondaseniorx.view.menu.imports.badge.BadgeImportView;
import br.com.senior.importadorrondaseniorx.view.menu.imports.group.GroupImportView;
import br.com.senior.importadorrondaseniorx.view.menu.imports.person.PeopleImportView;
import br.com.senior.importadorrondaseniorx.view.menu.imports.role.RoleImportView;
import br.com.senior.importadorrondaseniorx.view.menu.search.documenttype.DocumentTypeSearchView;
import br.com.senior.importadorrondaseniorx.view.menu.search.group.GroupSearchView;
import br.com.senior.importadorrondaseniorx.view.menu.search.person.PersonSearchView;
import br.com.senior.importadorrondaseniorx.view.menu.search.role.RoleSearchView;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JMenu;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;

public class AppMainFrame extends JFrame implements ActionListener {

	private static final long serialVersionUID = -5207486940890598255L;
	
	private final String peopleValue = "Pessoas";
	private final String linkRoleValue = "Vincular Papéis";
	private final String linkGroupValue = "Vincular Grupos";
	private final String linkBadgeValue = "Vincular Crachás";
	private final String searchDocumentTypeValue = "Tipos de Documentos";
	private final String searchPersonValue = "Pessoas";
	private final String searchGroupValue = "Grupos";
	private final String searchRoleValue = "Papéis";
	
	private final JMenuBar menu = new JMenuBar();
	
	private final JPanel importPanel = new JPanel();
	private final JMenu importMenu = new JMenu("Importar");
	private final JMenuItem importPeopleMenuItem = new JMenuItem(peopleValue, Utils.getImageIcon("/images/menu-user.png", "menu-user"));
	private final JMenuItem importLinkRoleMenuItem = new JMenuItem(linkRoleValue, Utils.getImageIcon("/images/menu-role.png", "menu-role"));
	private final JMenuItem importLinkGroupMenuItem = new JMenuItem(linkGroupValue, Utils.getImageIcon("/images/menu-group.png", "menu-group"));
	private final JMenuItem importLinkBadgeMenuItem = new JMenuItem(linkBadgeValue, Utils.getImageIcon("/images/menu-badge.png", "menu-badge"));
	private PeopleImportView importPeopleView;
	private RoleImportView importLinkRoleView;
	private GroupImportView importLinkGroupView;
	private BadgeImportView importLinkBadgeView;
	
	private final JPanel searchPanel = new JPanel();
	private final JMenu searchMenu = new JMenu("Pesquisar");
	private final JMenuItem searchDocumentTypeMenuItem = new JMenuItem(searchDocumentTypeValue, Utils.getImageIcon("/images/doc.png", "doc"));
	private final JMenuItem searchPersonMenuItem = new JMenuItem(searchPersonValue, Utils.getImageIcon("/images/menu-group.png", "menu-group"));
	private final JMenuItem searchGroupMenuItem = new JMenuItem(searchGroupValue, Utils.getImageIcon("/images/menu-groups.png", "menu-groups"));
	private final JMenuItem searchRoleMenuItem = new JMenuItem(searchRoleValue, Utils.getImageIcon("/images/menu-role.png", "menu-role"));
	private DocumentTypeSearchView searchDocumentTypeView;
	private PersonSearchView searchPersonView;
	private GroupSearchView groupSearchView;
	private RoleSearchView roleSearchView;
	
	private final JMenu helpMenu = new JMenu("Ajuda");
	private final JMenuItem aboutImportMenuItem = new JMenuItem("Sobre Importação", Utils.getImageIcon("/images/help.png", "help"));
	private final JMenuItem aboutSearchMenuItem = new JMenuItem("Sobre Pesquisa", Utils.getImageIcon("/images/help.png", "help"));
	
	private final JLabel menuLabel = new JLabel();
	
	public AppMainFrame() {
		createFrame();
		insertComponents();
	}

	private void createFrame() {
		setBounds(100, 100, 929, 660);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Importador Ronda Senior X");
		setResizable(Boolean.FALSE);
		getContentPane().setLayout(null);
		setVisible(true);
		setIconImage(Utils.getSeniorImage());
		
		addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
            	if(e.getID() == WindowEvent.WINDOW_CLOSING) {
            		LoginController.resetToken();
                    new LoginFrame();
                }
            }
        });
	}

	private void insertComponents() {
		createImportMenuItems();
		createSearchMenuItems();
		createHelpMenuItems();
		
		createMenu();
		
		createMenuPanels();
		
		createImportPeople();
		createImportLinkRole();
		createImportLinkGroup();
		createImportLinkBadge();
		
		createSearchDocumentType();
		createSearchPerson();
		createGroupSearch();
		createRoleSearch();
		
		createLabels();
		createFooterPanel();
		
		showImportPeopleView();
		setVisibleImportPanel();
	}
	
	private void createMenu() {
		menu.setBounds(0, 0, 914, 22);
		menu.add(importMenu);
		menu.add(searchMenu);
		menu.add(helpMenu);
		getContentPane().add(menu);
	}
	
	private void createMenuPanels() {
		importPanel.setBounds(15, 61, 884, 521);
		importPanel.setLayout(null);
		getContentPane().add(importPanel);
		
		searchPanel.setBounds(15, 61, 884, 521);
		searchPanel.setLayout(null);
		getContentPane().add(searchPanel);
	}
	
	private void createLabels() {
		menuLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		menuLabel.setBounds(15, 22, 884, 40);
		getContentPane().add(menuLabel);
	}
	
	private void createImportMenuItems() {
		importMenu.add(importPeopleMenuItem);
		importMenu.add(importLinkRoleMenuItem);
		importMenu.add(importLinkGroupMenuItem);
		importMenu.add(importLinkBadgeMenuItem);
		
		importPeopleMenuItem.addActionListener(this);
		importLinkRoleMenuItem.addActionListener(this);
		importLinkGroupMenuItem.addActionListener(this);
		importLinkBadgeMenuItem.addActionListener(this);
	}
	
	private void createSearchMenuItems() {
		searchMenu.add(searchDocumentTypeMenuItem);
		searchMenu.add(searchPersonMenuItem);
		searchMenu.add(searchGroupMenuItem);
		searchMenu.add(searchRoleMenuItem);
		
		searchDocumentTypeMenuItem.addActionListener(this);
		searchPersonMenuItem.addActionListener(this);
		searchGroupMenuItem.addActionListener(this);
		searchRoleMenuItem.addActionListener(this);
	}
	
	private void createHelpMenuItems() {
		helpMenu.add(aboutImportMenuItem);
		helpMenu.add(aboutSearchMenuItem);
		
		aboutImportMenuItem.addActionListener(this);
		aboutSearchMenuItem.addActionListener(this);
	}
	
	private void createImportPeople() {
		importPeopleView = new PeopleImportView();
		importPeopleView.setBounds(0, 0, 884, 521);
		importPeopleView.setVisible(Boolean.TRUE);
		importPanel.add(importPeopleView);
	}
	
	private void createImportLinkRole() {
		importLinkRoleView = new RoleImportView();
		importLinkRoleView.setBounds(0, 0, 884, 521);
		importLinkRoleView.setVisible(Boolean.TRUE);
		importPanel.add(importLinkRoleView);
	}
	
	private void createImportLinkGroup() {
		importLinkGroupView = new GroupImportView();
		importLinkGroupView.setBounds(0, 0, 884, 521);
		importLinkGroupView.setVisible(Boolean.TRUE);
		importPanel.add(importLinkGroupView);
	}
	
	private void createImportLinkBadge() {
		importLinkBadgeView = new BadgeImportView();
		importLinkBadgeView.setBounds(0, 0, 884, 521);
		importLinkBadgeView.setVisible(Boolean.TRUE);
		importPanel.add(importLinkBadgeView);
	}
	
	private void createSearchDocumentType() {
		searchDocumentTypeView = new DocumentTypeSearchView();
		searchDocumentTypeView.setBounds(0, 0, 884, 521);
		searchDocumentTypeView.setVisible(Boolean.TRUE);
		searchPanel.add(searchDocumentTypeView);
	}
	
	private void createSearchPerson() {
		searchPersonView = new PersonSearchView();
		searchPersonView.setBounds(0, 0, 884, 521);
		searchPersonView.setVisible(Boolean.TRUE);
		searchPanel.add(searchPersonView);
	}
	
	private void createGroupSearch() {
		groupSearchView = new GroupSearchView();
		groupSearchView.setBounds(0, 0, 884, 521);
		groupSearchView.setVisible(Boolean.TRUE);
		searchPanel.add(groupSearchView);
	}
	
	private void createRoleSearch() {
		roleSearchView = new RoleSearchView();
		roleSearchView.setBounds(0, 0, 884, 521);
		roleSearchView.setVisible(Boolean.TRUE);
		searchPanel.add(roleSearchView);
	}
	
	@Override
	public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == importPeopleMenuItem) {
        	showImportPeopleView();
        	setVisibleImportPanel();
        } else if (actionEvent.getSource() == importLinkRoleMenuItem) {
        	showImportLinkRoleView();
        	setVisibleImportPanel();
        } else if (actionEvent.getSource() == importLinkGroupMenuItem) {
        	showImportLinkGroupView();
        	setVisibleImportPanel();
        } else if (actionEvent.getSource() == importLinkBadgeMenuItem) {
        	showImportLinkBadgeView();
        	setVisibleImportPanel();
        } else if (actionEvent.getSource() == searchDocumentTypeMenuItem) {
        	showSearchDocumentTypeView();
        	setVisibleSearchPanel();
        } else if (actionEvent.getSource() == searchPersonMenuItem) {
        	showSearchPersonView();
        	setVisibleSearchPanel();
        } else if (actionEvent.getSource() == searchGroupMenuItem) {
        	showSearchGroupView();
        	setVisibleSearchPanel();
        } else if (actionEvent.getSource() == searchRoleMenuItem) {
        	showSearchRoleView();
        	setVisibleSearchPanel();
        } else if (actionEvent.getSource() == aboutImportMenuItem) {
        	new HelpFrame(Help.IMPORT);
        } else if (actionEvent.getSource() == aboutSearchMenuItem) {
        	new HelpFrame(Help.SEARCH);
        }
    }
	
	private void setVisibleImportPanel() {
		importPanel.setVisible(Boolean.TRUE);
		searchPanel.setVisible(Boolean.FALSE);
	}
	
	private void setVisibleSearchPanel() {
		importPanel.setVisible(Boolean.FALSE);
		searchPanel.setVisible(Boolean.TRUE);
	}

	private void showImportPeopleView() {
		menuLabel.setText(peopleValue);
		importPeopleView.setVisible(Boolean.TRUE);
		importLinkRoleView.setVisible(Boolean.FALSE);
		importLinkGroupView.setVisible(Boolean.FALSE);
		importLinkBadgeView.setVisible(Boolean.FALSE);
	}
	
	private void showImportLinkRoleView() {
		menuLabel.setText(linkRoleValue);
		importPeopleView.setVisible(Boolean.FALSE);
		importLinkRoleView.setVisible(Boolean.TRUE);
		importLinkGroupView.setVisible(Boolean.FALSE);
		importLinkBadgeView.setVisible(Boolean.FALSE);
	}
	
	private void showImportLinkGroupView() {
		menuLabel.setText(linkGroupValue);
		importPeopleView.setVisible(Boolean.FALSE);
		importLinkRoleView.setVisible(Boolean.FALSE);
		importLinkGroupView.setVisible(Boolean.TRUE);
		importLinkBadgeView.setVisible(Boolean.FALSE);
	}
	
	private void showImportLinkBadgeView() {
		menuLabel.setText(linkBadgeValue);
		importPeopleView.setVisible(Boolean.FALSE);
		importLinkRoleView.setVisible(Boolean.FALSE);
		importLinkGroupView.setVisible(Boolean.FALSE);
		importLinkBadgeView.setVisible(Boolean.TRUE);
	}
	
	private void showSearchDocumentTypeView() {
		menuLabel.setText(searchDocumentTypeValue);
		searchDocumentTypeView.setVisible(Boolean.TRUE);
		searchPersonView.setVisible(Boolean.FALSE);
		groupSearchView.setVisible(Boolean.FALSE);
		roleSearchView.setVisible(Boolean.FALSE);
	}
	
	private void showSearchPersonView() {
		menuLabel.setText(searchPersonValue);
		searchDocumentTypeView.setVisible(Boolean.FALSE);
		searchPersonView.setVisible(Boolean.TRUE);
		groupSearchView.setVisible(Boolean.FALSE);
		roleSearchView.setVisible(Boolean.FALSE);
		
		searchPersonView.init();
	}
	
	private void showSearchGroupView() {
		menuLabel.setText(searchGroupValue);
		searchDocumentTypeView.setVisible(Boolean.FALSE);
		searchPersonView.setVisible(Boolean.FALSE);
		groupSearchView.setVisible(Boolean.TRUE);
		roleSearchView.setVisible(Boolean.FALSE);
	}
	
	private void showSearchRoleView() {
		menuLabel.setText(searchRoleValue);
		searchDocumentTypeView.setVisible(Boolean.FALSE);
		searchPersonView.setVisible(Boolean.FALSE);
		groupSearchView.setVisible(Boolean.FALSE);
		roleSearchView.setVisible(Boolean.TRUE);
	}
	
	private void createFooterPanel() {
		JPanel footerPanel = new JPanel();
		footerPanel.setBounds(0, 582, 914, 39);
		footerPanel.setBackground(Color.LIGHT_GRAY);
		footerPanel.setLayout(null);
		
		JLabel userNameLabel = new JLabel();
		userNameLabel.setBounds(10, 0, 420, 39);
		userNameLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		if (LoginController.isAuthenticated() &&  LoginController.getToken().getUserName() != null) {
			userNameLabel.setText("Usuário: " + LoginController.getToken().getUserName());
		} else {
			userNameLabel.setText("Autenticado por chave");
		}
		
		JLabel seniorImage = new JLabel(Utils.getImageIcon("/images/senior-footer.png", "senior-footer"));
		seniorImage.setBounds(808, 0, 106, 39);
		
		footerPanel.add(userNameLabel);
		footerPanel.add(seniorImage);
		getContentPane().add(footerPanel);
	}
}
