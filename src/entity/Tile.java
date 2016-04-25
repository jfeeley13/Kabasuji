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
	protected int width = 32;
	protected int height = 32;
	public int valid=1;
	protected boolean isNull = false;
	JPanel panel;//the panel that the tile is on. Eitherboard or bullpen
	
	
	public Tile (JPanel panel, int row, int column){
		this.row = row;
		this.column = column;
		this.panel=panel;
		this.addMouseListener(new MListener(this));
		
	}

	/**
	 * 
	 * Determines if tile is covered or not
	 * 
	 * @return True = Covered --- False = Not Covered
	 */
	public JPanel getBoard(){
		return this.panel;
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


