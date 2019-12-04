package controle;

import java.sql.ResultSet;
import java.sql.SQLException;

import dao.FuncionarioDAO;
import dao.NaoEncontradoExeception;
import dao.VeterinarioDAO;
import modelo.Funcionario;
import modelo.Login;
import modelo.Veterinario;

public class ControleVeterinario{
	
	public boolean adicionaVeterinario(String nome, String endereco, String cidade, 
    		String estado, String telefone_residencial, String telefone_celular, 
    		String email, String data_contratacao, String cpf, int crmv, String tipo_permissao, String password)
    {
        // id auto-incremental
		
		Veterinario veterinario = new Veterinario(0, nome, endereco, cidade, estado, telefone_residencial, telefone_celular, email, data_contratacao, cpf, crmv, tipo_permissao);
		Login login = new Login(cpf, password);

        try {
			if(VeterinarioDAO.cadastrar(veterinario, login))
			    return true;
			else
			    return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return false;
		}
        
    }
    
    public boolean alteraVeterinario(int matricula, String nome, String endereco, String cidade, 
    		String estado, String telefone_residencial, String telefone_celular, 
    		String email, String data_contratacao, String cpf, int crmv, String tipo_permissao)
    {
    	Veterinario veterinario = new Veterinario(matricula, nome, endereco, cidade, estado, telefone_residencial, telefone_celular, email, data_contratacao, cpf, crmv, tipo_permissao);
    	
        try {
			if(VeterinarioDAO.alterar(veterinario))
				return true;
			else
				return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return false;
		}
    }
    public boolean removeVeterinario(int matricula)
    {
    	try {
			if(VeterinarioDAO.remover(matricula))
				return true;
			else
				return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return false;
		}
    }
    
    public Funcionario buscaVeterinario(int matricula)
    {
    	Veterinario veterinario = null;
    	ResultSet rs;
        try {

        	rs = VeterinarioDAO.recuperar(matricula);
            while(rs.next())
            {
            	veterinario = new Veterinario(rs.getInt("matricula"), rs.getString("nome"), rs.getString("endereco"), 
            			rs.getString("cidade"), rs.getString("estado"), rs.getString("telefone_residencial"), rs.getString("telefone_celular"), 
            			rs.getString("email"), rs.getString("data_contratacao"), rs.getString("cpf"), rs.getInt("crmv"), rs.getString("tipo_permissao"));
            	
                //Se não houver resultados na query
            }
            if (veterinario == null) {
                return null;
            }
            return veterinario;

        } catch (SQLException e) {
           return null;
        }
        catch (NaoEncontradoExeception e) {
           return null;
        }
        catch (ClassNotFoundException e) {
           return null;
        }
    }
}
        

