package entity;

/**
 * 
 * Entity class representing a move in the level builder.
 *
 */
public class LevelBuilderMove implements IMove{

	Level previousState; //state before move was done
	Level currentState; //state after move is done
	/**
	 * LevelBuilderove constructor
	 * @param previousState state of the Level before this newly created move was done
	 */
	public LevelBuilderMove(Level previousState){
		this.previousState = previousState;
	}
	/**
	 * @param currentState state of the Level after this move was done
	 */
	public boolean doMove(Level currentState) {
		this.currentState = currentState;
		return true;
	}
	/**
	 * reverts the Level object to the previous state in which it was before making this move.
	 * @return Level object representing the state of it before it was edited.
	 */
	public Level revertMove(){
		return previousState;
	}
	
}
