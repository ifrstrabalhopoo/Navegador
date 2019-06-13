package parsingv2;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe define o conteúdo de um nó
 * 
 */
public class Node {
		protected List<Node> children = new ArrayList<Node>();
		protected String 		renderEffect = null;
		protected String 		data = null;
		protected String 		name = null;
        
		protected Node 			parent = null;
		protected int 			level = 0;

		private Node() {
        	
        }
        
    	public Node(String data) {
    		this.data = data;
    	}
    	
    	public Node(String data, Node parent) {
    		this.data = data;
    		this.parent = parent;
    	}
    	
    	public List<Node> getChildren() {
    		return this.children;
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
    }