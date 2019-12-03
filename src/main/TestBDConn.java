package main;

import java.sql.SQLException;
import java.sql.Timestamp;

import dao.FuncionarioDAO;
import dao.NaoEncontradoExeception;
import dao.RacaDAO;
import modelo.Raca;

public class TestBDConn {

	public static void main(String[] args) {
		
		try {
			Raca raca = RacaDAO.recuperar("pintier");
			System.out.println(raca.getNome() + "\n" + raca.getDescricao());
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NaoEncontradoExeception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
