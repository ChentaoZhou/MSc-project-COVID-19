package generater;

import java.text.NumberFormat;
import java.util.Random;

public class Tool {
	  /**
     * method used to generate random number in given range
     * **/
    public static int randInt(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }
    
    public static double randDouble() {
    	Random r = new Random();
		double a = r.nextDouble();
		double res = a*100;
		NumberFormat Nformat=NumberFormat.getInstance();
		Nformat.setMaximumFractionDigits(1);
		res = Double.parseDouble(Nformat.format(res));
		return res;
    }
    
}
