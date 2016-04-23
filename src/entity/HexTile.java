package entity;

public class HexTile extends Tile{


	public HexTile(Board board, int row, int column) {
		super(board, row, column);
	}
	
	public void changeLocation(int newRow, int newCol){
		row = newRow;
		column = newCol;
	}
	
	
}
