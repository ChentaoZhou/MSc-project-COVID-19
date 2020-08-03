package generater;

public class CICGenerator {
	
	/**
	 * method to generate random data for CLINICAL INCLUSION CRITERIA
	 * 具体随机算法生产的数据根据已得到的统计数据合理生成
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
