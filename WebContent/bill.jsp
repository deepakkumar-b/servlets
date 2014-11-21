<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bill of Lading</title>
</head>
<link rel="stylesheet" href="//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
  <link rel="stylesheet" href="/resources/demos/style.css">
<body background='manager.jpg'>

<!-- Send Items --> 

<CENTER> 
<H1> 
Bill of Lading</H1></CENTER> 

<HR> 
<H2> 
Instructions</H2> 

<OL> 
<LI> 
Enter your information in the fields below.</LI> 

<LI> 
Press the <B>Bill Of Lading </B>button to generate results.</LI> 
</OL> 
<FORM method="get" action="BillServlet"> 
<TABLE BORDER=0 CELLPADDING=5 WIDTH="40%" > 
<TR> 
<TD WIDTH="80%"><B>Name of the Item </B></TD> 

<TD WIDTH="20%"><INPUT type="text" name="itemname" size="20"></TD> 

</TR>

<TR>
<TD WIDTH="43%"><B>Volume to be shipped </B><I>(number)</I></TD> 

<TD WIDTH="57%"><INPUT type="number" name="Volume" size="20"></TD> 
</TR> 

</TABLE>
<RIGHT><TABLE BORDER=0 CELLPADDING=5 WIDTH="40%" > 
<TR> 
<TD WIDTH="80%"><B>Name of the Truck Driver </B></TD> 

<TD WIDTH="20%"><INPUT type="text" name="driver" size="20"></TD> 

</TR>

<TR>


  <script>
  $(function() {
    $( "#datepicker" ).datepicker();
  });
  </script>
</head>
<body>
 <TD WIDTH="43%"><B>Date </B></TD>
<TD WIDTH="57%"><input type="text" id="datepicker" name="date" size="20"></p>
 </TD> 
</TR> 

</TABLE></RIGHT>

  
  
<CENTER><INPUT type="submit" value="Populate" name="bill">
<INPUT type="reset" value="Reset Form" name="B2"></CENTER> 

</FORM>
<br /> 
<HR> 

<CENTER>
<br>
<a href="mail.jsp">Send a mail</a>
<A HREF="home.jsp">Return to WareHouse Home Page</A><br>
</CENTER> 

</BODY> 
</HTML> 
