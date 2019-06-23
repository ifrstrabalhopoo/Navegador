
package webcrawler.http;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * Classe criada apenas para métodos de busca de html via URL
 * @author Everton Crespin da Silva
 */
public class HTMLFetcher {
	
	/**
	 * Recebe uma String, que deve ser uma URL válida, e retorna o html do endereço buscado
	 * em formato de String.
	 * @param url
	 * @return HTML da URL buscada
	 * @throws IOException No caso de ser impossível buscar o endereço
	 * @throws MalformedURLException URL inválida
	 */
    public static String getURLAsSring(String url) throws IOException, MalformedURLException
    {
        HttpURLConnection.setFollowRedirects(true); // defaults to true
        String result = null;
        URL request_url;
        
            request_url = new URL(url);
            HttpURLConnection http_conn = (HttpURLConnection)request_url.openConnection();
            http_conn.setConnectTimeout(100000);
            http_conn.setReadTimeout(100000);
            http_conn.setInstanceFollowRedirects(true);
            InputStream inStream = http_conn.getInputStream();
            
            @SuppressWarnings("resource")
			Scanner connScanner = new Scanner(inStream).useDelimiter("\\A");
            result = connScanner.hasNext() ? connScanner.next() : "";
            
            connScanner.close();
        
        return result;
    }
    
    public static String fetchHTMLAsString(URL url) 
    {
    	String html = "";
    	HttpURLConnection http_conn;
		try {
			http_conn = (HttpURLConnection)url.openConnection();
			http_conn.setConnectTimeout(100000);
	        http_conn.setReadTimeout(100000);
	        http_conn.setInstanceFollowRedirects(true);
	        InputStream inStream = http_conn.getInputStream();
	        
	        @SuppressWarnings("resource")
			Scanner connScanner = new Scanner(inStream).useDelimiter("\\A");
	        html = connScanner.hasNext() ? connScanner.next() : "";
	        
	        connScanner.close();
		} catch (IOException e) {
			System.err.println("Não foi possível abrir a URL especificada!");
		}
		
        return html;
    }
    
    /**
     * Verifica se a URL é válida
     * @param url
     * @return Se a url é valida
     */
    public static boolean validaURL(String url)
    {
        try {
            @SuppressWarnings("unused")
			URL validated = new URL(url);
        } catch (MalformedURLException ex) {
            return false;
        }
        return true;
    }
    
}
