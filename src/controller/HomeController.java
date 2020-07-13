package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.ExtractPage;
import view.HomePage;

public class HomeController implements ActionListener{
	private HomePage view;

	public HomeController(HomePage view) {
		this.view = view;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == view.getExtractButton()) {
			view.getFrame().dispose();
			ExtractPage ep = new ExtractPage();
			ep.getFrame().setVisible(true);
		}
		
		if(e.getSource() == view.getCreateButton()) {
			
		}
		
	}
}
