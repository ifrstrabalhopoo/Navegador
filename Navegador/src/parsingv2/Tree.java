package parsingv2;
import java.util.ArrayList;

public class Tree<T> {
    private Node<T> root;

    public Tree(T rootData) {
        root = new Node<T>();
        root.data = rootData;
        root.children = new ArrayList<Node<T>>();
    }
    
    public Node<T> getRoot() {
    	return this.root;
    }

    /**
     * Adiciona ao root
     * @param newNodeData
     */
    public Node<T> addNode(T newNodeData) {
    	Node<T> n = new Node<T>();
    	n.data = newNodeData;
    	n.children = new ArrayList<Node<T>>();
    	root.children.add(n);
    	return n;
    }
    
    /**
     * Adiciona ao pai especificado
     * @param parent
     * @param newNodeData
     */
    public Node<T> addNode(Node<T> parent, T newNodeData)
    {
    	Node<T> n = new Node<T>();
    	n.data = newNodeData;
    	n.children = new ArrayList<Node<T>>();
    	n.parent = parent;
    	return n;
    }

    
}
