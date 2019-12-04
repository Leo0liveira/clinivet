package controle;

import dao.ClienteDAO;
import modelo.Cliente;

public class ControleCliente {

    ClienteDAO clienteDAO = new ClienteDAO();

    public boolean IncluiCliente(String CPF, String Nome, String Endereço, String Cidade, String Estado, String Telefone, String Documento, String Email)
    {
        Cliente cliente = new Cliente(CPF, Nome, Endereço, Cidade, Estado, Telefone, Documento, Email);

        if(clienteDAO.cadastrar(cliente))
        {
            System.out.println("Cadastrado com sucesso"); //mensagem de sucesso pra view
        }
        else 
        {
            System.out.println("Erro ao cadastrar"); //mensagem de erro pra view
        }
    }

    public boolean alteraCliente(int codigo, String nome, int proprietario, String nascimento, int especie, int raca, String sexo, String cor)
    {
        Cliente cliente = new Cliente(codigo, nome, proprietario, nascimento, especie, raca, sexo, cor);

        if(clienteDAO.alterar(cliente))
        {
            System.out.println("Alterado com sucesso"); //mensagem de sucesso pra view
        }
        else 
        {
            System.out.println("Erro ao alterar"); //mensagem de erro pra view
        }
    }

    public boolean removeCliente(int codigo)
    {
        if(clienteDAO.remover(codigo)) 
        {
            System.out.println("Removido com sucesso"); //mensagem de sucesso pra view
        } 
        else
        {
            System.out.println("Erro ao remover"); //mensagem de erro pra view
        }
    }

    public Cliente buscaCliente(int codigo)
    {
        return clienteDAO.recuperar(codigo);
    }
}
