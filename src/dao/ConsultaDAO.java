package dao;

import modelo.Consulta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class ConsultaDAO extends DAO {

    static Connection conn = null;
    static ResultSet rs = null;
    static StringBuilder sql = new StringBuilder();

    private static boolean executeBooleanQuery(final StringBuilder sql) throws SQLException {
        try {
            conn = getInstance();
            final PreparedStatement ps = conn.prepareStatement(sql.toString());
            rs = ps.executeQuery();
        }  catch (final Exception e) {
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

    public static boolean cadastrar(Consulta consulta) throws SQLException {
        sql.append("INSERT INTO consultas ");
        sql.append("(tipo, data_hora, id_animal, forma_pagamento, id_veterinario) ");
        sql.append("VALUES ("+
                "'"+consulta.getTipo()+ "'" + ", " +
                "'"+consulta.getDataHora()+"'" + ", " +
                "'"+consulta.getIdAnimal()+"'" + ", " +
                "'"+consulta.getPagamentoForma()+"'" + ", " +
                "'"+consulta.getIdVeterinario()+"'" +
                ");");

        System.out.println(sql);
        return executeBooleanQuery(sql);
    }

}
