package gameControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import views.Builder;
import views.Level;

public class FlipController implements ActionListener{
	Level level;
	//Piece piece
	
	/**
	 * 
	 * @param level Level view to be edited
	 */
	public FlipController(Level level){
		this.level = level;
	}
	
	public FlipController(Builder builder, int i) {
		// TODO Auto-generated constructor stub
	}

	/**
	 * action method
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
