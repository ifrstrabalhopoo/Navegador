package webcrawler.parser.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Iterator de string, métodos de lookForward e lookBehind para parser
 * @author Everton Crespin da Silva
 *
 */
public class StrIterator {
	
	private final String fullContent;
	private final char[] chars;
	private int pointer = 0;
	private int startIndex = 0;
	private int endIndex;
	
	public StrIterator(String string) {
		if(string.length() == 0) string = "<html><body><h1>Erro ao carregar página<h1><body><html>";
		this.fullContent = string;
		this.chars = string.toCharArray();
		this.endIndex = chars.length -1;
	}
	
	
	public char current() {
		return this.chars[pointer];
	}
	public char first() {
		return chars[startIndex];
	}
	public int getBeginIndex() {
		return startIndex;
	}
	public int getEndIndex() {
		return endIndex;
	}
	public int getIndex() {
		return pointer;
	}
	public char last() {
		return chars[endIndex];
	}
	public char next() {
		pointer++;
		return chars[pointer];
	}
	public char previous() {
		pointer--;
		return chars[pointer];
	}
	public char setIndex(int newIndex) {
		pointer = newIndex;
		return chars[pointer];
	}
	public char lookNext() {
		return chars[pointer +1];
	}
	public char lookPrevious() {
		return chars[pointer -1];
	}
	public boolean hasNext() {
		if(pointer+1 <= endIndex) return true;
		else return false;	
	}
	public boolean nextMatches(String regex)
	{
		if(matches(regex, lookNext())) return true;
		else return false;
	}

	private boolean matches(String regex, char ch) {
		String c = Character.toString(ch);
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(c);
		
		if(m.matches()) return true;
		else return false;
	}
	public String getFullContent() {
		return fullContent;
	}
}
