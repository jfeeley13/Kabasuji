package gameControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import views.Builder;
import views.SaveMenu;

public class QuitController implements ActionListener {
	Builder parentView;
	SaveMenu sm;

	
	public QuitController(SaveMenu saveMenu, Builder parentView) {
		this.parentView=parentView;
		this.sm = saveMenu;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		sm.setVisible(false);
		parentView.quit(parentView);

	}

}
