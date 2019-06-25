package database.models;

/**
 * Modelo de dados do histórico
 * @author Everton Crespin da Silva
 *
 */
public class Historico {
	public Integer 	id = null;
	public Integer 	id_usuario = null;
	public String 	urlsite = null;
	public Data 	data_adicionado = null;
	
	protected Historico()
	{
		
	}
	public Historico(int id, int id_usuario, String urlsite, String date) 
	{
		this.id = id;
		this.id_usuario = id_usuario;
		this.urlsite = urlsite;
		this.data_adicionado = new Data(date);
	}
	public Historico(String urlsite, int id_usuario) 
	{
		this.id_usuario = id_usuario;
		this.urlsite = urlsite;
		this.data_adicionado = new Data();
	}

	public Historico(String urlsite) 
	{
		this.urlsite = urlsite;
		this.data_adicionado = new Data();
	}
	
	public Favorito convertToFavorito(int userId)
	{
		this.id_usuario = userId;
		return new Favorito(this);
	}
}
