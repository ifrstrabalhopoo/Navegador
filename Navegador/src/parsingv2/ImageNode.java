package parsingv2;

import parsingv2.html.EnumHTMLElement;

public class ImageNode extends Node {
	public ImageNode(String rawData, Node parent) {
		super();
		this.parent = parent;
		this.rawData = rawData;
		this.tag = EnumHTMLElement.IMG;
	}
}
