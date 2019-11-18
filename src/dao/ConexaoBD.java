package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexaoBD {

    private static Connection instance = null;

    private ConexaoBD() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexaoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instance = DriverManager.getConnection("jdbc:postgresql://localhost:5432/clinivet", "postgres", "postgres");
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Connection getInstance() throws SQLException {
        if (instance == null || instance.isClosed()) {
            new ConexaoBD();
        }
        return instance;
    }
}