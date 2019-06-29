package application;

import java.awt.EventQueue;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.alee.laf.WebLookAndFeel;

import application.components.AbaContainer;
import application.components.DialogLogin;
import database.models.Usuario;
import database.sqlite.DBase;

import java.awt.BorderLayout;
import java.awt.Dialog;

import javax.swing.JTabbedPane;

public class App {

	private Usuario user = null;
	private JFrame frmNavV;
	private AbaContainer aba;
	JTabbedPane 	tabs;
	private DialogLogin telalogin;
	private DBase banco;
	private Usuario usuario = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WebLookAndFeel.install();
					App window = new App();
					window.frmNavV.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public App() {
		initCustom();
		initialize();
		telalogin = new DialogLogin(this);
		this.banco = new DBase("navegador.db");
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmNavV = new JFrame();
		frmNavV.setTitle("Nav v0.000000000001");
		frmNavV.setBounds(100, 100, 450, 300);
		frmNavV.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmNavV.setExtendedState(frmNavV.getExtendedState()|JFrame.MAXIMIZED_BOTH);
		frmNavV.getContentPane().setLayout(new BorderLayout(0, 0));
		frmNavV.getContentPane().add(tabs, BorderLayout.CENTER);
		
		
		tabs.addTab(aba.getTitle(), aba);
		int tabIndex = tabs.getSelectedIndex();
		aba.setIndex(tabIndex);
		
		//frame.getContentPane().add(aba, "cell 0 0,grow");
		
	}

	private void initCustom()
	{
		tabs = new JTabbedPane(JTabbedPane.TOP);
		aba = new AbaContainer(this);
	}
	public void setTabTitle(int index, String title)
	{
		tabs.setTitleAt(index, title);
	}
	public void newTab() 
	{
		AbaContainer abaz = new AbaContainer(this);
		tabs.add("Nova aba", abaz);
		abaz.setIndex(tabs.getSelectedIndex());
		tabs.setSelectedComponent(abaz);
	}
	
	public void openLoginWindow() {
		telalogin.setVisible(true);
	}
	
	public boolean logarUsuario(String login, String senha)
	{
		if(banco.existeUsuario(login))
			{
				//verificar senha ta correta
				Usuario usr = banco.logar(login, senha);
				if(usr != null) //senha correta
				{
					this.usuario = usr;
					JOptionPane aviso = new JOptionPane();
					aviso.showMessageDialog(null, "Usuário logado com sucesso!", "Login", JOptionPane.INFORMATION_MESSAGE);
					return true;
				}
				else //senha incorreta 
				{
					JOptionPane aviso = new JOptionPane();
					aviso.showMessageDialog(null, "Senha incorreta!", "Erro de login", JOptionPane.INFORMATION_MESSAGE);
					return false;
				}
			}
		else 
			{
				//Criar novo?
				JOptionPane dialogConfirma = new JOptionPane();
				int confirma = dialogConfirma.showConfirmDialog(null, "Usuário inexistente! Deseja criá-lo?", "Login", JOptionPane.YES_NO_OPTION);
				
				if (confirma == 0) {
					banco.addUsuario(new Usuario(login, senha));
					telalogin.setVisible(false);
					return true;
				}
				else if (confirma == 1) {
					telalogin.setVisible(false);
				}
			}
		return false;
		
	}
}
