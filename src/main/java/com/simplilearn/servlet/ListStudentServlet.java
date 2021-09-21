package com.simplilearn.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.simplilearn.entity.Student;
import com.simplilearn.util.HibernateUtil;

/**
 * Servlet implementation class ListStudentServlet
 */
@WebServlet("/list-student")
public class ListStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		//1. load session factory
		SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
				
		//2. create a session
		Session session = sessionFactory.openSession();
		
		//3. read products (create query)
		List<Student> students = session.createQuery("from Student").list();
		
		
		//4. show data as table
		
		out.print("<a href='admin.jsp'>Admin Panel</a><br>");
		out.print("<h1> Student List </h1>");
		out.print("<style> table, td, th {" + "border:2px solid blue;" + "padding: 10px;" + "}</style>");
		out.print("<table>");
		out.print("<tr>");
		out.print("<th> Student ID </th>");
		out.print("<th> First Name </th>");
		out.print("<th> Last Name </th>");
		out.print("<th> Email </th>");
		out.print("<th> Contact </th>");
		out.print("<th> Address </th>");
		out.print("<th> Class </th>");
		out.print("</tr>");
		for (Student s : students) {
			out.print("<tr>");
			out.print("<td>" + s.getStudentId() + "</td>");
			out.print("<td>" + s.getFirstName() + "</td>");
			out.print("<td>" + s.getLastName() + "</td>");
			out.print("<td>" + s.getEmail() + "</td>");
			out.print("<td>" + s.getContact() + "</td>");
			out.print("<td>" + s.getAddress() + "</td>");
			out.print("<td>" + s.getClasses()+ "</td>");
			out.print("</tr>");
		}
		out.print("</table>");
		//3. close session
		session.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
