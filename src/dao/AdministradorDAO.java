package dao;

import modelo.Administrador;
import modelo.Funcionario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class AdministradorDAO extends DAO {

	static Connection conn = null;
	static ResultSet rs = null;
	static StringBuilder sql = new StringBuilder();

	/*
	 * executeBooleanQuery: retorna true se a operacao for realizada com sucesso,
	 * false caso contrario.
	 *
	 * @param sql StringBuilder
	 *
	 * @return
	 */
	private static boolean executeBooleanQuery(StringBuilder sql) throws SQLException {
		try {
			conn = getInstance();
			PreparedStatement ps = conn.prepareStatement(sql.toString());
			rs = ps.executeQuery();
		} catch (Exception e) {
			return false;
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		return true;
	}

	/*
	 * recuperaFuncionario: retorna funcioario com id requerido.
	 *
	 * @param cpfFuncionario String
	 *
	 * @return
	 */
	public Funcionario recuperar(String cpfAdmin) throws SQLException, ClassNotFoundException, NaoEncontradoExeception {

		Funcionario administrador = null;
		sql.append("SELECT * ");
		sql.append("FROM administradores");
		sql.append("WHERE cpf =  ?");

		try {

			//Cria instancia da conexão (usando singleton)
			//Executa query com o sql escrito acima
			conn = getInstance();
			PreparedStatement ps = conn.prepareStatement(sql.toString());
			ps.setString(1, cpfAdmin);
			rs = ps.executeQuery();

			administrador = new Funcionario();

			while (rs.next()) {
				administrador.setNome(rs.getString("nome"));
				administrador.setCidade(rs.getString("cidade"));
				administrador.setCpf(rs.getString("cpf"));
				administrador.setEmail(rs.getString("email"));
				administrador.setData_contratacao(rs.getString("datahora"));
				administrador.setEstado(rs.getString("estado"));
				administrador.setEndereco(rs.getString("endereco"));
				administrador.setMatricula(rs.getInt("id"));
				administrador.setTelefone_celular(rs.getString("telefonecelular"));
				administrador.setTelefone_residencial(rs.getString("telefoneresidencial"));
			}
			

			//Se não houver resultados na query
			if (administrador == null) {
				throw new NaoEncontradoExeception("Administraor n�o encontrado");
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
		return administrador;
	}

	/*
	 * cadastraFuncionario: insere um usuario no banco de dados.
	 *
	 * @param funcionario Funcionario
	 *
	 * @return
	 */
	public static boolean cadastrar(Funcionario funcionario) throws SQLException {
		sql.append("INSERT INTO administradores");
		sql.append("(nome, sexo, endereco, cidade, estado, telefoneResidencial, telefoneCelular, email, cpf) ");
		sql.append
				("VALUES (" +
						"'" + funcionario.getNome() + "'" + ", " +
						"'" + funcionario.getEndereco() + "'" + ", " +
						"'" + funcionario.getCidade() + "'" + ", " +
						"'" + funcionario.getEstado() + "'" + ", " +
						"'" + funcionario.getTelefone_residencial() + "'" + ", " +
						"'" + funcionario.getTelefone_celular() + "'" +
						"'" + funcionario.getEmail() + "'" + ", " +
						"'" + funcionario.getCpf() + "'" +
						");");
		return executeBooleanQuery(sql);
	}

	/*
	 * alteraFuncionario: altera um campo de um determinado funcionario.
	 *
	 * @param String cpfFuncionario
	 *
	 * @param String coluna
	 *
	 * @param String novoValor
	 *
	 * @return
	 */
	public boolean alterar(String cpfFuncionario, String coluna, String novoValor) throws SQLException {

		sql.append("UPDATE funcionarios ");
		sql.append("SET " + coluna + " = " + novoValor);
		sql.append("WHERE cpf = " + cpfFuncionario);

		return executeBooleanQuery(sql);
	}

	/*
	 * removeFuncionario: remove funcionario do banco de dados.
	 *
	 * @param String cpfFuncionario
	 *
	 * @return
	 */
	public boolean remover(String cpfFuncionario) throws SQLException {

		String funcionario = null;
		sql.append("DELETE FROM funcionarios ");
		sql.append("WHERE cpf = " + cpfFuncionario);

		return executeBooleanQuery(sql);

	}
}
