package cn.edu.bjtu.sad.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cn.edu.bjtu.sad.model.Medicine;
import cn.edu.bjtu.sad.util.DBUtilFactory;

public class MedicineDaoImp {
	private static PreparedStatement ps;
	private static ResultSet rs;
	
	public boolean deleteMedicine(String medicine_id){
		String sql = "delete from medicine where medicine_id = ?;";
		
		Connection conn = new DBUtilFactory().getMysqlConn();
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
	
	
	public int addMedicine(Medicine medicine){
		String sql = "INSERT INTO `outpatient`.`medicine` "
				+ "(`medicine_name`, `medicine_info`, `medicine_price`, `medicine_num`) "
				+ "VALUES (?, ?, ?);";
		Connection conn = new DBUtilFactory().getMysqlConn();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, medicine.getMedicine_name());
			ps.setString(2, medicine.getMedicine_info());
			ps.setDouble(3, medicine.getMedicine_price());
			ps.setInt(4, medicine.getMedicine_num());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		} finally {
			clearUp(conn);
		}
		int medicine_id = -1;
		sql = "select max(medicine_id) as id from medicine;";
		conn = new DBUtilFactory().getMysqlConn();
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()){
				medicine_id = rs.getInt("id");
			}else{
				return -1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		} finally {
			clearUp(conn);
		}
		return medicine_id;
	}
	
	
	public ArrayList<Medicine> getMedicineList () {
		ArrayList<Medicine> list = new ArrayList<Medicine>();
		String sql = "select * from medicine;";
		Connection conn = new DBUtilFactory().getMysqlConn();
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Medicine medicine = new Medicine();
				// stupid set method......
				medicine.setMedicine_id(rs.getInt("medicine_id"));
				medicine.setMedicine_info(rs.getString("medicine_info"));
				medicine.setMedicine_name(rs.getString("medicine_name"));
				medicine.setMedicine_price(rs.getDouble("medicine_price"));
				medicine.setMedicine_num(rs.getInt("medicine_num"));
				list.add(medicine);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			clearUp(conn);
		}
		return list;
	}

	
	public Medicine getMedicine(int medicine_id) {
		
		Medicine medicine = new Medicine();
		String sql = "select * from medicine where medicine_id = ?;";
		Connection conn = new DBUtilFactory().getMysqlConn();
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, medicine_id);
			rs = ps.executeQuery();
			if (rs.next()) {
				// stupid set method......
				medicine.setMedicine_id(rs.getInt("medicine_id"));
				medicine.setMedicine_info(rs.getString("medicine_info"));
				medicine.setMedicine_name(rs.getString("medicine_name"));
				medicine.setMedicine_price(rs.getDouble("medicine_price"));
				medicine.setMedicine_num(rs.getInt("medicine_num"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			clearUp(conn);
		}

		return medicine;
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
