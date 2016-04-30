package views;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Container;

import javax.swing.table.DefaultTableModel;

import entity.AllHex;
import entity.Board;
import entity.BoardBoss;
import entity.BoardPen;
import entity.BullPen;
import entity.HexTile;
import entity.Hexomino;
import entity.PuzzleTile;
import entity.Tile;
import gameControllers.MListener;

import javax.swing.JToolBar;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JProgressBar;
import javax.swing.border.MatteBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.JToggleButton;
import javax.swing.JSplitPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.List;
import java.awt.event.KeyEvent;
import java.awt.Panel;

import javax.swing.JScrollBar;




public class Level{

	/**Holds all elements of the level*/
	private static JFrame LevelFrame;

	/** Table for release level to show how many tiles have been covered*/
	private JTable ReleaseTileTable;

	/** Game type- "Puzzle","Lightning", or "Release"*/ 
	private static String gameType;

	/** Level Number (1-5)*/
	private static int levelNum;

	/** Time left in the level*/
	private static int levelTime;

	/** Ensures the timer counts in seconds*/
	private static int timeVar = 25;

	/** Label for timer or moves, depending on the level type*/
	private static JLabel MorTLabel;

	/** Initializes all Hexominos*/
	public static AllHex allhex = new AllHex();

	/** Number of rows on board*/
	int rows = 6;

	/**Number of columns on board*/
	int columns = 6;

	/**Label for displaying stars*/
	JLabel stars;

	/**Array of tiles for board */ 
	Tile boardArray[][] = new Tile[columns][rows];
	
	/**Array of stars to update the level select star labels 
	 * Puzzle Array, Lightning Array, and Release Array
	 */
	static String[] starPArray = new String[6];
	static String[] starLArray= new String[6];
	static String[] starRArray= new String[6];




	/**
	 * Launch the application.
	 */
	public static void openLevel(String type, int num) {
		gameType = type;
		levelNum = num;
		levelTime=30*timeVar;

		//		getLevel(type, levelnum);

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Level window = new Level();
					window.LevelFrame.setLocationRelativeTo(null);
					window.LevelFrame.setVisible(true);
					window.LevelFrame.setResizable(false);
					LevelFrame.addKeyListener(new KeyListener() {
						public void keyPressed(KeyEvent e) { 
							int key = e.getKeyCode();
							if(key == KeyEvent.VK_F1) {
								HelpScreen nw = new HelpScreen(); 
								nw.newwindow(); 
							}
						}

						public void keyReleased(KeyEvent e) { }

						public void keyTyped(KeyEvent e) {  }
					});
					LevelFrame.requestFocus();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
	}

	/**
	 * Create the application.
	 */
	public Level() {
		initialize();
		try {
			gameControllers.LevelTimer.main(this);
		} catch (Exception e) {

		}
	}

