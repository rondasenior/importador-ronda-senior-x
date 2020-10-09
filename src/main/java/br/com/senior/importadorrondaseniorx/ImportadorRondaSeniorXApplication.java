package br.com.senior.importadorrondaseniorx;

import java.awt.EventQueue;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import br.com.senior.importadorrondaseniorx.view.frame.LoginFrame;

@SpringBootApplication
public class ImportadorRondaSeniorXApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(ImportadorRondaSeniorXApplication.class).headless(false).run(args);
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				        if ("Metal".equals(info.getName())) {
				            UIManager.setLookAndFeel(info.getClassName());
				            break;
				        }
				    }
					new LoginFrame();
				} catch (Exception e) {
					
					e.printStackTrace();
				}
			}
		});
	}
}
