package entity;

public class ReleaseTile extends Tile{

	protected String setColor;
	protected int setNum;
	
	public ReleaseTile(RowColumn rowCol, String setColor, int setNum) {
		super(rowCol);
		this.setColor = setColor;
		this.setNum = setNum;
	}

	@Override
	public boolean isCovered() {
		if(setColor == null) //if the tile has no set, it does not matter if this tile is covered or not, so return true
			return true;
		return this.isCovered();
	}
	
	

}
