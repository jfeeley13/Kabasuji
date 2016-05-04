package builderControllers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import entity.AllLevels;
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
	boolean isValid;
	int type;
	public static Level customLevel;
	
	public static File getStoredDirectory() {
		String currentDirectory = System.getProperty("user.dir");
		File f =null;
		try{
		f = new File (currentDirectory, "Data/");
		} catch (Exception e) {};
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
				System.out.println("ID "+lvlID);

				int timer = Integer.parseInt(br.readLine());
				System.out.println("timer "+starsAchieved);

				int moves = Integer.parseInt(br.readLine());
				System.out.println("moves "+moves);

				/*while(!pieces.equals("Board")){
					int pID = Integer.parseInt(br.readLine());
					AllHex hexList = new AllHex();
					solutionPieces.add(hexList.getHex(pID));
				}*/

				boardWidth = Integer.parseInt(br.readLine());
				System.out.println("width "+boardWidth);

				boardHeight = Integer.parseInt(br.readLine());
				System.out.println("height "+boardHeight);

				Tile tileArray[][] = new Tile[boardWidth][boardHeight];
				Board board = new Board();
				boolean run = true;
				while(run==true){
					String x=br.readLine();
					if(x != null){
	
						tileID = Integer.parseInt(x);
						System.out.println("tileID "+tileID);
	
						String rowRead =br.readLine();
	
						row = Integer.parseInt(rowRead);
						System.out.println("row "+row);
	
						col = Integer.parseInt(br.readLine());
						System.out.println("col "+col);
	
						isValid = Boolean.parseBoolean(br.readLine());
						System.out.println("isValid "+isValid);
	
						type = Integer.parseInt(br.readLine());
						System.out.println("type "+type);
	
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
					run=false;
				}
				board.makeBoard(tileArray, boardWidth, boardHeight, 1);
				customLevel = new Level(lvlID);
				customLevel.setBoard(board);
				customLevel.setLvlID(lvlID);
				customLevel.setTimer(timer);
				customLevel.setMoves(moves);
				customLevel.setHeight(boardHeight);
				customLevel.setWidth(boardWidth);

				//level.setStarsAcheived(starsAchieved);
				
				if(type == 2){
					customLevel.setType("Release Level");
					views.Level.openLevel("Custom Level",lvlID);
				}
				else if(type == 1){
					customLevel.setType("Lightning Level");
					views.Level.openLevel("Custom Level",lvlID);
				}else{
					customLevel.setType("Puzzle Level");
					views.Level.openLevel("Custom Level",lvlID);

				}
				
				
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	

		
	}
}
