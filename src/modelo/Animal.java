package modelo;

public class Animal {

    private String nome;
    private String sexo;
    private String cor;
    private String raca;
    private int id;
	private int donoId;

    public Animal(String nome, String sexo, String cor, String raca, int donoId) {
        this.nome = nome;
        this.sexo = sexo;
        this.cor = cor;
        this.raca = raca;
        this.donoId = donoId;
	}
	
	public int getDonoId() {
		return donoId;
	}

	public void setDonoId(int donoId) {
		this.donoId = donoId;
	}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
	
	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }
}
