package entity;

import java.util.ArrayList;

public class AllHex {


	Board board;
	int width = 14;
	int height = 35;
	ArrayList<Hexomino> hexList = new ArrayList<Hexomino>();

	
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

	HexTile[] shape1  = {new HexTile(null,0,0,1), new HexTile(null,0,1,1), new HexTile(null, 0, 2, 1), new HexTile(null,  0,3, 1), new HexTile(null, 0,4, 1), new HexTile(null,  0, 5,1)};
	HexTile[] shape2  = {new HexTile(null,0,0,2), new HexTile(null,0,1,2), new HexTile(null, 0, 2, 2), new HexTile(null,  0,3, 2), new HexTile(null, 0,4, 2), new HexTile(null,  1, 0,2)};
	HexTile[] shape3  = {new HexTile(null,0,0,3), new HexTile(null,0,1,3), new HexTile(null, 0, 2, 3), new HexTile(null,  0,3, 3), new HexTile(null, 0,4, 3), new HexTile(null, -1, 3,3)};
	HexTile[] shape4  = {new HexTile(null,0,0,4), new HexTile(null,0,1,4), new HexTile(null, 0, 2, 4), new HexTile(null,  0,3, 4), new HexTile(null, 0,4, 4), new HexTile(null,  1, 2,4)};
	HexTile[] shape5  = {new HexTile(null,0,0,5), new HexTile(null,1,0,5), new HexTile(null, 0, 1, 5), new HexTile(null, -1,1, 5), new HexTile(null,-2,1, 5), new HexTile(null, -2, 2,5)};
	HexTile[] shape6  = {new HexTile(null,0,0,6), new HexTile(null,1,0,6), new HexTile(null, 2, 0, 6), new HexTile(null,  2,1, 6), new HexTile(null, 3,1, 6), new HexTile(null,  4, 1,6)};
	HexTile[] shape7  = {new HexTile(null,0,0,7), new HexTile(null,0,1,7), new HexTile(null,-1, 1, 7), new HexTile(null, -1,2, 7), new HexTile(null,-1,3, 7), new HexTile(null, -1, 4,7)};
	HexTile[] shape8  = {new HexTile(null,0,0,8), new HexTile(null,0,1,8), new HexTile(null, 0, 2, 8), new HexTile(null, -1,2, 8), new HexTile(null,-1,3, 8), new HexTile(null,  0, 3,8)};
	HexTile[] shape9  = {new HexTile(null,0,0,9), new HexTile(null,1,0,9), new HexTile(null, 1, 1, 9), new HexTile(null,  1,2, 9), new HexTile(null, 1,3, 9), new HexTile(null,  2, 3,9)};
	HexTile[] shape10 = {new HexTile(null,0,0,10),new HexTile(null,1,0,10),new HexTile(null, 2, 0, 10),new HexTile(null,  1,1, 10),new HexTile(null, 1,2, 10),new HexTile(null,  1, 3,10)};
	HexTile[] shape11 = {new HexTile(null,0,0,11),new HexTile(null,0,1,11),new HexTile(null, 0, 2, 11),new HexTile(null,  0,3, 11),new HexTile(null,-1,3, 11),new HexTile(null, -2, 3,11)};
	HexTile[] shape12 = {new HexTile(null,0,0,12),new HexTile(null,0,1,12),new HexTile(null, 0, 2, 12),new HexTile(null, -1,0, 12),new HexTile(null,-1,1, 12),new HexTile(null, -1, 2,12)};
	HexTile[] shape13 = {new HexTile(null,0,0,13),new HexTile(null,1,0,13),new HexTile(null, 0, 1, 13),new HexTile(null, -1,1, 13),new HexTile(null,-1,2, 13),new HexTile(null, -1, 3,13)};
	HexTile[] shape14 = {new HexTile(null,0,0,14),new HexTile(null,0,1,14),new HexTile(null,-1, 1, 14),new HexTile(null, -1,2, 14),new HexTile(null,-2,2, 14),new HexTile(null, -2, 3,14)};
	HexTile[] shape15 = {new HexTile(null,0,0,15),new HexTile(null,0,1,15),new HexTile(null, 0, 2, 15),new HexTile(null,  0,3, 15),new HexTile(null, 1,1, 15),new HexTile(null,  1, 2,15)};
	HexTile[] shape16 = {new HexTile(null,0,0,16),new HexTile(null,0,1,16),new HexTile(null, 0, 2, 16),new HexTile(null,  0,3, 16),new HexTile(null,-1,1, 16),new HexTile(null,  1, 1,16)};
	HexTile[] shape17 = {new HexTile(null,0,0,17),new HexTile(null,0,1,17),new HexTile(null, 0, 2, 17),new HexTile(null,  0,3, 17),new HexTile(null, 1,1, 17),new HexTile(null,  1, 3,17)};
	HexTile[] shape18 = {new HexTile(null,0,0,18),new HexTile(null,0,1,18),new HexTile(null, 0, 2, 18),new HexTile(null,  1,2, 18),new HexTile(null, 2,2, 18),new HexTile(null,  1, 3,18)};
	HexTile[] shape19 = {new HexTile(null,0,0,19),new HexTile(null,1,0,19),new HexTile(null, 2, 0, 19),new HexTile(null,  2,1, 19),new HexTile(null, 2,2, 19),new HexTile(null,  3, 2,19)};
	HexTile[] shape20 = {new HexTile(null,0,0,20),new HexTile(null,1,0,20),new HexTile(null, 2, 0, 20),new HexTile(null,  0,1, 20),new HexTile(null, 1,1, 20),new HexTile(null, -1, 1,20)};
	HexTile[] shape21 = {new HexTile(null,0,0,21),new HexTile(null,0,1,21),new HexTile(null,-1, 1, 21),new HexTile(null, -2,1, 21),new HexTile(null,-1,2, 21),new HexTile(null, -2, 2,21)};
	HexTile[] shape22 = {new HexTile(null,0,0,22),new HexTile(null,0,1,22),new HexTile(null, 0, 2, 22),new HexTile(null,  1,1, 22),new HexTile(null,-1,1, 22),new HexTile(null, -1, 2,22)};
	HexTile[] shape23 = {new HexTile(null,0,0,23),new HexTile(null,1,0,23),new HexTile(null, 1, 1, 23),new HexTile(null,  1,2, 23),new HexTile(null, 1,3, 23),new HexTile(null,  0, 3,23)};
	HexTile[] shape24 = {new HexTile(null,0,0,24),new HexTile(null,0,1,24),new HexTile(null,-1, 1, 24),new HexTile(null,  1,1, 24),new HexTile(null,-1,2, 24),new HexTile(null,  1, 2,24)};
	HexTile[] shape25 = {new HexTile(null,0,0,25),new HexTile(null,0,1,25),new HexTile(null, 0, 2, 25),new HexTile(null,  1,0, 25),new HexTile(null, 2,0, 25),new HexTile(null,  1, 2,25)};
	HexTile[] shape26 = {new HexTile(null,0,0,26),new HexTile(null,0,1,26),new HexTile(null, 0, 2, 26),new HexTile(null,  1,1, 26),new HexTile(null, 1,2, 26),new HexTile(null,  2, 2,26)};
	HexTile[] shape27 = {new HexTile(null,0,0,27),new HexTile(null,1,0,27),new HexTile(null, 1, 1, 17),new HexTile(null,  1,2, 27),new HexTile(null, 1,3, 27),new HexTile(null,  2, 1,27)};
	HexTile[] shape28 = {new HexTile(null,0,0,28),new HexTile(null,0,1,28),new HexTile(null, 0, 2, 18),new HexTile(null,  0,3, 28),new HexTile(null,-2,2, 28),new HexTile(null, -1, 2,28)};
	HexTile[] shape29 = {new HexTile(null,0,0,29),new HexTile(null,0,1,29),new HexTile(null, 1, 1, 19),new HexTile(null,  2,1, 29),new HexTile(null, 2,0, 29),new HexTile(null,  3, 0,29)};
	HexTile[] shape30 = {new HexTile(null,0,0,30),new HexTile(null,0,1,30),new HexTile(null, 0, 2, 20),new HexTile(null, -1,1, 30),new HexTile(null,-2,1, 30),new HexTile(null, -2, 2,30)};
	HexTile[] shape31 = {new HexTile(null,0,0,31),new HexTile(null,0,1,31),new HexTile(null, 0, 2, 21),new HexTile(null, -1,2, 31),new HexTile(null, 1,2, 31),new HexTile(null, -1, 3,31)};
	HexTile[] shape32 = {new HexTile(null,0,0,32),new HexTile(null,0,1,32),new HexTile(null, 0, 2, 22),new HexTile(null,  1,1, 32),new HexTile(null,-1,1, 32),new HexTile(null, -1, 2,32)};
	HexTile[] shape33 = {new HexTile(null,0,0,33),new HexTile(null,0,1,33),new HexTile(null, 1, 1, 23),new HexTile(null,  2,1, 33),new HexTile(null, 3,1, 33),new HexTile(null,  2, 2,33)};
	HexTile[] shape34 = {new HexTile(null,0,0,34),new HexTile(null,0,1,34),new HexTile(null,-1, 1, 24),new HexTile(null,  1,1, 34),new HexTile(null, 2,1, 34),new HexTile(null,  1, 2,34)};
	HexTile[] shape35 = {new HexTile(null,0,0,35),new HexTile(null,0,1,35),new HexTile(null,-1, 1, 25),new HexTile(null,  1,1, 35),new HexTile(null,-1,2, 35),new HexTile(null, -2, 2,35)};

//	HexTile[] shape4 = {new HexTile(null,0,0,1),new HexTile(null,0,1,1),new HexTile(null,-1,2,1),new HexTile(null,0,3,1),new HexTile(null,0,4,1),new HexTile(null,0,5,1)};
	
