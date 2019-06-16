package parsingv2;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


import parsingv2.html.EnumHTMLElement;
import parsingv2.html.HTMLAttribute;



/**
 * Clase nó, possui as propriedades e os métodos de criação
 * do nó
 * 
 */
public class Node {
		protected List<Node> children = new ArrayList<>();
		protected List<HTMLAttribute> attributes = new ArrayList<>(); 
		protected String 			rawData = null;
		protected String 			tagName = null;
        protected EnumHTMLElement	tag = null;
		protected Node 				parent = null;
		protected int				level = 0;

		/**
		 * Gera um node com uma string denominano o tag name
		 * @param data tagname
		 */
    	protected Node(String data) {
    		this.rawData = data;
    	}
    	/**
    	 * Gera um node com tagname e parent
    	 * @param data tagname
    	 * @param parent node pai
    	 */
    	protected Node(String data, Node parent) {
    		this.rawData = data;
    		this.parent = parent;
    	}
    	/**
    	 * Gera um node completo com dados, tagname e parent
    	 * @param tagname
    	 * @param data Dados do nó
    	 * @param parent Nó pai
    	 * @return Novo nó
    	 */
    	public static Node makeNode(String tagname, String data, Node parent) {
    		Node node 			= new Node(data);
    		node.tagName 	= tagname;
    		node.tag		= EnumHTMLElement.fromString(tagname);
    		node.parent		= parent;
    		return node;
    	}
    	/**
    	 * Gera um node com dados, tagname (sem parent!)
    	 * @param tagname 
    	 * @param data Dados do nó
    	 * @return Novo nó
    	 */
    	public static Node makeNode(String tagname, String data) 
    	{
    		Node node 			= new Node(data);
    		node.tagName 		= tagname;
    		node.tag			= EnumHTMLElement.fromString(tagname);
    		return node;
    	}
    	/**
    	 * Lista dos filhos
    	 * @return ArrayList de filhos
    	 */
    	public List<Node> getChildren() 
    	{
    		return this.children;
    	}
    	public void addChild(Node child) 
    	{
    		this.children.add(child);
    		child.parent = this;
    	}
    	
    	public void addParent(Node parent) 
    	{
    		this.parent = parent;
    	}
    	
    	public Node getParent()
    	{
    		return this.parent;
    	}
    	
    	public String getRawData() 
    	{
    		return this.rawData;
    	}
    	
    	public boolean isLeaf() 
    	{
    		if(this.children.isEmpty()) 
    			return true;
    		
    		return false;
    	}
    	public boolean hasAttribute() 
    	{
    		if(!this.attributes.isEmpty())
    			return true;
    		return false;
    	}
    	public List<HTMLAttribute> getAttributes() 
    	{
    		return this.attributes;
    	}
    	public void setLevel(int level) 
    	{
    		this.level = level;
    	}
    	public int getLevel() {
    		return this.level;
    	}
    	
    	public void processAttributes() 
    	{
    		if(!(this instanceof TextNode))
    		{
        		String attributesRegex = "(\\S+)\\s*=\\s*([']|[\"])\\s*([\\W\\w]*?)\\s*\\2";
        		Pattern pat = Pattern.compile(attributesRegex);
        		String data =this.rawData;
        		
        		Matcher m = pat.matcher(data);
        		
        		while(m.find())
        		{
        			HTMLAttribute newAttribute = new HTMLAttribute(m.group(1), m.group(3));
        			//TODO: TRATAR ATRIBUTO SRC
        			this.attributes.add(newAttribute);
        		}
    		}
    		
    	}
    	
    	@Override
    	public String toString()
    	{
    		return this.tagName;
    	}
    }