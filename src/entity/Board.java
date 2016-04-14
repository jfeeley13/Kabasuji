package entity;

public class Board {
	
//	TODO Change point to another class Hello world
	
	protected Tile tileBoard[];
	protected Hexomino hexPlaced[];
	
	public Board(Tile tileBoard[]){
		this.tileBoard = tileBoard;
	}
	

	public boolean checkCollision(Hexomino reqHex){
		return false;
	}
}
