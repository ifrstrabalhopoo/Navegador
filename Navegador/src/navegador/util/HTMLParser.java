package navegador.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


//TODO: Esta classe irá fazer o parsing do html e quebrar em uma árvore
/**
 *  
 * Sites de referência:
 * https://regexr.com/
 * http://myregexp.com/index.html
 * http://tutorials.jenkov.com/java-regex/matcher.html
 * https://www.devmedia.com.br/introducao-a-regex/15597
 * https://docs.microsoft.com/pt-br/dotnet/standard/base-types/quantifiers-in-regular-expressions
 * https://www.tutorialspoint.com/java/java_regular_expressions.htm
 * 
 * @author Everton C. da Silva
 */
public class HTMLParser {
    
    public static String pattern1 = "(<??)([A-Z][A-Z0-9]*)(\\b[^>]*>)([.\\s\\S]*?)<\\/\\2>";
    public static String testHTML = 
    "<HTML class=\"testyyy\">\n" +
    "\n" +
    "<HEAD>\n" +
    "\n" +
    "<TITLE>Your Title Here</TITLE>\n" +
    "\n" +
    "</HEAD>\n" +
    "\n" +
    "<BODY BGCOLOR=\"FFFFFF\">\n" +
    "\n" +
    "<CENTER><IMG SRC=\"clouds.jpg\" ALIGN=\"BOTTOM\"> </CENTER>\n" +
    "\n" +
    "<HR>\n" +
    "\n" +
    "<a href=\"http://somegreatsite.com\">Link Name</a>\n" +
    "\n" +
    "is a link to another nifty site\n" +
    "\n" +
    "<H1>This is a Header</H1>\n" +
    "\n" +
    "<H2>This is a Medium Header</H2>\n" +
    "\n" +
    "Send me mail at <a href=\"mailto:support@yourcompany.com\">\n" +
    "\n" +
    "support@yourcompany.com</a>.\n" +
    "\n" +
    "<P> This is a new paragraph!\n" +
    "\n" +
    "<P> <B>This is a new paragraph!</B>\n" +
    "\n" +
    "<BR> <B><I>This is a new sentence without a paragraph break, in bold italics.</I></B>\n" +
    "\n" +
    "<HR>\n" +
    "\n" +
    "</BODY>\n" +
    "\n" +
    "</HTML> ";
    
    public static void main(String[] args)
    {
        Pattern pat = Pattern.compile(pattern1, Pattern.CASE_INSENSITIVE);
        Matcher m = pat.matcher(testHTML);
        
        if(m.find())
        {
            System.out.println("Group count: " + m.groupCount());
            System.out.println("=============================================================");
            System.out.println("Encontrado valor: " + m.group(0));
            System.out.println("=============================================================");
            System.out.println("Encontrado valor: " + m.group(1));
            System.out.println("=============================================================");
            System.out.println("Encontrado valor: " + m.group(2));
            System.out.println("=============================================================");
            System.out.println("Encontrado valor: " + m.group(3));
            System.out.println("=============================================================");
            System.out.println("Encontrado valor: " + m.group(4));
            System.out.println("=============================================================");
        }
    }
    
}
