package entity;

public class LightningTile extends Tile{

	protected boolean isMarked = false;
	
	public LightningTile(BoardBoss board, int row, int column, int tileID) {
		super(board, row, column, tileID);
	}
	
	public boolean hasWon(){
		return this.checkMark();
	}
	
	public void markTile(){
		isMarked = true;
	}
	
	public String toString(){
		return 	tileID + "\n" 
				+ row + "\n" 
				+ column + "\n"
				+ isValid + "\n"
				+ "1" + "\n";
	}

	public void coverTile(){
		markTile();
	}
	
	public boolean checkMark(){
		return isMarked;
	}
	
}
