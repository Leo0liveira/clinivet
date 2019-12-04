package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.postgresql.util.PSQLException;

public abstract class LoginDAO extends DAO{
	
    static Connection conn = null;
    static ResultSet rs = null;
    
    private static boolean executeBooleanQuery(StringBuilder sql) throws SQLException {
        try {
            conn = getInstance();
            PreparedStatement ps = conn.prepareStatement(sql.toString());
            rs = ps.executeQuery();
            
        }  catch (PSQLException e) {
            return true;
        } 
          catch (Exception e){
        	  return false;
        }
        finally {
            if (rs != null) {
                rs.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return true;
    }
	
    public static ResultSet recuperar(String cpf, String senha) throws SQLException, ClassNotFoundException, NaoEncontradoExeception {

    	StringBuilder sql = new StringBuilder();
        sql.append("SELECT * ");
        sql.append("FROM login ");
        sql.append("WHERE cpf =  ? AND senha = ?");


            //Cria instancia da conexão (usando singleton)
            //Executa query com o sql escrito acima
            conn = getInstance();
            PreparedStatement ps = conn.prepareStatement(sql.toString());
            ps.setString(1, cpf);
            ps.setString(2, senha);
            rs = ps.executeQuery();

            if (conn != null) {
                conn.close();
            }
        return rs;
    }


}
