package Servlet;

import java.io.IOException;

import DAO01.Dao02;
import Modal.MODAL;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/course")
public class SERVLET extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public SERVLET() {
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name =request.getParameter("CourseName");
		String name1 =request.getParameter("CourseDuration");
		int name2 =Integer.parseInt(request.getParameter("CourseFees"));
		System.out.println(name);
		System.out.println(name1);
		System.out.println(name2);
		MODAL obj =new MODAL();
		obj.setCourseName(name);
		obj.setCoursedDuration(name1);
		obj.setCourseFees(name2);
		Dao02 obj1 =new Dao02();
		String status=obj1.insertData(obj);
		if(status.equals("succes")) {
		    RequestDispatcher rd1 = request.getRequestDispatcher("/Registrationsucces.html");  
		    rd1.include(request, response);  
			
		}
	}

}
