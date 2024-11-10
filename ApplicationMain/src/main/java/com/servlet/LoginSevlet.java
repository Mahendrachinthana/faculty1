package com.servlet;

import java.io.IOException;

import com.dao.LoginDao;
import com.model.LoginModel;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginSevlet
 */
@WebServlet("/login")
public class LoginSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginSevlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String name =request.getParameter("mail");
		String name1 =request.getParameter("password");
		String name2 =request.getParameter("role");
		System.out.println(name);
		System.out.println(name1);
		System.out.println(name2);
		LoginModel obj =new LoginModel();
		obj.setMail(name1);
		obj.setPassword(name1);
		obj.setRool(name1);
		LoginDao obj1 =new LoginDao();
		String status=obj1.LoginCheck(obj);
		System.out.println(status+"in servlet dao response");
		if(status.equals("succes")) {
		    RequestDispatcher rd1 = request.getRequestDispatcher("/AdminHome.html");  
		    rd1.include(request, response);  
			
		}
		else {
			 RequestDispatcher rd1 = request.getRequestDispatcher("/login.html");  
			    rd1.include(request, response);  
			
		}

	}

}
