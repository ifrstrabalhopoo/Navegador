package webcrawler.parser.fragments.node;

public class CloseTagNode extends Node {
	protected OpenTagNode openedBy = null;

	public CloseTagNode(String tagName) {
		this.name = tagName;
	}

	public OpenTagNode getOpenedBy() {
		return openedBy;
	}

	public void setOpenedBy(OpenTagNode openedBy) {
		this.openedBy = openedBy;
	}
	@Override
	public boolean isRenderAble() {
		return false;
	}
}
