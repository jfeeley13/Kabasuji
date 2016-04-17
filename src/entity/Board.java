package entity;

import java.awt.Point;

public class Board {
	
	protected Tile tileBoard[];
	protected Hexomino hexPlaced[];
	
	public Board(Tile tileBoard[]){
		this.tileBoard = tileBoard;
	}
	
	
	public boolean checkCollision(Hexomino reqHex){
		return false;
	}
	
	public int checkNumOfHex(){		
		return hexPlaced.length;
	}
	
	public boolean addHex(Hexomino hex){
		boolean isValid = true;
		return isValid;
	}
	
	public boolean removeHex(Hexomino hex){
		boolean isValid = true;
		return isValid;
	}
	//Can throw NullTileException
	public Tile getTile(int x, int y){
		int tile = 0;
		return tileBoard[tile];
	}
	//Can throw NullTileException
	public Point getTopLeftOfTile(Tile tile){
		Point coords = new Point(0, 0);
		return coords; 
	}
	
}
