package generater;

import model.Patient;

public class DEMOGenerator {
	/**
	 * The random data generating algorithm for Demographics section
	 * The gender, pregnancy and pregnancy cycle of the patient were calculated by the algorithm in a reasonable way
	 * (Men don't get pregnant, and patients who aren't pregnant don't have pregnancy cycles)   
	 * **/
	public static String generateData(Patient patient) {
		StringBuilder res = new StringBuilder();
		String gender = getSex();
		res.append(gender);res.append(",");
		
		//get birth info
		int day = Tool.randInt(1, 30);
		int month = Tool.randInt(1, 12);
		
		int age = getAge(gender);
		int year = 2020-age;
		String birthAndAge = day+"/"+month+"/"+year+","+age;
		res.append(birthAndAge);res.append(",");
		int prob;
		//if the patient's age is less than 24, he will not be a health care worker or laboratory worker
		if(age<24 || age>70) {
			res.append("No"+",");
			res.append("No"+",");
		}else {
			prob = (int) (Math.random()*100);			//get a random num between 0-100 
			if(prob>=80) res.append("Yes");
			else res.append("No");
			res.append(",");
			
			prob = (int) (Math.random()*100);
			if(prob>=80) res.append("Yes");
			else res.append("No");
			res.append(",");
		}
		
		
		//Make reasonable random decisions about pregnant
		String isPregnant = "";
		if(gender.equals("Male")) isPregnant= "No";
		else {
			if(age<18 || age>55) isPregnant= "No";
			else {
				prob = (int) (Math.random()*100);
				if(prob>=90) isPregnant= "Yes";
				else isPregnant= "No";
			}
		}
		res.append(isPregnant);res.append(",");
		
		//Make reasonable random decisions about Gestational weeks
		if(isPregnant.equals("Yes")) {
			int weeks = Tool.randInt(1, 36);
			res.append(weeks+"");
		}else res.append("");
		
		//store the basic age and gender info to the patient object.
		patient.setAge(age);
		patient.setGender(gender);
		
		
		
		return res.toString();
	}
	
	public static String getSex() {
		double prob = Tool.randDouble();
		if(prob>=40.1) return "Male";
		else return "Female";
	}
	/**
	 * generate age according to the statistical result
	 * */
	public static int getAge(String gender) {
		double x = Tool.randDouble();
		if(gender.equals("Male")) {
			if(x<=1.2) return Tool.randInt(1, 9);
			else if(x>1.2 && x<=1.8) return Tool.randInt(10, 19);
			else if(x>1.8 && x<=2.7) return Tool.randInt(20, 29);
			else if(x>2.7 && x<=5.9) return Tool.randInt(30, 39);
			else if(x>5.9 && x<=13.3) return Tool.randInt(40, 49);
			else if(x>13.3 && x<=27.6) return Tool.randInt(50, 59);
			else if(x>27.6 && x<=45.1) return Tool.randInt(60, 69);
			else if(x>45.1 && x<=69.7) return Tool.randInt(70, 79);
			else if(x>69.7 && x<=93.7) return Tool.randInt(80, 89);
			else return Tool.randInt(90, 110);	
		}else {
			if(x<=1.1) return Tool.randInt(1, 9);
			else if(x>1.1 && x<=1.8) return Tool.randInt(10, 19);
			else if(x>1.8 && x<=4.2) return Tool.randInt(20, 29);
			else if(x>4.2 && x<=8.1) return Tool.randInt(30, 39);
			else if(x>8.1 && x<=14.7) return Tool.randInt(40, 49);
			else if(x>14.7 && x<=26.9) return Tool.randInt(50, 59);
			else if(x>26.9 && x<=41.6) return Tool.randInt(60, 69);
			else if(x>41.6 && x<=62.9) return Tool.randInt(70, 79);
			else if(x>62.9 && x<=89.2) return Tool.randInt(80, 89);
			else return Tool.randInt(90, 110);
		}
	}

	
	public static void main(String[] args) {
		Patient p = new Patient();
		System.out.println(generateData(p));
	}
}
