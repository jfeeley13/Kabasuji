package entity;

public class Hexomino {
	
	protected int pID;
	protected Point neighbors[] = new Point[5]; //TODO: Look at G analysis feedback
	protected Point origin; //Remove?
	protected boolean isSel;//TODO: Look at G analysis feedback
	
	boolean CWRotate;
	boolean hFlipa;

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
