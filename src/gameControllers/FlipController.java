package gameControllers;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import entity.BoardBoss;
import entity.Tile;
import views.Builder;
import views.Level;

public class FlipController implements ActionListener{
	Tile tile;
	int num;
	//Piece piece
	
	/**
	 * 
	 * @param level Level view to be edited
	 */
	
	public FlipController(Tile currentTile, int i) {
		this.tile=currentTile;
		this.num=i;
	}
	

	/**
	 * action method
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		tile=MListener.datboi;
		if(num==1) {
			if(BoardBoss.flipped==1) 
				BoardBoss.flipped=2;
			else if(BoardBoss.flipped==4)
				BoardBoss.flipped=5;
			else
				BoardBoss.flipped=1;

		}
		else if (num==2) {
			if(BoardBoss.flipped==4)
				BoardBoss.flipped=3;
			else if(BoardBoss.flipped==4 && BoardBoss.flipped==1 || BoardBoss.flipped==2)
				BoardBoss.flipped=5;
			else
				BoardBoss.flipped=4;
			
		}
		this.tile.getBoard().refresh();
		this.tile.getBoard().drawHex(tile, 1, 1, Color.GREEN);
		
	}
}