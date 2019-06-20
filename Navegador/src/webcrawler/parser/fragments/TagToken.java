package webcrawler.parser.fragments;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TagToken extends Token {
	
	private String value = "";

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
		Pattern p = Pattern.compile("^(<\\/)");
		Matcher m = p.matcher(value);
		
		if(m.matches()) return true;
		else return false;
	}
	public boolean isTag(String tagname) 
	{
		String regex = "(<\\/[\\s]*"+tagname+")|(<[\\s]*"+tagname+")";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(value);
		
		if(m.matches()) return true;
		else return false;
	}
	public String getTagName() {
		String regex = "(<\\/[\\s]*"+tagname+")|(<[\\s]*"+tagname+")";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(value);
	}
	@Override
	public String toString() {
		return value;
	}
	
	
}
