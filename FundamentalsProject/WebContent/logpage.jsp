<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color:lightgrey;">
<center>
<h2>Login</h2>

 <form action="LoginServlet" method="post">
					<label>E-mail:</label>
					<input id="email" name="email" class="text" />
					<br/>
					<label>Password:</label>
					<input id="upassword" name="upassword" type="password" class="text" />
					<br/>
					<div class="sep"></div>
					<button type="submit" class="ok">Login</button><br/><a class="button" href = "Registration.jsp">Sign Up</a>
				</form>
</center>
</body>
</html>