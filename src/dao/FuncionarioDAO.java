package dao;

import modelo.Funcionario;
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
    public Funcionario recuperar(String cpfFuncionario) throws SQLException, ClassNotFoundException, NaoEncontradoExeception {

        Funcionario funcionario = null;
        sql.append("SELECT * ");
        sql.append("FROM funcionarios");
        sql.append("WHERE cpf =  ?");

        try {

            //Cria instancia da conexão (usando singleton)
            //Executa query com o sql escrito acima
            conn = getInstance();
            PreparedStatement ps = conn.prepareStatement(sql.toString());
            ps.setString(1, cpfFuncionario);
            rs = ps.executeQuery();

            funcionario = new Funcionario();
            
            while(rs.next())
            {
            	funcionario.setNome(rs.getString("nome"));
            	funcionario.setCidade(rs.getString("cidade"));
            	funcionario.setCpf(rs.getString("cpf"));
            	funcionario.setEmail(rs.getString("email"));
            	funcionario.setDataHora(rs.getString("datahora"));
            	funcionario.setEstado(rs.getString("estado"));
            	funcionario.setSexo(rs.getString("sexo"));
            	funcionario.setEndereco(rs.getString("endereco"));
            	funcionario.setId(rs.getInt("id"));
            	funcionario.setTelefoneCelular(rs.getString("telefonecelular"));
            	funcionario.setTelefoneResidencial(rs.getString("telefoneresidencial"));
            }
            

            //Se não houver resultados na query
            if (funcionario == null) {
                throw new NaoEncontradoExeception("Funcionario não encontrado");
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
        sql.append("INSERT INTO funcionarios");
        sql.append("(nome, endereco, cidade, estado, telefone_residencial, telefone_celular, email, cpf, tipo_permissao) ");
        sql.append
                ("VALUES ("+
                "'" +funcionario.getNome()+ "'" + ", " +
                "'" +funcionario.getEndereco()+ "'" + ", " +
                "'" +funcionario.getCidade()+"'" + ", " +
                "'" +funcionario.getEstado()+"'" + ", " +
                "'" +funcionario.getTelefone_residencial() +"'"+ ", " +
                "'" +funcionario.getTelefone_celular() +"'"+
                "'" +funcionario.getEmail()+"'" + ", " +
                "'" +funcionario.getCpf()+"'" + ", " +
                "'" +funcionario.getTipo_permissao()+"'" +
                ");"
                );

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
