package webcrawler.parser;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import webcrawler.http.HTMLFetcher;
import webcrawler.parser.exceptions.HTMLParseErrorException;
import webcrawler.parser.exceptions.InvalidCloseHTMLTagException;
import webcrawler.parser.exceptions.InvalidHTMLTagException;
import webcrawler.parser.fragments.node.CloseTagNode;
import webcrawler.parser.fragments.node.CommentNode;
import webcrawler.parser.fragments.node.ImageNode;
import webcrawler.parser.fragments.node.Node;
import webcrawler.parser.fragments.node.OpenTagNode;
import webcrawler.parser.fragments.node.SingleTagNode;
import webcrawler.parser.fragments.token.DataToken;
import webcrawler.parser.fragments.token.TagToken;
import webcrawler.parser.fragments.token.Token;
import webcrawler.parser.util.StrIterator;

public class WEBParser {
	enum State {
		TAG,
		DATA,
		COMMENT,
		STRING,
		SCRIPT,
		IGNORE;
	}
	
	private List<TagToken> tags = new ArrayList<>();
	private List<DataToken> datas = new ArrayList<>();
	private List<Token> tokens = new ArrayList<>();
	private List<Node> nodes = new ArrayList<>();
	private URL webpageSourceURL = null;
	private Node rootNode = null;
	private State state = State.DATA;
	private StrIterator chars;
	
	private WEBParser(String html, URL url) {
		chars = new StrIterator(html);
		webpageSourceURL = url;
	}
	
	public static WEBParser parse(URL url) {
		String html = HTMLFetcher.fetchHTMLAsString(url);
		WEBParser newParser = new WEBParser(html, url);
		newParser.parse();
		return newParser;
	}
	
	private void parse() 
	{
		tokenize();
		parseTree();
	}
	
	private void tokenize()
	{
		if(chars.current() == '<')
		{
			
			state = State.TAG;
			tokenizeTag();
		}
		else
		{
			state = State.DATA;
			tokenizeData();
		}
		return;
	}
	private void processComment() {
		TagToken token = new TagToken();
		token.consume(chars.current());
		
		while(chars.hasNext() && state == State.TAG)
		{
			if(chars.next() != '>') 
			{
				token.consume(chars.current());
			}
			else
			{
				token.consume(chars.current());
				state = State.DATA;
				tokenizeData();
				return;
			}
		}
		
	}
	private void tokenizeData() 
	{
		DataToken token = new DataToken();
		
		while(chars.hasNext() && state == State.DATA) 
		{
			if(chars.next() != '<')
			{ 
				token.consume(chars.current());
			}
			else
			{ 
				if(token.isValid()) 
					{datas.add(token); tokens.add(token); }
				state = State.TAG; 
				tokenizeTag(); 
				return;
			}
		}
		
		
	}
	private void tokenizeTag() 
	{
		TagToken token = new TagToken();
		token.consume(chars.current());
		if(chars.lookNext() == '!')
		{
			processComment();
			return;
		}
		
		while(chars.hasNext() && state == State.TAG)
		{
			if(token.isScript())
			{
				tokenizeScript(token);
				return;
			}
			
			if(chars.next() != '>') 
			{
				token.consume(chars.current());
			}
			else
			{
				token.consume(chars.current());
				if(token.isValid())
					{ tags.add(token); tokens.add(token); }
				state = State.DATA;
				tokenizeData();
				return;
			}
		}
		
	}
	private void tokenizeScript(TagToken token) 
	{
		token.consume(chars.current());
		
		while(chars.hasNext())
		{
			if(token.isClosedScript()) {
				state = State.DATA;
				tokenizeData();
				return;
			}
			token.consume(chars.next());
		}
	}
	
	@SuppressWarnings("unused")
	private void makeTokenTree() {
		Stack<TagToken> lastParent = new Stack<>();
		
		tokens.forEach((token) -> {
			if(token.isTagToken()) {
				TagToken tk = (TagToken) token;
				
				if(	tk.isClosingTag()
					&&				// Se a tag for de fechamento e o nome é igual à ultima tag aberta
					tk.getTagName().equals(lastParent.peek().getTagName())
					) 
				{
					lastParent.pop();
				}
				else if (!tk.isClosingTag() && !tk.isOmitiveTag()) {
					
					if(!lastParent.empty())
						tk.parent = lastParent.peek();
					
					lastParent.push(tk);
				}
			}
			else
			{
				if(!lastParent.empty())
					token.parent = lastParent.peek();
			}
		});
	}
	private Node parseTree() throws InvalidCloseHTMLTagException, InvalidHTMLTagException {
		Stack<OpenTagNode> lastParent = new Stack<>();
		Node rootNode = null;
		
		for(Token tk: tokens) 
		{
			if(tk.isTagToken())
			{
				Node node = tk.toNode();
				node.setSourceURL(webpageSourceURL);
				OpenTagNode parent = (!lastParent.isEmpty()) ? lastParent.peek() : null;
				
				if(node instanceof OpenTagNode)
				{
					if(parent == null && rootNode == null) 
					{
							lastParent.add((OpenTagNode) node); //root
							nodes.add(node);
							rootNode = node;
					}
					else if(parent == null && rootNode != null)
					{
						throw new HTMLParseErrorException();
					}
					else 
					{
						node.setParent(lastParent.peek());
						parent.children.add(node);
						nodes.add(node);
						lastParent.add((OpenTagNode) node);
					}
				}
				else if(node instanceof SingleTagNode 	|| 
						node instanceof ImageNode 		|| 
						node instanceof CommentNode)
				{
					if(parent == null) {
						System.err.println("Detectado problema na estrutura do html - tag:" + node.getName() +"\n -----> "+node.getToken());
						 //throw new InvalidHTMLTagException("Estrutura do HTML inválido");
					}
					else {
						nodes.add(node);
						parent.children.add(node);
						node.setParent(parent);
					}				
				}
				else //CloseTagNode
				{
					if (parent == null) throw new InvalidCloseHTMLTagException("Tag fechando pai inexistente");
					
					if(parent.getName().equals(node.getName()))
					{
						parent.setClosedBy((CloseTagNode) node);
						node.setParent(parent);
						lastParent.pop();
					}
					else
					{
						System.err.println("Problema de fechamento de tag detectado");
						//throw new InvalidCloseHTMLTagException("Fechamento de tag não bate");
					}
				}
			}
			else
			{
				Node n = tk.toNode();
				nodes.add(n);
				n.setParent(lastParent.peek());
			}
		}
		this.rootNode = rootNode;
		return rootNode;
	}
	public List<Node> getNodes() {
		return nodes;
	}
	public Node getRootNode() {
		return rootNode;
	}
}
