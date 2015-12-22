package cn.edu.bjtu.sad.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtilFactory extends DBUtilAbstractFactory{

	private Connection conn;
	
	public Connection getMysqlConn() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3306/outpatient?useUnicode=true&amp;characterEncoding=UTF-8";
            String username = "root";
            String password = "";
            conn = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return conn;
	}

	@Override
	public Connection getOracleConn() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Connection getDB2Conn() {
		// TODO Auto-generated method stub
		return null;
	}
}
