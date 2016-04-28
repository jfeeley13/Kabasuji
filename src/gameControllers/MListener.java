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
		if(!placed) {
			System.out.println("Didn't place anything!");
			ids.remove(ids.size()-1);
		
		}
		else {
			if(this.tile.getBoard().getID()==1) {
				bullPen.clearPen();
				bullPen.refill=true;
				generateRandom();
				int quickrand = r.nextInt(2)+1;
				bullPen.addHex(bullPen.returnBoard()[6][1], ids.get(ids.size()-1), Level.allhex.getHexList().get(quickrand));
				generateRandom();
				quickrand = r.nextInt(2)+1;
				bullPen.addHex(bullPen.returnBoard()[6][9], ids.get(ids.size()-1), Level.allhex.getHexList().get(quickrand));
				generateRandom();
				quickrand = r.nextInt(2)+1;
				bullPen.addHex(bullPen.returnBoard()[6][17], ids.get(ids.size()-1), Level.allhex.getHexList().get(quickrand));
				bullPen.refill=false;
			}
			
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
	       String message;
	       int notches = e.getWheelRotation();
	       /**
	       if(this.tile.getBoard().getID()==2){
	    	   if (notches < 0) {
	    		   this.tile.getBoard().rotated = (this.tile.getBoard().rotated % 4) + 1;
	    		   if(this.tile.getBoard().rotateCheck(this.tile)) {
	    			   System.out.println(this.tile.getBoard().rotated);
	    			   this.tile.getBoard().refresh();
	    			   this.tile.getBoard().drawHex(this.tile, 1, 1, Color.GREEN);
	    		   }
	    		   else {
	    			   this.tile.getBoard().rotated = (this.tile.getBoard().rotated % 4) - 1;
	    		   }
	           
	           
	    	   } else {
	    		   this.tile.getBoard().rotated = (this.tile.getBoard().rotated % 4) - 1;
	    		   if(this.tile.getBoard().rotated<=0) this.tile.getBoard().rotated+=4;
	    		   if(this.tile.getBoard().rotateCheck(this.tile)) {
	    		   
	    			   System.out.println(this.tile.getBoard().rotated);
	    			   this.tile.getBoard().refresh();
	    			   this.tile.getBoard().drawHex(this.tile, 1, 1, Color.GREEN);

	    		   }
	    		   else {
	    			   if(this.tile.getBoard().rotated==4) 
	    				   this.tile.getBoard().rotated-=3;
	    			   else
	    				   this.tile.getBoard().rotated = (this.tile.getBoard().rotated % 4) + 1;
	    		   }
	    	   
	           
	    	   }
	       }
	       **/
	}
	
    public void mouseMoved(MouseEvent e) {
    	if(tile.getBoard().selectedPiece!=null && tile.getBoard().lifted && !tile.getBoard().penPiece) {
    		
    		int x = this.tile.getCoords()[0];
    		int y = this.tile.getCoords()[1];
    		
    		int tileID= this.tile.getTileID();
    		
    		
    		
    		this.tile.getBoard().refresh();
    		if(this.tile.getBoard().borderCheck(this.tile)) {
    			this.tile.getBoard().drawHex(this.tile, x, y, Color.GREEN);
    			lastGoodTile=this.tile;
    		}
    		else 	
    			this.tile.getBoard().drawHex(this.tile, x, this.tile.getBoard().returnHeight()-6, Color.GREEN);


    		int id = tile.getBoard().getID();
    		if(id!=lastID) 
    			lastBoard.refresh();
  
    		if(tileID!=lastTileID && id==lastID) 
    			this.tile.getBoard().redraw();
  

    		lastID = id;
    		lastBoard = board;

    	}
     }	
    public void mouseDragged(MouseEvent e) {
    	mouseMoved(e);
    }

}
