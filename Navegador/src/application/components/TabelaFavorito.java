package application.components;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

import database.models.Favorito;
import database.models.Historico;

public class TabelaFavorito extends JFrame {
	private JPanel contentPane;
	private JTable table			= null;
	private application.App	app		= null;
	private JScrollPane scrollPane 	= null;

	public TabelaFavorito(application.App app, String orderby) {
		this.app = app;
		setTitle("Favoritos");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		init();
	}
	
	private void init()
	{
		String[] colunas = {"URL", "Data"};
		String[][] content = getContent();
		table = new JTable(content, colunas);
		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		contentPane.add(scrollPane, BorderLayout.CENTER);
		scrollPane.setViewportView(table);
		this.setVisible(true);
	}
	
	private String[][] getContent() {
		List<Favorito> favoritos;
		if(app.user != null)
		{
			favoritos = this.app.getBanco().getFavoritosLogado(app.user);			
		}
		else {
			favoritos = this.app.getBanco().getAllFavoritos();	
		}
		List<String[]> favs = new ArrayList<>();
		
		for(Favorito f : favoritos)
		{
			String[] data = new String[] {f.urlsite, f.data_adicionado.toString()};
			favs.add(data);
		}
		
		String[][] dados = favs.toArray(new String[0][]);
		return dados;
	}

}
