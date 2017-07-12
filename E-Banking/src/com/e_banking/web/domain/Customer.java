package com.e_banking.web.domain;

import java.io.File;

public class Customer {
	 String fname;
	 String lname;
	 String faname;
	 String gender;
	 String date;
	 String email;
	 long phone;
	 String add;
	 String photo;
	 File photo1;
	 String state;
	 String city;
	 String account;
	 long adhar;
	 String pan;
	 String pass;
	 String cpass;
	 String sq;
	 String ans;
	 int userId;
	 int accountNum;
	 
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public long getAdhar() {
		return adhar;
	}
	public void setAdhar(long adhar) {
		this.adhar = adhar;
	}
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getCpass() {
		return cpass;
	}
	public void setCpass(String cpass) {
		this.cpass = cpass;
	}
	public String getSq() {
		return sq;
	}
	public void setSq(String sq) {
		this.sq = sq;
	}
	public String getAns() {
		return ans;
	}
	public void setAns(String ans) {
		this.ans = ans;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getFaname() {
		return faname;
	}
	public void setFaname(String faname) {
		this.faname = faname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhone() {
		return phone;
	}
	@Override
	public String toString() {
		return "Customer [fname=" + fname + ", lname=" + lname + ", faname=" + faname + ", gender=" + gender + ", date="
				+ date + ", email=" + email + ", phone=" + phone + ", add=" + add + ", photo=" + photo + ", state="
				+ state + ", city=" + city + ", account=" + account + ", adhar=" + adhar + ", pan=" + pan + ", pass="
				+ pass + ", cpass=" + cpass + ", sq=" + sq + ", ans=" + ans + ", userId=" + userId + ", accountNum="
				+ accountNum + "]";
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getAccountNum() {
		return accountNum;
	}
	public void setAccountNum(int accountNum) {
		this.accountNum = accountNum;
	}
	public void setPhone(long d) {
		this.phone = d;
	}
	public String getAdd() {
		return add;
	}
	public void setAdd(String add) {
		this.add = add;
	}
	
	
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String is) {
		this.photo = is;
	}
	public File getPhoto1() {
		return photo1;
	}
	public void setPhoto1(File f) {
		this.photo1 = f;
	}
}
