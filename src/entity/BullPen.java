package entity;

import java.util.List;

import javax.swing.JPanel;

import gameControllers.MListener;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

public class BullPen extends BoardBoss{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Tile boardArray[][];
	List<Hexomino> hexPlaced = new ArrayList<Hexomino>();
	protected int width = 10;
	protected int height = 18;
	protected int tileID;
	protected int boardID = 2;

	
	
	public void makeBoard(Tile[][] boardArray, int width, int height, int id){
		this.boardArray = boardArray;
		this.width = width;
		this.height = height;
		this.boardID = id;
		
		for(int i=0;i<width;i++) 
			for(int j=0; j<height; j++)
				boardArray[i][j].isCovered=false;
	}
	
	public boolean checkCollision(Hexomino reqHex){
		return false;
	}
	
	public int checkNumOfHex(){		
		return hexPlaced.size();
	}
	
	/**
	 * Adds hexomino to board from BullPen (possibly give XY coordinates of piece as well)
	 * 
	 * @param Requested hexomino to be added
	 * @return True if heomino was added, false if hexomino doesn't exist
	 */
	
	public boolean addHex(Tile tile, int tileID){
		//HexTile[] shape = {new HexTile(this,0,0),new HexTile(this,0,1),new HexTile(this,0,-2),new HexTile(this,0,-3),new HexTile(this,0,-4),new HexTile(this,1,0)};
		HexTile[] shape2 = {new HexTile(this,0,0, width, height,1),new HexTile(this,0,1, width, height,1),new HexTile(this,0,2, width, height,1),new HexTile(this,0,3, width, height,1),new HexTile(this,0,4, width, height,1),new HexTile(this,0,5, width, height,1)};
		Hexomino hex = new Hexomino(1, shape2);	
	
		boolean isOverPiece = false;
		boolean allTilesEmpty=CheckTiles(tile, shape2);

		
		for(int i=0;i<6;i++) {
			int x=hex.shape[i].row+tile.getCoords()[0];
			int y=hex.shape[i].column+tile.getCoords()[1];
			if(init) {
				System.out.println("1");
				if(boardArray[x][y].getTileID()<100) 
					isOverPiece=true;
			}
			else if(borderCheck(tile)) {
				System.out.println("2");
				if(boardArray[x][y].getTileID()<100) 
					isOverPiece=true;
			}
			else {
				System.out.println("3");
				if(boardArray[x][height-6].getTileID()<100) 
					isOverPiece=true;
			}
				
		}

		
		if(isOverPiece) return false;
		if(init){
			
			for(int i=0; i<6;i++){
				int x=hex.shape[i].row+tile.getCoords()[0];
				int y=hex.shape[i].column+tile.getCoords()[1];
				System.out.println("x: " + x + ", " + "y: " + y);
				boardArray[x][y].coverTile();
				boardArray[x][y].setBackground(Color.BLUE);
				boardArray[x][y].isHighlight=false;
				hexPlaced.add(selectedPiece);
				selectedPiece=null;
				boardArray[x][y].setTileID(tileID);
			}

			System.out.println("Piece Placed!");

		}
		else {
			if((selectedPiece!=null && lifted && !penPiece)) {
				for(int i=0; i<width; i++) 
					for(int j=0; j<height; j++) {
						for(int k=0; k<6;k++){
							int x=hex.shape[k].row+tile.getCoords()[0];
							int y=hex.shape[k].column+tile.getCoords()[1];
							if(boardArray[x][y].isCovered()) {
								System.out.println("4");
								break;
							}
						}
						
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
		}

		lifted = true;
		return true;
	}
	public boolean CheckTiles(Tile tile,HexTile[] shape){
		Hexomino hex = new Hexomino(1, shape);
		System.out.println("CHECKING");
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
							boardArray[j][k].setBackground(Color.WHITE);
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


			boardArray[x][y].setHighlight(true);


			//System.out.println("The x and y are:" + x + y);
			//boardArray[x][y].coverTile();
			try {
				
				if(!boardArray[x][y].isCovered) {
					boardArray[x][y].setTileID(tileID+100);
					
				}
				//System.out.println(tileID+100);
				boardArray[x][y].setBackground(c);
				
				//if(boardArray[x][y].isCovered) {
					
				//}
				

				
			} catch(Exception e) {


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
	
	
	public void redraw() {
		
		for(int j=0; j<width; j++) 
			for(int k=0; k<height; k++) 
				if(boardArray[j][k].tileID<100) {
					
					if(!boardArray[j][k].isHighlight)
						boardArray[j][k].setBackground(Color.BLUE);
					else {
						//System.out.println("B");
						//boardArray[j][k].setBackground(Color.GREEN);
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

		//System.out.println(selectedPiece.shape[5].column);
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
	
	public int returnHeight() {
		return this.height;
	}

	
	public Tile[][] returnBoard() {
		return boardArray;
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
