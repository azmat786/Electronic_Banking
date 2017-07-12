package com.e_banking.web.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.e_banking.web.dao.BankingDAO;
import com.e_banking.web.dao.BankingDAOFactory;
import com.e_banking.web.domain.Customer;
import com.e_banking.web.domain.MobileRecSameBank;
import com.e_banking.web.domain.MobileRecharge;
import com.e_banking.web.util.DbUtil;

/**
 * Servlet implementation class CustomerController
 */
@WebServlet("/CustomerController")
//@MultipartConfig(maxFileSize=16177215)//upload file size upto 16 MB
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
	//image properties
	private boolean isMultipart;
	private String filePath;
	private int maxFileSize=5000*1024;
	private int maxMemSize=5000*1024;
	private File file;
	
	public void init(){
		filePath=getServletContext().getInitParameter("file-upload");
	}
	
	
    public CustomerController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @throws ServletException 
	 * @throws IOException 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    /**
     * method to get the first registration form value
     * @param request
     * @return
     * @throws IOException
     * @throws ServletException
     */
    public Customer page1(HttpServletRequest request) throws IOException, ServletException{//method to get first form value
    	
    	//File f = new File(request.getParameter("photo"));
    	//FileInputStream fis = new FileInputStream(f);
    	HttpSession  session = request.getSession();
    	Customer c1 = new Customer();
    	 isMultipart=ServletFileUpload.isMultipartContent(request);
		 if(!isMultipart){
			System.out.println("Its not a multipart form"); 
		 }
		DiskFileItemFactory factory=new DiskFileItemFactory();
		factory.setSizeThreshold(maxMemSize);
		factory.setRepository(new File("E:\\temp"));
		
		ServletFileUpload upload=new ServletFileUpload(factory);
		upload.setSizeMax(maxFileSize);

		try{
			List fileItems=upload.parseRequest(request);
			
			Iterator i=fileItems.iterator();
			
			while(i.hasNext()){
				FileItem fi=(FileItem)i.next();
				if(!fi.isFormField()){
					String fieldName=fi.getFieldName();
					String fileName=fi.getName();
					String contentType=fi.getContentType();
					boolean isInMemory=fi.isInMemory();
					long sizeInBytes=fi.getSize();
					Random random = new Random(System.nanoTime());
					int userId = random.nextInt(10000000);
					
					//System.out.println(fieldName+" "+fileName+" "+contentType+" "+isInMemory+" "+sizeInBytes);
					//write the file logic
	
					if(fileName.lastIndexOf("\\")>=0){
						file=new File(filePath+userId+fileName.substring(fileName.lastIndexOf("\\")));
											
					}else{
						file=new File(filePath+userId+fileName.substring(fileName.lastIndexOf("\\")+1));
					}
					fi.write(file);
					c1.setPhoto(userId+fileName);
					
				}else{
					if(fi.getFieldName().equals("fname")){
						c1.setFname(fi.getString());
					}
					if(fi.getFieldName().equals("lname")){
						c1.setLname(fi.getString());
					}
					if(fi.getFieldName().equals("faname")){
						c1.setFaname(fi.getString());
					}
					if(fi.getFieldName().equals("gender")){
						c1.setGender(fi.getString());
					}
					if(fi.getFieldName().equals("date")){
						c1.setDate(fi.getString());
					}
					if(fi.getFieldName().equals("email")){
						c1.setEmail(fi.getString());
					}
					if(fi.getFieldName().equals("phone")){
						//c1.setPhone(Long.parseLong(fi.getString()));
						c1.setPhone(Long.parseLong(fi.getString()));
					}
					if(fi.getFieldName().equals("add")){
						c1.setAdd(fi.getString());
					}
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
    	
		return c1;
    	
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	doPost(req, resp);
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BankingDAO dao=BankingDAOFactory.getInstance();
		PrintWriter pr = response.getWriter();
		String id = request.getParameter("id");
		HttpSession  session = request.getSession();
		switch(id){
		
		case "customer":
			int sAccount=(int)session.getAttribute("account");
			if(sAccount!=0){
				RequestDispatcher rd2 = request.getRequestDispatcher("loginSuccess.jsp");
				rd2.forward(request, response);
			}
			else{
				RequestDispatcher rd2 = request.getRequestDispatcher("sessionExp.jsp");
				rd2.forward(request, response);
			}
				
			break;
		case "sessn":
			session.setAttribute("account", 0);
			RequestDispatcher rd2 = request.getRequestDispatcher("login.jsp");
			rd2.forward(request, response);
			
			break;
		
		case  "page1":
			Customer c1=null;
			c1=page1(request);//callling method page1
			session.setAttribute("customer", c1);
			
			RequestDispatcher rd=request.getRequestDispatcher("register1.jsp");
			rd.forward(request, response);
			break;
		case "page2":
			Customer cus =page2(request,session);//calling method page2
			try{
				Connection con = DbUtil.getConnection();//database connection
				
					PreparedStatement ps1 = con.prepareStatement("select adharNo,panNo from customers ");
					ResultSet rs = ps1.executeQuery();
					long adharNo1=0;
					String panNo1="";
					while(rs.next()){
						long adharNo= rs.getLong(1);
						String panNo=rs.getString(2);
						if(adharNo==cus.getAdhar()){
							 adharNo1=rs.getLong(1);
							
						}
						if(panNo.equalsIgnoreCase(cus.getPan())){
							 panNo1=rs.getString(2);
						}
					}
					if(adharNo1!=0 && panNo1 !=null && panNo1.equalsIgnoreCase(cus.getPan()) && adharNo1==cus.getAdhar()){
						//pr.println("Adhar Number  " + adharNo1 + " alredy exist " );
						//pr.println("Pan Number  " + panNo1 + " alredy exist" );
						pr.println("<script type=\"text/javascript\">window.alert('Adhar Number and Pan Number alredy Exist');</script>");
						RequestDispatcher rd3 = request.getRequestDispatcher("register1.jsp");
						rd3.include(request, response);
					}
					
					else if(adharNo1!=0 &&  adharNo1==cus.getAdhar()){
						//pr.println("Adhar Number + " + adharNo1 + " alredy exist " );
						pr.println("<script type=\"text/javascript\">window.alert('Adhar Number already exist');</script>");
						RequestDispatcher rd3 = request.getRequestDispatcher("register1.jsp");
						rd3.include(request, response);
						
					}
					else if(panNo1 !=null && panNo1.equalsIgnoreCase(cus.getPan())){
						//pr.println("Pan Number + " + panNo1 + " alredy exist" );
						pr.println("<script type=\"text/javascript\">window.alert('Pan number already exist ');</script>");
						RequestDispatcher rd3 = request.getRequestDispatcher("register1.jsp");
						rd3.include(request, response);
					}
					else{
						//insert
						Map mp=dao.createAccount(cus);
						request.setAttribute("map", mp);
						int i=(int)mp.get("result");
						if(i>0){
							RequestDispatcher rd1 =request.getRequestDispatcher("regSuccess.jsp");
							rd1.forward(request, response);
							
						}
					}	
					
			}catch(Exception e){
				System.out.println(e);
				
			}
			break;
		case "log":
			int userId = Integer.parseInt(request.getParameter("uid"));
			String pass= request.getParameter("pass");
			Map map=dao.login(userId, pass);
			int account =0;
			String fname="";
			String lname="";
			int statusA=0;
			try{
			
				account = (int)map.get("account");
				fname = (String)map.get("fname");
				lname = (String)map.get("lname");
				statusA = (int)map.get("status");
			
				if(account>0 && statusA==1){
					session.setAttribute("account", account);
					session.setAttribute("fname", fname);
					session.setAttribute("lname", lname);
					RequestDispatcher rd4 = request.getRequestDispatcher("loginSuccess.jsp");
					rd4.include(request, response);
				}else{
					pr.println("<font color='red' size=5><center>Account haven't activated yet</center></font>");
					
					RequestDispatcher rd3 = request.getRequestDispatcher("login.jsp");
					rd3.include(request, response);
				}
			}catch(Exception e){
				pr.println("<font color='red' size=5><center>invalid user name or password</center></font>");
				
				RequestDispatcher rd3 = request.getRequestDispatcher("login.jsp");
				rd3.include(request, response);
			}
			break;
			
		case "forgotPass":
				long accountF = Long.parseLong(request.getParameter("account"));
				String sq = request.getParameter("sq");
				String ans = request.getParameter("ans");
				String rePass = request.getParameter("rePass");
				boolean status = dao.forgotPass(sq, ans,accountF);
				try{
					
					if(status){
						Connection con = DbUtil.getConnection();//database connection
						String query1 = "UPDATE `customers` SET `password`="+rePass+" where accountNo=(?)";
						PreparedStatement ps1 = con.prepareStatement(query1);
						ps1.setLong(1, accountF);
						ps1.executeUpdate();
								pr.println("<font color='green' size=5><center>successfully Updated</center></font>");
						
								RequestDispatcher rd3 = request.getRequestDispatcher("forgotPass.jsp");
								rd3.include(request, response);
						}else{ 
							pr.println("<font color='red' size=5><center>invalid Security Question or Answer</center></font>");
							
							RequestDispatcher rd3 = request.getRequestDispatcher("forgotPass.jsp");
							rd3.include(request, response);
						}
					
				}catch(Exception e){
					System.out.println(e);
				}
				
			break;
		case "forgotUid":
				long accountU = Long.parseLong(request.getParameter("account"));
				String passU = request.getParameter("pass");
				Map mapU = dao.forgotUid(accountU, passU);
				try{
					int uId = (int)mapU.get("userId");
					int accountUd = (int)mapU.get("account"); 
					boolean result = (boolean)mapU.get("result");
					if(result){
					session.setAttribute("uId", uId);
					session.setAttribute("accountUd", accountUd);
					RequestDispatcher rd4 = request.getRequestDispatcher("displayUid.jsp");
					rd4.forward(request, response);
					}
				}catch(Exception e){
					pr.println("<font color='red' size=5><center>invalid Security Question or Answer</center></font>");
					RequestDispatcher rd4 = request.getRequestDispatcher("forgotUid.jsp");
					rd4.include(request, response);
				}
			break;
			
		case "mRecharge":
			long mobNum = Long.parseLong(request.getParameter("mNum"));
			String netType = request.getParameter("s");
			double amountR = Double.parseDouble(request.getParameter("amount"));
			String dateR = request.getParameter("dat");
//			System.out.println(mobNum+""+netType+""+amountR+""+dateR);
			session.setAttribute("mobNum", mobNum);
			session.setAttribute("netType", netType);
			session.setAttribute("amountR", amountR);
			session.setAttribute("dateR", dateR);
			
			RequestDispatcher rdp = request.getRequestDispatcher("rechargeType.jsp");
			rdp.include(request, response);
		
			break;
			
		case "payment":
			String cardType = request.getParameter("r");
//			System.out.println(cardType);
			session.setAttribute("cardType", cardType);
			RequestDispatcher rdpay = request.getRequestDispatcher("payment1.jsp");
			rdpay.include(request, response);
		
			break;
			
		case "payment1":
			MobileRecharge mob = mobRec(request, session);
			int idM =0;
			try{
				Connection con = DbUtil.getConnection();
				String sql = "SELECT * FROM `card_detail` WHERE card_num=(?)";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setLong(1, mob.getCardNo());
				ResultSet rs = ps.executeQuery();
				if(rs.next()){
					idM = rs.getInt(1);
					if(rs.getString(2).equalsIgnoreCase(mob.getName()) && rs.getLong(3)==mob.getCardNo() && rs.getInt(4)==mob.getCcvNo()
						&& rs.getInt(5)==mob.getvM() && rs.getInt(6)==mob.getvY() && rs.getInt(7)==mob.getPin()){
							boolean result = dao.recSuccess(idM, mob.getAmountR());
							if(result){
								dao.mobRechargeInsert(mob);
							}else{
								pr.println("<font color='red' size=5><center>Insufficient amount</center></font>");
								RequestDispatcher rdR = request.getRequestDispatcher("payment1.jsp");
								rdR.include(request, response);
							}
							
						RequestDispatcher rdR = request.getRequestDispatcher("rechargeSuccess.jsp");
						rdR.include(request, response);
						
					}else{
						pr.println("<font color='red' size=5><center>invalid Card Details</center></font>");
						RequestDispatcher rdR = request.getRequestDispatcher("payment1.jsp");
						rdR.include(request, response);
					}
				}else{
					pr.println("<font color='red' size=5><center>invalid Card Number</center></font>");
					RequestDispatcher rdR = request.getRequestDispatcher("payment1.jsp");
					rdR.include(request, response);
				}
					
			}catch(Exception e){
				e.printStackTrace();
			}
			
		
			break;
			
		case "mRechSameBank":
			MobileRecSameBank mob1 = mobRecS(request,session);
				try{
					String details = "moblie Recharge";
					String password = request.getParameter("pass");
					int accountSb = (int)session.getAttribute("account");
					String fnameM = (String)session.getAttribute("fname");
					String lnameM = (String)session.getAttribute("lname");
					Connection con = DbUtil.getConnection();
					String query = "SELECT `password` FROM `customers` WHERE accountNo=(?)";
					PreparedStatement ps = con.prepareStatement(query);
					ps.setInt(1, accountSb);
					ResultSet rs = ps.executeQuery();
					if(rs.next()){
						if(password.equals(rs.getString(1))){
							boolean result1 = dao.recSuccessSamebank(accountSb, mob1.getAmount());
							boolean rslt = dao.withdrawlMoney(accountSb, fnameM, lnameM, mob1.getAmount(), mob1.getDate(), details);
							if(result1 && rslt){
								dao.mobRecSameBank(mob1);
					
								RequestDispatcher rdR = request.getRequestDispatcher("rechargeSuccess.jsp");
								rdR.include(request, response);
							}else{
								pr.println("<font color='red' size=5><center>Insufficient amount</center></font>");
								RequestDispatcher rdR = request.getRequestDispatcher("rechargeSameBank.jsp");
								rdR.include(request, response);
							}
						}else{
							pr.println("<font color='red' size=5><center>Password doesnot match</center></font>");
							RequestDispatcher rdR = request.getRequestDispatcher("rechargeSameBank.jsp");
							rdR.include(request, response);
						}
					}
					
				}catch(Exception e){
					e.printStackTrace();
				}
			break;
			
		case "nftTransfer":
			try{
					String fNameS="";
					String lNameS="";
					String details1 = "online Transfer";
					int sAccountT = (int)session.getAttribute("account");
					String bName = request.getParameter("bName");
					String lName = request.getParameter("lName");
					int bAccount = Integer.parseInt( request.getParameter("bNum"));
					String date = request.getParameter("dat");
					double  amount = Double.parseDouble(request.getParameter("amount"));
					Map mpV = dao.validateAccount(bAccount);
					int accountV = (int)mpV.get("account");
					String fNameV = (String)mpV.get("fName");
					String lNameV = (String)mpV.get("lName");
					if(bAccount==accountV && bName.equalsIgnoreCase(fNameV) && lName.equalsIgnoreCase(lNameV)){
					//System.out.println(sAccountT+""+bName+""+bAccount+""+date+""+amount);
						Map mapa = dao.transfer(sAccountT,bAccount, amount); 
						boolean resultT=(boolean)mapa.get("result");
						String message=(String)mapa.get("msg");
						if(resultT){
							Map mp = dao.depositMoney(bAccount, bName,lName, amount, date);
							int i = (int)mp.get("result");
							Connection con = DbUtil.getConnection();
							String query = "select firstName,lastName from customers where accountNo = (?)";
							PreparedStatement ps = con.prepareStatement(query);
							ps.setInt(1, sAccountT);
							ResultSet rs = ps.executeQuery();
							if(rs.next()){
								fNameS = rs.getString(1);
								lNameS = rs.getString(2);
							}
							boolean statusT = dao.withdrawlMoney(sAccountT, fNameS, lNameS, amount, date, details1);
							if(i>0 && statusT){

							//System.out.println("successfully transfer amount");
								RequestDispatcher rdT = request.getRequestDispatcher("neftTransfer.jsp");
								rdT.include(request, response);
								pr.println("<script type=\"text/javascript\">alert('"+message+"');</script>");
							}
					
						}else{
				
							RequestDispatcher rdT = request.getRequestDispatcher("neftTransfer.jsp");
							rdT.include(request, response);
							pr.println("<script type=\"text/javascript\">alert('"+message+"');</script>");
							
						}
					}else{
						RequestDispatcher rdT = request.getRequestDispatcher("neftTransfer.jsp");
						rdT.include(request, response);
						pr.println("<script type=\"text/javascript\">alert('Enter valid account number or name');</script>");
					}
					
			}catch(Exception e){
				RequestDispatcher rdT = request.getRequestDispatcher("neftTransfer.jsp");
				rdT.include(request, response);
				pr.println("<script type=\"text/javascript\">alert(' Account not activated yet ');</script>");
			}
				
			break;
		case "close":
			try{
				//form value
				String fnameC = request.getParameter("fname");
				String lnameC = request.getParameter("lname");
				String fanameC = request.getParameter("faname");
				int accountC = Integer.parseInt(request.getParameter("account"));
				String dobC = request.getParameter("date");
				int uidC = Integer.parseInt(request.getParameter("uid"));
				//calling closeAccount method
				Map mp = dao.closeAccount(accountC);
				//database value
				String fnameDb = (String)mp.get("fnameC");
				String lnameDb = (String)mp.get("lnameC");
				String fanameDb = (String)mp.get("fanameC");
				String dobDb = (String)mp.get("dobC");
				int uidDb = (int)mp.get("uidC");
				int accountDb = (int)mp.get("accountC");
				if(fnameC.equalsIgnoreCase(fnameDb) && lnameC.equalsIgnoreCase(lnameDb) && fanameC.equalsIgnoreCase(fanameDb) && accountC==accountDb && dobC.equalsIgnoreCase(dobDb) && uidC==uidDb){
					dao.accountCloseD(accountC);
					boolean result = dao.closeAccountD(accountC);
					if(result){
						RequestDispatcher rdT = request.getRequestDispatcher("closeAccount.jsp");
						rdT.include(request, response);
						pr.println("<script type=\"text/javascript\">alert(' Your Account has been successfully close ');</script>");
					}
				}else{
					RequestDispatcher rdT = request.getRequestDispatcher("closeAccount.jsp");
					rdT.include(request, response);
					pr.println("<script type=\"text/javascript\">alert(' Information is not correct ');</script>");
				}
				
			}catch(Exception e){
				RequestDispatcher rdT = request.getRequestDispatcher("closeAccount.jsp");
				rdT.include(request, response);
				pr.println("<script type=\"text/javascript\">alert(' Invalid Account number ');</script>");
			}
				
			break;
			
		}
	}
		
	/**
	 * mathod to get 2nd page registration form value 
	 * @param request
	 * @param session
	 * @return
	 */
	public Customer page2(HttpServletRequest request,HttpSession session){//method to get 2nd form value
		Customer cus= new Customer();
		cus=(Customer)session.getAttribute("customer");
		cus.setState(request.getParameter("state"));
		cus.setCity(request.getParameter("city"));
		cus.setAccount(request.getParameter("account"));
		cus.setAdhar(Long.parseLong(request.getParameter("adhar")));
		cus.setPan(request.getParameter("pan"));
		Random random = new Random(System.nanoTime());
		int userId = random.nextInt(10000000);
		cus.setUserId(userId);
		cus.setPass(request.getParameter("pass"));
		cus.setCpass(request.getParameter("cpass"));
		cus.setSq(request.getParameter("sq"));
		cus.setAns(request.getParameter("ans"));
		int accountNum= random.nextInt(1000000000);
		cus.setAccountNum(accountNum);
		return cus;
	}
	
	/**
	 * method to get mobile recharge form value
	 * @param request
	 * @param session
	 * @return
	 */
	public MobileRecharge mobRec(HttpServletRequest request,HttpSession session){
			MobileRecharge mob = new MobileRecharge();
			
			long mobNum = (long)session.getAttribute("mobNum");
			mob.setMobNum(mobNum);
			String netTpye = (String)session.getAttribute("netType");
			mob.setNetTpye(netTpye);
			double amountR = (double)session.getAttribute("amountR");
			mob.setAmountR(amountR);
			String dateR = (String)session.getAttribute("dateR");
			mob.setDateR(dateR);
			String cardType =(String)session.getAttribute("cardType");
			mob.setCardType(cardType);
			String name = request.getParameter("t1");
			mob.setName(name);
			long cardNo = Long.parseLong(request.getParameter("t2"));
			mob.setCardNo(cardNo);
			int ccvNo = Integer.parseInt(request.getParameter("t3"));
			mob.setCcvNo(ccvNo);
			int vM = Integer.parseInt(request.getParameter("ccExpiryMonth"));
			mob.setvM(vM);
			int vY = Integer.parseInt(request.getParameter("ccExpiryYear"));
			mob.setvY(vY);
			int pin = Integer.parseInt(request.getParameter("t5"));
			mob.setPin(pin);
		
		return mob;
		
		
	}
	
	public MobileRecSameBank mobRecS(HttpServletRequest request,HttpSession session){
		MobileRecSameBank mob1 = new MobileRecSameBank();
		
		long mobNum = (long)session.getAttribute("mobNum");
		mob1.setMobRec(mobNum);
		String netTpye = (String)session.getAttribute("netType");
		mob1.setNetType(netTpye);
		double amountR = (double)session.getAttribute("amountR");
		mob1.setAmount(amountR);
		String dateR = (String)session.getAttribute("dateR");
		mob1.setDate(dateR);
		
		return mob1;
	}

}
