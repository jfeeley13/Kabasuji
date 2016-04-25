package entity;

public class Level {
	
	protected int lvlID;
	protected boolean locked;
	protected int starsAcheived;
	protected Board board;
	protected BullPen pen;
	
	public Level(int lvlID, BullPen pen){
		this.lvlID = lvlID;
		this.pen = pen;
	}
	
	public void initializeLevel(){
		this.board = new Board();
	}
	
	public boolean levelComplete(){
		return board.hasWon();
	}
	
	
}
