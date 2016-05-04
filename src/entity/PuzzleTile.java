package entity;

public class PuzzleTile extends Tile{
	
	public PuzzleTile(BoardBoss board, int row, int column, int tileID) {
		super(board, row, column, tileID);
	
	
	}
	
	
	
	public String toString(){
		return 	tileID + "\n" 
				+ row + "\n" 
				+ column + "\n"
				+ isValid + "\n"
				+ "0" + "\n";
	}
	
	public boolean canPickUp(){
		return true;
	}
	
	
}
