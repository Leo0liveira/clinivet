package dao;

import modelo.Raca;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.postgresql.util.PSQLException;

public abstract class RacaDAO extends DAO {

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

    
    public static ResultSet recuperar(int ID) throws SQLException, ClassNotFoundException, NaoEncontradoExeception {
    	
    	StringBuilder sql = new StringBuilder();
        sql.append("SELECT * ");
        sql.append("FROM racas ");
        sql.append("WHERE codigo = ?");

        //Cria instancia da conexão (usando singleton)
        //Executa query com o sql escrito acima
        conn = getInstance();
        PreparedStatement ps = conn.prepareStatement(sql.toString());
        ps.setInt(1, ID);
        return ps.executeQuery();
    }

 
    public static boolean cadastrar(Raca raca) throws SQLException{
    	StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO racas");
        sql.append("(descricao) ");
        sql.append
                ("VALUES ("+
                "'"+  raca.getDescricao() +"'"+
                ");");

        return executeBooleanQuery(sql);
    }


    public static boolean alterar(Raca raca) throws SQLException {
    	StringBuilder sql = new StringBuilder();
    	boolean flag =false;
    	try {
    		
			ResultSet rs = recuperar(raca.getID());
			while(rs.next())
				flag = true;
		} catch (ClassNotFoundException | NaoEncontradoExeception e) {
			return false;
		}
    	if(!flag)
    		return false;

        sql.append("UPDATE racas ");
        sql.append("SET descricao = '" + raca.getDescricao()+ "' ");
        sql.append("WHERE codigo = " + raca.getID()+ ";");

        return executeBooleanQuery(sql);
    }

    public static boolean remover(int ID) throws SQLException {
    	StringBuilder sql = new StringBuilder();
    	boolean flag =false;
    	try {
    		
			ResultSet rs = recuperar(ID);
			while(rs.next())
				flag = true;
		} catch (ClassNotFoundException | NaoEncontradoExeception e) {
			return false;
		}
    	if(!flag)
    		return false;
        sql.append("DELETE FROM racas ");
        sql.append("WHERE codigo = " + ID);

        return executeBooleanQuery(sql);

    }

}
