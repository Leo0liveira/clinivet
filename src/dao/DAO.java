package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * DAO
 */
public abstract class DAO {

    protected static Connection instance = null;

    public abstract boolean cadastrar();

    public abstract boolean alterar();

    public abstract boolean remover();

    public abstract Object recuperar();

    protected Connection getInstance() throws SQLException, ClassNotFoundException {
        if (instance == null || instance.isClosed()) {
            Class.forName("org.postgresql.Driver");
            instance = DriverManager.getConnection("jdbc:postgresql://localhost:5432/clinivet", 
                "postgres", "postgres");
        }
        return instance;
    }

}