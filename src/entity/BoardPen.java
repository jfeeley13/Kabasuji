package entity;

import java.awt.Color;

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
	public void drawHex(Tile tile, int posx, int posy, Color c) {
		int widthOver=0;
		int heightOver=0;
		
		int lastX=0;
		for(int i=0; i<6; i++) {
			int y=0;
			int x=0;
			x=selectedPiece.shape[i].row+posx;
			try {
				Tile testTile = boardArray[x][y];
			} catch (Exception e) {
				if(x!=lastX) {
					if((tile.getCoords()[0]<width/2-1))
						widthOver-=1;
					else
						widthOver+=1;
				}
				lastX=x;
				}
		}
		
		int lastY=0;
		for(int i=0; i<6; i++) {
			int y=0;
			int x=0;
			y=selectedPiece.shape[i].column+posy;
			try {
				Tile testTile = boardArray[x][y];
			} catch (Exception e) {
				if(y>lastY)
					heightOver+=1;
				lastY=y;
				}
		}
		for(int i=0; i<6;i++){
			int x = 0;
			int y = 0;
			switch(rotated) {
			case 1:	x=selectedPiece.shape[i].row+posx-widthOver;
					y=selectedPiece.shape[i].column+posy-heightOver;
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
				
				boardArray[x][y].setTileID(tileID+1000);
				boardArray[x][y].setBorder(selectBorder);
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
			for(int k=0; k<height; k++) 
				if(boardArray[j][k].isHighlight || boardArray[j][k].getBackground()==Color.GREEN) {
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
	public int getGreenTiles() {
 		int greenBois=0;
 		for(int i=0;i<width;i++)
 			for(int j=0;j<height;j++)
 				if(boardArray[i][j].getBackground()==Color.GREEN) greenBois+=1;
 		return greenBois;
 	}
	
	/**
	 * 	is piece at Tile tile escaping borders?
	 * 	this method stops that from happening
	 */
	
	
	public int returnHeight() {
		return this.height;
	}

	
	public Tile[][] returnBoard() {
		return boardArray;
	}



}
