package entity;

public class AllHex {

	
//TestPieces	
int hp1[][] = {{0,0},{0,-1},{0,-2},{0,-3},{0,-4},{0,-5}};
int hp2[][] = {{0,0},{0,-1},{0,-2},{0,-3},{0,-4},{1,0}};	
int hp3[][] = {{0,0},{0,-1},{0,-2},{0,-3},{0,-4},{-1,-3}};
int hp4[][] = {{0,0},{0,-1},{0,-2},{0,-3},{0,-4},{1,-2}};
int hp5[][] = {{0,0},{-1,0},{-1,-1},{-2,-1},{-3,-1},{-3,-2}};
int hp12[][]= {{0,0},{1,0},{0,-1},{1,-1},{0,-2},{1,-2}};

protected Hexomino h1 = new Hexomino(1, hp1);		
protected Hexomino h2 = new Hexomino(1, hp2);		
protected Hexomino h3 = new Hexomino(1, hp3);		
protected Hexomino h4 = new Hexomino(1, hp4);		
protected Hexomino h5 = new Hexomino(1, hp5);
protected Hexomino h12 = new Hexomino(1, hp12);
}
