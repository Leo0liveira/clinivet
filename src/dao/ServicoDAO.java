package dao;

import modelo.Servico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class ServicoDAO extends DAO {

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
    * recuperaServico: retorna raca com nome requerido.
    * @param idServico Int
    * @return
    * */
    public static Servico recuperar(int idServico) throws SQLException, ClassNotFoundException, NaoEncontradoExeception {
        Servico servico = null;
        sql.append("SELECT * ");
        sql.append("FROM servicos ");
        sql.append("WHERE nome = ?");

        try {

            //Cria instancia da conexão (usando singleton)
            //Executa query com o sql escrito acima
            conn = getInstance();
            PreparedStatement ps = conn.prepareStatement(sql.toString());
            ps.setInt(1, idServico);
            rs = ps.executeQuery();

            while(rs.next())
            {
                servico = new Servico(
                    rs.getString("tipo"),
                    rs.getInt("data_hora"),
                    rs.getInt("numero"),
                    rs.getString("nome")
                );
            }

            //Se não houver resultados na query
            if (servico == null) {
               	throw new NaoEncontradoExeception("Servico nao cadastrado.");
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
        return servico;
    }

    /*
     * cadastraFuncionario: insere um usuario no banco de dados.
     * @param raca raca
     * @return
     * */
    public static boolean cadastrar(Servico servico) throws SQLException{
        sql.append("INSERT INTO servicos ");
        sql.append("(numero, tipo) ");
        sql.append
                ("VALUES ("+
                "'" +servico.getNome()+ "'" + ", " +
                "'"+  servico.getCodigo()+"'"+
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
    public boolean alterar(String nomeRaca, String coluna, String novoValor) throws SQLException {

        sql.append("UPDATE raca ");
        sql.append("SET " + coluna + " = " + novoValor);
        sql.append("WHERE nome = " + nomeRaca);

        return executeBooleanQuery(sql);
    }

    /*
     * removeFuncionario: remove raca do banco de dados.
     * @param String cpfFuncionario
     * @return
     * */
    public boolean remover(String racaNome) throws SQLException {
        sql.append("DELETE FROM raca ");
        sql.append("WHERE nome = " + racaNome);

        return executeBooleanQuery(sql);

    }

}
