package modelo;


public class Funcionario {

	private int matricula;
    private String nome;
    private String sexo;
    private String endereco;
    private String cidade;
    private String estado;
    private String telefone_residencial;
    private String telefone_celular;
    private String email;
    private String data_contratacao;
    private String tipo_permissao;
    private String cpf;

    public Funcionario(int matricula, String nome, String sexo, String endereco, String cidade, 
    		String estado, String telefone_residencial, String telefone_celular, 
    		String email, String data_contratacao, String cpf, String tipo_permissao) {
    	
    	this.matricula = matricula;
        this.nome = nome;
        this.sexo = sexo;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
        this.telefone_residencial = telefone_residencial;
        this.telefone_celular = telefone_celular;
        this.email = email;
        this.data_contratacao = data_contratacao;
        this.tipo_permissao = tipo_permissao;
        this.cpf = cpf;
    }

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getTelefone_residencial() {
		return telefone_residencial;
	}

	public void setTelefone_residencial(String telefone_residencial) {
		this.telefone_residencial = telefone_residencial;
	}

	public String getTelefone_celular() {
		return telefone_celular;
	}

	public void setTelefone_celular(String telefone_celular) {
		this.telefone_celular = telefone_celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getData_contratacao() {
		return data_contratacao;
	}

	public void setData_contratacao(String data_contratacao) {
		this.data_contratacao = data_contratacao;
	}

	public String getTipo_permissao() {
		return tipo_permissao;
	}

	public void setTipo_permissao(String tipo_permissao) {
		this.tipo_permissao = tipo_permissao;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


}
