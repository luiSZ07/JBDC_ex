package ufmt.biblioteca;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

public class LivroDAO {

    public static ArrayList<Livro> getRegistros() {
        Connection conexao = ConexaoFactory.getConnection();
        String sql = "SELECT * FROM livro";
        ArrayList<Livro> tabela = new ArrayList<Livro>();

        try {
            PreparedStatement consulta = conexao.prepareStatement(sql);
            ResultSet resultado = consulta.executeQuery();
            while (resultado.next()) {
                Livro colunaAuxiliar = new Livro(
                        resultado.getInt("id_livro"),
                        resultado.getString("nome_livro"),
                        resultado.getInt("isbn"),
                        resultado.getDate("data_publicacao"),
                        resultado.getFloat("preco_livro"));
                tabela.add(colunaAuxiliar);
            }
            consulta.close();
            conexao.close();
            return tabela;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao consultar" + e.getMessage(), e);
        }
    }

    public static int cadastrarLivro(Livro l) {
        Connection conexao = ConexaoFactory.getConnection();
        String sql = "INSERT INTO livro (nome_livro, isbn, data_publicacao, preco_livro) VALUES (?,?,?,?)";

        try {
            System.out.println("CADASTRANDO LIVRO NA BIBLIOTECA...");
            PreparedStatement consulta = conexao.prepareStatement(sql);
            consulta.setString(1, l.getNome_livro());
            consulta.setInt(2, l.getIsbn());
            Date datasql = Date.valueOf(l.getData_publicacao());
            consulta.setDate(3, datasql);
            consulta.setFloat(4, l.getPreco_livro());
            int rowsAffected = consulta.executeUpdate();
            consulta.close();
            conexao.close();
            return rowsAffected;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar" + e.getMessage(), e);
        }
    }

    public static int excluirLivro(Scanner scanner) {
        Connection conexao = ConexaoFactory.getConnection();
        String sql = "DELETE FROM livro WHERE id_livro = ?";

        System.out.printf("Insira o id do livro a ser excluido: ");
        int id_excluir = scanner.nextInt();

        try {
            PreparedStatement consulta = conexao.prepareStatement(sql);
            consulta.setInt(1, id_excluir);

            int rowsAffected = consulta.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Livro excluido com sucesso.");
            } else {
                System.out.println("Nenhum livro foi excluido.");
            }
            
            conexao.close();
            return rowsAffected;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir" + e.getMessage(), e);
        }
    }

    public static ArrayList<Livro> getRegistrosFaixadePreco(Scanner scanner) {

        System.out.println("Insira a faixa de preços a ser consultada");
        System.out.printf("\nValor max: ");
        float max = scanner.nextInt();
        scanner.nextLine();

        System.out.printf("\nValor min: ");
        float min = scanner.nextInt();
        scanner.nextLine();

        Connection conexao = ConexaoFactory.getConnection();
        String sql = "SELECT * FROM livro WHERE preco_livro >= ? and preco_livro <= ?";
        ArrayList<Livro> tabela = new ArrayList<Livro>();

        try {
            PreparedStatement consulta = conexao.prepareStatement(sql);
            consulta.setFloat(1, min);
            consulta.setFloat(2, max);
            ResultSet resultado = consulta.executeQuery();
            while (resultado.next()) {
                Livro colunaAuxiliar = new Livro(
                        resultado.getInt("id_livro"),
                        resultado.getString("nome_livro"),
                        resultado.getInt("isbn"),
                        resultado.getDate("data_publicacao"),
                        resultado.getFloat("preco_livro"));
                tabela.add(colunaAuxiliar);
            }
            consulta.close();
            conexao.close();
            return tabela;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao consultar" + e.getMessage(), e);
        }
    }

    public static int editarLivro(Scanner scanner) {
        Connection conexao = ConexaoFactory.getConnection();
        
        String sql = "UPDATE livro " + //
                "SET nome_livro = ?, isbn = ?, data_publicacao = ?, preco_livro = ? " + //
                "WHERE id_livro = ?";

        System.out.printf("Insira o id do livro a ser alterado: ");
        int id_editar = scanner.nextInt();
        scanner.nextLine();
        Livro livroAux = new Livro(scanner);

        try {
            PreparedStatement consulta = conexao.prepareStatement(sql);
            consulta.setInt(5, id_editar);
            consulta.setString(1, livroAux.getNome_livro());
            consulta.setInt(2, livroAux.getIsbn());
            Date datasql = Date.valueOf(livroAux.getData_publicacao());
            consulta.setDate(3, datasql);
            consulta.setFloat(4, livroAux.getPreco_livro());

            int rowsAffected = consulta.executeUpdate();
            if (rowsAffected == 1) {
                System.out.println("Livro editado com sucesso.");
            } else {
                System.out.println("Nenhum livro foi editado.");
            }

            conexao.close();
            return rowsAffected;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir" + e.getMessage(), e);
        }
    }

    public static void imprimirRegistros(ArrayList<Livro> registroLivros) {
        for (Livro livro : registroLivros) {
            livro.imprimirLivro();
        }
    }
}
