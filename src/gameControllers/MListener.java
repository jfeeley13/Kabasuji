package gameControllers;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.event.MouseInputAdapter;

import entity.Board;
import entity.BoardBoss;
import entity.BullPen;
import entity.Hexomino;
import entity.Tile;


public class MListener extends MouseInputAdapter implements MouseListener, MouseMotionListener, MouseWheelListener{
	Tile tile;
	static int lastID;
	BoardBoss board;
	static BoardBoss lastBoard;

	
	public MListener(Tile tile, BoardBoss board){
		this.tile=tile;
		this.board = board;
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		
		//Code to show which tile is clicked on


		Point b = e.getLocationOnScreen();
		int x = (int) b.getX();
		int y = (int) b.getY();
		
		lastID = tile.getBoard().getID();
		//System.out.println("Row = " + y);
		//System.out.println("Col = " + x);
		System.out.println("Clicked!");

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
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	
	}
	
	public void mouseWheelMoved(MouseWheelEvent e) {
	       String message;
	       int notches = e.getWheelRotation();
	       
	       if (notches < 0) {
	    	   this.tile.getBoard().rotated = (this.tile.getBoard().rotated % 4) + 1;
	    	   if(this.tile.getBoard().rotateCheck(this.tile)) {
	    		   System.out.println(this.tile.getBoard().rotated);
		           this.tile.getBoard().refresh();
		           this.tile.getBoard().drawHex(this.tile, 1, 1);
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
		           this.tile.getBoard().drawHex(this.tile, 1, 1);

	    	   }
	    	   else {
	    		   if(this.tile.getBoard().rotated==4) this.tile.getBoard().rotated-=3;
	    		   else
	    			   this.tile.getBoard().rotated = (this.tile.getBoard().rotated % 4) + 1;
	    	   }
	    	   
	           
	           
	       }
	}
	
    public void mouseMoved(MouseEvent e) {
    	if(tile.getBoard().selectedPiece!=null && tile.getBoard().lifted && !tile.getBoard().penPiece) {
    		

    		Point b = e.getLocationOnScreen();
    		int x = (int) b.getX();
    		int y = (int) b.getY();
    		
    		

    		
    		this.tile.getBoard().refresh();

    		this.tile.getBoard().drawHex(this.tile, x, y);
   
    		int id = tile.getBoard().getID();
    		if(id!=lastID) {
  
    			lastBoard.refresh();

    		}
    		lastID = id;
    		lastBoard = board;

    	}
     }	

}
