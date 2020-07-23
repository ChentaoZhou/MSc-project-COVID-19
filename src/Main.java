import view.HomePage;

public class Main {
	public static void main(String[] args) {
		HomePage hp = new HomePage();
		hp.getFrame().setVisible(true);
	}
}

/**
 * 创建一个新的window用来展示提取的部分数据
 * 将每个提取按钮和对应方法联系起来，并在调用后在新窗口内展示
 * **/ 
 