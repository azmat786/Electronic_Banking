package com.e_banking.web.domain;

public class MobileRecSameBank {
	long mobRec;
	String netType;
	double amount;
	String date;
	public long getMobRec() {
		return mobRec;
	}
	public void setMobRec(long mobRec) {
		this.mobRec = mobRec;
	}
	public String getNetType() {
		return netType;
	}
	public void setNetType(String netType) {
		this.netType = netType;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
}
