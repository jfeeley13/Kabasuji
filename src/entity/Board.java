package entity;

import javax.swing.BorderFactory;
import views.YouWin;

import java.awt.Color;

public class Board extends BoardBoss{
	
	/**
	 *  
	 */
	private static final long serialVersionUID = 1L;
	protected Tile boardArray[][];

	int cols;
	int rows;
	protected int tileID;
	protected int boardID = 1;
	int moves;

	/** Board Creation method 
	 *  
	 *  Creates the board, made up of the boardArray[][], with height ROWS, and width COLUMNS
	 *  boardID specifies current board
	 * 
	 * */
	
	public void makeBoard(Tile[][] boardArray, int rows, int columns, int id){
		this.boardArray = boardArray;
		this.cols = columns;
		this.rows = rows;
		this.boardID = id;
	}
	
	
	/** adds hexomino to Tile tile
	 *  with specified id tileID
	 * 
	 */
	public boolean addHex(Tile tile, int tileID, Hexomino hex){
		boolean isOverPiece = false;
		boolean allTilesEmpty=liftHex(tile, hex);
		
		System.out.println("1");
		if(selectedPiece==null && !init) return false;

		if(selectedPiece!=null & lifted) {
			for(int i=0; i<rows; i++) 
				for(int j=0; j<cols; j++) 
					if((boardArray[i][j].getBackground()==Color.GREEN || boardArray[i][j].getBackground()==Color.RED) && (boardArray[i][j].isCovered||!boardArray[i][j].checkValid()))
						return false;
			
			for(int i=0; i<rows; i++) 
				for(int j=0; j<cols; j++) {
					if((boardArray[i][j].getBackground()==Color.GREEN && !boardArray[i][j].isCovered)|| !boardArray[i][j].isValid() && boardArray[i][j].checkValid()) {
						boardArray[i][j].coverTile();
						boardArray[i][j].setBackground(Color.BLUE);
						boardArray[i][j].isHighlight=false;
						selectedPiece=null;
						boardArray[i][j].setTileID(tileID);
					
					}
				}
			pieceList.put(tileID, hex);
			moves-=1;
			}
		lifted = true;
		hasWon();
		return true;
	}
	
