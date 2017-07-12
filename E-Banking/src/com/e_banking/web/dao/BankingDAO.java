package com.e_banking.web.dao;

import java.util.List;
import java.util.Map;

import com.e_banking.web.domain.Customer;
import com.e_banking.web.domain.MobileRecSameBank;
import com.e_banking.web.domain.MobileRecharge;

public interface BankingDAO {
	//to create account
	Map createAccount(Customer cus);
	//user login
	Map login(int userId, String pass);
	//desposit money from admin panel
	Map depositMoney(int account, String name, String lname, double amount, String date);
	//admin login
	Map adminLogin(String username, String password);
	//account detail user panel
	Map accountdetail(long accountNo);
	//validating account to transfer money
	Map validateAccount(int bAccount);
	//checking sufficient amount is there
	Map validateWithdrawl(int account, double amount );
	//transfer amount from 1 account ot other
	Map transfer(int dAccount, int sAccount, double dAmount );
	//deposit money update account
	boolean depositT(int accountT, double amountT);
	//updating amount from admin panel
	boolean depositAdmin(int account, double amount);
	//forgot password 
	boolean forgotPass(String sq, String ans, long account);
	//forgot userid
	Map forgotUid(long account, String pass);
	//inserting data into database when amount will be transfer successful
	boolean withdrawlMoney(int accountS, String nameS, String lnameS, double amountS, String date, String details);
	//mini statement
	List miniStat(int account);
	//activate account detail
	List activateDis();
	//to activate account
	boolean accountActivate(int accountA);
	//close account
	Map closeAccount(int accountC);//to get data from database
	
	boolean closeAccountD(int accountCd);//logic to delete account
	//activated account
	List activatedAccount();
	//close account and insert into closeAccount database
	void accountCloseD(int accountNo);
	//close account detail
	List closeAccountD();
	
	//mobile recharge data insert into database
	void mobRechargeInsert(MobileRecharge mob);
	
	//validate recharge amount
	public Map validateMobAmount(int id, double amount);
	
	//Rechrage successfull
	 public boolean recSuccess(int id, double amount);
	
	//mob recharge update
	public void mobRecUpdate(int id, double amount);
	
	//mob recharge same bank account detail
	public void mobRecSameBank(MobileRecSameBank mob);
	
	//recharge successful from same bank
	public boolean recSuccessSamebank(int account, double amount);
}