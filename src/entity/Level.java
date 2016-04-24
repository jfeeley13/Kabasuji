package entity;

public class Level {
	
	protected int lvlID;
	protected boolean locked;
	protected int starsAcheived;
	protected Board board;
	protected BullPen pen;
	//TODO: instead of level taking these parameters why not just have it take a string to identify type of level and initialize everything according to this variable.
	
	public Level(int lvlID, BullPen pen, Board board){
		this.lvlID = lvlID;
		this.pen = pen;
		this.board = board;
	}
	
	public void initializeLevel(){
		
	}
	
	public boolean levelComplete(){
//	Can return false for losing and true for winning
//	Use another method to deal with result of this method?
		return false;
	}
	
	
}
