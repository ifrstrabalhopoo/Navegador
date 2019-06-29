package application.components;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import application.App;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DialogLogin extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField login;
	private JPasswordField senha;
	private App app;
	

	/**
	 * Create the dialog.
	 */
	public DialogLogin(App app) {
		this.app = app;
		setTitle("Login");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 434, 40);
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 228, 434, 33);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						fazerLogin();
					}
				});
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		{
			login = new JTextField();
			login.setBounds(137, 51, 213, 20);
			getContentPane().add(login);
			login.setColumns(10);
		}
		
		senha = new JPasswordField();
		senha.setBounds(137, 86, 213, 20);
		getContentPane().add(senha);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(81, 54, 46, 14);
		getContentPane().add(lblLogin);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(81, 89, 46, 14);
		getContentPane().add(lblSenha);
	}
	
	private String getLoginText() {
		return this.login.getText();
	}
	private String getSenhaText() {
		return new String(this.senha.getPassword());
	}
	private void fazerLogin() {
		String login = getLoginText();
		String senha = getSenhaText();
		this.app.logarUsuario(login, senha);
	}
	
}
