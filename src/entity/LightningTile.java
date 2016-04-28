package entity;

public class LightningTile extends Tile{

	protected boolean marked;
	
	public LightningTile(BoardBoss board, int row, int column, int tileID) {
		super(board, row, column, tileID);
	}
	
	public void markTile(){
		
	}
	
	public String toString(){
		return "Tile " + tileID + " "+"LightingTile"+ " " +row+" " +column + " "  + isNull; 
	}

	
	
}
