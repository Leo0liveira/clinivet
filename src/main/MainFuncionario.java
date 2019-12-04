package main;

import controle.ControleFuncionario;

public class MainFuncionario {
	public static void main(String[] args) {
		ControleFuncionario c = new ControleFuncionario();
		
		c.adicionaFuncionario(nome, endereco, cidade, estado, telefone_residencial, telefone_celular, email, data_contratacao, cpf, tipo_permissao, password)
		c.buscaFuncionario(matricula);
		c.alteraFuncionario(matricula, nome, endereco, cidade, estado, telefone_residencial, telefone_celular, email, data_contratacao, cpf, tipo_permissao);
		c.buscaFuncionario(matricula);
		c.removeFuncionario(matricula)
		c.buscaFuncionario(matricula);
	}

}
