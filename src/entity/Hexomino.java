package entity;


public class Hexomino {
	
	protected int pID;
	protected HexTile[] shape;
	protected boolean isSel;
	
	boolean CWRotate;
	boolean hFlip;

	public Hexomino(int pID, HexTile[] shape){
		this.pID = pID;
		this.shape = shape;	
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
		for(HexTile tile : shape){
			tile.changeLocation(dir*(-1)*tile.rowCol.getColumn(), dir*tile.rowCol.getRow());
			// tile.rowCol.getColumn is the current column in which the tile is located
			//and tile.rowCol.getRow() is the current row in which the tile is located
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
		for(HexTile tile : shape){
			tile.changeLocation(dir*(-1)*tile.rowCol.getRow(), dir*tile.rowCol.getColumn());
			// tile.rowCol.getColumn is the current column in which the tile is located
			//and tile.rowCol.getRow() is the current row in which the tile is located
		}
	}
	
	/**
	 * 
	 * 
	 * @return List of (Row, Column) Coordinates of all the tiles that make up the Hexomino
	 */
	public RowColumn[] getCoordShape(){
		RowColumn coords[] = new RowColumn[6];
		int idx = 0;
		for(HexTile tile : shape){
			coords[idx] = tile.rowCol;
			idx++;
		}
		return coords;
	}
		/*
	public int[][] getCoordShape(){
		int coords[][] = new int[5][2];
		//for loop iterates and grabs each HexTiles coordinates
		for(int tileNum = 0; tileNum >= 5; tileNum++){
			coords[tileNum][0] = this.shape[tileNum].getLocation()[0];
			coords[tileNum][1] = this.shape[tileNum].getLocation()[1];		
			}
		return coords;
		
	}*/
	
}
