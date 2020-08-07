package generater;

import model.FileTool;

public class OverallGenerator {
	public static String generateDate() {
		String result="";
		result+= BasicInfoGenerator.generateData()+","+CICGenerator.generateData()+","+DEMOGenerator.generateData()+","
				  +DateOnsetAndSignsGenerator.generateData()+","+COMorbiditiesGenerator.generateData()+","+PreCMGenerator.generateData()
				  +","+SignAndSymGenerator.generateData();
		return result;
	}
	
	public static void main(String[] args) {
		for(int i=0;i<100;i++) {
			String stuff = generateDate();
			FileTool.writeUpdate("overall.txt", stuff);
		}
	}
}
