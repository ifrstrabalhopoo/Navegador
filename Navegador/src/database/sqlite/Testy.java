package database.sqlite;

import java.sql.Connection;

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
	}
}
