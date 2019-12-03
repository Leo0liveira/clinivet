package modelo;

public class Procedimento {

    private String tipo;
    private int dataHora;
    private int id;

    public Procedimento(String tipo, int dataHora, int id) {
        this.tipo = tipo;
        this.dataHora = dataHora;
        this.id = id;
    }
    
    public Procedimento()
    {
    }

    public Procedimento(String tipo) {
    }

    public Procedimento(String pagante, double valor, String tipo) {

    }


    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDataHora() {
        return dataHora;
    }

    public void setDataHora(int dataHora) {
        this.dataHora = dataHora;
    }
}
