package gameControllers;

import entity.Board;
import entity.Kabasuji;
import java.awt.event.MouseEvent;

public class BoardController {

	/** The game being played */
//	private Kabasuji theGame;
	
	/** The board being used */
	private Board board;
	
	public BoardController(/**Kabasuji theGame,*/ Board board){
//		this.theGame = theGame;
		this.board = board;
	}
}