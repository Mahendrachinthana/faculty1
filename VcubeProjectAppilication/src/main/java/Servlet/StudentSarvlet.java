package Servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import DAO01.Dao02;
import Modal.StudentDitailsModal;

@WebServlet("Student")
public class StudentSarvlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public StudentSarvlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("FirstName");
		String name1 = request.getParameter("LastName");
		String name2 = request.getParameter("FatherName");

		String name3 = request.getParameter("MotherName");
		String name4 = request.getParameter("StudentSubject");

		String name5 = request.getParameter("Adresh");

		String name6 = request.getParameter("Mail");

		String name7 = request.getParameter("PhoneNumber");

		String name8 = request.getParameter("Alternate");
		int name9 = Integer.parseInt(request.getParameter("cid"));
		System.out.println(name);
		System.out.println(name1);

		System.out.println(name2);

		System.out.println(name3);

		System.out.println(name4);
		System.out.println(name5);
		System.out.println(name6);
		System.out.println(name7);
		System.out.println(name8);
		System.out.println(name9);
		StudentDitailsModal obj = new StudentDitailsModal();
		obj.setFirstName(name);
		obj.setLastName(name1);
		obj.setFatherName(name2);
		obj.setMotherName(name3);
		obj.setStudentSubject(name4);
		obj.setAdresh(name5);
		obj.setMail(name6);
		obj.setPhoneNumber(name7);
		obj.setAlternate(name8);
		obj.setCid(name9);
		Dao02 obj2 = new Dao02();
		String status = obj2.StudentData(obj);
		if (status.equals("succes")) {
			RequestDispatcher rd1 = request.getRequestDispatcher("/Registrationsucces.html");
			rd1.include(request, response);
		} else {
			RequestDispatcher rd2 = request.getRequestDispatcher("/StudentDitails.html");
			rd2.include(request, response);
		}

	}

}
