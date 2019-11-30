package visao.interfaces;

import modelo.Cliente;

public interface IClienteCRUD {

    public boolean IncluiCliente(String CPF, String Nome, String Endereço, String Cidade, String Estado, String Telefone, String Documento, String Email);

    public boolean AlteraCliente(String CPF, String Nome, String Endereço, String Cidade, String Estado, String Telefone, String Documento, String Email);

    public boolean RemoveCliente(String CPF);

    public Cliente busca(String CPF);


}
