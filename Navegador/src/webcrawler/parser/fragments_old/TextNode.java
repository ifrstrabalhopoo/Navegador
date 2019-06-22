package webcrawler.parser.fragments_old;

public class TextNode extends Node{
	
	public TextNode(String text, Node parent) {
		super();
		this.parent = parent;
		this.rawData = text;
		this.tag = EnumHTMLElement.TEXTNODE;
	}
}
