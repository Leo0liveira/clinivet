package controle;

import java.sql.ResultSet;
import java.sql.SQLException;

import dao.FuncionarioDAO;
import dao.LoginDAO;
import dao.NaoEncontradoExeception;
import modelo.Funcionario;
import modelo.Login;

public class ControleLogin {

	public Login autentica(String cpf, String senha)
    {
    	Login login = null;
    	ResultSet rs;
        try {

        	rs = LoginDAO.recuperar(cpf, senha);
            while(rs.next())
            {
            	login = new Login(rs.getString("cpf"), rs.getString("senha"));
            	
            }
            if (login == null) {
                return null;
            }
            return login;

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
