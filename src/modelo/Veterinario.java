package modelo;

public class Veterinario extends Funcionario {

    public Veterinario(String nome, String sexo, String endereco, String cidade, String estado, String telefoneResidencial,
                       String telefoneCelular, String email, String dataHora, int id, String cpf) {
        super(id, sexo, endereco, cidade, estado, telefoneResidencial, telefoneCelular, email, dataHora, nome, cpf);
    }


}
