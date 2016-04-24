package entity;

import java.util.List;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

public class BullPen extends BoardBoss{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Tile boardArray[][];
//	protected Hexomino hexPlaced[] = new Hexomino[];
	List<Hexomino> hexPlaced = new ArrayList<Hexomino>();
	protected int XOrigin;
	protected int YOrigin;
	protected int width = 10;
	protected int height = 18;
	protected int tileID;
	protected int boardID = 2;

	
	
	public void makeBoard(Tile[][] boardArray, int width, int height, int id){
		this.boardArray = boardArray;
		this.width = width;
		this.height = height;
		this.boardID = id;
	}

	public int[] getTopLeft(){
		int[] origin = {XOrigin, YOrigin};
		return origin;
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
	
	public boolean addHex(Tile tile){
		//HexTile[] shape = {new HexTile(this,0,0),new HexTile(this,0,1),new HexTile(this,0,-2),new HexTile(this,0,-3),new HexTile(this,0,-4),new HexTile(this,1,0)};
		HexTile[] shape2 = {new HexTile(this,0,0, width, height,1),new HexTile(this,0,1, width, height,1),new HexTile(this,0,2, width, height,1),new HexTile(this,0,3, width, height,1),new HexTile(this,0,4, width, height,1),new HexTile(this,0,5, width, height,1)};
		Hexomino hex = new Hexomino(1, shape2);	
	
		boolean allTilesEmpty=CheckTiles(tile, shape2);
		
		if((selectedPiece!=null && lifted && !penPiece) || init){
			for(int i=0; i<6;i++){
				int x=hex.shape[i].row+tile.getCoords()[0];
				int y=hex.shape[i].column+tile.getCoords()[1];
				//System.out.println("The x and y are:" + x + y);
				boardArray[x][y].coverTile();
				boardArray[x][y].setBackground(Color.BLUE);
				hexPlaced.add(hex);
				penPiece = true;
				boardArray[x][y].setTileID(board.id);
			}
			

			System.out.println("Piece Placed!");

		}

		lifted = true;
		return true;
	}
	public boolean CheckTiles(Tile tile,HexTile[] shape){
		Hexomino hex = new Hexomino(1, shape);
		for(int i=0; i<6;i++){
			int x=hex.shape[i].row+tile.getCoords()[0];
			int y=hex.shape[i].column+tile.getCoords()[1];
			
			if(boardArray[x][y].isCovered()==true){
				tileID = boardArray[x][y].getTileID();
				System.out.println(tileID);
				System.out.println("Selected Piece!");
				for(int j=0; j<width; j++) 
					for(int k=0; k<height; k++) 
						if(boardArray[j][k].tileID==tileID) {
							
							//x=hex.shape[j].row+tile.getCoords()[0];
							//y=hex.shape[j].column+tile.getCoords()[1];
							boardArray[j][k].isCovered = false;
							boardArray[j][k].setBackground(Color.WHITE);
						}
				selectedPiece = hex;
				lifted = false;
				penPiece = false;
				drawHex(tile,1,1);
				return false;
			}

			
		}
		return true;

	}
	
	public void drawHex(Tile tile, int posx, int posy) {

		for(int i=0; i<6;i++){
			int x = 0;
			int y = 0;
			switch(rotated) {
			case 1:	x=selectedPiece.shape[i].row+tile.getCoords()[0];
					y=selectedPiece.shape[i].column+tile.getCoords()[1];
					break;
			case 2:	x=selectedPiece.shape[i].column+tile.getCoords()[0];
					y=selectedPiece.shape[i].row+tile.getCoords()[1];
					break;
			case 3:	x=selectedPiece.shape[i].row+tile.getCoords()[0];
					y=tile.getCoords()[1]-selectedPiece.shape[5-i].column;
					break;
			case 4:	x=tile.getCoords()[0]-selectedPiece.shape[i].column;
					y=selectedPiece.shape[i].row+tile.getCoords()[1];
					break;
			}

				

			
			//System.out.println("The x and y are:" + x + y);
			//boardArray[x][y].coverTile();
			try {
				boardArray[x][y].setTileID(tileID+100);
				boardArray[x][y].setBackground(Color.GREEN);


				
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
				if(boardArray[j][k].tileID==tileID+100) {
					
					//x=hex.shape[j].row+tile.getCoords()[0];
					//y=hex.shape[j].column+tile.getCoords()[1];
					//boardArray[j][k].isCovered = false;
					boardArray[j][k].setBackground(Color.WHITE);
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
		//System.out.println("x: " + x);
		//System.out.println("y: " + y);
		if(x>width-2 || y>height-2 || x<0 || y<0) return false;
		return true;
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
