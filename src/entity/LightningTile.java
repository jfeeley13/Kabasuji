package entity;

public class LightningTile extends Tile{

	protected boolean marked = false;
	
	public LightningTile(BoardBoss board, int row, int column, int tileID) {
		super(board, row, column, tileID);
	}
	
	public void markTile(){
		marked = true;
	}
	
	public String toString(){
		return 	tileID + "\n" 
				+ row + "\n" 
				+ column + "\n"
				+ isNull + "\n"
				+ "1" + "\n";
	}

	
	
}
