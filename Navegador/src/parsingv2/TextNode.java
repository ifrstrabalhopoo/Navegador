package parsingv2;

import parsingv2.html.EnumHTMLElement;

public class TextNode extends Node{
	
	public TextNode(String text, Node parent) {
		super();
		this.parent = parent;
		this.rawData = text;
		this.tag = EnumHTMLElement.TEXTNODE;
	}
}
