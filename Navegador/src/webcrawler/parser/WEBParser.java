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
	private List<Token> stack = new ArrayList<>();
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
					{datas.add(token); stack.push(token); }
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
					{ tags.add(token); stack.push(token); }
				state = State.DATA;
				tokenizeData();
			}
		}
		
	}
	
	public void makeTokenTree() {
		Stack<Token> stack = new Stack<>();
		
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
