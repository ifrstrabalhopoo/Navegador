package webcrawler.parser.fragments.node;

public class OpenTagNode extends Node {
	private CloseTagNode closedBy = null;
	public OpenTagNode(String tagName) {
		this.name = tagName;
	}
	public CloseTagNode getClosedBy() {
		return closedBy;
	}
	public void setClosedBy(CloseTagNode closedBy) {
		this.closedBy = closedBy;
	}
	@Override
	public boolean isRenderAble() {
		return false;
	}
}