	/**
	 * Initialize the contents of the LevelFrame.
	 */	
	private void initialize() {

		int crossHeight = 348; //TODO What is this for and why is it used for the intermittent area in bullpen?


		LevelFrame = new JFrame();
		Color myColor = Color.decode("#4169aa");
		LevelFrame.getContentPane().setBackground(myColor);
		LevelFrame.setBounds(100, 100, 760, 600);

		LevelFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/** Initialize Top toolbar for level*/
		JToolBar toolBar = new JToolBar();
		toolBar.setEnabled(false);
		toolBar.setFloatable(false);
		Color myToolbarColor = Color.decode("#4b89d0");
		toolBar.setBackground(myToolbarColor);	

		/** Initialize Exit button*/
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LevelSelection nw = new LevelSelection();
				LevelFrame.dispose();
				nw.openWindow();
			}
		});

		//		JScrollPane scrollPane = new JScrollPane();
		//		scrollPane.setPreferredSize(new Dimension(99, 400));	
		//	    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		//	    scrollPane.setViewportBorder(new LineBorder(Color.RED));
		//		scrollpane.setColumnHeaderView(table.getTableHeader());

		/** Initialize table for Release tiles */
		ReleaseTileTable = new JTable();
		ReleaseTileTable.setVisible(false);
		if (gameType == "Release Level"){
			ReleaseTileTable.setVisible(true);	
		}
		ReleaseTileTable.setForeground(Color.BLACK);
		ReleaseTileTable.setBorder(new LineBorder(new Color(0, 0, 0)));
		ReleaseTileTable.setModel(new DefaultTableModel(
				new Object[][] {
						{"1", "2", "3", "4", "5", "6"},
						{"1", "2", "3", "4", "5", "6"},
						{"1", "2", "3", "4", "5", "6"},
				},
				new String[] {
						"New column", "New column", "New column", "New column", "New column", "New column"
				}
				));
		ReleaseTileTable.setRowSelectionAllowed(false);
		ReleaseTileTable.setBackground(UIManager.getColor("List.dropLineColor"));


		/**Help text initialized*/
		JLabel lblF1 = new JLabel("Press F1 for Help");
		lblF1.setHorizontalAlignment(SwingConstants.LEFT);
		lblF1.setFont(new Font("Lucida Grande", Font.ITALIC, 13));


		/**BoardBoss Elements initialized*/
		BoardBoss boardPen = new BoardPen();
		BoardBoss boardPen2 = new BoardPen();

		BoardBoss board = new Board();
		BoardBoss pen = new BullPen();


		/**Piece Manipulation Button Initialization*/
		//TODO Need two rotate buttons and two flip buttons
		JButton rotateButton = new JButton("\u21BB");		
		JButton flipButton = new JButton("\u21C4");
		rotateButton.setPreferredSize(new Dimension(50, 20));	
		flipButton.setPreferredSize(new Dimension(50, 20));	



		/**Auto Generated Window Builder Code*/

		JLabel lblBoard = new JLabel("Board");
		GroupLayout groupLayout = new GroupLayout(LevelFrame.getContentPane());
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.TRAILING)
				.addComponent(toolBar, GroupLayout.DEFAULT_SIZE, 1056, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
						.addGap(26)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
										.addGap(17)
										.addComponent(ReleaseTileTable, GroupLayout.PREFERRED_SIZE, 315, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
												.addGap(30)
												.addComponent(lblF1))
												.addComponent(board, GroupLayout.PREFERRED_SIZE, 348, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblBoard))
												//.addGap(18)
												.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
														.addGroup(groupLayout.createSequentialGroup()
																.addComponent(boardPen, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
																//.addPreferredGap(ComponentPlacement.UNRELATED)
																//.addComponent(boardPen2, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
																//.addPreferredGap(ComponentPlacement.UNRELATED)
																.addComponent(pen, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE))
																.addComponent(btnExit))
																.addGap(360))
				);
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
						.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
										.addGap(22)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)

												.addGroup(groupLayout.createSequentialGroup()
														.addComponent(lblBoard)
														.addGap(18)
														.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
																.addComponent(boardPen, GroupLayout.DEFAULT_SIZE, crossHeight, GroupLayout.DEFAULT_SIZE)
																//.addComponent(boardPen2, GroupLayout.DEFAULT_SIZE, crossHeight, GroupLayout.DEFAULT_SIZE)
																.addComponent(pen, GroupLayout.DEFAULT_SIZE, 348, GroupLayout.DEFAULT_SIZE)
																.addGroup(groupLayout.createSequentialGroup()
																		.addComponent(board, GroupLayout.PREFERRED_SIZE, 348, GroupLayout.PREFERRED_SIZE)
																		.addGap(33)
																		.addComponent(ReleaseTileTable, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(ComponentPlacement.RELATED)
																		.addComponent(lblF1)))))
																		.addGap(34))
																		.addGroup(groupLayout.createSequentialGroup()
																				.addGap(48)

																				.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																				.addComponent(btnExit)
																				.addGap(21))))
				);

		/**Color set for area between bullPen and board*/
		boardPen.setBackground(Color.decode("#4169aa"));
		boardPen2.setBackground(Color.decode("#4169aa"));
		pen.setBackground(Color.decode("#4169aa"));
		//boardPen.setBackground(Color.WHITE);


		/**
		JSplitPane splitPane = new JSplitPane();
		splitPane.setEnabled(false);
		splitPane.setPreferredSize(new Dimension(100, 20));	
		scrollPane.setColumnHeaderView(splitPane);

		JButton rotateButton = new JButton("\u21BB");
		rotateButton.setPreferredSize(new Dimension(50, 20));	
		splitPane.setLeftComponent(rotateButton);

		JButton flipButton = new JButton("\u21C4");
		flipButton.setPreferredSize(new Dimension(50, 20));	
		flipButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		splitPane.setRightComponent(flipButton);
		splitPane.setEnabled(true);
		 **/


		/**Level number display*/
		JLabel lblNewLabel = new JLabel("Level:   " + levelNum);
		toolBar.add(lblNewLabel);

		/**Star Display*/
		//stars is \u2605
		stars = new JLabel("    ");
		stars.setForeground(Color.YELLOW);
		toolBar.add(stars);


		/**Spacer*/
		JLabel lblNewLabel_3 = new JLabel("                                   ");
		toolBar.add(lblNewLabel_3);


		/**Displays moves/time left in level*/
		JLabel movesOrTimerLbl = new JLabel(" ");
		movesOrTimerLbl.setFont(new Font("Lucida Grande", Font.ITALIC, 13));
		toolBar.add(movesOrTimerLbl);
		if (gameType == "Lightning Level"){
			movesOrTimerLbl.setText("Timer:");
		}
		else{
			movesOrTimerLbl.setText("Moves: ");
		}		
		/**Displays value of movesLeft or timeLeft*/
		MorTLabel = new JLabel(" ");
		toolBar.add(MorTLabel);
		if (gameType == "Lightning Level"){
			MorTLabel.setText(levelTime/2+"");
		}
		else{
			MorTLabel.setText(BoardBoss.getMoves()+"");
		}

		/**Another Spacer*/
		JLabel label_1 = new JLabel("                                                                       ");
		toolBar.add(label_1);

		/**Initializes game type label*/
		JLabel gameTypeLabel = new JLabel(gameType);
		gameTypeLabel.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		toolBar.add(gameTypeLabel);


		LevelFrame.getContentPane().setLayout(groupLayout);


		/**
		 * 
		 *  BOARD INIT
		 * 	@param x ROWS
		 *  @param y COLUMNS
		 *  
		 */

		int bCol = columns; //X
		int bRow = rows; // Y

		board.setLayout(new GridLayout(bRow,bCol));
		board.setPreferredSize(new Dimension(bCol*32,bRow*32));
		board.setMinimumSize(new Dimension(bCol*32,bRow*32));
		board.setMaximumSize(new Dimension(bCol*32,bRow*32));


		/**
		 *  boardArray[][] holds all the tiles
		 *  of the board being created
		 * 
		 */

		Tile boardArray[][] = new Tile[bRow][bCol];

		Border BoardTileBorder = BorderFactory.createLineBorder(Color.BLACK, 1);


		/** 
		 *  go through every single tile at every row and column
		 * 
		 */
		for(int TileRow = 0; TileRow <bRow;TileRow++){
			for(int TileCol = 0; TileCol <bCol;TileCol++){

				// create a new tile
				PuzzleTile AddedTile = new PuzzleTile(board, TileRow,TileCol, 9999);

				// the new tile will be empty (white)
				AddedTile.setBackground(Color.WHITE);

				// set border around tile (black border)
				AddedTile.setBorder(BoardTileBorder);

				// add tile to boardArray
				boardArray[TileRow][TileCol] = AddedTile;
				board.add(AddedTile);
			}
		}
		// make the board with the given boardArray
		board.makeBoard(boardArray, bRow, bCol, 1);



		/**
		 * 
		 *  BULLPEN INIT
		 * 	@param x ROWS
		 *  @param y COLUMNS
		 *  
		 */
		int x = 14;
		int y = 35;

		int bpRow = y;
		int bpCol = x;

		pen.setPreferredSize(new Dimension(bpCol*10, bpRow*10));
		pen.setMinimumSize(new Dimension(bpCol*10, bpRow*10));
		pen.setMaximumSize(new Dimension(bpCol*10, bpRow*10));

		pen.setLayout(new GridLayout(bpRow, bpCol));


		/**
		 *  penArray[][] holds all the tiles
		 *  of the board being created
		 * 
		 */
		Tile penArray[][] = new Tile[bpRow][bpCol];



		Border penTileBorder = BorderFactory.createLineBorder(Color.WHITE, 1);

		/** 
		 *  go through every single tile at every row and column
		 * 
		 */
		for(int TileRow = 0; TileRow <bpRow;TileRow++){
			for(int TileCol = 0; TileCol <bpCol;TileCol++){

				// create a new tile
				PuzzleTile AddedTile = new PuzzleTile(pen, TileRow,TileCol, 9999);

				// the new tile will be empty (white)
				AddedTile.setBackground(Color.WHITE);

				// set border around tile (white border)
				AddedTile.setBorder(penTileBorder);

				// add tile to boardArray
				penArray[TileRow][TileCol] = AddedTile;
				pen.add(AddedTile);
			}
		}

		pen.selectedPiece = null; // there is no piece being picked up yet (obviously)

		// make the board with the given boardArray
		pen.makeBoard(penArray, bpRow, bpCol, 2);

		// begin filling bullpen with pieces
		pen.init = true;

		// add two pieces
		pen.addHex(penArray[2][2], 1, allhex.getHexList().get(1));
		//	pen.addHex(penArray[4][4], 2, allhex.getHexList().get(2));
		//	BoardBoss.penPieces=2;		

		//		pen.addHex(penArray[3][2], 2, allhex.getHexList().get(1));
		//		pen.addHex(penArray[4][2], 3, allhex.getHexList().get(1));
		//		pen.addHex(penArray[5][2], 4, allhex.getHexList().get(1));
		//		pen.addHex(penArray[6][2], 5, allhex.getHexList().get(1));
		//		pen.addHex(penArray[7][2], 6, allhex.getHexList().get(1));
		//pen.addHex(penArray[4][4], 2, allhex.getHexList().get(2));

		// end filling bullpen with pieces
		pen.init=false;		


		/**
		 * 
		 *  BOARD PEN INIT
		 * 	@param x ROWS
		 *  @param y COLUMNS
		 *  
		 */
		int intPenRow=(int) (rows*1.5);
		int intPenCol=(int) (3*1.5);


		//		TODO Why is 348 the height of the board even though it is 32*6 = 192?
		boardPen.setPreferredSize(new Dimension(100, intPenRow*58));
		boardPen.setMinimumSize(new Dimension(100, intPenRow*32));
		boardPen.setMaximumSize(new Dimension(100, crossHeight));
		boardPen.setLayout(new GridLayout(intPenRow, intPenCol));


		/**
		 *  boardPenArray[][] holds all the tiles
		 *  of the board being created
		 * 
		 */
		Tile boardPenArray[][] = new Tile[intPenRow][intPenCol];

		Border boardPenTileBorder = BorderFactory.createLineBorder(Color.decode("#4169aa"), 1);
		Border blackBorder = BorderFactory.createLineBorder(Color.black, 1);


		for(int TileRow = 0; TileRow <intPenRow;TileRow++){
			for(int TileCol = 0; TileCol <intPenCol;TileCol++){

				// create a new tile
				PuzzleTile AddedTile = new PuzzleTile(boardPen, TileRow,TileCol, 9999);

				// the new tile will be empty (Color is background color)
				AddedTile.setBackground(Color.decode("#4169aa"));

				// set border around tile (background color)
				AddedTile.setBorder(boardPenTileBorder);

				// add tile to boardArray
				boardPenArray[TileRow][TileCol] = AddedTile;
				boardPen.add(AddedTile);
			}
		}

		// make the board with the given boardArray
		boardPen.makeBoard(boardPenArray, intPenRow, intPenCol,3);


	}

	/**
	 *  Updates UI elements such as moves left and timer
	 * 
	 */
	public void setLabel() {
		if (gameType == "Lightning Level") {
			MorTLabel.setText(levelTime/timeVar+"");
			if(levelTime==0) {
				GameOver hs = new GameOver();
				hs.newwindow();
			}
		}else if (gameType == "Puzzle Level" || gameType == "Release Level") {

			if(BoardBoss.getMoves()>=0)
				MorTLabel.setText(BoardBoss.getMoves()+"");
			if(BoardBoss.getMoves()==0) {
				GameOver hs = new GameOver();
				hs.newwindow();
				BoardBoss.setMoves(-1);
			}
			if(BoardBoss.getMoves()==-1) {
				MorTLabel.setText(0+"");
			}
		}


		/* STARS */
		if (gameType == "Puzzle Level" || gameType == "Lightning Level") {
			int covered=0;
			int all=rows * columns;

			//Y is the width of the array? **might break if change board size
			/*
			for(int i = 0; i < columns; i++){
				for(Tile t : boardArray[i]){
					if(t.isCovered()==true) {
						covered++;
					}
					
				}
			}
		
			for(int j=0; j<rows; j++) 
				for(int k=0; k<columns; k++) 
					if(boardArray[j][k].isCovered()==true) {
						covered++;
					}
	*/
			//1 star if 12 tiles uncovered (2 pieces)
			if(covered==all-12){
				//System.out.println( "COVERED is 12");

				stars.setText("    \u2605");				
				if (gameType == "Puzzle Level"){
					starPArray[levelNum]="    \u2605";					//put current score in star array to be read by level selection screen
					if(starPArray[levelNum+1] == null){
						starPArray[levelNum]="   ";	
					}
				}
				else if (gameType == "Lightning Level"){
					starLArray[levelNum]="    \u2605";
					if(starLArray[levelNum+1] == null){
						starLArray[levelNum+1]="   ";	
					}
				}
				else{
					starRArray[levelNum]="    \u2605";
					if(starRArray[levelNum+1] == null){
						starRArray[levelNum+1]="   ";	
					}
				}
			}

			//2 stars if 6 tiles uncovered (1 pieces)
			else if(covered==all-6){
				//System.out.println( "COVERED is 6");
				stars.setText("    \u2605\u2605");
				if (gameType == "Puzzle Level"){
					starPArray[levelNum]="    \u2605\u2605";
				}
				else if (gameType == "Lightning Level"){
					starLArray[levelNum]="    \u2605\u2605";
				}
				else{
					starRArray[levelNum]="    \u2605\u2605";
				}
			}

			//3 stars if all tiles covered
			else if(covered==all){
				//System.out.println( "COVERED is ALL");

				stars.setText("    \u2605\u2605\u2605");
				if (gameType == "Puzzle Level"){
					starPArray[levelNum]="    \u2605\u2605\u2605";
				}
				else if (gameType == "Lightning Level"){
					starLArray[levelNum]="    \u2605\u2605\u2605";
				}
				else{
					starRArray[levelNum]="    \u2605\u2605\u2605";
				}
			}
			for(int i=1;i<6;i++){
				//System.out.println( i + "  " + Level.starPArray[i]);
			}
		}
	}
	
	public Hexomino getHex(int ID){
		return this.allhex.getHexList().get(ID);
	}
	
	public String getGameType(){
		return gameType;
	}
	
	public int getLvlTime(){
		return levelTime;
	}
	
	public void setLvlTime(int time){
		levelTime = time;
	}


}
