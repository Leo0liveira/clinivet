package main;

import java.sql.SQLException;
import java.sql.Timestamp;

import dao.FuncionarioDAO;
import modelo.Funcionario;

public class TestBDConn {

	public static void main(String[] args) {
		Timestamp dataDeHoje = new Timestamp(System.currentTimeMillis());
		System.out.println(dataDeHoje);
		
		
//		Funcionario func = new Funcionario("igor", 'M', "Rua ufms", "campo grande", 
//					"Mato Grosso do Sul", "00 00000000", "000000000", "igorbgalvan@hotmail.com", dataDeHoje, 0, "012345678-99");
//		try {
//			FuncionarioDAO.cadastrar(func);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}

}
