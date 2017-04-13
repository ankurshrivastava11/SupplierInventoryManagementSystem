package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
            Connection con=DBConnection.emergencycon();
       HttpSession  sess=request.getSession(true);
      
      
        PrintWriter out=response.getWriter();
        String email=request.getParameter("email");
        String userpass=request.getParameter("upassword");
  PreparedStatement st=(PreparedStatement) con.prepareStatement("select * from credentials where Email=? and Password=?");
   st.setString(1,email);
   st.setString(2,userpass);
       
      
     ResultSet rs=st.executeQuery();
     if(rs.next())
     {
         
         String des=rs.getString(3);
         
        
         if(des.equalsIgnoreCase("admin"))
         {
             System.out.println("Admin Login");
                out.println(" Admin Login");
         
         }
         
         else if(des.equalsIgnoreCase("manager"))
         {
              System.out.println("Manager Login");
          out.println(" Manager Login");
         }
         
       else
         {
              System.out.println("User Login");
          out.println(" User Login");
         }
     }
     else
     {
   out.println("invalid username password");
     }
      
      
  
        System.out.println("--------------");
         } catch (Exception exp) {
          exp.printStackTrace();
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
