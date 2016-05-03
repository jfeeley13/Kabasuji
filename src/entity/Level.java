package entity;

import java.util.ArrayList;

import javax.swing.Box.Filler;

public class Level {
	
	protected int lvlID;
	protected boolean locked;
	protected int starsAcheived;
	protected Board board;
	protected BullPen pen;
	ArrayList<Hexomino> solutionPieces; //this attribute will contain the pieces of the level, which will be copied and put into the bullpen
	//this way we have a copy always of the solution pieces and can always restart easily the bullpen and the game with this.
	
	public Level(int lvlID){
		this.lvlID = lvlID;
		starsAcheived = 0;
	}
	
	/**
	 * Initializes the board of a level based on the type it is
	 * @param type String representing the  type of boardit is
	 * @return the board of the lvel, now initialized
	 */
	public Board initializeBoard(String type, int rows, int columns){
		this.board = new Board();
		
		if(type.equals("Puzzle Level")){
			board.makeBoard(new PuzzleTile[rows][columns], rows, columns, 1);
			board.fillArray(new PuzzleTile(board, 0, 0, 999));
		}

		else if(type.equals("Lighting Level")){
			board.makeBoard(new LightningTile[rows][columns], rows, columns, 1);
			board.fillArray(new LightningTile(board, 0, 0, 999));
		}
		else{
			board.makeBoard(new ReleaseTile[rows][columns], rows, columns, 1);
			board.fillArray(new ReleaseTile(board, 0, 0, 999));
		}
		
		return board;
	}
	/**
	 * 
	 * @return
	 */
	public boolean levelComplete(){
		return board.hasWon();
	}
	
	/**
	 * Changes the dimensions of the board object
	 * @param newRows
	 * @param newColumns
	 * @return the newly created board
	 */
	public Board setBoardDimensions(int newRows, int newColumns){
		return board.resizeBoardArray(newRows, newColumns);
	}
	
	public void addPiecesToSolution(Hexomino hex){
		solutionPieces.add(hex);
	}
	
	public String toString(){
		return lvlID + "/n" + starsAcheived + "/n" + solutionPieces.toString() 
				+ " Board \n" + board.toString();
	}

	public int getLvlID() {
		return lvlID;
	}

	public void setLvlID(int lvlID) {
		this.lvlID = lvlID;
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	public int getStarsAcheived() {
		return starsAcheived;
	}

	public void setStarsAcheived(int starsAcheived) {
		this.starsAcheived = starsAcheived;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public BullPen getPen() {
		return pen;
	}

	public void setPen(BullPen pen) {
		this.pen = pen;
	}


	
	
	
	
	
}
