package builderControllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import entity.Board;
import entity.Hexomino;
import entity.Level;
import entity.LightningTile;
import entity.PuzzleTile;
import entity.ReleaseTile;
import entity.Tile;

public class LoadController {
	int lvlID;
	int starsAchieved;
	int boardWidth;
	int boardHeight;
	Board board = new Board();
	ArrayList<Hexomino> solutionPieces;
	String type;
	public LoadController(File f){
		try {
			Scanner s = new Scanner(f);
			//each s.next() moves the scanner to the next WORD in file
			//I use s.next(String) to just ensure that I'm at certain part of the string in the file
			s.next("Level"); 
			lvlID = s.nextInt(); //next word after Level is always the id off the level
			s.nextLine();
			s.next("AchievedStars"); //
			starsAchieved = s.nextInt();
			s.nextLine();
			s.next("SolutionPieces");
			String pieces = s.next();
			while(!pieces.equals("Board")){
				// we need to retrieve pieeces by their ID so we do not have to create hexonimos objects each time.
				//and then add to arraylist
			}
			//after this loop we know we at the board stuff
			s.next("BoardWidth");
			boardWidth = s.nextInt();
			s.next("BoardHeight");
			boardHeight = s.nextInt();
			s.nextLine();
			//next line after dimensions are all the tiles
			Tile tileArray[][] = new Tile[boardWidth][boardHeight];
			board.makeBoard(tileArray, boardWidth, boardHeight, 1);
			while(s.hasNextLine()){
				processTile(s, tileArray);
				s.nextLine();
				//go to next tile
			}
			
			Level level = new Level(lvlID, type);
			level.setBoard(board);
			level.setColumns(boardHeight);
			level.setRows(boardWidth);
			level.setStarsAcheived(starsAchieved);
			//level.setSolutionPieces(solutionPieces);
			
			//now that string data is retrieved, time to process it
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void processTile(Scanner s, Tile tileArray[][]){
		s.next("Tile");  
		int tileID = s.nextInt();
		type = s.next();
		int row = s.nextInt();
		int column = s.nextInt();
		boolean isNull;
		if(s.next() == "true")
			isNull = true;
		isNull = false;
		if(type.equals("PuzzleTile")){
			PuzzleTile pt = new PuzzleTile(board, row, column, tileID);
			tileArray[row][column] = pt;
		}
		if(type.equals("Lighting Tile")){
			LightningTile lt = new LightningTile(board, row, column, tileID);
			tileArray[row][column] = lt;
		}
		else{
			String setColor = s.next();
			int setNum = s.nextInt();
			ReleaseTile rt = new ReleaseTile(board, row, column, setColor, setNum, tileID);
			tileArray[row][column] = rt;
		}
	}
}
