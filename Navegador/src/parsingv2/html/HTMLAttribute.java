package parsingv2.html;

public class HTMLAttribute {
	protected final String name;
	protected final String value;
	protected final String effectName;
	protected final String effectValue;
	
	public HTMLAttribute(String name, String value) {
		this.name = name;
		this.effectName = name;
		this.effectValue = value;
		this.value = value;
	}
	
}
