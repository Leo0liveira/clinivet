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
    
    public boolean alteraFuncionario(int id, String nome, String endereco, String cidade, 
    		String estado, String telefone_residencial, String telefone_celular, 
    		String email, String data_contratacao, String cpf, String tipo_permissao)
    {
    	Funcionario funcionario = new Funcionario(0, nome, endereco, cidade, estado, telefone_residencial, telefone_celular, email, data_contratacao, cpf, tipo_permissao);
    	
        try {
			if(RacaDAO.alterar(raca))
				return true;
			else
				return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return false;
		}
    }
    public boolean removeFuncionario(int ID)
    {
    	try {
			if(RacaDAO.remover(ID))
				return true;
			else
				return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return false;
		}
    }
    public Raca buscaFuncionario(int id)
    {
        Raca raca = null;
        try {

            ResultSet rs = RacaDAO.recuperar(id);
            while(rs.next())
            {
                raca = new Raca(rs.getInt("id"), rs.getString("descricao"));
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

        return raca;
        
    }
}
