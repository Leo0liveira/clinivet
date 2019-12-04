package modelo;

public class Raca {

    private String descricao;
    private int ID;

    public Raca(int ID, String descricao) {
        this.ID = ID; 
        this.descricao = descricao;
    }

    public Raca() {
		// TODO Auto-generated constructor stub
	}

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getID() {
        return ID;
    }

    public void setDescricao(int ID) {
        this.ID = ID;
    }
}
