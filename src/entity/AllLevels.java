package entity;

public class AllLevels {
	Level[] puzzle = new Level[5];
	Level[] lightning = new Level[5];
	Level[] release = new Level[5];
	
	public void initializePuzzleLevels(){
		for(int i=0; i < 5; i++){
			Level l = new Level(i);
			l.initializeBoard("Lightning Level", 10, 10);
			l.setTimer(20);
			
			
			puzzle[i] = l;
			
		}
	}
	
	public Level getPuzzleLevel(int id){
		return puzzle[id];
	}
}
