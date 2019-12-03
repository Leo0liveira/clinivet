package modelo;

public class Procedimento {

    private String tipo;
    private int dataHora;
    private int id;

    public Procedimento(String tipo) {
        this.tipo = tipo;

    }


    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
