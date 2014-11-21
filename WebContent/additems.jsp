<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Addition of Items</title>
</head>
<body background='images.jpg'>

<!-- Add Items to the inventory --> 

<CENTER> 
<H1> 
Add Items to the Inventory</H1></CENTER> 

<HR> 
<H2> 
Instructions</H2> 

<OL> 
<LI> 
Enter your information in the fields below.</LI> 

<LI> 
Press the <B>AddItems </B>button to enter your information into the warehouse 
database.</LI> 
</OL> 
<FORM method="get" action="WarehouseServlet"> 
<CENTER><TABLE BORDER=0 CELLPADDING=5 WIDTH="40%" > 
<TR> 
<TD WIDTH="80%"><B>Name of the Item </B></TD> 

<TD WIDTH="20%"><INPUT type="text" name="itemname" size="20"></TD> 

</TR>

<TR>
<TD WIDTH="100%"><B>Description of the Item</B>  

<P> <TEXTAREA rows="5" name="Description" cols="66"></TEXTAREA>
</TD> 
</TR>


<TR> 
<TD WIDTH="26%"><B>Unit of Measurement</B></TD> 

<TD WIDTH="10%"><SELECT name="units" size="1">
<OPTION selected value="unit">Unit</OPTION> <OPTION value="lbs">LBS</OPTION>
 <OPTION value="gallons">Gallons</OPTION></SELECT></TD> 

</TR>

<TR>
<TD WIDTH="43%"><B>Volume in the warehouse </B><I>(number)</I></TD> 

<TD WIDTH="57%"><INPUT type="number" name="Volume" size="20"></TD> 
</TR> 

</TABLE></CENTER> 
  
  
<CENTER><INPUT type="submit" value="AddItems" name="add">
<INPUT type="reset" value="Reset Form" name="B2"></CENTER> 

</FORM>
<br /> 
<HR> 
<CENTER><A HREF="home.jsp">Return to WareHouse Home Page</A>
</CENTER> 

</BODY> 
</HTML> 
