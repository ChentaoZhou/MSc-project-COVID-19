import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.bouncycastle.util.Arrays;

public class ExtractPdf {
	/**
	 * method used for extract all information from target PDF
	 * @param file name
	 * @return String[]
	 * **/
	public static ArrayList<String> extractPdf(String file) throws IOException {
		ArrayList<String> result = new ArrayList<String>();
		PDFTextStripper tStripper = new PDFTextStripper();
		tStripper.setStartPage(2);		//the target pages
		tStripper.setEndPage(7);
		String[] lines = null;
		PDDocument document = PDDocument.load(new File(file));
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
	 * */
	public static String m1_basicInfo(List<String> m1_basicinfo) {
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
	 * */
	public static String m1_Clinical(List<String> m) {
		ArrayList<String> temp = new ArrayList<String>();
		for(String line:m) {
			line = line.replace("≥ 38oC","").replace("(shortness of breath) OR Tachypnoea*", "").replaceAll("[a-zA-Z|]", "").replace("-", "").replace(" ", "");
			System.out.println(line);
			if(line.charAt(0) == '×') {
				line = "Yes";
			}else {line = "No";}
			temp.add(line);
		}
		return  ListToString(temp);
	}
	/**
	 * Take out the data from m1_DEMOGRAPHICS table and change to CSV string.
	 * */
	public static String m1_Demographics(List<String> m) {
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
	 * **/
	public static String m1_Vitalsigns(List<String> m) {
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
	
	
	
	
	
	
	public static void main(String[] args) throws IOException {
		ArrayList<String> lines = extractPdf("ISARIC_M1.pdf");
//		for(int i=0;i<lines.size();i++) {
//			System.out.println("line"+i+": "+lines.get(i));
//		}
		List<String> m = lines.subList(26, 35);
		for(int i=0;i<m.size();i++) {
			System.out.println("line"+i+": "+ m.get(i));
		}
		
		System.out.println(m1_Vitalsigns(m));
		
		
	}

}
