package cn.edu.bjtu.sad.dao;

import java.util.ArrayList;

import cn.edu.bjtu.sad.model.User;

public interface UserDao {
	public boolean deleteUser(String user_id);
	public int addUser(User user);
	public ArrayList<User> getUser();
	public User getUser(int user_id);
	
}
