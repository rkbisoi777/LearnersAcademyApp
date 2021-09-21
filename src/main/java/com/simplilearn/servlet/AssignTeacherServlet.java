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
import com.simplilearn.entity.Subject;
import com.simplilearn.entity.Teacher;
import com.simplilearn.util.HibernateUtil;

/**
 * Servlet implementation class AssignTeacherServlet
 */
@WebServlet("/assign-teacher")
public class AssignTeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AssignTeacherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("teacher-subject.jsp").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		//Fetch data f-idrom request
		Integer teacher_id = Integer.parseInt(request.getParameter("teacher_id"));
		String subject = request.getParameter("subject");
		String classes = request.getParameter("classes");
		//1. load session factory
		SessionFactory factory = HibernateUtil.buildSessionFactory();
		
		//2. create a session
		Session session = factory.openSession();
		
		//3. begin transaction
		Transaction tx = session.beginTransaction();
		
		//4. create persistence object/ add product
		Teacher tchr = (Teacher) session.createQuery("FROM Teacher T WHERE T.teacherId = :teacher_id").setParameter("teacher_id", teacher_id).uniqueResult();
		Classes cls = (Classes) session.createQuery("FROM Classes C WHERE C.className = :classes").setParameter("classes", classes).uniqueResult();
		Subject sbjt = (Subject) session.createQuery("FROM Subject S WHERE S.subjectName = :subject").setParameter("subject", subject).uniqueResult();
		cls.addTeacher(tchr);
		cls.addSubject(sbjt);
		//stdnt.setClasses(cls);
		//5. save product
		//session.save(stdnt);
		
		//6. commit transaction
		tx.commit();
		
		
		out.print("<h3 style='color:green'> Classes Assigned to Subject Successfully! </h3>" );
		out.print("<br><a href='admin.jsp'>Admin Panel</a>");
		//7. close session
		session.close();
	}

}
