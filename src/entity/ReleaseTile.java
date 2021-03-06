package entity;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import views.Level;

public class ReleaseTile extends Tile{

	protected Color setColor= Color.BLACK;
	protected int setNum=0;
	JPanel pArray[][]=Level.PanelArray;
	
	public ReleaseTile(BoardBoss board, int row, int column, int tileID) {
		super(board, row, column, tileID);
	}
	
	@Override
	public boolean hasWon(){
//		boolean answer = false;
		int RowA = 0;
		int RowB = 0;
		int RowC = 0;
		for (int i = 0; i<=5; i++){
			if(pArray[0][i].getBackground() == Color.GREEN) RowA++;
			if(pArray[1][i].getBackground() == Color.ORANGE) RowB++;
			if(pArray[2][i].getBackground() == Color.PINK) RowC++;
		}
		if(RowA == 6 && RowB == 6 && RowC == 6){
			return true;
		}
		return false;
	}
	
	public void addSetNum(int num, Color color){
		setNum = num;
		setColor = color;
		JLabel tileText = new JLabel("");
		tileText.setText(Integer.toString(num));
		tileText.setForeground(color);
		tileText.setVerticalAlignment(SwingConstants.CENTER);
		tileText.setHorizontalAlignment(SwingConstants.CENTER);
		tileText.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		this.add(tileText);
	}

	public String toString(){
		return 	tileID + "\n" 
				+ row + "\n" 
				+ column + "\n"
				+ isValid + "\n"
				+ "2" + "\n"
				+ setColor + "\n" 
				+ setNum + "\n";
	}
	public void coverTile(){
		this.isCovered=true;
		if(setColor != Color.BLACK&& setNum != 0){
			if(setColor == Color.GREEN){
				pArray[0][setNum-1].setBackground(setColor);
			}else if(setColor == Color.ORANGE){
				pArray[1][setNum-1].setBackground(setColor);
			}else if(setColor == Color.PINK){
				pArray[2][setNum-1].setBackground(setColor);
			}
		}
	}
	
	public Color getSetColor() {
		return setColor;
	}

	public void setSetColor(Color setColor) {
		this.setColor = setColor;
	}

	public int getSetNum() {
		return setNum;
	}

	public void setSetNum(int setNum) {
		this.setNum = setNum;
	}
	
	
	
}
