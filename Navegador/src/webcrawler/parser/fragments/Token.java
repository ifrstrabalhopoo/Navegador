package webcrawler.parser.fragments;

public abstract class Token {
	public Token parent;
	public boolean isTagToken()
	{
		if (this instanceof TagToken) return true;
		else return false;
	}

}
