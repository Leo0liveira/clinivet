package main;

import java.sql.SQLException;
import java.sql.Timestamp;

import controle.ControleFuncionario;
import dao.FuncionarioDAO;
import dao.NaoEncontradoExeception;
import dao.RacaDAO;
import modelo.Funcionario;
import modelo.Raca;

public class TestBDConn {

	public static void main(String[] args) {
		
    	ControleFuncionario c = new ControleFuncionario();
    	
    	System.out.println(c.adicionaFuncionario("1", "1", "1", "1", "1", "1", "1", "1", "1", "1"));
    	
//    	Funcionario f = new Funcionario(0, "1",);
//    	
//    	System.out.println(f.getNome());
    	
		
//		Timestamp dataDeHoje = new Timestamp(System.currentTimeMillis());
//		
//		
//		Raca func = new Raca("pintier", "A raca do capeta");
//		try {
//			RacaDAO.cadastrar(func);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}

}
