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
    * recuperaCliente: retorna cliente com id requerido.
    * @param id Int
    * @return
    * */
    public String recuperar(int clienteId) throws SQLException, ClassNotFoundException {

        String cliente = null;
        sql.append("SELECT * ");
        sql.append("FROM clientes");
        sql.append("WHERE id =  " + clienteId);

        try {

            //Cria instancia da conexão (usando singleton)
            //Executa query com o sql escrito acima
            conn = getInstance();
            PreparedStatement ps = conn.prepareStatement(sql.toString());
            rs = ps.executeQuery();
            ps.setInt(1, clienteId);

            Cliente cliente = new Cliente(
                rs.getString(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4),
                rs.getString(5),
                rs.getString(6),
                rs.getString(7),
                rs.getString(8),
                rs.getString(9)
            );

            //Se não houver resultados na query
            if (cliente == null) {
                cliente = "Cliente nao cadastrado.";
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
    public static boolean cadastrar(Cliente cliente) throws SQLException {
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
    public boolean alterar(int clienteId, String coluna, String novoValor) throws SQLException {

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
    public boolean remover(int clienteId) throws SQLException {

        sql.append("DELETE FROM clientes ");
        sql.append("WHERE id = " + clienteId);

        return executeBooleanQuery(sql);

    }

}
