<%@page import="com.mysql.jdbc.ResultSet"%>
<%@page import="com.mysql.jdbc.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Warehouse Management System</title>
</head>
<body>
<font color='magenta'><center><h2> View By Items System </h2></center>
<h2> Select an Item </h2><br>
<form method="post" action="view" >

<table border="2">
<tr>
<td>Item</td>
<td>Volume</td>
<td>Driver</td>
<td>Date</td>
</tr>
<%
try
{
Class.forName("com.mysql.jdbc.Driver");
String url="jdbc:mysql://localhost:3306/sam?";
//jdbc:mysql://localhost:3306/sam?
String username="root";
String password="root";
String query="select * from bill ";
Connection conn;
conn=DriverManager.getConnection(url,username,password);
Statement stmt=(Statement)conn.createStatement();
ResultSet rs=(ResultSet)stmt.executeQuery(query);
while(rs.next())
{

%>
    <tr><td><%= rs.getString("itemname")%></td>
    <td><%=rs.getString("volume")%></td>
    <td><%= rs.getString("driver") %></td>
    <td><%= rs.getString("date")%></td>
     
        <%

}
%>
</table>
<%
    rs.close();
    stmt.close();
    conn.close();
    }
catch(Exception e)
{
    e.printStackTrace();
    }

%>


</form>
        <br>
   <a href = "driver.jsp"> Truck Driver Login</a><br>
</body>
</html>