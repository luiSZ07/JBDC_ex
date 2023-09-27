package ufmt.biblioteca;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LivroDAO {

    Connection conexao;
    String sql;
     
    ArrayList<Livro> listarRegistros(){
    sql = "SELECT * FROM livro";
        try {
            PreparedStatement consulta = conexao.prepareStatement(sql);
            ResultSet resultado = consulta.executeQuery();
            while (resultado.next()) {
                System.out.println("ID: " + resultado.getInt("id_livro"));
                System.out.println("ISBN: " + resultado.getInt("isbn"));
                System.out.println("NOME: " + resultado.getString("nome_livro"));
                System.out.println("ID DO AUTOR: " + resultado.getInt("id_autor"));
                System.out.println("DATA DE PUBLICAÇÃO: " + resultado.getDate("data_publicacao"));
                System.out.println("PREÇO: " + resultado.getFloat("preco_livro"));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao consultar" + e.getMessage(), e);
        }
        return registros;
    }
}
