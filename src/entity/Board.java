package entity;

import java.util.HashMap;
import java.util.List;

import javax.swing.JPanel;

import gameControllers.MListener;
import views.GameOver;
import views.YouWin;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

public class Board extends BoardBoss{
	
	/**
	 *  
	 */
	private static final long serialVersionUID = 1L;
	protected Tile boardArray[][];

	int width;
	int height;
	protected int tileID;
	protected int boardID = 1;

	/** Board Creation method 
	 *  
	 *  Creates the board, made up of the boardArray[][], with height ROWS, and width COLUMNS
	 *  boardID specifies current board
	 * 
	 * */
	
	public void makeBoard(Tile[][] boardArray, int width, int height, int id){
		this.boardArray = boardArray;
		this.width = width;
		this.height = height;
		this.boardID = id;
	}
	
	
	/** adds hexomino to Tile tile
	 *  with specified id tileID
	 * 
	 */
	
	public boolean addHex(Tile tile, int tileID, Hexomino hex){

	
		boolean isOverPiece = false;
		boolean allTilesEmpty=liftHex(tile, hex);
		
		
		
		if(selectedPiece==null && !init) return false;
		for(int i=0; i<6;i++){
			int x=hex.shape[i].row+tile.getCoords()[0];
			int y=hex.shape[i].column+tile.getCoords()[1];
			try {
			if(borderCheck(tile)) {
				if(boardArray[x][y].getTileID()<1000) isOverPiece=true;
			}
			else {
				if(boardArray[x][height-6+i].getTileID()<1000) isOverPiece=true;
			}
			} catch (Exception e) {return false;}
		}
		
		if(isOverPiece) return false;
		if(selectedPiece!=null & lifted) {
			for(int k=0; k<6;k++){
				int x=hex.shape[k].row+tile.getCoords()[0];
				int y=hex.shape[k].column+tile.getCoords()[1];
				if(!borderCheck(tile)) y=height-6;
				try {
					if(boardArray[x][y].isCovered()) {

						return false;
					}
				} catch (NullPointerException e) {}
			}
			for(int i=0; i<width; i++) 
				for(int j=0; j<height; j++) {
					if(boardArray[i][j].getBackground()==Color.GREEN) {
						boardArray[i][j].coverTile();
						boardArray[i][j].setBackground(Color.BLUE);
						boardArray[i][j].isHighlight=false;
						selectedPiece=null;
						boardArray[i][j].setTileID(tileID);
					
					}
				}
			pieceList.put(tileID, hex);
			System.out.println("Piece Placed!");
			BoardBoss.moves-=1;
			}
		lifted = true;
		hasWon();
		return true;
	}
	
	/** Attempts to lift hexomino
	 *  of shape HexTile[] shape off Tile tile 
	 * 
	 */
	public boolean liftHex(Tile tile,Hexomino hex){
		for(int i=0; i<6;i++){
			int x=tile.getCoords()[0];
			int y=tile.getCoords()[1];

			if(boardArray[x][y].isCovered()==true && selectedPiece==null){
				tileID = boardArray[x][y].getTileID();
				//System.out.println(tileID);
				System.out.println("Selected Piece!");
				for(int j=0; j<width; j++) 
					for(int k=0; k<height; k++) 
						if(boardArray[j][k].tileID==tileID) {

							boardArray[j][k].isCovered = false;
							boardArray[j][k].setBackground(Color.WHITE);
							boardArray[j][k].setTileID(tileID+1000);

						}
				selectedPiece = hex;
				lifted = false;
				penPiece = false;
				drawHex(tile,x,y, Color.GREEN);
				return false;
			}	
		}
		return true;

	}
	
	/** 
	 * 	code for drawing lifted piece as green
	 * 	over tiles
	 */
	public void drawHex(Tile tile, int posx, int posy, Color c) {
		
		for(int i=0; i<6;i++){
			if(!borderCheck(tile)) posy=height-6;
			int x = 0;
			int y = 0;
			switch(rotated) {
			case 1:	x=selectedPiece.shape[i].row+posx;
					y=selectedPiece.shape[i].column+posy;
					break;
			case 2:	x=selectedPiece.shape[i].column+posx;
					y=selectedPiece.shape[i].row+posy;
					break;
			case 3:	x=selectedPiece.shape[i].row+posx;
					y=posy-selectedPiece.shape[5-i].column;
					break;
			case 4:	x=posx-selectedPiece.shape[i].column;
					y=selectedPiece.shape[i].row+posy;
					break;
			}
			
			try{
				boardArray[x][y].setHighlight(true);
			

			try {
				if(!boardArray[x][y].isCovered) {
					boardArray[x][y].setTileID(tileID+1000);					
				}
				boardArray[x][y].setBackground(c);

			} catch(NullPointerException e) {

			}
			} catch(Exception e) {};
			

		}	
	}
	
	
	/**
	 * 	refresh the board
	 * 	setting pieces to their
	 * 	appropriate state
	 * 
	 * 	(used after moving from bullpen/board to
	 * 	clear any potential paint artifacts)
	 */
	public void refresh() {
		for(int j=0; j<width; j++) 
			for(int k=0; k<height; k++) {
				if(boardArray[j][k].isHighlight) {
					boardArray[j][k].setBackground(Color.WHITE);
				}
				if(boardArray[j][k].isCovered) {
					boardArray[j][k].setBackground(Color.BLUE);
				}
			}
	}
	
