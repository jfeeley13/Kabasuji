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
	public boolean hasWon() {
		return isCovered() && (setColor != null);
	}

	

}
