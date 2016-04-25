package entity;

public class Level {
	
	protected int lvlID;
	protected boolean locked;
	protected int starsAcheived;
	protected Board board;
	protected BullPen pen;
	String type;
	int rows, columns;
	
	public Level(int lvlID, String type){
		this.lvlID = lvlID;
		this.type = type;
		starsAcheived = 0;
		initializeLevel();
	}
	
	public void initializeLevel(){
		this.board = new Board();
		if(type.equals("Puzzle"))
			board.makeBoard(new PuzzleTile[rows][columns], rows, columns, 1);
		else if(type.equals("Lighting"))
			board.makeBoard(new LightningTile[rows][columns], rows, columns, 1);
		else
			board.makeBoard(new ReleaseTile[rows][columns], rows, columns, 1);
		//initialize bullPen
		//TODO: finish
	}
	
	public boolean levelComplete(){
		return board.hasWon();
	}
	
	public void setBoardDimensions(int newRows, int newColumns){
		this.rows = newRows;
		this.columns = columns;
		//TODO: HERE IS WHERE ARRAY IS RESIZED
	}
	
	
	
}
