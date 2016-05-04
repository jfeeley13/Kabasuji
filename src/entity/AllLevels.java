package entity;

import java.awt.Color;
import java.util.ArrayList;

public class AllLevels {
	Level[] puzzle = new Level[60];
	Level[] lightning = new Level[60];
	Level[] release = new Level[60];
	Level[] custom = new Level[60];

	int xy=0;
	public void initializePuzzleOne(){

	
		Level l = new Level(1);
		AllHex allHex =new AllHex();
		ArrayList <Hexomino> hexList = allHex.getHexominos(0,0,0,0,0,0);
		l.setSolutionPieces(hexList);
		l.initializeBoard("Puzzle Level", 6, 6);
		l.setMoves(20);
		l.initializeBullPen();
			
		puzzle[1] = l;		
	}
	
	public void initializePuzzleTwo(){

		Level l = new Level(2);
		AllHex allHex =new AllHex();
		ArrayList <Hexomino> hexList = allHex.getHexominos(11,11,11,11,11,11);
		l.setSolutionPieces(hexList);
		l.initializeBoard("Puzzle Level", 6, 6);
		l.setMoves(20);
		l.initializeBullPen();
			
		puzzle[2] = l;		
	}
	public void initializePuzzleThree(){

		
		Level l = new Level(3);
		AllHex allHex =new AllHex();
		ArrayList <Hexomino> hexList = allHex.getHexominos(11,11,0,0,0,0);
		l.setSolutionPieces(hexList);
		l.initializeBoard("Puzzle Level", 6, 6);
		l.setMoves(20);
		l.initializeBullPen();
			
		puzzle[3] = l;		
	}
	public void initializePuzzleFour(){

		
		Level l = new Level(4);
		AllHex allHex =new AllHex();
		ArrayList <Hexomino> hexList = allHex.getHexominos(0,0,0,0,11,11);
		l.setSolutionPieces(hexList);
		l.initializeBoard("Puzzle Level", 6, 6);
		l.setMoves(30);
		l.initializeBullPen();
			
		puzzle[4] = l;		
	}
	public void initializePuzzleFive(){

		
		Level l = new Level(5);
		AllHex allHex =new AllHex();
		ArrayList <Hexomino> hexList = allHex.getHexominos(0,11,11,0,0, 6, 11, 3, 1, 11, 3,17, 11, 11, 23, 45, 21, 11, 14, 26, 11, 0, 1, 2, 3, 4, 12, 31, 34, 18);
		l.setSolutionPieces(hexList);
		l.initializeBoard("Puzzle Level", 10, 10);
		l.setMoves(120);
		l.initializeBullPen();
			
		puzzle[5] = l;		
	}
	
