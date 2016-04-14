package builderControllers;

import views.Level;
import entity.Board;

public class DeleteTileController {
	Board board;
	Level levelView;
	
	/**
	 * 
	 * @param levelView Boundary object representing the level
	 * @param board	Entity object representing the board
	 */
	public DeleteTileController(Level levelView, Board board){
		this.board = board;
		this.levelView = levelView;
	}
	
	/**
	 * entry method
	 */
	public void entry(){
		
	}
}
