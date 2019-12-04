package modelo;

public class Raca {

    private String descricao;
    private int ID;


    public Raca() {
		// TODO Auto-generated constructor stub
	}

    public Raca(int ID, String descricao) {
        this.descricao = descricao;
        this.ID = ID;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getID() {
        return this.ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

}
