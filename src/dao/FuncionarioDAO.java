package dao;

import modelo.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.postgresql.util.PSQLException;

import org.postgresql.util.PSQLException;

public abstract class FuncionarioDAO extends DAO {

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
        sql.append("FROM funcionarios ");
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
    public static boolean cadastrar(Funcionario funcionario) throws SQLException{
    	StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO funcionarios ");
        sql.append("(nome, endereco, cidade, estado, telefone_residencial, telefone_celular, email, cpf, tipo_permissao) ");
        sql.append
                ("VALUES ("+
                "'" +funcionario.getNome()+ "'" + ", " +
                "'" +funcionario.getEndereco()+ "'" + ", " +
                "'" +funcionario.getCidade()+"'" + ", " +
                "'" +funcionario.getEstado()+"'" + ", " +
                "'" +funcionario.getTelefone_residencial() +"'"+ ", " +
                "'" +funcionario.getTelefone_celular() +"',"+
                "'" +funcionario.getEmail()+"'" + ", " +
                "'" +funcionario.getCpf()+"'" + ", " +
                "'" +funcionario.getTipo_permissao()+"'" +
                ");"
                );

        return executeBooleanQuery(sql);
    }

    /*
     * alteraFuncionario: altera um campo de um determinado funcionario.
     * @param String cpfFuncionario
     * @param String coluna
     * @param String novoValor
     * @return
     * */
    public static boolean alterar(Funcionario funcionario) throws SQLException {
    	StringBuilder sql = new StringBuilder();
    	try {
    		
			ResultSet rs = recuperar(funcionario.getMatricula());
			while(rs.next())
				if(rs.getString("nome") == null)
					return false;
		} catch (ClassNotFoundException | NaoEncontradoExeception e) {
			return false;
		}
        sql.append("UPDATE funcionarios ");
        sql.append("SET nome = '" + funcionario.getNome()+ "'," +
        "endereco = '" + funcionario.getEndereco()+ "',"+
        "cidade = '" + funcionario.getEndereco()+ "',"+
        "estado = '" + funcionario.getEstado()+ "',"+
        "telefone_residencial = '" + funcionario.getTelefone_residencial()+ "',"+
        "telefone_celular = '" + funcionario.getTelefone_celular()+ "',"+
        "tipo_permissao = '" + funcionario.getEndereco()+ "' ");
        sql.append("WHERE matricula = " + funcionario.getMatricula() + ";");
        

        return executeBooleanQuery(sql);
    }

    /*
     * removeFuncionario: remove funcionario do banco de dados.
     * @param String cpfFuncionario
     * @return
     * */
    public static boolean remover(int matricula) throws SQLException {
		try {
			ResultSet rs = recuperar(matricula);
			while(rs.next()) {
				if(rs.getString("nome") == null)
					return false;
			}
		} catch (ClassNotFoundException | NaoEncontradoExeception e) {
			return false;
		}
		
    	StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM funcionarios ");
        sql.append("WHERE matricula = " + matricula + ";");

        return executeBooleanQuery(sql);

    }

}
