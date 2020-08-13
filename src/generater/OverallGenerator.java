package generater;

import model.FileTool;

public class OverallGenerator {
	/**
	 * Aggregate all the random generation algorithms to get all the randomly generated information for a patient
	 * **/
	public static String generateData() {
		String result="";
		result+= BasicInfoGenerator.generateData()+","+CICGenerator.generateData()+","+DEMOGenerator.generateData()+","
				  +DateOnsetAndSignsGenerator.generateData()+","+COMorbiditiesGenerator.generateData()+","+PreCMGenerator.generateData()
				  +","+SignAndSymGenerator.generateData();
		return result;
	}
	
	public static void main(String[] args) {
		for(int i=0;i<100;i++) {
			String stuff = generateData();
			FileTool.writeUpdate("overall.txt", stuff);
		}
	}
}
