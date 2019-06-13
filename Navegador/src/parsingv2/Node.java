package parsingv2;
import java.util.ArrayList;
import java.util.List;



/**
 * Clase nó, possui as propriedades e os métodos de criação
 * do nó
 * 
 */
public class Node {
		protected List<Node> children = new ArrayList<Node>();
		protected List<String> 		renderEffects = null;
		protected String 		data = null;
		protected String 		tagName = null;
        
		protected Node 			parent = null;
		protected int 			level = 0;

		private Node() {
			
		}
		/**
		 * Gera um node com uma string denominano o tag name
		 * @param data tagname
		 */
    	public Node(String data) {
    		this.data = data;
    	}
    	/**
    	 * Gera um node com tagname e parent
    	 * @param data tagname
    	 * @param parent node pai
    	 */
    	public Node(String data, Node parent) {
    		this.data = data;
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
    		Node node 		= new Node();
    		node.data 		= Node.parseData(data);
    		node.tagName 	= tagname;
    		node.parent		= parent;
    		return node;
    	}
    	/**
    	 * Gera um node com dados, tagname (sem parent!)
    	 * @param tagname 
    	 * @param data Dados do nó
    	 * @return Novo nó
    	 */
    	public static Node makeNode(String tagname, String data) {
    		Node node 		= new Node();
    		node.data 		= Node.parseData(data);
    		node.tagName 	= tagname;
    		return node;
    	}
    	/**
    	 * Lista dos filhos
    	 * @return ArrayList de filhos
    	 */
    	public List<Node> getChildren() {
    		return this.children;
    	}
    	/**
    	 * Faz o parse dos dados da tag, null se não houver
    	 * @param data
    	 * @return
    	 */
    	protected static String parseData(String data) {
    		String result = data.replace(">", "");
    		result = result.trim();
    		if(result.isEmpty()) 
    			return null;
    		return result;
    	}
    	public void addChild(Node child) {
    		this.children.add(child);
    		child.parent = this;
    	}
    	
    	public void addParent(Node parent) {
    		this.parent = parent;
    	}
    	
    	public Node getParent(){
    		return this.parent;
    	}
    	
    	public String getData() {
    		return this.data;
    	}
    	
    	public boolean isLeaf() {
    		if(this.children.isEmpty()) 
    			return true;
    		
    		return false;
    	}
    }