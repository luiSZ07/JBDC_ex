package ufmt.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        Livro livro = new Livro(scanner);
        LivroDAO.cadastrarLivro(livro);

        ArrayList<Livro> registros = LivroDAO.getRegistros();
        LivroDAO.imprimirRegistros(registros);

        LivroDAO.excluirLivro(scanner);
        LivroDAO.imprimirRegistros(registros);

        LivroDAO.editarLivro(scanner);
        LivroDAO.imprimirRegistros(registros);

        registros = LivroDAO.getRegistrosFaixadePreco(scanner);
        LivroDAO.imprimirRegistros(registros);

        scanner.close();
    } 
}