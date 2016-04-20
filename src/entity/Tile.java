package entity;

public abstract class Tile {
	protected RowColumn rowCol;
	protected boolean isCovered;
	protected int width = 32;
	protected int height = 32;
	protected boolean isNull = false;
	
	
	public Tile (RowColumn rowCol){
		this.rowCol = rowCol;
	}

	/**
	 * 
	 * Determines if tile is covered or not
	 * 
	 * @return True = Covered --- False = Not Covered
	 */
	public boolean isCovered(){
		return isCovered;
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
	public RowColumn getLocation(){
		return rowCol;
	}
}


