package main;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Scanner;

import controle.ControleAnimal;
import controle.ControleEspecie;
import controle.ControleFuncionario;
import controle.ControleLogin;
import controle.ControleRaca;
import controle.ControleVeterinario;
import controle.ControleCliente;
import dao.EspecieDAO;
import dao.FuncionarioDAO;
import dao.LoginDAO;
import dao.NaoEncontradoExeception;
import dao.RacaDAO;
import modelo.Funcionario;
import modelo.Raca;

public class TestBDConn {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, NaoEncontradoExeception {
		
		int index = 3;
		String nome = null;
		String senha = null;
    	ControleLogin cl = new ControleLogin();
		Scanner input = new Scanner(System.in);
		System.out.println("digite o cpf");
		String user = input.next();
		System.out.println("digite a senha");
		String password = input.next();
		ResultSet rs = LoginDAO.recuperar(user, password);
		
		
		while(rs.next()) {

		 nome = rs.getString("cpf");
		 senha = rs.getString("senha");
		}
		System.out.println('\n');
		if(nome != null && senha != null) {
			System.out.println("Autenticado");}
		else {
			System.out.println("senha incorreta");
			return;
		
		}
		
		
		ControleCliente cc = new ControleCliente();
		System.out.println("Adicionar um cliente            : " + cc.IncluiCliente(242424, "Igor", "kk", "kk", "kk", "aa", 2424, "dsad"));
		System.out.println("Imprime o nome do cliente       : " + cc.busca(242424).getNome());
		System.out.println("Altera cliente                  : " + cc.AlteraCliente(242424, "Gabriel", "kk", "kk", "kk", "aa", 2424, "dsad"));
		System.out.println("Imprime novo nome do cliente    : " + cc.busca(242424).getNome());
		System.out.println("Remover o cliente               : " + cc.RemoveCliente(242424));
		System.out.println("Busca o cliente                 : " + cc.busca(242424));
		System.out.println();
		
		
		ControleEspecie ce = new ControleEspecie();
		
		System.out.println("Adicionar uma especie            : " + ce.adicionaEspecie("Teste especie"));
		System.out.println("Imprime o nome da especie        : " + ce.buscaEspecie(index).getDescricao());
		System.out.println("Altera a especie                 : " + ce.alteraEspecie(index, "Nova especie"));
		System.out.println("Imprime o novo nome da especie   : " + ce.buscaEspecie(index).getDescricao());
		System.out.println("Remover a especie                : " + ce.removeEspecie(index));
		System.out.println("Busca a especie                  : " + ce.buscaEspecie(index));
		System.out.println();
		
		
		ControleVeterinario cv = new ControleVeterinario();

		System.out.println("Adiciona um veterinario           : " + cv.adicionaVeterinario("1", "1", "1", "1", "1", "1", "1", "1", "1", 1, "1", "1"));
		System.out.println("Imprime o nome do veterinario     : " + cv.buscaVeterinario(index).getNome());
		System.out.println("Altera o veterinario              : " + cv.alteraVeterinario(index, "igor", "1", "1", "1", "1", "1", "1", "1", "1", 1, "1"));
		System.out.println("Imprime novo nome do veterinario  : " + cv.buscaVeterinario(index).getNome());
		System.out.println("Remover o veterinario             : " + cv.removeVeterinario(index));
		System.out.println("Busca o veterinario               : " + cv.buscaVeterinario(index));
		System.out.println();
		
		
		ControleRaca cr = new ControleRaca();
		
		System.out.println("Adiciona uma raca           : " + cr.adicionaRaca("martinez cotoco"));
		System.out.println("Imprime nome da raca        : " + cr.buscaRaca(index).getDescricao());
		System.out.println("Altera a raca               : " + cr.alteraRaca(index, "jao doido"));
		System.out.println("Imprime novo nome da raca   : " + cr.buscaRaca(index).getDescricao());
		System.out.println("Remover a raca              : " + cr.removeRaca(index));
		System.out.println("Busca a raca                : " + cr.buscaRaca(index));
		System.out.println();

		
		
		
    	ControleFuncionario crs = new ControleFuncionario();
//    	ControleAnimal ca = new ControleAnimal();
    	
    	System.out.println("Adiciona funcionario               :" + crs.adicionaFuncionario("1", "funcionario", "1", "1", "1", "1", "1", "1", "1", "1", "senha"));
		System.out.println("Imprime nome do funcionario        : " + crs.buscaFuncionario(index).getNome());
		System.out.println("altera funcionario                 :" + crs.alteraFuncionario(index, "igor", "1", "1", "1", "1", "1", "1", "1", "1", "1"));
		System.out.println("Imprime nome atualizado            : " + crs.buscaFuncionario(index).getNome());
		System.out.println("remove funcionario                 : " + crs.removeFuncionario(index));
		System.out.println("Imprime func removido              : " + crs.buscaFuncionario(index));
		System.out.println();
		
    	
		
		
		
		
		ControleAnimal ca = new ControleAnimal();
		
		System.out.println("Adiciona animal               :" + ca.adicionaAnimal("martinezCotoco", 2157850, "1012-10-10 00:00:00", 2, 2457, "M", "azul"));
		System.out.println("Busca animal adicionado       :" + ca.buscaAnimal(index).getNome());
		System.out.println("Edita animal                  :"+ ca.alteraAnimal(index, "martinez alterado", 2157850, "1012-10-10 00:00:00", 2, 2457, "M", "azul"));
		System.out.println("Busca animal editado          :" + ca.buscaAnimal(index).getNome());
		System.out.println("Remove animal                 :" + ca.removeAnimal(index));
		System.out.println("Busca animal removido         :" + ca.buscaAnimal(index));
		
		
    	
//    	System.out.println(c.buscaFuncionario(10));
//    	System.out.println(ca.removeAnimal(2));
//    	System.out.println(ca.buscaAnimal(2));
    	
//    	System.out.println(ca.alteraAnimal(, "martinezCotoco", 2157850, "1012-10-10 00:00:00", 2, 2457, "M", "azul"));
//    	System.out.println(ca.buscaAnimal(2).getNome());
    	
    	
		
	}

}
