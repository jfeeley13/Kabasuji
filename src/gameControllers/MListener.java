package gameControllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.event.MouseInputAdapter;

import entity.Tile;


public class MListener extends MouseInputAdapter implements MouseListener{
	Tile tile;
	public MListener(Tile tile){
		this.tile=tile;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		//Code to show which tile is clicked on
		int x = this.tile.getCoords()[0];
		int y = this.tile.getCoords()[1];

		System.out.println("Row = " + x);
		System.out.println("Col = " + y);

		this.tile.getBoard().addHex(this.tile);

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	
	}
	
	

}
