<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<head>
<title>Home</title>
</head>
<h1>Home Page</h1>
<body>
<h3>Hello,
<%=request.getParameter("firstName")
%>
<%=request.getParameter("lastName")%>
</h3>
<br/>

</body>
</html>