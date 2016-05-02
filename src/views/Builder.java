package views;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JToolBar;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JScrollPane;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.SwingConstants;
import javax.swing.JSplitPane;
import entity.AllHex;
import entity.Board;
import entity.BoardBoss;
import entity.BullPen;
import entity.PuzzleTile;
import entity.Tile;

import java.awt.Color;

import javax.swing.border.Border;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.SpinnerNumberModel;

import builderControllers.LevelBuilderController;
import gameControllers.ExitController;


public class Builder extends JFrame{

	/**Holds all the elements of a level*/
	private JFrame LevelFrame;
	
	/**TODO Figure out function*/
	private JTextField txtGame;
	
	/** TODO Figure out what this does*/
	private JTextField textField;
	
	/** TODO FIgure out what this does*/
	private JTextField textField_1;
	
	/** Game type- "Puzzle","Lightning", or "Release"*/ 
	static String gameType;
	
	/** Previously levelTime--Time left in the level*/
	private int levelTime = 0;
	
	/** Allowable moves for level*/
	private int moveCounter = 0;
	
	/** Number of rows on board*/
	int rows = 6;
	
	/**Number of columns on board*/
	int columns = 6;
	
	/** Width of board tile*/
	int boardTileWidth = 32; //Pixels
	
	/** Height of board tile*/
	int boardTileHeight = 32;
	
	/** Initializes all 35 Hexominos*/
	AllHex allhex = new AllHex();
	
	/** Displays current time left in level or moves left, depening on level type*/
	private JTextField timerORMoveTextField;

