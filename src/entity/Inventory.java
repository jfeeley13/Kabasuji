package entity;

import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

import gameControllers.MListener;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

public class Inventory extends BoardBoss{
	

	private static final long serialVersionUID = 1L;
	public Tile boardArray[][];
	int width;
	int height;
	protected int tileID;
	protected int boardID = 4;
	
	


	/** Board Creation method 
	 *  
	 *  Creates the bullpen, made up of the boardArray[][], with ROWS height, and COLUMNS width
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
		liftHex(tile, hex);
		
		
		
		if(selectedPiece==null && !(init || refill)) return false;
		
		if(isOverPiece) return false;
		if(init || refill){
			
			for(int i=0; i<6;i++){
				int x=hex.shape[i].row+tile.getCoords()[0];
				int y=hex.shape[i].column+tile.getCoords()[1];

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
				selectedPiece=null;
				for(int i=0; i<width; i++) 
					for(int j=0; j<height; j++) {
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
				for(int j=0; j<width; j++) 
					for(int k=0; k<height; k++) 
						/*if(boardArray[j][k].tileID==tileID) {
							boardArray[j][k].isCovered = false;
							boardArray[j][k].setTileID(tileID+1000);
							boardArray[j][k].setBackground(Color.WHITE);
							boardArray[j][k].setBorder(whiteBorder);
						}
						*/
						boardArray[j][k].setBorder(whiteBorder);

				selectedPiece = hex;
				lifted = false;
				penPiece = false;
				penPieces-=1;
				
				drawHex(tile,x,y, Color.GREEN);
				redraw();

				return false;
			}

		return true;

	}
	
	
	/** 
	 * 	code for drawing lifted piece as green
	 * 	over tiles
	 */
	public void drawHex(Tile tile, int posx, int posy, Color c) {

		int widthOver=0;
		int heightOver=0;
		

		for(int i=0; i<6;i++){
			int x = 0;
			int y = 0;
			switch(rotated) {
			case 1:	x=selectedPiece.shape[i].row+posx-widthOver;
					y=selectedPiece.shape[i].column+posy-heightOver;
					break;
			case 2:	x=selectedPiece.shape[i].column+posx-heightOver;
					y=selectedPiece.shape[i].row+posy-widthOver;
					break;
			case 3:	x=selectedPiece.shape[i].row+posx-widthOver;
					y=posy-selectedPiece.shape[5-i].column-heightOver;
					break;
			case 4:	x=posx-selectedPiece.shape[i].column-heightOver;
					y=selectedPiece.shape[i].row+posy-widthOver;
					break;
			}



			try {
				boardArray[x][y].setHighlight(true);
			
			
			try {
				
				//if(boardArray[x][y].isCovered) {
					boardArray[x][y].setTileID(1000);
					
				//}
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
		for(int j=0; j<width; j++) 
			for(int k=0; k<height; k++) {
				if(boardArray[j][k].getBackground()==Color.GREEN) {
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
		
		for(int j=0; j<width; j++) 
			for(int k=0; k<height; k++) 
				if(boardArray[j][k].tileID<1000) {
					
					if(!boardArray[j][k].isHighlight){
						boardArray[j][k].setBackground(Color.BLUE);
						boardArray[j][k].setBorder(selectBorder);
				}
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

		if(x>width-2 || y>height-2 || x<0 || y<0) return false;
		return true;
	}
	
	
	/**
	 * 	is piece at Tile tile escaping borders?
	 * 	this method stops that from happening
	 */
	

	
	public int returnHeight() {
		return this.height;
	}
	
	public int returnWidth() {

		return this.width;
	}
	
	public int getGreenTiles() {
		int greenBois=0;
		for(int i=0;i<width;i++)
			for(int j=0;j<height;j++)
				if(boardArray[i][j].getBackground()==Color.GREEN) greenBois+=1;
		return greenBois;
	}
	
	public void setBoard(Tile[][] board) {
		boardArray=board;
		return;
	}

	
	public Tile[][] returnBoard() {
		return boardArray;
	}

	public void clearPen() {
		for(int i=0;i<width;i++)
			for(int j=0; j<height;j++) {
				boardArray[i][j].isCovered=false;
				boardArray[i][j].tileID=9999;
				boardArray[i][j].setBackground(Color.WHITE);
				boardArray[i][j].setBorder(whiteBorder);
			}
	}

}