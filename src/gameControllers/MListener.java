package gameControllers;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.event.MouseInputAdapter;

import entity.AllHex;
import entity.Board;
import entity.BoardBoss;
import entity.BullPen;
import entity.Hexomino;
import entity.Tile;
import views.Level;


public class MListener extends MouseInputAdapter implements MouseListener, MouseMotionListener, MouseWheelListener{
	Tile tile;
	static int lastID;
	static int lastTileID;
	static Tile lastGoodTile;
	BoardBoss board;
	static BoardBoss bullPen;
	static BoardBoss lastBoard;
	Random r = new Random();
	static ArrayList<Integer> ids = new ArrayList<Integer>();
	int randint;
	public static Tile datboi= null;
	static int lastgreenbois=0;
	static int greenbois=0;
	static Tile[][] savedBoardState;
	static Tile[][] lastBoardState;
	Tile lastTile;


	//
	
	public MListener(Tile tile, BoardBoss board){
		this.tile=tile;
		this.board = board;
		this.lastTileID = tile.getTileID();

	}
	/**
	 * Handles mouse click
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		
		if(tile.getBoard().getID()==2) bullPen=(BullPen)tile.getBoard();
		lastID = tile.getBoard().getID();

		//System.out.println("Clicked!");
		
		//System.out.println("Piece id: " + ids.get(ids.size()-1));
		
		generateRandom();

		Hexomino hex;
		if(BoardBoss.selectedPiece==null) {
			hex = (Hexomino) BoardBoss.pieceList.get(tile.getTileID());
			System.out.println("Stuff...yo");
		}
		else {
			hex=BoardBoss.selectedPiece;
		}
		boolean placed = this.tile.getBoard().addHex(this.tile, ids.get(ids.size()-1), hex);
		
		if(tile.getBoard().getID()==4){

			for(int i=0; i<tile.getBoard().returnWidth();i++){
				for(int j=0; j<tile.getBoard().returnHeight();j++) {

					if(tile.getBoard().returnBoard()[i][j].getBackground()==Color.GREEN || tile.getBoard().returnBoard()[i][j].getTileID()==1000) {
						 datboi = tile.getBoard().returnBoard()[i][j];
//							System.out.println("Selected piece "+datboi);
							break;
					}
				}
			}
//			System.out.println("Selected piece2 "+datboi);
			

					
			tile.getBoard().rotateFlip(datboi);
    		


		}
		
		if(!placed) {
			if(tile.getBoard().getID()==4) {
				tile.getBoard().drawHex(tile, tile.getCoords()[0], tile.getCoords()[1], Color.GREEN);
			}
			System.out.println("Didn't place anything!");
			ids.remove(ids.size()-1);
		
		}
		//else {
			if(this.tile.getBoard().getID()==1) {
				//if(lastBoard.getID()==2){
					//bullPen.clearPen();
					if(bullPen.isEmpty()) {
					bullPen.refill=true;
					for(int i = 0; i <2; i++){
						generateRandom();
						bullPen.addHex(bullPen.returnBoard()[7*i+1][5], ids.get(ids.size()-1), entity.Level.solutionPieces.get(0));
						entity.Level.solutionPieces.remove(0);
					}
					
				
					bullPen.refill=false;
					}
					BoardBoss.bullPenPosition+=1;
			//}
				if(lastBoard.getID()==4) {
					lastBoard.clearPen();
					lastBoard.refillInventory();
				}

			}
			lastBoard = board;
		//}
	}
	
	/**
	 * generate unique tile identifier
	 */
	private void generateRandom() {
		randint = r.nextInt(993)+7;
		if(!ids.contains(randint)) ids.add(randint);
		else {
			while(ids.contains(randint)) {
				randint = r.nextInt(993)+7;
			}
			ids.add(randint);
		}
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
	public void mouseClicked(MouseEvent e) {
		System.out.println(e.getButton() == 3);
		if(e.getButton() == 3){
			this.tile.toggleTile();
			if(this.tile.checkValid() && (!this.tile.isCovered() || !this.tile.checkMark())){
				this.tile.setBackground(Color.WHITE);
				this.tile.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
			}else if(!this.tile.checkValid()){
//				System.out.println("IS NOW INVALID");
				this.tile.setBackground(Color.decode("#4169aa"));
				this.tile.setBorder(BorderFactory.createLineBorder(Color.decode("#4169aa"), 1));
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	
	}
	
	public void mouseWheelMoved(MouseWheelEvent e) {
	}
	
	
	/**
	 * handle mouse move event
	 */
    public void mouseMoved(MouseEvent e) {
  

    	if(tile.getBoard().selectedPiece!=null && tile.getBoard().lifted && !tile.getBoard().penPiece && tile.getBoard().getID()!=4){
    		if(tile.getBoard().getID()==2 && lastBoard.getID()==3) {
    			lastBoard.refresh();
    			return;
    		}
     		int x = this.tile.getCoords()[0];
    		int y = this.tile.getCoords()[1];
    		
    		int tileID= this.tile.getTileID();
    		
    		this.tile.getBoard().refresh();
    		
    		this.tile.getBoard().drawHex(this.tile, x, y, Color.GREEN);
    		savedBoardState=tile.getBoard().returnBoard();
			greenbois=tile.getBoard().getGreenTiles();

				if(greenbois==6) {
					this.tile.getBoard().drawHex(this.tile, x, y, Color.GREEN);
				}
				//this.tile.getBoard().redraw();
	    		if(greenbois<6) {
	    			this.tile.getBoard().drawHex(this.tile, x, y, Color.RED);
	    		}

			

    		int id = tile.getBoard().getID();
    		if(id!=lastID) {
    			System.out.println("refresh!  "+lastBoard.getID());
    			lastBoard.refresh();
    		}
    		

  
    		lastTileID=tileID;
    		lastID = id;
    		lastBoard = board;
    		lastTile=tile;
    		

    	}else if (tile.getBoard().selectedPiece==null && tile.getBoard().getID()==4){
     		int x = this.tile.getCoords()[0];
    		int y = this.tile.getCoords()[1];
    		
    		BoardBoss.rotated = 1;
			this.tile.getBoard().refresh();
    	}
     }	
    public void mouseDragged(MouseEvent e) {
    	mouseMoved(e);
    }

}