package cn.edu.bjtu.sad.model;

public class User {
	private int user_id;
	private String user_name;
	private String password;
	private int right_id;
	private String phone_number;
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getRight_id() {
		return right_id;
	}
	public void setRight_id(int right_id) {
		this.right_id = right_id;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
}
