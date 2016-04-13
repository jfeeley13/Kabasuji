package gameControllers;

import entity.Hexomino;
import views.Level;

public class RotateController {
	Hexomino piece;
	Level currentLevel;
	
	/**
	 * 
	 * @param curreLevel current level view to be modified
	 */
	public RotateController(Level curreLevel, Hexomino piece){
		this.currentLevel = curreLevel;
		this.piece = piece;
	}
	
	/**
	 * entry method
	 */
	public void entry(){
		
	}
}
