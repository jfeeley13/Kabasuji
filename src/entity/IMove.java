package entity;

public interface IMove{
	
	public boolean doMove(Level previousState);
	public Level revertMove();
}
