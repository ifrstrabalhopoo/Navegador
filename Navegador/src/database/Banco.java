package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Banco {
    public static Connection getConexao() {
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/banco", "root", "root");
            System.out.println("Conectado com sucesso!");
        }catch(SQLException e) {
            System.out.println("Não foi possível conectar ao banco!");
        }
        return con;
    }
    
    public void logar(String login, String senha){
        System.out.println("Recebido login: " + login + "\nRecebido senha: " + senha);
    }
    
    public void addHistorico(String URL){
        System.out.println("Adicionando URL visitada ao histórico. URL: " + URL);
    }
    
    public void addFavorito(String URL){
        System.out.println("Adicionando URL aos favoritos!");
    }
}
