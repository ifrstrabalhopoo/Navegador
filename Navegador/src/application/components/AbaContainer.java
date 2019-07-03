package application.components;

import java.net.MalformedURLException;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import net.miginfocom.swing.MigLayout;
import webcrawler.render.BasicRender;
import java.awt.BorderLayout;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import database.models.Historico;


@SuppressWarnings("serial")
public class AbaContainer extends JPanel {
	private Barra 		menuBar;
	private BasicRender render;
	Historico			historico = null;
	JScrollPane 		scrollPane = null;
	JPanel 				panel;
	JLabel 				loadingLabel;
	JLabel 				errorlabel;
	String 				titulo = "Nova aba";
	int					tabindex;
	application.App		app = null;
	
	/**
	 * A aba em si, constituida de menu e conteudo
	 * @throws MalformedURLException 
	 */
	public AbaContainer(application.App app2){
		app = app2;
		initCustom();
		setLayout(new MigLayout("", "[600px:800px,grow]", "[55px:55px:55px,grow][500px:n,grow]"));
		
		add(menuBar, "cell 0 0,grow");
		panel = new JPanel();
		add(panel, "cell 0 1,grow");
		panel.setLayout(new BorderLayout(0, 0));
		
		
		loadingLabel = new JLabel("");
		loadingLabel.setHorizontalAlignment(SwingConstants.CENTER);
		loadingLabel.setIcon(new ImageIcon(AbaContainer.class.getResource("/application/icons/loader.gif")));
		
		errorlabel = new JLabel("");
		errorlabel.setHorizontalAlignment(SwingConstants.CENTER);
		errorlabel.setIcon(new ImageIcon(AbaContainer.class.getResource("/application/icons/errlogo.png")));
	}

	
	private void initCustom()
	{
		menuBar = new Barra(this);
	}
	
	public void loadPage(String url) {
		
		panel.removeAll();
		panel.add(loadingLabel, BorderLayout.CENTER);
		
		panel.revalidate();
		try {
			render = new BasicRender(url);
			JTextPane renderContent = render.getPane();
			renderContent.setCaretPosition(0);
			scrollPane = new JScrollPane(renderContent);
			
			titulo = render.getTitulo();
			panel.removeAll();
			scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			panel.add(scrollPane, BorderLayout.CENTER);
			app.setTabTitle(tabindex, titulo);
			this.historico = app.addHistorico(url);
			panel.revalidate();
			
		} catch (Exception e) {
			panel.add(errorlabel, BorderLayout.CENTER);
			titulo = "Erro...";
		}
		
	}
	public String getTitle()
	{
		return titulo;
	}
	public void setIndex(int i)
	{
		this.tabindex = i;
	}
	public void triggerNewTab()
	{
		app.newTab();
	}
	
}
