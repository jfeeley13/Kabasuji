package entity;

public class HexTile extends Tile{

	public HexTile(RowColumn rowCol) {
		super(rowCol);
	}
	
	public void changeLocation(int newRow, int newCol){
		RowColumn newRowCol = new RowColumn(newRow, newCol);
		this.setRowCol(newRowCol); 
	}

	@Override
	public boolean isCovered() {
		return false;
	}
	
}
