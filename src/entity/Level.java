package entity;

import java.util.ArrayList;

import javax.swing.Box.Filler;

public class Level {
	
	protected int lvlID;
	protected boolean locked;
	protected int starsAcheived;
	protected Board board;
	protected BullPen pen;
	int rows, columns;
	ArrayList<Hexomino> solutionPieces; //this attribute will contain the pieces of the level, which will be copied and put into the bullpen
	//this way we have a copy always of the solution pieces and can always restart easily the bullpen and the game with this.
	
	public Level(int lvlID){
		this.lvlID = lvlID;
		starsAcheived = 0;
	}
	
	public void initializeLevel(String type){
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

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}
	
	
	
	
	
}
