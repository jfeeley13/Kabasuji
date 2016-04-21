package entity;

public class LightningTile extends Tile{

	protected boolean marked; //marked is isCovered in Tile superclass, so this is not needed right?
	
	public LightningTile(RowColumn rowCol) {
		super(rowCol);
		marked = false;
	}
	
	public void markTile(){
		marked = true;
	}
	
}
