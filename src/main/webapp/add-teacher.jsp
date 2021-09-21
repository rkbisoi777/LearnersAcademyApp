<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Add Teacher</h1>
<form action="add-teacher" method="post">
<fieldset>
<legend>Teacher Registration Form</legend>
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
<br>
<input type="submit" value="Add Teacher"/>
</fieldset>
</form>
</body>
</html>