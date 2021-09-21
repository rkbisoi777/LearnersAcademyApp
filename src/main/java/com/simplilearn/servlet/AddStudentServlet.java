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
import com.simplilearn.entity.Student;
import com.simplilearn.util.HibernateUtil;

/**
 * Servlet implementation class AddStudentServlet
 */
@WebServlet("/add-student")
public class AddStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("add-student.jsp").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		//Fetch data from request
		String firstName = request.getParameter("first_name");
		String lastName = request.getParameter("last_name");
		String email = request.getParameter("email");
		String contact = request.getParameter("contact");
		String address = request.getParameter("address");
		String classes = request.getParameter("classes");
		//1. load session factory
		SessionFactory factory = HibernateUtil.buildSessionFactory();
		
		//2. create a session
		Session session = factory.openSession();
		
		//3. begin transaction
		Transaction tx = session.beginTransaction();
		
		//4. create persistence object/ add product
		Student stdnt = new Student(firstName, lastName, email, contact, address);
		Classes cls = (Classes) session.createQuery("FROM Classes C WHERE C.className = :classes").setParameter("classes", classes).uniqueResult();
		stdnt.setClasses(cls);
		//5. save product
		session.save(stdnt);
		
		//6. commit transaction
		tx.commit();
		
		
		out.print("<h3 style='color:green'> Student Added Successfully! </h3>" );
		out.print("<br><a href='admin.jsp'>Admin Panel</a>");
		//7. close session
		session.close();
	}

}
