package entity;

import javax.swing.JPanel;

import gameControllers.MListener;

public abstract class Tile extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected int row;
	protected int column;
	protected boolean isCovered = false;
	protected boolean isNull = false;
	protected int tileID;
	BoardBoss board;
	protected boolean isHighlight = false;
	
	
	public Tile (BoardBoss board, int row, int column,int tileID){
		this.row = row;
		this.column = column;
		this.board=board;
		this.addMouseListener(new MListener(this, board));
		this.addMouseMotionListener(new MListener(this, board));
		this.addMouseWheelListener(new MListener(this, board));
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
		this.isNull = !this.isNull;
	}
	
	
	/**
	 * 
	 * Determines if tile is null or not
	 * 
	 * @return True = Null --- False = Not Null
	 */
	
	public boolean isNull(){
		return isNull;
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
	
	
}


