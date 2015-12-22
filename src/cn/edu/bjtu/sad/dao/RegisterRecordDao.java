package cn.edu.bjtu.sad.dao;

import java.util.ArrayList;

import cn.edu.bjtu.sad.model.RegisterRecord;

public interface RegisterRecordDao {
	public boolean deleteRegisterRecord(String register_id);
	public int addRegisterRecord(RegisterRecord register);
	public ArrayList<RegisterRecord> getRegisterRecord();
	public RegisterRecord getRegisterRecord(int register_id);
}
