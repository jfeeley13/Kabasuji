package entity;

import java.awt.Color;

import javax.swing.JLabel;

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
	
	public void addSetNum(int num, Color color){
			JLabel tileText = new JLabel("");
			tileText.setText(Integer.toString(num));
//			tileTex
			this.board.returnBoard()[row][column].add(tileText);
	}

}
