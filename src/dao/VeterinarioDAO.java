package dao;

import modelo.Funcionario;
import modelo.Login;
import modelo.Veterinario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.postgresql.util.PSQLException;

import org.postgresql.util.PSQLException;

public abstract class VeterinarioDAO extends DAO {

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
    * recuperaFuncionario: retorna funcioario com id requerido.
    * @param cpfFuncionario String
    * @return
    * */
    public static ResultSet recuperar(int matricula) throws SQLException, ClassNotFoundException, NaoEncontradoExeception {

    	StringBuilder sql = new StringBuilder();
        sql.append("SELECT * ");
        sql.append("FROM veterinarios ");
        sql.append("WHERE matricula =  ?");


            //Cria instancia da conexão (usando singleton)
            //Executa query com o sql escrito acima
            conn = getInstance();
            PreparedStatement ps = conn.prepareStatement(sql.toString());
            ps.setInt(1, matricula);
            rs = ps.executeQuery();

            if (conn != null) {
                conn.close();
            }
        return rs;
    }

    /*
     * cadastraFuncionario: insere um usuario no banco de dados.
     * @param funcionario Funcionario
     * @return
     * */
    public static boolean cadastrar(Veterinario veterinario, Login login) throws SQLException{
    	StringBuilder sql = new StringBuilder();
    	
        sql.append("INSERT INTO veterinarios ");
        sql.append("(nome, endereco, cidade, estado, telefone_residencial, telefone_celular, email, cpf, crmv, tipo_permissao) ");
        sql.append
                ("VALUES ("+
                "'" +veterinario.getNome()+ "'" + ", " +
                "'" +veterinario.getEndereco()+ "'" + ", " +
                "'" +veterinario.getCidade()+"'" + ", " +
                "'" +veterinario.getEstado()+"'" + ", " +
                "'" +veterinario.getTelefone_residencial() +"'"+ ", " +
                "'" +veterinario.getTelefone_celular() +"',"+
                "'" +veterinario.getEmail()+"'" + ", " +
                "'" +veterinario.getCpf()+"'" + ", " +
                "'" +veterinario.getCrmv()+"'" + ", " +
                "'" +veterinario.getTipo_permissao()+"'" +
                ");"
                );
        cadastrarLogin(login);
        return executeBooleanQuery(sql);
    }
    
    public static boolean cadastrarLogin(Login login) throws SQLException{
    	StringBuilder sql1 = new StringBuilder();
        sql1.append("INSERT INTO login ");
        sql1.append("(cpf, senha) ");
        sql1.append
                ("VALUES ("+
                "'" +login.getCpf()+ "'" + ", " +
                "'" +login.getPassword()+"'" +
                ");"
                );

        return executeBooleanQuery(sql1);
    }

    /*
     * alteraFuncionario: altera um campo de um determinado funcionario.
     * @param String cpfFuncionario
     * @param String coluna
     * @param String novoValor
     * @return
     * */
    public static boolean alterar(Veterinario veterinario) throws SQLException {
    	StringBuilder sql = new StringBuilder();
    	boolean flag =false;
    	try {
    		
			ResultSet rs = recuperar(veterinario.getMatricula());
			while(rs.next())
				flag = true;
		} catch (ClassNotFoundException | NaoEncontradoExeception e) {
			return false;
		}
    	if(!flag)
    		return false;
    	
        sql.append("UPDATE veterinarios ");
        sql.append("SET nome = '" + veterinario.getNome()+ "'," +
        "endereco = '" + veterinario.getEndereco()+ "',"+
        "cidade = '" + veterinario.getEndereco()+ "',"+
        "estado = '" + veterinario.getEstado()+ "',"+
        "telefone_residencial = '" + veterinario.getTelefone_residencial()+ "',"+
        "telefone_celular = '" + veterinario.getTelefone_celular()+ "',"+
        "tipo_permissao = '" + veterinario.getEndereco()+ "' ");
        sql.append("WHERE matricula = " + veterinario.getMatricula() + ";");
        

        return executeBooleanQuery(sql);
    }

    /*
     * removeFuncionario: remove funcionario do banco de dados.
     * @param String cpfFuncionario
     * @return
     * */
    public static boolean remover(int matricula) throws SQLException {
    	StringBuilder sql = new StringBuilder();
    	boolean flag =false;
    	try {
    		
			ResultSet rs = recuperar(matricula);
			while(rs.next())
				flag = true;
		} catch (ClassNotFoundException | NaoEncontradoExeception e) {
			return false;
		}
    	if(!flag)
    		return false;
        sql.append("DELETE FROM veterinarios ");
        sql.append("WHERE matricula = " + matricula + ";");

        return executeBooleanQuery(sql);

    }

}
