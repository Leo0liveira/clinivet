package dao;

import modelo.Consulta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class ConsultaDAO extends DAO {

    static Connection conn = null;
    static ResultSet rs = null;
    static StringBuilder sql = new StringBuilder();

    /*
     * executeBooleanQuery: retorna true se a operacao for realizada com sucesso, false caso contrario.
     * @param sql StringBuilder
     * @return
     * */
    private static boolean executeBooleanQuery(final StringBuilder sql) throws SQLException {
        try {
            conn = getInstance();
            final PreparedStatement ps = conn.prepareStatement(sql.toString());
            rs = ps.executeQuery();
        }  catch (final Exception e) {
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
    * recuperaConsulta: retorna consulta com id requerido.
    * @param id Int
    * @return
    * */
    public static Consulta recuperar(int consultaId) throws SQLException, ClassNotFoundException {

        Consulta consulta = null;
        sql.append("SELECT * ");
        sql.append("FROM consultas");
        sql.append("WHERE id =  ?");

        try {

            //Cria instancia da conexão (usando singleton)
            //Executa query com o sql escrito acima
            conn = getInstance();
            final PreparedStatement ps = conn.prepareStatement(sql.toString());
            ps.setInt(1, consultaId);
            rs = ps.executeQuery();

            while(rs.next())
            {
                consulta = new Consulta(
                    rs.getInt("id_animal"),
                    rs.getInt("id_veterinario"),
                    rs.getString("tipo"),
                    rs.getInt("data_hora"),
                    rs.getInt("id")
                );
            }

            //Se não houver resultados na query
            if (consulta == null) {
                throw new NaoEncontradoExeception("Consulta nao cadastrada.");
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
        return consulta;
    }

    /*
     * cadastraConsulta: insere uma consulta no banco de dados.
     * @param consulta Consulta
     * @return
     * */
    public static boolean cadastrar(Consulta consulta) throws SQLException {
        sql.append("INSERT INTO consultas ");
        sql.append("(tipo, data_hora, id_animal, id_veterinario) ");
        sql.append
                ("VALUES ("+
                "'"+consulta.getTipo()+ "'" + ", " +
                "'"+consulta.getDataHora()+"'" + ", " +
                "'"+consulta.getIdAnimal()+"'" + ", " +
                "'"+consulta.getIdVeterinario()+"'" +
                ");");

        System.out.println(sql);
        return executeBooleanQuery(sql);
    }

    /*
     * alteraConsulta: altera um campo de uma determinada consulta.
     * @param int consultaId
     * @param String coluna
     * @param String novoValor
     * @return
     * */
    public boolean alterar(final int consultaId, final String coluna, final String novoValor) throws SQLException {

        sql.append("UPDATE consultas ");
        sql.append("SET " + coluna + " = " + novoValor);
        sql.append("WHERE id = " + consultaId);

        return executeBooleanQuery(sql);
    }

    /*
     * removeConsulta: remove consulta do banco de dados.
     * @param String consultaId
     * @return
     * */
    public boolean remover(final int consultaId) throws SQLException {

        sql.append("DELETE FROM consultas ");
        sql.append("WHERE id = " + consultaId);

        return executeBooleanQuery(sql);

    }

}
