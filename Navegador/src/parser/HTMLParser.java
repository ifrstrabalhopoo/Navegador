package parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import nodes.Node;
import nodes.TextNode;


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
    
    public static final String pattern1 = "(<??)([A-Z][A-Z0-9]*)(\\b[^>]*>)([.\\s\\S]*?)<\\/\\2>";
    private static Pattern pattern = Pattern.compile(pattern1);
     
    
    public static void primeiroTeste(Node parent, String input, Document dom)
    {
        Matcher ma = pattern.matcher(input);
        boolean found = ma.find();
        
        //condição de parada: se não tem match em tag
        if(!found) 
        {
            Node no = new TextNode(input, 1, parent);
        }
        
        //
        
        if(found) 
        {
            if (parent == null)
            {
                Node no = new Node(ma.group(2), 1);
                dom = new Document(no);
                String output = ma.replaceAll("$4");
                System.out.println(output);
            }
            
            
            
            
            
            
        }
    }
    
    public static void main(String[] args)
    {
        Document doc = null;
        primeiroTeste(null, TestoTeste.getHtml(), doc);
//        
//        System.out.println(TestoTeste.getHtml());
//        
//        Matcher ma = pattern.matcher(TestoTeste.getHtml());
//        
//        if(ma.find())
//        {
//            System.out.println("Group count: " + ma.groupCount());
//            System.out.println("=============================================================");
//            System.out.println("Encontrado valor: " + ma.group(0));
//            System.out.println("=============================================================");
//            System.out.println("Encontrado valor: " + ma.group(1));
//            System.out.println("=============================================================");
//            System.out.println("Encontrado valor: " + ma.group(2));
//            System.out.println("=============================================================");
//            System.out.println("Encontrado valor: " + ma.group(3));
//            System.out.println("=============================================================");
//            System.out.println("Encontrado valor: " + ma.group(4));
//            System.out.println("=============================================================");
//            
//            String out = ma.replaceAll("$4");
//            System.out.println("RESULTANT: \n" + out);
//        }
//        
    }
}
