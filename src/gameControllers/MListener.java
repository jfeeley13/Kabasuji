package gameControllers;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.event.MouseInputAdapter;

import entity.Board;
import entity.BullPen;
import entity.HexTile;
import entity.Hexomino;
import entity.Tile;
import views.Level;


public class MListener extends MouseInputAdapter implements MouseListener{
	Tile tile;
	boolean pieceSelected=false;
	public MListener(Tile tile){
		this.tile=tile;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		
		//Code to show which tile is clicked on
		if((tile.valid==1) && (this.tile.getBoard() instanceof Board)){
			placePiece();
		}
		else if(tile.valid==1){
			System.out.println("got here");
			pieceSelected=true;	
			pickFromPen();
		}
	}
	public void placePiece(){
		int x = this.tile.getCoords()[0];
		int y = this.tile.getCoords()[1];

		System.out.println("Row = " + x);
		System.out.println("Col = " + y);
		int ID = ((HexTile) this.tile).getAssocHexID();
		((Board) this.tile.getBoard()).addHex(ID,this.tile);
		pieceSelected=false;
		((Board) this.tile.getBoard()).getLevel().setIfPieceSel(false);
	}
	
	public void pickFromPen(){

		int ID = ((HexTile) this.tile).getAssocHexID();
		Hexomino selHex =((BullPen) this.tile.getBoard()).getLevel().getHexPieceFromID(ID);
		((BullPen) this.tile.getBoard()).getLevel().selectHexomino(selHex);

		((BullPen) this.tile.getBoard()).getLevel().setIfPieceSel(true);
		
		
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}
	
	

}
