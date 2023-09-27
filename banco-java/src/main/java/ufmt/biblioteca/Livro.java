package ufmt.biblioteca;

import java.time.LocalDate;

public class Livro {
    short id_livro;
    String nome_livro;
    int id_autor;
    LocalDate data_publicacao;
    int preco_livro;
    
    public Livro(String nome_livro, int id_autor, LocalDate data_publicacao, int preco_livro) {
        this.nome_livro = nome_livro;
        this.id_autor = id_autor;
        this.data_publicacao = data_publicacao;
        this.preco_livro = preco_livro;
    }

    public short getId_livro() {
        return id_livro;
    }

    public String getNome_livro() {
        return nome_livro;
    }

    public void setNome_livro(String nome_livro) {
        this.nome_livro = nome_livro;
    }

    public int getId_autor() {
        return id_autor;
    }

    public void setId_autor(int id_autor) {
        this.id_autor = id_autor;
    }

    public LocalDate getData_publicacao() {
        return data_publicacao;
    }

    public void setData_publicacao(LocalDate data_publicacao) {
        this.data_publicacao = data_publicacao;
    }

    public int getPreco_livro() {
        return preco_livro;
    }

    public void setPreco_livro(int preco_livro) {
        this.preco_livro = preco_livro;
    }
}
