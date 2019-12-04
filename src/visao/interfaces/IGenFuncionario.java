package visao.interfaces;

import modelo.Funcionario;

public interface IGenFuncionario {
    public void setFuncionario (String nome, char sexo, String endereco, String cidade, String estado, String telefoneResidencial, String telefoneCelular, String email, int dataHora, int id, String cpf);
    public Funcionario getFuncionario (String nome);
}
