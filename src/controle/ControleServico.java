package controle;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import dao.ConsultaDAO;
import modelo.Consulta;



public class ControleServico {
	public boolean AgendarConsulta(Date data,String Horario, String CPF, String NomeVet, String Descricao, String FormaDePagamento) {
		Consulta consulta = new Consulta();

        try {
			if(ConsultaDAO.cadastrar(consulta))
			    return true;
			else
			    return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return false;
		}
	}

    public boolean AgendarProcedimento(Date data,String Horario, String CPF, String NomeVet, String TipoDeProcedimento, String FormaDePagamento) {
    	
    }


    // retorna lista de todos os animais agrupados por especie
    public ArrayList ImprimeRelatorioRacas() {
    	
    }

    //retorna lista de todas as consultas e procedimentos feitos em um animal espefico
    public ArrayList ImprimeConsultasProcedimentosPorAnimal() {
    	
    }

    //retorna todas as consultas e procedimentos feitos na clinica
    public ArrayList ImprimeConsultaProcedimentosClinica() {
    	
    }

}
