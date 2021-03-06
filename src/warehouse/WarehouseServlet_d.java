package warehouse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import warehouse.Warehouse;

/**
 * Servlet implementation class WarehouseServlet
 */
public class WarehouseServlet_d extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WarehouseServlet_d() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected Connection dbConnection; 
    protected PreparedStatement displayStatement; 
    protected PreparedStatement registerStatement;
    
    protected String dbURL = "jdbc:mysql://localhost:3306/sam";
    		//"jdbc:odbc:database"; 
    protected String userID = "root"; 
    protected String passwd = "root"; 

    protected String NL = "\n"; 

    protected final int NAME  = 1; 
    protected final int DESC = 2; 
    protected final int UNITS      = 3; 
    protected final int VOLUME    = 4; 
    
    public void init(ServletConfig config) throws ServletException 
    { 
        super.init(config); 

        // use println statements to send status messages to Web server console 
        try { 
            System.out.println("WarehouseServlet init: Start"); 
            
            Class.forName("com.mysql.jdbc.Driver"); 

            System.out.println("Getting a connection to - " + dbURL); 
            dbConnection = DriverManager.getConnection(dbURL, userID, passwd); 

            System.out.println("Preparing display statement"); 
            displayStatement = 
               dbConnection.prepareStatement("select * from bill where "+" driver = "+"?" ); 

            System.out.println("Preparing add items statement"); 
            registerStatement = 
               dbConnection.prepareStatement("insert into warehouse " 
+ "(itemname, description, units, volume)" 
                 + " values (?, ?, ?, ?)");    

            System.out.println("WarehouseServlet i: End"); 
        } 
        catch (Exception e) 
        { 
            cleanUp(); 
            e.printStackTrace(); 
        } 
    } 

    public void service(HttpServletRequest request, 
                        HttpServletResponse response) 
           throws ServletException, IOException 
    { 

        String userOption = null;
        userOption = request.getParameter("add"); 
        
        if (userOption != null) 
        { 
            // hidden form field "Register" was present 
        	//registerItem(request, response);
        	 
        } 
        else 
        { 
            // simply display the Items 
            displayItems(request, response); 
        } 
    } 

    public void displayItems(HttpServletRequest request, 
                                HttpServletResponse response) 
    { 
        bill abill = null; 

        try { 
            // build the html page heading 
            String htmlHead = "<html><head><title>Bills and Details</title></head>" + NL; 

            // build the html body 
            String htmlBody = "<body bgcolor ='cyan'><center>" + NL; 
            htmlBody += "<h1>Bills List</h1>" + NL; 
            htmlBody += "<hr></center><p>" + NL; 

            // build the table heading 
            String tableHead = "<center><table border width=100% cellpadding=5>" + NL; 
            tableHead += "<tr>" + NL; 
            tableHead += "<th> </th>" + NL; 
            tableHead += "<th>Item Name</th>" + NL; 
            tableHead += "<th>Volume</th>" + NL; 
            tableHead += "<th>Driver</th>" + NL; 
            tableHead += "<th>Date of Shipping</th>" + NL;
            tableHead += "</tr>" + NL; 

            bill abill1 = new bill(request);
            displayStatement.setString(1, abill1.getDriver());
            System.out.println(displayStatement);
            // execute the query to get a list of the Items 
            ResultSet dataResultSet = (ResultSet) displayStatement.executeQuery(); 

            // build the table body 
            String tableBody = ""; 

            int rowNumber = 1; 
            while (dataResultSet.next()) 
            { 
                abill = new bill(dataResultSet); 
                tableBody += abill.toTableStringb(rowNumber); 
                rowNumber++; 
            } 

            dataResultSet.close(); 

            // build the table bottom 
            String tableBottom = "</table></center>"; 

            // build html page bottom 
            String htmlBottom = "</body></html>"; 

            // build complete html page 
            htmlBody += tableHead + tableBody + tableBottom; 
            htmlBody += "<p><hr>"; 
            htmlBody += "<center><br><a href=login.jsp>Return to Login Page</a>"; 
            htmlBody += "<p><i>" + this.getServletInfo() + "</i>"; 
            htmlBody += "</center>"; 
            String htmlPage = htmlHead + htmlBody + htmlBottom; 

            // now let's send this dynamic data 
            // back to the browser 
            PrintWriter outputToBrowser =  new PrintWriter(response.getOutputStream()); 
            response.setContentType("text/html"); 
            outputToBrowser.println(htmlPage); 
            outputToBrowser.close(); 

        } 
        catch (Exception e) 
        { 
            cleanUp(); 
            e.printStackTrace(); 
        } 
    } 

    public void registerItem(HttpServletRequest request, 
                                HttpServletResponse response) 
    { 
        try { 
            // create a new Item based on the form data 
            Warehouse aItem = new Warehouse(request); 

            // set sql parameters 
            registerStatement.setString(NAME, aItem.getItemname()); 
            registerStatement.setString(DESC, aItem.getDescription()); 
            registerStatement.setString(UNITS, aItem.getUnit()); 
            registerStatement.setString(VOLUME, aItem.getVolume()); 
            

            // execute sql 
            registerStatement.executeUpdate(); 

            // build confirmation page 
			String htmlPage = "<html><head><title>Confirmation Page</title></head>"; 
			
			htmlPage += "<body>"; 
			htmlPage += "<center><h1>Confirmation Page</h1></center><hr>"; 
			htmlPage += "The following information was entered successfully"; 
			htmlPage += aItem.toWebString(); 
			
			htmlPage += "<hr>"; 
			htmlPage += "<center><a href=home.jsp>Return to Home Page</a> | "; 
			htmlPage += "<a href=WarehouseServlet>View Item List</a>"; 
			htmlPage += "<p><i>" + this.getServletInfo() + "</i>"; 
			htmlPage += "</center></body></html>"; 

            // now let's send this dynamic data 
            // back to the browser 
            PrintWriter outputToBrowser =  new PrintWriter(response.getOutputStream()); 

            response.setContentType("text/html"); 
            outputToBrowser.println(htmlPage); 
            outputToBrowser.close(); 
        } 
        catch (Exception e) 
        { 
            cleanUp(); 
            e.printStackTrace(); 
        } 
    } 
    
    public void cleanUp() 
    { 
        try { 
            System.out.println("Closing database connection"); 
            dbConnection.close(); 
        } 
        catch (SQLException e) 
        { 
            e.printStackTrace(); 
        } 
    } 

    public void destroy() 
    { 
        System.out.println("WarehouseServlet: destroy"); 
        cleanUp(); 
    } 

    public String getServletInfo() 
    { 
        return "<i>Item Registration Servlet, v.06</i>"; 
    } 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	

	try{
		String driver = request.getParameter("driver");
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sam?","root","root");
	
		String searchQuery="select * from bill where driver='"+driver+"'";
		Statement stmt=con.createStatement();
		ResultSet rs = stmt.executeQuery(searchQuery);
		System.out.println(driver);
							
		while(rs.next()){
			String driver1 = rs.getString("driver");
			System.out.println(driver1);
			boolean entrance;
			entrance=false;
			
		}
	} 
	catch (ClassNotFoundException e) {
	System.err.println("Couldn't find the mm " + "database driver: "+ e.getMessage());
	} 
	/*catch (InstantiationException e) {
	System.err.println(e.getMessage());
	} catch (IllegalAccessException e) {
	System.err.println(e.getMessage());
	} */
	catch (SQLException e) {
	System.err.println("SQL problem: " + e.getMessage());
	System.err.println("SQL state: " + e.getSQLState());
	System.err.println("Vendor error: " + e.getErrorCode());
	} 
	/*finally {
	try {
	if (con != null) {
		con.close();
	}
	} catch (SQLException e) {
	System.err.println(e.getMessage());
	}
	}*/
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
