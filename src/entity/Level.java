package entity;

import java.util.ArrayList;

import javax.swing.Box.Filler;

public class Level {
	
	protected int lvlID;
	protected boolean locked;
	protected int starsAcheived;
	protected Board board;
	protected BullPen pen;
	String type;
	int rows, columns;
	ArrayList<Hexomino> solutionPieces; //this attribute will contain the pieces of the level, which will be copied and put into the bullpen
	//this way we have a copy always of the solution pieces and can always restart easily the bullpen and the game with this.
	
	public Level(int lvlID, String type){
		this.lvlID = lvlID;
		this.type = type;
		starsAcheived = 0;
		initializeLevel();
	}
	
	public void initializeLevel(){
		this.board = new Board();
		if(type.equals("Puzzle")){
			board.makeBoard(new PuzzleTile[rows][columns], rows, columns, 1);
		}

		else if(type.equals("Lighting"))
			board.makeBoard(new LightningTile[rows][columns], rows, columns, 1);
		else
			board.makeBoard(new ReleaseTile[rows][columns], rows, columns, 1);
			//board.fillArray(typeOfTile);
		//still need to fill array here
		//initialize bullPen
		//TODO: finish
	}
	/**
	 * 
	 * @return
	 */
	public boolean levelComplete(){
		return board.hasWon();
		//TODO: currently this only checks the winning condition of 3start
	}
	
	public void setBoardDimensions(int newRows, int newColumns){
		this.rows = newRows;
		this.columns = newColumns;
		board.resizeBoardArray(newRows, newColumns);
	}
	
	public void addPiecesToSolution(Hexomino hex){
		solutionPieces.add(hex);
	}
	
	public String toString(){
		return lvlID + "/n" + starsAcheived + "/n" + solutionPieces.toString() + "/n"
				+ " Board \n" + board.toString();
	}
	
	
	
}
