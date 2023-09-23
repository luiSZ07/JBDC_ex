package ufmt.biblioteca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/db_biblioteca";
        String user = "luiz";
        String password = "luiz1234";
        Connection conexao;
        try{
            conexao = DriverManager.getConnection(url, user, password);
        }
        catch(SQLException e){
            throw new RuntimeException("Erro ao conectar"+e.getMessage(), e);
        }
        
        String sql = "SELECT * FROM livro";

        try{
            PreparedStatement consulta = conexao.prepareStatement(sql);
            ResultSet resultado = consulta.executeQuery();
            while(resultado.next()){
                System.out.println("ID: "+resultado.getInt("id"));
                System.out.println("Nome: "+resultado.getString("nome"));
                System.out.println("Cidade: "+resultado.getString("cidade"));
            }
        }
        catch(SQLException e ){
            throw new RuntimeException("Erro ao consultar"+e.getMessage(),e);
        }
    }
}
