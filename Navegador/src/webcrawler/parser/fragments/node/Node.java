package webcrawler.parser.fragments.node;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JComponent;

import webcrawler.parser.fragments.HTMLAttribute;
import webcrawler.parser.fragments.token.TagToken;

public abstract class Node {
	protected URL webpageSourceURL = null;
	protected Node parent = null;
	protected String name = "";
	protected TagToken token = null;
	public List<Node> children = new ArrayList<>();
	protected List<HTMLAttribute> attributes = new ArrayList<>();
	
	public Node() {
	}
	public Node(String name) {
		this.name = name;
	}
	public Node(Node parent) {
		this.parent = parent;
	}
	public abstract boolean isRenderAble();
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
	public TagToken getToken() {
		return token;
	}
	public void setToken(TagToken token) {
		this.token = token;
	}
	public List<HTMLAttribute> getAttributes() {
		return attributes;
	}
	public Node hasParent() {
		if(this.parent != null) return parent;
		else return null;
	}
	@Override
	public String toString() {
		return name;
	}
	public int countParents() {
		int count = -1;
		Node parent = this;
		while(parent != null)
		{
			count++;
			parent = parent.parent;
		}
		return count;
	}
	
	public boolean isChildOf(String tagname)
	{
		Node parent = this;
		while(parent != null) 
		{
			if(parent.getName().toLowerCase().equals(tagname.toLowerCase())) return true;
			parent = parent.parent;
		}
		return false;
	}
	public JComponent toJComponent() 
	{
		return null;
	}
	public void setSourceURL(URL url) {
		webpageSourceURL = url;
	}
}
