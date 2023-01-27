package utility;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class JdbcUtil {
	

	public static Connection getJdbcConnection() throws IOException, SQLException {
		
		FileInputStream fis = new FileInputStream("src\\Properties\\application.properties");
		Properties properties  = new Properties();
		properties.load(fis);
		
		//connection
		Connection connection = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("user"), 
				properties.getProperty("password"));	
		System.out.println("Connection object created...");
		return connection;
		
	}
	
	public static void cleanUp(Connection connection,Statement statement,ResultSet resultSet) throws SQLException
	{
		if(connection !=null)
			connection.close();
		if(statement !=null)
			statement.close();
		if(resultSet !=null)
			resultSet.close();
	}

}
