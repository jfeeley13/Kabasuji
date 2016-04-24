package entity;

public class HexTile extends Tile{


	public HexTile(Board board, RowColumn rowCol) {
		super(board, rowCol);

	}
	
	public void changeLocation(int newRow, int newCol){
		RowColumn newRowCol = new RowColumn(newRow, newCol);
		this.setRowCol(newRowCol); 
	}

	@Override
	public boolean isCovered() {
		return false;
	
	}

	@Override
	public boolean hasWon() {
		return false;
	}
	
	
}
