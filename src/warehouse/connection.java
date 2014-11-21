package warehouse;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
import java.util.*;

import javax.swing.*;
/**
 * Servlet implementation class test
 */

public class connection extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public connection() {
        super();
        // TODO Auto-generated constructor stub
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
		
		
		try{
			String uname = request.getParameter("uname");
			String password = request.getParameter("upassword");
			//System.out.println("Name"+uname);
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sam?","root","root");
			System.out.println(uname);
			
			//Scanner in = new Scanner(System.in);
			/*System.out.println("Enter new user name");
			String newuser= in.nextLine();
			System.out.println("Enter the password");
			String newpwd = in.nextLine();*/
			String searchQuery="select * from manager where username='"+uname+"' AND user_id='"+password+"'";
			Statement stmt=con.createStatement();
			ResultSet rs = stmt.executeQuery(searchQuery);
			System.out.println("Inside"+searchQuery);
								
			while(rs.next()){
				String dbUser = rs.getString("username");
				String dbPassword= rs.getString("user_id");
				String type= rs.getString("type");
				boolean entrance;
				entrance=false;

				if ((uname.equals(dbUser)) && (password.equals(dbPassword)) && (type.equals("manager")) ){
					request.getRequestDispatcher("home.jsp").include(request, response);
					//entrance=true;
					}
					else if((uname.equals(dbUser)) && (password.equals(dbPassword)) && (type.equals("driver"))) {
					//entrance=false;
					request.getRequestDispatcher("driver.jsp").include(request, response); 
					}

					else
					{

					}
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
}