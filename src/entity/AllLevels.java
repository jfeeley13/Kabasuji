package entity;

import java.util.ArrayList;

public class AllLevels {
	Level[] puzzle = new Level[5];
	Level[] lightning = new Level[5];
	Level[] release = new Level[5];
	
	public void initializePuzzleLevels(){
		for(int i=0; i < 5; i++){
			Level l = new Level(i);
			AllHex allHex =new AllHex();
			ArrayList <Hexomino> hexList = allHex.getHexominos(0,0,0,0,0);
			l.setSolutionPieces(hexList);
			l.initializeBoard("Puzzle Level", 6, 6);
			l.setMoves(20);
			l.initializeBullPen();
			
			puzzle[i] = l;
			
		}
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
