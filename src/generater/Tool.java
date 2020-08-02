package generater;

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
}
