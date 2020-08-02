package generater;

public class DEMOGenerator {
	public static String getDEMO() {
		StringBuilder res = new StringBuilder();
		String gender = getSex();
		res.append(gender);res.append(",");
		
		//get birth info
		int day = Tool.randInt(1, 30);
		int month = Tool.randInt(1, 12);
		int year = Tool.randInt(1930,2019);
		int age = 2020-year;
		String birthAndAge = day+"/"+month+"/"+year+","+age;
		res.append(birthAndAge);res.append(",");
		
		int prob = (int) (Math.random()*100);			//get a random num between 0-100 
		if(prob>=80) res.append("Yes");
		else res.append("No");
		res.append(",");
		
		prob = (int) (Math.random()*100);
		if(prob>=80) res.append("Yes");
		else res.append("No");
		res.append(",");
		
		//Make reasonable random decisions about pregnant
		String isPregnant = "";
		if(gender.equals("Male")) isPregnant= "No";
		else {
			if(age<18 || age>50) isPregnant= "No";
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
		
		return res.toString();
	}
	
	public static String getSex() {
		int prob = (int) (Math.random()*100);
		if(prob>=50) return "Male";
		else return "Female";
	}

	
	public static void main(String[] args) {
		System.out.println(getDEMO() );
	}
}
