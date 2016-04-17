package entity;

public class BullPen {

	protected Hexomino HexList[];
	protected Hexomino selectedHex;
	
	public BullPen(Hexomino HexList[]){
		this.HexList = HexList;
	}
	
	public void rotateHex(int direction){
		
	}
	
	public void flipHex(int direction){
		
	}
	
	public Hexomino getPiece(){
		int x = 0;
		return this.HexList[x];
	}
	
	public void addHex(Hexomino piece){
		
	}
	
	public void removeHex(Hexomino piece){
		
	}
	
}
