package entity;

import java.awt.Color;

import javax.swing.JPanel;

import gameControllers.MListener;

public abstract class Tile extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public boolean isOrigin;
	protected int row;
	protected int column;
	protected boolean isCovered = false;
	protected boolean isValid = true;
	protected int tileID;
	BoardBoss board;
	protected boolean isHighlight = false;
	
	
	public Tile (BoardBoss board, int row, int column,int tileID){
		this.row = row;
		this.column = column;
		this.board=board;
		this.addMouseListener(new MListener(this, board));
		this.addMouseMotionListener(new MListener(this, board));
		//this.addMouseWheelListener(new MListener(this, board));
		this.tileID = tileID;
	}
	
	public  boolean hasWon(){
		return this.isCovered;
	}

	/**
	 * 
	 * Determines if tile is covered or not
	 * 
	 * @return True = Covered --- False = Not Covered
	 */
	public BoardBoss getBoard(){
		return this.board;
	}
	
	/**
	 * 
	 * @return true = tile is covered ---- false = not Covered
	 */
	public boolean isCovered(){
		return isCovered;
	}
	
	public void coverTile(){
		this.isCovered = true;
	}
	
	/**
	 * Toggles tile from null to not null
	 * Used in level editor only
	 */
	
	public void toggleTile(){
		this.isValid = !this.isValid;
	}
	
	
	/**
	 * 
	 * Determines if tile is valid or not
	 * 
	 * @return True = Valid --- False = Not valid
	 */
	
	public boolean checkValid(){
		return isValid;
	}

	
	public boolean isHighlight() {
		return isHighlight;
	}
	
	public void setHighlight(boolean b) {
		isHighlight = b;
	}

	
	public void setTileID(int id) {
		tileID=id;
	}
	
	public int getTileID() {
		return tileID;
	}
	
	/**
	 * 
	 * Determines the location of the tile in a board or piece
	 * 
	 * @return (Row, Column) Coordinates of Selected Tile
	 */
	public int[] getCoords(){
		int coords[] = {row , column};
		return coords;
	}
	
	/**
	 	 * 
	 	 * @return true = tile is marked ---- false = not Marked
	 	 */
	public boolean checkMark(){
		 		return false;
			}
	
	public void addSetNum(int i, Color color) {		      
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}
	public boolean canPickUp(){
		return false;
	}
	
}


