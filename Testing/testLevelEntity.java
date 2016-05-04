import static org.junit.Assert.*;

import org.junit.Test;



import java.awt.Color;
import java.util.ArrayList;

import org.junit.Test;

import entity.*;
import entity.Level;
import views.*;

public class testLevelEntity {

/*	@Test
	public void test() {
		fail("Not yet implemented");
	}
*/	
	@Test
	public void testMakeElements(){
		
		
		AllLevels levels = new AllLevels();
		AllHex allhex = new AllHex(); 
		Board board = new Board();
		Level level = new Level(1);
		board = level.initializeBoard("Puzzle Level", 6, 6);
		board = level.initializeBoard("Release Level", 12, 12);
		board = level.initializeBoard("Lightning Level", 8, 6);
		ArrayList<Hexomino> hexList = allhex.getHexominos(1,2,5,10);
		level.setSolutionPieces(hexList);
		BoardBoss bullpen = new BullPen();
		BoardBoss inv = new Inventory();
//		bullpen = level.initializeBullPen();
		
		levels.getLightningLevel(1);
		levels.getReleaseLevel(1);
		levels.getPuzzleLevel(1);
		
		Builder a = new Builder("Puzzle Level", 6, 6, "Derp", 5);
		BuilderSplashScreen b = new BuilderSplashScreen(); 
		BuildStart c = new BuildStart();
		GameOver d = new GameOver();
		HelpScreen e = new HelpScreen();
		views.Level f = new views.Level(1, "Release Level");
		views.Level f1 = new views.Level(2, "Puzzle Level");
		views.Level f2 = new views.Level(1, "Lightning Level");

		LevelSelection g = new LevelSelection();
		Menu h = new Menu();
		SaveMenu i = new SaveMenu(a);
		SplashScreen j = new SplashScreen();
		YouWin k = new YouWin();

		f.openLevel("Release Level", 2);
		f.openLevel("Lightning Level", 2);
		f.openLevel("Puzzle Level", 2);

		for (int index = 1; index<6; index++){
			levels.initializePuzzleLevels(index);
			levels.initializeLightningLevels(index);
			levels.initializeReleaseLevels(index);
		}		
		
		/*Level Getters and Setters*/
		level.setname("TEST");
		String name = level.getName();
		int timer = level.getTimer();
		int moves = level.getMoves();
		level.setPen(((BullPen)bullpen));
		level.setBoard(board);
		String toString = level.toString();
		level.setLvlID(1);
		int qws = level.getLvlID();
		boolean dq = level.isLocked();
		level.setLocked(true);
		int q = level.getStarsAcheived();
		level.setStarsAcheived(2);
		level.levelComplete();
		Board newBoard = level.setBoardDimensions(12, 12);

//		newBoard.liftHex(newBoard.getBoardArray()[1][1], allhex.getHex(1));
//		newBoard.addHex(newBoard.getBoardArray()[1][2], 9999, allhex.getHex(1));
		
		board.selectedPiece = allhex.getHex(1);
		board.lifted = true;
//		board.getBoardArray()[5][5].toggleTile();
//		board.drawHex(board.getBoardArray()[5][5], 5, 5, Color.ORANGE);
		Board board2 = new Board();
		board2.makeBoard(new ReleaseTile[12][12], 12, 12, 1);
//		board2.getBoardArray()[5][5].setBackground(Color.green);
//		board2.getGreenTiles();
//		board2.winAnimation();
		
//		inv.liftHex(inv.returnBoard()[2][2], allhex.getHex(2));
		
//		board.addHex(board.getBoardArray()[5][5],9999, allhex.getHex(1));


	}

}
