package dao;

import modelo.Pagamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class PagamentoDAO extends DAO {

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
        } 
        finally {
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
    public String recuperar(int id) throws SQLException, ClassNotFoundException {

        sql.append("SELECT * ");
        sql.append("FROM funcionarios");
        sql.append("WHERE cpf =  " + id);

        try {

            //Cria instancia da conexão (usando singleton)
            //Executa query com o sql escrito acima
            conn = getInstance();
            PreparedStatement ps = conn.prepareStatement(sql.toString());
            ps.setInt(1, id);
            rs = ps.executeQuery();

            Pagamento pagamento = new Pagamento(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getInt(3),
                    rs.getInt(4),
                    rs.getInt(5),
                    rs.getInt(6),
                    rs.getInt(7),
                    rs.getInt(8),
                    rs.getInt(9)
                );

            //Se não houver resultados na query
            if (pagamento == null) {
                pagamento = "pagamento nao cadastrado.";
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
    public static boolean cadastrar(Funcionario funcionario) throws SQLException{
        sql.append("INSERT INTO funcionario");
        sql.append("(id, nome, cpf, email, endereco, sexo, telefoneResidencial, telefoneCelular) ");
        sql.append
                ("VALUES ("+
                funcionario.getId() + ", " +
                "'" +funcionario.getNome()+ "'" + ", " +
                "'"+  funcionario.getCpf()+"'" + ", " +
                "'"+funcionario.getEmail()+"'" + ", " +
                "'"+funcionario.getEndereco()+"'" + ", " +
                "'"+ funcionario.getSexo() +"'"+ ", " +
                "'"+funcionario.getTelefoneResidencial()+"'" + ", " +
                "'"+funcionario.getTelefoneCelular() +"'"+
                ");");

        System.out.println(sql);
        return executeBooleanQuery(sql);
    }

    /*
     * alteraFuncionario: altera um campo de um determinado funcionario.
     * @param String cpfFuncionario
     * @param String coluna
     * @param String novoValor
     * @return
     * */
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
    public boolean remover(String cpfFuncionario) throws SQLException {

        String funcionario = null;
        sql.append("DELETE FROM funcionarios ");
        sql.append("WHERE cpf = " + cpfFuncionario);

        return executeBooleanQuery(sql);

    }

}
