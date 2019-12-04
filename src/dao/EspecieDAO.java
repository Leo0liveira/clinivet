package dao;

import modelo.Especie;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class EspecieDAO extends DAO {

    static Connection conn = null;
    static ResultSet rs = null;

    /*
     * executeBooleanQuery: retorna true se a operacao for realizada com sucesso, false caso contrario.
     * @param sql StringBuilder
     * @return
     * */
    private static boolean executeBooleanQuery(StringBuilder sql) throws SQLException {
        try {
            conn = getInstance();
            PreparedStatement ps = conn.prepareStatement(sql.toString());
            rs = ps.executeQuery();
        }  catch (Exception e) {
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

    /*
    * recuperaEspecie: retorna raca com nome requerido.
    * @param codigo int
    * @return
    * */
    public static ResultSet recuperar(int ID) throws SQLException, ClassNotFoundException, NaoEncontradoExeception {
        static StringBuilder sql = new StringBuilder();
        sql.append("SELECT * ");
        sql.append("FROM especies ");
        sql.append("WHERE codigo = ?");

        //Cria instancia da conexão (usando singleton)
        //Executa query com o sql escrito acima
        conn = getInstance();
        PreparedStatement ps = conn.prepareStatement(sql.toString());
        ps.setInt(1, ID);
        return ps.executeQuery();
    }

    /*
     * cadastraEspecie: insere um usuario no banco de dados.
     * @param Especie especie
     * @return
     * */
    public static boolean cadastrar(Especie especie) throws SQLException{
        static StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO especies");
        sql.append("(descricao) ");
        sql.append("VALUES ("+
                "'"+  especie.getDescricao() +"'"+
                ");");

        return executeBooleanQuery(sql);
    }

    /*
     * alteraFuncionario: altera um campo de um determinado raca.
     * @param int codigo
     * @param String descricao
     * @return
     * */
    public static boolean alterar(Especie especie) throws SQLException {
    	StringBuilder sql = new StringBuilder();
    	boolean flag =false;
    	try {
    		
			ResultSet rs = recuperar(especie.getDescricao());
			while(rs.next())
				flag = true;
		} catch (ClassNotFoundException | NaoEncontradoExeception e) {
			return false;
		}
    	if(!flag)
    		return false;

        sql.append("UPDATE especies ");
        sql.append("SET descricao = ''" + especie.getDescricao()+ "''");
        sql.append("WHERE codigo = " + especie.getCodigo());

        return executeBooleanQuery(sql);
    }

    /*
     * removeFuncionario: remove raca do banco de dados.
     * @param String cpfFuncionario
     * @return
     * */
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
        sql.append("DELETE FROM especies ");
        sql.append("WHERE codigo = " + ID);

        return executeBooleanQuery(sql);

    }

}
