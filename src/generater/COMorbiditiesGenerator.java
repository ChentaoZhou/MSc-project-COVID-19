package generater;

public class COMorbiditiesGenerator {
	/**
	 * The random data generating algorithm for CO-Morbidities section
	 * The data produced by the specific random algorithm is reasonably generated according to the obtained statistical data 
	 **/
	public static String generateData() {
		StringBuilder res = new StringBuilder();
		int prob = (int) (Math.random()*100);
		if(prob>=30) res.append("No"+",");
		else res.append("Yes"+",");					//Chronic cardiac disease (not hypertension)
		
		prob = (int) (Math.random()*100);		//Diabetes
		if(prob>=20) res.append("No"+",");
		else res.append("Yes"+",");	
		
		prob = (int) (Math.random()*100);		//Hypertension
		if(prob>=10) res.append("No"+",");
		else res.append("Yes"+",");	
		
		prob = (int) (Math.random()*100);		//Current smoking
		if(prob>=7) res.append("No"+",");
		else res.append("Yes"+",");	
		
		prob = (int) (Math.random()*100);		//Chronic pulmonary disease
		if(prob>=17) res.append("No"+",");
		else res.append("Yes"+",");	
		
		prob = (int) (Math.random()*100);		//Tuberculosis
		if(prob>=5) res.append("No"+",");
		else res.append("Yes"+",");	
		
		prob = (int) (Math.random()*100);		//Asthma
		if(prob>=14) res.append("No"+",");
		else res.append("Yes"+",");	
		
		prob = (int) (Math.random()*100);		//Asplenia
		if(prob>=3) res.append("No"+",");
		else res.append("Yes"+",");	
		
		prob = (int) (Math.random()*100);		//Chronic kidney disease
		if(prob>=16) res.append("No"+",");
		else res.append("Yes"+",");
		
		prob = (int) (Math.random()*100);		//Malignant neoplasm
		if(prob>=10) res.append("No"+",");
		else res.append("Yes"+",");
		
		prob = (int) (Math.random()*100);		//Chronic liver disease
		if(prob>=2) res.append("No"+",");
		else res.append("Yes"+",");
		
		prob = (int) (Math.random()*100);		//Other
		if(prob>=10) res.append("No"+",");
		else res.append("Yes"+",");
		
		prob = (int) (Math.random()*100);		//Chronic neurological disorder
		if(prob>=11) res.append("No"+",");
		else res.append("Yes"+",");
		
		res.append(" "+",");
		prob = (int) (Math.random()*100);		//HIV
		if(prob>1) res.append("No");
		else res.append("Yes");
		
		return res.toString();
	}
//	public static void main(String[] args) {
//		System.out.println(getCOM());
//	}
	
}
