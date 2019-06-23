package webcrawler.parser.fragments.token;

import webcrawler.parser.fragments.node.Node;

public abstract class Token {
	public Token parent;
	public boolean isTagToken()
	{
		if (this instanceof TagToken) return true;
		else return false;
	}
	public abstract Node toNode();
	

}
