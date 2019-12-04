package main;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Scanner;

import controle.ControleAnimal;
import controle.ControleFuncionario;
import controle.ControleLogin;
import controle.ControleRaca;
import controle.ControleVeterinario;
import dao.FuncionarioDAO;
import dao.NaoEncontradoExeception;
import dao.RacaDAO;
import modelo.Funcionario;
import modelo.Raca;

public class TestBDConn {

	public static void main(String[] args) {
		ControleVeterinario cv = new ControleVeterinario();
		
//		System.out.println(cv.adicionaVeterinario("1", "1", "1", "1", "1", "1", "1", "1", "1", 1, "1", "1"));
		System.out.println(cv.buscaVeterinario(1).getNome());
		System.out.println(cv.alteraVeterinario(1, "igor", "1", "1", "1", "1", "1", "1", "1", "1", 1, "1"));
		System.out.println(cv.buscaVeterinario(1).getNome());
		System.out.println(cv.removeVeterinario(1));
		System.out.println(cv.buscaVeterinario(1));
		
//		ControleRaca cr = new ControleRaca();
//		
//		System.out.println(cr.buscaRaca(6));
////		System.out.println(cr.adicionaRaca("martinez cotoco"));
//		System.out.println(cr.buscaRaca(6).getDescricao());
//		System.out.println(cr.alteraRaca(6, "jao doido"));
//		System.out.println(cr.buscaRaca(6).getDescricao());
////		System.out.println(cr.removeRaca(6));
////		System.out.println(cr.buscaRaca(6));

		
		
		
		
		
		
		
//		
//    	ControleFuncionario c = new ControleFuncionario();
//    	ControleLogin cl = new ControleLogin();
//    	ControleAnimal ca = new ControleAnimal();
    	
    	
    	
    	
//    	System.out.println(c.buscaFuncionario(10));
//    	System.out.println(ca.removeAnimal(2));
//    	System.out.println(ca.buscaAnimal(2));
    	
//    	System.out.println(ca.alteraAnimal(, "martinezCotoco", 2157850, "1012-10-10 00:00:00", 2, 2457, "M", "azul"));
//    	System.out.println(ca.buscaAnimal(2).getNome());
    	
//    	if(cl.autentica("123") != null)
//    		System.out.println("autenticado");
//    	System.out.println(c.removeFuncionario(10));
//    	System.out.println(c.buscaFuncionario(10));
    	
		
	}

}
