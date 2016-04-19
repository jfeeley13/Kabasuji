package entity;

public class BullPen {

	protected Hexomino HexList[];
	protected Hexomino selectedHex;
	
	public BullPen(Hexomino HexList[]){
		this.HexList = HexList;
	}
	
	public void rotateHex(boolean direction){
		
	}
	
	public void flipHex(boolean direction){
		
	}
	
	public Hexomino getPiece(int x){
		return this.HexList[x];
	}
	
	public void addHex(Hexomino piece){
		HexList[HexList.length] = piece;
	}
	
	public void removeHex(Hexomino piece){
		
	}
	
}
