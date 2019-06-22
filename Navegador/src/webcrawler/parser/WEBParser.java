package webcrawler.parser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import webcrawler.parser.fragments.DataToken;
import webcrawler.parser.fragments.TagToken;
import webcrawler.parser.fragments.Token;
import webcrawler.parser.util.StrIterator;

public class WEBParser {
	enum State {
		TAG,
		DATA;
	}
	
	private List<TagToken> tags = new ArrayList<>();
	private List<DataToken> datas = new ArrayList<>();
	private List<Token> tokens = new ArrayList<>();
	private State state = State.DATA;
	StrIterator chars;
	
	public WEBParser(String html) {
		chars = new StrIterator(html);
	}
	
	public void tokenize()
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
			}
		}
		
		
	}
	private void tokenizeTag() 
	{
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
				if(token.isValid())
					{ tags.add(token); tokens.add(token); }
				state = State.DATA;
				tokenizeData();
			}
		}
		
	}
	public void makeTokenTree() {
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
	private void tokensToNodes() 
	{
		
	}
	
//	public void parse(StrIterator chars) 
//	{
//		
//		//sempre olhando o próximo
//		while(chars.hasNext()) 
//		{
////			if(Character.isWhitespace(chars.lookNext())) 
////			{ chars.next(); continue; } // Se for whitespace - passa
//			
//			if(chars.lookNext() == '<')
//			{	chars.next(); parseTag(chars); } // Se o próximo abrir uma tag, parseTag()
//			
//			if(chars.nextMatches("[\\w]"))
//			{ chars.next(); parseText(chars); }
//		}
//		
//	}
//	
//	public void parseTag(StrIterator chars)
//	{
//		TagToken tag = new TagToken();
//		while(chars.hasNext()) 
//		{
//			char c = chars.next();
//			
//			if(c != '>')
//		}
//	}

}
