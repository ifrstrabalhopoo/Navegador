package webcrawler.parser.fragments;

public class HTMLAttribute {
	protected String name = "";
	
	protected String value = "";
	
	
	public HTMLAttribute(String name, String value) {
		this.name = name;
		this.value = value;
	}
	
	public String getName() {
		return name;
	}
	public String getValue() {
		return value;
	}
	@Override
	public String toString() {
		return name;
	}
}
