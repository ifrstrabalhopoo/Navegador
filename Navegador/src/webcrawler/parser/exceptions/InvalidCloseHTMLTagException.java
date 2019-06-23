package webcrawler.parser.exceptions;

@SuppressWarnings("serial")
public class InvalidCloseHTMLTagException extends RuntimeException {
	public InvalidCloseHTMLTagException() {
	
	}
	public InvalidCloseHTMLTagException(String msg) {
		super(msg);
	}
}
