package modelo;

import java.sql.Timestamp;

public class Administrador extends Funcionario {

    public Administrador(String nome, char sexo, String endereco, String cidade, String estado, String telefoneResidencial, String telefoneCelular, String email, Timestamp dataDeHoje, int id, String cpf) {
    	super(nome, sexo, endereco, cidade, estado, telefoneResidencial, telefoneCelular, email, dataDeHoje, id, cpf);
    }

    public void removerFuncionario(int id) {
        //TODO: implementar
    }

    public void adicionarFuncionario(int id) {
       //TODO: implementar
    }

    public void alterarFuncionario(int id) {
        //TODO: implementar
    }

}
