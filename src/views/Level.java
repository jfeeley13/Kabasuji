package views;

import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;

import java.awt.BasicStroke;
import java.awt.Color;

import javax.swing.table.DefaultTableModel;

import entity.Board;
import entity.BullPen;
import entity.HexTile;
import entity.Hexomino;
import entity.PuzzleTile;
import entity.Tile;
import gameControllers.MouseMove;

import javax.swing.JToolBar;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.JSplitPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.awt.event.KeyEvent;


public class Level extends JPanel implements ActionListener{

	public static JFrame frame;
	private JTable table_c;
	private JTable table;
	static String gameType;
	static int level;
	private int mouseX=0;
	private int mouseY=0;
	private boolean pieceSelected=false;
	boolean drawPiece=false;
	ArrayList <Hexomino> HexList;
	private  Hexomino selectedHex;

	/**
	 * Launch the application.
	 */
	public static void openLevel(String type, int levelnum) {
		gameType = type;
		level = levelnum;
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Level window = new Level();
					Level.frame.setLocationRelativeTo(null);
					frame.add(window);
					Level.frame.setVisible(true);
					Level.frame.setResizable(false);
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
	}
	  public void paintComponent(Graphics g){		  
		  //draw on g here e.g.
			  super.paintComponent(g);
			  g.setColor(Color.green);
//			  g.setStroke(new BasicStroke(2));
			  int width = 27;
			  int height = 27;
			  Hexomino hex = selectedHex;
		  if(drawPiece){
			  for (int i = 0; i < 6; i++){
				 int wConst = hex.getCoordShape()[i][0];
				 int hConst = hex.getCoordShape()[i][1];
				 int gapX = hex.getCoordShape()[i][0]*2;
				 int gapY = hex.getCoordShape()[i][1]*2;
			  ((Graphics2D)g).fillRect(mouseX+(width*wConst)+gapX, mouseY+(height*hConst)+gapY, width, height);
			  }
		  }
		  Color myColor = Color.decode("#4169aa");
		  this.setBackground(myColor);
           
         }
	  
		public Hexomino getHexPieceFromID(int ID){
			Hexomino hex = HexList.get(0);
			for(int i = 1; i < HexList.size(); i++){
				if (HexList.get(i).getID() == ID){
					hex = HexList.get(i);
				}
			}
			return hex;
		}

	  
	/**
	 */
	private void initialize() {
		HexList = makeHexominos();	//Makes all of the hexominos	
		frame = new JFrame();
		frame.setBounds(100, 100, 760, 550);
		frame.addMouseMotionListener(new MouseMove(this));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Timer timer = new Timer(10,this);
		timer.start(); 
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
		scrollPane.setPreferredSize(new Dimension(99, 400));	

	    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	    
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
		
		Board board = new Board();
		
		JLabel lblBoard = new JLabel("Board");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addComponent(toolBar, GroupLayout.DEFAULT_SIZE, 760, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(17)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(table_c, GroupLayout.PREFERRED_SIZE, 315, GroupLayout.PREFERRED_SIZE)
									.addGap(227))
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(lblBoard)
									.addComponent(board, GroupLayout.PREFERRED_SIZE, 348, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(30)
							.addComponent(lblF1)))
					.addPreferredGap(ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnExit)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
					.addGap(22)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 410, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(14)
							.addComponent(lblBoard)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(board, GroupLayout.PREFERRED_SIZE, 348, GroupLayout.PREFERRED_SIZE)
							.addGap(31)
							.addComponent(table_c, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnExit)
						.addComponent(lblF1))
					.addGap(34))
		);
		
		
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
		//bull pen initilize code goes in here
		BullPen pen= new BullPen(this,new ArrayList<Hexomino>());
		scrollPane.setViewportView(pen);
		
		//end of  bullpen initilize code
		
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
		
		JLabel label = new JLabel(" ");
		toolBar.add(label);
		if (gameType == "Lightning Level"){
			label.setText("  10:00");
		}
		else{
			label.setText("  40");
		}
		
		JLabel label_1 = new JLabel("                                                                       ");
		toolBar.add(label_1);
		
		JLabel lblLevel = new JLabel("");
		lblLevel.setText(gameType);
		
		lblLevel.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		toolBar.add(lblLevel);
		
		this.setLayout(groupLayout);

		board.setLayout(new GridLayout(12,12));
		board.setPreferredSize(new Dimension(384,384));
		board.setMinimumSize(new Dimension(384,384));
		board.setMaximumSize(new Dimension(384,384));
		
		Tile boardArray[][] = new Tile[12][12];
		
		Border BoardTileBorder = BorderFactory.createLineBorder(Color.BLACK, 2, true);
		
		//make board
		for(int TileCol = 0; TileCol <=11;TileCol++){
			for(int TileRow = 0; TileRow <=11;TileRow++){
				PuzzleTile AddedTile = new PuzzleTile(board, TileRow,TileCol);
				AddedTile.setBackground(Color.WHITE);
				AddedTile.setBorder(BoardTileBorder);
				boardArray[TileRow][TileCol] = AddedTile;
				board.add(AddedTile);
			}
		}
		board.makeBoard(this,boardArray);
	}
	/**Selects desired Hexomino*/
	public void selectHexomino(Hexomino Hex){
		selectedHex = Hex;
	}
	
	/** Creates all of the Hexominos*/
	private ArrayList<Hexomino> makeHexominos() {
		ArrayList<Hexomino> hexList = new ArrayList<Hexomino>();
		
		HexTile[] shape1 = {new HexTile(1,this, 0,0),new HexTile(1,this,0,1),new HexTile(1,this,0,2),new HexTile(1,this,0,3),new HexTile(1,this,0,4),new HexTile(1,this,0,5)};
		HexTile[] shape2 = {new HexTile(2,this, 0,0),new HexTile(2,this,1,1),new HexTile(2,this,0,2),new HexTile(2,this,0,3),new HexTile(2,this,0,4),new HexTile(2,this,0,1)};

		Hexomino h1 = new Hexomino(1, shape1);		
		Hexomino h2 = new Hexomino(2, shape2);
		hexList.add(h1);
		hexList.add(h2);

		return hexList;
	}

	public void hidePiece(){
		drawPiece=false;
	}
	public void drawPiece(){
		drawPiece=true;
	}

	public void setMouseXY(int x, int y){
		mouseX = x;
		mouseY = y;
	}
	
	public void setIfPieceSel(boolean isSel){
		pieceSelected = isSel;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("x: "+this.mouseX);
		System.out.println("y: "+this.mouseY);
		int x=this.mouseX;
		int y=this.mouseY;
			if(x>375 && pieceSelected==true){
				drawPiece();
			}
			else{
				hidePiece();
			}
		repaint();
	}
	


}
