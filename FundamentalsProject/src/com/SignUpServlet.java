package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
            Connection con=DBConnection.emergencycon();
       HttpSession  sess=request.getSession(true);
      
      
        PrintWriter pw = response.getWriter();
        String fName=request.getParameter("firstName");
        String lName=request.getParameter("lastName");
        String Email=request.getParameter("email");
        String userpass=request.getParameter("password");
        String userpassconf=request.getParameter("passwordconfirm");
        String MobNo = request.getParameter("phone");
        String Gender = request.getParameter("gender");
        /*String birthM = request.getParameter("birthMonth");
        String birthD = request.getParameter("birthDay");
        String birthY = request.getParameter("birthYear");*/
        String adminK = request.getParameter("adminKey");
        String managerK = request.getParameter("managerKey");
        int flag = 0;
        if(adminK.isEmpty() && !managerK.isEmpty())
        {
        	flag = 1;
        }
        else if(!adminK.isEmpty() && managerK.isEmpty())
        {
        	flag = 2;
        }
       
        
        String sql = "insert into userinformation(FirstName,LastName,EmailAddress,Password,PhoneNumber,Gender,AdminKey,ManagerKey) values(?,?,?,?,?,?,?,?)";
        
     
        PreparedStatement pst =(PreparedStatement) con.prepareStatement(sql);
        
        pst.setString(1,fName);
        pst.setString(2,lName);
        pst.setString(3,Email);
        pst.setString(4,userpass);
        pst.setString(5,MobNo);
        pst.setString(6,Gender);
        pst.setString(7,adminK);
        pst.setString(8,managerK);
        int i = pst.executeUpdate(); 
        String msg=" ";
        if(i!=0){  
           msg="Record has been inserted";
          pw.println("<font size='6' color=blue>" + msg + "</font>"); 
          
          if(flag == 2)
          {
        	  
        	  PreparedStatement pst1 =(PreparedStatement) con.prepareStatement("insert into credentials(Email,Password,designation) values(?,?,?)");
        	  pst1.setString(1, Email);
        	  pst1.setString(2, userpass);
        	  pst1.setString(3, "Admin");
        	  pst1.executeUpdate();
        	  System.out.println("----Inside Admin");
          }
          else if(flag == 1)
          {
        	  PreparedStatement pst1 =(PreparedStatement) con.prepareStatement("insert into credentials(Email,Password,designation) values(?,?,?)");
        	  pst1.setString(1, Email);
        	  pst1.setString(2, userpass);
        	  pst1.setString(3, "Manager");
        	  pst1.executeUpdate();
        	  System.out.println("----Inside Manager");
          }
          else if(flag == 0)
          {
        	  PreparedStatement pst1 =(PreparedStatement) con.prepareStatement("insert into credentials(Email,Password,designation) values(?,?,?)");
        	  pst1.setString(1, Email);
        	  pst1.setString(2, userpass);
        	  pst1.setString(3, "User");
        	  pst1.executeUpdate();
        	  System.out.println("----Inside User");
          }


        }  
        else{  
          msg="failed to insert the data";
          pw.println("<font size='6' color=blue>" + msg + "</font>");
         }  
        pst.close();
  
        System.out.println("--------------");
         } catch (Exception exp) {
          exp.printStackTrace();
        }
		doGet(request, response);
	}

}
