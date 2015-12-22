package cn.edu.bjtu.sad.model;

/**
 * ErrorList class description
 * This Class is the class Entity mapping ErrorList Table.
 * Include all attributes and all get/set function.
 * @author sunshine
 */
public class ErrorList {
	private int error_id;
	private String error_info;
	private int error_type;
	private String user_action;
	public int getError_id() {
		return error_id;
	}
	public void setError_id(int error_id) {
		this.error_id = error_id;
	}
	public String getError_info() {
		return error_info;
	}
	public void setError_info(String error_info) {
		this.error_info = error_info;
	}
	public int getError_type() {
		return error_type;
	}
	public void setError_type(int error_type) {
		this.error_type = error_type;
	}
	public String getUser_action() {
		return user_action;
	}
	public void setUser_action(String user_action) {
		this.user_action = user_action;
	}
}
