<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Warehouse management - Driver System</title>
</head>
<body>
<form action="contact" method="post">
    <p>Your email address: <input name="email"></p>
    <p>Mail subject: <input name="subject"></p>
    <p>Mail message: <textarea name="message"></textarea></p>
    <p><input type="submit"><span class="message">${message}</span></p>
</form>
</body>
</html>