package entity;

public class ReleaseTile extends Tile{

	protected String setColor;
	protected int setNum;
	
	public ReleaseTile(BoardBoss board, int row, int column, String setColor, int setNum, int tileID) {
		super(board, row, column, tileID);
		this.setColor = setColor;
		this.setNum = setNum;
	}
	
	@Override
	public boolean hasWon(){
		if(setColor == null)
			return true;
		else if(this.isCovered)
			return true;
		return false;
					
	}

	public String toString(){
		return "Tile " + tileID + " " + "ReleaseTile" + " "
				+ row+" " 
				+column + " "
				+setColor+ " " 
				+ setNum + " " + isNull;
	}
	
}