	protected Hexomino h1 = new Hexomino(1, shape1);		
	protected Hexomino h2 = new Hexomino(2, shape2);
	protected Hexomino h3 = new Hexomino(3, shape3);
	protected Hexomino h4 = new Hexomino(4, shape4);		
	protected Hexomino h5 = new Hexomino(5, shape5);
	protected Hexomino h6 = new Hexomino(6, shape6);
	protected Hexomino h7 = new Hexomino(7, shape7);		
	protected Hexomino h8 = new Hexomino(8, shape8);
	protected Hexomino h9 = new Hexomino(9, shape9);
	protected Hexomino h10 = new Hexomino(10, shape10);		
	protected Hexomino h11 = new Hexomino(11, shape11);		
	protected Hexomino h12 = new Hexomino(12, shape12);
	protected Hexomino h13 = new Hexomino(13, shape13);
	protected Hexomino h14 = new Hexomino(14, shape14);		
	protected Hexomino h15 = new Hexomino(15, shape15);
	protected Hexomino h16 = new Hexomino(16, shape16);
	protected Hexomino h17 = new Hexomino(17, shape17);		
	protected Hexomino h18 = new Hexomino(18, shape18);
	protected Hexomino h19 = new Hexomino(19, shape19);
	protected Hexomino h20 = new Hexomino(20, shape20);		
	protected Hexomino h21 = new Hexomino(21, shape21);		
	protected Hexomino h22 = new Hexomino(22, shape22);
	protected Hexomino h23 = new Hexomino(23, shape23);
	protected Hexomino h24 = new Hexomino(24, shape24);		
	protected Hexomino h25 = new Hexomino(25, shape25);
	protected Hexomino h26 = new Hexomino(26, shape26);
	protected Hexomino h27 = new Hexomino(17, shape27);		
	protected Hexomino h28 = new Hexomino(18, shape28);
	protected Hexomino h29 = new Hexomino(19, shape29);
	protected Hexomino h30 = new Hexomino(20, shape30);		
	protected Hexomino h31 = new Hexomino(21, shape31);		
	protected Hexomino h32 = new Hexomino(22, shape32);
	protected Hexomino h33 = new Hexomino(23, shape33);
	protected Hexomino h34 = new Hexomino(24, shape34);		
	protected Hexomino h35 = new Hexomino(25, shape35);
	
