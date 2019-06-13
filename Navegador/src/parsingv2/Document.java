package parsingv2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Document {
	
	private Tree html = null;
	private static final String REGEX = "(<??)([A-Z][A-Z0-9]*)(\\b[^>]*>)([.\\s\\S]*?)<\\/\\2>";
	
	private static final Pattern PATTERN = Pattern.compile(REGEX,
							Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);
	
	public Document() {
		
	}
	
	public static Document parseHTML(Document doc, Node parent, String htmlInput) {
		
		Matcher m = PATTERN.matcher(htmlInput);
		
		int matchChount = 0;
		while(m.find()) {
			matchChount++;
		}
		
		m.reset();
		while(matchChount > 0 && m.find()) {
				matchChount -= 1;
				String data = m.group(2);
				if(doc.isEmpty()) {
					doc.html = new Tree(data);
					String nextHtml = m.group(4);
					Document.parseHTML(doc, doc.html.getRoot(), nextHtml);
				}
				else if(parent == doc.html.getRoot()) {
					Node newNode = new Node(data, doc.html.getRoot());
					doc.html.getRoot().addChild(newNode);
					String nextHtml = m.group(4);
					Document.parseHTML(doc, newNode, nextHtml);
				}
				else {
					Node newNode = new Node(data, parent);
					parent.addChild(newNode);
					String nextHtml = m.group(4);
					Document.parseHTML(doc, newNode, nextHtml);
				}
			
		}
		
		return doc;
		
	}
	
	public boolean isEmpty() {
		return this.html == null ? true : false;
	}
}
