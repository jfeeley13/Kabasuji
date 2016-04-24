package entity;

import java.util.List;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;

public class Board extends JPanel{
	
	protected HashMap<RowColumn, Tile> tileBoard;
	//protected Hexomino hexPlaced[]; //TODO: why array? we need to dinamically resize this as it is impossible to know max number of pieces in the game as all levels vary on this
	RowColumn origin;
	int maxRow, maxCol;
	private static final long serialVersionUID = 1L;
	protected Tile boardArray[][];
//	protected Hexomino hexPlaced[] = new Hexomino[];
	List<Hexomino> hexPlaced = new ArrayList<Hexomino>();
	protected int XOrigin;
	protected int YOrigin;
	AllHex HexList;
	
	public Board(HashMap<RowColumn, Tile>  tileBoard, int maxRow, int maxCol){
		this.tileBoard = tileBoard;
		this.maxCol = maxCol;
		this.maxRow = maxRow;
		origin = new RowColumn(0, 0);
	}
	
	/** List of Hexominos*/
	
	HexTile[] shape1 = {new HexTile(this, new RowColumn(0,0)),new HexTile(this, new RowColumn(0,-1)),new HexTile(this,new RowColumn(0,-2)),new HexTile(this,new RowColumn(0,-3)),new HexTile(this,new RowColumn(0,-4)),new HexTile(this,new RowColumn(0,-5))};
	HexTile[] shape2 = {new HexTile(this, new RowColumn(0,0)),new HexTile(this, new RowColumn(0,-1)),new HexTile(this,new RowColumn(0,-2)),new HexTile(this,new RowColumn(0,-3)),new HexTile(this,new RowColumn(0,-4)),new HexTile(this,new RowColumn(1,0))};

	AllHex hexList = new AllHex();
	
	
	public Board(){
		hexList.makeHex((Integer) 1,shape1);
		hexList.makeHex((Integer)2,shape2);
	}
	


	
	public void makeBoard(Tile[][] boardArray){
		this.boardArray = boardArray;
	}

	public int[] getTopLeft(){
		int[] origin = {XOrigin, YOrigin};
		return origin;
	}

	
	public boolean checkCollision(Hexomino reqHex){
		//TODO: is the hexTiles location where the piece is in the board or is it for specifying shape?
		return false;
	}
	
	public int checkNumOfHex(){		
		return hexPlaced.size();
	}
	
	/**
	 * Adds hexomino to board from BullPen (possibly give XY coordinates of piece as well)
	 * 
	 * @param Requested hexomino to be added
	 * @return True if heomino was added, false if hexomino doesn't exist
	 */
	
	public boolean addHex(Hexomino hex){
		if(checkCollision(hex)){
			//hexPlaces should not be an array in my opinion, maybe a list
			return true;
		}
		return false;
	}
	
	public boolean addHex(Hexomino hex, Tile tile){
		hexPlaced.add(hex);
		int tileX = tile.getCoords().getColumn();
		int tileY = tile.getCoords().getRow();
		RowColumn coordList[] = hex.getCoordShape();
		
		for(int hexTileNum = 0; hexTileNum <= coordList.length; hexTileNum++){
			int row = coordList[hexTileNum].getRow();
			int col = coordList[hexTileNum].getColumn();
			
			coordList[hexTileNum] = new RowColumn(row+tileX, col+tileY);
		}
		
		for(int hexTileNum = 0; hexTileNum <= coordList.length; hexTileNum++){
			int row = coordList[hexTileNum].getRow();
			int col = coordList[hexTileNum].getColumn();

			boardArray[row][col].coverTile();
			//boardArray[row][col].setBackground(Color.BLUE);
		}
		
		return true;
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

	/**
	 * 
	 * @param x location of click in pixels
	 * @param y location of click in pixels
	 * @return Tile that is being selected
	 * Throws exception if tile does not exist at selected location
	 * 
	 */
/*	public Tile getTile(int x, int y){
		int tRow = (y-YOrigin)/tileBoard[0].getTileWidth();
		int tCol = (x-XOrigin)/tileBoard[0].getTileHeight();
		int tile = 0; //Placeholder value
		return tileBoard[tile];
	public Tile getTile(RowColumn key){
		return tileBoard.get(key);
	}
	public void editTile(RowColumn key,Tile newTile){
		tileBoard.put(key, newTile);
	}
	*/

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
	/**
	 * @return 
	 * 
	 */
	public String toString(){
		TileIterator boardIterator = new TileIterator(tileBoard, maxRow, maxCol);
		String returnString = new String();
		while(boardIterator.hasNext()){
			Tile t = boardIterator.next();
			returnString = t.toString() + "/n" ;
		}
		return returnString;
	}

	
}
