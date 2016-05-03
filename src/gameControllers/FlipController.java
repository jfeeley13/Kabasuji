package gameControllers;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import entity.Tile;
import views.Builder;
import views.Level;

public class FlipController implements ActionListener{
	Level level;
	Tile tile;
	int num;
	//Piece piece
	
	/**
	 * 
	 * @param level Level view to be edited
	 */
	
	public FlipController(Builder builder, Tile currentTile, int i) {
		this.tile=currentTile;
		this.num=i;
	}
	

	/**
	 * action method
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		/*//this.tile.getBoard().
		if(num==1)//If VFlip
			//dir = -1;
			
			tile.
		for (int TileNum = 0; TileNum >= 5; TileNum++){
				int currRow = shape[TileNum].getCoords()[0];
				int currCol = shape[TileNum].getCoords()[1];
				shape[TileNum].changeLocation(dir*(-1)*currRow, dir*currCol);
			}
		
		
		 * 
		 * 
		 * 
		tile = MListener.datboi;
		if(num==1){
		this.tile.getBoard().rotated = (this.tile.getBoard().rotated % 4) + 1;
		   if(this.tile.getBoard().rotateCheck(this.tile)) {
			   this.tile.getBoard().refresh();
			   this.tile.getBoard().drawHex(this.tile, 1, 1, Color.GREEN);
		   }
		   else {
			   this.tile.getBoard().rotated = (this.tile.getBoard().rotated % 4) - 1;
		   }
		}
 
 
	    else {
		   this.tile.getBoard().rotated = (this.tile.getBoard().rotated % 4) - 1;
		   if(this.tile.getBoard().rotated<=0) this.tile.getBoard().rotated+=4;
		   if(this.tile.getBoard().rotateCheck(this.tile)) {
		   
			   this.tile.getBoard().refresh();
			   this.tile.getBoard().drawHex(this.tile, 1, 1, Color.GREEN);

		   }
		   else {
			   if(this.tile.getBoard().rotated==4) 
				   this.tile.getBoard().rotated-=3;
			   else
				   this.tile.getBoard().rotated = (this.tile.getBoard().rotated % 4) + 1;
		   }
	   }*/
		
	}
}

