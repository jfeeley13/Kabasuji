package entity;

import java.util.HashMap;
import java.util.List;

import javax.swing.JPanel;

import gameControllers.MListener;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

public class Board extends BoardBoss{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Tile boardArray[][];
	List<Hexomino> hexPlaced = new ArrayList<Hexomino>();

	int width;
	int height;
	protected int tileID;
	protected int boardID = 1;

	
	public void makeBoard(Tile[][] boardArray, int width, int height, int id){
		this.boardArray = boardArray;
		this.width = width;
		this.height = height;
		this.boardID = id;
	}
	
	public boolean checkCollision(Hexomino reqHex){
		return false;
	}
	
	public int checkNumOfHex(){		
		return hexPlaced.size();
	}
	
	public boolean hasWon(){
		for(int i = 0; i < width; i++){
			for(Tile t : boardArray[i]){
				if(!t.hasWon()) {
					
					return true;
				}
			}
		}
		System.out.println("You win!");
		winAnimation();
		return false;
	}
	
	/**
	 * Adds hexomino to board from BullPen (possibly give XY coordinates of piece as well)
	 * 
	 * @param Requested hexomino to be added
	 * @return True if heomino was added, false if hexomino doesn't exist
	 */
	
	public boolean addHex(Tile tile, int tileID){
		//HexTile[] shape = {new HexTile(this,0,0, width, height),new HexTile(this,0,1, width, height),new HexTile(this,0,-2, width, height),new HexTile(this,0,-3, width, height),new HexTile(this,0,-4, width, height),new HexTile(this,1,0, width, height)};
		HexTile[] shape2 = {new HexTile(this,0,0, width, height,1),new HexTile(this,0,1, width, height,1),new HexTile(this,0,2, width, height,1),new HexTile(this,0,3, width, height,1),new HexTile(this,0,4, width, height,1),new HexTile(this,0,5, width, height,1)};
		Hexomino hex = new Hexomino(1, shape2);	
	
		boolean isOverPiece = false;
		boolean allTilesEmpty=CheckTiles(tile, shape2);
		for(int i=0; i<6;i++){
			int x=hex.shape[i].row+tile.getCoords()[0];
			int y=hex.shape[i].column+tile.getCoords()[1];
			if(borderCheck(tile)) {
				if(boardArray[x][y].getTileID()<100) isOverPiece=true;
			}
			else {
				if(boardArray[x][height-6].getTileID()<100) isOverPiece=true;
			}
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
						hexPlaced.add(selectedPiece);
						selectedPiece=null;
						boardArray[i][j].setTileID(tileID);
					
					}
				}
			}

		lifted = true;
		hasWon();
		return true;
	}
	public boolean CheckTiles(Tile tile,HexTile[] shape){
		Hexomino hex = new Hexomino(1, shape);
		for(int i=0; i<6;i++){
			//int x=hex.shape[i].row+tile.getCoords()[0];
			//int y=hex.shape[i].column+tile.getCoords()[1];
			int x=tile.getCoords()[0];
			int y=tile.getCoords()[1];
			
			if(boardArray[x][y].isCovered()==true && selectedPiece==null){
				tileID = boardArray[x][y].getTileID();
				System.out.println(tileID);
				System.out.println("Selected Piece!");
				for(int j=0; j<width; j++) 
					for(int k=0; k<height; k++) 
						if(boardArray[j][k].tileID==tileID) {
							//x=hex.shape[j].row+tile.getCoords()[0];
							//y=hex.shape[j].column+tile.getCoords()[1];
							boardArray[j][k].isCovered = false;

							boardArray[j][k].setTileID(tileID+100);
							//boardArray[j][k].setBackground(Color.WHITE);
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
			
			boardArray[x][y].setHighlight(true);
			//System.out.println("The x and y are:" + x + y);
			//boardArray[x][y].coverTile();
			try {
				if(!boardArray[x][y].isCovered) {
					boardArray[x][y].setTileID(tileID+100);
					
				}
				boardArray[x][y].setBackground(c);
				
				//if(boardArray[x][y].isCovered) {
					
				//}
				

			} catch(NullPointerException e) {

			}
			
			//hexPlaced.add(selectedPiece);
			//penPiece = true;
			//boardArray[x][y].setTileID(board.id);
		}	
	}
	
	
	public void refresh() {
		for(int j=0; j<width; j++) 
			for(int k=0; k<height; k++) 
				if(boardArray[j][k].isHighlight) {
					
					//x=hex.shape[j].row+tile.getCoords()[0];
					//y=hex.shape[j].column+tile.getCoords()[1];
					//boardArray[j][k].isCovered = false;
					boardArray[j][k].setBackground(Color.WHITE);
				}
	}
	
	public int getID() {
		return boardID;
	}
	
	public void redraw() {
		for(int j=0; j<width; j++) 
			for(int k=0; k<height; k++) 
				if(boardArray[j][k].tileID<100) {
					
					if(!boardArray[j][k].isHighlight)
						boardArray[j][k].setBackground(Color.BLUE);
					else {
						//boardArray[j][k].setBackground(Color.GREEN);
						boardArray[j][k].setHighlight(false);
					}
				}

	}
	/**
	 * 
	 * Removes selected hexomino from board
	 * 
	 * @param Requested hexomino to be removed 
	 * @return true if hexomino was removed, false if hexomino doesn't exist
	 */
	public boolean removeHex(Hexomino hex){
		boolean isValid = true;
		return isValid;
	}
	
	public boolean borderCheck(Tile tile) {
		int x=0;
		int y=0;

		//System.out.println(selectedPiece.shape[5].column);

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
	
	public void winAnimation() {
		int k=0;
		Color[] colorList = new Color[3];
		colorList[0] = Color.GREEN;
		colorList[1] = Color.RED;
		colorList[2] = Color.BLUE;
		for(int i=0; i<width; i++) 
			for(int j=0; j<height; j++) {
				boardArray[i][j].setBackground(colorList[1]);
				k=(k+1)%2;
			}
	}
	/**
	 * 
	 * @param x location of click in pixels
	 * @param y location of click in pixels
	 * @return Tile that is being selected
	 * Throws exception if tile does not exist at selected location
	 * 
	 */
/*	public Tile getTile(int x, int y){
		int tRow = (y-YOrigin)/tileBoard[0].getTileWidth();
		int tCol = (x-XOrigin)/tileBoard[0].getTileHeight();
		int tile = 0; //Placeholder value
		return tileBoard[tile];
	}
	//Can throw NullTileException
	public Point getTopLeftOfTile(Tile tile){
		Point coords = new Point(0, 0);
		return coords; 
	}
	*/
}
