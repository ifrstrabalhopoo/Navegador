package database.sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import database.models.Historico;
import database.util.DBaseUtils;

public class DBase {
	private Connection conn = null;

	
	public DBase(String dbFileName) {
		conn = createDatabase(dbFileName);
		createNewTables(conn);
	}
	
	private Connection createDatabase(String dbname) {
		if(dbname == null) dbname = "navigator.db";
		Connection conn = null;
		try {
			String dbUrl = "jdbc:sqlite:" + dbname;
			conn = DriverManager.getConnection(dbUrl);
			System.out.println(DBaseUtils.nowString() + " DB[SQLITE]: Conexão com banco efetuada com sucesso!");
		} catch (Exception e) {
			System.err.println(DBaseUtils.nowString() + " DB[SQLITE]: Erro ao conectar com o banco de dados!");
		}
		
		return conn;
	}
	private void createNewTables(Connection conn) {
        
        // SQL statement for creating a new table
        String sql_usuario = 	"CREATE TABLE IF NOT EXISTS `usuario` ( `id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, `login` TEXT NOT NULL, `senha` TEXT NOT NULL )";
        
        String sql_favoritos = 	"CREATE TABLE IF NOT EXISTS `favoritos` ( `id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, `id_usuario` INTEGER NOT NULL,`urlsite` TEXT NOT NULL, `data_adicionado` TEXT NOT NULL);";
        String sql_historico = 	"CREATE TABLE IF NOT EXISTS `historico` ( `id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, `id_usuario`	INTEGER, `urlsite`	TEXT NOT NULL, `data_adicionado` TEXT NOT NULL);";
        Statement stmt;
		try {
			stmt = conn.createStatement();
			stmt.execute(sql_usuario);
			stmt.execute(sql_favoritos);
			stmt.execute(sql_historico);
			System.out.println(logPrefix() + "Tabelas geradas com sucesso!");
		} catch (SQLException e1) {
			System.out.println(logPrefix() + "Erro ao preparar banco de dados:  " + e1.getMessage());
		}
        
    }
	
	private String logPrefix() {
		return DBaseUtils.nowString() + " DB[SQLITE]: ";
	}
	/**
	 * Adiciona url ao historico grava a data automaticamente, não vincula a usuário
	 * @param urlSite URL a ser adicionada ao histórico
	 */
	public void addHistorico(String urlSite) {
		String date = DBaseUtils.nowString();
		String sql = "INSERT INTO `historico` (`urlsite`, `data_adicionado`) VALUES ('"+ urlSite +"', '"+date+"')";
		 
		Statement stmt;
			try {
				stmt = conn.createStatement();
				stmt.execute(sql);
				System.out.println(logPrefix()+ "Salvo histórico");
			} catch (SQLException e1) {
				System.out.println(logPrefix()+ "Erro ao salvar histórico no banco de dados:  " + e1.getMessage());
			}
	}
	/**
	 * Adiciona um histórico vinculado a um id de usuário
	 * @param urlSite URL a ser adicionada ao histórico
	 * @param userId Id do usuário ao qual este histórico é vinculado
	 */
	public void addHistorico(String urlSite, int userId) {
		String date = DBaseUtils.nowString();
		String sql = 	"INSERT INTO `historico` (`urlsite`, `id_usuario`  ,`data_adicionado`)"+
						" VALUES ('"+ urlSite +"', "+userId+" , '"+date+"')";
		 
		Statement stmt;
			try {
				stmt = conn.createStatement();
				stmt.execute(sql);
				System.out.println(logPrefix() + "Salvo histórico");
			} catch (SQLException e1) {
				System.out.println(logPrefix() + "Erro ao salvar histórico no banco de dados:  " + e1.getMessage());
			}
	}
	/**
	 * Adiciona ao banco de dados um histórico instanciado
	 * @param obj histórico as ser salvo
	 */
	public void addHistorico(Historico obj) {
		
		String date = obj.data_adicionado == null ? DBaseUtils.nowString() : obj.data_adicionado.toString();
		Integer userId = obj.id_usuario;
		String urlSite = obj.urlsite;
		String sql = 	"INSERT INTO `historico` (`urlsite`, `id_usuario`  ,`data_adicionado`)"+
						" VALUES ('"+ urlSite +"', "+userId+" , '"+date+"')";
					
		 
		Statement stmt;
			try {
				stmt = conn.createStatement();
				stmt.execute(sql);
				System.out.println(logPrefix() + "Salvo histórico");
			} catch (SQLException e1) {
				System.out.println(logPrefix() + "Erro ao salvar histórico no banco de dados:  " + e1.getMessage());
			}
	}
}
