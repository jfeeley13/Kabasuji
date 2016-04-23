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
	protected int width;
	protected int height;
	protected boolean isNull = false;
	BoardBoss board=new Board();
	
	
	public Tile (BoardBoss board, int row, int column, int w,int h){
		this.row = row;
		this.column = column;
		this.board=board;
		this.addMouseListener(new MListener(this));
		this.width = w;
		this.height = h;
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
	
	/**
	 * 
	 * @return Width of tile in Pixels
	 * 
	 */
	public int getTileWidth(){
		return width;
	}

	/**
	 * 
	 * @return Height of tile in Pixels
	 * 
	 */
	public int getTileHeight(){
		return height;
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
}


