package com.etc.entity;
/**
* @author hyh
* @version 创建时间：2021年5月27日 上午9:58:21
*/
public class User {
    private int id;
    private String account;
    private String password;
    private String power;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPower() {
		return power;
	}
	public void setPower(String power) {
		this.power = power;
	}
	public User(int id, String account, String password, String power) {
		this.id = id;
		this.account = account;
		this.password = password;
		this.power = power;
	}
	public User() {
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", account=" + account + ", password=" + password + ", power=" + power + "]";
	}
    
}
