package entity;

public class Puzzle{
	
	protected int movesLeft;
	protected int totalMoves;
	protected int ID;
	protected BullPen pen;
	
	Puzzle(int ID, int allowedMoves, BullPen pen){
		this.ID = ID;
		this.totalMoves = allowedMoves;
		this.pen = pen;
	}
}
