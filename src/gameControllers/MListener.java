package gameControllers;

import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

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
	
	@Override
	public void mousePressed(MouseEvent e) {
		if(tile.getBoard().getID()==2) bullPen=tile.getBoard();
		lastID = tile.getBoard().getID();

		//System.out.println("Clicked!");
		
		//System.out.println("Piece id: " + ids.get(ids.size()-1));
		
		generateRandom();
	
		
		Hexomino hex;
		if(BoardBoss.selectedPiece==null) {
			hex = (Hexomino) BoardBoss.pieceList.get(tile.getTileID());
			

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
							System.out.println("Selected piece "+datboi);
							break;
					}
				}
			}
			System.out.println("Selected piece2 "+datboi);
			

					
			tile.getBoard().rotateFlip(datboi);
    		


		}
		
		if(!placed) {
			if(tile.getBoard().getID()==4) {
				tile.getBoard().drawHex(tile, tile.getCoords()[0], tile.getCoords()[1], Color.GREEN);
			}
			System.out.println("Didn't place anything!");
			ids.remove(ids.size()-1);
		
		}
		else {
			if(this.tile.getBoard().getID()==1) {
				if(lastBoard.getID()==2){
					bullPen.clearPen();
					int boardWidth =(bullPen.returnWidth()/2)-1;
					bullPen.refill=true;
					int pos = BoardBoss.bullPenPosition;
					generateRandom();
					bullPen.addHex(bullPen.returnBoard()[boardWidth][3], ids.get(ids.size()-1), Level.allhex.getHexList().get(pos));
					generateRandom();
					bullPen.addHex(bullPen.returnBoard()[boardWidth][11], ids.get(ids.size()-1), Level.allhex.getHexList().get(pos+1));
					generateRandom();
					bullPen.addHex(bullPen.returnBoard()[boardWidth][20], ids.get(ids.size()-1), Level.allhex.getHexList().get(pos+2));
					bullPen.refill=false;
					BoardBoss.bullPenPosition+=1;
			}

			}
			lastBoard = board;
		}
	}
	
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	
	}
	
	public void mouseWheelMoved(MouseWheelEvent e) {
	}
	
    public void mouseMoved(MouseEvent e) {
    	if(tile.getBoard().selectedPiece!=null && tile.getBoard().lifted && !tile.getBoard().penPiece && tile.getBoard().getID()!=4){
    		

    		int x = this.tile.getCoords()[0];
    		int y = this.tile.getCoords()[1];
    		
    		int tileID= this.tile.getTileID();
    		
    		this.tile.getBoard().refresh();
    		
    		this.tile.getBoard().drawHex(this.tile, x, y, Color.GREEN);
    		savedBoardState=tile.getBoard().returnBoard();
			greenbois=tile.getBoard().getGreenTiles();

			if(greenbois==6) {
				lastBoardState=savedBoardState.clone();
        		System.out.println("saved ");
			}
			

    		int id = tile.getBoard().getID();
    		if(id!=lastID) {
    			System.out.println("refresh!  "+lastBoard.getID());
    			lastBoard.refresh();
    		}
    		
    		
    			//this.tile.getBoard().redraw();
        		if(greenbois<6) {
            		System.out.println("less than 6 ");

        			this.tile.getBoard().setBoard(lastBoardState);
        			this.tile.getBoard().drawHex(this.tile, x, y, Color.GREEN);
        		}
    		
  
    		lastTileID=tileID;
    		lastID = id;
    		lastBoard = board;
    		lastTile=tile;
    		

    	}
     }	
    public void mouseDragged(MouseEvent e) {
    	mouseMoved(e);
    }

}