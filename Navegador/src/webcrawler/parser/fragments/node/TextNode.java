package webcrawler.parser.fragments.node;

import java.awt.Color;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;


public class TextNode extends Node {
	protected String textValue;
	
	public TextNode(String text) {
		convertHTMLEscapeStrings(text);
	}
	
	public String getText() 
	{
		return this.textValue;
	}
	@Override
	public String toString( ) {
		return textValue;
	}
	@Override
	public boolean isRenderAble() {
		if(this.isChildOf("body") && !this.isChildOf("script")) return true;
		else return false;
	}
	public Style getStyle(Style s) {
		if(this.isChildOf("b"))
			StyleConstants.setBold(s, true);
		if(this.isChildOf("i"))
			StyleConstants.setBold(s, true);
		if(this.isChildOf("a"))
			StyleConstants.setForeground(s, new Color(0,0,255));
		if(this.isChildOf("h6"))
			StyleConstants.setFontSize(s, 12);
		if(this.isChildOf("h5"))
			StyleConstants.setFontSize(s, 14);
		if(this.isChildOf("h4"))
			StyleConstants.setFontSize(s, 16);
		if(this.isChildOf("h3"))
			StyleConstants.setFontSize(s, 18);
		if(this.isChildOf("h2"))
			StyleConstants.setFontSize(s, 20);
		if(this.isChildOf("h1"))
			StyleConstants.setFontSize(s, 22);
		if(this.isChildOf("center"))
			StyleConstants.setAlignment(s, StyleConstants.ALIGN_CENTER);
		return s;
	}
	
	private void convertHTMLEscapeStrings(String text) {
		String convertedText = text;
		convertedText = convertedText.replaceAll("&nbsp;", " ");
		convertedText = convertedText.replaceAll("&laquo;", "«");
		convertedText = convertedText.replaceAll("&quot;", "\"");
		convertedText = convertedText.replaceAll("&amp;", "&");
		convertedText = convertedText.replaceAll("&apos;", "'");
		convertedText = convertedText.replaceAll("&lt;", "<");
		convertedText = convertedText.replaceAll("gt;", ">");
		convertedText = convertedText.replaceAll("&excl;", "!");
		convertedText = convertedText.replaceAll("&QUOT;", "\"");
		convertedText = convertedText.replaceAll("&num;", "#");
		convertedText = convertedText.replaceAll("&dollar;", "$");
		convertedText = convertedText.replaceAll("&percnt;", "%");
		convertedText = convertedText.replaceAll("&lpar;", "(");
		convertedText = convertedText.replaceAll("&rpar;", ")");
		convertedText = convertedText.replaceAll("&copy;", "©");
		convertedText = convertedText.replaceAll("&COPY;", "©");
		
		this.textValue = convertedText;
	}
}
