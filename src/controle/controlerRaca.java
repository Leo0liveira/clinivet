package controle;

import java.sql.SQLException;

import dao.RacaDAO;
import modelo.Raca;

public class controlerRaca
{

    public boolean adicionaRaca(String descricao)
    {
        // id auto-incremental
        Raca raca = new Raca(0, descricao);

        try {
			if(RacaDAO.cadastrar(raca))
			    return true;
			else
			    return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return false;
		}
        
    }
    
    public boolean alteraRaca(int id, String descricao)
    {
    	Raca raca = new Raca(id, descricao);
    	
        try {
			if(RacaDAO.alterar(raca))
				return false;
			else
				return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return false;
		}
    }
    public boolean removeRaca(int codigo)
    {
    	if(RacaDAO.remover(raca))
            System.out.println("Removido");
        else
            System.out.println("Não removido");
    }
    public Raca buscaRaca(int id)
    {
        Raca raca = null;
        try {

            ResultSet rs = RacaDAO.recuperar(id);
            while(rs.next())
            {
                raca = new raca(rs.getInt("id"), rs.getString("descricao"));
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