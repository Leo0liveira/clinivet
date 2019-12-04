package controle;

import java.sql.ResultSet;
import java.sql.SQLException;

import dao.FuncionarioDAO;
import dao.NaoEncontradoExeception;
import jdk.jfr.DataAmount;
import modelo.Funcionario;

public class ControleFuncionario {
	
	public boolean adicionaFuncionario(String nome, String endereco, String cidade, 
    		String estado, String telefone_residencial, String telefone_celular, 
    		String email, String data_contratacao, String cpf, String tipo_permissao)
    {
        // id auto-incremental
		
		Funcionario funcionario = new Funcionario(0, nome, endereco, cidade, estado, telefone_residencial, telefone_celular, email, data_contratacao, cpf, tipo_permissao);

        try {
			if(FuncionarioDAO.cadastrar(funcionario))
			    return true;
			else
			    return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return false;
		}
        
    }
    
    public boolean alteraFuncionario(int matricula, String nome, String endereco, String cidade, 
    		String estado, String telefone_residencial, String telefone_celular, 
    		String email, String data_contratacao, String cpf, String tipo_permissao)
    {
    	Funcionario funcionario = new Funcionario(matricula, nome, endereco, cidade, estado, telefone_residencial, telefone_celular, email, data_contratacao, cpf, tipo_permissao);
    	
        try {
			if(FuncionarioDAO.alterar(funcionario))
				return true;
			else
				return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return false;
		}
    }
    public boolean removeFuncionario(int matricula)
    {
    	try {
			if(FuncionarioDAO.remover(matricula))
				return true;
			else
				return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return false;
		}
    }
    public Funcionario buscaFuncionario(int matricula)
    {
    	Funcionario funcionario = null;
    	ResultSet rs;
        try {

        	rs = FuncionarioDAO.recuperar(matricula);
            while(rs.next())
            {
            	funcionario = new Funcionario(rs.getInt("matricula"), rs.getString("nome"), rs.getString("endereco"), 
            			rs.getString("cidade"), rs.getString("estado"), rs.getString("telefone_residencial"), rs.getString("telefone_celular"), 
            			rs.getString("email"), rs.getString("data_contratacao"), rs.getString("cpf"), rs.getString("tipo_permissao"));
            	
                //Se não houver resultados na query
                if (funcionario == null) {
                    return null;
                }
            }

        } catch (SQLException e) {
           return null;
        }
        catch (NaoEncontradoExeception e) {
           return null;
        }
        catch (ClassNotFoundException e) {
           return null;
        }
        finally {
            if (rs != null) {
                rs.close();
            }

        return funcionario;
        
    }
}
