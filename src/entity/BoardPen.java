package entity;

import java.util.List;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

public class BoardPen extends BoardBoss{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Tile boardArray[][];

	int rows;
	int columns;
	protected int tileID;
	protected int boardID;

	/** Board Creation method 
	 *  
	 *  Creates the boardpen, made up of the boardArray[][], with ROWS height, and COLUMNS width
	 *  boardID specifies current board
	 * 
	 * */
	
	public void makeBoard(Tile[][] boardArray, int row, int col, int id){
		this.boardArray = boardArray;
		this.rows = row;
		this.columns = col;
		this.boardID = id;
	}

	
	public boolean addHex(Tile tile, int tileID, Hexomino hex){
		
		return false;
	}
	public boolean liftHex(Tile tile,HexTile[] shape){
		
		return true;

	}
	
	/** 
	 * 	code for drawing lifted piece as green
	 * 	over tiles
	 */
	public void drawHex(Tile tile, int column, int row, Color c) {
		
		if(!borderCheck(tile)[0]) row=rows-1;
		if(!borderCheck(tile)[1]) column = columns - 2;


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
				
				if(!boardArray[Row][Col].isCovered) {
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
					boardArray[j][k].setBackground(Color.decode("#4169aa"));
				}
				if(boardArray[j][k].isCovered) {
					boardArray[j][k].setBackground(Color.decode("#4169aa"));
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
						boardArray[j][k].setBackground(Color.decode("#4169aa"));
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
	
/*	public boolean borderCheck(Tile tile) {
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
	}*/
	
	public boolean[] borderCheck(Tile tile) {
		boolean result[] = {true,true};
		int RowVal=0;
		int ColVal=0;
		boolean hitColLimit = false;
		boolean hitRowLimit = false;
				
		try {
			for (int i = 0; i < 5; i++){
				RowVal=getSelectedPiece().shape[i].row+tile.getCoords()[0];
				ColVal=getSelectedPiece().shape[i].column+tile.getCoords()[1];
				if (RowVal<0||RowVal>rows-2) hitRowLimit = true;
				if (ColVal<0||ColVal>columns-2) hitColLimit = true;
			}
		} catch (Exception e) {}
		result[0] = hitRowLimit;
		result[1] = hitColLimit;
		return result;
//		if(hitRowLimit) {
//			System.out.println("Hit a Limit!");
//			result[0] = false;
//		}
//		else
//			return true;
	}

	
	public int returnRows() {
		return this.rows;
	}

	
	public Tile[][] returnBoard() {
		return boardArray;
	}

}
