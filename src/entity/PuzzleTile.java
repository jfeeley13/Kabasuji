package entity;

public class PuzzleTile extends Tile{
	
	public PuzzleTile(BoardBoss board, int row, int column, int tileID) {
		super(board, row, column, tileID);
	
	
	}
	
	public String toString(){
		return 	tileID + "\n" 
				+ row + "\n" 
				+ column + "\n"
				+ isNull + "\n"
				+ "0" + "\n";
	}
	
	
}
