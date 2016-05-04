package entity;

import java.util.ArrayList;

public class AllLevels {
	Level[] puzzle = new Level[5];
	Level[] lightning = new Level[5];
	Level[] release = new Level[5];
	int xy=0;
	public void initializePuzzleOne(){

	
		Level l = new Level(1);
		AllHex allHex =new AllHex();
		ArrayList <Hexomino> hexList = allHex.getHexominos(0,0,0,0,0,0);
		l.setSolutionPieces(hexList);
		l.initializeBoard("Puzzle Level", 6, 6);
		l.setMoves(20);
		l.initializeBullPen();
			
		puzzle[1] = l;		
	}
	
	public void initializePuzzleTwo(){

		Level l = new Level(2);
		AllHex allHex =new AllHex();
		ArrayList <Hexomino> hexList = allHex.getHexominos(11,11,11,11,11,11);
		l.setSolutionPieces(hexList);
		l.initializeBoard("Puzzle Level", 6, 6);
		l.setMoves(20);
		l.initializeBullPen();
			
		puzzle[2] = l;		
	}
	public void initializePuzzleThree(){

		
		Level l = new Level(3);
		AllHex allHex =new AllHex();
		ArrayList <Hexomino> hexList = allHex.getHexominos(11,11,11,0,0,0);
		l.setSolutionPieces(hexList);
		l.initializeBoard("Puzzle Level", 6, 6);
		l.setMoves(20);
		l.initializeBullPen();
			
		puzzle[3] = l;		
	}
	public void initializePuzzleFour(){

		
		Level l = new Level(4);
		AllHex allHex =new AllHex();
		ArrayList <Hexomino> hexList = allHex.getHexominos(0,0,0,0,0,0);
		l.setSolutionPieces(hexList);
		l.initializeBoard("Puzzle Level", 6, 6);
		l.setMoves(20);
		l.initializeBullPen();
			
		puzzle[4] = l;		
	}
	public void initializePuzzleFive(){

		
		Level l = new Level(5);
		AllHex allHex =new AllHex();
		ArrayList <Hexomino> hexList = allHex.getHexominos(0,0,0,0,0,0);
		l.setSolutionPieces(hexList);
		l.initializeBoard("Puzzle Level", 6, 6);
		l.setMoves(20);
		l.initializeBullPen();
			
		puzzle[5] = l;		
	}

	
	public void initializePuzzleLevels(int i) {
		if(i==1) initializePuzzleOne();
		if(i==2) initializePuzzleTwo();
		if(i==3) initializePuzzleThree();
		if(i==4) initializePuzzleFour();
		if(i==5) initializePuzzleFive();
		
	}
	

	public void initializeLightningLevels(){
		for(int i=0; i < 5; i++){
			Level l = new Level(i);
			AllHex allHex =new AllHex();
			ArrayList <Hexomino> hexList = allHex.getHexominos(12,5,7,8,20);
			l.setSolutionPieces(hexList);
			l.initializeBoard("Lightning Level", 8, 8);
			l.setTimer(20);
			l.initializeBullPen();
			
			lightning[i] = l;
			
		}
	}
	
	public void initializeReleaseLevels(){
		for(int i=0; i < 5; i++){
			Level l = new Level(i);
			AllHex allHex =new AllHex();
			ArrayList <Hexomino> hexList = allHex.getHexominos(12,5,7,8,20);
			l.setSolutionPieces(hexList);
			l.initializeBoard("Release Level", 10, 10);
			l.setMoves(20);
			l.initializeBullPen();
			
			release[i] = l;
		}
	}
	
	public Level getPuzzleLevel(int id){
		return puzzle[id];
	}
	
	public Level getLightningLevel(int id){
		return lightning[id];
	}
	
	public Level getReleaseLevel(int id){
		return release[id];
	}
}
