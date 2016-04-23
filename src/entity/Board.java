package entity;

import java.awt.Point;
import java.util.HashMap;

public class Board {
	
	protected HashMap<RowColumn, Tile> tileBoard;
	protected Hexomino hexPlaced[];
	RowColumn origin;
	int maxRow, maxCol;
	
	
	public Board(HashMap<RowColumn, Tile>  tileBoard, int maxRow, int maxCol){
		this.tileBoard = tileBoard;
		this.maxCol = maxCol;
		this.maxRow = maxRow;
		origin = new RowColumn(0, 0);
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
	public Tile getTile(RowColumn key){
		return tileBoard.get(key);
	}
	public void editTile(RowColumn key,Tile newTile){
		tileBoard.put(key, newTile);
	}
	public void removeTile(RowColumn key){
		tileBoard.remove(key);
	}
	
	public boolean hasWon(){
		TileIterator boardIterator = new TileIterator(tileBoard, maxRow, maxCol);
		while(boardIterator.hasNext()){
			Tile t = boardIterator.next();
			if(t.hasWon() || t.isCovered())
				return false;
		}
		return true;
	}
	
	

	
}
