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
    public Pagamento recuperar(int id) throws SQLException, ClassNotFoundException, NaoEncontradoExeception {
    	Pagamento pagamento = null;
        sql.append("SELECT * ");
        sql.append("FROM pagamento");
        sql.append("WHERE id =  " + id);

        try {
            //Cria instancia da conexão (usando singleton)
            //Executa query com o sql escrito acima
            conn = getInstance();
            PreparedStatement ps = conn.prepareStatement(sql.toString());
            ps.setInt(1, id);
            rs = ps.executeQuery();

            pagamento = new Pagamento(
                    rs.getString(1),
                    rs.getDouble(3),
                    rs.getString(2)
                );

            //Se não houver resultados na query
            if (pagamento == null) {
                throw new NaoEncontradoExeception("Pagamento não encontrado");
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
        return pagamento;
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
