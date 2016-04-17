package entity;

public class Hexomino {
	
	protected int pID;
	protected int shape[][] = new int [5][2];
	protected boolean isSel;
	
	boolean CWRotate;
	boolean hFlip;

	public Hexomino(int pID, int shape[][]){
		this.pID = pID;
		this.shape = shape;	
	}
	
	public void rotate(boolean direction){
		
	}
	
	public void flip(boolean direction){
		
	}
	
	
}
