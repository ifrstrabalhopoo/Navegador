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
				String tag = m.group(2);
				matchChount -= 1;
				if(!Document.isTagEnabled(tag)) { //se a tag não for permitida filtra e remove
					String nextHtml = m.group(4);
					Document.parseHTML(doc, parent, nextHtml);
				}
				else if(doc.isEmpty()) {	// se for a primeira tag do documento inicializa a árvore html
					doc.html = new Tree(tag);
					String nextHtml = m.group(4);
					Document.parseHTML(doc, doc.html.getRoot(), nextHtml);
				}
				else if(parent == doc.html.getRoot()) { // se for filho da raiz
					Node newNode = new Node(tag, doc.html.getRoot());
					doc.html.getRoot().addChild(newNode);
					String nextHtml = m.group(4);
					Document.parseHTML(doc, newNode, nextHtml);
				}
				//TODO: Node: isLeaf?
				else {
					Node newNode = new Node(tag, parent);
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
	/**
	 * Verifica se a tag está habilitada
	 * @param tagName
	 * @return
	 */
	private static boolean isTagEnabled(String tagName) {
		if(EnabledTags.contains(tagName)) return true;
		return false;
	}
}
