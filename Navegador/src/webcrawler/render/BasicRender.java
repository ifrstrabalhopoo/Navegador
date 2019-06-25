package webcrawler.render;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

import webcrawler.parser.WEBParser;
import webcrawler.parser.fragments.node.ImageNode;
import webcrawler.parser.fragments.node.Node;
import webcrawler.parser.fragments.node.TextNode;

public class BasicRender {
	JTextPane pane;
	JScrollPane scrollpane;
	StyledDocument doc;
	List<Node> nodes;
	Style defaultStyle;
	WEBParser parser;
	String titulo;
	
	public BasicRender(String url) throws MalformedURLException, BadLocationException {
		URL path = new URL(url);
		titulo = path.getHost();
		parser = WEBParser.parse(path);
		nodes = parser.getNodes();
		initPane();
	}
	
	public BasicRender(URL url) throws MalformedURLException, BadLocationException {
		URL path = url;
		parser = WEBParser.parse(path);
		nodes = parser.getNodes();
		initPane();
	}
	
	private void initPane() throws BadLocationException {
		pane = new JTextPane();
		pane.setEditable(false);
		doc = pane.getStyledDocument();
		initializeStyles();
		renderNodes();
	}
	/**
	 * Inicializa os estilos que serão uitilizados no documento
	 */
	private void initializeStyles() {
		defaultStyle = StyleContext.getDefaultStyleContext()
				.getStyle(StyleContext.DEFAULT_STYLE);
	}
	
	public JTextPane getPane() {
		scrollpane = new JScrollPane();
		scrollpane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollpane.add(pane);
		return pane;
	}
	public String getTitulo()
	{
		return titulo;
	}
	
	private void renderNodes() throws BadLocationException 
	{
		for (Node node : nodes) { 
			if(!node.isRenderAble()) continue;
			
			if (node instanceof TextNode) //render texto
			{
				TextNode tn = (TextNode) node;
				Style style = tn.getStyle();
				String text = tn.getText();
				if(tn.isChildOf("ul"))
					text += " ";
				if(tn.isChildOf("li"))
					text = "\t [" + text +"]";
				if(tn.isChildOf("title"))
					titulo = tn.getText();
				if(tn.isChildOf("a"))
					text += " ";
					doc.insertString(doc.getLength(), text, style);
				
			}
			else if (node instanceof ImageNode) //render imagem
			{
				ImageNode in = (ImageNode) node;
				URL url = in.getUrl();
				if(url == null)
				{
					System.out.println("Erro ao buscar caminho da imagem");
				}
				else 
				{
					Style s = doc.addStyle("image", defaultStyle);
					StyleConstants.setAlignment(s, StyleConstants.ALIGN_CENTER);
					ImageIcon icon = new ImageIcon(url, "Imagem");
					StyleConstants.setIcon(s, icon);
					try {
						doc.insertString(doc.getLength(), "\n", defaultStyle);
						doc.insertString(doc.getLength(), "\n", s);
					} catch (BadLocationException | ArrayIndexOutOfBoundsException e) {
						System.err.println("Erro ao inserir elemento no texto\n"+e.getMessage());
					}
				}
				
			}
		}
	}
	
}
