package modelo;

import java.sql.Date;

public class Procedimento {

    private String tipo;
    private Date dataHora;
    private int id;

    public Procedimento(String tipo, Date dataHora, int id) {
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

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }
}
