package entity;

import java.util.ArrayList;


public class Level {
	
	protected int lvlID, moves, timer;
	String name, type;
	int row, col;
	protected boolean locked;
	protected int starsAcheived;
	protected Board board;
	protected BullPen pen;
	int height,width;

	public static ArrayList<Hexomino> solutionPieces; //this attribute will contain the pieces of the level, which will be copied and put into the bullpen
	//this way we have a copy always of the solution pieces and can always restart easily the bullpen and the game with this.
	
	public Level(int lvlID){
		this.lvlID = lvlID;
		starsAcheived = 0;
	}
	
	/**
	 * Initializes the board of a level based on the type it is
	 * @param type String representing the  type of boardit is
	 * @return the board of the lvel, now initialized
	 */
	public Board initializeBoard(String type, int rows, int columns){
		this.board = new Board();
		
		if(type.equals("Puzzle Level")){
			board.makeBoard(new PuzzleTile[rows][columns], rows, columns, 1);
			board.fillBoard(type);
		}

		else if(type.equals("Lightning Level")){
			board.makeBoard(new LightningTile[rows][columns], rows, columns, 1);
			board.fillBoard(type);
		}
		else{
			board.makeBoard(new ReleaseTile[rows][columns], rows, columns, 1);
			board.fillBoard(type);
		}
		
		return board;
	}
	
	public BullPen initializeBullPen(){
		this.pen = new BullPen();
		pen.makeBoard(new PuzzleTile[14][35], 14, 35, 2);
		this.pen.fillBoard();
		BullPen.init = true;
		for(int i = 0; i <2; i++){
			pen.addHex(pen.getBoardArray()[7*i+1][5], i, solutionPieces.get(i));
			solutionPieces.remove(i);
		}
		BullPen.init = false;
		return pen;
	}
	
	
	
	
	
	public ArrayList<Hexomino> getSolutionPieces() {
		return solutionPieces;
	}

	public void setSolutionPieces(ArrayList<Hexomino> solutionPieces) {
		this.solutionPieces = solutionPieces;
	}

	/**
	 * 
	 * @return
	 */
	public boolean levelComplete(){
		return board.hasWon();
	}
	
	/**
	 * Changes the dimensions of the board object
	 * @param newRows
	 * @param newColumns
	 * @return the newly created board
	 */
	public Board setBoardDimensions(int newRows, int newColumns){
		row=newRows;
		col=newColumns;
		return board.resizeBoardArray(newRows, newColumns);
	}
	
	public void addPiecesToSolution(Hexomino hex){
		solutionPieces.add(hex);
	}
	AllHex hexList = new AllHex();

	public String toString(){
		return lvlID + System.getProperty("line.separator")  + timer + System.getProperty("line.separator") +moves +   System.getProperty("line.separator")+board.toString(); 
				//+ solutionPieces.toString() + " Board \n" + board.toString();
		
	}

	public int getLvlID() {
		return lvlID;
	}

	public void setLvlID(int lvlID) {
		this.lvlID = lvlID;
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	public int getStarsAcheived() {
		return starsAcheived;
	}

	public void setStarsAcheived(int starsAcheived) {
		this.starsAcheived = starsAcheived;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public BullPen getPen() {
		return pen;
	}

	public void setPen(BullPen pen) {
		this.pen = pen;
	}

	public void setTimer(int gameTimer) {
		this.timer=gameTimer;
	}

	public void setMoves(int moveCounter) {
		this.moves=moveCounter;
		board.setMoves(moveCounter);
	}

	public void setname(String text) {
		this.name=text;
	}

	public String getName() {
		return name;
	}

	public int getTimer() {
		return timer;
	}

	public int getMoves() {
		return moves;
	}

	public void setType(String gameType) {
		type= gameType;
		
	}

	public int getWidth() {
		return height;
	}
	public int getHeight() {
		return width;
	}

	public String getType() {
		return type;
	}

	public void setHeight(int boardHeight) {
		height = boardHeight;
	}
	public void setWidth(int boardWidth) {
		width = boardWidth;
	}

}

