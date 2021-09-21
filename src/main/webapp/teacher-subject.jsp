<%@ page language="java" import="java.sql.*" %> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Assign Teacher</h1>
<form action="assign-teacher" method="post">
<fieldset>
<legend>Class : </legend>
<br>
Class : <select name="classes" id="classes">
     <option>Select</option>
     
    <%
        try {
    		String query = "select * from classes";
    		Class.forName("com.mysql.jdbc.Driver");
    		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/learneracademy","root","password");
    	    Statement st = conn.createStatement();
    		ResultSet rs = st.executeQuery(query);
    		while(rs.next()){
    			%>
    			<option><%=rs.getString("class_name") %></option>
    			<% 
    		}
    		
        } catch (Exception e){
        	e.printStackTrace();
        	out.println("Error "+e.getMessage());
        }
    %>
</select>
<br>
<br>
Subject : <select name="subject" id="subject">
     <option>Select</option>
     
    <%
        try {
    		String query = "select * from subject";
    		Class.forName("com.mysql.jdbc.Driver");
    		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/learneracademy","root","password");
    	    Statement st = conn.createStatement();
    		ResultSet rs = st.executeQuery(query);
    		while(rs.next()){
    			%>
    			<option><%=rs.getString("subject_name") %></option>
    			<% 
    		}
    		
        } catch (Exception e){
        	e.printStackTrace();
        	out.println("Error "+e.getMessage());
        }
    %>
</select>
<br>
<br>
Teacher Id : <select name="teacher_id" id="teacher_id">
     <option>Select</option>
     
    <%
        try {
    		String query = "select * from teacher";
    		Class.forName("com.mysql.jdbc.Driver");
    		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/learneracademy","root","password");
    	    Statement st = conn.createStatement();
    		ResultSet rs = st.executeQuery(query);
    		while(rs.next()){
    			%>
    			<option><%=rs.getInt("teacher_id")%></option>
    			<% 
    		}
    		
        } catch (Exception e){
        	e.printStackTrace();
        	out.println("Error "+e.getMessage());
        }
    %>
</select>
<br>
<br>
<input type="submit" value="Assign"/>
</fieldset>
</form>
</body>
</body>
</html>