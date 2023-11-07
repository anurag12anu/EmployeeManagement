package EmployeM2Packege;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcClass {
	Connection con=null;
	
	public JdbcClass() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch(ClassNotFoundException e) {
			System.out.println(e);
		}
		try {
		con =DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagement?user=root&password=Rewa@123");
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

public boolean check(String user,String pass)
{
	boolean isvalids=false;
	try
	{
		PreparedStatement ps = con.prepareStatement("select * from login where username = ? and password = ?");
		ps.setString(1, user);
		ps.setString(2, pass);
		ResultSet rs = ps.executeQuery();
		if(rs.next()==true)
		{
			isvalids=true;
		}
		else
		{
			isvalids=false;
		}
	}
	catch(SQLException e)
	{
		
	}
	return isvalids;
}
	public static void main(String[] args) {
		JdbcClass j=new JdbcClass();
	}
}

