package entity;

import gameControllers.MListener;
import javax.swing.JPanel;
import gameControllers.MListener;


public abstract class Tile extends JPanel{
	private static final long serialVersionUID = 1L;
	protected int row;
	protected int column;
	protected boolean isCovered = false;
	protected int width = 32;
	protected int height = 32;
	protected boolean isNull = false;
	Board board;
	private RowColumn rowCol;


	public Tile(Board board, RowColumn rowCol) {
		this.rowCol = rowCol;
		this.board = board;
		//	this.addMouseListener(new MListener(this));
	}

	/**
	 * 
	 * Determines if tile is covered or not
	 * 
	 * @return True = Covered --- False = Not Covered
	 */
	public Board getBoard(){
		return this.board;
	}
	
	
	public void coverTile(){
		this.isCovered = true;
	}
	
	/**
	 * Toggles tile from null to not null
	 * Used in level editor only
	 * @return 
	 */

	public abstract boolean hasWon();
	
	public void toggleTile(){
		this.isNull = !this.isNull;
	}

	public RowColumn getRowCol() {
		return rowCol;
	}

	public void setRowCol(RowColumn rowCol) {
		this.rowCol = rowCol;
	}

	public boolean isCovered() {
		return isCovered;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}
	
	/**
	 * 
	 * Determines the location of the tile in a board or piece
	 * 
	 * @return (Row, Column) Coordinates of Selected Tile
	 */
	public RowColumn getCoords(){
		RowColumn coords = new RowColumn(row , column);
		return coords;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public boolean isNull() {
		return isNull;
	}

	public void setNull(boolean isNull) {
		this.isNull = isNull;
	}

	public void setCovered(boolean isCovered) {
		this.isCovered = isCovered;
	}
	
	public String toString(){
		return "Tile : Position " + rowCol.toString() + "isCovered: " + isCovered + " isNull = " + isNull;
	}

}


