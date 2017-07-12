package com.e_banking.web.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.e_banking.web.domain.Customer;
import com.e_banking.web.domain.MobileRecSameBank;
import com.e_banking.web.domain.MobileRecharge;
import com.e_banking.web.util.DbUtil;

public class BankingDAOImpl  implements BankingDAO{
	/* (non-Javadoc)
	 * method to create Account
	 * @see com.e_banking.web.dao.BankingDAO#createAccount(com.e_banking.web.domain.Customer)
	 */
	@Override
	public Map createAccount(Customer cus) {
		// TODO Auto-generated method stub
		Map map=null;
		try{
		Connection con = DbUtil.getConnection();
		String query="INSERT INTO `customers`(`firstName`, `lastName`, `fatherName`, `gender`, `DOB`, `e-mail`, `phoneNo`, `address`, `photo`, `state`, `city`, `type_of_acount`, `adharNo`, `panNo`, `userId`, `password`, `security_question`, `answer`, `accountNo`, `amount`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1,cus.getFname());
			ps.setString(2, cus.getLname());
			ps.setString(3,cus.getFaname());
			ps.setString(4, cus.getGender());
			ps.setString(5, cus.getDate());
			ps.setString(6, cus.getEmail());
			ps.setLong(7, cus.getPhone());
			ps.setString(8, cus.getAdd());
			//ps.setBinaryStream(9, cus.getPhoto(), (int)cus.getPhoto1().length());
			//ps.setBlob(9, cus.getPhoto());
			ps.setString(9, cus.getPhoto());
			ps.setString(10, cus.getState());
			ps.setString(11, cus.getCity());
			ps.setString(12, cus.getAccount());
			ps.setLong(13, cus.getAdhar());
			ps.setString(14, cus.getPan());
			ps.setInt(15, cus.getUserId());
			ps.setString(16, cus.getPass());
			ps.setString(17, cus.getSq());
			ps.setString(18, cus.getAns());
			ps.setInt(19, cus.getAccountNum());
			ps.setDouble(20, 0.0);
			int i=ps.executeUpdate();
			//setting value for the successfully open acccountso
			map =new HashMap();
			map.put("name", cus.getFname());
			map.put("userId", cus.getUserId());
			map.put("accountNo", cus.getAccountNum());
			map.put("result", i);
		}catch(Exception e){
			System.out.println("Problem in database:"+e);
		}
			
		return map;
	}

	/* (non-Javadoc)
	 * method for userLogin
	 * @see com.e_banking.web.dao.BankingDAO#login(int, java.lang.String)
	 */
	
	@Override
	public Map login(int userId, String pass) {
		// TODO Auto-generated method stub
		Map mp = new HashMap();
		try{
			Connection con = DbUtil.getConnection();
			String loginQuery="select accountNo,firstName,lastName,status from customers where userId=(?) and password=(?)";
			PreparedStatement pr = con.prepareStatement(loginQuery);
			pr.setInt(1, userId);
			pr.setString(2, pass);
			ResultSet rs = pr.executeQuery();
			if(rs.next()){
				
				 mp.put("account", rs.getObject(1));
				 mp.put("fname", rs.getObject(2));
				 mp.put("lname", rs.getObject(3));
				 mp.put("status", rs.getObject(4));
				 	
			}
			
		}catch(Exception e){
			System.out.println("problem in database"+e);
		}
		return mp;
	}

	/* (non-Javadoc)
	 * money deposit from admin panel
	 * @see com.e_banking.web.dao.BankingDAO#depositMoney(int, java.lang.String, java.lang.String, double, java.lang.String)
	 */
	@Override
	public Map depositMoney(int account, String name, String lname, double amount, String date) {
		// TODO Auto-generated method stub
		Map map=null;
		map = new HashMap();
		try{
			Connection con = DbUtil.getConnection();
			
			//String query="INSERT INTO `deposits`( `accountNo`, `name`, `lname`, `amount`, `date`) VALUES (?,?,?,?,?)";
			String query1 = "INSERT INTO `dep_withdrawl`(`accountNo`, `name`, `lname`, `amount`, `date`, `description`, `details`) VALUES (?,?,?,?,?,?,?)";
			//PreparedStatement pr = con.prepareStatement(query);
			PreparedStatement pr = con.prepareStatement(query1);
			pr.setInt(1, account);
			pr.setString(2, name);
			pr.setString(3, lname);
			pr.setDouble(4, amount);
			pr.setString(5, date);
			pr.setString(6,"Credit");
			pr.setString(7, "online Transfer");
			
			int i=pr.executeUpdate();
			map.put("result", i);
		
	}catch(Exception e){
		System.out.println("problem in database");

	}
	return map;
}

