package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * DAO
 */
public abstract class DAO extends ConexaoBD{

    protected static Connection instance = null;

    public static boolean cadastrar() {
		// TODO Auto-generated method stub
		return false;
	}

    public abstract boolean alterar();

    public abstract boolean remover();

    public abstract Object recuperar();

    protected static Connection getInstance(){
        instance = conecta();
        return instance;
    }


}