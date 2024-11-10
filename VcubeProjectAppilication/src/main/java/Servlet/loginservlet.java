package Servlet;

import java.io.IOException;

import DAO01.Dao02;
import Modal.ModalLogin;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String mail = request.getParameter("mail");
		String password = request.getParameter("password");
		String rool = request.getParameter("role");
		System.out.println(mail);
		System.out.println(password);
		System.out.println(rool);
		ModalLogin obj = new ModalLogin();
		obj.setMail(mail);
		obj.setPassword(password);
		obj.setRool(rool);
		Dao02 obj1 = new Dao02();
		String man = obj1.LoginData(obj);
		if (man.equals("succes")) {
			RequestDispatcher rd1 = request.getRequestDispatcher("/adminpage.html");
			rd1.include(request, response);

		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/login.html");
			rd.include(request, response);

		}

	}

}