	/* (non-Javadoc)
	 * AdminLogin Method
	 * @see com.e_banking.web.dao.BankingDAO#adminLogin(java.lang.String, java.lang.String)
	 */
	@Override
	public Map adminLogin(String username, String password) {
		// TODO Auto-generated method stub
		Map map = new HashMap();
		try{
			Connection con = DbUtil.getConnection();
			
			String query = "SELECT  `username`, `password` FROM `admin` where username=(?) and password=(?)";
			PreparedStatement pr = con.prepareStatement(query);
			pr.setString(1, username);
			pr.setString(2, password);
			ResultSet rs = pr.executeQuery();
			if(rs.next()){
				map.put("username", rs.getString(1));
			}
			/**if(user.equals(username)){
				return true;
			}*/
			
		}catch(Exception e){
			System.out.println("problem in database");
		}
		return map;
	}

	/* (non-Javadoc)
	 * Account Detail Admin panel
	 * @see com.e_banking.web.dao.BankingDAO#accountdetail(long)
	 */
	@Override
	public Map accountdetail(long accountNo) {
		// TODO Auto-generated method stub
		Map map = new HashMap();
		try{
			Connection con = DbUtil.getConnection();
			String query = "select firstName, lastName, fatherName, photo, accountNo, amount from customers  where accountNo=?";
			PreparedStatement pr = con.prepareStatement(query);
			//byte b[];
			//Blob blob;
			pr.setLong(1, accountNo);
			ResultSet rs = pr.executeQuery();
			if(rs.next()){
						
				//blob = rs.getBlob(4);
				//b = blob.getBytes(1, (int)blob.length());
				map.put("fname", rs.getString(1));
				map.put("lname", rs.getString(2));
				map.put("faName",rs.getString(3));
				map.put("photo", rs.getString(4));
				map.put("account", rs.getInt(5));
				map.put("amount", rs.getDouble(6));
			}
		}catch(Exception e){
			System.out.println(e);
		}
		return map;
	}

	/* (non-Javadoc)
	 * validate account checking wheather account is present or not
	 * @see com.e_banking.web.dao.BankingDAO#validateAccount(int)
	 */
	@Override
	public Map validateAccount(int bAccount) {
		// TODO Auto-generated method stub
		Map mp = new HashMap();
		try{
			Connection con = DbUtil.getConnection();
			String query = "select accountNo,firstName,lastName from customers where accountNo=(?) and status=(?) ";
			PreparedStatement pr = con.prepareStatement(query);
			pr.setInt(1, bAccount);
			pr.setInt(2, 1);
			ResultSet rs = pr.executeQuery();
			if(rs.next()){
				mp.put("account", rs.getInt(1));
				mp.put("fName", rs.getString(2));
				mp.put("lName",rs.getString(3));
				return mp;
			}
				
		}catch(Exception e){
			System.out.println(e);
		}
		return mp;
	}

