package entity;

public class SaveMove implements  IMove {
	private Level savedState;
	
	public Level loadSavedState(){
		return savedState;
	}

	@Override
	public boolean doMove(Level savedState) {
		this.savedState = savedState;
		return true;
	}
}
