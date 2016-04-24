package entity;

public class HexTile extends Tile{


	public HexTile(BoardBoss board, int row, int column, int width, int height, int tileID) {
		super(board, row, column, width, height, tileID);
	}
	
	public void changeLocation(int newRow, int newCol){
		row = newRow;
		column = newCol;
	}
	
}
