package model;

import generater.Tool;

public class Patient {
	private String gender;
	private int age;
	private int num_comorbidities=0;
	private int num_symptom=0;
	// four common symptoms related to COVID-19 
	private boolean isFever = false, isCough= false,isMuscleAches= false,isFatigue= false;
	private int numCovidSym=0;
	public Patient() {}
	//Getter and Setter methods to get and set the attribute value.
	

		public Patient(boolean sex) {
		if(sex==true) this.gender="Male";
		else this.gender = "Female";
		age = Tool.randInt(20, 100);
	}
	public boolean isFever() {
		return this.isFever;
	}
	public int getNumCovidSym() {
		return this.numCovidSym;
	}
	public void addNumCovidSym() {
		this.numCovidSym++;
	}
	public void setFever(boolean isFever) {
		this.isFever = isFever;
	}
	public boolean isCough() {
		return this.isCough;
	}
	public void setCough(boolean isCough) {
		this.isCough = isCough;
	}
	public boolean isMuscleAches() {
		return this.isMuscleAches;
	}
	public void setMuscleAches(boolean isMuscleAches) {
		this.isMuscleAches = isMuscleAches;
	}
	public boolean isFatigue() {
		return this.isFatigue;
	}
	public void setFatigue(boolean isFatigue) {
		this.isFatigue = isFatigue;
	}
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
	public void addNum_comorbidities() {
		this.num_comorbidities++;
	}
	public int getNum_symptom() {
		return this.num_symptom;
	}
	public void setNum_symptom(int num_symptom) {
		this.num_symptom = num_symptom;
	}
}
