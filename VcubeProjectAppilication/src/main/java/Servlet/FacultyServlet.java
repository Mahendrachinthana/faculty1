package Servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import DAO01.Dao02;
import Modal.Faculty;

/**
 * Servlet implementation class FacultyServlet
 */

@WebServlet("/Faculty")

public class FacultyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String man =request.getParameter("FacultyFistname");
		String man1 =request.getParameter("FacultyLastname");

		String man2 =request.getParameter("FacultySubject");
		String man3 =request.getParameter("PhoneNumber");


		String man4 =request.getParameter("Mail");

		String man5 =request.getParameter("Adresh");

		int man6 = Integer.parseInt(request.getParameter("cid"));
		Faculty obj2 = new Faculty();
		obj2.setFacultyFistname(man);
		obj2.setFacultyLastname(man1);
		obj2.setFacultySubject(man2);
		obj2.setPhoneNumber(man3);
		obj2.setMail(man4);
		obj2.setAdresh(man5);
		obj2.setCid(man6);
		Dao02 obj1 =new Dao02();
		String status=obj1.FacultyData(obj2);
		if(status.equals("succes")) {
		    RequestDispatcher rd1 = request.getRequestDispatcher("/Registrationsucces.html");  
		    rd1.include(request, response);  
			
		}

		
	}

}
