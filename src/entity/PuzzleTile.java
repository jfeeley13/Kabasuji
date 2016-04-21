package entity;

public class PuzzleTile extends Tile{
	
	protected int row;
	protected int column;
	
	public PuzzleTile(RowColumn rowCol) {
		super(rowCol);
	}

	@Override
	public boolean hasWon() {
		return this.isCovered();
	}
	
}
