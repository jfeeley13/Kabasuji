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
import entity.BullPen;
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
import gameControllers.ExitController;


public class Builder extends JFrame{

	private JFrame frame;
	private JTextField txtGame;
	private JTextField textField;
	private JTextField textField_1;
	static String gameType;
	private int gameTimer = 0;
	private int moveCounter = 0;
	int row = 6;
	int col = 6;
	int boardTileWidth = 32; //Pixels
	int boardTileHeight = 32;
	AllHex allhex = new AllHex();
	private JTextField timerORMoveTextField;

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
		ColSpinner.setModel(new SpinnerNumberModel(6, 1, 12, 1));
		ColSpinner.setValue(col);
		
		JLabel lblX = new JLabel("x");
		lblX.setHorizontalAlignment(SwingConstants.LEFT);
		
		final JSpinner RowSpinner = new JSpinner();	//column spinner
		RowSpinner.setModel(new SpinnerNumberModel(6, 1, 12, 1));
		RowSpinner.setValue(row);
		
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
		
		
		/**BullPen Elements Initialized*/
		JScrollPane bullPen_scroll = new JScrollPane();
		bullPen_scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	    bullPen_scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		
		BoardBoss Bullpen = new BullPen();
		Bullpen.setPreferredSize(new Dimension(100, 3000));
		bullPen_scroll.setViewportView(Bullpen);
		
		
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
		//TODO: save controller
		
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
		
		//JPanel board = new JPanel();
		BoardBoss board = new Board();
		
		
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
								.addComponent(board, GroupLayout.PREFERRED_SIZE, row*boardTileHeight, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(6)
									.addComponent(lblPressFFor)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnUndo, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnTest, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblBullPin)
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
							.addComponent(lblBullPin)
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
							.addComponent(board, GroupLayout.PREFERRED_SIZE, col*boardTileWidth, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblInventory)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(inventory_scrollPane, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblPressFFor)))
					.addContainerGap())
		);
		
		JSplitPane splitPane_2 = new JSplitPane();
		splitPane_2.setOrientation(JSplitPane.VERTICAL_SPLIT);
		inventory_scrollPane.setRowHeaderView(splitPane_2);
		
		JButton RotateCW_btn = new JButton("\u21BB");
		splitPane_2.setLeftComponent(RotateCW_btn);
		RotateCW_btn.setPreferredSize(new Dimension(50, 38));	
		
		JButton RotateCCW_btn = new JButton("\u27F2");
		splitPane_2.setLeftComponent(RotateCCW_btn);
		RotateCCW_btn.setPreferredSize(new Dimension(50, 38));	

		JButton VertFlip_btn = new JButton("\u21C4");
		splitPane_2.setRightComponent(VertFlip_btn);
		VertFlip_btn.setPreferredSize(new Dimension(50, 10));	
		
		JButton HorFlip_btn = new JButton("\u21C5");
		splitPane_2.setRightComponent(HorFlip_btn);
		HorFlip_btn.setPreferredSize(new Dimension(50, 10));
		
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


		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setPreferredSize(new Dimension(100, 20));	

		bullPen_scroll.setColumnHeaderView(splitPane);
		
		
		BoardBoss BullPen = new BullPen();
		bullPen_scroll.setViewportView(BullPen);

		
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
		
		
		int x = col;
		int y = row;
		
		board.setLayout(new GridLayout(x,y));
		
		Tile boardArray[][] = new Tile[x][y];
		
		Border BoardTileBorder = BorderFactory.createLineBorder(Color.BLACK, 1);
		
		board.setPreferredSize(new Dimension(col*boardTileWidth,row*boardTileHeight));
		
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



		x = 14;
		y = 35;
		
		Bullpen.setPreferredSize(new Dimension(140, 410));
		Bullpen.setMinimumSize(new Dimension(140, 410));
		Bullpen.setMaximumSize(new Dimension(140, 410));
		
		Bullpen.setLayout(new GridLayout(y, x));
		
		Tile penArray[][] = new Tile[x+6][y+6];


		
		Border penTileBorder = BorderFactory.createLineBorder(Color.WHITE, 1);
		
		for(int TileRow = 0; TileRow <y;TileRow++){
			for(int TileCol = 0; TileCol <x;TileCol++){

				PuzzleTile AddedTile = new PuzzleTile(Bullpen, TileCol,TileRow, 9999);

				AddedTile.setBackground(Color.white);

				AddedTile.setBorder(penTileBorder);

				penArray[TileCol][TileRow] = AddedTile;
				Bullpen.add(AddedTile);
			}
		}
		Bullpen.selectedPiece = null;
		Bullpen.makeBoard(penArray, x, y, 2);
		Bullpen.init = true;
		Bullpen.addHex(penArray[2][2], 1, allhex.getHexList().get(2));
		//Bullpen.addHex(penArray[4][4], 2);
		BoardBoss.penPieces = 1;
		Bullpen.init=false;
	
		
		x = 400;
		y = 10;
				
		Inventory.setPreferredSize(new Dimension(4000, 100));
		//Inventory.setMinimumSize(new Dimension(140, 410));
		//Inventory.setMaximumSize(new Dimension(140, 410));
		
		Inventory.setLayout(new GridLayout(y, x));
		Tile invArray[][] = new Tile[x][y];
		


		Border invTileBorder = BorderFactory.createLineBorder(Color.white, 1);

		for(int TileRow = 0; TileRow <y;TileRow++){
			for(int TileCol = 0; TileCol <x;TileCol++){

				PuzzleTile AddedTile = new PuzzleTile(Inventory, TileCol,TileRow, 9999);

				AddedTile.setBackground(Color.white);

				AddedTile.setBorder(invTileBorder);

				invArray[TileCol][TileRow] = AddedTile;
				Inventory.add(AddedTile);
			}
			Inventory.selectedPiece = null;
			Inventory.makeBoard(invArray, x, y, 2);
			Inventory.init = true;
			//Inventory.addHex(penArray[2][2], 1);
			//Inventory.addHex(penArray[4][4], 2);
			Inventory.init=false;

		}
	
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


}
