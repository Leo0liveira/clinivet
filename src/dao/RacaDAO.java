package dao;

import modelo.Raca;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class RacaDAO extends DAO {

    static Connection conn = null;
    static ResultSet rs = null;
    static StringBuilder sql = new StringBuilder();

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
    * recuperaFuncionario: retorna raca com nome requerido.
    * @param cpfFuncionario String
    * @return
    * */
    public static Raca recuperar(int ID) throws SQLException, ClassNotFoundException, NaoEncontradoExeception {
        Raca raca = null;
        sql.append("SELECT * ");
        sql.append("FROM racas ");
        sql.append("WHERE id = ?");

        try {

            //Cria instancia da conexão (usando singleton)
            //Executa query com o sql escrito acima
            conn = getInstance();
            PreparedStatement ps = conn.prepareStatement(sql.toString());
            ps.setInt(1, ID);
            rs = ps.executeQuery();
            raca = new Raca();
            
            while(rs.next())
            {
        		raca.setID(rs.getString("ID"));
        		raca.setDescricao(rs.getString("descricao"));
            }

            //Se não houver resultados na query
            if (raca == null) {
               	throw new NaoEncontradoExeception("Raca nao cadastrado.");
            }

            // Fecha conexão
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return raca;
    }

    /*
     * cadastraFuncionario: insere um usuario no banco de dados.
     * @param raca raca
     * @return
     * */
    public static boolean cadastrar(Raca raca) throws SQLException{
        sql.append("INSERT INTO racas");
        sql.append("(descricao) ");
        sql.append
                ("VALUES ("+
                "'"+  raca.getDescricao() +"'"+
                ");");

        return executeBooleanQuery(sql);
    }

    /*
     * alteraFuncionario: altera um campo de um determinado raca.
     * @param String cpfFuncionario
     * @param String coluna
     * @param String novoValor
     * @return
     * */
    public boolean alterar(Raca raca) throws SQLException {

        sql.append("UPDATE racas ");
        sql.append("SET descricao = ''" + raca.getDescricao()+ "''");
        sql.append("WHERE id = " + raca.getID());

        return executeBooleanQuery(sql);
    }

    /*
     * removeFuncionario: remove raca do banco de dados.
     * @param String cpfFuncionario
     * @return
     * */
    public boolean remover(int ID) throws SQLException {
        sql.append("DELETE FROM raca ");
        sql.append("WHERE id = " + ID);

        return executeBooleanQuery(sql);

    }

}
