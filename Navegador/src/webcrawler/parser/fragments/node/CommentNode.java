package webcrawler.parser.fragments.node;

public class CommentNode extends Node {
	public final String value;
	public CommentNode(String value) {
		this.value = value;
	}
	@Override
	public String toString()
	{
		return value;
	}
	@Override
	public boolean isRenderAble() {
		return false;
	}
}
