package entity;

public class HexTile extends Tile{


	public HexTile(BoardBoss board, int row, int column, int tileID) {
		super(board, row, column, tileID);
	}
	
	/**
	 * change location of hextile
	 * @param newRow
	 * @param newCol
	 */
	public void changeLocation(int newRow, int newCol){
		row = newRow;
		column = newCol;
	}
	
}
