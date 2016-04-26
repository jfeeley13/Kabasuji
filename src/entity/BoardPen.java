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

	int width;
	int height;
	protected int tileID;
	protected int boardID;

	/** Board Creation method 
	 *  
	 *  Creates the boardpen, made up of the boardArray[][], with ROWS height, and COLUMNS width
	 *  boardID specifies current board
	 * 
	 * */
	
	public void makeBoard(Tile[][] boardArray, int width, int height, int id){
		this.boardArray = boardArray;
		this.width = width;
		this.height = height;
		this.boardID = id;
	}

	
	public boolean addHex(Tile tile, int tileID){
		
		return false;
	}
	public boolean liftHex(Tile tile,HexTile[] shape){
		
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
			
			boardArray[x][y].setHighlight(true);

			try {
				
				boardArray[x][y].setTileID(tileID+1000);
				boardArray[x][y].setBorder(selectBorder);
				boardArray[x][y].setBackground(c);


				
			} catch(NullPointerException e) {


			}
			

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
			for(int k=0; k<height; k++) 
				if(boardArray[j][k].isHighlight) {
					boardArray[j][k].setBorder(boardPenBorder);
					boardArray[j][k].setBackground(Color.decode("#4169aa"));
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

					boardArray[j][k].setBackground(Color.BLUE);
				}
	}
	
	public int getID() {
		return boardID;
	}
	
	public boolean rotateCheck(Tile tile) {
		return true;
	}

	
	/**
	 * 	is piece at Tile tile escaping borders?
	 * 	this method stops that from happening
	 */
	public boolean borderCheck(Tile tile) {
		int x=0;
		int y=0;


		x=selectedPiece.shape[5].row+tile.getCoords()[0];
		y=selectedPiece.shape[5].column+tile.getCoords()[1];
		
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
