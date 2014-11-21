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
<font color='Blue'><center><h2> Welcome to Warehouse Management System </h2></center>
<h2> View By Items </h2><br>
        
<form method="post" action="viewservlet" >

<table border="2">
<tr>
<td>Items</td>
</tr>
<%
try
{
Class.forName("com.mysql.jdbc.Driver");
String url="jdbc:mysql://localhost:3306/sam?";
//jdbc:mysql://localhost:3306/sam?
String username="root";
String password="root";
String query="select itemname from bill";
Connection conn;
conn=DriverManager.getConnection(url,username,password);
Statement stmt=(Statement)conn.createStatement();
ResultSet rs=(ResultSet)stmt.executeQuery(query);%>
<SELECT name="itemname"> Choose an Item : <%
while(rs.next())
{

%>
    
<OPTION ><%= rs.getString("itemname")%></OPTION>

<%

}
%>
</SELECT>
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

<input type="submit" value="submit">
</form>

</body>
</html>
 <br>
</body>
</html>