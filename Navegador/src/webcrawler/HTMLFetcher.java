
package webcrawler;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe criada apenas para métodos de busca de html via URL
 * @author Everton Crespin da Silva
 */
public class HTMLFetcher {
    public static String getURLAsSring(String url) throws IOException 
    {
        HttpURLConnection.setFollowRedirects(true); // defaults to true
        String result = null;
        URL request_url;
        try {
            request_url = new URL(url);
            HttpURLConnection http_conn = (HttpURLConnection)request_url.openConnection();
            http_conn.setConnectTimeout(100000);
            http_conn.setReadTimeout(100000);
            http_conn.setInstanceFollowRedirects(true);
            InputStream inStream = http_conn.getInputStream();
            Scanner connScanner = new Scanner(inStream).useDelimiter("\\A");
            result = connScanner.hasNext() ? connScanner.next() : "";
            
        } catch (MalformedURLException ex) {
            //faz nada, este erro será tratado em outro método
        } 
        
        return result;
    }
    
    public static boolean validaURL(String url)
    {
        try {
            URL validated = new URL(url);
        } catch (MalformedURLException ex) {
            return false;
        }
        return true;
    }
    
}
