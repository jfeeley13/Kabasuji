package entity;

public class Tile {
	
	protected boolean isCovered;
	protected String setColor;
	protected int setNum;
	
	public Tile (String setColor, int setNum){
		this.setColor = setColor; 
		this.setNum = setNum;
	}
	
	public boolean isCovered(){
		return false;
	}

	public boolean isNull(){
		return true;
	}
	
}


