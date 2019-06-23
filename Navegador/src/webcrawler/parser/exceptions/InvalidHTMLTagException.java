package webcrawler.parser.exceptions;

@SuppressWarnings("serial")
public class InvalidHTMLTagException extends RuntimeException {
	public InvalidHTMLTagException() {
		
	}
	public InvalidHTMLTagException(String msg) {
		super(msg);
	}
}
