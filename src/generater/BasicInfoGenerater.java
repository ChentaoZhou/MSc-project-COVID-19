package generater;

import java.util.Calendar;
import java.util.Random;

/**
 * This class is used to generate random basic information 
 * for each case. Including: ID, site, country,date
 * **/
public class BasicInfoGenerater {
	/**
	 * The final method to call sub-methods and combine 
	 * return values together.
	 * @return String(Basic Info)
	 * **/
	public static String getBasicInfo() {
		StringBuilder res = new StringBuilder();
		res.append(generateID(9));
		res.append(",");
		res.append("Galsgow");
		res.append(",");
		res.append("UK");
		res.append(",");
		res.append(generateDate());
		return res.toString();
	}
	
	/**generate random ID for each patient**/
    public static String generateID(int num){
        StringBuilder str=new StringBuilder();//定义变长字符串
        Random random=new Random();
        for (int i = 0; i < num; i++) {
            str.append(random.nextInt(10));
        }
        return str.toString();
    } 
    
    /**
     * method used to generate random number in given range
     * **/
    public static int randInt(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }
    /** generate random date **/
    public static String generateDate() {
    	int day = randInt(1,31);
    	int month = randInt(1,9);
    	String res = day+"/"+month+"/"+"2020";
    	return res;
    }
    
    public static void main(String[] args) {
    	System.out.println(getBasicInfo() );
    }
}