	public int getID() {
		return boardID;
	}
	
	
	/** 
	 * 	redraw all the current pieces,
	 * 	both placed and lifted
	 * 
	 */
	public void redraw() {
		for(int j=0; j<width; j++) 
			for(int k=0; k<height; k++) 
				if(boardArray[j][k].tileID<1000) {
					
					if(!boardArray[j][k].isHighlight)
						boardArray[j][k].setBackground(Color.BLUE);
					else {
						boardArray[j][k].setHighlight(false);
					}
				}

	}
	
	
	/**
	 * 	is piece at Tile tile escaping borders?
	 * 	this method stops that from happening
	 */
	public boolean borderCheck(Tile tile) {
		int x=0;
		int y=0;
		
		try {
		x=selectedPiece.shape[5].row+tile.getCoords()[0];
		y=selectedPiece.shape[5].column+tile.getCoords()[1];
			
		if(x<width && y<height) {
			return true;
		}
		else
			return false;
		} catch (NullPointerException e) {};
		return false;
	}
	
	public int returnHeight() {
		return this.height;
	}
	
	public Tile[][] returnBoard() {
		return boardArray;
	}
	
	
	/**
	 * 	you win!
	 * 	opens win window
	 * 	and sets win status
	 */
	public boolean hasWon(){
		for(int i = 0; i < width; i++){
			for(Tile t : boardArray[i]){
				if(!t.hasWon()) {
					
					return true;
				}
			}
		}
		System.out.println("You win!");
		moves=-1;
		YouWin hs = new YouWin();
		hs.newwindow();
		winAnimation();
		return false;
	}
	
	/**
	 * 	plays win animation
	 */
	public void winAnimation() {
		int k=0;
		Color[] colorList = new Color[3];
		colorList[0] = Color.GREEN;
		colorList[1] = Color.RED;
		colorList[2] = Color.BLUE;
		for(int i=0; i<width; i++) 
			for(int j=0; j<height; j++) {
				boardArray[j][i].setBackground(colorList[1]);
				k=(k+1)%3;
			}
	}
	
	/**
	 * Resizes the field boardArray in Board class
	 * @param newRows new number of rows in board
	 * @param newCols new number of columns in board
	 */
	public void resizeBoardArray(int newRows, int newCols){
		//check if the new dimension are smaller or bigger than previous array
		Tile[][] newBoard = new Tile[newRows][newCols];
		if(newRows == this.width && this.height == newCols)
			return;
		if(newCols < height && newRows < width)
			copyContents(newBoard, newRows, newCols);
		else if(newCols < height)
			copyContents(newBoard, width, newCols);
		else if(newRows < width)
			copyContents(newBoard, newRows, height);
		else{
			copyContents(newBoard, width, height);
			for(int i = width - 1; i < newRows; i++){
				for(int j = height; j < newCols; j++){
					//just copy the origin tile to the new places to ensure it is the same type of tile.
					newBoard[i][j] = boardArray[0][0]; 
				}
			}
		}
		this.width = newRows;
		this.height = newCols;
		//not update width and height
	}
	/**
	 * Copies the contents of boardArray into a newBoard up to a specified row and column limit
	 * @param newBoard 
	 * @param row
	 * @param cols
	 */
	public void copyContents(Tile[][] newBoard ,int row, int cols){
		for(int i= 0; i < row; i++){
			for(int j = 0; j < cols; j++){
				newBoard[i][j] = boardArray[i][j]; 
			}
		}
	}
	
	public void fillArray(Tile typeOfTile){
		for(int i= 0; i < width; i++){
			for(int j = 0; j < height; j++){
				boardArray[i][j] = typeOfTile; 
			}
		}
	}

}
