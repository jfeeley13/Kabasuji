package gameControllers;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import entity.Tile;
import views.Builder;
import views.Level;

public class RotateController implements ActionListener {
	//Piece piece
	int num; 			//1 for flip < and 2 for flip >
	Tile tile;
	
	/**
	 * 
	 * @param builder, int num current level view to be modified
	 */
	public RotateController(Tile selected, int number){
		//this.currentLevel = builder, int num;
		tile=selected;
		num=number;
	}
	
	/**
	 * entry method
	 */

	@Override
	public void actionPerformed(ActionEvent arg0) {
		tile = MListener.datboi;
		this.tile.getBoard().rotated+=1;
		this.tile.getBoard().drawHex(this.tile, 1, 1, Color.GREEN);
		if(true) return;
		//System.out.println("!!!! tile "+tile);
		System.out.println("TILE NULL =" +this.tile == null);
		
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
	   }
	}
}