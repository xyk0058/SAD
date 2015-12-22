package cn.edu.bjtu.sad.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cn.edu.bjtu.sad.model.TradeRecord;
import cn.edu.bjtu.sad.util.DBUtilFactory;

public class TradeRecordDaoImp {
	private static PreparedStatement ps;
	private static ResultSet rs;
	
	public boolean deleteTradeRocord(String record_id){
		String sql = "delete from traderecord where record_id = ?;";
		
		Connection conn = new DBUtilFactory().getMysqlConn();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, record_id);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			clearUp(conn);
		}
		
		return true;
	}
	

	public int addTradeRecord (TradeRecord record){
		String sql = "INSERT INTO `outpatient`.`traderecord` "
				+ "(`patient_id`, `price`, "
				+ "`pre_time`, `final_time`, `trade_detail`, "
				+ "`isPrePay`, `isFinalPay`) "
				+ "VALUES (NULL, NULL, NULL, NULL, NULL, NULL, NULL);";
		Connection conn = new DBUtilFactory().getMysqlConn();
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, record.getPatient_id());
			ps.setDouble(2, record.getPrice());
			ps.setString(3, record.getPre_time());
			ps.setString(4, record.getFinal_time());
			ps.setString(5, record.getTrade_detail());
			ps.setString(6, record.getIsPrePay());
			ps.setString(7, record.getIsFinalPay());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		} finally {
			clearUp(conn);
		}
		int record_id = -1;
		sql = "select max(record_id) as id from traderecord;";
		conn = new DBUtilFactory().getMysqlConn();
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()){
				record_id = rs.getInt("id");
			}else{
				return -1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		} finally {
			clearUp(conn);
		}
		return record_id;
	}
	
	
	public ArrayList<TradeRecord> getTradeRecord () {
		ArrayList<TradeRecord> list = new ArrayList<TradeRecord>();
		String sql = "select * from traderecord;";
		Connection conn = new DBUtilFactory().getMysqlConn();
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				TradeRecord record = new TradeRecord();
				// stupid set method......
				record.setFinal_time(rs.getString("final_time"));
				record.setIsFinalPay(rs.getString("isFinalPay"));
				record.setIsPrePay(rs.getString("isPrePay"));
				record.setPatient_id(rs.getInt("patient_id"));
				record.setPre_time(rs.getString("pre_time"));
				record.setPrice(rs.getDouble("price"));
				record.setRecord_id(rs.getInt("record_id"));
				record.setTrade_detail(rs.getString("trade_detail"));
				list.add(record);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			clearUp(conn);
		}
		return list;
	}

	
	public TradeRecord getTradeRecord(int record_id) {
		TradeRecord record = new TradeRecord();
		String sql = "select * from traderecord where record_id = ?;";
		Connection conn = new DBUtilFactory().getMysqlConn();
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, record_id);
			rs = ps.executeQuery();
			if (rs.next()) {
				// stupid set method......
				record.setFinal_time(rs.getString("final_time"));
				record.setIsFinalPay(rs.getString("isFinalPay"));
				record.setIsPrePay(rs.getString("isPrePay"));
				record.setPatient_id(rs.getInt("patient_id"));
				record.setPre_time(rs.getString("pre_time"));
				record.setPrice(rs.getInt("price"));
				record.setRecord_id(rs.getInt("record_id"));
				record.setTrade_detail(rs.getString("trade_detail"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			clearUp(conn);
		}
		return record;
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
