package controle;

import java.sql.ResultSet;
import java.sql.SQLException;

import dao.ClienteDAO;
import dao.NaoEncontradoExeception;
import modelo.Cliente;

public class ControleCliente {


    public boolean IncluiCliente(int CPF, String Nome, String Endereco, String Cidade, String Estado, String Telefone, int Documento, String Email) {
        Cliente cliente = new Cliente(CPF, Nome, Endereco, Cidade, Estado, Telefone, Documento, Email);

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

    public boolean AlteraCliente(int CPF, String Nome, String Endereco, String Cidade, String Estado, String Telefone, int Documento, String Email) {
        Cliente cliente = new Cliente(CPF, Nome, Endereco, Cidade, Estado, Telefone, Documento, Email);

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

    public boolean RemoveCliente(int CPF) {
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

    public Cliente busca(int CPF) {
        
        Cliente cliente = null;
        ResultSet rs;
		try {
			rs = ClienteDAO.recuperar(CPF);
	        while (rs.next()) {
	            cliente = new Cliente(rs.getInt("cpf"), rs.getString("nome"), 
	            rs.getString("endereco"), rs.getString("cidade"), rs.getString("estado"), 
	            rs.getString("telefone"), rs.getInt("documento"), rs.getString("email"));
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
    
