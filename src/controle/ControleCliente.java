package controle;

import java.sql.ResultSet;
import java.sql.SQLException;

import dao.ClienteDAO;
import dao.NaoEncontradoExeception;
import modelo.Cliente;

public class ControleCliente {


    public boolean IncluiCliente(String CPF, String Nome, String Endereço, String Cidade, String Estado, String Telefone, String Documento, String Email) {
        Cliente cliente = new Cliente(CPF, Nome, Endereço, Cidade, Estado, Telefone, Documento, Email);

        try {
			if (ClienteDAO.cadastrar(cliente)) {
			    return true;
			} else {
			    return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return false;
		}
    }

    public boolean AlteraCliente(String CPF, String Nome, String Endereço, String Cidade, String Estado, String Telefone, String Documento, String Email) {
        Cliente cliente = new Cliente(CPF, Nome, Endereço, Cidade, Estado, Telefone, Documento, Email);

        try {
			if (ClienteDAO.alterar(cliente)) {
			    return true;
			} else {
			    return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return false;
		}
    }

    public boolean RemoveCliente(String CPF) {
        try {
			if (ClienteDAO.remover(CPF)) {
			    return true;
			} else {
			    return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return false;
		}
    }

    public Cliente busca(String CPF) {
        
        Cliente cliente = null;
        ResultSet rs;
		try {
			rs = ClienteDAO.recuperar(CPF);
	        while (rs.next()) {
	            cliente = new Cliente(rs.getString("CPF"), rs.getString("Nome"), 
	            rs.getString("Endereço"), rs.getString("Cidade"), rs.getString("Estado"), 
	            rs.getString("Telefone"), rs.getString("Documento"), rs.getString("Email"));
	        }
	        
		} catch (ClassNotFoundException | SQLException | NaoEncontradoExeception e) {
			// TODO Auto-generated catch block
			return null;
		}

			
            // Se não houver resultados na query
            if (cliente == null) {
                return null;
            }
            return cliente;
    }
}
    
