package controle;

import java.sql.ResultSet;
import java.sql.SQLException;

import dao.EspecieDAO;
import dao.NaoEncontradoExeception;
import modelo.Especie;

public class ControleEspecie {

	public boolean adicionaEspecie(String especieNome)
	{
		// id auto-incremental
		Especie especie = new Especie(0, especieNome);

		try {
			if(EspecieDAO.cadastrar(especie))
				return true;
			else
				return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return false;
		}
		
	}

	public boolean alteraEspecie(int codigo, String especieNome)
	{
        Especie especie = new Especie(codigo, especieNome);

        try {
			if (EspecieDAO.alterar(especie)) {
			    return true;
			} else {
			    return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return false;
		}
	}
	
    public boolean removeEspecie(int ID)
    {
    	try {
			if(EspecieDAO.remover(ID))
				return true;
			else
				return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return false;
		}
    }
	
    public Especie buscaEspecie(int codigo)
    {
        Especie especie = null;
        try {

            ResultSet rs = EspecieDAO.recuperar(codigo);
            while(rs.next())
            {
                especie = new Especie(rs.getInt("codigo"), rs.getString("especie"));
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

        return especie;
        
    }
}
    
