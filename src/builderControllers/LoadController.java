package builderControllers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import entity.AllHex;
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
	Board board;
	ArrayList<Hexomino> solutionPieces;
	int tileID;
	int row;
	int col;
	boolean isNull;
	int type;
	
	public static File getStoredDirectory() {
		String currentDirectory = System.getProperty("user.dir");
		File f = new File (currentDirectory, "Data/");
		
		return f;
	}
	
	public LoadController(String fileName){
			//File f = new File("%appdata%/" + fileName);
			File f = new File (getStoredDirectory(), fileName);
			System.out.println(f);
			FileReader fr;
			BufferedReader br;
			try {
				fr = new FileReader(f);
				br = new BufferedReader(fr);
				lvlID = Integer.parseInt(br.readLine());
				starsAchieved = Integer.parseInt(br.readLine());
				String pieces = br.readLine();
				while(!pieces.equals("Board")){
					int pID = Integer.parseInt(br.readLine());
					AllHex hexList = new AllHex();
					solutionPieces.add(hexList.getHex(pID));
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
						ReleaseTile rt = new ReleaseTile(board, row, col, tileID);
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
				Level level = new Level(lvlID);
				level.setBoard(board);
				level.setStarsAcheived(starsAchieved);
				
				
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	

		
	}
}
