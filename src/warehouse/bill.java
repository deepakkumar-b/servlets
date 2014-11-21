package warehouse;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Warehouse
 */
public class bill extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public bill() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected String itemname; 
    protected String description; 
    protected String units; 
    protected String volume; 
    protected String driver;
    protected String date;
    
    protected final String CR = "\n";     // carriage return 

    // constructors 
   public bill(HttpServletRequest request) 
    { 
        itemname = request.getParameter("itemname"); 
        volume = request.getParameter("Volume"); 
        driver = request.getParameter("driver");
        date = request.getParameter("date");

    } 

    public bill(ResultSet dataResultSet) 
    { 

        try { 
            // assign data members 
        	
        	itemname = dataResultSet.getString("itemname"); 
            volume = dataResultSet.getString("Volume");
            driver = dataResultSet.getString("driver"); 
            date = dataResultSet.getString("date"); 
            
            } 
        catch (SQLException e) 
        { 
            e.printStackTrace(); 
        } 
    } 

    //  accessors 
    public String getItemname() 
    { 
        return itemname; 
    } 

     public String getVolume() 
    { 
        return volume; 
    } 
     
    public String getDriver()
    {
    	return driver;
    	
    }
    public String getDate()
    {
    	return date;
    	
    }
    

      

    //  methods 
    //  normal text string representation 
    public String toStringb() 
    { 
        String replyString = ""; 

        replyString += "Item: " + itemname + CR;
        replyString += "Volume Left: " + volume + CR;
        replyString += "Driver Name: " + driver + CR;
        replyString += "Date: " + date + CR;
        

        return replyString; 
    } 

    //  returns data as HTML formatted un-ordered list 
    public String toWebStringb() 
    { 

        String replyString = "<ul>"; 

        replyString += "<li><B>Name:</B> " + itemname + CR; 
        replyString += "<li><B>Volume Leftover:</B> " + volume + CR; 
        replyString += "<li><B>Driver:</B> " + driver + CR; 
        replyString += "<li><B>Date:</B> " + date  + CR; 
        

        replyString += "</ul>" + CR; 




        return replyString; 
    } 
    public String toWebString2b() 
    { 

        String replyString = "<ul>"; 

        replyString += "<li><B>Name:</B> " + itemname + CR; 
        replyString += "<li><B>Volume Shipped:</B> " + volume + CR; 
        

        replyString += "</ul>" + CR; 




        return replyString; 
    } 

    // returns data formatted for an HTML table row 
    public String toTableStringb(int rowNumber) 
    { 
        String replyString = ""; 
        String tdBegin = "<td>"; 
        String tdEnd = "</td>" + CR; 

        replyString += "<tr>" + CR; 
        replyString += tdBegin + rowNumber + tdEnd; 
        replyString += tdBegin + itemname + tdEnd; 
        //replyString += tdBegin + "<a href=mailto:" + email + "> " 
                               //+ email + "</a>" + tdEnd; 
        //replyString += tdBegin + "<img src=" + email + "> " 
             //   + tdEnd; 
        replyString += tdBegin + volume + tdEnd;

        replyString += tdBegin + driver + tdEnd;
        replyString += tdBegin + date + tdEnd;
        replyString += "</tr>" + CR; 

        return replyString; 
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
