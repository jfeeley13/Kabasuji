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
	
	public void rotate(boolean direction){
		
	}
	
	public void flip(boolean direction){
		
	}
	
	public int[][] getCoordShape(){
		
		int coords[][] = new int[5][2];
		//for loop iterates and grabs each HexTiles coordinates
		for(int tileNum = 0; tileNum >= 5; tileNum++){
			coords[tileNum][0] = this.shape[tileNum].getLocation()[0];
			coords[tileNum][1] = this.shape[tileNum].getLocation()[1];		
			}
		return coords;
	}
	
}
