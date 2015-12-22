package cn.edu.bjtu.sad.dao;

import cn.edu.bjtu.sad.model.Hcard;

public interface HcardDao {
	public boolean deleteHcard(String hcard_id);
	public int addHcard(Hcard hcard);
	public Hcard getHcard(int hcard_id);
}
