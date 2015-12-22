package cn.edu.bjtu.sad.dao;

import java.util.ArrayList;

import cn.edu.bjtu.sad.model.TradeRecord;

public interface TradeRecordDao {
	public boolean deleteTradeRocord(String trade_id);
	public int addTradeRecord (TradeRecord record);
	public ArrayList<TradeRecord> getTradeRecord();
	public TradeRecord getTradeRecord(int trade_id);
	
}