	/**
	 * Create the application.
	 */
	public Builder(String type, int rows, int cols) {
		gameType = type;
		this.rows = rows;
		columns = cols;
		this.setLocationRelativeTo(null);
		initialize();
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//frame = new JFrame();

		
		/**Initializes Windows*/
		Color myColor = Color.decode("#4169aa");
		getContentPane().setBackground(myColor);		
		setBounds(100, 100, 800, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/**Initializes Toolbar*/
		JToolBar toolBar = new JToolBar();
		Color myToolbarColor = Color.decode("#4b89d0");
		toolBar.setBackground(myToolbarColor);
		toolBar.setFloatable(false);
		
		
		/**Buttons and Text Used for defining board size*/
		JLabel lblBoardSize = new JLabel("Board Size:");	
		lblBoardSize.setHorizontalAlignment(SwingConstants.CENTER);
		
		final JSpinner ColSpinner = new JSpinner();	//row spinner
		ColSpinner.setModel(new SpinnerNumberModel(6, 1, 12, 1));
		ColSpinner.setValue(columns);
		
		JLabel lblX = new JLabel("x");
		lblX.setHorizontalAlignment(SwingConstants.LEFT);
		
		final JSpinner RowSpinner = new JSpinner();	//column spinner
		RowSpinner.setModel(new SpinnerNumberModel(6, 1, 12, 1));
		RowSpinner.setValue(rows);
		
		/**Used for defining level type*/
		final JComboBox levelComboBox = new JComboBox();	//select which level to create
		levelComboBox.addItem("Puzzle Level");
		levelComboBox.addItem("Lightning Level");
		levelComboBox.addItem("Release Level");

		levelComboBox.setSelectedItem(gameType);

		/**Release Level Logic for Adding colored numbers*/
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
		
		/**Button used to generate a random set of numbers*/
		JButton btnGenerate = new JButton("Generate Set");
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
		/**Used spinner used to set the desired number that the user wants to add*/
		JSpinner SetNumSpinner = new JSpinner();
		SetNumSpinner.setModel(new SpinnerNumberModel(1, 1, 6, 1));
		if (gameType == "Release Level"){
			SetNumSpinner.setVisible(true);
		}
		else{
			SetNumSpinner.setVisible(false);
		}

		
		
		/**Initializes Undo Button*/
		JButton btnUndo = new JButton("Undo");
		btnUndo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		/**Initializes testing TODO not sure if this is actually needed*/ 
		JButton btnTest = new JButton("Test");
		btnTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		
		/**BullPen Elements Initialized*/
		JScrollPane bullPen_scroll = new JScrollPane(); //ScrollPane
		bullPen_scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	    bullPen_scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		JLabel lblBullPen = new JLabel("Bull Pen:");

		
		BoardBoss Bullpen = new BullPen(); //Actual BullPen
//		bullPen_scroll.setViewportView(Bullpen);
		
		/**Inventory Elements Initialized*/
		JScrollPane inventory_scrollPane = new JScrollPane();
	    inventory_scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	    inventory_scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		JLabel lblInventory = new JLabel("Inventory:");
		if (gameType == "Lightning Level"){
			inventory_scrollPane.setVisible(false);
			lblInventory.setVisible(false);
		}
		else{
			inventory_scrollPane.setVisible(true);
			lblInventory.setVisible(true);
		}


		/**Save controller initialization*/	
		JButton btnSave = new JButton("Save");
		//TODO: save controller
		
		/**Button to exit level initialized*/
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ExitController(this));
		
		/** Button used to set new board size*/
		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rows = (Integer) RowSpinner.getValue();
				columns = (Integer) ColSpinner.getValue();
				new LevelBuilderController(Builder.this).process(levelComboBox.getSelectedItem().toString(), rows, columns);	
			}
		});
						
		/**Initialize Board*/
		BoardBoss board = new Board();
		
				
		JLabel lblPressFFor = new JLabel("Press F1 for Help");
		lblPressFFor.setFont(new Font("Lucida Grande", Font.ITALIC, 13));
		
		/**Resets level based on */
		JButton btnChangeLevel = new JButton("New Level");
		btnChangeLevel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LevelBuilderController(Builder.this).process(levelComboBox.getSelectedItem().toString(), rows, columns);	
			}
		});
		
		/**Text for how to add/remove a tile
		 * TODO Add independent mouse listener for when level builder is being played
		 */
		
		JLabel lblRightClickTo = new JLabel("Right click to add/delete tile");
		lblRightClickTo.setFont(new Font("Lucida Grande", Font.ITALIC, 13));
		
		
		
		
		/**Auto Generated Window Builder Code*/
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(12)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblInventory)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(lblBoardSize)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(ColSpinner, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(lblX, GroupLayout.PREFERRED_SIZE, 8, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(RowSpinner, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(btnCreate, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE))
										.addComponent(lblRightClickTo))
									.addGap(6)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(SetColorComboBox, 0, 86, Short.MAX_VALUE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(SetNumSpinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addComponent(levelComboBox, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(btnChangeLevel, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnGenerate, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE))
									.addGap(77))
								.addComponent(inventory_scrollPane, GroupLayout.PREFERRED_SIZE, 575, GroupLayout.PREFERRED_SIZE)
								.addComponent(board, GroupLayout.PREFERRED_SIZE, columns*boardTileWidth, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(6)
									.addComponent(lblPressFFor)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnUndo, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnTest, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblBullPen)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(6)
									.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(9)
									.addComponent(Bullpen, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(toolBar, GroupLayout.DEFAULT_SIZE, 749, Short.MAX_VALUE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
									.addComponent(btnUndo)
									.addComponent(btnTest)
									.addComponent(btnCreate)
									.addComponent(levelComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(btnChangeLevel))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblX)
									.addGap(12))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(RowSpinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(ColSpinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(5))))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblBoardSize)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addComponent(lblBullPen)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(SetColorComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(btnGenerate)
										.addComponent(SetNumSpinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED))))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblRightClickTo)
							.addGap(12)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(Bullpen, GroupLayout.PREFERRED_SIZE, 375, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnSave)
								.addComponent(btnExit)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(11)
							.addComponent(board, GroupLayout.PREFERRED_SIZE, rows*boardTileHeight, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblInventory)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(inventory_scrollPane, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblPressFFor)))
					.addContainerGap())
		);
		
