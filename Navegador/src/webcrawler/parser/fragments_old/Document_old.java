package webcrawler.parser.fragments_old;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Document_old {
	
	private Tree html = null;
	private static final String REGEX_CLOSED_TAG = "(<??)([A-Z][A-Z0-9]*)(\\b[^>]*)(>)([.\\s\\S]*?)<\\/\\2>";
	private static final String REGEX_OPEN_TAG = "((<){1}([A-Z][A-Z0-9]*)(\\b[^>]*)(>))";
	//private static final String REGEX = "(<??)([A-Z][A-Z0-9]*)(\\b[^>]*)(>)([.\\s\\S]*?)<\\/\\2>|((<){1}([A-Z][A-Z0-9]*)(\\b[^>]*)(>))";
	//private static final String REGEX = "((<??)([A-Z][A-Z0-9]*)(\\b[^>]*)(>)([.\\s\\S]*?)(<\\/\\3>))|((<){1}([A-Z][A-Z0-9]*)(\\b[^>]*)(>))";
	private static final Pattern PATTERN_CLOSED_TAG = Pattern.compile(REGEX_CLOSED_TAG,
							Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);
	private static final Pattern PATTERN_OPEN_TAG = Pattern.compile(REGEX_OPEN_TAG,
			Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);
	
	private Document_old() {
		
	}
	/**
	 * Faz o parsing de uma string html (htmlInput)
	 * @param doc Documento será resultado do parsing
	 * @param parent
	 * @param htmlInput
	 * @return
	 */
	private static Document_old parseHTMLv2(Document_old doc, Node parent, String htmlInput) {
		
		// checar se tem tag
		Matcher matchClosedTags = PATTERN_CLOSED_TAG.matcher(htmlInput);
		
		int fechadasMatchCount = Document_old.contaMatches(matchClosedTags);
		
			if (fechadasMatchCount > 0)
			{
				// gera tags fechadas
				while(fechadasMatchCount > 0 && matchClosedTags.find()) 						// tem tag
				{
					fechadasMatchCount--;
					String tag = matchClosedTags.group(2);
					String nodeData = matchClosedTags.group(3);
					String nextHtml = matchClosedTags.group(5);
	
					if(doc.isEmpty() || parent == null) 										// se não tem raiz ou parent, gerar raiz
					{
						Document_old.gerarRaiz(doc, tag, nodeData, nextHtml);
					}
					else if(parent != null)														// se houver parent, gera node
					{
						Document_old.geraNode(doc, parent, tag, nodeData, nextHtml);
					}
				}
				return doc;
			}
		
		// checar se tem tags omissas
		Matcher matchOpenTags = PATTERN_OPEN_TAG.matcher(htmlInput);
		
		int abertasMatchCount = Document_old.contaMatches(matchOpenTags);
				
			if(abertasMatchCount > 0)
			{
				
				while(abertasMatchCount > 0 && matchOpenTags.find()) // gera tags abertas
				{
					abertasMatchCount--;
					String tag = matchOpenTags.group(3);
					String nodeData = matchOpenTags.group(4);
					String nextHtml = htmlInput.replace(matchOpenTags.group(1), "");
					
					Document_old.geraNode(doc, parent, tag, nodeData, nextHtml);
				}
				return doc;
			}
		
		// checar se tem texto
		if(!htmlInput.trim().isEmpty()) 
		{
			Document_old.geraTextNode(doc, parent, htmlInput);
		}
		
		
		return doc;
	}
	/**
	 * Parse HTML antigo, algoritmo incompleto, não utilizar
	 * @deprecated
	 * @param doc
	 * @param parent
	 * @param htmlInput
	 * @return
	 */
	private static Document_old parseHTML(Document_old doc, Node parent, String htmlInput) {
		
		Matcher m = PATTERN_CLOSED_TAG.matcher(htmlInput);
		
		int matchCount = 0;
		while(m.find()) {
			matchCount++;
		}
		
		
		if(matchCount == 0 && htmlInput != null && parent != null) {
			// quanto só houver texto ele cria um textNode 
			// ou faz parse das tags que não fecham
			if(!htmlInput.trim().isEmpty()) 
			{
				parent.addChild(new TextNode(htmlInput, parent));
				return doc;
			}
			return doc;
		}
		
		m.reset();
		while(matchCount > 0 && m.find()) {
				matchCount -= 1;
				
				String tag = m.group(2);
				String nodeData = m.group(3);
				String nextHtml = m.group(5);
				String next2 = m.group(5);
				
				if(!Document_old.isTagEnabled(tag)) 			// se a tag não for permitida filtra e remove
				{ 
					Document_old.parseHTML(doc, parent, nextHtml);
				}
				else if(doc.isEmpty()) 						// se for a primeira tag do documento inicializa a árvore html
				{ 
					doc.html = new Tree(tag, nodeData);
					Document_old.parseHTML(doc, doc.html.getRoot(), nextHtml);
				}
				else if(parent == doc.html.getRoot())		// se for filho da raiz 
				{ 
					Node newNode = Node.makeNode(tag, nodeData, doc.html.getRoot());
					doc.html.getRoot().addChild(newNode);
					Document_old.parseHTML(doc, newNode, nextHtml);
				}
				//TODO: Node: isLeaf?
				else 										// node normal
				{
					Node newNode = Node.makeNode(tag, nodeData, parent);
					parent.addChild(newNode);
					Document_old.parseHTML(doc, newNode, nextHtml);
				}
			
		}
		
		return doc;
		
	}
	
	public static Document_old factory(String html)
	{
		Document_old doc = new Document_old();
		Document_old.parseHTMLv2(doc, null, html);
		
		return doc;
	}
	
	private static void gerarRaiz(Document_old doc, String tag, String nodeData, String nextHtml) 
	{
		doc.html = new Tree(tag, nodeData);
		Document_old.parseHTMLv2(doc, doc.html.getRoot(), nextHtml);
	}
	private static void geraNode(Document_old doc, Node parent, String tag, String nodeData, String nextHtml) 
	{
		Node newNode = Node.makeNode(tag, nodeData);
		parent.addChild(newNode);
		Document_old.parseHTMLv2(doc, newNode, nextHtml);
	}
	private static void geraTextNode(Document_old doc, Node parent, String text)
	{
		Node newTextNode = new TextNode(text, parent);
		parent.addChild(newTextNode);
	}
	
	private static int contaMatches(Matcher m) {
		int count = 0;
		while(m.find()) {
			count++;
		}
		m.reset();
		return count;
	}
	
	
	
	private static String removeGroup(String input, String remove) {
		String output = input;
		output.replace(remove,"");
		
		return output;
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
		if(EnumHTMLElement.contains(tagName)) 
			return true;
		return false;
	}
}
