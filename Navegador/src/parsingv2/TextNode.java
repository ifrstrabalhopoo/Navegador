package parsingv2;

import javax.swing.JComponent;
import javax.swing.JLabel;

import parsingv2.html.EnumHTMLElement;

public class TextNode extends LeafNode {
	
	public TextNode(String text, Node parent) {
		super(text);
		this.parent = parent;
		this.tagName = "#textElement";
		this.rawData = text;
		this.tag = EnumHTMLElement.TEXTNODE;
	}

	@Override
	public JComponent getRenderedComponent() 
	{
		JComponent textLabel = new JLabel(this.rawData);
		return textLabel;
	}
}
