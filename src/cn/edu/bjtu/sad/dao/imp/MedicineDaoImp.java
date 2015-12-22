package cn.edu.bjtu.sad.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cn.edu.bjtu.sad.model.Laboratory;
import cn.edu.bjtu.sad.util.DBUtil;

public class MedicineDaoImp {
	private static PreparedStatement ps;
	private static ResultSet rs;
	
	public boolean deleteMedicine(String medicine_id){
		String sql = "delete from medicine where medicine_id = ?;";
		
		Connection conn = new DBUtil().getConn();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, medicine_id);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			clearUp(conn);
		}
		
		return true;
	}
	
	
	public int addMedicine(Laboratory laboratory){
		String sql = "INSERT INTO `outpatient`.`laboratory` "
				+ "(`laboratory_name`, `patient_id`, `doctor_id`, `report`) "
				+ "VALUES (?, ?, ?, ?);";
		Connection conn = new DBUtil().getConn();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, laboratory.getLaboratory_name());
			ps.setInt(2, laboratory.getPatient_id());
			ps.setInt(3, laboratory.getDoctor_id());
			ps.setString(4, laboratory.getReport());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		} finally {
			clearUp(conn);
		}
		int laboratory_id = -1;
		sql = "select max(laboratory_id) as id from laboratory;";
		conn = new DBUtil().getConn();
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()){
				laboratory_id = rs.getInt("id");
			}else{
				return -1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		} finally {
			clearUp(conn);
		}
		return laboratory_id;
	}
	
	
	public ArrayList<Laboratory> getLaboratoryList () {
		ArrayList<Laboratory> list = new ArrayList<Laboratory>();
		String sql = "select * from laboratory;";
		Connection conn = new DBUtil().getConn();
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Laboratory laboratory = new Laboratory();
				// stupid set method......
				laboratory.setDoctor_id(rs.getInt("doctor_id"));
				laboratory.setLaboratory_id(rs.getInt("laboratory_id"));
				laboratory.setLaboratory_name(rs.getString("laboratory_name"));
				laboratory.setPatient_id(rs.getInt("patient_id"));
				laboratory.setReport(rs.getString("report"));
				list.add(laboratory);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			clearUp(conn);
		}
		return list;
	}

	
	public Laboratory getLaboratory(int laboratory_id) {
		
		String sql = "select * from laboratory where laboratory_id = ?;";
		Laboratory laboratory = new Laboratory();
		Connection conn = new DBUtil().getConn();
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, laboratory_id);
			rs = ps.executeQuery();
			if(rs.next()) {
				
				// stupid set method......
				laboratory.setDoctor_id(rs.getInt("doctor_id"));
				laboratory.setLaboratory_id(rs.getInt("laboratory_id"));
				laboratory.setLaboratory_name(rs.getString("laboratory_name"));
				laboratory.setPatient_id(rs.getInt("patient_id"));
				laboratory.setReport(rs.getString("report"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			clearUp(conn);
		}
		return laboratory;
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
