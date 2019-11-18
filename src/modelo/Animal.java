package modelo;

public class Animal {

    private String nome;
    private char sexo;
    private String cor;
    private int id;

    public Animal(String nome, char sexo, String cor, int id) {
        this.nome = nome;
        this.sexo = sexo;
        this.cor = cor;
        this.id = id;
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

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }
}
