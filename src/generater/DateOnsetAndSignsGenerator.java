package generater;

public class DateOnsetAndSignsGenerator {
	
	/**
	 * The random data generating algorithm for Date of Onset and Admission Vital Signs section
	 * The data produced by the specific random algorithm is reasonably generated according to the obtained statistical data 
	 * the getArmWeightHeight() method generate the random BMI for each person in a reasonable way.
	 **/
	public static String generateData() {
		StringBuilder res = new StringBuilder();
		int day = Tool.randInt(1, 25);
		int month = Tool.randInt(1, 8);
		int year = 2020;
		String SymDate = day+"/"+month+"/"+year;
		res.append(SymDate);res.append(",");			//Symptom onset
		
		int day2 = day+5;
		String AdmDate = day2+"/"+month+"/"+year;
		res.append(AdmDate); res.append(",");			//Admission date at this facility
		
		int temp1 = Tool.randInt(36, 40);
		int temp2 = (int)(Math.random()*10);
		String temp = temp1+"."+temp2;
		res.append(temp); res.append(",");				//Temperature
		
		int heartRate = Tool.randInt(55, 120);
		res.append(heartRate+",");						//Heart rate
		
		int breathRate = Tool.randInt(10, 30);
		res.append(breathRate+",");						//Respiratory rate
		
		int sysBP = Tool.randInt(100, 150);
		res.append(sysBP+",");							//BP(systolic)
		
		int diaBP = Tool.randInt(60, 100);
		res.append(diaBP+",");							//BP(diastolic)
		
		int prob = (int) (Math.random()*100);
		if(prob>=90) res.append("Yes");
		else res.append("No");
		res.append(",");								//Severe dehydration
		
		prob = (int) (Math.random()*100);
		if(prob>=50) res.append("Yes");
		else res.append("No");							//Sternal capillary refill time >2seconds
		res.append(",");
		
		int oxygenSat = Tool.randInt(70, 100);
		res.append(oxygenSat+",");						//Oxygen saturation
		
		prob = (int) (Math.random()*100);
		if(prob>=30) res.append("room air");
		else res.append("oxygen therapy");
		res.append(",");								//place
		
		int GCS = Tool.randInt(7, 15);
		res.append(GCS+",");							//Glasgow Coma Score
		
		if(prob>=80) res.append("Yes"+",");
		else res.append("No"+",");						//Malnutrition
		
		res.append(getArmWeightHeight());					//Height + weight
		return res.toString();			

	}
	
	/**
	 * Generate Mid-upper arm circumference, height and weight in a reasonable way
	 * **/
	public static String getArmWeightHeight() {
		
		int hight = Tool.randInt(150, 200);
		//for weight
		int weight, arm;
		if(hight<160) {
			weight = Tool.randInt(42, 60);
		}
		else if(hight<170) {
			weight = Tool.randInt(42, 80);
			
		}else if(hight<180) {
			weight = Tool.randInt(60, 90);
			
		}else if(hight<190) {
			weight = Tool.randInt(62, 105);
		}
		else {
			weight = Tool.randInt(80, 130);
		}
		//for arm
		if(weight<60) {
			arm = Tool.randInt(170, 250);
		}else if(weight<80) {
			arm = Tool.randInt(250, 320);
		}else if(weight<100) {
			arm = Tool.randInt(320, 400);
		}else {
			arm = Tool.randInt(390, 450);
		}
		
		return arm+","+hight+","+weight;
	}
	
//	public static void main(String[] args) {
//		System.out.println (DOAVSGenerator());
//	}
}
