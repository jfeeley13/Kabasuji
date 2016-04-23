package entity;

public class PuzzleTile extends Tile{
	
	protected int row;
	protected int column;
	
	public PuzzleTile(Board board, RowColumn rowCol) {
		super(board, rowCol);
	}

	@Override
	public boolean hasWon() {
		return this.isCovered();
	}
	
}
