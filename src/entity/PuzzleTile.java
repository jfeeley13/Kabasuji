package entity;

public class PuzzleTile extends Tile{
	
	protected int row;
	protected int column;
	
	public PuzzleTile(BoardBoss board, int row, int column, int width, int height) {
		super(board, row, column, width, height);
	}
	
	
}
