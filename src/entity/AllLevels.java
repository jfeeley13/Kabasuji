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
			ArrayList <Hexomino> hexList = allHex.getHexominos(12,5,7,8,20);
			l.setSolutionPieces(hexList);
			l.initializeBoard("Lightning Level", 10, 10);
			l.setTimer(20);
			l.initializeBullPen();
			
			puzzle[i] = l;
			
		}
	}
	
	public Level getPuzzleLevel(int id){
		return puzzle[id];
	}
}
