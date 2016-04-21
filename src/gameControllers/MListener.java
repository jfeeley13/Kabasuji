package gameControllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.event.MouseInputAdapter;

import entity.Board;
import entity.HexTile;
import entity.Hexomino;
import entity.Tile;


public class MListener extends MouseInputAdapter implements MouseListener{
	
	Tile selTile;
	Board board;
	
	HexTile[] shape1 = {new HexTile(null, 0,0),new HexTile(null,0,-1),new HexTile(null,0,-2),new HexTile(null,0,-3),new HexTile(null,0,-4),new HexTile(null,0,-5)};
	HexTile[] shape2 = {new HexTile(null,0,0),new HexTile(null,0,-1),new HexTile(null,0,-2),new HexTile(null,0,-3),new HexTile(null,0,-4),new HexTile(null,1,0)};

	protected Hexomino h1 = new Hexomino(1, shape1);		
	protected Hexomino h2 = new Hexomino(2, shape2);

	
	public MListener(Board board, Tile tile){
		this.selTile = tile;
		this.board = board;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
//Code to show which tile is clicked on
/*		int x = this.tile.getCoords()[0];
		int y = this.tile.getCoords()[1];
		
		System.out.println("Row = " + x);
		System.out.println("Col = " + y);
*/
		this.board.addHex(h1, this.selTile);
		
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
		// TODO Auto-generated method stub
		
	}
	
	

}
