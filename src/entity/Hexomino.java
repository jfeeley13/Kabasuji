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
	public String toString(){
		return pID + "\n";
	}
	
}
