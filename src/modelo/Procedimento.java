package modelo;

import java.sql.Date;

public class Procedimento {

    private String descricao;
    private Double preco;
    private int codigo;

    public Procedimento(String descricao, Date dataHora, int codigo) {
        this.descricao = descricao;
        this.preco = preco;
        this.codigo= codigo;
    }
    
    public Procedimento(){
    }

    public Procedimento(String descricao) {
    }

    public Procedimento(int codigo, String descricao, double preco) {
    	this.codigo = codigo;
    	this.descricao = descricao;
    	this.preco = preco;
    }


    public String getTipo() {
        return descricao;
    }

    public void setTipo(String descricao) {
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo =codigo;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}
