package entity;

import java.util.ArrayList;
import java.util.Stack;

public class LevelBuilder{
	
	private static Level level;
	protected BullPen inventory;
	protected String lvlName;
	private Stack<IMove> moves = new Stack<IMove>();
	String type;
	int newLvlID;
	
	public LevelBuilder(Level level){
		this.level = level;
	}
	
	
	
	/**
	 * 
	 * @param color set color
	 * @param number set number
	 * @param t ReleaseTile in which the set number and color will be added
	 */
	public void addSet(String color, int number, ReleaseTile t){
		Level previousState = getLevel();
		t.setColor = color;
		t.setNum = number;	
		Level currentState = getLevel();
		moveDone(previousState, currentState);
	}
	

	/**
	 * Changes the number of rows and columns that the board contains.
	 * @param rows a
	 * @param columns
	 */
	public void setBoardDimensions(int rows, int columns){
		Level previousState = getLevel();
		getLevel().setBoardDimensions(rows, columns);
		Level currentState = getLevel();
		moveDone(previousState, currentState);
	}
	
	public void setBoardRows(int rows){
		setBoardDimensions(rows, LevelBuilder.level.getColumns());
	}
	public void setBoardColumns(int cols){
		setBoardDimensions(LevelBuilder.level.getRows(), cols);
	}
	
	
	public void setTimer(){
		Level previousState = getLevel();
		//Where is the timer attribute
		//change timer here
		Level currentState = getLevel();
		moveDone(previousState, currentState);
	}
	
	public void setMoves(){
		Level previousState = getLevel();
		//Where is the move attribute
		//change moves here
		//I see it in BoardBoss, but shouldnt it be only on board? since only the subclass board uses this atttribute
		Level currentState = getLevel();
		moveDone(previousState, currentState);
	}
	

	
	/**
	 * Makes a LevelBuilderMove Object and pushes it onto the stack of moves. This method should be called whenever any editing of the
	 * Level is made.
	 * @param previousState Level object representing the state of the Level before the move was done
	 * @param curretState Level object representing the state of the Level afterr the move was done
	 */
	public void moveDone(Level previousState, Level currentState){
		LevelBuilderMove newMove = new LevelBuilderMove(previousState);
		newMove.doMove(currentState);
		moves.push(newMove);
		
	}
	/**
	 * Undoes the last move done by the user
	 */
	public void undo(){
		IMove unknownMove = moves.pop();
		LevelBuilderMove notSaveMove = (LevelBuilderMove) unknownMove; 
		notSaveMove.revertMove();

	}
	/**
	 * Adds a hexomino onto the set of solutionPieces of level.
	 * This hex should come from the inventory.
	 * @param hex
	 */
	public void addSolutionPiece(Hexomino hex){
		Level previousState = getLevel();
		this.level.solutionPieces.add(hex);
		Level currentState = getLevel();
		moveDone(previousState, currentState);
	}

	public static Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}
	
	
}
