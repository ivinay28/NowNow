package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.github.dockerjava.api.model.Driver;

public class Creating {

	public static void main(String[] args) throws Throwable 
	{
	//step1 : register driver
		Driver driverref = new Driver();
		DriverManager.registerDriver((java.sql.Driver) driverref);
		
	//step2 : connection to database
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/vinay","root","root");

	//step3 : create sql statement
		Statement stat = conn.createStatement();
		String query = "select * from student";
		
	//step4 : Execeute query
		ResultSet result = stat.executeQuery(query);
		
		while(result.next())
		{
			System.out.println(result.getInt(1)+"\t"+result.getString(2)+"\t"+result.getString(3));
		}
		
	//close database connection
		conn.close();
	}

}
