package builderControllers;

import views.Level;
import entity.Board;

public class AddTileController {
	Board board;
	Level levelView;
	
	/**
	 * 
	 * @param levelView Boundary object representing the level
	 * @param board	Entity object representing the board
	 */
	public AddTileController(Level levelView, Board board){
		this.board = board;
		this.levelView = levelView;
	}
	
	/**
	 * entry method
	 */
	public void entry(){
		
	}
}
