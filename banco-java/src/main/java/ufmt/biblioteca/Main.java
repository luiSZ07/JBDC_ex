package ufmt.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Livro> registros = LivroDAO.getRegistros();
        LivroDAO.imprimirRegistros(registros);
        
        scanner.close();
    } 
}