package controle;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import dao.ConsultaDAO;
import modelo.Consulta;



public class ControleConsulta {
    public Consulta consulta;
    private ResultSet resultSet;
    
    public boolean salvarDados(int idAnimal, int idVeterinario, String tipo, Date dataHora, int id, String horario, String pagamentoForma) {
    	
    	Consulta consulta = new Consulta(idAnimal, idVeterinario, tipo, (java.sql.Date) dataHora, 0, horario, pagamentoForma);
    	
    	try{
        	if (ConsultaDAO.cadastrar(consulta)) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			return false;
		}
    }
    
    
}

    