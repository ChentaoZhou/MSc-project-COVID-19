package generater;

import java.text.NumberFormat;
import java.util.Random;

public class SignAndSymGenerator {
	/**
	 * The random data generating algorithm for Signs and Symptoms on Admission section
	 * All randomly generated data is based on official statistical data distribution
	 * **/
	public static String generateData() {
		double prob = Tool.randDouble();
		StringBuilder res = new StringBuilder();
		//Fever
		if(prob>=28.4) res.append("Yes"+",");
		else res.append("No"+",");
		//Lower chest wall indrawing
		prob = Tool.randDouble();
		if(prob>=98.4) res.append("Yes"+",");
		else res.append("No"+",");
		//Cough
		prob = Tool.randDouble();
		if(prob>=31.1) res.append("Yes"+",");
		else res.append("No"+",");
		//Headache
		prob = Tool.randDouble();
		if(prob>=87.5) res.append("Yes"+",");
		else res.append("No"+",");
		//Couth with sputum production
		prob = Tool.randDouble();
		if(prob>=73.8) res.append("Yes"+",");
		else res.append("No"+",");
		//Altered consciousness/confusion
		prob = Tool.randDouble();
		if(prob>=73.3) res.append("Yes"+",");
		else res.append("No"+",");
		//Cough with haemoptysis(blood)
		prob = Tool.randDouble();
		if(prob>=96.5) res.append("Yes"+",");
		else res.append("No"+",");
		//Seizures
		prob = Tool.randDouble();
		if(prob>=98.3) res.append("Yes"+",");
		else res.append("No"+",");
		//Sore throat
		prob = Tool.randDouble();
		if(prob>=90.2) res.append("Yes"+",");
		else res.append("No"+",");
		//Abdominal pain
		prob = Tool.randDouble();
		if(prob>=89.8) res.append("Yes"+",");
		else res.append("No"+",");
		//Runny nose(rhinorrhoea)
		prob = Tool.randDouble();
		if(prob>=96.4) res.append("Yes"+",");
		else res.append("No"+",");
		//Vomiting/Nausea
		prob = Tool.randDouble();
		if(prob>=80.2) res.append("Yes"+",");
		else res.append("No"+",");
		//Wheezing
		prob = Tool.randDouble();
		if(prob>=89.1) res.append("Yes"+",");
		else res.append("No"+",");
		//Diarrhoea
		prob = Tool.randDouble();
		if(prob>=79.6) res.append("Yes"+",");
		else res.append("No"+",");
		//Chest pain
		prob = Tool.randDouble();
		if(prob>=85.4) res.append("Yes"+",");
		else res.append("No"+",");
		//Conjunctivitis
		prob = Tool.randDouble();
		if(prob>=99.7) res.append("Yes"+",");
		else res.append("No"+",");
		//Muscle aches(myalgia)
		prob = Tool.randDouble();
		if(prob>=79.4) res.append("Yes"+",");
		else res.append("No"+",");
		//Skin rash
		prob = Tool.randDouble();
		if(prob>=98.3) res.append("Yes"+",");
		else res.append("No"+",");
		//Joint pain
		prob = Tool.randDouble();
		if(prob>=92.5) res.append("Yes"+",");
		else res.append("No"+",");
		//Skin ulcers
		prob = Tool.randDouble();
		if(prob>=97.6) res.append("Yes"+",");
		else res.append("No"+",");
		//Fatigue/Malaise
		prob = Tool.randDouble();
		if(prob>=54.5) res.append("Yes"+",");
		else res.append("No"+",");
		//Lymphadenopathy
		prob = Tool.randDouble();
		if(prob>=99.3) res.append("Yes"+",");
		else res.append("No"+",");
		//Shortness of breath
		prob = Tool.randDouble();
		if(prob>=28.8) res.append("Yes"+",");
		else res.append("No"+",");
		//Bleeding(Haemorrhage)
		prob = Tool.randDouble();
		double isbleeding = prob;
		if(prob>=98.8) res.append("Yes"+",");
		else res.append("No"+",");
		//Inability to walk
		prob = Tool.randDouble();
		if(prob>=90.1) res.append("Yes"+",");
		else res.append("No"+",");
		//if bleeding, specify site:
		if(isbleeding>=98.8) res.append("nose"+",");
		else res.append(" "+",");
		
		//other
		res.append("No"+",");
		return res.toString();
	}
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {

		System.out.println(generateData());
	}
}
