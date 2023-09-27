package ufmt.biblioteca;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.time.LocalDate;

public class LivroDAO implements InterfaceDAO{

    Livro colunaAuxiliar;
    ArrayList<Livro> tabela;
    Connection conexao = ConexaoFactory.getConnection();
    
    ArrayList<Livro> listarRegistros(){
    String sql = "SELECT * FROM livro";
        try {
            PreparedStatement consulta = conexao.prepareStatement(sql);
            ResultSet resultado = consulta.executeQuery();
            while (resultado.next()) {
                colunaAuxiliar = new Livro(
                        resultado.getInt("id_livro"),
                        resultado.getInt("isbn"),
                        resultado.getString("nome_livro"),
                        resultado.getInt("id_autor"),
                        resultado.getDate("data_publicacao"),
                        resultado.getFloat("preco_livro"));
                tabela.add(colunaAuxiliar);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao consultar" + e.getMessage(), e);
        }
        System.out.println(tabela.get(1));
        return tabela;
    }
}