	/* (non-Javadoc)
	 * checking withdrawal amount is sufficient or not
	 * @see com.e_banking.web.dao.BankingDAO#validateWithdrawl(int, double)
	 */
	@Override
	public Map validateWithdrawl(int account, double amount) {
		// TODO Auto-generated method stub
			double amountCheck=0.0;
			Map mp = new HashMap();
		try{
			Connection con = DbUtil.getConnection();
			String query = "select amount from customers where accountNo=(?)";
			PreparedStatement pr = con.prepareStatement(query);
			pr.setInt(1, account);
			ResultSet rs = pr.executeQuery();
			if(rs.next()){
				amountCheck = rs.getDouble(1);
				if(amountCheck>=amount){
					mp.put("amountK", amountCheck);
					mp.put("result", true);
				}else{
					mp.put("amountK", amountCheck);
					mp.put("result", false);
				}
			}
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
		return mp;
	}

	/* (non-Javadoc)
	 * transfer amount logic from 1 account to another
	 * @see com.e_banking.web.dao.BankingDAO#transfer(int, int, double)
	 */
	@Override
	public Map transfer(int sAccount, int dAccount, double dAmount) {
		// TODO Auto-generated method stub
		Map mp = new HashMap(); 
		double sa=0.0,da=0.0;
			//first account
			Map map = validateWithdrawl( sAccount, dAmount);
			boolean status = (boolean)map.get("result");
			if(status){
				double amountR = (double)map.get("amountK");
				sa = amountR-dAmount;
				boolean t=depositT(sAccount,sa);
				map = validateWithdrawl( dAccount, dAmount);
				/**if(!(boolean)map.get("reuslt")){
					mp.put("result", false);
					mp.put("msg", "Insuffiecient Balance!!");
					return mp;
				}**/
				double am = (double)map.get("amountK");
				da=am+dAmount;
				boolean s=depositT(dAccount,da);
				if(s&&t){
					mp.put("result", true);
					mp.put("msg", "Successfull Transfered");
					return  mp;
				}
			}else{
				mp.put("result", false);
				mp.put("msg", "Insuffiecient Balance!!");
				return mp;
			}
		return mp;
	}

	/* (non-Javadoc)
	 * updating amount from the account is transfer
	 * @see com.e_banking.web.dao.BankingDAO#depositT(int, double)
	 */
	@Override
	public boolean depositT(int accountT, double amountT) {
		// TODO Auto-generated method stub
		try{
		Connection con = DbUtil.getConnection();
		String query = "UPDATE `customers` SET `amount`="+amountT+" WHERE accountNo=(?)";
		PreparedStatement pr = con.prepareStatement(query);
		pr.setInt(1, accountT);
		int i=pr.executeUpdate();
		if(i>0)
			return true;
		}catch(Exception e){
			System.out.println(e);
		}
		return false;
	}

	/* (non-Javadoc)
	 * withdrawl amount deatil saved in database
	 * @see com.e_banking.web.dao.BankingDAO#withdrawlMoney(int, java.lang.String, java.lang.String, double, java.lang.String)
	 */
	@Override
	public boolean withdrawlMoney(int accountS, String nameS, String lnameS, double amountS, String date, String details) {
		// TODO Auto-generated method stub
		try{
			Connection con = DbUtil.getConnection();
			
			//String query="INSERT INTO `withdrawl`(`accountNo`, `name`, `lname`, `amount`, `date`) VALUES (?,?,?,?,?)";
			String query="INSERT INTO `dep_withdrawl`(`accountNo`, `name`, `lname`, `amount`, `date`, `description`, `details`) VALUES (?,?,?,?,?,?,?)";
			PreparedStatement pr = con.prepareStatement(query);
			pr.setInt(1, accountS);
			pr.setString(2, nameS);
			pr.setString(3, lnameS);
			pr.setDouble(4, amountS);
			pr.setString(5, date);
			pr.setString(6, "Debit");
			pr.setString(7, details);
			
			int i=pr.executeUpdate();
			if(i>0){
				return true;
			}
		
	}catch(Exception e){
		System.out.println("problem in database");

	}
		return false;
	}

	/* (non-Javadoc)
	 * despositing amount from admin panel
	 * @see com.e_banking.web.dao.BankingDAO#depositAdmin(int, double)
	 */
	@Override
	public boolean depositAdmin(int account, double amount) {
		// TODO Auto-generated method stub
		double amountCheck=0.0;
		double amountUPdate=0.0;
		Map mp = new HashMap();
	try{
		Connection con = DbUtil.getConnection();
		String query = "select amount from customers where accountNo=(?)";
		PreparedStatement pr = con.prepareStatement(query);
		pr.setInt(1, account);
		ResultSet rs = pr.executeQuery();
		if(rs.next()){
			amountCheck = rs.getDouble(1);
			amountUPdate = amount + amountCheck;
			depositT(account, amountUPdate);
		}
	}catch(Exception e){
		System.out.println(e);
	}
	
		return true;
}

	/* (non-Javadoc)
	 * frogot password logic
	 * @see com.e_banking.web.dao.BankingDAO#forgotPass(java.lang.String, java.lang.String, long)
	 */
	@Override
	public boolean forgotPass(String sq, String ans, long account) {
		// TODO Auto-generated method stub
		try{
			Connection con = DbUtil.getConnection();
			String query = "select security_question, answer, accountNo from customers";
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				if((sq.equalsIgnoreCase(rs.getString(1)))&& (ans.equalsIgnoreCase(rs.getString(2))) && account==rs.getLong(3)){
					 return true;
				}
			}
			
			ps.close();
		}catch(Exception e){
			System.out.println(e);
		}
		return false;
	}

