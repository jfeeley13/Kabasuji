package builderControllers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import entity.Board;
import entity.Hexomino;
import entity.Level;
import entity.LevelBuilder;
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
	int tileID;
	int row;
	int col;
	boolean isNull;
	int type;
	
	
	public LoadController(File f){
			FileReader fr;
			BufferedReader br;
			try {
				fr = new FileReader(f);
				br = new BufferedReader(fr);
				lvlID = Integer.parseInt(br.readLine());
				starsAchieved = Integer.parseInt(br.readLine());
				String pieces = br.readLine();
				while(!pieces.equals("Board")){
					br.readLine();
				}
				boardWidth = Integer.parseInt(br.readLine());
				boardHeight = Integer.parseInt(br.readLine());
				Tile tileArray[][] = new Tile[boardWidth][boardHeight];
				Board board = new Board();
				
				while(br.readLine() != null){
					tileID = Integer.parseInt(br.readLine());
					row = Integer.parseInt(br.readLine());
					col = Integer.parseInt(br.readLine());
					isNull = Boolean.parseBoolean(br.readLine());
					type = Integer.parseInt(br.readLine());
					if(type == 2){
						String setColor = br.readLine();
						int setNum = Integer.parseInt(br.readLine());
						ReleaseTile rt = new ReleaseTile(board, row, col, setColor, setNum, tileID);
						tileArray[row][col] = rt;
					}
					else if(type == 1){
						LightningTile lt = new LightningTile(board, row, col, tileID);
						tileArray[row][col] = lt;
					}
					else{
						PuzzleTile pt = new PuzzleTile(board, row, col, tileID);
						tileArray[row][col] = pt;
					}
				}
				board.makeBoard(tileArray, boardWidth, boardHeight, 1);
				
				
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	

		
	}
}
