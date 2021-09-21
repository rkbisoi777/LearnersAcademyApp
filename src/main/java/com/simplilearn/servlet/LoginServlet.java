package com.simplilearn.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.simplilearn.util.HibernateUtil;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("login.jsp").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String user_name = "admin";
		String pass_word = "password";
		
		//Fetch data from request
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//1. load session factory
		SessionFactory factory = HibernateUtil.buildSessionFactory();
		
		//2. create a session
		Session session = factory.openSession();
		
		
		//3. validate
		if(username.equals(user_name) && password.equals(pass_word)) {
			session.close();
			request.getRequestDispatcher("admin.jsp").include(request, response);
		} else {
			out.print("<h1 style='color:red'> Wrong Password </h1>");
			out.print("<a href='login.jsp'>Go Back</a>");
		}

		
		
	}

}
