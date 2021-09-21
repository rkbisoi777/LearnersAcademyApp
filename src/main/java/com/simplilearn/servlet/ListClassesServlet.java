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

import com.simplilearn.entity.Classes;
import com.simplilearn.util.HibernateUtil;

/**
 * Servlet implementation class ListClassesServlet
 */
@WebServlet("/list-classes")
public class ListClassesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListClassesServlet() {
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
		List<Classes> classess = session.createQuery("from Classes").list();
		
		//4. show data as table
		out.print("<a href='admin.jsp'>Admin Panel</a><br>");
		out.print("<h1> Class List </h1>");
		out.print("<style> table, td, th {" + "border:2px solid blue;" + "padding: 10px;" + "}</style>");
		out.print("<table>");
		out.print("<tr>");
		out.print("<th> Class ID </th>");
		out.print("<th> Class Name </th>");
		out.print("<th> No. of Subjects </th>");
		out.print("<th> No. of Teachers </th>");
		out.print("</tr>");
		for (Classes c : classess) {
			out.print("<tr>");
			out.print("<td>" + c.getClassId() + "</td>");
			out.print("<td>" + c.getClassName() + "</td>");
			out.print("<td>" + c.getSubjects().size() + "</td>");
			out.print("<td>" + c.getTeachers().size() + "</td>");
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
