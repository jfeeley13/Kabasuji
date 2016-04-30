package entity;

public class PuzzleTile extends Tile{
	
	protected int row;
	protected int column;
	
	public PuzzleTile(BoardBoss board, int row, int column, int tileID) {
		super(board, row, column, tileID);
		this.row = row;
		this.column = column;
	}
	
	public String toString(){
		return 	tileID + "\n"
				+ row + "\n" 
				+ column + "\n"
				+ isNull + "\n"
				+ "0" + "\n";
	}
	
}
