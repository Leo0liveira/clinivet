package modelo;

public class Animal {

    private int codigo;
    private String nome;
    private int proprietario;
    private String nascimento;
    private int especie;
    private int raca;
    private String sexo;
    private String cor;

    public Animal(int codigo, String nome, int proprietario, String nascimento, int especie, int raca, String sexo, String cor) {
        this.codigo = codigo;
        this.nome = nome;
        this.proprietario = proprietario;
        this.nascimento = nascimento;
        this.especie = especie;
        this.raca = raca;
        this.sexo = sexo;
        this.cor = cor;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getProprietario() {
        return proprietario;
    }

    public void setProprietario(int proprietario) {
        this.proprietario = proprietario;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public int getEspecie() {
        return especie;
    }

    public void setEspecie(int especie) {
        this.especie = especie;
    }

    public int getRaca() {
        return raca;
    }

    public void setRaca(int raca) {
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
