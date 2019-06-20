
package webcrawler;

/**
 *
 * @author Everton Crespin da Silva
 */
public class Teste {
    
    
    
    
    public static void main(String[] args) {
        String url = "http://www.pudim.com.br";
        String pagina = HTMLFetcher.getURLAsSring(url);
        
        System.out.println("Fetch: "+url);
        System.out.println(pagina);
    }
}
