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
<h1>Add Student</h1>
<form action="add-student" method="post">
<fieldset>
<legend>Add Student Form</legend>
<br>
First Name : <input type="text" name="first_name" id="first_name"/><br>
<br>
Last Name : <input type="text" name="last_name" id="last_name"/><br>
<br>
Email : <input type="text" name="email" id="email"/><br>
<br>
Contact : <input type="text" name="contact" id="contact"/><br>
<br>
Address : <input type="text" name="address" id="address"/><br>
<br>
Assign Class : <select name="classes" id="classes">
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
<input type="submit" value="Add Student"/>
</fieldset>
</form>

</body>
</html>