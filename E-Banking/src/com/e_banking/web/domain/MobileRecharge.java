package com.e_banking.web.domain;

public class MobileRecharge {
	long mobNum;
	String netTpye;
	double amountR;
	String dateR;
	String cardType;
	String name; 
	long cardNo;
	int ccvNo;
	int vM;
	int vY;
	int pin;
	
	
	public long getMobNum() {
		return mobNum;
	}
	public void setMobNum(long mobNum) {
		this.mobNum = mobNum;
	}
	public String getNetTpye() {
		return netTpye;
	}
	public void setNetTpye(String netTpye) {
		this.netTpye = netTpye;
	}
	public double getAmountR() {
		return amountR;
	}
	public void setAmountR(double amountR) {
		this.amountR = amountR;
	}
	public String getDateR() {
		return dateR;
	}
	public void setDateR(String dateR) {
		this.dateR = dateR;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getCardNo() {
		return cardNo;
	}
	public void setCardNo(long cardNo) {
		this.cardNo = cardNo;
	}
	public int getCcvNo() {
		return ccvNo;
	}
	public void setCcvNo(int ccvNo) {
		this.ccvNo = ccvNo;
	}
	public int getvM() {
		return vM;
	}
	public void setvM(int vM) {
		this.vM = vM;
	}
	public int getvY() {
		return vY;
	}
	public void setvY(int vY) {
		this.vY = vY;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	

}
