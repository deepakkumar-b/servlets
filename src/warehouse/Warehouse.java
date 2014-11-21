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
public class Warehouse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Warehouse() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected String itemname; 
    protected String description; 
    protected String units; 
    protected String volume; 
    
    protected final String NL = "\n";     // carriage return 

    // constructors 
   public Warehouse(HttpServletRequest request) 
    { 
        itemname = request.getParameter("itemname"); 
        description = request.getParameter("Description"); 
        units = request.getParameter("units"); 
        volume = request.getParameter("Volume"); 

    } 

    public Warehouse(ResultSet dataResultSet) 
    { 

        try { 
            // assign data members 
        	
        	itemname = dataResultSet.getString("itemname"); 
            description = dataResultSet.getString("Description"); 
            units = dataResultSet.getString("units"); 
            volume = dataResultSet.getString("Volume");
            
            } 
        catch (SQLException e) 
        { 
            e.printStackTrace(); 
        } 
    } 

    
    public String getItemname() 
    { 
        return itemname; 
    } 

    public String getDescription() 
    { 
        return description; 
    } 

    public String getUnit() 
    { 
        return units; 
    } 

    public String getVolume() 
    { 
        return volume; 
    } 

      

    //  methods 
    //  normal text string representation 
    public String toString() 
    { 
        String replyString = ""; 

        replyString += "Item: " + itemname + NL; 
        replyString += "Description: " + description + NL; 
        replyString += "Unit: " + units  + NL; 
        replyString += "Volume Left: " + volume + NL; 
        

        return replyString; 
    } 

    //  returns data as HTML formatted un-ordered list 
    public String toWebString() 
    { 

        String replyString = "<ul>"; 

        replyString += "<li><B>Name:</B> " + itemname + NL; 
        replyString += "<li><B>Description:</B> " + description + NL; 
        replyString += "<li><B>Units:</B> " + units  + NL; 
        replyString += "<li><B>Volume Leftover:</B> " + volume + NL; 
        

        replyString += "</ul>" + NL; 




        return replyString; 
    } 
    public String toWebString2() 
    { 

        String replyString = "<ul>"; 

        replyString += "<li><B>Name:</B> " + itemname + NL; 
        replyString += "<li><B>Volume Shipped:</B> " + volume + NL; 
        

        replyString += "</ul>" + NL; 




        return replyString; 
    } 

    // returns data formatted for an HTML table row 
    public String toTableString(int rowNumber) 
    { 
        String replyString = ""; 
        String tdBegin = "<td>"; 
        String tdEnd = "</td>" + NL; 

        replyString += "<tr>" + NL; 
        replyString += tdBegin + rowNumber + tdEnd; 
        replyString += tdBegin + itemname + tdEnd; 
        //replyString += tdBegin + "<a href=mailto:" + email + "> " 
                               //+ email + "</a>" + tdEnd; 
        //replyString += tdBegin + "<img src=" + email + "> " 
             //   + tdEnd;
        replyString += tdBegin + description + tdEnd;
        replyString += tdBegin + units + tdEnd; 
        replyString += tdBegin + volume + tdEnd;
        replyString += "</tr>" + NL; 

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
