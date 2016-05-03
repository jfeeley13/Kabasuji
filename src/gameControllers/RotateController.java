package gameControllers;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import entity.Tile;
import views.Builder;
import views.Level;

public class RotateController implements ActionListener {
	//Piece piece
	Level currentLevel;
	int num; 			//1 for flip < and 2 for flip >
	Tile tile;
	
	/**
	 * 
	 * @param builder, int num current level view to be modified
	 */
	public RotateController(Builder builder, Tile selected){
		//this.currentLevel = builder, int num;
		tile=selected;
		
	}
	
	/**
	 * entry method
	 */
	public void entry(){
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
//		System.out.println();
		this.tile.getBoard().rotated = (this.tile.getBoard().rotated % 4) + 1;
		   if(this.tile.getBoard().rotateCheck(this.tile)) {
//			   System.out.println(this.tile.getBoard().rotated);
			   this.tile.getBoard().refresh();
			   this.tile.getBoard().drawHex(this.tile, 1, 1, Color.GREEN);
		   }
		   else {
			   this.tile.getBoard().rotated = (this.tile.getBoard().rotated % 4) - 1;
		   }
 
 
	    //else {
		   this.tile.getBoard().rotated = (this.tile.getBoard().rotated % 4) - 1;
		   if(this.tile.getBoard().rotated<=0) this.tile.getBoard().rotated+=4;
		   if(this.tile.getBoard().rotateCheck(this.tile)) {
		   
//			   System.out.println(this.tile.getBoard().rotated);
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
//}

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


/** IN HEXOMINO!!
 * Rotates Hexomino CW or CCW
 * 
 * @param direction: true = CW or false = CCW


public void rotate(boolean direction){
	//CW  Rotation ---newRow = currCol--newCol = currRow*-1
	//CCW Rotation ---newRow = currCol*-1-----newCol = currRow
	//Initialize at CCW Rotation
	int dir = 1;
	if(direction)//If CW Rotation
		dir = -1;
	for (int TileNum = 0; TileNum >= 5; TileNum++){
			int currRow = shape[TileNum].getCoords()[0];
			int currCol = shape[TileNum].getCoords()[1];
			shape[TileNum].changeLocation(dir*(-1)*currCol, dir*currRow);
		}
} */
