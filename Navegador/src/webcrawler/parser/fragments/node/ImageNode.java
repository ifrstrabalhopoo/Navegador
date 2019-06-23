package webcrawler.parser.fragments.node;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.text.Style;
import javax.swing.text.StyleConstants;

import webcrawler.parser.fragments.HTMLAttribute;

public class ImageNode extends Node {
	
	public ImageNode() {
		super("img");
	}
	
	private HTMLAttribute getSource() {
		HTMLAttribute source = this.attributes.stream()
				.filter(attr -> "src".equals(attr.getName().toLowerCase()))
				.findFirst()
				.orElse(null);
		System.out.println("att");
		return source;
	}
	
	@Override
	public boolean isRenderAble() {
		return true;
	}
	
	public Style  getStyle(Style s) {
		StyleConstants.setAlignment(s, StyleConstants.ALIGN_CENTER);
		return s;
	}
	/**
	 * Retorna a URL da imagem, ou nulo caso ela não exista ou for inválida
	 * @return
	 */
	public URL getUrl() {
		URL url = null;
		try {
			url = new URL(this.getSource().getValue());
		} catch (MalformedURLException e) {
				url = null;
		} catch (NullPointerException ex) {
			System.err.println("Não foi possível carregar a imagem");
		}
		
		if(url == null) {
			try {
					String regex = "^(http[s]?:\\/\\/)";
					Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);
					Matcher m = p.matcher(this.getSource().getValue());
					
					if(m.find()) { // se encontrar http(s) no inicio, então realmente a URL é inválida
						System.err.println("Erro ao formar URL da imagem");
					}
					else 
					{	//se não encontrar http(s): -- tentamos criar link relativo
						url = new URL(this.webpageSourceURL, this.getSource().getValue());
					}
				
				} catch (Exception e2) {
				System.err.println("Erro ao formar URL da Imagem");
			
				}
		}
		
		return url;
	}
}
