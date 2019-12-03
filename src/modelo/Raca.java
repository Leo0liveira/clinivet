package modelo;

public class Raca {

    private String nome;
    private String descricao;

    public Raca(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public Raca() {
		// TODO Auto-generated constructor stub
	}

	public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
