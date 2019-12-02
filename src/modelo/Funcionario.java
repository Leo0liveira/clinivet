package modelo;

import java.sql.Timestamp;

public class Funcionario {

    private String nome;
    private char sexo;
    private String endereco;
    private String cidade;
    private String estado;
    private String telefoneResidencial;
    private String telefoneCelular;
    private String email;
    private Timestamp dataHora;
    private int id;
    private String cpf;

    public Funcionario(String nome, char sexo, String endereco, String cidade, String estado, String telefoneResidencial, String telefoneCelular, String email, Timestamp dataDeHoje, int id, String cpf) {
        this.nome = nome;
        this.sexo = sexo;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
        this.telefoneResidencial = telefoneResidencial;
        this.telefoneCelular = telefoneCelular;
        this.email = email;
        this.dataHora = dataDeHoje;
        this.id = id;
        this.cpf = cpf;
    }

    public Funcionario() {
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTelefoneResidencial() {
        return telefoneResidencial;
    }

    public void setTelefoneResidencial(String telefoneResidencial) {
        this.telefoneResidencial = telefoneResidencial;
    }

    public String getTelefoneCelular() {
        return telefoneCelular;
    }

    public void setTelefoneCelular(String telefoneCelular) {
        this.telefoneCelular = telefoneCelular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getDataHora() {
        return dataHora;
    }

    public void setDataHora(int dataHora) {
        this.dataHora = dataHora;
    }
}
