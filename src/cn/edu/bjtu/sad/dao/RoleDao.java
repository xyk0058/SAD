package cn.edu.bjtu.sad.dao;

import java.util.ArrayList;

import cn.edu.bjtu.sad.model.Role;

public interface RoleDao {
	public boolean deleteRole(String role_id);
	public int addRole(Role role);
	public ArrayList<Role> getRole();
	public Role getRole(int role_id);
	
}
