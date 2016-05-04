package views;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.Color;

import entity.AllHex;
import entity.AllLevels;
import entity.Board;
import entity.BoardPen;
import entity.BullPen;
import entity.PuzzleTile;
import entity.Tile;
import gameControllers.FlipController;
import gameControllers.MListener;
import gameControllers.RotateController;

import javax.swing.JToolBar;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

import javax.swing.ScrollPaneConstants;


public class Level{

	private static JFrame frame;
	private JTable table;
	public static String gameType;
	public static JPanel PanelArray[][] = new JPanel[3][6];
	public static int PanelsCovered[] = {0,0,0};
	static int levelID;
	static int timeVar = 25;
	static JLabel label;
	public static AllHex allhex = new AllHex();
	public static  String starPArray[] = new String[6];
	public static String starLArray[] = new String[6];
	public static String starRArray[] = new String[6];
	static JLabel stars, stars2;
	static JLabel starLabel;
	private int rowA,rowB,rowC = 0;
	private boolean aFlag,bFlag, cFlag = false;
	public static int levelTime;
	static entity.Level level;
	static int rows,cols;
	static Board board;
	static int penX,penY,boardX, boardY;
	JToolBar toolBar;
	JButton RotateCW_btn,RotateCCW_btn ,VertFlip_btn,HorFlip_btn, btnNewButton_1,btnR ,btnNewButton,btnR_1;

	

	/**
	 * Launch the application.
	 * @param lblNewLabel 
	 */
	public static void openLevel(String type, int  num) {
		gameType = type;

		levelTime= level.getTimer()*timeVar;
		levelID = num;
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Level window = new Level(Level.level);
					window.frame.setLocationRelativeTo(null);
					window.frame.setVisible(true);
					window.frame.setResizable(false);
					frame.addKeyListener(new KeyListener() {
					    public void keyPressed(KeyEvent e) { 
					    	int key = e.getKeyCode();
					    	if(key == KeyEvent.VK_F1) {
					    		HelpScreen nw = new HelpScreen(); 
						    	nw.newwindow(); 
					    		}
					    	}

					    public void keyReleased(KeyEvent e) { System.out.println("whatever"); }

					    public void keyTyped(KeyEvent e) { System.out.println("lol"); }
					});
					frame.requestFocus();
				} catch (Exception e) {
					e.printStackTrace();
				}
			
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Level(int level ,String type) {
		if(type=="Puzzle Level") {
			AllLevels allLevels = new AllLevels();
			allLevels.initializePuzzleLevels(level);
			Level.level = allLevels.getPuzzleLevel(level);
		}
		if(type=="Lightning Level") {
			AllLevels allLevels = new AllLevels();
			allLevels.initializeLightningLevels(level);
			Level.level = allLevels.getLightningLevel(level);
		}
		initialize();
		try {
			gameControllers.LevelTimer.main(this);
		} catch (Exception e) {
			
		}
	}

