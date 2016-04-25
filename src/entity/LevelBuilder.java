package entity;

import java.util.ArrayList;
import java.util.Stack;

public class LevelBuilder{

	protected Level level;
	protected BullPen inventory;
	protected String lvlName;
	private Stack<LevelBuilderMove> moves = new Stack<LevelBuilderMove>();
	public LevelBuilder(){
		
	}
	
	public void SaveLevel(){
		
	}
	
	public void NewLevel(){
		
	}
	
	public void addSet(int color, int number){
		
	}
	
	public void invToBP(){
		
	}
	
	public void toggleTile(){
		
	}
	
	public int checkNumTile(){
		return 0;
	}
	
	public void moveDone(Level previousState, Level curretState){
		LevelBuilderMove newMove = new LevelBuilderMove(previousState);
		newMove.doMove(curretState);
		moves.push(newMove);
		
	}
	
	public void undo(){
		this.level = moves.pop().revertMove();
	}
	
	
}
