package gameControllers;

import entity.BoardBoss;
import entity.Kabasuji;
import java.awt.event.MouseEvent;

public class BoardController {

	/** The game being played */
//	private Kabasuji theGame;
	
	/** The board being used */
	private BoardBoss board;
	
	public BoardController(/**Kabasuji theGame,*/ BoardBoss board){
//		this.theGame = theGame;
		this.board = board;
	}
}