//		BoardBoss Bullpen = new BullPen(); //Actual BullPen
//		bullPen_scroll.setViewportView(Bullpen);
		
		/**Initialize all rotate and flip buttons inside of the inventory*/
		JSplitPane invSplitPane = new JSplitPane();
		invSplitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		inventory_scrollPane.setRowHeaderView(invSplitPane);
		
		JButton RotateCW_btn = new JButton("\u21BB");
		invSplitPane.setLeftComponent(RotateCW_btn);
		RotateCW_btn.setPreferredSize(new Dimension(50, 38));	
		
		JButton RotateCCW_btn = new JButton("\u27F2");
		invSplitPane.setLeftComponent(RotateCCW_btn);
		RotateCCW_btn.setPreferredSize(new Dimension(50, 38));	

		JButton VertFlip_btn = new JButton("\u21C4");
		invSplitPane.setRightComponent(VertFlip_btn);
		VertFlip_btn.setPreferredSize(new Dimension(50, 10));	
		
		JButton HorFlip_btn = new JButton("\u21C5");
		invSplitPane.setRightComponent(HorFlip_btn);
		HorFlip_btn.setPreferredSize(new Dimension(50, 10));
		
		/**Initialize the inventory elements*/
		BoardBoss Inventory = new BullPen();
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


		/**Initialize the BullPen elements*/
