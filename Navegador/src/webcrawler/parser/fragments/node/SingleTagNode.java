package webcrawler.parser.fragments.node;

public class SingleTagNode extends Node {

	public SingleTagNode(String tagName) {
		this.name = tagName;
	}
	@Override
	public boolean isRenderAble() {
		if(this.name.toLowerCase() == "br" || this.name.toLowerCase() == "hr")
			return true;
		return false;
	}

}
