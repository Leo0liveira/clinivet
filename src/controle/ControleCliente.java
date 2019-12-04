package controle;

import dao.ClienteDAO;
import modelo.Cliente;

public class ControleCliente {

    ClienteDAO clienteDAO = new ClienteDAO();

    public boolean IncluiCliente(String CPF, String Nome, String Endereço, String Cidade, String Estado,
            String Telefone, String Documento, String Email) {
        Cliente cliente = new Cliente(CPF, Nome, Endereço, Cidade, Estado, Telefone, Documento, Email);

        if (clienteDAO.cadastrar(cliente)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean AlteraCliente(String CPF, String Nome, String Endereço, String Cidade, String Estado, String Telefone, String Documento, String Email) {
        Cliente cliente = new Cliente(CPF, Nome, Endereço, Cidade, Estado, Telefone, Documento, Email);

        if (clienteDAO.alterar(cliente)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean RemoveCliente(String CPF) {
        if (clienteDAO.remover(CPF)) {
            return true;
        } else {
            return false;
        }
    }

    public Cliente busca(String CPF) {
        
        Cliente cliente = null;
        ResultSet rs = clienteDAO.recuperar(CPF);

        while (rs.next()) {
            cliente = new Cliente(rs.getString("CPF"), rs.getString("Nome"), 
            rs.getString("Endereço"), rs.getString("Cidade"), rs.getString("Estado"), 
            rs.getString("Telefone"), rs.getString("Documento"), rs.getString("Email"));
        }

        try {
            // Se não houver resultados na query
            if (cliente == null) {
                throw new NaoEncontradoExeception("Cliente nao cadastrado.");
            }
            // Fecha conexão
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

        return cliente;
    }
}