	public AllHex() {
		hexList.add(h1);
		hexList.add(h2);
		hexList.add(h3);
		hexList.add(h4);
		hexList.add(h5);
		hexList.add(h6);
		hexList.add(h7);
		hexList.add(h8);
		hexList.add(h9);
		hexList.add(h10);
		hexList.add(h11);
		hexList.add(h12);
		hexList.add(h13);
		hexList.add(h14);
		hexList.add(h15);
		hexList.add(h16);
		hexList.add(h17);
		hexList.add(h18);
		hexList.add(h19);
		hexList.add(h20);
		hexList.add(h21);
		hexList.add(h22);
		hexList.add(h23);
		hexList.add(h24);
		hexList.add(h25);
		hexList.add(h26);
		hexList.add(h27);
		hexList.add(h28);
		hexList.add(h29);
		hexList.add(h30);
		hexList.add(h31);
		hexList.add(h32);
		hexList.add(h33);
		hexList.add(h34);
		hexList.add(h35);
		}
	public ArrayList<Hexomino> getHexList() {
		return hexList;
	}
	
	public Hexomino getHex(int id){
		return hexList.get(id);
	}
	
	public ArrayList<Hexomino> getHexominos(int ... hexNums){
		 ArrayList <Hexomino> hexList = new ArrayList <Hexomino>();
		 for (int i = 0; i < hexNums.length; i++){
		 	hexList.add(getHex(hexNums[i]));
		 }
		 return hexList;
	}
}

