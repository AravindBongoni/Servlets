package com.Server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class InsertStudentDetails {
	public static int insert(Student s) {
		int a=0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/aravind","root","Aravind");
			String q = "insert into student values (?,?,?)";
			PreparedStatement pst = con.prepareStatement(q);
			pst.setString(1, s.getName());
			pst.setString(2, s.getEmail());
			pst.setString(3, s.getpassword());
			a =pst.executeUpdate();
			con.close();
			pst.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}

	

}
