package database;
import java.sql.*;


public class ConnectDB {
	private static Connection con;
	
	public ConnectDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String dbURL = "jdbc:mysql://localhost/db_library?characterEncoding=utf-8";
			
				con = DriverManager.getConnection(dbURL,"root","");
				System.out.println("Connect DB ok");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static Connection getCon() {
		return con;
	}

	public static void setCon(Connection con) {
		ConnectDB.con = con;
	}
	
	public void closeConnect() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
