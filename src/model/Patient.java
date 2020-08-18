package model;

import generater.Tool;

public class Patient {
	private String gender;
	private int age;
	private int num_comorbidities=0;
	private int num_symptom=0;
	
	public Patient(boolean sex) {
		if(sex==true) this.gender="Male";
		else this.gender = "Female";
		age = Tool.randInt(20, 100);
	}
	public Patient() {}
	
	
	
	
	public String getGender() {
		return this.gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return this.age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getNum_comorbidities() {
		return this.num_comorbidities;
	}
	public void setNum_comorbidities(int num_comorbidities) {
		this.num_comorbidities = num_comorbidities;
	}
	public int getNum_symptom() {
		return this.num_symptom;
	}
	public void setNum_symptom(int num_symptom) {
		this.num_symptom = num_symptom;
	}
}
