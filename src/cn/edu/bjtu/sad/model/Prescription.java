package cn.edu.bjtu.sad.model;

public class Prescription {
	private int prescription_id;
	private int patient_id;
	private int doctor_id;
	private String medicine_list;
	private int evaluate_score;
	
	public int getPrescription_id() {
		return prescription_id;
	}
	public void setPrescription_id(int prescription_id) {
		this.prescription_id = prescription_id;
	}
	public int getPatient_id() {
		return patient_id;
	}
	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}
	public int getDoctor_id() {
		return doctor_id;
	}
	public void setDoctor_id(int doctor_id) {
		this.doctor_id = doctor_id;
	}
	public String getMedicine_list() {
		return medicine_list;
	}
	public void setMedicine_list(String medicine_list) {
		this.medicine_list = medicine_list;
	}
	public int getEvaluate_score() {
		return evaluate_score;
	}
	public void setEvaluate_score(int evaluate_score) {
		this.evaluate_score = evaluate_score;
	}
	
}
