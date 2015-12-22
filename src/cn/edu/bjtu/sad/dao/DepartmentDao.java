package cn.edu.bjtu.sad.dao;

import java.util.List;

import cn.edu.bjtu.sad.model.Department;

public interface DepartmentDao {
	public boolean deleteDepartment(String department_id);
	public int addDepartment(Department dep);
	public boolean updateDepartment(Department dep);
	public List<Department> getDepartment();
	
}
