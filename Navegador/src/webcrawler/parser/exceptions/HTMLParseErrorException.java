package webcrawler.parser.exceptions;

@SuppressWarnings("serial")
public class HTMLParseErrorException extends RuntimeException {
	public HTMLParseErrorException() {
	}
	
	public HTMLParseErrorException(String msg) {
		super(msg);
	}
}
