package dao;

import modelo.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.postgresql.util.PSQLException;

public abstract class ClienteDAO extends DAO {

    static Connection conn = null;
    static ResultSet rs = null;

    /*
     * executeBooleanQuery: retorna true se a operacao for realizada com sucesso,
     * false caso contrario.
     * 
     * @param sql StringBuilder
     * 
     * @return
     */
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

    /*
     * recuperaCliente: retorna cliente com id requerido.
     * 
     * @param id Int
     * 
     * @return
     */
    public static ResultSet recuperar(int CPF) throws SQLException, ClassNotFoundException, NaoEncontradoExeception {
        StringBuilder sql = new StringBuilder();

        sql.append("SELECT * ");
        sql.append("FROM clientes ");
        sql.append("WHERE cpf =  ?");

        // Cria instancia da conexão (usando singleton)
        // Executa query com o sql escrito acima
        conn = getInstance();
        PreparedStatement ps = conn.prepareStatement(sql.toString());
        ps.setInt(1, CPF);
        ResultSet rs = ps.executeQuery();
        
        if (conn != null) 
            conn.close();
       return rs;
    }

    /*
     * cadastraCliente: insere um cliente no banco de dados.
     * 
     * @param cliente Cliente
     * 
     * @return
     */
    public static boolean cadastrar(Cliente cliente) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO clientes");
        sql.append("(cpf, nome, endereco, cidade, estado, telefone, documento, email) ");
        sql.append("VALUES (" + 
        "" + cliente.getCPF() + ",'" 
        + cliente.getNome() + "','" 
        + cliente.getEndereco() + "','"
        + cliente.getCidade() + "','" 
        + cliente.getEstado() + "','"
        + cliente.getTelefone() + "'," 
        + cliente.getDocumento() + ",'"
        + cliente.getEmail() + "'" + ");");

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
    public static boolean alterar(Cliente cliente) throws SQLException {
    	StringBuilder sql = new StringBuilder();
    	boolean flag =false;
    	try {
    		
			ResultSet rs = recuperar(cliente.getCPF());
			while(rs.next())
				flag = true;
		} catch (ClassNotFoundException | NaoEncontradoExeception e) {
			return false;
		}
    	if(!flag)
    		return false;
    	
        sql.append("UPDATE clientes SET ");
        sql.append("cpf = '" + cliente.getCPF() + "',");
        sql.append("nome = '" + cliente.getNome() + "',");
        sql.append("endereco = '" + cliente.getEndereco() + "',");
        sql.append("cidade = '" + cliente.getCidade() + "',");
        sql.append("estado = '" + cliente.getEstado() + "',");
        sql.append("telefone = '" + cliente.getTelefone() + "',");
        sql.append("documento = '" + cliente.getDocumento() + "',");
        sql.append("email = '" + cliente.getEmail() + "' ");
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
    public static boolean remover(int cpf) throws SQLException {
    	StringBuilder sql = new StringBuilder();
    	boolean flag =false;
    	try {
    		
			ResultSet rs = recuperar(cpf);
			while(rs.next())
				flag = true;
		} catch (ClassNotFoundException | NaoEncontradoExeception e) {
			return false;
		}
    	if(!flag)
    		return false;
    	
        sql.append("DELETE FROM clientes ");
        sql.append("WHERE cpf = '" + cpf + "'");

        return executeBooleanQuery(sql);
    }

}
