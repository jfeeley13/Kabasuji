package entity;

public class LightningTile extends Tile{

	protected boolean marked; //marked is isCovered in Tile superclass, so this is not needed right?
	

	public LightningTile(Board board, RowColumn rowCol) {
		super(board, rowCol);
		marked = false;
	}
	
	public void markTile(){
		marked = true;
	}

	@Override
	public boolean hasWon() {
		return marked;
	}
	
}
