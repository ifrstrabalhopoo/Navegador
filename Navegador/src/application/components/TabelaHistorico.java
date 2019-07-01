package application.components;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.models.Historico;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;

@SuppressWarnings("serial")
public class TabelaHistorico extends JFrame {

	private JPanel contentPane 		= null;;
	private JTable table			= null;
	private application.App	app		= null;
	private JScrollPane scrollPane 	= null;

	
	public TabelaHistorico(application.App app, String orderby) {
		this.app = app;
		setTitle("Histórico");
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
		List<Historico> historicos;
		if(app.user != null)
		{
			historicos = this.app.getBanco().getHistoricosLogado(app.user);			
		}
		else {
			historicos = this.app.getBanco().getAllHistoricos();	
		}
		List<String[]> hists = new ArrayList<>();
		
		for(Historico h : historicos)
		{
			String[] data = new String[] {h.urlsite, h.data_adicionado.toString()};
			hists.add(data);
		}
		
		String[][] dados = hists.toArray(new String[0][]);
		return dados;
	}

}
