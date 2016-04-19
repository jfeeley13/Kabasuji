package entity;

public class HexTile extends Tile{

	public HexTile(int row, int column) {
		super(row, column);
	}
	
	public void changeLocation(int newRow, int newCol){
		row = newRow;
		column = newCol;
	}
	
}
