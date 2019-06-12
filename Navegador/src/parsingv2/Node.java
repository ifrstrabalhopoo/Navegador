package parsingv2;
import java.util.ArrayList;
import java.util.List;


public class Node<T> {
		protected T data;
		protected Node<T> parent;
        protected List<Node<T>> children = new ArrayList<Node<T>>();
        
        public Node() {
        	
        }
        
    	public Node(T data) {
    		this.data = data;
    	}
    	
    	public Node(T data, Node<T> parent) {
    		this.data = data;
    		this.parent = parent;
    	}
    	
    	public List<Node<T>> getChildren() {
    		return this.children;
    	}
    	
    	public void addChild(Node<T> child) {
    		this.children.add(child);
    		child.parent = this;
    	}
    	
    	public Node<T> getParent(){
    		return this.parent;
    	}
    	
    	public T getData() {
    		return this.data;
    	}
    }