package entity;

import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

import gameControllers.MListener;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

public class BullPen extends BoardBoss{
	

	private static final long serialVersionUID = 1L;
	protected Tile boardArray[][];
	int columns;
	int rows;
	protected int tileID;
	protected int boardID = 2;
	
	


	/** Board Creation method 
	 *  
	 *  Creates the bullpen, made up of the boardArray[][], with ROWS height, and COLUMNS width
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
		int minCol = 0;
		int minRow = 0; 
		
		
		if(getSelectedPiece()==null && !(isInit() || refill)) return false;
		
		for(int i=0;i<6;i++) {
			int rows=hex.shape[i].row+tile.getCoords()[0];
			int columns=hex.shape[i].column+tile.getCoords()[1];
			if (rows < minRow){
				minRow = rows;
				rows = rows+Math.abs(rows);
			}
			if (columns < minCol){			
				minCol = columns;
				columns = columns+Math.abs(columns);
			}
			if(isInit()) 
				if(boardArray[rows][columns].getTileID()<1000) 
					isOverPiece=true;
			
			else if(borderCheck(tile)[1]) 
				System.out.println("Stuff");
				if(boardArray[rows][columns].getTileID()<1000) 
					isOverPiece=true;
			
			else 
				if(boardArray[rows][columns].getTileID()<1000) 
					isOverPiece=true;
			
				
		}
		
		if(isOverPiece) return false;
		if(isInit() || refill){
			minRow = 0;
			minCol = 0;
			for(int i=0; i<6;i++){
				int rows=hex.shape[i].row+tile.getCoords()[0];
				int columns=hex.shape[i].column+tile.getCoords()[1];
				if (rows < minRow){
					minRow = rows;
					rows = rows+Math.abs(rows);
				}
				if (columns < minCol){			
					minCol = columns;
					columns = columns+Math.abs(columns);
				}
				boardArray[rows][columns].coverTile();
				boardArray[rows][columns].setBackground(Color.BLUE);
				boardArray[rows][columns].setBorder(selectBorder);
				boardArray[rows][columns].isHighlight=false;
				//selectedPiece=null;
				boardArray[rows][columns].setTileID(tileID);
			}
			getPieceList().put(tileID, hex);
			System.out.println("Piece Placed!");
			
		}
		else {
			if(getSelectedPiece()!=null && isLifted() && !isPenPiece()) {
				setSelectedPiece(null);
				for(int i=0; i<rows; i++) 
					for(int j=0; j<columns; j++) {
						if(boardArray[i][j].getBackground()==Color.GREEN) {
							boardArray[i][j].setBackground(Color.WHITE);
							boardArray[i][j].setBorder(whiteBorder);
							boardArray[i][j].isHighlight=false;
						
						}
					}
			}
		}
		/**
		else {
			if((selectedPiece!=null && lifted && !penPiece)) {
				for(int k=0; k<6;k++){
					int x=hex.shape[k].row+tile.getCoords()[0];
					int y=hex.shape[k].column+tile.getCoords()[1];
					boardArray[x][y].setBorder(selectBorder);
					if(borderCheck(tile)) y=height-6;
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
							boardArray[i][j].setBorder(selectBorder);
							boardArray[i][j].setBackground(Color.BLUE);
							boardArray[i][j].isHighlight=false;
							selectedPiece=null;
							boardArray[i][j].setTileID(tileID);
						
						}
					}
				pieceList.put(tileID, hex);
				penPieces+=1;
				System.out.println("Piece Placed!");
				}
		}
		*/
		setLifted(true);
		return true;
	}
	
	/** Attempts to lift hexomino
	 *  of shape HexTile[] shape off Tile tile 
	 * 
	 */
	public boolean liftHex(Tile tile, Hexomino hex){
		

			int rows=tile.getCoords()[0];
			int columns=tile.getCoords()[1];

			
			if(boardArray[rows][columns].isCovered()==true && getSelectedPiece()==null){
				tileID = boardArray[rows][columns].getTileID();
				//System.out.println(tileID);
				System.out.println("Selected Piece!");
				for(int j=0; j<rows; j++) 
					for(int k=0; k<columns; k++) 
						if(boardArray[j][k].tileID==tileID) {
							boardArray[j][k].isCovered = false;
							boardArray[j][k].setTileID(tileID+1000);
							boardArray[j][k].setBackground(Color.WHITE);
							boardArray[j][k].setBorder(whiteBorder);
						}
				setSelectedPiece(hex);
				setLifted(false);
				setPenPiece(false);
				setPenPieces(getPenPieces() - 1);
				drawHex(tile,columns,rows, Color.GREEN);

				return false;
			}

		return true;

	}
	
	
	/** 
	 * 	code for drawing lifted piece as green
	 * 	over tiles
	 */
	public void drawHex(Tile tile, int column, int row, Color c) {
		
		if(!borderCheck(tile)[0]) row=rows-7;
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
					boardArray[j][k].setBorder(whiteBorder);
					boardArray[j][k].setBackground(Color.WHITE);
			}
			if(boardArray[j][k].isCovered) {
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

	public void clearPen() {
		for(int i=0;i<rows;i++)
			for(int j=0; j<columns ;j++) {
				boardArray[i][j].isCovered=false;
				boardArray[i][j].tileID=9999;
				boardArray[i][j].setBackground(Color.WHITE);
				boardArray[i][j].setBorder(whiteBorder);
			}
	}

}
