package com.Server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertDetails {
	public static int insert(Employee e) {
		int a=0;
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet","root","Aravind");
		PreparedStatement pst = con.prepareStatement("insert into employeedetails value(?,?,?)");
		pst.setString(1, e.getName());
		pst.setInt(2, e.getId());
		pst.setInt(3, e.getSalary());
	   a = pst.executeUpdate();
		pst.close();
		con.close();
		
				
	}
	catch(Exception e1) {
		//Throwable e1;
		e1.printStackTrace();
		
	}
	return a;
	}
}
