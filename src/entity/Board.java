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

	int columns;
	int rows;
	protected int tileID;
	protected int boardID = 1;

	/** Board Creation method 
	 *  
	 *  Creates the board, made up of the boardArray[][], with height ROWS, and width COLUMNS
	 *  boardID specifies current board
	 * 
	 * */
	
	public void makeBoard(Tile[][] boardArray, int row, int col, int id){
		this.boardArray = boardArray;
		this.columns = col;
		this.rows = row;
		this.boardID = id;
	}
	
	/** adds hexomino to Tile tile
	 *  with specified id tileID
	 * 
	 */
	
	public boolean addHex(Tile tile, int tileID, Hexomino hex){

	
		boolean isOverPiece = false;
		boolean allTilesEmpty=liftHex(tile, hex);
		
		
		System.out.println("1");
		if(selectedPiece==null && !init) return false;
		
		
		
		if(selectedPiece!=null & lifted) {
			for(int k=0; k<6;k++){
				int Row=hex.shape[k].row+tile.getCoords()[0];
				int Col=hex.shape[k].column+tile.getCoords()[1];
				if(!borderCheck(tile)) Row=rows-6+k;
				try {
					if(boardArray[Row][Col].isCovered()) {

						return false;
					}
				} catch (Exception e) {}
			}
			for(int i=0; i<rows; i++) 
				for(int j=0; j<columns; j++) {
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
		System.out.println("3");
		lifted = true;
		hasWon();
		return true;
	}

	
	/** Attempts to lift hexomino
	 *  of shape HexTile[] shape off Tile tile 
	 * 
	 */
	public boolean liftHex(Tile tile,Hexomino hex){

			int Row=tile.getCoords()[0];
			int Col=tile.getCoords()[1];
			

			
			if(boardArray[Row][Col].isCovered()==true && selectedPiece==null){
				tileID = boardArray[Row][Col].getTileID();
				//System.out.println(tileID);
				System.out.println("Selected Piece!");

				for(int j=0; j<rows; j++) 
					for(int k=0; k<columns; k++) 
						if(boardArray[j][k].tileID==tileID) {

							boardArray[j][k].setCovered(false);
							boardArray[j][k].setBackground(Color.WHITE);
							boardArray[j][k].setTileID(tileID+1000);

						}

				selectedPiece = hex;
				lifted = false;
				penPiece = false;
				drawHex(tile,rows,columns, Color.GREEN);
				return false;
			}	

		return true;

	}
	
	
	/** 
	 * 	code for drawing lifted piece as green
	 * 	over tiles
	 */
	public void drawHex(Tile tile, int column, int row, Color c) {
		
		if(!borderCheck(tile)) row=rows-6;


		for(int i=0; i<6;i++){
			int Row = 0;
			int Col = 0;
			switch(rotated) {
			case 1:	Row=getSelectedPiece().shape[i].row+row;
					Col=getSelectedPiece().shape[i].column+column;
					break;
			case 2:	Row=getSelectedPiece().shape[i].row+row;
					Col=getSelectedPiece().shape[i].column+column;
					break;
			case 3:	Row=getSelectedPiece().shape[i].row+row;
					Col=column-getSelectedPiece().shape[5-i].column;
					break;
			case 4:	Row=row-getSelectedPiece().shape[i].row;
					Col=getSelectedPiece().shape[i].column+column;
					break;
			}


			try {
				boardArray[Row][Col].setHighlight(true);
			
			
			try {
				
				if(!boardArray[Row][Col].isCovered()) {
					boardArray[Row][Col].setTileID(tileID+1000);
					
				}
				boardArray[Row][Col].setBorder(selectBorder);
				boardArray[Row][Col].setBackground(c);
				
				
			} catch(Exception e) {


			}
			} catch (Exception e) {};

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
		for(int j=0; j<rows; j++) 
			for(int k=0; k<columns; k++) {
				if(boardArray[j][k].isHighlight) {
					boardArray[j][k].setBackground(Color.WHITE);
				}
				if(boardArray[j][k].isCovered()) {
					boardArray[j][k].setBackground(Color.BLUE);
				}
			}
	}

	
	/** 
	 * 	redraw all the current pieces,
	 * 	both placed and lifted
	 * 
	 */
	public void redraw() {
		for(int j=0; j<rows; j++) 
			for(int k=0; k<columns; k++) 
				if(boardArray[j][k].tileID<1000) {
					
					if(!boardArray[j][k].isHighlight)
						boardArray[j][k].setBackground(Color.BLUE);
					else {
						boardArray[j][k].setHighlight(false);
					}
				}

	}
	
	public int getID() {
		return boardID;
	}
	
	public boolean rotateCheck(Tile tile) {
		int Row=0;
		int Col=0;

		switch(rotated) {
		case 1:	Row=getSelectedPiece().shape[5].row+tile.getCoords()[0];
				Col=getSelectedPiece().shape[5].column+tile.getCoords()[1];
				break;
		case 2:	Row=getSelectedPiece().shape[5].row+tile.getCoords()[0];
				Col=getSelectedPiece().shape[5].column+tile.getCoords()[1];
				break;
		case 3:	Row=getSelectedPiece().shape[5].row+tile.getCoords()[0];
				Col=tile.getCoords()[1]-getSelectedPiece().shape[5-5].column;
				break;
		case 4:	Row=tile.getCoords()[0]-getSelectedPiece().shape[5].row;
				Col=getSelectedPiece().shape[5].column+tile.getCoords()[1];
				break;
		}

		if(Col>columns-2 || Row>rows-2 || Col<0 || Row<0) return false;
		return true;
	}
	
	
	/**
	 * 	is piece at Tile tile escaping borders?
	 * 	this method stops that from happening
	 */
	
	public boolean borderCheck(Tile tile) {
		int colCheck=0;
		int rowCheck=0;

		try {
		rowCheck=getSelectedPiece().shape[5].row+tile.getCoords()[0];
		colCheck=getSelectedPiece().shape[5].column+tile.getCoords()[1];
		} catch (Exception e) {}
		if(colCheck<columns && rowCheck<rows) {
			return true;
		}
		else
			return false;
	}

	
	public int returnRows() {
		return this.rows;
	}

	
	public Tile[][] returnBoard() {
		return boardArray;
	}

	
	public int widthCheck(Tile tile) {
		int Row=0;
		int Col=0;
		for(int i=0; i<6; i++) {
			try {
				Row=selectedPiece.shape[i].row+tile.getCoords()[0];
				Col=columns-6;
				Tile tileX = boardArray[Row][Col];
			} catch (Exception e) {return i;}
		}
		return 0;
	}

	
	
	/**
	 * 	you win!
	 * 	opens win window
	 * 	and sets win status
	 */
	public boolean hasWon(){
		for(int i = 0; i < columns; i++){
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
		for(int i=0; i<rows; i++) 
			for(int j=0; j<columns; j++) {
				boardArray[i][j].setBackground(colorList[1]);
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
		if(newRows == this.rows && this.columns == newCols)
			return;
		//case 1: new board is smaller
		if(newCols < columns && newRows < rows)
			copyContents(newBoard, newRows, newCols);
		//case 2: new board height is smaller
		else if(newCols < columns)
			copyContents(newBoard, rows, newCols);
		else if(newRows < rows)
			copyContents(newBoard, newRows, columns);
		else{
			//case 4: new board is bigger in height and width
			copyContents(newBoard, rows, columns);
			for(int i = rows - 1; i < newRows; i++){
				for(int j = columns; j < newCols; j++){
					//just copy the origin tile to the new places to ensure it is the same type of tile.
					newBoard[i][j] = boardArray[0][0]; 
				}
			}
		}
		this.rows = newRows;
		this.columns = newCols;
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
	



}