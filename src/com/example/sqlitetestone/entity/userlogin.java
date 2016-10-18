package com.example.sqlitetestone.entity;




//用户登录实体类
public class userlogin {
	//sqlite中是下划线id，_id
	private  int _id;
	private  String username;
	private  String password;
	private  int loginNum;
	private  String loginDateTime;
	
	
	public int get_id() {
		return _id;
	}


	public void set_id(int _id) {
		this._id = _id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public int getLoginNum() {
		return loginNum;
	}


	public void setLoginNum(int loginNum) {
		this.loginNum = loginNum;
	}


	public String getLoginDateTime() {
		return loginDateTime;
	}


	public void setLoginDateTime(String loginDateTime) {
		this.loginDateTime = loginDateTime;
	}


	
	public userlogin() {
		super();
		// TODO Auto-generated constructor stub
	}


	public userlogin(String username, String password, int loginNum,
			String loginDateTime) {
		super();
		this.username = username;
		this.password = password;
		this.loginNum = loginNum;
		this.loginDateTime = loginDateTime;
	}
	

}
