package DAO01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Modal.Faculty;
import Modal.MODAL;
import Modal.ModalLogin;
import Modal.StudentDitailsModal;

public class Dao02 {
	public String insertData(MODAL ml) {
		System.out.println(ml.getCourseName());
		String status = "fild";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mahendra", "root", "root");
			PreparedStatement ps = con
					.prepareStatement("insert into course01 (CourseName,CoursedDuration,CourseFee) values (?,?,?)");
			ps.setString(1, ml.getCourseName());
			ps.setString(2, ml.getCoursedDuration());
			ps.setInt(3, ml.getCourseFees());
			int n = ps.executeUpdate();
			if (n > 0) {
				status = "succes";
			}

		} catch (Exception e) {
			System.out.println(e);

		}
		return status;

	}

	// only login code

	public String LoginData(ModalLogin ml) {
		String status = "fild";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mahendra", "root", "root");
			PreparedStatement ps = con.prepareStatement("select*from Admin01 where mail=? and password =?");
			ps.setString(1, ml.getMail());
			ps.setString(2, ml.getPassword());
			ResultSet n = ps.executeQuery();
			while (n.next()) {
				status = "succes";
			}

		} catch (Exception e) {
			System.out.println(e);

		}
		return status;

	}

	public String StudentData(StudentDitailsModal sdm) {
		String status = "fild";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mahendra", "root", "root");
			PreparedStatement ps = con.prepareStatement(
					"insert into (FirstName,LastName,FatherName,MotherName,StudentSubject,Adresh,Mail,PhoneNumber,Alternate,cid)student01 values (?,?,?,?,?,?,?,?,?,?)");

			ps.setString(1, sdm.getFirstName());
			ps.setString(2, sdm.getLastName());
			ps.setString(3, sdm.getFatherName());

			ps.setString(4, sdm.getMotherName());

			ps.setString(5, sdm.getStudentSubject());

			ps.setString(6, sdm.getAdresh());

			ps.setString(7, sdm.getMail());

			ps.setString(8, sdm.getPhoneNumber());
			ps.setString(9, sdm.getAlternate());
			ps.setInt(10, sdm.getCid());
			int n = ps.executeUpdate();
			if (n > 0) {
				status = "succes";
			}
		} catch (Exception e) {
			System.out.println(e);

		}
		return status;

	}

	public String FacultyData(Faculty sdm) {
		String status = "fild";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mahendra", "root", "root");
			PreparedStatement ps = con.prepareStatement(
					"insert into (FacultyFistname,FacultyLastname,FacultySubject,PhoneNumber,Mail,Adresh,cid)faculty01 values (?,?,?,?,?,?,?)");

			ps.setString(1, sdm.getFacultyFistname());
			ps.setString(2, sdm.getFacultyLastname());
			ps.setString(3, sdm.getFacultySubject());

			ps.setString(4, sdm.getPhoneNumber());

			ps.setString(5, sdm.getMail());

			ps.setString(6, sdm.getAdresh());

			ps.setInt(7, sdm.getCid());

			int n = ps.executeUpdate();
			if (n > 0) {
				status = "succes";
			}
		} catch (Exception e) {
			System.out.println(e);

		}
		return status;

	}
}