//		JSplitPane splitPane = new JSplitPane();
//		splitPane.setPreferredSize(new Dimension(100, 20));	
//
//		bullPen_scroll.setColumnHeaderView(splitPane);
//		
//		BoardBoss BullPen = new BullPen();
//		bullPen_scroll.setViewportView(BullPen);

		
		JLabel lblLevelName = new JLabel("Level Name:");
		toolBar.add(lblLevelName);

		/**Initialize Level Name input text field
		 * TODO Add Listener in order to automatically update the level name when the keys are pressed
		 * */
		txtGame = new JTextField();
		txtGame.setText("game1");
		toolBar.add(txtGame);
		txtGame.setColumns(10);
		
		/**Spacer*/
		JLabel label_1 = new JLabel("                ");
		toolBar.add(label_1);
		
		/**Text field to differentiate between timer and move counter*/
		JLabel lblTimer = new JLabel(" ");
		toolBar.add(lblTimer);
		if (gameType == "Lightning Level"){
			lblTimer.setText("  Timer:");
		}
		else{
			lblTimer.setText("  Moves:");
		}
		
		/**Text field for move or timer counter, depending on level type*/
		timerORMoveTextField = new JTextField();
		timerORMoveTextField.setText("00");
		toolBar.add(timerORMoveTextField);
		timerORMoveTextField.setColumns(10);
		
		/**Listens for changes in counter*/
		timerORMoveTextField.getDocument().addDocumentListener(new DocumentListener() {
		  public void warn() {
			  //0 is put in to handle nullPointerException, 0 is ignored if actual number is inputed
		     if (Integer.parseInt("0"+timerORMoveTextField.getText()) != 0){
		 		if (gameType == "Lightning Level"){
					levelTime = Integer.parseInt("0"+timerORMoveTextField.getText());
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
		
		/**Initialize units label*/
		JLabel label = new JLabel("");
		toolBar.add(label);
		if (gameType == "Lightning Level"){
			label.setText(" seconds");
		}
		else{
			label.setText(" moves");
		}
		
		
		/**Spacer*/
		JLabel label_2 = new JLabel("                                      ");
		toolBar.add(label_2);
		
		/**Game type label*/
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
		
		
		int bRow = rows = 6;
		int bCol = columns = 6;
		
		board.setLayout(new GridLayout(bRow,bCol));
		
		Tile boardArray[][] = new Tile[bRow][bCol];
		
		Border BoardTileBorder = BorderFactory.createLineBorder(Color.BLACK, 1);
		
		board.setPreferredSize(new Dimension(bCol *boardTileWidth, bRow*boardTileHeight));
		
		for(int TileRow = 0; TileRow <bRow;TileRow++){
			for(int TileCol = 0; TileCol <bCol;TileCol++){
				
				PuzzleTile AddedTile = new PuzzleTile(board, TileRow,TileCol, 9999);

				AddedTile.setBackground(Color.white);

				AddedTile.setBorder(BoardTileBorder);

				boardArray[TileRow][TileCol] = AddedTile;
				board.add(AddedTile);
			}
		}
		board.makeBoard(boardArray, bRow, bCol, 1);



		int bpRow = 35;
		int bpCol = 14;
		
		Bullpen.setPreferredSize(new Dimension(bpCol*10, bpRow*10));
		Bullpen.setMinimumSize(new Dimension(bpCol*10, bpRow*10));
		Bullpen.setMaximumSize(new Dimension(bpCol*10, bpRow*10));
		
		Bullpen.setLayout(new GridLayout(bpRow, bpCol));
		
		Tile penArray[][] = new Tile[bpRow][bpCol];


		
		Border penTileBorder = BorderFactory.createLineBorder(Color.WHITE, 1);
		
		for(int TileRow = 0; TileRow <bpRow;TileRow++){
			for(int TileCol = 0; TileCol <bpCol;TileCol++){

				PuzzleTile AddedTile = new PuzzleTile(Bullpen, TileRow,TileCol, 9999);

				AddedTile.setBackground(Color.white);

				AddedTile.setBorder(penTileBorder);

				penArray[TileRow][TileCol] = AddedTile;
				Bullpen.add(AddedTile);
			}
		}
		Bullpen.setSelectedPiece(null);
		Bullpen.makeBoard(penArray, bpRow, bpCol, 2);
		Bullpen.setInit(true);
		Bullpen.addHex(penArray[2][2], 1, allhex.getHexList().get(2));
//		Bullpen.addHex(penArray[4][2], 2, allhex.getHexList().get(2));
//		Bullpen.addHex(penArray[6][2], 3, allhex.getHexList().get(2));
//		Bullpen.addHex(penArray[8][2], 4, allhex.getHexList().get(2));
		//Bullpen.addHex(penArray[4][4], 2);
		BoardBoss.setPenPieces(1);
		Bullpen.setInit(false);
	
		
		int iRow = 400;
		int iCol = 10;
				
		Inventory.setPreferredSize(new Dimension(4000, 100));
		//Inventory.setMinimumSize(new Dimension(140, 410));
		//Inventory.setMaximumSize(new Dimension(140, 410));
		
		Inventory.setLayout(new GridLayout(iRow, iCol));
		Tile invArray[][] = new Tile[iRow][iCol];
		

		Border invTileBorder = BorderFactory.createLineBorder(Color.white, 1);

		for(int TileRow = 0; TileRow <iRow;TileRow++){
			for(int TileCol = 0; TileCol <iCol;TileCol++){

				PuzzleTile AddedTile = new PuzzleTile(Inventory, TileRow,TileCol, 9999);

				AddedTile.setBackground(Color.white);

				AddedTile.setBorder(invTileBorder);

				invArray[TileRow][TileCol] = AddedTile;
				Inventory.add(AddedTile);
			}
		}
			Inventory.setSelectedPiece(null);
			Inventory.makeBoard(invArray, iRow, iCol, 3);
			Inventory.setInit(true);
			Inventory.addHex(invArray[8][2], 4, allhex.getHexList().get(2));
			//Inventory.addHex(penArray[4][4], 2);
			Inventory.setInit(false);

	}

	/**Changes number of columns based on value inputed*/
	private ChangeListener changeColNum(Object value) {
		columns = (Integer) value;
		return null;
	}

	/**Changes number of rows based on value inputed*/
	private ChangeListener changeRowNum(Object value) {
		rows = (Integer) value;
		return null;
	}



	public void quit(Builder parentView) {
		//parentView.setVisible(false);	
		BuildStart bs = new BuildStart();
		bs.setVisible(true);
	}


}
