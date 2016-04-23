package entity;

public class ReleaseTile extends Tile{

	protected String setColor;
	protected int setNum;
	
	public ReleaseTile(BoardBoss board, int row, int column, String setColor, int setNum, int width, int height) {
		super(board, row, column, width, height);
		this.setColor = setColor;
		this.setNum = setNum;
	}

}
