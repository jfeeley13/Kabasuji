package views;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JToolBar;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JViewport;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;

import javax.swing.JScrollPane;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.UIManager;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.table.DefaultTableModel;

import entity.AllHex;
import entity.Board;
import entity.BoardBoss;
import entity.BoardPen;
import entity.BullPen;
import entity.Inventory;
import entity.LevelBuilder;
import entity.PuzzleTile;
import entity.Tile;

import java.awt.Color;

import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.SpinnerNumberModel;

import builderControllers.CreateNewLevelController;
import builderControllers.LevelBuilderController;
import builderControllers.SaveController;
import gameControllers.ExitController;
import gameControllers.FlipController;
import gameControllers.MListener;
import gameControllers.RotateController;

import javax.swing.ScrollPaneConstants;


public class Builder extends JFrame{

	private JFrame frame;
	int crossHeight = 348;
	JTextField txtGame;
	private JTextField textField;
	private JTextField textField_1;
	JButton RotateCW_btn,RotateCCW_btn ,VertFlip_btn,HorFlip_btn, btnNewButton_1,btnR ,btnNewButton,btnR_1;
	static String gameType;
	private int gameTimer = 0;
	private int moveCounter = 0;
	int row = 6;
	int col = 6;
	int boardTileWidth = 32; //Pixels
	int boardTileHeight = 32;
	AllHex allhex = new AllHex();
	private JTextField timerORMoveTextField;
	private JPanel pen2;
	Tile invArray[][] = new Tile[240][10];
	Tile penArray[][] = new Tile[20][41];



//	/**
//	 * Launch the application.
//	 */
//	public static void openBuildWindow(String type) {
//		gameType= type;
//		
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Builder window = new Builder();
//					window.frame.setLocationRelativeTo(null);
//					window.frame.setVisible(true);
//					window.frame.setResizable(false);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	/**
	 * Launch the application.
	public static void openBuildWindow(String type, int rows, int cols) {
		gameType= type;
		row = rows;
		col = cols;
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Builder window = new Builder();
					window.frame.setLocationRelativeTo(null);
					window.frame.setVisible(true);
					window.frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/

	/**
	 * Create the application.
	 */
	public Builder(String type, int rows, int cols) {
		gameType = type;
		row = rows;
		col = cols;
		this.setLocationRelativeTo(null);
		initialize();
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//frame = new JFrame();

		Color myColor = Color.decode("#4169aa");
		getContentPane().setBackground(myColor);
		
		setBounds(100, 100, 800, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JToolBar toolBar = new JToolBar();
		Color myToolbarColor = Color.decode("#4b89d0");
		toolBar.setBackground(myToolbarColor);
		toolBar.setFloatable(false);
		
		JLabel lblBoardSize = new JLabel("Board Size:");	
		lblBoardSize.setHorizontalAlignment(SwingConstants.CENTER);
		
		final JSpinner ColSpinner = new JSpinner();	//row spinner
		ColSpinner.setModel(new SpinnerNumberModel(6, 6, 12, 1));
		ColSpinner.setValue(col);
		
		JLabel lblX = new JLabel("x");
		lblX.setHorizontalAlignment(SwingConstants.LEFT);
		
		final JSpinner RowSpinner = new JSpinner();	//column spinner
		RowSpinner.setModel(new SpinnerNumberModel(6, 6, 12, 1));
		RowSpinner.setValue(row);
		
		//LevelBuilder.NewLevel(6);
		//LevelBuilder.setMoves();
		//LevelBuilder.setBoardDimensions(row, col);

		
		final JComboBox levelComboBox = new JComboBox();	//select which level to create
		levelComboBox.addItem("Puzzle Level");
		levelComboBox.addItem("Lightning Level");
		levelComboBox.addItem("Release Level");

		levelComboBox.setSelectedItem(gameType);

		JComboBox SetColorComboBox = new JComboBox();	//select create a set
		SetColorComboBox.addItem("Red");
		SetColorComboBox.addItem("Yellow");
		SetColorComboBox.addItem("Green");
		SetColorComboBox.addItem("Delete");
		if (gameType == "Release Level"){
			SetColorComboBox.setVisible(true);
		}
		else{
			SetColorComboBox.setVisible(false);
		}
		
		
		JButton btnGenerate = new JButton("Generate Set");	//generate a random set
		btnGenerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		if (gameType == "Release Level"){
			btnGenerate.setVisible(true);
		}
		else{
			btnGenerate.setVisible(false);
		}
		
		
		JButton btnUndo = new JButton("Undo");
		btnUndo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnTest = new JButton("Test");
		btnTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		
		/**BullPen Elements Initialized
		JScrollPane bullPen_scroll = new JScrollPane();
		bullPen_scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	    bullPen_scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	    */
		
		
		
		JScrollPane inventory_scrollPane = new JScrollPane();
	    inventory_scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	    inventory_scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		if (gameType == "Lightning Level"){
			inventory_scrollPane.setVisible(false);
		}
		else{
			inventory_scrollPane.setVisible(true);
		}

		
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SaveController(LevelBuilder.getLevel(), txtGame.getText()).save();	
			}
		});

		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ExitController(this));
		
		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				row = (Integer) RowSpinner.getValue();
				col = (Integer) ColSpinner.getValue();
				new LevelBuilderController(Builder.this).process(levelComboBox.getSelectedItem().toString(), row, col);	
			}
		});
		
		JLabel lblInventory = new JLabel("Inventory:");
		if (gameType == "Lightning Level"){
			lblInventory.setVisible(false);
		}
		else{
			lblInventory.setVisible(true);
		}
		
		JLabel lblBullPin = new JLabel("Bull Pen:");
		
		
		JSpinner SetNumSpinner = new JSpinner();
		SetNumSpinner.setModel(new SpinnerNumberModel(1, 1, 6, 1));
		if (gameType == "Release Level"){
			SetNumSpinner.setVisible(true);
		}
		else{
			SetNumSpinner.setVisible(false);
		}
		
		JLabel lblPressFFor = new JLabel("Press F1 for Help");
		lblPressFFor.setFont(new Font("Lucida Grande", Font.ITALIC, 13));
		
		JButton btnChangeLevel = new JButton("New Level");
		btnChangeLevel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LevelBuilderController(Builder.this).process(levelComboBox.getSelectedItem().toString(), row, col);	
			}
		});
		
		JLabel lblRightClickTo = new JLabel("Right click to add/delete tile");
		lblRightClickTo.setFont(new Font("Lucida Grande", Font.ITALIC, 13));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		//JPanel board = new JPanel();
		BoardBoss board = new Board();
		
		BoardBoss boardpen = new BoardPen();
		boardpen.setBackground(UIManager.getColor("Color2"));

		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(toolBar, GroupLayout.DEFAULT_SIZE, 782, Short.MAX_VALUE)
					.addGap(12))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(12)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblPressFFor)
							.addGap(474)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(6)
									.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnUndo, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnTest, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(6)
									.addComponent(lblBullPin))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblBoardSize)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(ColSpinner, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
									.addGap(3)
									.addComponent(lblX, GroupLayout.PREFERRED_SIZE, 8, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(RowSpinner, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblRightClickTo))
							.addGap(17)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnCreate, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(levelComboBox, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnChangeLevel, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(SetColorComboBox, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(SetNumSpinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(btnGenerate, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(inventory_scrollPane, GroupLayout.PREFERRED_SIZE, 575, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblInventory)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(board, GroupLayout.PREFERRED_SIZE, 457, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(boardpen, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)))
					.addGap(55))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(6)
					.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addComponent(lblBoardSize)
							.addComponent(ColSpinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(RowSpinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
									.addComponent(btnCreate)
									.addComponent(levelComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(btnChangeLevel)
									.addComponent(btnUndo)
									.addComponent(btnTest))))
						.addComponent(lblX))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblRightClickTo)
							.addComponent(SetColorComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnGenerate)
								.addComponent(lblBullPin))
							.addComponent(SetNumSpinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(boardpen, GroupLayout.PREFERRED_SIZE, 325, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 384, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(board, GroupLayout.PREFERRED_SIZE, 325, GroupLayout.PREFERRED_SIZE)
									.addGap(27)
									.addComponent(lblInventory)))
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblPressFFor)
										.addComponent(btnSave)
										.addComponent(btnExit))
									.addGap(34))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(inventory_scrollPane, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
									.addGap(75))))))
		);
		
		//JPanel bullpen = new JPanel();
		BoardBoss bullpen = new BullPen();
		scrollPane.setViewportView(bullpen);
		bullpen.setLayout(new GridLayout(14, 35));
		bullpen.setPreferredSize(new Dimension(140,350));
		
		
		JPanel panel_1 = new JPanel();
		scrollPane.setColumnHeaderView(panel_1);
		panel_1.setPreferredSize(new Dimension(100, 50));
		panel_1.setLayout(new GridLayout(2, 2, 0, 0));
		
		 btnNewButton_1 = new JButton("\u21BB");
		panel_1.add(btnNewButton_1);

		btnR = new JButton("\u21BA");
		panel_1.add(btnR);

		 btnNewButton = new JButton("\u21C4");
		panel_1.add(btnNewButton);

		btnR_1 = new JButton("\u21C5");
		panel_1.add(btnR_1);

		
		JPanel panel_2 = new JPanel();
		inventory_scrollPane.setRowHeaderView(panel_2);
		panel_2.setPreferredSize(new Dimension(60, 50));
		panel_2.setLayout(new GridLayout(2, 2, 0, 0));
		
		RotateCW_btn = new JButton("\u21BB");
		panel_2.add(RotateCW_btn);
		
		RotateCCW_btn = new JButton("\u21BA");
		panel_2.add(RotateCCW_btn);

		VertFlip_btn = new JButton("\u21C4");
		panel_2.add(VertFlip_btn);
		
		HorFlip_btn = new JButton("\u21C5");
		panel_2.add(HorFlip_btn);
				
		BoardBoss Inventory = new Inventory();
		inventory_scrollPane.setViewportView(Inventory);
		Inventory.setPreferredSize( new Dimension(35000,100));		
		
		GroupLayout gl_Inventory = new GroupLayout(Inventory);
		gl_Inventory.setHorizontalGroup(
			gl_Inventory.createParallelGroup(Alignment.LEADING)
				.addGap(0, 540, Short.MAX_VALUE)
		);
		gl_Inventory.setVerticalGroup(
			gl_Inventory.createParallelGroup(Alignment.LEADING)
				.addGap(0, 90, Short.MAX_VALUE)
		);
		Inventory.setLayout(gl_Inventory);


		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setPreferredSize(new Dimension(100, 20));	



		
		JLabel lblLevelName = new JLabel("Level Name:");
		toolBar.add(lblLevelName);
		
		txtGame = new JTextField();
		txtGame.setText("game1");
		toolBar.add(txtGame);
		txtGame.setColumns(10);
		
		JLabel label_1 = new JLabel("                ");
		toolBar.add(label_1);
		
		JLabel lblTimer = new JLabel(" ");
		toolBar.add(lblTimer);
		if (gameType == "Lightning Level"){
			lblTimer.setText("  Timer:");
		}
		else{
			lblTimer.setText("  Moves:");
		}
		
		
		textField = new JTextField();
		textField.setText("00");
		toolBar.add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel(":");
		toolBar.add(label);
		if (gameType == "Lightning Level"){
			label.setVisible(true);
		}
		else{
			label.setVisible(false);
		}
		
		timerORMoveTextField = new JTextField();
		timerORMoveTextField.setText("00");
		toolBar.add(timerORMoveTextField);
		timerORMoveTextField.setColumns(10);
		
		// Listen for changes in the text
		timerORMoveTextField.getDocument().addDocumentListener(new DocumentListener() {
		  public void warn() {
			  //0 is put in to handle nullPointerException, 0 is ignored if actual number is inputed
		     if (Integer.parseInt("0"+timerORMoveTextField.getText()) != 0){
		 		if (gameType == "Lightning Level"){
					gameTimer = Integer.parseInt("0"+timerORMoveTextField.getText());
			    	System.out.println("Time Set to " + Integer.parseInt("0"+timerORMoveTextField.getText()));
				}
				else{
					moveCounter = Integer.parseInt("0"+timerORMoveTextField.getText());
			    	System.out.println("Number of Moves Changed to " + Integer.parseInt("0"+timerORMoveTextField.getText()));
				}		    	 
		     }
		  }
		  
		  @Override
		  public void insertUpdate(DocumentEvent e) {
			  warn();

		  }
		  @Override
		  public void removeUpdate(DocumentEvent e) {
			  warn();
		  }
		  @Override
		  public void changedUpdate(DocumentEvent e) {
			  warn();
		  }
		});
		
		textField_1 = new JTextField();
		textField_1.setText("00");
		toolBar.add(textField_1);
		textField_1.setColumns(10);
		if (gameType == "Lightning Level"){
			textField_1.setVisible(true);
		}
		else{
			textField_1.setVisible(false);
		}
		
		JLabel label_2 = new JLabel("                                      ");
		toolBar.add(label_2);
		
		JLabel lblLevelBuilder = new JLabel("     ");
		String title = gameType + (" Builder");
		
		lblLevelBuilder.setText(title);
		
		lblLevelBuilder.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		toolBar.add(lblLevelBuilder);
		//groupLayout.setAutoCreateGaps(true);
		groupLayout.setAutoCreateContainerGaps(true);
		getContentPane().setLayout(groupLayout);

		
		/**Mouse Listener*/
		this.setLocationRelativeTo(null);
		

		
		
		int x = row;
		int y = col;
		
		/**
		 * 
		 *  BOARD INIT
		 * 	@param x ROWS
		 *  @param y COLUMNS
		 *  
		 */

		board.setLayout(new GridLayout(y,x));
		board.setPreferredSize(new Dimension(col*boardTileWidth,row*boardTileHeight));

		//board.setPreferredSize(new Dimension(384,384));
		//board.setMinimumSize(new Dimension(384,384));
		//board.setMaximumSize(new Dimension(384,384));
		
		/**
		 *  boardArray[][] holds all the tiles
		 *  of the board being created
		 * 
		 */
		
		Tile boardArray[][] = new Tile[x][y];
		
		Border BoardTileBorder = BorderFactory.createLineBorder(Color.BLACK, 1);

		
		for(int TileRow = 0; TileRow <y;TileRow++){
			for(int TileCol = 0; TileCol <x;TileCol++){
				
				PuzzleTile AddedTile = new PuzzleTile(board, TileCol,TileRow, 9999);

				AddedTile.setBackground(Color.white);

				AddedTile.setBorder(BoardTileBorder);

				boardArray[TileCol][TileRow] = AddedTile;
				board.add(AddedTile);
			}
		}

		board.makeBoard(boardArray, x, y, 1);
		
		
		/**
		 * 
		 *  BOARD INIT
		 * 	@param x ROWS
		 *  @param y COLUMNS
		 *  
		 */
		
		x=5;
		y=12;
		
		boardpen.setPreferredSize(new Dimension(26, crossHeight));
		boardpen.setMinimumSize(new Dimension(26, crossHeight));
		boardpen.setMaximumSize(new Dimension(26, crossHeight));
		boardpen.setLayout(new GridLayout(y, x));
		
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
				PuzzleTile AddedTile = new PuzzleTile(boardpen, TileCol,TileRow, 9999);

				// the new tile will be empty (Color is background color)
				AddedTile.setBackground(Color.decode("#4169aa"));

				// set border around tile (background color)
				AddedTile.setBorder(boardPenTileBorder);

				// add tile to boardArray
				boardPenArray[TileCol][TileRow] = AddedTile;
				boardpen.add(AddedTile);
			}
		}

		// make the board with the given boardArray
		boardpen.makeBoard(boardPenArray, x, y,3);
		

		/**
		 *  penArray[][] holds all the tiles
		 *  of the board being created
		 * 
		 */
		x = 14;
		y = 35;
		
		bullpen.setPreferredSize(new Dimension(140, 350));
		bullpen.setMaximumSize(new Dimension(140,350));
		bullpen.setMinimumSize(new Dimension(140,350));
		bullpen.setLayout(new GridLayout(35, 14));

		
		Border penTileBorder = BorderFactory.createLineBorder(Color.WHITE, 1);
		
		for(int TileRow = 0; TileRow <y;TileRow++){
			for(int TileCol = 0; TileCol <x;TileCol++){

				PuzzleTile AddedTile = new PuzzleTile(bullpen, TileCol,TileRow, 9999);

				AddedTile.setBackground(Color.white);

				AddedTile.setBorder(penTileBorder);

				penArray[TileCol][TileRow] = AddedTile;
				bullpen.add(AddedTile);
			}
		}
	
		bullpen.makeBoard(penArray, x, y, 2);

		
		bullpen.selectedPiece=null;
		bullpen.init=(true);
		int pos = BoardBoss.bullPenPosition;
		//bullpen.addHex(bullpen.returnBoard()[bullpen.returnWidth()/2][3], 1, Level.allhex.getHexList().get(pos));
		//bullpen.addHex(bullpen.returnBoard()[bullpen.returnWidth()/2][11], 2, Level.allhex.getHexList().get(pos+1));
		//bullpen.addHex(bullpen.returnBoard()[bullpen.returnWidth()/2][20],3, Level.allhex.getHexList().get(pos+2));
		//bullpen.refill=false;
		BoardBoss.bullPenPosition+=1;		
		bullpen.init=(false);
	
		
		//Bullpen.addHex(penArray[4][4], 2);
		BoardBoss.penPieces = 1;
	
		
		x = 240;
		y = 10;
				
		Inventory.setPreferredSize(new Dimension(4000, 100));
		//Inventory.setMinimumSize(new Dimension(140, 410));
		//Inventory.setMaximumSize(new Dimension(140, 410));
		
		Inventory.setLayout(new GridLayout(y, x));
		//Tile invArray[][] = new Tile[x][y];
		


		Border invTileBorder = BorderFactory.createLineBorder(Color.white, 1);

		for(int TileRow = 0; TileRow <y;TileRow++){
			for(int TileCol = 0; TileCol <x;TileCol++){

				PuzzleTile AddedTile = new PuzzleTile(Inventory, TileCol,TileRow, 9999);

				AddedTile.setBackground(Color.white);

				AddedTile.setBorder(invTileBorder);

				invArray[TileCol][TileRow] = AddedTile;

				Inventory.add(AddedTile);
			}
		}
			Inventory.makeBoard(invArray, x, y, 4);

			Inventory.selectedPiece = null;
			Inventory.init = true;
			for(int i=1;i<34;i++){
				Inventory.addHex(invArray[i*7][2], i, Level.allhex.getHexList().get(i-1));
			}
			Inventory.init=false;
			
		//	RotateCW_btn.addActionListener(new RotateController(this, MListener.datboi, 1));

			rotateFlip(MListener.datboi);


	}

	private ChangeListener changeColNum(Object value) {
		col = (Integer) value;
		return null;
	}


	private ChangeListener changeRowNum(Object value) {
		row = (Integer) value;
		return null;
	}



	public void quit(Builder parentView) {
		parentView.setVisible(false);	
		BuildStart bs = new BuildStart();
		bs.setVisible(true);
	}
	
	public void rotateFlip(Tile tiles){
		Tile datboi=tiles;
		System.out.println("ROTATE FLIP ");

		
		/*rotate controllers get current selected piece in bullpen
		Tile currentTile= null;
		for(int TileRow = 0; TileRow <35;TileRow++){
			for(int TileCol = 0; TileCol <14;TileCol++){
				if(penArray[TileCol][TileRow].getBackground()==Color.GREEN){
					currentTile=penArray[TileCol][TileRow];
					System.out.println("CURRENT TILE "+currentTile);
					break;
				}
			}
		}
			btnNewButton_1.addActionListener(new RotateController(this, currentTile, 1));
			btnR.addActionListener(new RotateController(this, currentTile, 2));
			btnNewButton.addActionListener(new FlipController(this, currentTile, 1));	
			btnR_1.addActionListener(new FlipController(this,currentTile, 2));
		*/
		
		System.out.println("CURRENT TILE1 "+datboi);
		//datboi is current selected tile
			RotateCW_btn.addActionListener(new RotateController(this, MListener.datboi, 1));
			RotateCCW_btn.addActionListener(new RotateController(this, MListener.datboi, 2));
			VertFlip_btn.addActionListener(new FlipController(this, MListener.datboi, 1));	
			HorFlip_btn.addActionListener(new FlipController(this,MListener.datboi, 2));
		
	}
}
