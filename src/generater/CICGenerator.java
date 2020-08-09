package generater;

public class CICGenerator {
	
	/**
	 * method to generate random data for CLINICAL INCLUSION CRITERIA section
	 * The data produced by the specific random algorithm is reasonably generated according to the obtained statistical data
	 * **/
	public static String generateData() {
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
