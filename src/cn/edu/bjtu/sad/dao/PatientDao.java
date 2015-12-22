package cn.edu.bjtu.sad.dao;

import java.util.ArrayList;

import cn.edu.bjtu.sad.model.Patient;

public interface PatientDao {
	public boolean deletePatient(String patient_id);
	public int addPatient(Patient patient);
	public ArrayList<Patient> getPatientList();
	public Patient getPatient(int patient_id);
}