	public void initializeLightningOne() {
		Level l = new Level(1);
		AllHex allHex =new AllHex();
		ArrayList <Hexomino> hexList = allHex.getHexominos(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
		l.setSolutionPieces(hexList);
		l.initializeBoard("Lightning Level", 6, 6);
		l.setTimer(30);
		l.initializeBullPen();
		
		lightning[1] = l;
	}
	
	public void initializeLightningTwo() {
		Level l = new Level(2);
		AllHex allHex =new AllHex();
		ArrayList <Hexomino> hexList = allHex.getHexominos(1,0,2,5,4,6,0,8,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
		l.setSolutionPieces(hexList);
		l.initializeBoard("Lightning Level", 6, 6);
		l.setTimer(30);
		l.initializeBullPen();
		
		lightning[2] = l;
	}
	
	public void initializeLightningThree() {
		Level l = new Level(3);
		AllHex allHex =new AllHex();
		ArrayList <Hexomino> hexList = allHex.getHexominos(33,12,20,12,3,5,18,21,13,3,8,20,21,16,12,0,0,0,0,0,0,0,0,0,0,0,0);
		l.setSolutionPieces(hexList);
		l.initializeBoard("Lightning Level", 6, 6);
		l.setTimer(20);
		l.initializeBullPen();
		
		lightning[3] = l;
	}
	
	public void initializeLightningFour() {
		Level l = new Level(4);
		AllHex allHex =new AllHex();
		ArrayList <Hexomino> hexList = allHex.getHexominos(5,8,6,3,0,33,32,18,22,13,12,10,2,0,5,0,0,0,0,0,0,0,0,0,0,0,0);
		l.setSolutionPieces(hexList);
		l.initializeBoard("Lightning Level", 8, 8);
		l.setTimer(30);
		l.initializeBullPen();
		
		lightning[4] = l;
	}
	
	public void initializeLightningFive() {
		Level l = new Level(5);
		AllHex allHex =new AllHex();
		ArrayList <Hexomino> hexList = allHex.getHexominos(6,3,0,33,32,18,22,13,12,6,3,0,33,32,18,22,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
		l.setSolutionPieces(hexList);
		l.initializeBoard("Lightning Level", 12, 12);
		l.setTimer(60);
		l.initializeBullPen();
		
		lightning[5] = l;
	}

	
	public void initializePuzzleLevels(int i) {
		if(i==1) initializePuzzleOne();
		if(i==2) initializePuzzleTwo();
		if(i==3) initializePuzzleThree();
		if(i==4) initializePuzzleFour();
		if(i==5) initializePuzzleFive();
		
	}
	

	public void initializeLightningLevels(int i){
		if(i==1) initializeLightningOne();
		if(i==2) initializeLightningTwo();
		if(i==3) initializeLightningThree();
		if(i==4) initializeLightningFour();
		if(i==5) initializeLightningFive();
	}
	public void initializeReleaseOne() {
		Level l = new Level(1);
		AllHex allHex =new AllHex();
		ArrayList <Hexomino> hexList = allHex.getHexominos(0,0,0,0,0,0,0,0,0,0);
		l.setSolutionPieces(hexList);
		l.initializeBoard("Release Level", 6, 6);
		l.board.boardArray[2][3].addSetNum(1, Color.RED);
		l.setMoves(20);
		l.initializeBullPen();
		
		release[1] = l;
	}
	
	public void initializeReleaseTwo() {
		Level l = new Level(2);
		AllHex allHex =new AllHex();
		ArrayList <Hexomino> hexList = allHex.getHexominos(0,0,0,0,0,0);
		l.setSolutionPieces(hexList);
		l.initializeBoard("Release Level", 6, 6);
		l.setMoves(20);
		l.initializeBullPen();
		
		release[2] = l;
	}
	
	public void initializeReleaseLevels(int i){
		if(i==1) initializeReleaseOne();
		if(i==2) initializeReleaseTwo();
		//if(i==3) initializeLightningThree();
		//if(i==4) initializeLightningFour();
		//if(i==5) initializeLightningFive();
			

	}
	
	public void initializeCustomLevel(int ID, String string, int moves, int timer,  int boardWidth, int boardHeight, Board board){

		Level l = new Level(ID);
		AllHex allHex =new AllHex();
		ArrayList <Hexomino> hexList = allHex.getHexominos(0,0,0,0,0,0);
		l.setSolutionPieces(hexList);
		l.initializeBoard(string, boardWidth, boardHeight);
		l.setMoves(moves);
		l.initializeBullPen();
			
		
		if(string=="Puzzle Level"){
			custom[ID] = l;	
		}
		else if(string=="Lightning Level"){
			custom[ID] = l;	
		}
		else{
			custom[ID]=l;
		}
	}
	
	public Level getPuzzleLevel(int id){
		return puzzle[id];
	}
	
	public Level getLightningLevel(int id){
		return lightning[id];
	}
	
	public Level getReleaseLevel(int id){
		return release[id];
	}
	
	public Level getCustomLevel(int id){
		return custom[id];
	}
}
