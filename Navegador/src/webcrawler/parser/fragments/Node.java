package webcrawler.parser.fragments;

import java.util.ArrayList;
import java.util.List;

public class Node {
	private Node parent = null;
	private String name = "";
	private boolean closed = false;
	public List<HTMLAttribute> attributes = new ArrayList<>();
	
	public Node() {
	}
	public Node(Node parent) {
		this.parent = parent;
	}
	
	public void streamToName(char ch) {
		name += ch;
	}
	public void setClosed() {
		closed = true;
	}

	public void addAttribute(HTMLAttribute attr) {
		this.attributes.add(attr);
	}

	public Node getParent() {
		return parent;
	}
	public String getName() {
		return name;
	}
}