	/* (non-Javadoc)
	 * forgot userd id logic
	 * @see com.e_banking.web.dao.BankingDAO#forgotUid(long, java.lang.String)
	 */
	@Override
	public Map forgotUid(long account, String pass) {
		// TODO Auto-generated method stub
		Map mp = new HashMap();
		try{
			Connection con = DbUtil.getConnection();
			String sql = "select userId, accountNo from customers where accountNo=(?) and password=(?)";
			 PreparedStatement ps = con.prepareStatement(sql);
			 ps.setLong(1, account);
			 ps.setString(2, pass);
			 ResultSet rs = ps.executeQuery();
			 if(rs.next()){
				 mp.put("userId", rs.getInt(1));
				 mp.put("account", rs.getInt(2));
				 mp.put("result", true);
			 }
		}catch(Exception e){
			System.out.println(e);
		}
		return mp;
	}

	/* (non-Javadoc)
	 * ministatement logic user panel
	 * @see com.e_banking.web.dao.BankingDAO#miniStat(int)
	 */
	@Override
	public List miniStat(int account) {
		// TODO Auto-generated method stub
		List li = new ArrayList();
		try{
			Connection con = DbUtil.getConnection();
			String query = "SELECT * FROM `dep_withdrawl` WHERE accountNo=(?) order by date ASC ";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, account);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				
				li.add(rs.getDouble(5));
				li.add(rs.getString(6));
				li.add(rs.getString(7));
				li.add(rs.getString(8));
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return li;
	}

