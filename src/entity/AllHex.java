package entity;

import java.util.ArrayList;
import java.util.HashMap;

public class AllHex {

	//TestPieces	
//	int hp1[][] = {{0,0},{0,-1},{0,-2},{0,-3},{0,-4},{0,-5}};
//	int hp2[][] = {{0,0},{0,-1},{0,-2},{0,-3},{0,-4},{1,0}};	
//	int hp3[][] = {{0,0},{0,-1},{0,-2},{0,-3},{0,-4},{-1,-3}};
//	int hp4[][] = {{0,0},{0,-1},{0,-2},{0,-3},{0,-4},{1,-2}};
//	int hp5[][] = {{0,0},{-1,0},{-1,-1},{-2,-1},{-3,-1},{-3,-2}};
//	int hp12[][]= {{0,0},{1,0},{0,-1},{1,-1},{0,-2},{1,-2}};

//	protected Hexomino h1 = new Hexomino(1, shape1);		
//	protected Hexomino h2 = new Hexomino(1, hp2);		
//	protected Hexomino h3 = new Hexomino(1, hp3);		
//	protected Hexomino h4 = new Hexomino(1, hp4);		
//	protected Hexomino h5 = new Hexomino(1, hp5);
//	protected Hexomino h12 = new Hexomino(1, hp12);
	

//	Board board = this.tile.getBoard();
			
//	HexTile[] shape1 = {new HexTile(board, 0,0),new HexTile(board,0,-1),new HexTile(board,0,-2),new HexTile(board,0,-3),new HexTile(board,0,-4),new HexTile(board,0,-5)};
//	HexTile[] shape2 = {new HexTile(board,0,0),new HexTile(board,0,-1),new HexTile(board,0,-2),new HexTile(board,0,-3),new HexTile(board,0,-4),new HexTile(board,1,0)};

//	protected Hexomino h1 = new Hexomino(1, shape1);		
//	protected Hexomino h2 = new Hexomino(2, shape2);

	private HashMap<Integer, Hexomino> hexList = new HashMap<Integer, Hexomino>();
	
	public Hexomino getHex(int ID) {
		Hexomino hex = null;
		hex = hexList.get(ID);
		
		return hex;
	}

	public void makeHex(int ID, HexTile[] shape) {
		hexList.put(ID, new Hexomino(ID, shape));
	}

}
/*
	public static HexTile[] shape1 = {new HexTile(new RowColumn(0,0)),new HexTile(new RowColumn(0,-1)),new HexTile(new RowColumn(0,-2)),new HexTile(new RowColumn(0,-3)),new HexTile(new RowColumn(0,-4)),new HexTile(new RowColumn(0,-5))};
	public static HexTile[] shape2 = {new HexTile(new RowColumn(0,0)),new HexTile(new RowColumn(0,-1)),new HexTile(new RowColumn(0,-2)),new HexTile(new RowColumn(0,-3)),new HexTile(new RowColumn(0,-4)),new HexTile(new RowColumn(1,0))};	
	
	//TEMPORARY public static to display piece drawn
	public static Hexomino h1 = new Hexomino(1, shape1);		
	public static Hexomino h2 = new Hexomino(2, shape2);
	

}*/
