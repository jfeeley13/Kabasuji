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
import entity.LightningTile;
import entity.PuzzleTile;
import entity.ReleaseTile;
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
import java.awt.event.KeyEvent;
import java.awt.Panel;
import java.util.ArrayList;

import javax.swing.JScrollBar;
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
	public static String starPArray[] = new String[6];
	public static String starLArray[] = new String[6];
	public static String starRArray[] = new String[6];
	JLabel stars;
	static JLabel starLabel;
	private int rowA,rowB,rowC = 0;
	private boolean aFlag,bFlag, cFlag = false;
	public static int levelTime;
	static entity.Level level;
	static int rows;
	static int cols;
	static Board board;
	

	/**
	 * Launch the application.
	 * @param lblNewLabel 
	 */
	public static void openLevel(String type, JLabel lbl) {
		gameType = type;

		levelTime= level.getTimer()*timeVar;
		starLabel = lbl;
		
		
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
	public Level(entity.Level level) {
		Level.level = level;
		initialize();
		try {
			gameControllers.LevelTimer.main(this);
		} catch (Exception e) {
			
		}
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
		
		JToolBar toolBar = new JToolBar();
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
		
		BoardBoss pen = new BullPen();
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
		stars = new JLabel("         ");
		stars.setForeground(Color.YELLOW);
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
		Tile penArray[][] = new Tile[x][y];

		pen.setPreferredSize(new Dimension(140, 350));
		pen.setMaximumSize(new Dimension(140,350));
		pen.setMinimumSize(new Dimension(140,350));
		pen.setLayout(new GridLayout(35, 14));

		Border penTileBorder = BorderFactory.createLineBorder(Color.WHITE, 1);
		
		/** 
		 *  go through every single tile at every row and column
		 * 
		 */
		for(int TileRow = 0; TileRow <y;TileRow++){
			for(int TileCol = 0; TileCol <x;TileCol++){
				
				// create a new tile
				PuzzleTile AddedTile = new PuzzleTile(pen, TileCol,TileRow, 9999);
				
				// the new tile will be empty (white)
				AddedTile.setBackground(Color.WHITE);

				// set border around tile (white border)
				AddedTile.setBorder(penTileBorder);
				
				// add tile to boardArray
				penArray[TileCol][TileRow] = AddedTile;
				pen.add(AddedTile);
			}
		}
		pen.makeBoard(penArray, x, y, 2);

		
		pen.selectedPiece=null;
		pen.init=(true);
		//pen.addHex(penArray[2][2], 1, allhex.getHexList().get(2));
		//pen.init=(false);
		
		// add two pieces
		int pos = BoardBoss.bullPenPosition;
		ArrayList <Hexomino> hexList = allhex.getHexominos(12,5,7,8,20);
		for (int i = 0; i<hexList.size(); i++){
			pen.addHex(penArray[pen.returnWidth()/2][i*6+1], i, hexList.get(i));
		}
		//		pen.addHex(penArray[pen.returnWidth()/2][3], 1, Level.allhex.getHexList().get(pos));
		//		pen.addHex(penArray[pen.returnWidth()/2][11], 2, Level.allhex.getHexList().get(pos+1));
		//		pen.addHex(penArray[pen.returnWidth()/2][20], 3, Level.allhex.getHexList().get(pos+2));
		// end filling bullpen with pieces
		BoardBoss.bullPenPosition+=1;
		pen.init=false;
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(100,50));
		panel.setMaximumSize(new Dimension(100,50));
		panel.setMinimumSize(new Dimension(100,50));

		bullpen_scrollPane.setColumnHeaderView(panel);
		panel.setLayout(new GridLayout(2, 2, 0, 0));
		
		JButton RotateCW_btn = new JButton("\u21BB");
		panel.add(RotateCW_btn);
		
		JButton RotateCCW_btn = new JButton("\u21BA");
		RotateCCW_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panel.add(RotateCCW_btn);
		
		JButton HorFlip_btn = new JButton("\u21C4");
		panel.add(HorFlip_btn);
		
		JButton VertFlip_btn = new JButton("\u21C5");
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
					if(starPArray[levelID+1] == null){
						starPArray[levelID+1]="   ";	
					}
				}
				else if (gameType == "Lightning Level"){
					starLArray[levelID]="    \u2605";
					if(starLArray[levelID+1] == null){
						starLArray[levelID+1]="   ";	
					}
				}
				else{
					starRArray[levelID]="    \u2605";
					if(starRArray[levelID+1] == null){
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
