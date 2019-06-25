package application.components;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Dimension;

public class LoginDialog extends JDialog {
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			LoginDialog dialog = new LoginDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public LoginDialog() {
		setAlwaysOnTop(true);
		setSize(new Dimension(340, 240));
		getContentPane().setSize(new Dimension(340, 200));
		setResizable(false);
		setTitle("Login");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setBounds(53, 49, 66, 15);
		getContentPane().add(lblLogin);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(53, 91, 66, 15);
		getContentPane().add(lblSenha);
		
		textField = new JTextField();
		textField.setBounds(120, 42, 280, 30);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(120, 84, 280, 30);
		getContentPane().add(passwordField);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setBounds(69, 147, 114, 25);
		getContentPane().add(btnLogin);
		
		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.setBounds(248, 147, 114, 25);
		getContentPane().add(btnCancelar);
	}
}
