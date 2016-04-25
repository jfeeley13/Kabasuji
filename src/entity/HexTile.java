package entity;

import javax.swing.JPanel;

public class HexTile extends Tile{

	public int belongsTo;
	public HexTile(int belongsTo,JPanel panel, int row, int column) {
		super(panel, row, column);
		this.belongsTo=belongsTo;
	}
	
	public void changeLocation(int newRow, int newCol){
		row = newRow;
		column = newCol;
	}
	
	public int getAssocHexID(){
		return belongsTo;
	}
}
