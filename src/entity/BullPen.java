package entity;

import javax.swing.BorderFactory;
import javax.swing.border.Border;

import java.awt.Color;

public class BullPen extends BoardBoss{
	

	private static final long serialVersionUID = 1L;
	protected Tile boardArray[][];
	int rows;
	int cols;
	protected int tileID;
	protected int boardID = 2;
	
	


	/** Board Creation method 
	 *  
	 *  Creates the bullpen, made up of the boardArray[][], with ROWS height, and COLUMNS width
	 *  boardID specifies current board
	 * 
	 * */
	
	public void makeBoard(Tile[][] boardArray, int width, int height, int id){
		this.boardArray = boardArray;
		this.rows = width;
		this.cols = height;
		this.boardID = id;
	}
	
	
	/** adds hexomino to Tile tile
	 *  with specified id tileID
	 * 
	 */
	
	public boolean addHex(Tile tile, int tileID, Hexomino hex){

	
		boolean isOverPiece = false;
		System.out.println("tile   "+tile);
		liftHex(tile, hex);
		
		
		
		if(selectedPiece==null && !(init || refill)) return false;
		
		if(isOverPiece) return false;
		if(init || refill){
			
			for(int i=0; i<6;i++){
				int x=hex.shape[i].column+tile.getCoords()[0];
				int y=hex.shape[i].row+tile.getCoords()[1];
				boardArray[x][y].coverTile();
				boardArray[x][y].setBackground(Color.BLUE);
				boardArray[x][y].setBorder(selectBorder);
				boardArray[x][y].isHighlight=false;
				//selectedPiece=null;
				boardArray[x][y].setTileID(tileID);
			}
			pieceList.put(tileID, hex);
			System.out.println("Piece Placed!");
			
		}
		else {
			if(selectedPiece!=null && lifted && !penPiece) {
				entity.Level.solutionPieces.add(selectedPiece);
				selectedPiece=null;
				
				for(int i=0; i<rows; i++) 
					for(int j=0; j<cols; j++) {
						if(boardArray[i][j].getBackground()==Color.GREEN) {
							boardArray[i][j].setBackground(Color.WHITE);
							boardArray[i][j].setBorder(whiteBorder);
							boardArray[i][j].isHighlight=false;
						
						}
					}
			}
		}
		
		lifted = true;
		return true;
	}
	
	/** Attempts to lift hexomino
	 *  of shape HexTile[] shape off Tile tile 
	 * 
	 */
	public boolean liftHex(Tile tile, Hexomino hex){
		

			int x=tile.getCoords()[0];
			int y=tile.getCoords()[1];

			
			if(boardArray[x][y].isCovered()==true && selectedPiece==null){
				tileID = boardArray[x][y].getTileID();
				//System.out.println(tileID);
				System.out.println("Selected Piece!");
				for(int j=0; j<rows; j++) 
					for(int k=0; k<cols; k++) 
						if(boardArray[j][k].tileID==tileID) {
							boardArray[j][k].isCovered = false;
							boardArray[j][k].setTileID(tileID+1000);
							boardArray[j][k].setBackground(Color.WHITE);
							boardArray[j][k].setBorder(whiteBorder);
						}
				selectedPiece = hex;
				lifted = false;
				penPiece = false;
				penPieces-=1;
				drawHex(tile,x,y, Color.GREEN);

				return false;
			}

		return true;

	}
	
	
	/** 
	 * 	code for drawing lifted piece as green
	 * 	over tiles
	 */
	public void drawHex(Tile tile, int posx, int posy, Color c) {
		

		for(int i=0; i<6;i++){
			int x = 0;
			int y = 0;
			switch(rotated) {
			case 1:	x=selectedPiece.shape[i].column+posx;
					y=selectedPiece.shape[i].row+posy;
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


			try {
				boardArray[x][y].setHighlight(true);
			
			
			try {
				
				if(!boardArray[x][y].isCovered) {
					boardArray[x][y].setTileID(tileID+1000);
					
				}
				boardArray[x][y].setBorder(selectBorder);
				boardArray[x][y].setBackground(c);
				
				
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
			for(int k=0; k<cols; k++) {
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
			for(int k=0; k<cols; k++) 
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
		int x=0;
		int y=0;

		switch(rotated) {
		case 1:	x=selectedPiece.shape[5].row+tile.getCoords()[0];
				y=selectedPiece.shape[5].column+tile.getCoords()[1];
				break;
		case 2:	x=selectedPiece.shape[5].column+tile.getCoords()[0];
				y=selectedPiece.shape[5].row+tile.getCoords()[1];
				break;
		case 3:	x=selectedPiece.shape[5].row+tile.getCoords()[0];
				y=tile.getCoords()[1]-selectedPiece.shape[5-5].column;
				break;
		case 4:	x=tile.getCoords()[0]-selectedPiece.shape[5].column;
				y=selectedPiece.shape[5].row+tile.getCoords()[1];
				break;
		}

		if(x>rows-2 || y>cols-2 || x<0 || y<0) return false;
		return true;
	}
	
	
	/**
	 * 	is piece at Tile tile escaping borders?
	 * 	this method stops that from happening
	 */
	

	
	public int returnHeight() {
		return this.cols;
	}

	
	public Tile[][] returnBoard() {
		return boardArray;
	}
	public int getGreenTiles() {
 		int greenBois=0;
 		for(int i=0;i<width;i++)
 			for(int j=0;j<height;j++)
 				if(boardArray[i][j].getBackground()==Color.GREEN) greenBois+=1;
 		return greenBois;
 	}
	public void clearPen() {
		for(int i=0;i<rows;i++)
			for(int j=0; j<cols;j++) {
				boardArray[i][j].isCovered=false;
				boardArray[i][j].tileID=9999;
				boardArray[i][j].setBackground(Color.WHITE);
				boardArray[i][j].setBorder(whiteBorder);
			}
	}

	 /** Fills the boardArray of the board
	 * @param type String representing the type of board it is
	 */
	public void fillBoard(){
		int row = 0; 
		int col =0;
		Border penTileBorder = BorderFactory.createLineBorder(Color.WHITE, 1);
		
		for(int i = 0; i < 14; i++){
			for(int j =0; j < 35; j++){
				PuzzleTile t = new PuzzleTile(this, row, col, 999);
				// the new tile will be empty (white)
				t.setBackground(Color.WHITE);

				// set border around tile (white border)
				t.setBorder(penTileBorder);
				boardArray[i][j] = t;
				col++;
			}
			col = 0;
			row++;
			
		}
			
	}

	public boolean isEmpty() {
		for(int i=0;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				if(boardArray[i][j].isCovered) return false;
			}
		}
		return true;
	}
	public Tile[][] getBoardArray() {
		return boardArray;
	}
	
	
	
	
	
}
