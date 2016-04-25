package gameControllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;


import views.Level;

public class MouseMove implements MouseMotionListener{
	public Level level;
	
	public MouseMove(Level level){
		this.level=level;
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseMoved(MouseEvent e){
		 int x = e.getX();
	     int y = e.getY();
	     this.level.setMouseXY(x,y);	     
		
	}

}
