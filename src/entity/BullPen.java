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
	int width;
	int height;
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
		for(int i=0;i<6;i++) {
			int x=hex.shape[i].row+tile.getCoords()[0];
			int y=hex.shape[i].column+tile.getCoords()[1];
			if(init) 
				if(boardArray[x][y].getTileID()<1000) 
					isOverPiece=true;
			
			else if(borderCheck(tile)) 
				if(boardArray[x][y].getTileID()<1000) 
					isOverPiece=true;
			
			else 
				if(boardArray[x][height-6].getTileID()<1000) 
					isOverPiece=true;
			
				
		}

		
		if(isOverPiece) return false;
		if(init){
			
			for(int i=0; i<6;i++){
				int x=hex.shape[i].row+tile.getCoords()[0];
				int y=hex.shape[i].column+tile.getCoords()[1];
				System.out.println("x: " + x + ", " + "y: " + y);
				boardArray[x][y].coverTile();
				boardArray[x][y].setBackground(Color.BLUE);
				boardArray[x][y].setBorder(selectBorder);
				boardArray[x][y].isHighlight=false;
				selectedPiece=null;
				boardArray[x][y].setTileID(tileID);
			}
			pieceList.put(tileID, hex);
			System.out.println("Piece Placed!");
			
		}
		else {
			if((selectedPiece!=null && lifted && !penPiece)) {
				for(int k=0; k<6;k++){
					int x=hex.shape[k].row+tile.getCoords()[0];
					int y=hex.shape[k].column+tile.getCoords()[1];
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
		
		lifted = true;
		return true;
	}
	
	/** Attempts to lift hexomino
	 *  of shape HexTile[] shape off Tile tile 
	 * 
	 */
	public boolean liftHex(Tile tile, Hexomino hex){
 		System.out.println(hex);
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

			
		}
		return true;

	}
	
	
	/** 
	 * 	code for drawing lifted piece as green
	 * 	over tiles
	 */
	public void drawHex(Tile tile, int posx, int posy, Color c) {
		
		if(!borderCheck(tile)) posy=height-6;


		for(int i=0; i<6;i++){
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
		for(int j=0; j<width; j++) 
			for(int k=0; k<height; k++) {
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
	
	public boolean borderCheck(Tile tile) {
		int x=0;
		int y=0;

		try {
		x=selectedPiece.shape[5].row+tile.getCoords()[0];
		y=selectedPiece.shape[5].column+tile.getCoords()[1];
		} catch (Exception e) {}
		if(x<width && y<height) {
			return true;
		}
		else
			return false;
	}

	
	public int returnHeight() {
		return this.height;
	}

	
	public Tile[][] returnBoard() {
		return boardArray;
	}


}
