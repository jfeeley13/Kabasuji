package entity;

import java.util.List;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

public abstract class BoardBoss extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Tile boardArray[][];
//	protected Hexomino hexPlaced[] = new Hexomino[];
	List<Hexomino> hexPlaced = new ArrayList<Hexomino>();
	protected int XOrigin;
	protected int YOrigin;
	Board board;
	int width = 12;
	int height = 12;
	public static Hexomino selectedPiece;
	
	public void makeBoard(Tile[][] boardArray, int width, int height){
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
	
	public boolean addHex(Tile tile){
		HexTile[] shape = {new HexTile(this,0,0, width, height),new HexTile(this,0,1, width, height),new HexTile(this,0,-2, width, height),new HexTile(this,0,-3, width, height),new HexTile(this,0,-4, width, height),new HexTile(this,1,0, width, height)};
		HexTile[] shape2 = {new HexTile(this,0,0, width, height),new HexTile(this,0,1, width, height),new HexTile(this,0,2, width, height),new HexTile(this,0,3, width, height),new HexTile(this,0,4, width, height),new HexTile(this,0,5, width, height)};
		Hexomino hex = new Hexomino(1, shape2);	
	
		boolean allTilesEmpty=CheckTiles(tile, shape2);
		if(allTilesEmpty){
			for(int i=0; i<6;i++){
				int x=hex.shape[i].row+tile.getCoords()[0];
				int y=hex.shape[i].column+tile.getCoords()[1];
				boardArray[x][y].coverTile();
				boardArray[x][y].setBackground(Color.BLUE);
				hexPlaced.add(hex);
			}
		}
		return true;
	}
	public boolean CheckTiles(Tile tile,HexTile[] shape){
		Hexomino hex = new Hexomino(1, shape);
		for(int i=0; i<6;i++){
			int x=hex.shape[i].row+tile.getCoords()[0];
			int y=hex.shape[i].column+tile.getCoords()[1];
			if(boardArray[x][y].isCovered()==true){
				System.out.println("can't place piece here");
				return false;
			}	
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
