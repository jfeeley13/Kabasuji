package entity;

public class BullPen {

	protected Hexomino HexList[];
	protected Hexomino selectedHex;
	
	public BullPen(Hexomino HexList[]){
		this.HexList = HexList;
	}
	
	public void rotatePiece(){
		
	}
	
	public void putBack(){
		
	}
	
	public Hexomino getPiece(){
		int x = 0;
		return this.HexList[x];
	}
	
	public void addPiece(){
		
	}
	
}
