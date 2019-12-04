package controle;

import java.sql.Date;
import java.sql.SQLException;

import dao.ProcedimentoDAO;
import modelo.Procedimento;



public class ControleProcedimento {
	public boolean adicionaProcedimento(int codigo, String descricao, double preco) {
		Procedimento procedimento = new Procedimento(tipo, dataHora, id);

        try {
			if(ProcedimentoDAO.cadastrar(procedimento))
			    return true;
			else
			    return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return false;
		}
	}
    
	public boolean alteraProcedimento(int codigo, String descricao, double preco) {
		
	}
	
    public boolean removeProcedimento(int codigo) {
    	
    }
    
    public Procedimento buscaProcedimento(int codigo) {
    	
    }
}
