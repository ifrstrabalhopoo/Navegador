package parsingv2;

public class Tree {
    private Node root;

    public Tree(String tagName, String tagData) {
        root = Node.makeNode(tagName, tagData);
    }
    
    public Node getRoot() {
    	return this.root;
    }

    /**
     * Adiciona ao root
     * @param newNodeData
     */
    public Node addNode(String newTagName, String newTagData) {
    	Node n = Node.makeNode(newTagName, newTagData);
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
