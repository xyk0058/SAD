package cn.edu.bjtu.sad.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.edu.bjtu.sad.model.Hcard;
import cn.edu.bjtu.sad.util.DBUtilFactory;

public class HcardDaoImp {
	private static PreparedStatement ps;
	private static ResultSet rs;
	
	public boolean deleteHcard(String hcard_id){
		String sql = "delete from hcard where hcard_id = ?;";
		
		Connection conn = new DBUtilFactory().getMysqlConn();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, hcard_id);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			clearUp(conn);
		}
		
		return true;
	}
	
	
	public int addHcard(Hcard hcard){
		String sql = "INSERT INTO `outpatient`.`hcard` "
				+ "(`idcard_number`, `phone_number`, `crash_card`)"
				+ " VALUES (?, ?, ?);";
		Connection conn = new DBUtilFactory().getMysqlConn();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, hcard.getIdcard_number());
			ps.setString(2, hcard.getPhone_number());
			ps.setString(3, hcard.getCrash_card());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		} finally {
			clearUp(conn);
		}
		int hcard_id = -1;
		sql = "select max(hcard_id) as id from hcard;";
		conn = new DBUtilFactory().getMysqlConn();
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()){
				hcard_id = rs.getInt("id");
			}else{
				return -1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		} finally {
			clearUp(conn);
		}
		return hcard_id;
	}
	
	
	public Hcard getHcard(int hcard_id) {
		
		String sql = "select * from hcard where hcard_id = ?;";
		Hcard hcard = new Hcard();
		Connection conn = new DBUtilFactory().getMysqlConn();
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, hcard_id);
			rs = ps.executeQuery();
			if(rs.next()) {
				
				// stupid set method......
				hcard.setCrash_card(rs.getString("crash_card"));
				hcard.setHcard_id(rs.getInt("hcard_id"));
				hcard.setIdcard_number(rs.getString("idcard_number"));
				hcard.setPhone_number(rs.getString("phone_number"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			clearUp(conn);
		}
		return hcard;
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
