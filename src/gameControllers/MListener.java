package gameControllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.event.MouseInputAdapter;

import entity.AllHex;
import entity.Tile;


public class MListener extends MouseInputAdapter implements MouseListener{
	Tile tile;
	AllHex hexList;
	
	public MListener(Tile tile){
		this.tile=tile;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		//Code to show which tile is clicked on
		int x = this.tile.getCoords().getColumn();
		int y = this.tile.getCoords().getRow();

		System.out.println("Row = " + y);
		System.out.println("Col = " + x);

		this.tile.getBoard().addHex(hexList.getHex(1), this.tile);

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
