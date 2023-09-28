package ufmt.biblioteca;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Livro {
    private int id_livro;
    private int isbn;
    private String nome_livro;
    private LocalDate data_publicacao;
    private float preco_livro;

    public Livro(int id_livro, int isbn, String nome_livro, Date data_publicacaosql, float preco_livro) {
        this.id_livro = id_livro;
        this.isbn = isbn;
        this.nome_livro = nome_livro;
        this.data_publicacao = data_publicacaosql.toLocalDate();
        this.preco_livro = preco_livro;
    }

    public Livro(String nome_livro, int isbn, LocalDate data_publicacao, float preco_livro) {
        this.nome_livro = nome_livro;
        this.isbn = isbn;
        this.data_publicacao = data_publicacao;
        this.preco_livro = preco_livro;
    }

    public int getId_livro() {
        return id_livro;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getNome_livro() {
        return nome_livro;
    }

    public void setNome_livro(String nome_livro) {
        this.nome_livro = nome_livro;
    }

    public LocalDate getData_publicacao() {
        return data_publicacao;
    }

    public void setData_publicacao(LocalDate data_publicacao) {
        this.data_publicacao = data_publicacao;
    }

    public float getPreco_livro() {
        return preco_livro;
    }

    public void setPreco_livro(float preco_livro) {
        this.preco_livro = preco_livro;
    }

    public void imprimirLivro() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("---------------------------------------------------------");
        System.out.println("| ID      | ISBN   | Nome                | Data Publicacao  | Preco     |");
        System.out.println("---------------------------------------------------------");
        System.out.printf("| %-8d | %-6d | %-20s | %-14s | %-10.2f |\n",
                id_livro, isbn, nome_livro, data_publicacao.format(formatter), preco_livro);
        System.out.println("---------------------------------------------------------");
    }
}
