package entity;

import javax.swing.JPanel;

public class Hexomino extends JPanel{
	
	protected int pID;
	protected HexTile[] shape;
	protected boolean isSel;
	
	boolean CWRotate;
	boolean hFlip;

	public Hexomino(int pID, HexTile[] shape){
		this.pID = pID;
		this.shape = shape;	
	}
	
	public int getID(){
	return this.pID;
	}
	public HexTile[] getShape(){
		return shape;
	}
	
	public boolean isSel(){
		return isSel;
	}
	
	public void toggleSelectHex(){
		isSel = !isSel;
	}
	/**
	 * Rotates Hexomino CW or CCW
	 * 
	 * @param direction: true = CW or false = CCW
	 */
	
	public void rotate(boolean direction){
		//CW  Rotation ---newRow = currCol--newCol = currRow*-1
		//CCW Rotation ---newRow = currCol*-1-----newCol = currRow
		//Initialize at CCW Rotation
		int dir = 1;
		if(direction)//If CW Rotation
			dir = -1;
		for (int TileNum = 0; TileNum >= 5; TileNum++){
				int currRow = shape[TileNum].getCoords()[0];
				int currCol = shape[TileNum].getCoords()[1];
				shape[TileNum].changeLocation(dir*(-1)*currCol, dir*currRow);
			}
	}
	/**
	 * 
	 * Flips Hexomino horizontally or vertically 
	 * 
	 * @param direction true = VFlip or false = HFlip
	 */
	public void flip(boolean direction){
		//HFlip ---newRow = currRow*-1--newCol = currCol
		//VFlip ---newRow = currRow-----newCol = currCol*-1
		//Initialize at HFlip
		int dir = 1;
		if(direction)//If VFlip
			dir = -1;
		for (int TileNum = 0; TileNum >= 5; TileNum++){
				int currRow = shape[TileNum].getCoords()[0];
				int currCol = shape[TileNum].getCoords()[1];
				shape[TileNum].changeLocation(dir*(-1)*currRow, dir*currCol);
			}
		
	}
	
	/**
	 * 
	 * 
	 * @return List of (Row, Column) Coordinates of all the tiles that make up the Hexomino
	 */
	public int[][] getCoordShape(){
		
		int coords[][] = new int[6][2];
		//for loop iterates and grabs each HexTiles coordinates
		for(int tileNum = 0; tileNum < 6; tileNum++){
			coords[tileNum][0] = this.shape[tileNum].getCoords()[0];
			coords[tileNum][1] = this.shape[tileNum].getCoords()[1];		
			}
		return coords;
	}
	
}
