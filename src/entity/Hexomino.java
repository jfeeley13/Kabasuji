package entity;

import java.util.Iterator;


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
	
	public int[] getShape(){
		
		int coords[][];
		//for loop iterates and grabs each HexTiles coordinates
		for(int tileNum = 0; tileNum >= 5; tileNum++){
			coords.
			.add(this.shape[tileNum].getLocation())
		}
		return coords;
	}
	
}
