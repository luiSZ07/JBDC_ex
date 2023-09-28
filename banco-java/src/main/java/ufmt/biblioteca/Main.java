package ufmt.biblioteca;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 
        Livro[] l = new Livro[5];
        for (int i = 0; i < l.length; i++) {
            l[i] = LivroDAO.criarLivro(scanner);
            LivroDAO.cadastrarLivro(l[i]);
        }

        LivroDAO.imprimirRegistros();
        LivroDAO.excluirLivro();
        //LivroDAO.imprimirRegistrosPorPreco(); arrumar a questão do maldito scanner

        scanner.close();
    } 
}