package database.models;

public class Usuario {
	public Integer id = null;
	public String login = null;
	public String senha = null;
	
	public Usuario(String nome, String senha) {
		this.login = nome;
		this.senha = senha;
	}
	public Usuario(String nome, String senha, int id) {
		this.id = id;
		this.login = nome;
		this.senha = senha;
	}
}
