package parsingv2;
import java.util.regex.Pattern;

public class Parser {
	Tree<String> document = null;
	String regex = "(<??)([A-Z][A-Z0-9]*)(\\b[^>]*>)([.\\s\\S]*?)<\\/\\2>";
	Pattern pat = Pattern.compile(regex);
	
		
	String example = 	"<html>\n" + 
						"<head>\n" + 
						"<title>\n" + 
						"A Simple HTML Document\n" + 
						"</title>\n" + 
						"</head>\n" + 
						"<body>\n" + 
						"<p>This is a very simple HTML document</p>\n" + 
						"<p>It only has two paragraphs</p>\n" + 
						"</body>\n" + 
						"</html>";
}
