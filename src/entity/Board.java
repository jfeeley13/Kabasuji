package entity;

import java.util.List;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

public class Board extends JPanel{
	
	/** List of Hexominos*/
	
	HexTile[] shape1 = {new HexTile(this, 0,0),new HexTile(this,0,-1),new HexTile(this,0,-2),new HexTile(this,0,-3),new HexTile(this,0,-4),new HexTile(this,0,-5)};
	HexTile[] shape2 = {new HexTile(this,0,0),new HexTile(this,0,-1),new HexTile(this,0,-2),new HexTile(this,0,-3),new HexTile(this,0,-4),new HexTile(this,1,0)};

	AllHex hexList = new AllHex();
	
	
	public Board(){
		hexList.makeHex((Integer) 1,shape1);
		hexList.makeHex((Integer)2,shape2);
	}
	
	private static final long serialVersionUID = 1L;
	protected Tile boardArray[][];
//	protected Hexomino hexPlaced[] = new Hexomino[];
	List<Hexomino> hexPlaced = new ArrayList<Hexomino>();
	protected int XOrigin;
	protected int YOrigin;
	AllHex HexList;
	
	public void makeBoard(Tile[][] boardArray){
		this.boardArray = boardArray;
	}

	public int[] getTopLeft(){
		int[] origin = {XOrigin, YOrigin};
		return origin;
	}
	
	public boolean checkCollision(Hexomino reqHex){
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
			boardArray[row][col].setBackground(Color.BLUE);
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
	}
	//Can throw NullTileException
	public Point getTopLeftOfTile(Tile tile){
		Point coords = new Point(0, 0);
		return coords; 
	}
	*/
}
