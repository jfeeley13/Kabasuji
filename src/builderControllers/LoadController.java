package builderControllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import entity.Board;

public class LoadController {
	int lvlID;
	public LoadController(File f){
		try {
			Scanner s = new Scanner(f);
			s.next("Level");
			lvlID = processInt(s.nextLine());
			s.next("AchievedStars");
			int starsAchieved = processInt(s.nextLine());
			s.next("SolutionPieces");
			String solutionPieces = s.nextLine();
			//I still need a toString method for hexonimos and hextiles
			s.next("Board");
			ArrayList<String> boardArray = new ArrayList<String>();
			while(s.hasNextLine()){
				boardArray.add(s.nextLine());
			}
			
			//now that string data is retrieved, time to process it
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public int processInt(String integer){
		return Integer.parseInt(integer);
	}
//	public Board processBoard(ArrayList<String> tileStrings){
		//for (int i =0; i < tileStrings.size(); i++)
			//processTile(tileStrings.get(i));
		//after processing all tiles, add them to the board based on the row and col each tile has
	//}
	//public Tile processTile(String t){
		
	//}
}
