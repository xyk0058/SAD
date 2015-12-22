package cn.edu.bjtu.sad.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.bjtu.sad.dao.DepartmentDao;
import cn.edu.bjtu.sad.model.Department;
import cn.edu.bjtu.sad.util.DBUtilFactory;

public class DepartmentDaoImp implements DepartmentDao{
	private static PreparedStatement ps;
	private static ResultSet rs;
	
	public boolean deleteDepartment(String department_id){
		String sql = "delete from department where department_id = ?;";
		
		Connection conn = new DBUtilFactory().getMysqlConn();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, department_id);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			clearUp(conn);
		}
		
		return true;
	}
	
	
	public int addDepartment(Department dep){
		String sql = "INSERT INTO `outpatient`.`dempartment` "
				+ "(`department_name`, `department_detail`, `avaliable_num`) "
				+ "VALUES (?, ?, ?);";
		Connection conn = new DBUtilFactory().getMysqlConn();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, dep.getDepartment_name());
			ps.setString(2, dep.getDepartment_detail());
			ps.setInt(3, dep.getAvaliable_num());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		} finally {
			clearUp(conn);
		}
		int department_id = -1;
		sql = "select max(department_id) as id from department;";
		conn = new DBUtilFactory().getMysqlConn();
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()){
				department_id = rs.getInt("id");
			}else{
				return -1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		} finally {
			clearUp(conn);
		}
		return department_id;
	}
	
	public boolean updateDepartment(Department dep){
		String sql = "UPDATE `outpatient`.`dempartment` "
				+ "SET `department_name`= ?, "
				+ "`department_detail`= ?, `avaliable_num`= ? "
				+ "WHERE (`department_id`= ? );";
		
		Connection conn = new DBUtilFactory().getMysqlConn();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, dep.getDepartment_name());
			ps.setString(2, dep.getDepartment_detail());
			ps.setInt(3, dep.getAvaliable_num());
			ps.setInt(4, dep.getDepartment_id());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			clearUp(conn);
		}
		return true;
	}
	
	public List<Department> getDepartment() {
		
		List<Department> adminList = new ArrayList<Department>();
		String sql = "select * from admin_list";
		
		Connection conn = new DBUtilFactory().getMysqlConn();
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Department department = new Department();
				
				// stupid set method......
				department.setAvaliable_num(rs.getInt("avaliable_num"));
				department.setDepartment_detail(rs.getString("department_deatil"));
				department.setDepartment_id(rs.getInt("department_id"));
				department.setDepartment_name(rs.getString("department_name"));
				
				adminList.add(department);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			clearUp(conn);
		}
		return adminList;
	}
	
	private void clearUp(Connection conn) {
        try {
            if(rs != null){
                rs.close();
            }
            if(ps != null){
                ps.close();
            }
            if(conn != null){
                conn.close();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
