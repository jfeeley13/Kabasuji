package gameControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import views.Builder;
import views.SaveMenu;

public class QuitController implements ActionListener {
	Builder parentView;
	SaveMenu sm;
	boolean save=false;

	
	public QuitController(SaveMenu saveMenu, Builder parentView, boolean saved) {
		this.parentView=parentView;
		this.sm = saveMenu;
		this.save=saved;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		sm.setVisible(false);

		if(save==false){
			parentView.quit(parentView);
		}
		else{
			parentView.quit(parentView);

			System.out.println("saved");
		}
	}

}