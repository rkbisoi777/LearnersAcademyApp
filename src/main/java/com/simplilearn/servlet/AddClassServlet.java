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
import org.hibernate.Transaction;
import com.simplilearn.entity.Classes;
import com.simplilearn.util.HibernateUtil;

/**
 * Servlet implementation class AddClassServlet
 */
@WebServlet("/add-class")
public class AddClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddClassServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("add-class.jsp").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		//Fetch data from request
		String className = request.getParameter("class_name");
	
		//1. load session factory
		SessionFactory factory = HibernateUtil.buildSessionFactory();
		
		//2. create a session
		Session session = factory.openSession();
		
		//3. begin transaction
		Transaction tx = session.beginTransaction();
		
		//4. create persistence object/ add product
		Classes cls = new Classes(className);
		
		//5. save product
		session.save(cls);
		
		//6. commit transaction
		tx.commit();
		
		
		out.print("<h3 style='color:green'> Class Added successfully! </h3>" );
		out.print("<br><a href='admin.jsp'>Admin Panel</a>");
		//7. close session
		session.close();
	}

}
