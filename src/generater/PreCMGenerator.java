package generater;

public class PreCMGenerator {
	public static String getPCM() {
		int prob = (int) (Math.random()*100);
		StringBuilder res = new StringBuilder();
		if(prob>50) res.append("Yes"+",");
		else res.append("No"+",");
		
		prob = (int) (Math.random()*100);
		if(prob>50) res.append("Yes"+",");
		else res.append("No"+",");
		
		prob = (int) (Math.random()*100);
		if(prob>50) res.append("Yes");
		else res.append("No");
		
		return res.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(getPCM());
	}
	
}
