package webcrawler.parser.fragments;

public class HTMLAttribute {
	protected String name = "";
	protected String value = "";
	
	public HTMLAttribute() {
	}
	public void streamToName(char ch) {
		name += ch;
	}
	public void streamToValue(char ch) {
		value+= ch;
	}
	
}
