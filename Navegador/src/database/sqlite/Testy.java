package database.sqlite;

import java.util.List;

import database.models.Favorito;
import database.models.Historico;
import database.models.Usuario;

public class Testy {
	public static void main(String[] args) {
		DBase db = new DBase("navi.db");
		db.addHistorico("www.9gag.com");
		db.addHistorico("https://java.oracle.com/aljksdh/asiuodhaos", 5);
		
		Historico hist = new Historico("http://naointendo.com");
		Historico hist2 = new Historico("http://youtube.com", 2);
		db.addHistorico(hist);
		db.addHistorico(hist2);
		Favorito fv = hist2.convertToFavorito(2);
		db.addFavorito(fv);
		Usuario usr = db.getUsuario(1);
		
		System.out.println("Localizado usuário ID:"+usr.id+" LOGIN:"+usr.login+" SENHA:"+usr.senha);
		
		List<Favorito> favs = db.getAllFavoritos();
		
		favs.forEach(fav -> {
			System.out.println("Favorito: id: "+fav.id+" usuario: "+fav.id_usuario+" Data: " +fav.data_adicionado.toString()+"\n ---> URL: ["+fav.urlsite+"]");
		});
		
		List<Historico> histo = db.getAllHistoricos();
				
				histo.forEach(fav -> {
					System.out.println("Historico: id: "+fav.id+" usuario: "+fav.id_usuario+" Data: " +fav.data_adicionado.toString()+"\n ---> URL: ["+fav.urlsite+"]");
		});
	}
}
