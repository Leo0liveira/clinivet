package dao;

import modelo.Funcionario;
import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class FuncionarioDAO extends DAO {

    static Connection conn = null;
    static ResultSet rs = null;
    static StringBuilder sql = new StringBuilder();

    /*
     * executeBooleanQuery: retorna true se a operacao for realizada com sucesso, false caso contrario.
     * @param sql StringBuilder
     * @return
     * */
    private static boolean executeBooleanQuery(StringBuilder sql) throws SQLException {
        try {
            conn = getInstance();
            PreparedStatement ps = conn.prepareStatement(sql.toString());
            rs = ps.executeQuery();
        }  catch (Exception e) {
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
    * @param cpfFuncionario String
    * @return
    * */
    @Override
    public String recuperar(String cpfFuncionario) throws SQLException {

        String funcionario = null;
        sql.append("SELECT * ");
        sql.append("FROM funcionarios");
        sql.append("WHERE cpf =  " + cpfFuncionario);

        try {

            //Cria instancia da conexão (usando singleton)
            //Executa query com o sql escrito acima
            conn = getInstance();
            PreparedStatement ps = conn.prepareStatement(sql.toString());
            ps.setString(1, cpfFuncionario);
            rs = ps.executeQuery();

            funcionario = rs.getString(1);

            //Se não houver resultados na query
            if (funcionario == null) {
                funcionario = "Funcionario nao cadastrado.";
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
        return funcionario;
    }

    /*
     * cadastraFuncionario: insere um usuario no banco de dados.
     * @param funcionario Funcionario
     * @return
     * */
    @Override
    public boolean cadastrar(@NotNull Funcionario funcionario) throws SQLException {

        sql.append("INSERT INTO funcionarios");
        sql.append
                ("VALUES ("+
                funcionario.getId() + ", " +
                funcionario.getNome() + ", " +
                funcionario.getCpf() + ", " +
                funcionario.getEmail() + ", " +
                funcionario.getEndereco() + ", " +
                funcionario.getSexo() + ", " +
                funcionario.getTelefoneResidencial() + ", " +
                funcionario.getTelefoneCelular() + ", " +
                ")");

        return executeBooleanQuery(sql);
    }

    /*
     * alteraFuncionario: altera um campo de um determinado funcionario.
     * @param String cpfFuncionario
     * @param String coluna
     * @param String novoValor
     * @return
     * */
    @Override
    public boolean alterar(String cpfFuncionario, String coluna, String novoValor) throws SQLException {

        sql.append("UPDATE funcionarios ");
        sql.append("SET " + coluna + " = " + novoValor);
        sql.append("WHERE cpf = " + cpfFuncionario);

        return executeBooleanQuery(sql);
    }

    /*
     * removeFuncionario: remove funcionario do banco de dados.
     * @param String cpfFuncionario
     * @return
     * */
    @Override
    public boolean remover(String cpfFuncionario) throws SQLException {

        String funcionario = null;
        sql.append("DELETE FROM funcionarios ");
        sql.append("WHERE cpf = " + cpfFuncionario);

        return executeBooleanQuery(sql);

    }

}
