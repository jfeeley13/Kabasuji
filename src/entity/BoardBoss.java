package entity;

import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class BoardBoss extends JPanel{
	
	/**
	 * *
	 */
	private static final long serialVersionUID = 1L;
	protected static Tile boardArray[][];
	Board board;
	int width = 12;
	int height = 12;
	public static Hexomino selectedPiece;							/** the piece currently being "lifted" */
	public static boolean init = true;								/** is the level being initalized (bullpen being filled with pieces?) */
	public static boolean refill = false;
	public static boolean lifted = false;							/** has a piece been lifted off the board/pen by the user? */
	public static boolean penPiece = false;							/** is the piece being lifted a bullpen piece? */
	protected int tileID;											/** id of tile that hexomino is being added to */
	protected int boardID;											/** id of board */
	public static int rotated = 1;									/** rotate state */
	public static int flipped = 1;									/** flipped state */
	public static int moves = 8;									/** remaining moves */
	protected Border selectBorder = BorderFactory.createLineBorder(Color.BLACK, 1);
	protected Border whiteBorder = BorderFactory.createLineBorder(Color.WHITE, 1);
	protected Border boardPenBorder = BorderFactory.createLineBorder(Color.decode("#4169aa"), 1);
	public static HashMap pieceList = new HashMap();
	public static int penPieces = 0;
	public static int bullPenPosition=0;

	
	/** Board Creation method 
	 *  
	 *  Creates the board, made up of the boardArray[][], with ROWS height, and COLUMNS width
	 *  boardID specifies current board
	 * 
	 * */
	
	public void makeBoard(Tile[][] boardArray, int width, int height, int id){
		this.boardArray = boardArray;
		this.boardID = id;
	}
	


	public abstract boolean addHex(Tile tile, int tileID, Hexomino hex);

	public boolean liftHex(Tile tile,HexTile[] shape){
		return true;
	}
	
	
	public void drawHex(Tile tile, int posx, int posy, Color c) {

	}
	
	public void refresh() {

	}
	
	public int getID() {
		return boardID;
	}


	public void redraw() {

	}
	
	public boolean rotateCheck(Tile tile) {
		return true;
		
	}
	
	public int returnHeight() {
		return this.height;
	}
	
	public int returnWidth() {
		return this.width;
	}
	
	public Tile[][] returnBoard() {
		return boardArray;
	}
	public void rotateFlip(Tile datboi){
  	}		  	
	
 	public int getGreenTiles() {
 		return 0;
 	}
  			  	
 	public void setBoard(Tile[][] board) {
 		return;
 	}
	

	/**
	 * Fills the boardArray parameter with a given type of tile
	 * @param typeOfTile Any subclass object of the Tile class.
	 */
	public void fillArray(Tile typeOfTile){
		for(int i= 0; i < width; i++){
			for(int j = 0; j < height; j++){
				boardArray[i][j] = typeOfTile; 
			}
		}
	}
	
	public void clearPen() {
		return;
	}

}
