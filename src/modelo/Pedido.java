package modelo;

public class Pedido {

    private String tipo;
    private int dataHora;

    public Pedido(String tipo, int dataHora) {
        this.tipo = tipo;
        this.dataHora = dataHora;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getDataHora() {
        return dataHora;
    }

    public void setDataHora(int dataHora) {
        this.dataHora = dataHora;
    }
}
