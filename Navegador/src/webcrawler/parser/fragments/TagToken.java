package webcrawler.parser.fragments;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TagToken extends Token {
	
	public static int rgxFlags = Pattern.CASE_INSENSITIVE | Pattern.MULTILINE;
	private static String omitiveTags ="(?<=<)\\s*(br|meta|col|hr|input)|(?<=<)\\s*html\\s*(?=\\w)";
	private static String[] enabledTags = {
			"!--","a","b","body","br","button","col","div","form", "h1","h2","h3","h4","h5","h6",
			"head","header","html","hr","i","img","input","label","li","meta","ol","option","p","select","table",
			"tbody","td","textarea","title","th","tr","ul"
	};
	private String value = "";

	public TagToken() {
	}
	public TagToken(String value) {
		this.value = value;
	}
	public void consume(char ch) {
		value += ch;
	}
	public boolean isValid() {
		
		if(	value.charAt(0) == '<'
			&&
			value.charAt(value.length() -1) == '>')
		return true;
		
		else return false;
	}
	public boolean isClosingTag() {
		Pattern p = Pattern.compile("^(<\\/)", rgxFlags);
		Matcher m = p.matcher(value);
		
		if(m.find()) return true;
		else return false;
	}
	public boolean isTag(String tagname) 
	{
		String regex = "(<\\/[\\s]*"+tagname+")|(<[\\s]*"+tagname+")";
		Pattern p = Pattern.compile(regex, rgxFlags);
		Matcher m = p.matcher(value);
		
		if(m.find()) return true;
		else return false;
	}
	public String getTagName() {
		String tagname = null;
		String regex = "<\\s*(\\w*)";
		Pattern p = Pattern.compile(regex, rgxFlags);
		Matcher matchOpen = p.matcher(value);
		
		
		if(matchOpen.find() && !matchOpen.group(1).isEmpty())
		{
			tagname = matchOpen.group(1);
		}
		else 
		{
			String closeRegex = "<\\/[\\s]*(\\w*)";
			Pattern pa = Pattern.compile(closeRegex, rgxFlags);
			Matcher matchClosed = pa.matcher(value);
			
			if(matchClosed.find() && !matchClosed.group(1).isEmpty()) 
			{
				tagname = matchClosed.group(1);
			}
		}
	
		return tagname;
	}
	/**
	 * Checa se a tag é omitiva
	 * @return
	 */
	public boolean isOmitiveTag() 
	{
		String regex = omitiveTags;
		Pattern p = Pattern.compile(regex, rgxFlags);
		Matcher m = p.matcher(value);

		if(m.find()) return true;
		else return false;
	}
	public String getValue() {
		return value;
	}
	@Override
	public String toString() {
		return value;
	}
	public Node toNode() {
		Node n = new Node(this.getTagName());
		n.setAttibutesFromWholeTag(value);
		n.setToken(this);
		return n;
	}
}
