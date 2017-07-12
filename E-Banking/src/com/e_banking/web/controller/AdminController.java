package com.e_banking.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.e_banking.web.dao.BankingDAO;
import com.e_banking.web.dao.BankingDAOFactory;
import com.e_banking.web.util.DbUtil;

/**
 * Servlet implementation class AdminController
 */
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	doPost(req, resp);
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BankingDAO dao = BankingDAOFactory.getInstance(); 
		PrintWriter pr = response.getWriter();
		HttpSession session = request.getSession();
		String id = request.getParameter("id");
		switch(id){
			
		case "admin":
			String nameA = (String)session.getAttribute("username");
			if(nameA!=null){
				RequestDispatcher rd = request.getRequestDispatcher("adminLoginSuccess.jsp");
				rd.forward(request, response);
			}else{
				RequestDispatcher rds = request.getRequestDispatcher("adminLogin.jsp");
				rds.forward(request, response);
			}
			break;
			
		case "sessn":
				session.setAttribute("username", null);
				RequestDispatcher rds = request.getRequestDispatcher("adminLogin.jsp");
				rds.forward(request, response);
			break;
		
			case "adminLog":
				String username = request.getParameter("username");
				String pass = request.getParameter("pass");
				Map username1 = dao.adminLogin(username, pass);
				String user = (String)username1.get("username");
				if(user!=null){
					session.setAttribute("username", user);//setting usernmae value
					RequestDispatcher rd = request.getRequestDispatcher("adminLoginSuccess.jsp");
					rd.forward(request, response);
				}else{
					pr.println("<font color='red' size=5><center>invalid user name or password</center></font>");
					
					RequestDispatcher rd3 = request.getRequestDispatcher("adminLogin.jsp");
					rd3.include(request, response);
				}
			break;
			
			case "deposit":
				try{
					int accountNo = Integer.parseInt(request.getParameter("account"));
					String name = request.getParameter("name");
					String lname = request.getParameter("lname");
					double amount = Double.parseDouble(request.getParameter("amount"));
					String date = request.getParameter("date");
					Connection con = DbUtil.getConnection();//database connection
					
						PreparedStatement ps1 = con.prepareStatement("select firstName,lastName,accountNo,status from customers where accountNo=(?)");
						ps1.setInt(1, accountNo);
						ResultSet rs = ps1.executeQuery();
						String firstName="";
						String lastName="";
						int account=0;
						int status=0;
						if(rs.next()){
							 firstName= rs.getString(1);
							 lastName = rs.getString(2);
							 account=rs.getInt(3);
							 status = rs.getInt(4);
							
						}
						if(firstName.equalsIgnoreCase(name) && lastName.equalsIgnoreCase(lname)&& account==accountNo ){
							if(status==1){
								Map mp = dao.depositMoney(accountNo, name,lname, amount, date);
								int i = (int)mp.get("result");
								if(i>0){
									dao.depositAdmin(accountNo, amount);
									//pr.println("<font color='green' size=5><center>Successfully deposited </center></font>");
									RequestDispatcher rd = request.getRequestDispatcher("deposit.jsp");
									rd.include(request, response);
									pr.println("<script type=\"text/javascript\">alert('Successfully deposited');</script>");
									
								}
							}else{
								RequestDispatcher rd = request.getRequestDispatcher("deposit.jsp");
								rd.include(request, response);
	
								
								
								
								
								
								
								
								pr.println("<script type=\"text/javascript\">window.alert('Account not activated yet');</script>");
								
								
							}
							
						}else{
								//pr.println("<font color='red' size=5><center>Account Number or name Incorrect </center></font>");
								
								RequestDispatcher rd = request.getRequestDispatcher("deposit.jsp");
								rd.include(request, response);
								pr.println("<script type=\"text/javascript\">window.alert('Account Number or name Incorrect');</script>");
				
							}	
						
				}catch(Exception e){
					System.out.println(e);
				}
				break;	
				
			case "activateAccount":
					int accountA = (int)session.getAttribute("acA");
					boolean result = dao.accountActivate(accountA);
					if(result){
						RequestDispatcher rd = request.getRequestDispatcher("activateD.jsp");
						rd.include(request, response);
						pr.println("<script type=\"text/javascript\">window.alert('Account Number activated successfully');</script>");
					}else{
						System.out.println("problem in database");
					}
				break;
				
		}
		
	}
}
