package cn.edu.bjtu.sad.dao;

import java.util.ArrayList;

import cn.edu.bjtu.sad.model.Laboratory;

public interface LaboratoryDao {
	public boolean deleteLaboratory(String laboratory_id);
	public int addLaboratory(Laboratory laboratory);
	public ArrayList<Laboratory> getLaboratoryList();
}
