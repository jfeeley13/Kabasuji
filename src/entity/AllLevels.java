package entity;

public class AllLevels {
	Level[] puzzle = new Level[5];
	Level[] lighting = new Level[5];
	Level[] release = new Level[5];
	
	public void initializePuzzleLevels(){
		for(int i=0; i < 5; i++){
			Level l = new Level(i);
			l.initializeBoard("Puzzle Level", 10, 10);
			l.setMoves(20);
			
			puzzle[i] = l;
			
		}
	}
	
	public Level getPuzzleLevel(int id){
		return puzzle[id];
	}
}
