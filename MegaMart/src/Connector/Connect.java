package Connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class Connect 
{
	public static Connection Mega()throws SQLException
	{
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		
		String url="jdbc:mysql://localhost:3306/megamart";
		String user="root";
		String password="";
		
		Connection con=DriverManager.getConnection(url,user,password);
		return con;
	}
}
