package main;

import java.sql.ResultSet;
import java.sql.SQLException;

import controle.ControleFuncionario;
import dao.LoginDAO;
import dao.NaoEncontradoExeception;

public class MainFuncionario {
	public static void main(String[] args) throws ClassNotFoundException, SQLException, NaoEncontradoExeception {
		ControleFuncionario c = new ControleFuncionario();
		ResultSet rs = LoginDAO.recuperar("1", "1");
		
		
		rs.next();

		String nome = rs.getString("cpf");
		String senha = rs.getString("senha");
		
		if(nome != null && senha != null) {
			System.out.println("Autenticado");
		}
		
	}

}
