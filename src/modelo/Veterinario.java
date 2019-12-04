package modelo;

public class Veterinario extends Funcionario {
	private int crmv;

	public Veterinario(int matricula, String nome, String endereco, String cidade, String estado,
			String telefone_residencial, String telefone_celular, String email, String data_contratacao, String cpf, int crmv,
			String tipo_permissao) {
		super(matricula, nome, endereco, cidade, estado, telefone_residencial, telefone_celular, email, data_contratacao, cpf,
				tipo_permissao);
		this.crmv = crmv;
		// TODO Auto-generated constructor stub
	}

	public int getCrmv() {
		return crmv;
	}

	public void setCrmv(int crmv) {
		this.crmv = crmv;
	}

   


}
