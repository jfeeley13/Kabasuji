package entity;

public abstract class Tile {
	private RowColumn rowCol;
	private boolean isCovered;
	private int width = 32;
	private int height = 32;
	private boolean isNull = false;
	
	
	public Tile (RowColumn rowCol){
		this.rowCol = rowCol;
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


