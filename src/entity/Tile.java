package entity;

public abstract class Tile {
	
	protected int row;
	protected int column;
	protected boolean isCovered;
	protected int width;
	protected int height;
	
	
	public Tile (int row, int column){
		this.row = row;
		this.column = column;
	}
	
	public boolean isCovered(){
		return false;
	}
	
	//Toggles from null to non-null
	public void toggleTile(){
		
	}
	
	public boolean isNull(){
		return true;
	}
	
	public int getTileWidth(){
		return width;
	}
	
	public int getTileHeight(){
		return height;
	}
	
	public int[] getLocation(){
		int coords[] = {row , column};
		return coords;
	}
}


