package builderControllers;

import views.Level;
import entity.Board;

public class ChangeBoardSizeController {
	Board board;
	Level levelView;
	
	/**
	 * 
	 * @param levelView Boundary object representing the level
	 * @param board Entity object representing the board
	 */
	public ChangeBoardSizeController(Level levelView, Board board){
		this.board = board;
		this.levelView = levelView;
	}
	/**
	 * Entry method
	 */
	public void entry(){
		
	}
}
