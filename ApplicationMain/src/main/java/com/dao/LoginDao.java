package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.model.LoginModel;

public class LoginDao {
	public String LoginCheck(LoginModel ml) {	
		String status="fail";
		String role=ml.getRool();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mahendra","root","root");
			PreparedStatement ps = con.prepareStatement("select*from admin01 where mail=? and Password=?");
			ps.setString(1, ml.getMail());
			ps.setString(2, ml.getPassword());
			System.out.println(ml.getMail());
			System.out.println(ml.getPassword());

			ResultSet n=ps.executeQuery();
			while(n.next()){
				status="succes";
				System.out.println("Verified ");
			}
			
			
		}catch(Exception e) {
			System.out.println(e);
	
		}
		return status;
	}
	

}
