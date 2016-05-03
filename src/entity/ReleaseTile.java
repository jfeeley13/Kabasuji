package entity;

public class ReleaseTile extends Tile{

	protected String setColor;
	protected int setNum;
	
	public ReleaseTile(BoardBoss board, int row, int column, int tileID) {
		super(board, row, column, tileID);
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
		return 	tileID + "\n" 
				+ row + "\n" 
				+ column + "\n"
				+ isNull + "\n"
				+ "2" + "\n"
				+ setColor + "\n" 
				+ setNum + "\n";
	}

	public String getSetColor() {
		return setColor;
	}

	public void setSetColor(String setColor) {
		this.setColor = setColor;
	}

	public int getSetNum() {
		return setNum;
	}

	public void setSetNum(int setNum) {
		this.setNum = setNum;
	}
	
	
	
}
