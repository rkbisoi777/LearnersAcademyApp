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

import com.simplilearn.entity.Subject;
import com.simplilearn.util.HibernateUtil;

/**
 * Servlet implementation class ListSubjectServlet
 */
@WebServlet("/list-subject")
public class ListSubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListSubjectServlet() {
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
		List<Subject> subjects = session.createQuery("from Subject").list();
		
		//4. show data as table
		out.print("<a href='admin.jsp'>Admin Panel</a><br>");
		out.print("<h1> Subject List </h1>");
		out.print("<style> table, td, th {" + "border:2px solid blue;" + "padding: 10px;" + "}</style>");
		out.print("<table>");
		out.print("<tr>");
		out.print("<th> Subject ID </th>");
		out.print("<th> Subject Name </th>");
		out.print("<th> No. of Teachers </th>");
		out.print("<th> No. of Classes </th>");
		out.print("</tr>");
		for (Subject s : subjects) {
			out.print("<tr>");
			out.print("<td>" + s.getSubjectId() + "</td>");
			out.print("<td>" + s.getSubjectName() + "</td>");
			out.print("<td>" + s.getTeachers().size() + "</td>");
			out.print("<td>" + s.getClassess().size() + "</td>");
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
