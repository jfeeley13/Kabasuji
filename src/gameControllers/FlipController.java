package gameControllers;

import entity.Hexomino;
import views.Level;


public class FlipController {
	Level level;
	Hexomino piece;
	
	/**
	 * @param piece Piece to be flipped
	 * @param level Level view to be edited
	 */
	public FlipController(Level level, Hexomino piece){
		this.level = level;
		this.piece = piece;
	}
	
	/**
	 * Entry method
	 */
	public void entry(){
		
	}
}
