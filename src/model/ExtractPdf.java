package model;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.bouncycastle.util.Arrays;

import model.FileTool;

public class ExtractPdf {
	/**
	 * method used for extract all information from target PDF
	 * @param file name
	 * @return String[]
	 * **/
	public static ArrayList<String> extractPdf(File file) throws IOException {
		ArrayList<String> result = new ArrayList<String>();
		PDFTextStripper tStripper = new PDFTextStripper();
		tStripper.setStartPage(2);		//the target pages
		tStripper.setEndPage(7);
		String[] lines = null;
		PDDocument document = PDDocument.load(file);
		document.getClass();
		if (!document.isEncrypted()) {
			String pdfFileInText = tStripper.getText(document);		// pdfFileInText contains all the data of PDF
			lines = pdfFileInText.split("[\\r\\n]+");
			for (int i = 0; i < lines.length; i++) {
				result.add(lines[i]);
			}
		}
		return result;
	}
	/**
	 * get a processed ArrayList and change it into formated String
	 * which is satisfy the CSV format.
	 **/
	public static String ListToString(ArrayList<String> lists) {
		String result = "";
		for(String s:lists) {
			result+=s+",";
		}
		result = result.substring(0,result.length()-1);
		return result;
	}
	/**
	 * Take out the data from m1_basicInfo table and change to CSV string.
	 * List<String> mbasicInfo = lines.subList(0, 11);
	 * */
	public static String m1_basicInfo(List<String> lines) {
		List<String> m1_basicinfo = lines.subList(0, 11);
		ArrayList<String> temp = new ArrayList<String>();
		// operation for first line
		String line0 = m1_basicinfo.get(0);
		line0 = line0.replaceAll("[A-Z]", "").replaceAll("-", "").replace(" ", "");
		temp.add(line0);
		//operation for site name line
		String line1 = m1_basicinfo.get(6);
		line1 = line1.replace("Site name", "").replace("_", "").replace(" ", "");
		temp.add(line1);
		//operation for country line
		String line2 = m1_basicinfo.get(9);
		line2 = line2.replace("Country", "").replace("_", "").replace(" ", "");
		temp.add(line2);
		// operation for enrollment date
		String line3 = m1_basicinfo.get(10);
		line3 = line3.replace(" ", "").replaceAll("[A-Z][a-z]*", "").replace("_", "").replace("[", "").replace("]", "");
		temp.add(line3);
		
		return ListToString(temp);
	}
	/**
	 * Take out the data from m1_CLINICAL INCLUSION CRITERIA table and change to CSV string.
	 * List<String> m1Clinical = lines.subList(12, 17);
	 * */
	public static String m1_Clinical(List<String> lines) {
		List<String> m = lines.subList(12, 17);
		ArrayList<String> temp = new ArrayList<String>();
		for(String line:m) {
			line = line.replace("≥ 38oC","").replace("(shortness of breath) OR Tachypnoea*", "").replaceAll("[a-zA-Z|]", "").replace("-", "").replace(" ", "");
			if(line.charAt(0) == '×') {
				line = "Yes";
			}else {line = "No";}
			temp.add(line);
		}
		return  ListToString(temp);
	}
	/**
	 * Take out the data from m1_DEMOGRAPHICS table and change to CSV string.
	 * List<String> m1Demographics = lines.subList(20, 24);
	 * */
	public static String m1_Demographics(List<String> lines) {
		List<String> m = lines.subList(20, 24);
		ArrayList<String> temp = new ArrayList<String>();
		String line00 = m.get(0).substring(0,45);
		line00 = line00.replaceAll("[a-zA-Z\\s+]", "");
		if(line00.charAt(0)=='×') line00 = "Male";
		else if(line00.charAt(1)=='×') line00 = "Female";
		else if(line00.charAt(2)=='×') line00 = "Not specified";
		temp.add(line00);
		String line01 = m.get(0).substring(45);
		line01 = line01.replaceAll("[a-zA-Z\\s+\\[\\]\\_]", "");
		temp.add(line01);
		String line1 = m.get(1);
		line1 = line1.replaceAll("[a-zA-Z\\s+\\[\\]\\_,:]", "");
		temp.add(line1);
		String line20 = m.get(2).substring(0,39);
		line20 = line20.replaceAll("[a-zA-Z\\s+?]", "");
		if(line20.charAt(0)=='×') line20 = "Yes";
		else if(line20.charAt(1)=='×') line20 = "No";
		else if(line20.charAt(2)=='×') line20 = "Unknown";
		temp.add(line20);
		String line21 = m.get(2).substring(39);
		line21 = line21.replaceAll("[a-zA-Z\\s+?]", "");
		if(line21.charAt(0)=='×') line21 = "Yes";
		else if(line21.charAt(1)=='×') line21 = "No";
		else if(line21.charAt(2)=='×') line21 = "Unknown";
		temp.add(line21);
		String line30 = m.get(3).substring(0,40);
		line30 = line30.replaceAll("[a-zA-Z\\s+?/]", "");
		if(line30.charAt(0)=='×') line30 = "Yes";
		else if(line30.charAt(1)=='×') line30 = "No";
		else if(line30.charAt(2)=='×') line30 = "Unknown";
		else line30 = "N/A";
		temp.add(line30);
		String line31 = m.get(3).substring(40);
		line31 = line31.replaceAll("[a-zA-Z\\s+\\[\\]\\_:]", "");
		if(line31.length()==0) line31=" ";
		temp.add(line31);
		
		return  ListToString(temp);
	}
	/**
	 * Take out the data from m1_Vitalsigns table and change to CSV string.
	 * List<String> m1Vitalsigns = lines.subList(26, 35);
	 * **/
	public static String m1_Vitalsigns(List<String> lines) {
		List<String> m = lines.subList(26, 35);
		ArrayList<String> temp = new ArrayList<String>();
		String line0 = m.get(0);
		line0 = line0.replaceAll("[a-zA-Z\\s+\\[\\]\\_()]", "").substring(1);
		temp.add(line0);
		String line1 = m.get(1);
		line1 = line1.replaceAll("[a-zA-Z\\s+\\[\\]\\_()]", "");
		temp.add(line1);
		String line2 = m.get(2);
		line2 = line2.replaceAll("[a-zA-Z\\s+\\[\\]\\_°/]", "");
		temp.add(line2.substring(0,4));
		temp.add(line2.substring(4));
		String line3 = m.get(3);
		line3 = line3.replaceAll("[a-zA-Z\\s+\\[\\]\\_/]", "");
		temp.add(line3);
		String line4 = m.get(4);
		line4 = line4.replaceAll("[a-zA-Z\\s+\\[\\]\\_/()×]", "");
		temp.add(line4.substring(0,3));
		temp.add(line4.substring(3));
		String line41 = m.get(4);
		line41 = line41.replaceAll("[a-zA-Z\\s+\\[\\]\\_/()0-9]", "");
		if(line41.charAt(0)=='×') line41 = "Yes";
		else if(line41.charAt(1)=='×') line41 = "No";
		else if(line41.charAt(2)=='×') line41 = "Unknown";
		temp.add(line41);
		String line5 = m.get(5);
		line5 = line5.replaceAll("[a-zA-Z\\s+>2]", "");
		if(line5.charAt(0)=='×') line5 = "Yes";
		else if(line5.charAt(1)=='×') line5 = "No";
		else if(line5.charAt(2)=='×') line5 = "Unknown";
		temp.add(line5);
		String line6 = m.get(6);
		line6 = line6.replaceAll("[a-zA-Z\\s+\\[\\]\\_:()%×]", "");
		temp.add(line6);
		String line61 = m.get(6);
		line61 = line61.replaceAll("[a-zA-Z\\s+\\[\\]\\_:()%0-9]", "");
		if(line61.charAt(0)=='×') line61 = "room air";
		else if(line61.charAt(1)=='×') line61 = "oxygen therapy";
		else if(line61.charAt(2)=='×') line61 = "Unknown";
		temp.add(line61);
		String line7 = m.get(7);
		line7 = line7.replaceAll("[a-zA-Z\\s+\\[\\]\\_/(15)×]", "");
		temp.add(line7);
		String line71 = m.get(7);
		line71 = line71.replaceAll("[a-zA-Z\\s+\\[\\]\\_/()0-9]", "");
		if(line71.charAt(0)=='×') line71 = "Yes";
		else if(line71.charAt(1)=='×') line71 = "No";
		else if(line71.charAt(2)=='×') line71 = "Unknown";
		temp.add(line71);
		String line8 = m.get(8);
		line8 = line8.replaceAll("[a-zA-Z\\s+\\[\\]\\_-]", "");
		temp.add(line8.substring(0,3));
		temp.add(line8.substring(4,7));
		temp.add(line8.substring(8));
		
		return  ListToString(temp);
	}
	/**
	 * Take out the data from m1_CO-MORBIDITIES table and change to CSV string.
	 * List<String> m = lines.subList(38, 48);
		m.remove(1);
	 * */
	public static String m1_CoMorbidities(List<String> lines) {
		List<String> m = lines.subList(38, 48);
		m.remove(1);
	
		ArrayList<String> temp = new ArrayList<String>();
		List<String> n = new ArrayList<String>();
		n.add(m.get(0).replaceAll("[a-zA-Z\\s+()]", ""));n.add(m.get(1).replaceAll("[a-zA-Z\\s+]", ""));
		for(int i=2;i<7;i++) {
			String line = m.get(i).replaceAll("[a-zA-Z\\s+]", "");
			n.add(line.substring(0,3));
			n.add(line.substring(3));
		}
		String line7 = m.get(7).replaceAll("[a-zA-Z\\s+]", "").substring(0,3);
		n.add(line7);
		for(String s:n) {
			if(s.charAt(0)=='×') s = "Yes";
			else if(s.charAt(1)=='×') s = "No";
			else if(s.charAt(2)=='×') s = "Unknown";
			
			temp.add(s);
		}
		String line71 = m.get(7).replace("_", "").substring(61);
		temp.add(line71);
		String line8 = m.get(8).replaceAll("[a-zA-Z\\s+-]", "");
			if(line8.charAt(0)=='×') line8 = "Yes-on ART";
			else if(line8.charAt(1)=='×') line8 = "Yes-not on ART";
			else if(line8.charAt(2)=='×') line8 = "No";
			else line8 = "Unknown";
		temp.add(line8);
		
		return  ListToString(temp);
	}
	/**
	 * m1_PRE-ADMISSION & CHRONIC MEDICATION
	 * Take out the data from target table and change to CSV string.
	 * List<String> m = lines.subList(55, 58);
	 * */
	public static String m1_ChronicMedication(List<String> lines) {
		List<String> m = lines.subList(55, 58);
	
		ArrayList<String> temp = new ArrayList<String>();
		for(String s:m) {
			s= s.replaceAll("[a-zA-Z\\s+()?-]", "");
			if(s.charAt(0)=='×') s = "Yes";
			else if(s.charAt(1)=='×') s = "No";
			else if(s.charAt(2)=='×') s = "Unknown";
			temp.add(s);
		}
		return  ListToString(temp);
	}
	/**
	 * m1_SIGNS AND SYMPTIONS ON ADMISSION
	 * Take out the data from target table and change to CSV string.
	 * List<String> m = lines.subList(64, 81);
	 * */
	public static String m1_SymptomsAD(List<String> lines) {
		List<String> m = lines.subList(64, 81);
		
		ArrayList<String> temp = new ArrayList<String>();
		List<String> n = m.subList(0, 11);
		//extract first 11 lines from this table [0-10]
		for(String line:n) {
			line = line.replaceAll("[a-zA-Z\\s+./()]", "");
			String res = null;
			if(line.charAt(0)=='×') res = "Yes";
			else if(line.charAt(1)=='×') res = "No";
			else if(line.charAt(2)=='×') res = "Unknown";
			temp.add(res);
			if(line.charAt(3)=='×') res = "Yes";
			else if(line.charAt(4)=='×') res = "No";
			else if(line.charAt(5)=='×') res = "Unknown";
			temp.add(res);
		}
		//extract data from 11-15 until "If bleeding: specify site(s):"
		List<String> rest = new ArrayList<>();
		rest.add(m.get(11));rest.add(m.get(13));rest.add(m.get(15));
		for(String line:rest) {
			line = line.replaceAll("[a-zA-Z\\s+./():]", "");
			if(line.charAt(0)=='×') line = "Yes";
			else if(line.charAt(1)=='×') line = "No";
			else if(line.charAt(2)=='×') line = "Unknown";
			temp.add(line);
		}
		String line15 = m.get(15).replace(" Yes   No  ×Unk      If bleeding: specify site(s):", "");
		temp.add(line15);
		String line16 = m.get(16).replaceAll("[a-zA-Z\\s+./(),:]", "");
		if(line16.charAt(0)=='×') line16 = "Yes";
		else if(line16.charAt(1)=='×') line16 = "No";
		else if(line16.charAt(2)=='×') line16 = "Unknown";
		temp.add(line16);
		String line161 = m.get(16).replace("Other Yes   No   ×Unk  If yes, specify:", "");
		temp.add(line161);
		
		return  ListToString(temp);	
	}
	
	
	/**
	 * A method used to return all the info in the M1_module by 
	 * calling all the method above.
	 * from Beginning -----to -----SymptomsAD in this PDF
	 * **/
	public static String m1_overall(List<String> lines) {
		String result ="";
		List<String> input = new ArrayList<String>(lines);
		//take all the data out and store them in the String
		String m1basicinfo = ExtractPdf.m1_basicInfo(lines);
		String m1Clinical = ExtractPdf.m1_Clinical(lines);
		String m1Demographics = ExtractPdf.m1_Demographics(lines);
		String m1Vitalsigns = ExtractPdf.m1_Vitalsigns(lines);
		String m1CoMorbidities = ExtractPdf.m1_CoMorbidities(lines);
		//here I need to use a new list "input" to do this job, because the m1_CoMorbidities(lines)
		//will change the order of someplace and cause problem.
		String m1ChronicMedication = ExtractPdf.m1_ChronicMedication(input);
		String m1SymptomsAD = ExtractPdf.m1_SymptomsAD(input);
		
		//add all the result string together;
		result = m1basicinfo+","+m1Clinical+","+m1Demographics+","+m1Vitalsigns+","+m1CoMorbidities+","+m1ChronicMedication+","+m1SymptomsAD;
		
		return result;
		
	}
	
	
//	public static void main(String[] args) throws IOException {
//		ArrayList<String> lines = extractPdf("ISARIC_M1.pdf");
//		for(int i=0;i<lines.size();i++) {
//			System.out.println("line"+i+": "+lines.get(i));
//		}
//		//List<String> m1SymptomsAD = lines.subList(64, 81);
//		//List<String> m1basicInfo = lines.subList(0, 11);
//		//List<String> m1Clinical = lines.subList(12, 17);
//		//List<String> m1Demographics = lines.subList(20, 24);
//		//List<String> m1Vitalsigns = lines.subList(26, 35);
//		
//		
//		
//		
////		String stuff = ExtractPdf.m1_overall(lines);
////		System.out.println(stuff);
////		String path = "E:\\test\\overall.txt";
////		FileTool.writeUpdate(path, stuff);
//		
//		
//	}

}
