package webcrawler.parser.fragments;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Node {
	private Node parent = null;
	private String name = "";
	private Node closingNode = null;
	private TagToken token = null;
	private boolean isClosingTagNode = false;
	
	public List<HTMLAttribute> attributes = new ArrayList<>();
	
	public Node() {
	}
	public Node(String name) {
		this.name = name;
	}
	public Node(Node parent) {
		this.parent = parent;
	}
	public void setParent(Node parent) {
		this.parent = parent;
	}
	public Node getParent() {
		return parent;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAttibutesFromWholeTag(String tagContent) {
		String regex = "(\\w+)(\\s*=\\s*)\"([^\"]+)\"";
		Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);
		Matcher m = p.matcher(tagContent);
		
		while(m.find()) 
		{
			HTMLAttribute attr = new HTMLAttribute(m.group(1), m.group(3));
			attributes.add(attr);
		}
		
	}
	public void setCloseNode(Node node) {
		this.closingNode = node;
	}
	public Node getClosingNode() {
		return closingNode;
	}
	public void setClosingNode(Node closingNode) {
		this.closingNode = closingNode;
	}
	public TagToken getToken() {
		return token;
	}
	public void setToken(TagToken token) {
		this.token = token;
		this.isClosingTagNode = token.isClosingTag();
	}
	public List<HTMLAttribute> getAttributes() {
		return attributes;
	}
	public boolean isClosingTagNode() {
		return isClosingTagNode;
	}
}
