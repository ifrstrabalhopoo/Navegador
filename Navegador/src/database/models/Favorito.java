package database.models;

public class Favorito extends Historico {

	public Favorito(int id, int id_usuario, String urlsite, String date) {
		this.id = id;
		this.id_usuario = id_usuario;
		this.urlsite = urlsite;
		this.data_adicionado = new Data(date);
	}
	
	public Favorito(Historico hist) {
		if(hist.id_usuario != null)
			this.id_usuario = hist.id_usuario;
		if(hist.urlsite != null)
			this.urlsite = hist.urlsite;
		this.data_adicionado = new Data();
		
	}
}