	public Level(entity.Level level2) {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Initialize the contents of the frame.
	 */	
	private void initialize() {
		
		Level.board = Level.level.getBoard();
		
		Level.rows = Level.board.getRows();
		Level.cols = Level.board.getCols();
		

		
		int crossHeight = 348;
		frame = new JFrame();
		Color myColor = Color.decode("#4169aa");
		frame.getContentPane().setBackground(myColor);
		frame.setBounds(100, 100, 760, 600);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		 toolBar = new JToolBar();
		toolBar.setEnabled(false);
		toolBar.setFloatable(false);
		Color myToolbarColor = Color.decode("#4b89d0");
		toolBar.setBackground(myToolbarColor);	
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LevelSelection nw = new LevelSelection();
				resetLevel();
				frame.dispose();
				nw.openWindow();
			}
		});

		JScrollPane scrollPane = new JScrollPane();
		//scrollPane.setPreferredSize(new Dimension(99, 400));	

	    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	    
	    
		JLabel lblF1 = new JLabel("Press F1 for Help");
		lblF1.setHorizontalAlignment(SwingConstants.LEFT);
		lblF1.setFont(new Font("Lucida Grande", Font.ITALIC, 13));
		
		
		BoardPen boardPen = new BoardPen();
		BoardPen boardPen2 = new BoardPen();
		
		
		JButton rotateButton = new JButton("\u21BB");
		rotateButton.setPreferredSize(new Dimension(50, 20));
		
		JButton flipButton = new JButton("\u21C4");
		flipButton.setPreferredSize(new Dimension(50, 20));	
		
		JLabel lblBoard = new JLabel("Board");
		JPanel releasePanel = new JPanel();
		releasePanel.setLayout(new GridLayout(3,6));
		//		JPanel PanelArray[][] = new JPanel[3][6];
		Border releaseBorder = BorderFactory.createLineBorder(Color.BLACK, 1);

		for(int j = 0; j<=2; j++){
			for (int i = 0; i<=5; i++){
				JPanel setPanel = new JPanel();
				setPanel.setBorder(releaseBorder);
				JLabel tileText = new JLabel("");
				tileText.setText(Integer.toString(i+1));
				tileText.setVerticalAlignment(SwingConstants.CENTER);
				tileText.setHorizontalAlignment(SwingConstants.CENTER);
				tileText.setFont(new Font("Lucida Grande", Font.BOLD, 10));
				setPanel.add(tileText);
				PanelArray[j][i] = setPanel;
				releasePanel.add(setPanel);
			}
		}
		if (gameType == "Release Level"){
			releasePanel.setVisible(true);	
		}else releasePanel.setVisible(false);
		
		JScrollPane bullpen_scrollPane = new JScrollPane();
		bullpen_scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		bullpen_scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.TRAILING)
				.addComponent(toolBar, GroupLayout.DEFAULT_SIZE, 1014, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
						.addGap(26)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(releasePanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addGroup(groupLayout.createSequentialGroup()
												.addGap(30)
												.addComponent(lblF1))
										.addComponent(board, GroupLayout.PREFERRED_SIZE, 348, Short.MAX_VALUE)
										.addComponent(lblBoard)))
					.addComponent(boardPen, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(bullpen_scrollPane, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnExit))
					.addGap(506))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
					.addGap(22)
					.addComponent(lblBoard)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(boardPen, GroupLayout.DEFAULT_SIZE, 348, GroupLayout.DEFAULT_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(board, GroupLayout.PREFERRED_SIZE, 348, GroupLayout.PREFERRED_SIZE)
								.addComponent(bullpen_scrollPane, GroupLayout.PREFERRED_SIZE, 346, GroupLayout.PREFERRED_SIZE))
							.addGap(33)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnExit)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(releasePanel, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblF1)))))
					.addGap(34))
		);
		
		BullPen pen = Level.level.getPen();
		bullpen_scrollPane.setViewportView(pen);
		
		boardPen.setBackground(Color.decode("#4169aa"));
		boardPen2.setBackground(Color.decode("#4169aa"));
		//boardPen.setBackground(Color.WHITE);
		
		
		JLabel lblNewLabel = new JLabel("Level:   ");
		toolBar.add(lblNewLabel);
		
		JLabel lblLvlNum = new JLabel("     ");
		lblLvlNum.setText(String.valueOf(levelID));
		toolBar.add(lblLvlNum);
		
		//stars is \u2605
		stars = new JLabel("    ");
		stars2 = new JLabel("");
		toolBar.add(stars2);		

		stars.setForeground(Color.YELLOW);
		stars.setSize(stars.getPreferredSize());
		stars.setLocation(50, 20);
		toolBar.add(stars);		
		
		
		JLabel lblNewLabel_3 = new JLabel("                                   ");
		toolBar.add(lblNewLabel_3);
		
		JLabel movesLbl = new JLabel(" ");
		movesLbl.setFont(new Font("Lucida Grande", Font.ITALIC, 13));
		toolBar.add(movesLbl);


		if (gameType == "Lightning Level"){
			movesLbl.setText("Timer:");
		}
		else{
			movesLbl.setText("Moves: ");
		}
		
		label = new JLabel(" ");
		toolBar.add(label);
		if (gameType == "Lightning Level"){
			label.setText(levelTime/2+"");
		}
		else{
			label.setText(level.getBoard().getMoves()+"");
		}
		
		JLabel label_1 = new JLabel("                                                                       ");
		toolBar.add(label_1);
		
		JLabel lblLevel = new JLabel("");
		lblLevel.setText(gameType);
		
		lblLevel.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		toolBar.add(lblLevel);
		
		
		
		frame.getContentPane().setLayout(groupLayout);

		
		/**
		 * 
		 *  BOARD INIT
		 * 	@param x ROWS
		 *  @param y COLUMNS
		 *  
		 */
		
		
		//board.setLayout(new GridLayout(6,6));

		board.setLayout(new GridLayout(Level.rows,Level.cols));
		board.setPreferredSize(new Dimension(Level.rows * 32,Level.cols*32));
		board.setMinimumSize(new Dimension(Level.rows * 32,Level.cols*32));
		board.setMaximumSize(new Dimension(Level.rows * 32,Level.cols*32));
		
		
		/**
		 *  boardArray[][] holds all the tiles
		 *  of the board being created
		 * 
		 */
		
		//Tile boardArray[][] = new Tile[x][y];
		
		Border BoardTileBorder = BorderFactory.createLineBorder(Color.BLACK, 1);
		
		System.out.println(Level.board.toString());
		Tile t;
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < cols; j++){
				Tile [][] array = Level.board.getBoardArray();
				t = array[i][j];
				System.out.println("tile"+ t.getRow() + " " +t.getColumn() );
				t.setBackground(Color.WHITE);
				// set border around tile (black border)
				t.setBorder(BoardTileBorder);
				Level.board.add(t);
			}
		}
		
	

	

		/**
		 * 
		 *  BULLPEN INIT
		 * 	@param x ROWS
		 *  @param y COLUMNS
		 *  
		 */
		int x = 14;
		int y = 35;
		
		
		
		
		
		/**
		 *  penArray[][] holds all the tiles
		 *  of the board being created
		 * 
		 */

		pen.setPreferredSize(new Dimension(350, 140));
		pen.setMaximumSize(new Dimension(350,140));
		pen.setMinimumSize(new Dimension(350,140));
		pen.setLayout(new GridLayout(14, 35));

		Border penTileBorder = BorderFactory.createLineBorder(Color.WHITE, 1);
		
		/** 
		 *  go through every single tile at every row and column
		 * 
		 */
		for(int TileRow = 0; TileRow < 14;TileRow++){
			for(int TileCol = 0; TileCol < 35;TileCol++){
				Tile AddedTile = pen.getBoardArray()[TileRow][TileCol] ;
				pen.add(AddedTile);
			}
		}
		
		
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(100,50));
		panel.setMaximumSize(new Dimension(100,50));
		panel.setMinimumSize(new Dimension(100,50));

		bullpen_scrollPane.setColumnHeaderView(panel);
		panel.setLayout(new GridLayout(2, 2, 0, 0));
		
		 RotateCW_btn = new JButton("\u21BB");
		panel.add(RotateCW_btn);
		
		 RotateCCW_btn = new JButton("\u21BA");
		panel.add(RotateCCW_btn);
		
		 HorFlip_btn = new JButton("\u21C4");
		panel.add(HorFlip_btn);
		
		 VertFlip_btn = new JButton("\u21C5");
		panel.add(VertFlip_btn);
		
		
		/**
		 * 
		 *  BOARD INIT
		 * 	@param x ROWS
		 *  @param y COLUMNS
		 *  
		 */
		
		x=5;
		y=12;
		
		boardPen.setPreferredSize(new Dimension(26, crossHeight));
		boardPen.setMinimumSize(new Dimension(26, crossHeight));
		boardPen.setMaximumSize(new Dimension(26, crossHeight));
		boardPen.setLayout(new GridLayout(y, x));
		
		
		/**
		 *  boardPenArray[][] holds all the tiles
		 *  of the board being created
		 * 
		 */
		Tile boardPenArray[][] = new Tile[x][y];
		
		Border boardPenTileBorder = BorderFactory.createLineBorder(Color.decode("#4169aa"), 1);

		
		for(int TileRow = 0; TileRow <y;TileRow++){
			for(int TileCol = 0; TileCol <x;TileCol++){

				// create a new tile
				PuzzleTile AddedTile = new PuzzleTile(boardPen, TileCol,TileRow, 9999);

				// the new tile will be empty (Color is background color)
				AddedTile.setBackground(Color.decode("#4169aa"));

				// set border around tile (background color)
				AddedTile.setBorder(boardPenTileBorder);

				// add tile to boardArray
				boardPenArray[TileCol][TileRow] = AddedTile;
				boardPen.add(AddedTile);
			}
		}

		// make the board with the given boardArray
		boardPen.makeBoard(boardPenArray, x, y,3);
		
	


	}
	
	public void rotateFlip(Tile tiles){
		Tile datboi=tiles;
		
		//datboi is current selected tile
			RotateCW_btn.addActionListener(new RotateController(MListener.datboi, 1));
			RotateCCW_btn.addActionListener(new RotateController( MListener.datboi, 2));
			VertFlip_btn.addActionListener(new FlipController(MListener.datboi, 1));	
			HorFlip_btn.addActionListener(new FlipController(MListener.datboi, 2));	
	}
	
	/**
	 *  Updates UI elements such as moves left and timer
	 * 
	 */
	
	private void resetLevel() {
		//BoardBoss.moves=8;
	}
	public void setLabel() {
		if (gameType == "Lightning Level") {
			label.setText(levelTime/timeVar+"");
			if(levelTime==0) {
				GameOver hs = new GameOver();
				hs.newwindow();
			}
		}
		
		if (gameType == "Puzzle Level" || gameType == "Release Level") {
			
			if(Level.board.getMoves()>=0)
				label.setText(Level.board.getMoves()+"");
			if(Level.board.getMoves()==0) {
				GameOver hs = new GameOver();
				hs.newwindow();
				Level.board.setMoves(Level.board.getMoves() -1);
			}
			if(Level.board.getMoves()==-1) {
				label.setText(0+"");
			}
		}

		/* STARS */
		if (gameType == "Puzzle Level" || gameType == "Lightning Level") {
			int covered=0;
			int all=rows * cols;

			//Y is the width of the array? **might break if change board size
			for(int i = 0; i <rows; i++){
				for(Tile t : Level.board.getBoardArray()[i]){
					if(t.isCovered()==true || t.checkMark() == true) {
						covered++;
					}
				}
			}
			
			//1 star if 12 tiles uncovered (2 pieces)
			if(covered==all-12){
				
				stars.setText("    \u2605");					

				if (gameType == "Puzzle Level"){
					starPArray[levelID]="    \u2605";					//put current score in star array to be read by level selection screen
					if(starPArray[levelID+1] == null && levelID !=5 ){
						starPArray[levelID+1]="   ";	
					}
				}
				else if (gameType == "Lightning Level"){
					starLArray[levelID]="    \u2605";
					if(starLArray[levelID+1] == null && levelID !=5){
						starLArray[levelID+1]="   ";	
					}
				}
				else{
					starRArray[levelID]="    \u2605";
					if(starRArray[levelID+1] == null && levelID !=5){
						starRArray[levelID+1]="   ";	
					}
				}
			}
			
			//2 stars if 6 tiles uncovered (1 pieces)
			else if(covered==all-6){
				stars.setText("    \u2605\u2605");
				if (gameType == "Puzzle Level"){
					starPArray[levelID]="    \u2605\u2605";
				}
				else if (gameType == "Lightning Level"){
					starLArray[levelID]="    \u2605\u2605";
				}
				else{
					starRArray[levelID]="    \u2605\u2605";
				}
			}
			
			//3 stars if all tiles covered
			else if(covered==all){
				stars.setText("    \u2605\u2605\u2605");
				if (gameType == "Puzzle Level"){
					starPArray[levelID]="    \u2605\u2605\u2605";
				}
				else if (gameType == "Lightning Level"){
					starLArray[levelID]="    \u2605\u2605\u2605";
				}
				else{
					starRArray[levelID]="    \u2605\u2605\u2605";
				}
			}

		}
	 else if(gameType == "Release Level"){
		int checkRowA = 0;
		int checkRowB = 0;
		int checkRowC = 0;

		for(int colNum = 0; colNum <6; colNum++){
			if(PanelArray[0][colNum].getBackground() == Color.GREEN){checkRowA++;}
			if(PanelArray[1][colNum].getBackground() == Color.ORANGE){checkRowB++;}
			if(PanelArray[2][colNum].getBackground() == Color.PINK){checkRowC++;}
		}
		if(checkRowA > rowA)rowA = checkRowA;
		if(checkRowB > rowB)rowB = checkRowB;
		if(checkRowC > rowC)rowC = checkRowC;
		//System.out.println(stars.getText());

		if(rowA == 6 || rowB == 6 || rowC == 6){
			stars.setText("    \u2605");				
			starRArray[levelID]="    \u2605";
			if(rowA+rowB == 12||rowA+rowC == 12 ||rowC+rowB == 12){
				stars.setText("    \u2605\u2605");
				starRArray[levelID]="    \u2605\u2605";
				if (rowA+rowB+rowC == 18){
					stars.setText("    \u2605\u2605\u2605");
					starRArray[levelID]="    \u2605\u2605\u2605";
				}
			}
		}else if(starRArray[levelID+1] == null)
			starRArray[levelID+1]="   ";	
		
	}

	}

}
