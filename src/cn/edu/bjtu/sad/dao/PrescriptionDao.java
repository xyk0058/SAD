package cn.edu.bjtu.sad.dao;

import java.util.ArrayList;

import cn.edu.bjtu.sad.model.Prescription;

public interface PrescriptionDao {
	public boolean deletePrescription(String prescription_id);
	public int addPrescription(Prescription prescription);
	public ArrayList<Prescription> getPrescription();
	public Prescription getPatient(int prescription_id);
}
