package entity;

import java.util.ArrayList;

public class Level {
	
	protected int lvlID;
	protected boolean locked;
	protected int starsAcheived;
	protected Board board;
	protected BullPen pen;
	String type;
	protected ArrayList<Hexomino> solutionPieces;
	public Level(int lvlID, String type){
		this.lvlID = lvlID;
		this.type = type;
	}
	
	public void initializeLevel(){
		this.board = new Board();
	}
	
	public boolean levelComplete(){
		return board.hasWon();
	}

	public void setBoardDimensions(int rows, int columns) {
		// TODO Auto-generated method stub
		
	}
	
	
}
