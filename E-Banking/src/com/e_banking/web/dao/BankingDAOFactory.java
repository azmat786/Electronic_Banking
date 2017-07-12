package com.e_banking.web.dao;

public class BankingDAOFactory {
	public static BankingDAO getInstance(){
		return new BankingDAOImpl();
	}
}
