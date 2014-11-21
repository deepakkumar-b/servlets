<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Warehouse Management System</title>
</head>
<body background="images.jpg">
<font color='Blue'><center><h2> Welcome to Warehouse Management System </h2></center>
<h2> Login Page </h2><br>
<form method="post" action="connection" >
        <!-- action="LoginServlet" -->
        <table>                
            <tr>
                <td></td>
                <td align="left">Username</td>
                <td><input type="text" name="uname"/></td>
                <td></td>                                
            </tr>
            <tr>
                <td></td>
                <td align="left">Password</td>
                <td><input type="password" name="upassword"/></td>
                <td></td>
            </tr>
            <tr>
                <td></td>
                <td align="left">Manager/Driver</td>
                <td><SELECT name="type" size="1">
<OPTION selected value="manager">manager</OPTION>
 <OPTION value="driver">driver</OPTION></SELECT></td>
                <td></td>
            </tr>
            <tr>
                <td></td>
                <td></td>
                <td><input type="submit" value="submit"></td>
                <td></td>
            </tr></font>
               
            </table>
        </form>
        <br>
   <br>
</body>
</html>