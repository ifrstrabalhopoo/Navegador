package webcrawler.render;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextPane;
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
	StyledDocument doc;
	List<Node> nodes;
	Style defaultStyle;
	WEBParser parser;
	public BasicRender(String url) throws MalformedURLException {
		URL path = new URL(url);
		parser = WEBParser.parse(path);
		nodes = parser.getNodes();
		List<Node> no1 = parser.getNodes();
		System.out.println("testre");
		initPane();
	}
	private void initPane() {
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
		return pane;
	}
	
	private void renderNodes() 
	{
		for (Node node : nodes) { 
			if(!node.isRenderAble()) continue;
			
			if (node instanceof TextNode) //render texto
			{
				TextNode tn = (TextNode) node;
				Style style = tn.getStyle(this.defaultStyle);
				String text = tn.getText();
				try {
					doc.insertString(doc.getLength(), text, style);
				} catch (BadLocationException e) {
					System.err.println("Não foi possível renderizar o texto: " + text);
				}
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
					} catch (BadLocationException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
