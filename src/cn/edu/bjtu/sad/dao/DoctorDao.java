package cn.edu.bjtu.sad.dao;

import java.util.ArrayList;

import cn.edu.bjtu.sad.model.Doctor;

public interface DoctorDao {
	public boolean deleteDoctor(String doctor_id);
	public int addDoctor(Doctor doctor);
	public boolean updateDoctor(Doctor doctor);
	public ArrayList<Doctor> getDoctorList();
	public Doctor getDoctor(int doctor_id);
}
