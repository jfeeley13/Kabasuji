package entity;

public class PuzzleTile extends Tile{
	
	public PuzzleTile(BoardBoss board, int row, int column, int tileID) {
		super(board, row, column, tileID);
	
	
	}
	
	
	public String toString(){
		return "Tile " + tileID + " "+"PuzzleTile"+ " " +row+" " +column + " "  + isNull; 
	}
}
