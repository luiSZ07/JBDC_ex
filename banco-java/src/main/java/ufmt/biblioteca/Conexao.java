package ufmt.biblioteca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class Conexao {
        public static String url = "jdbc:mysql://localhost:3306/db_biblioteca";
        public static String user = "luiz";
        public static String password = "luiz1234";
        public static Connection conexao;
        
        try {
            conexao = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar" + e.getMessage(), e);
        }
}
