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
		ArrayList <Hexomino> hexList = allHex.getHexominos(1,2,3,4,5,6);
		l.setSolutionPieces(hexList);
		l.initializeBoard("Puzzle Level", 12, 12);
		l.setMoves(20);
		l.initializeBullPen();
			
		puzzle[2] = l;		
	}
	
	public void initializePuzzleLevels(int i) {
		if(i==1) initializePuzzleOne();
		
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
