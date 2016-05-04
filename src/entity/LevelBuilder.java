package entity;

import java.awt.Color;
import java.util.Stack;

public class LevelBuilder{
	
	private static Level level;
	protected BullPen inventory;
	protected String lvlName;
	private Stack<IMove> moves = new Stack<IMove>();
	String type;
	int newLvlID, movesnum,timer;
	
	public LevelBuilder(){
		
	}
	
	/**
	 * Saves the current state of the level
	 */
	
	
	/**
	 * Returns an initialized board from a new level.
	 * @param type
	 * @return
	 */
	public Board NewLevelBoard(int rows, int cols){
		return level.initializeBoard(this.type,rows,cols);
	}
	
	public BullPen NewLevelBullPen(){
		return level.initializeBullPen();
	}
	/**
	 * 
	 * @param color set color
	 * @param number set number
	 * @param t ReleaseTile in which the set number and color will be added
	 */
	public void addSet(Color color, int number, ReleaseTile t){
		Level previousState = getLevel();
		t.setSetColor(color);
		t.setSetNum(number);	
		Level currentState = getLevel();
		moveDone(previousState, currentState);
	}
	

	/**
	 * Changes the number of rows and columns that the board contains.
	 * @param rows a
	 * @param columns
	 */
	public Board setBoardDimensions(int rows, int columns){
		Level previousState = getLevel();
		Board returnBoard = getLevel().setBoardDimensions(rows, columns);
		Level currentState = getLevel();
		moveDone(previousState, currentState);
		return returnBoard;
		
		
	}
	
	public void setTimer(int gameTimer){
		Level previousState = getLevel();
		level.timer=gameTimer;
		Level currentState = getLevel();

		moveDone(previousState, currentState);
	}
	
	public void setMoves(int moveCounter){
		Level previousState = getLevel();
		level.moves=moveCounter;
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
		getLevel().solutionPieces.add(hex);
		Level currentState = getLevel();
		moveDone(previousState, currentState);
	}

	public static Level getLevel() {
		return level;
	}

	public static void setLevel(Level level) {
		LevelBuilder.level = level;
	}
	
	
}

