package dao;

import modelo.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class ClienteDAO extends DAO {

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
    * recuperaCliente: retorna cliente com id requerido.
    * @param id Int
    * @return
    * */
    public static Cliente recuperar(int clienteId) throws SQLException, ClassNotFoundException, NaoEncontradoExeception {

        Cliente cliente = null;
        sql.append("SELECT * ");
        sql.append("FROM clientes");
        sql.append("WHERE id =  ?");

        try {

            //Cria instancia da conexão (usando singleton)
            //Executa query com o sql escrito acima
            conn = getInstance();
            final PreparedStatement ps = conn.prepareStatement(sql.toString());
            ps.setInt(1, clienteId);
            rs = ps.executeQuery();

            while(rs.next())
            {
                cliente = new Cliente(
                    rs.getString("nome"),
                    rs.getString("sexo"),
                    rs.getString("endereco"),
                    rs.getString("cidade"),
                    rs.getString("estado"),
                    rs.getString("telefoneResidencial"),
                    rs.getString("telefoneCelular"),
                    rs.getString("email"),
                    rs.getString("cpf")
                );
            }

            //Se não houver resultados na query
            if (cliente == null) {
                throw new NaoEncontradoExeception("Cliente nao cadastrado.");
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
        return cliente;
    }

    /*
     * cadastraCliente: insere um cliente no banco de dados.
     * @param cliente Cliente
     * @return
     * */
    public static boolean cadastrar(final Cliente cliente) throws SQLException {
        sql.append("INSERT INTO clientes");
        sql.append("(nome, sexo, endereco, cidade, estado, telefoneResidencial, telefoneCelular, email, cpf) ");
        sql.append
                ("VALUES ("+
                "'"+cliente.getNome()+ "'" + ", " +
                "'"+cliente.getSexo()+"'" + ", " +
                "'"+cliente.getEndereco()+"'" + ", " +
                "'"+cliente.getCidade()+"'" + ", " +
                "'"+cliente.getEstado()+"'" + ", " +
                "'"+cliente.getTelefoneResidencial()+"'" + ", " +
                "'"+cliente.getTelefoneCelular()+"'" + ", " +
                "'"+cliente.getEmail()+"'" + ", " +
                "'"+cliente.getCpf()+"'" +
                ");");

        System.out.println(sql);
        return executeBooleanQuery(sql);
    }

    /*
     * alteraCliente: altera um campo de um determinado cliente.
     * @param int clienteId
     * @param String coluna
     * @param String novoValor
     * @return
     * */
    public boolean alterar(final int clienteId, final String coluna, final String novoValor) throws SQLException {

        sql.append("UPDATE clientes ");
        sql.append("SET " + coluna + " = " + novoValor);
        sql.append("WHERE id = " + clienteId);

        return executeBooleanQuery(sql);
    }

    /*
     * removeCliente: remove cliente do banco de dados.
     * @param String clienteId
     * @return
     * */
    public boolean remover(final int clienteId) throws SQLException {

        sql.append("DELETE FROM clientes ");
        sql.append("WHERE id = " + clienteId);

        return executeBooleanQuery(sql);

    }

}
