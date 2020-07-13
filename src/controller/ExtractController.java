package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.ExtractPage;
import view.HomePage;

public class ExtractController implements ActionListener{
	private ExtractPage view;

	public ExtractController(ExtractPage view) {
		this.view = view;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == view.getBackButton()) {
			view.getFrame().dispose();
			HomePage hp = new HomePage();
			hp.getFrame().setVisible(true);
		}
		
	}
	
	
}
