package gameControllers;

import java.awt.Color;
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
	Hexomino selectedHex;
	Color c = Color.blue;
	Color oldColor[][] = new Color[12][12];
	int ID = 1;
	BullPen bp;
	
	public MListener(Tile tile){
		this.tile=tile;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		
		//Code to show which tile is clicked on
		if((tile.valid==1) && (this.tile.getPanel() instanceof Board) && ((Board) this.tile.getPanel()).getLevel().isHexSel()==true){
			placePiece();
		}
		else if(tile.valid==1 && tile instanceof HexTile){

			((BullPen) this.tile.getPanel()).getLevel().setIfPieceSel(true);
			//((BullPen) this.tile.getPanel()).getLevel().isHexSel();
			pickFromPen();
			
		}
	}
	public void placePiece(){
		int x = this.tile.getCoords()[0];
		int y = this.tile.getCoords()[1];

//		System.out.println("Row = " + x);
//		System.out.println("Col = " + y);
//		System.out.println(pieceSelected);
		if(true){
			int test = ((Board) this.tile.getPanel()).getLevel().giveSelHex().getID();
			ID = ((Board) this.tile.getPanel()).getLevel().giveSelHex().getID();
			((Board) this.tile.getPanel()).addHex(ID,this.tile);
			//Removes Hexomino
			((Board) this.tile.getPanel()).getLevel().getBP().removeHex(selectedHex);
			((Board) this.tile.getPanel()).getLevel().getBP().Initialize();
			((Board) this.tile.getPanel()).getLevel().setIfPieceSel(false);
			((Board) this.tile.getPanel()).getLevel().selectHexomino(null);
			c = Color.blue;
		}
	}
	
	public void pickFromPen(){
		ID = ((HexTile) this.tile).getAssocHexID();
		((BullPen) this.tile.getPanel()).getLevel().selectHexomino(((BullPen) this.tile.getPanel()).getLevel().getHexPieceFromID(ID));
//		System.out.print(ID);
		bp = ((BullPen)this.tile.getPanel()).getLevel().getBP();
//		((BullPen) this.tile.getPanel()).getLevel().selectHexomino(selectedHex);
		
	}
	
	
	@Override
	public void mouseEntered(MouseEvent e) {
		c = this.tile.getBackground();
		if (this.tile.getPanel() instanceof Board){
			selectedHex = ((Board)this.tile.getPanel()).getLevel().giveSelHex();
//			System.out.println(selectedHex.getID());
			if(((Board)this.tile.getPanel()).getLevel().giveSelHex() != null){
				Tile boardArray[][] = ((Board) this.tile.getPanel()).getBoardArray();
				for (int i = 0; i < selectedHex.getCoordShape().length; i++){
					int x=selectedHex.getShape()[i].getCoords()[0]+this.tile.getCoords()[0];
					int y=selectedHex.getShape()[i].getCoords()[1]+this.tile.getCoords()[1];
					System.out.println("x,y = " + x + " " + y);
					oldColor[x][y] = boardArray[x][y].getBackground();
					boardArray[x][y].setBackground(Color.GREEN);
					//					this.tile.setBackground(Color.green);
				}
			}
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (this.tile.getPanel() instanceof Board){
			if(((Board)this.tile.getPanel()).getLevel().giveSelHex() != null){

				Tile boardArray[][] = ((Board) this.tile.getPanel()).getBoardArray();
				for (int i = 0; i < selectedHex.getCoordShape().length; i++){
					int x=selectedHex.getShape()[i].getCoords()[0]+this.tile.getCoords()[0];
					int y=selectedHex.getShape()[i].getCoords()[1]+this.tile.getCoords()[1];
					System.out.println("x,y = " + x + " " + y);
					boardArray[x][y].setBackground(oldColor[x][y]);				
					this.tile.setBackground(c);
				}
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}
	
	

}
