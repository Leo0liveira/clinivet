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
     * executeBooleanQuery: retorna true se a operacao for realizada com sucesso,
     * false caso contrario.
     * 
     * @param sql StringBuilder
     * 
     * @return
     */
    private static boolean executeBooleanQuery(final StringBuilder sql) throws SQLException {
        try {
            conn = getInstance();
            final PreparedStatement ps = conn.prepareStatement(sql.toString());
            rs = ps.executeQuery();
        } catch (final Exception e) {
            return false;
        } finally {
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
     * 
     * @param id Int
     * 
     * @return
     */
    public ResultSet recuperar(String CPF) throws SQLException, ClassNotFoundException, NaoEncontradoExeception {

        sql.append("SELECT * ");
        sql.append("FROM clientes");
        sql.append("WHERE cpf =  ?");

        // Cria instancia da conexão (usando singleton)
        // Executa query com o sql escrito acima
        conn = getInstance();
        PreparedStatement ps = conn.prepareStatement(sql.toString());
        ps.setString(1, CPF);
        return ps.executeQuery();
    }

    /*
     * cadastraCliente: insere um cliente no banco de dados.
     * 
     * @param cliente Cliente
     * 
     * @return
     */
    public boolean cadastrar(Cliente cliente) throws SQLException {
        sql.append("INSERT INTO clientes");
        sql.append("(nome, sexo, endereco, cidade, estado, telefoneResidencial, telefoneCelular, email, cpf) ");
        sql.append("VALUES (" + 
        "'" + cliente.getNome() + "','" 
        + cliente.getSexo() + "','"
        + cliente.getEndereco() + "','" 
        + cliente.getCidade() + "','"
        + cliente.getEstado() + "','" 
        + cliente.getTelefoneResidencial() + "','"
        + cliente.getTelefoneCelular() + "','" 
        + cliente.getEmail() + "','"
        + cliente.getCpf() + "'" + ");");

        System.out.println(sql);
        return executeBooleanQuery(sql);
    }

    /*
     * alteraCliente: altera um campo de um determinado cliente.
     * 
     * @param int clienteId
     * 
     * @param String coluna
     * 
     * @param String novoValor
     * 
     * @return
     */
    public boolean alterar(Cliente cliente) throws SQLException {

        sql.append("UPDATE clientes SET ");
        sql.append("CPF = '" + cliente.getCPF() + "',");
        sql.append("Nome = '" + cliente.getNome() + "',");
        sql.append("Endereco = '" + cliente.getEndereco() + "',");
        sql.append("Cidade = '" + cliente.getCidade() + "',");
        sql.append("Estado = '" + cliente.getEstado() + "',");
        sql.append("Telefone = '" + cliente.getTelefone() + "',");
        sql.append("Documento = '" + cliente.getDocumento() + "',");
        sql.append("Email = '" + cliente.getEmail() + "' ");
        sql.append("WHERE cpf = '" + cliente.getCPF() + "'");

        return executeBooleanQuery(sql);
    }

    /*
     * removeCliente: remove cliente do banco de dados.
     * 
     * @param String clienteId
     * 
     * @return
     */
    public boolean remover(String cpf) throws SQLException {

        sql.append("DELETE FROM clientes ");
        sql.append("WHERE cpf = '" + cpf + "'");

        return executeBooleanQuery(sql);
    }

}
