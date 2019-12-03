package dao;

import modelo.Pedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class PedidoDAO extends DAO {

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
    * recuperaPedido: retorna pedido com id requerido.
    * @param id Int
    * @return
    * */
    public Pedido recuperar(int pedidoId) throws SQLException, ClassNotFoundException {

        Pedido pedido = null;
        sql.append("SELECT * ");
        sql.append("FROM pedidos");
        sql.append("WHERE id =  ?");

        try {

            //Cria instancia da conexão (usando singleton)
            //Executa query com o sql escrito acima
            conn = getInstance();
            PreparedStatement ps = conn.prepareStatement(sql.toString());
            ps.setInt(1, pedidoId);
            rs = ps.executeQuery();

            while(rs.next())
            {
                pedido = new Pedido(
                    rs.getString("tipo"),
                    rs.getInt("dataHora")
                );
            }

            //Se não houver resultados na query
            if (pedido == null) {
                throw new NaoEncontradoExeception("Pedido nao cadastrado.");
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
        return pedido;
    }

    /*
     * cadastraPedido: insere um pedido no banco de dados.
     * @param pedido Pedido
     * @return
     * */
    public static boolean cadastrar(Pedido pedido) throws SQLException {
        sql.append("INSERT INTO pedidos ");
        sql.append("(tipo, data_hora) ");
        sql.append
                ("VALUES ("+
                "'"+pedido.getTipo()+ "'" + ", " +
                "'"+pedido.getDataHora()+"'" +
                ");");

        System.out.println(sql);
        return executeBooleanQuery(sql);
    }

    /*
     * alteraPedido: altera um campo de um determinado pedido.
     * @param int pedidoId
     * @param String coluna
     * @param String novoValor
     * @return
     * */
    public boolean alterar(int pedidoId, String coluna, String novoValor) throws SQLException {

        sql.append("UPDATE pedidos ");
        sql.append("SET " + coluna + " = " + novoValor);
        sql.append("WHERE id = " + pedidoId);

        return executeBooleanQuery(sql);
    }

    /*
     * removePedido: remove pedido do banco de dados.
     * @param String pedidoId
     * @return
     * */
    public boolean remover(int pedidoId) throws SQLException {

        sql.append("DELETE FROM pedidos ");
        sql.append("WHERE id = " + pedidoId);

        return executeBooleanQuery(sql);

    }

}
