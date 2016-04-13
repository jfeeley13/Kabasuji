package entity;

public class Board {
	
//	TODO Change point to another class
	
	protected Tile tileBoard[];
	protected Hexomino hexPlaced[];
	protected Point tileList[];
	
	public Board(Tile tileBoard[], Point tileList[]){
		this.tileBoard = tileBoard;
		this.tileList = tileList;
	}
	

	public boolean checkCollision(Hexomino reqHex){
		return false;
	}
}
