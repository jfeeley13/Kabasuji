package entity;

public class Hexomino {
	
	protected int pID;
	protected Point neighbors[] = new Point[5];
	protected Point origin; //Remove?
	protected boolean isSel;
	
	boolean CWRotate;
	boolean hFlip;

	public Hexomino(int pID, Point origin, Point neighbors[]){
		this.pID = pID;
		this.origin = origin;
		this.neighbors = neighbors;	
	}
	
	public void rotate(boolean direction){
		
	}
	
	public void flip(boolean direction){
		
	}
	
	
}
