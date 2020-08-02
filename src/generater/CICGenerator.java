package generater;

public class CICGenerator {
	
	/**
	 * method to generate random data for CLINICAL INCLUSION CRITERIA
	 * **/
	public static String getCIC() {
		StringBuilder res = new StringBuilder();
		int prob = (int) (Math.random()*100);
		if(prob>=50) res.append("Yes");
		else res.append("No");
		res.append(",");
		
		prob = (int) (Math.random()*100);
		if(prob>=29) res.append("Yes");
		else res.append("No");
		res.append(",");
		
		prob = (int) (Math.random()*100);
		if(prob>=31) res.append("Yes");
		else res.append("No");
		res.append(",");
		
		prob = (int) (Math.random()*100);
		if(prob>=29) res.append("Yes");
		else res.append("No");
		res.append(",");
		
		prob = (int) (Math.random()*100);
		if(prob>=90) res.append("Yes");
		else res.append("No");
		
		
		return res.toString();
	}
}
