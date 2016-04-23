package gameControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import views.SaveMenu;
import views.Builder;

public class SaveController implements ActionListener{
	Builder parentView;

	
	public SaveController(Builder parentView){
		this.parentView = parentView;
	
	}
	
	/**
	 * Entry method
	 */
	
	public void actionPerformed(ActionEvent e) {
		
		// get value
		try {
			//parenView.setVisible(false);
					
			SaveMenu nw = new SaveMenu(parentView);
			nw.setVisible(true);
		} catch (Exception ex) {
			System.err.println("Not Integer!!!");
		}
	}
	
	
}
