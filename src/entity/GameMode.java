package entity;

public class GameMode {
	
	protected Level levels[];
	
	public GameMode(int maxLevels){
		levels = new Level[maxLevels];
	}
	
	public GameMode(Level levels[]){
		this.levels = levels;
	}
}
