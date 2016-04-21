package entity;

import java.awt.Point;
import java.util.HashMap;

public class Board {
	
	protected HashMap<RowColumn, Tile> tileBoard;
	protected Hexomino hexPlaced[];
	protected int XOrigin;
	protected int YOrigin;
	
	public Board(HashMap<RowColumn, Tile>  tileBoard){
		this.tileBoard = tileBoard;
	}
	

	public int[] getTopLeft(){
		int[] origin = {XOrigin, YOrigin};
		return origin;
	}
	
	public boolean checkCollision(Hexomino reqHex){
		return false;
	}
	
	public int checkNumOfHex(){		
		return hexPlaced.length;
	}
	
	/**
	 * Adds hexomino to board from BullPen (possibly give XY coordinates of piece as well)
	 * 
	 * @param Requested hexomino to be added
	 * @return True if heomino was added, false if hexomino doesn't exist
	 */
	
	public boolean addHex(Hexomino hex){
		boolean isValid = true;
		return isValid;
	}
	/**
	 * 
	 * Removes selected hexomino from board
	 * 
	 * @param Requested hexomino to be removed 
	 * @return true if hexomino was removed, false if hexomino doesn't exist
	 */
	public boolean removeHex(Hexomino hex){
		boolean isValid = true;
		return isValid;
	}
	/**
	 * 
	 * @param x location of click in pixels
	 * @param y location of click in pixels
	 * @return Tile that is being selected
	 * @exception NullTileException if tile does not exist at selected location
	 * 
	 */
/**	public Tile getTile(int x, int y){
		int tRow = (y-YOrigin)/tileBoard[0].getWidth();
		int tCol = (x-XOrigin)/tileBoard[0].getHeight();
		int tile = 0; //Placeholder value
		return tileBoard[tile];
	}
	//Can throw NullTileException
	public Point getTopLeftOfTile(Tile tile){
		Point coords = new Point(0, 0);
		return coords; 
	}**/
	
}
