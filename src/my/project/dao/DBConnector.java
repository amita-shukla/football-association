package my.project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {

	private static Connection con;
	public static Connection getConnection()
	{
		String DRIVER="com.mysql.jdbc.Driver";
		String DBURL="jdbc:mysql://localhost:3306/ifa_project"; //Connection parameters
		String DBUSER="root";
		String DBPASSWORD="";
		try {
			Class.forName(DRIVER);
			con=DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD);
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}