	/* (non-Javadoc)
	 * activate account detail from admin panel
	 * @see com.e_banking.web.dao.BankingDAO#activateDis()
	 */
	@Override
	public List activateDis() {
		// TODO Auto-generated method stub
		List li = new ArrayList();
		try{
			Connection con = DbUtil.getConnection();
			String query = "SELECT * FROM `customers` WHERE status=(?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, 0);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				li.add(rs.getString(2));
				li.add(rs.getString(3));
				li.add(rs.getString(4));
				li.add(rs.getString(5));
				li.add(rs.getString(7));
				li.add(rs.getString(9));
				li.add(rs.getString(13));
				li.add(rs.getString(14));
				li.add(rs.getString(15));
				li.add(rs.getInt(20));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return li;
	}

	/* (non-Javadoc)
	 * activate account logic
	 * @see com.e_banking.web.dao.BankingDAO#accountActivate(int)
	 */
	@Override
	public boolean accountActivate(int accountA) {
		// TODO Auto-generated method stub
		try{
			Connection con = DbUtil.getConnection();
			String query = "UPDATE `customers` SET `status`=1 WHERE accountNo=(?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setObject(1, accountA);
			int i = ps.executeUpdate();
			if(i>0){
				return true;
			}
		}catch(Exception e){
			e.printStackTrace();
			System.out.println(e);
		}
		return false;
	}

	/* (non-Javadoc)
	 * to close account user panel
	 * @see com.e_banking.web.dao.BankingDAO#closeAccount(int)
	 */
	@Override
	public Map closeAccount(int accountC) {
		// TODO Auto-generated method stub
		Map mp = new HashMap();
			try{
				Connection con = DbUtil.getConnection();
				String query = "SELECT `firstName`, `lastName`, `fatherName`, `DOB`, `userId`, `accountNo` FROM `customers` WHERE accountNo=(?)";
				PreparedStatement ps = con.prepareStatement(query);
				ps.setInt(1, accountC);
				ResultSet rs = ps.executeQuery();
				if(rs.next()){
					mp.put("fnameC", rs.getString(1));
					mp.put("lnameC", rs.getString(2));
					mp.put("fanameC", rs.getString(3));
					mp.put("dobC", rs.getString(4));
					mp.put("uidC", rs.getInt(5));
					mp.put("accountC", rs.getInt(6));
					
				}
			}catch(Exception e){
				System.out.println(e);
			}
		
		return mp;
	}

	/* (non-Javadoc)
	 * close account logic
	 * @see com.e_banking.web.dao.BankingDAO#closeAccountD(int)
	 */
	@Override
	public boolean closeAccountD(int accountCd) {
		// TODO Auto-generated method stub
			try{
				Connection con = DbUtil.getConnection();
				String query = "DELETE FROM `customers` WHERE accountNo=(?)";
				PreparedStatement ps = con.prepareStatement(query);
				ps.setInt(1, accountCd);
				int i = ps.executeUpdate();
				if(i>0){
					return true;
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		
		return false;
	}

	/* (non-Javadoc)
	 * the account which is already activated 
	 * @see com.e_banking.web.dao.BankingDAO#activatedAccount()
	 */
	@Override
	public List activatedAccount() {
		List li1 = new ArrayList();
		try{
			Connection con = DbUtil.getConnection();
			String query ="SELECT * FROM `customers` WHERE status=(?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, 1);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				li1.add(rs.getString(2));
				li1.add(rs.getString(3));
				li1.add(rs.getString(4));
				li1.add(rs.getString(5));
				li1.add(rs.getString(7));
				li1.add(rs.getLong(8));
				li1.add(rs.getString(9));
				li1.add(rs.getString(11));
				li1.add(rs.getString(12));
				li1.add(rs.getString(13));
				li1.add(rs.getString(14));
				li1.add(rs.getString(15));
				li1.add(rs.getInt(20));
				li1.add(rs.getDouble(21));
				
			}
		}catch(Exception e){
			System.out.println(e);
		}
		
		return li1;
	}

	/* (non-Javadoc)
	 * close account logic to display in database
	 * @see com.e_banking.web.dao.BankingDAO#accountCloseD(int)
	 */
	@Override
	public void accountCloseD(int accountNo) {
		// TODO Auto-generated method stub
			try{
				Connection con = DbUtil.getConnection();
				String query ="SELECT * FROM `customers` WHERE accountNo=(?)";
				PreparedStatement ps = con.prepareStatement(query);
				ps.setInt(1, accountNo);
				ResultSet rs = ps.executeQuery();
				if(rs.next()){
					String fname = rs.getString(2);
					String lname = rs.getString(3);
					String faname = rs.getString(4);
					String gender = rs.getString(5);
					String mail = rs.getString(7);
					long phone = rs.getLong(8);
					String address = rs.getString(9);
					String typeAccount = rs.getString(13);
					int account = rs.getInt(20);
					String sql = "INSERT INTO `account_close`(`firstName`, `lastName`, `fatherName`, `gender`, `e-mail`, `phoneNo`, `address`, `type_of_account`, `accountNo`) VALUES (?,?,?,?,?,?,?,?,?)";
					PreparedStatement ps1 = con.prepareStatement(sql);
					ps1.setString(1, fname);
					ps1.setString(2, lname);
					ps1.setString(3, faname);
					ps1.setString(4, gender);
					ps1.setString(5, mail);
					ps1.setLong(6, phone);
					ps1.setString(7, address);
					ps1.setString(8, typeAccount);
					ps1.setInt(9, account);
					int i = ps1.executeUpdate();
					if(i>0){
						System.out.println("success");
					}
					
				}
			}catch(Exception e){
				System.out.println(e);
			}
	}

	/* (non-Javadoc)
	 * close account Detail to display in admin panel
	 * @see com.e_banking.web.dao.BankingDAO#closeAccountD()
	 */
	@Override
	public List closeAccountD() {
		List li3 = new ArrayList();
		try{
			Connection con = DbUtil.getConnection();
			String query = "SELECT * FROM `account_close`";
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				li3.add(rs.getString(2));
				li3.add(rs.getString(3));
				li3.add(rs.getString(4));
				li3.add(rs.getString(5));
				li3.add(rs.getString(6));
				li3.add(rs.getLong(7));
				li3.add(rs.getString(8));
				li3.add(rs.getString(9));
				li3.add(rs.getInt(10));
				
			}
		}catch(Exception e){
			System.out.println(e);
		}
		return li3;
	}

	@Override
	public void mobRechargeInsert(MobileRecharge mob) {
		try{
			Connection con = DbUtil.getConnection();
			String query = "INSERT INTO `mobrecharge_detail`(`mobNum`, `netType`, `amount`, `date`, `cardType`, `name`, `cardNo`) VALUES (?,?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setLong(1,mob.getMobNum());
			ps.setString(2, mob.getNetTpye());
			ps.setDouble(3, mob.getAmountR());
			ps.setString(4,  mob.getDateR());
			ps.setString(5, mob.getCardType());
			ps.setString(6, mob.getName());
			ps.setLong(7, mob.getCardNo());
			int i = ps.executeUpdate();
			if(i>0){
				System.out.println("success");
			}else{
				System.out.println("fail");
			}
				
			
		}catch(Exception e){
			System.out.println(e);
		}
		
	}

	@Override
	public Map validateMobAmount(int id, double amount) {
		Map mp = new HashMap();
		double amountCheck=0.0;
	try{
		Connection con = DbUtil.getConnection();
		String query = "SELECT `balance` FROM `card_detail` WHERE id=(?)";
		PreparedStatement pr = con.prepareStatement(query);
		pr.setInt(1, id);
		ResultSet rs = pr.executeQuery();
		if(rs.next()){
			amountCheck = rs.getDouble(1);
			if(amountCheck>=amount){
				mp.put("amountK", amountCheck);
				mp.put("result", true);
			}else{
				mp.put("amountK", amountCheck);
				mp.put("result", false);
			}
		}
	}catch(Exception e)
	{
		System.out.println(e);
	}
			
		return mp;
	}

	@Override
	public boolean recSuccess(int id, double amount) {
		Map mp = validateMobAmount(id, amount);
		double amountUpdate=0.0;
		boolean status = (boolean)mp.get("result");
		
		if(status){
			double balance = (double)mp.get("amountK");
			amountUpdate = balance-amount;
			mobRecUpdate(id, amountUpdate);
			return true;
		}else{
			return false;
		}
			
	}

	@Override
	public void mobRecUpdate(int id, double amount) {
		try{
			Connection con = DbUtil.getConnection();
			String query = "UPDATE `card_detail` SET `balance`="+amount+"  WHERE id=(?)";
			PreparedStatement pr = con.prepareStatement(query);
			pr.setInt(1, id);
			pr.executeUpdate();
			
			}catch(Exception e){
				System.out.println(e);
			}
	}

	@Override
	public void mobRecSameBank(MobileRecSameBank mob) {
		
		try{
			Connection con = DbUtil.getConnection();
			String query = "INSERT INTO `rech_same_bank`(`mobNum`, `netType`, `amount`, `date`) VALUES (?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setLong(1, mob.getMobRec());
			ps.setString(2,mob.getNetType());
			ps.setDouble(3, mob.getAmount());
			ps.setString(4, mob.getDate());
			int i = ps.executeUpdate();
			if(i>0){
				System.out.println("success");
				
			}else{
				System.out.println("problen in database");
			}
			
		}catch(Exception e){
			System.out.println(e);
		}
	}

	@Override
	public boolean recSuccessSamebank(int account, double amount) {
		Map mp = validateWithdrawl(account, amount);
		double amountUpdate=0.0;
		boolean status = (boolean)mp.get("result");
		
		if(status){
			double balance = (double)mp.get("amountK");
			amountUpdate = balance-amount;
			depositT(account, amountUpdate);
			return true;
		}else{
			return false;
		}
		
	}
	
}
