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
    	System.out.println(c.buscaFuncionario(10));
    	
    	System.out.println(c.alteraFuncionario(1667, "igor", "1", "1", "1", "1", "1", "1", "1", "1", "1"));
    	
    	System.out.println(c.removeFuncionario(10));
    	System.out.println(c.buscaFuncionario(10));
    	
		
	}

}
