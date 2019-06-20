package webcrawler.parser.fragments;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataToken extends Token {
	private String value = "";
			
	public void consume(char ch) {
		value += ch;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	/**
	 * Verifica se o token não é apenas composto de caracteres whitespace,
	 * se tiver alguma caracter diferende destes retorna true
	 * @return
	 */
	public boolean isValid() {
		
		Pattern p = Pattern.compile("^\\s*$");
		Matcher m = p.matcher(value);
		
		if(m.matches()) return false;
		else return true;
	}

	
	
}
