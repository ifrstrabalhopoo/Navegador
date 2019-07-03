package application;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.alee.laf.WebLookAndFeel;

import application.components.AbaContainer;
import application.components.DialogLogin;
import application.components.TabelaFavorito;
import application.components.TabelaHistorico;
import database.models.Favorito;
import database.models.Historico;
import database.models.Usuario;
import database.sqlite.DBase;

import java.awt.BorderLayout;
import java.awt.Dialog;

import javax.swing.JTabbedPane;

public class App {

	public	Usuario 		user 		= null;
	private JFrame 			app_frame 	= null;
	private AbaContainer 	aba 		= null;
	private JTabbedPane 	tabs 		= null;
	private DialogLogin 	telalogin 	= null;
	private DBase 			banco 		= null;
	private TabelaHistorico historicos	= null;
	private TabelaFavorito  favoritos	= null;
	private String			appTitle 	= "Navigathor v0.02";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WebLookAndFeel.install();
					App window = new App();
					window.app_frame.setVisible(true);
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
		this.banco = new DBase("navegador.db");
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		app_frame = new JFrame();
		app_frame.setTitle(appTitle);
		app_frame.setBounds(100, 100, 450, 300);
		app_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app_frame.setExtendedState(app_frame.getExtendedState()|JFrame.MAXIMIZED_BOTH);
		app_frame.getContentPane().setLayout(new BorderLayout(0, 0));
		app_frame.getContentPane().add(tabs, BorderLayout.CENTER);
		
		
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
		if(this.user == null)
		{
			telalogin = new DialogLogin(this);
			telalogin.setVisible(true);			
		}
		else
		{
			String msgLogout = "Você já está logado com usuário: " + user.login + ", deseja fazer logout?";
			int deslogar = JOptionPane.showConfirmDialog(app_frame, msgLogout, "Usuário já logado!", JOptionPane.YES_NO_OPTION);
			if(deslogar == 0) // deslogar
			{
				this.user = null;
				updateFrameStatus();
			}
			
		}
	}
	public DBase getBanco()
	{
		return this.banco;
				
	}
	
	public boolean logarUsuario(String login, String senha)
	{
		if(banco.existeUsuario(login))
			{
				//verificar senha ta correta
				Usuario usr = banco.logar(login, senha);
				if(usr != null) //senha correta
				{
					this.user = usr;
					JOptionPane.showMessageDialog(null, "Usuário logado com sucesso!", "Login", JOptionPane.INFORMATION_MESSAGE);
					this.telalogin.setVisible(false);
					this.telalogin = null;
					updateFrameStatus();
					return true;
				}
				else //senha incorreta 
				{
					JOptionPane.showMessageDialog(null, "Senha incorreta!", "Erro de login", JOptionPane.INFORMATION_MESSAGE);
					return false;
				}
			}
		else 
			{
				//Criar novo?
				int confirma = JOptionPane.showConfirmDialog(null, "Usuário inexistente! Deseja criá-lo?", "Login", JOptionPane.YES_NO_OPTION);
				
				if (confirma == 0) {
					banco.addUsuario(new Usuario(login, senha));
					telalogin.setVisible(false);
					telalogin = null;
					this.user = banco.logar(login, senha);
					updateFrameStatus();
					return true;
				}
				else if (confirma == 1) {
					telalogin.setVisible(false);
				}
			}
		return false;
		
	}
	private void updateFrameStatus()
	{
		//nome do usuário logado
		if(this.user != null) this.app_frame.setTitle(appTitle + "[Logado como usuário: "+this.user.login+"]"); 		
		else this.app_frame.setTitle(appTitle); 
		
	}
	public Historico addHistorico(String url) 
	{
		Historico hist = new Historico(url);
		if(this.user != null) hist.id_usuario = this.user.id;
		
		banco.addHistorico(hist);
		return hist;
	}
	public void addFavorito(Historico hist) {
		banco.addFavorito(new Favorito(hist));
	}
	public void abreTelaHistorico() 
	{
		historicos = new TabelaHistorico(this, "any");
	}
	public void abreTelaFavoritos() {
		favoritos = new TabelaFavorito(this, "any");
	}
}
