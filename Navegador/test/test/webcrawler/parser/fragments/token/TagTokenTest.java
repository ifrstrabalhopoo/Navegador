package test.webcrawler.parser.fragments.token;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runners.Parameterized.Parameter;

import webcrawler.parser.fragments.token.DataToken;
import webcrawler.parser.fragments.token.TagToken;

public class TagTokenTest {
	
	@Parameter
	TagToken token = new TagToken("<html xmlns=\\\"http://www.w3.org/1999/xhtml\\\">");

	@Test
	public void testTagToken() {
		TagToken tk = new TagToken();
		
		assertTrue(tk.getValue().isEmpty());
		assertNotNull(tk);
	}

	@Test
	public void testTagTokenString() {
		TagToken tk = new TagToken("<html xmlns=\\\\\\\"http://www.w3.org/1999/xhtml\\\\\\\">");
		assertFalse(tk.getValue().isEmpty());
		assertNotNull(tk);		
	}

	@Test
	public void testConsume() {
		TagToken emptyToken = new TagToken();
		char c = 'a';
		
		emptyToken.consume(c);
		
		assertEquals("a", emptyToken.getValue());
		
	}

	@Test
	public void testIsValid() {
		TagToken invalidToken1 = new TagToken("asdkl <kkkslka />");
		TagToken invalidToken2 = new TagToken(" <kkkslka /> ");
		TagToken invalidToken3 = new TagToken("<kkkslka");
		TagToken invalidToken4 = new TagToken("<kkkslka / asdas");
		
		assertTrue(token.isValid());
		assertFalse(invalidToken1.isValid());
		assertFalse(invalidToken2.isValid());
		assertFalse(invalidToken3.isValid());
		assertFalse(invalidToken4.isValid());
	}

	@Test
	public void testIsClosingTag() {
		TagToken t1 = new TagToken("<html saskdjasl laskdj >");
		TagToken t2 = new TagToken("<p>");
		TagToken t3 = new TagToken("<div>");
		
		TagToken t4 = new TagToken("</a>");
		TagToken t5 = new TagToken("</html >");
		TagToken t6 = new TagToken("</body asdas>");
		TagToken t7 = new TagToken("</ title>");
		
		assertFalse(token.isClosingTag());
		assertFalse(t1.isClosingTag());
		assertFalse(t2.isClosingTag());
		assertFalse(t3.isClosingTag());
		
		assertTrue(t4.isClosingTag());
		assertTrue(t5.isClosingTag());
		assertTrue(t6.isClosingTag());
		assertTrue(t7.isClosingTag());
		
	}

	@Test
	public void testIsTag() {
		assertTrue(token.isTag("html"));
	}

	@Test
	public void testGetTagName() {
		TagToken t1 = new TagToken("</body>");
		TagToken t2 = new TagToken("</h1>");
		TagToken t3 = new TagToken("<body>");
		TagToken t4 = new TagToken("<head>");
		
		assertEquals(token.getTagName(), "html");
		assertEquals(t1.getTagName(), "body");
		assertEquals(t2.getTagName(), "h1");
		assertEquals(t3.getTagName(), "body");
		assertEquals(t4.getTagName(), "head");
	}

	@Test
	public void testIsOmitiveTag() {
		TagToken t1 = new TagToken("</body>");
		TagToken t2 = new TagToken("</h1>");
		TagToken t3 = new TagToken("<body>");
		TagToken t4 = new TagToken("<head>");
		
		TagToken t5 = new TagToken("<html xmlns=\"...>");
		TagToken t6 = new TagToken("<br>");
		TagToken t7 = new TagToken("<meta charset=\"ISO_8851...>");
		
		
		assertFalse(t1.isOmitiveTag());
		assertFalse(t2.isOmitiveTag());
		assertFalse(t3.isOmitiveTag());
		assertFalse(t4.isOmitiveTag());
		
		assertTrue(t5.isOmitiveTag());
		assertTrue(t6.isOmitiveTag());
		assertTrue(t7.isOmitiveTag());
		
	}

	@Test
	public void testToString() {
		assertEquals("<html xmlns=\\\"http://www.w3.org/1999/xhtml\\\">", token.getValue());
	}
	@Test
	public void testIsTagToken() {
		DataToken dt1 = new DataToken();
		assertTrue(token.isTagToken());
		assertFalse(dt1.isTagToken());
	}

}
