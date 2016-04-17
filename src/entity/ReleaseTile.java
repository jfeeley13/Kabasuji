package entity;

public class ReleaseTile extends Tile{

	protected String setColor;
	protected int setNum;
	
	public ReleaseTile(int row, int column, String setColor, int setNum) {
		super(row,column);
		this.setColor = setColor;
		this.setNum = setNum;
	}

}
