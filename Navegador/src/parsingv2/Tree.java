package parsingv2;

public class Tree {
    private Node root;

    public Tree(String rootData) {
        root = new Node(rootData);
    }
    
    public Node getRoot() {
    	return this.root;
    }

    /**
     * Adiciona ao root
     * @param newNodeData
     */
    public Node addNode(String newNodeData) {
    	Node n = new Node(newNodeData);
    	root.children.add(n);
    	return n;
    }
    
    /**
     * Adiciona ao pai especificado
     * @param parent
     * @param newNodeData
     */
    public Node addNode(Node parent, String newNodeData)
    {
    	Node n = new Node(newNodeData);
    	n.addParent(parent);
    	return n;
    }

    
}