	/** Attempts to lift hexomino
	 *  of shape HexTile[] shape off Tile tile 
	 * 
	 */
	public boolean liftHex(Tile tile,Hexomino hex){

			int x=tile.getCoords()[0];
			int y=tile.getCoords()[1];
			
			if(!boardArray[x][y].canPickUp()) return false;

			
			if(boardArray[x][y].isCovered()==true && selectedPiece==null){
				tileID = boardArray[x][y].getTileID();
				//System.out.println(tileID);
				System.out.println("Selected Piece!");

				for(int j=0; j<rows; j++) 
					for(int k=0; k<cols; k++) 
						if(boardArray[j][k].tileID==tileID) {

							boardArray[j][k].isCovered = false;
							boardArray[j][k].setBackground(Color.WHITE);
							boardArray[j][k].setTileID(tileID+1000);

						}

				selectedPiece = hex;
				lifted = false;
				penPiece = false;
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
			int rows = 0;
			int columns = 0;
			if(!BoardBoss.isBuilder) {
				rows = selectedPiece.shape[i].row+posy;
				columns = selectedPiece.shape[i].column+posx;
			}
			else {
				rows = selectedPiece.shape[i].column+posy;
				columns = selectedPiece.shape[i].row+posx;
			}
			int x = columns;
			int y = rows;
			/**
			switch(flipped) {
			case 1: rows = rows;
					columns = columns;
					break;
			case 2: rows = rows * -1;
					break;
			case 3: columns = columns;
					break;
			case 4: columns = columns*-1;
					break;
			case 5: rows = rows * -1;
					columns = columns*-1;
					break;
			}
			
			switch(rotated) {
			case 1:	x=rows+orgX-widthOver;
					y=columns+orgY-heightOver;
					break;
			case 2:	x=columns+orgX;
					y=rows+orgY;
					break;
			case 3:	x=orgX-rows;
					y=orgY-selectedPiece.shape[5-i].column;
					break;
			case 4:	x=orgX-columns;
					y=rows+orgY;
					break;
			}
			*/
			try{
				boardArray[x][y].setHighlight(true);
			
				try {
					if(!boardArray[x][y].isCovered()) {
						boardArray[x][y].setTileID(1000);					
					}
					if(boardArray[x][y].checkValid()){
						if(!boardArray[x][y].isCovered())
							boardArray[x][y].setBackground(c);
						else{
							boardArray[x][y].setBackground(Color.red);
						//	boardArray[x][y].setBorder(BorderFactory.createLineBorder(Color.red, 1));
						}
					}else{ boardArray[x][y].setBackground(Color.red);
					//boardArray[x][y].setBorder(BorderFactory.createLineBorder(Color.red, 1));
					}
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
		for(int j=0; j<cols; j++) 
			for(int k=0; k<rows; k++) {
				if(boardArray[j][k].isHighlight ) {
					boardArray[j][k].setBackground(Color.WHITE);
				}
				if(boardArray[j][k].isCovered){
					boardArray[j][k].setBackground(Color.BLUE);
				}
				if(boardArray[j][k].checkMark()){
					boardArray[j][k].setBackground(Color.BLUE);
				}
				if((!boardArray[j][k].checkValid())){
					boardArray[j][k].setBackground(Color.decode("#4169aa"));
					boardArray[j][k].setBorder(BorderFactory.createLineBorder(Color.decode("#4169aa"), 1));
				}
			}
	}
	
	public int getID() {
		return boardID;
	}
	
	
	/** 
	 * 	redraw all the current pieces,
	 * 	both placed and lifted
	 * 
	 */
	public void redraw() {/**
		for(int j=0; j<rows; j++) 
			for(int k=0; k<cols; k++) 
				if(boardArray[j][k].tileID<1000) {
					
					if(!boardArray[j][k].isHighlight)
						boardArray[j][k].setBackground(Color.BLUE);
					else {
						boardArray[j][k].setHighlight(false);
					}
				}*/

	}
	
	/**
	 * 
	 */
	public Tile[][] returnBoard() {
		return boardArray;
	}
	public int getGreenTiles() {
		 		int greenBois=0;
		 		for(int i=0;i<cols;i++)
		 			for(int j=0;j<rows;j++)
		 				if(boardArray[i][j].getBackground()==Color.GREEN) greenBois+=1;
		 		return greenBois;
		 	}
	
	/**
	 * 	you win!
	 * 	opens win window
	 * 	and sets win status
	 */
	public boolean hasWon(){
		for(int i = 0; i < rows; i++){
			for(Tile t : boardArray[i]){
				if(!t.hasWon()) {
					return true;
				}
			}
		}
		
		System.out.println("You win!");
		moves=-1;
		YouWin hs = new YouWin();
		hs.newwindow();
		winAnimation();
		return false;
	}
	
	/**
	 * 	plays win animation
	 */
	public void winAnimation() {
		int k=0;
		Color[] colorList = new Color[3];
		colorList[0] = Color.GREEN;
		colorList[1] = Color.RED;
		colorList[2] = Color.BLUE;
		for(int i=0; i<width; i++) 
			for(int j=0; j<height; j++) {
				boardArray[j][i].setBackground(colorList[1]);
				k=(k+1)%3;
			}
	}
	//public void setBoard(Tile[][] board) {
 	//	boardArray=board.clone();
 	//	return;
 	//}
	
	/**
	 * Resizes the field boardArray in Board class
	 * @param newColumns new number of rows in board
	 * @param newRows new number of columns in board
	 */
	public Board resizeBoardArray(int newRows, int newColumns){
		//check if the new dimension are smaller or bigger than previous array
		Tile[][] newBoard = new Tile[newRows][newColumns];
		if(newColumns == this.cols && this.rows == newRows)
			return this;
		//case 1: new board is smaller
		if(newRows < rows && newColumns < cols)
			copyContents(newBoard, newRows, newColumns);
		//case 2: new board height is smaller
		else if(newRows < rows)
			copyContents(newBoard, newRows, cols);
		else if(newColumns < cols)
			copyContents(newBoard, rows, newColumns);
		else{
			//case 4: new board is bigger in height and width
			copyContents(newBoard, rows, cols);
			Tile t = boardArray[0][0];
			t.setRow(rows - 1);
			t.setColumn(cols - 1);
			for(int i = rows - 1; i < newRows; i++){
				for(int j = cols; j < newColumns; j++){
					//just copy the origin tile to the new places to ensure it is the same type of tile.
					newBoard[i][j] = t;
					t.setColumn(j);
				}
				t.setRow(i);
			}
		}
		this.cols = newColumns;
		this.rows = newRows;
		this.boardArray = newBoard;
		return this;
		//now update width and height
	}
	/**
	 * Copies the contents of boardArray into a newBoard up to a specified row and column limit
	 * @param newBoard 
	 * @param row
	 * @param cols
	 */
	public void copyContents(Tile[][] newBoard ,int row, int cols){
		for(int i= 0; i < row; i++){
			for(int j = 0; j < cols; j++){
				newBoard[i][j] = boardArray[i][j]; 
			}
		}
	}
	
	public String toString(){
		String returnString = cols + "\n" + rows + "\n";
		for(int i = 0; i < cols; i++){
			for(Tile t: boardArray[i])
				returnString = returnString + t.toString() + "\n";
		}
		return returnString;
	}
	
	/**
	 * Fills the boardArray of the board
	 * @param type String representing the type of board it is
	 */
	public void fillBoard(String type){
		int row = 0; 
		int col =0;
		
		for(int i = 0; i < rows; i++){
			for(int j =0; j < cols; j++){
				if(type.equals("Puzzle Level"))
					boardArray[i][j] = new PuzzleTile(this, row, col, 999);
				else if(type.equals("Lightning Level"))
					boardArray[i][j] = new LightningTile(this, row, col, 999);
				else
					boardArray[i][j] = new ReleaseTile(this, row, col, 999);
				col++;
			}
			col = 0;
			row++;
			
		}
			
	}
	
	public void setMoves(int moves){
		this.moves = moves;
	}
	
	public int getMoves(){
		return moves;
	}


	public int getCols() {
		return this.cols;
	}


	public int getRows() {
		return this.rows;
	}


	public Tile[][] getBoardArray() {
		return boardArray;
	}

	


}
