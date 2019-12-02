package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexaoBD {
	private static String user = "postgres";
	private static String password = "postgres";
	private static String host = "jdbc:postgresql://localhost:5432/clinivet";
	public static String driver = "org.postgresql.Driver";
	public Statement stetement;
	public ResultSet result;
	public static Connection conn = null;
	
	protected static Connection conecta() {
		
	    try {
			Class.forName(driver);
			System.out.println("teste");
		    conn = DriverManager.getConnection(host, user, password);
	        return conn;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;

	}

}
