package entity;

public class ReleaseTile extends Tile{

	protected String setColor;
	protected int setNum;
	
	public ReleaseTile(Board board, int row, int column, String setColor, int setNum) {
		super(board,row,column);
		this.setColor = setColor;
		this.setNum = setNum;
	}

}
