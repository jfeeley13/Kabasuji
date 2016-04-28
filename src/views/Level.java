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
import java.awt.event.KeyEvent;
import java.awt.Panel;
import javax.swing.JScrollBar;


public class Level{

	private static JFrame frame;
	private JTable table_c;
	private JTable table;
	public static String gameType;
	static int level;
	public static int levelTime=30;
	static int timeVar = 25;
	static JLabel label;
	public static AllHex allhex = new AllHex();


	

	/**
	 * Launch the application.
	 */
	public static void openLevel(String type, int levelnum) {
		gameType = type;
		level = levelnum;
		levelTime=30*timeVar;

		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Level window = new Level();
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
	public Level() {
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
				frame.dispose();
				nw.openWindow();
			}
		});

		JScrollPane scrollPane = new JScrollPane();
		//scrollPane.setPreferredSize(new Dimension(99, 400));	

	    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	    
	   // scrollPane.setViewportBorder(new LineBorder(Color.RED));
        //scrollpane.setColumnHeaderView(table.getTableHeader());

		
		table_c = new JTable();
		table_c.setVisible(false);
		if (gameType == "Release Level"){
			table_c.setVisible(true);	
		}
		
		table_c.setForeground(Color.BLACK);
		table_c.setBorder(new LineBorder(new Color(0, 0, 0)));
		table_c.setModel(new DefaultTableModel(
			new Object[][] {
				{"1", "2", "3", "4", "5", "6"},
				{"1", "2", "3", "4", "5", "6"},
				{"1", "2", "3", "4", "5", "6"},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		table_c.setRowSelectionAllowed(false);
		table_c.setBackground(UIManager.getColor("List.dropLineColor"));
		
		JLabel lblF1 = new JLabel("Press F1 for Help");
		lblF1.setHorizontalAlignment(SwingConstants.LEFT);
		lblF1.setFont(new Font("Lucida Grande", Font.ITALIC, 13));
		
		
		BoardBoss boardPen = new BoardPen();
		BoardBoss boardPen2 = new BoardPen();
		

		BoardBoss board = new Board();
		BoardBoss pen = new BullPen();
		
		JButton rotateButton = new JButton("\u21BB");
		rotateButton.setPreferredSize(new Dimension(50, 20));	


		
		JButton flipButton = new JButton("\u21C4");
		flipButton.setPreferredSize(new Dimension(50, 20));	
		
		
		
		
		
		JLabel lblBoard = new JLabel("Board");
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addComponent(toolBar, GroupLayout.DEFAULT_SIZE, 1056, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(17)
							.addComponent(table_c, GroupLayout.PREFERRED_SIZE, 315, GroupLayout.PREFERRED_SIZE))
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
											.addComponent(table_c, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(lblF1)))))
							.addGap(34))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(48)
							
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnExit)
							.addGap(21))))
		);
		
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
		
	
		
		JLabel lblNewLabel = new JLabel("Level:   ");
		toolBar.add(lblNewLabel);
		
		JLabel lblLvlNum = new JLabel("     ");
		lblLvlNum.setText(String.valueOf(level));
		toolBar.add(lblLvlNum);
		
		JLabel stars = new JLabel("    \u2605\u2605\u2605");
		stars.setForeground(Color.LIGHT_GRAY);
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
			label.setText(BoardBoss.moves+"");
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
		
		int x = 6;
		int y = 6;

		board.setLayout(new GridLayout(y,x));
		board.setPreferredSize(new Dimension(384,384));
		board.setMinimumSize(new Dimension(384,384));
		board.setMaximumSize(new Dimension(384,384));
		
		
		/**
		 *  boardArray[][] holds all the tiles
		 *  of the board being created
		 * 
		 */
		
		Tile boardArray[][] = new Tile[x][y];
		
		Border BoardTileBorder = BorderFactory.createLineBorder(Color.BLACK, 1);
		
		
		/** 
		 *  go through every single tile at every row and column
		 * 
		 */
		for(int TileCol = 0; TileCol <y;TileCol++){
			for(int TileRow = 0; TileRow <x;TileRow++){

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
		board.makeBoard(boardArray, x, y, 1);


		/**
		 * 
		 *  BULLPEN INIT
		 * 	@param x ROWS
		 *  @param y COLUMNS
		 *  
		 */
		x = 14;
		y = 35;
		
		pen.setPreferredSize(new Dimension(140, 348));
		pen.setMinimumSize(new Dimension(140, 348));
		pen.setMaximumSize(new Dimension(140, 348));
		
		pen.setLayout(new GridLayout(y, x));
		
		
		/**
		 *  penArray[][] holds all the tiles
		 *  of the board being created
		 * 
		 */
		Tile penArray[][] = new Tile[x][y];


		
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
		
		pen.selectedPiece = null; // there is no piece being picked up yet (obviously)
		
		// make the board with the given boardArray
		pen.makeBoard(penArray, x, y, 2);
		
		// begin filling bullpen with pieces
		pen.init = true;
		
		// add two pieces
		pen.addHex(penArray[2][2], 1, allhex.getHexList().get(1));
		pen.addHex(penArray[4][4], 2, allhex.getHexList().get(2));
		BoardBoss.penPieces=2;		
		// end filling bullpen with pieces
		pen.init=false;
		
		
		
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
	public void setLabel() {
		if (gameType == "Lightning Level") {
			label.setText(levelTime/timeVar+"");
			if(levelTime==0) {
				GameOver hs = new GameOver();
				hs.newwindow();
			}
		}
		
		if (gameType == "Puzzle Level" || gameType == "Release Level") {
			
			if(BoardBoss.moves>=0)
				label.setText(BoardBoss.moves+"");
			if(BoardBoss.moves==0) {
				GameOver hs = new GameOver();
				hs.newwindow();
				BoardBoss.moves=-1;
			}
			if(BoardBoss.moves==-1) {
				label.setText(0+"");
			}
		}
	}
}
