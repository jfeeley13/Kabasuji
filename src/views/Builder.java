package views;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JToolBar;

import java.awt.BorderLayout;

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

import javax.swing.UIManager;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;

import javax.swing.border.LineBorder;
import javax.swing.SpinnerNumberModel;

import gameControllers.SaveController;


public class Builder extends JFrame implements MouseListener{

	private JFrame frame;
	private JTextField txtGame;
	private JTextField textField;
	private JTextField textField_1;
	static String gameType;
	int row;
	int col;

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
		initialize();
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//frame = new JFrame();
		Color myColor = Color.decode("#4169aa");
		getContentPane().setBackground(myColor);
		setBounds(100, 100, 760, 550);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JToolBar toolBar = new JToolBar();
		Color myToolbarColor = Color.decode("#4b89d0");
		toolBar.setBackground(myToolbarColor);
		toolBar.setFloatable(false);
		
		JLabel lblBoardSize = new JLabel("Board Size:");	
		lblBoardSize.setHorizontalAlignment(SwingConstants.CENTER);
		
		final JSpinner spinner = new JSpinner();	//row spinner
		spinner.setModel(new SpinnerNumberModel(6, 1, 12, 1));
		spinner.setValue(6);
		
		JLabel lblX = new JLabel("x");
		lblX.setHorizontalAlignment(SwingConstants.LEFT);
		
		final JSpinner spinner_1 = new JSpinner();	//column spinner
		spinner_1.setModel(new SpinnerNumberModel(6, 1, 12, 1));
		spinner_1.setValue(6);
		
		final JComboBox levelComboBox = new JComboBox();	//select which level to create
		levelComboBox.addItem("Puzzle Level");
		levelComboBox.addItem("Lightning Level");
		levelComboBox.addItem("Release Level");

		levelComboBox.setSelectedItem(gameType);

		JComboBox setComboBox = new JComboBox();	//select create a set
		setComboBox.addItem("Red");
		setComboBox.addItem("Yellow");
		setComboBox.addItem("Green");
		setComboBox.addItem("Delete");
		if (gameType == "Release Level"){
			setComboBox.setVisible(true);
		}
		else{
			setComboBox.setVisible(false);
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
		row = 6;
		col = 6;
		
		
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
		
		
		
		JScrollPane bullPin = new JScrollPane();
		bullPin.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		
		JScrollPane inventory = new JScrollPane();
	    inventory.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		if (gameType == "Lightning Level"){
			inventory.setVisible(false);
		}
		else{
			inventory.setVisible(true);
		}

		
		
		JButton btnSave = new JButton("Save");
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new SaveController(this));

		/*btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SaveMenu nw = new SaveMenu();
				//frame.dispose();
				nw.setVisible(true);
				
				SaveController sc = new SaveController(this);
				
				BuildStart nw = new BuildStart();
				setVisible(false);
				//nw.openWindow();
				SaveMenu nw = new SaveMenu();
				//frame.dispose();
				nw.setVisible(true);
							
			}
		});
		*/
		
		JButton btnCreate = new JButton("Create");
		//TODO: this needs a controller
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				row = (Integer) spinner_1.getValue();
				col = (Integer) spinner.getValue();
				Builder nw = new Builder(levelComboBox.getSelectedItem().toString(), row, col);
				nw.setVisible(false);
				
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
		
		JPanel board = new JPanel();
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setModel(new SpinnerNumberModel(1, 1, 6, 1));
		if (gameType == "Release Level"){
			spinner_2.setVisible(true);
		}
		else{
			spinner_2.setVisible(false);
		}
		
		JLabel lblPressFFor = new JLabel("Press F1 for Help");
		lblPressFFor.setFont(new Font("Lucida Grande", Font.ITALIC, 13));
		
		JButton btnChangeLevel = new JButton("New Level");
		btnChangeLevel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String newType = levelComboBox.getItemAt(0).toString();
				Builder nw = new Builder(levelComboBox.getSelectedItem().toString(), row, col);
				nw.setVisible(true);
				//nw.openBuildWindow(levelComboBox.getSelectedItem().toString(), row, col);
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
											.addComponent(spinner, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(lblX, GroupLayout.PREFERRED_SIZE, 8, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(spinner_1, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(btnCreate, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE))
										.addComponent(lblRightClickTo))
									.addGap(6)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(setComboBox, 0, 86, Short.MAX_VALUE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(spinner_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addComponent(levelComboBox, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(btnChangeLevel, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnGenerate, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE))
									.addGap(77))
								.addComponent(inventory, GroupLayout.PREFERRED_SIZE, 575, GroupLayout.PREFERRED_SIZE)
								.addComponent(board, GroupLayout.PREFERRED_SIZE, 520, GroupLayout.PREFERRED_SIZE)
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
									.addComponent(bullPin, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE))))
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
										.addComponent(spinner_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(spinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(5))))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblBoardSize)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addComponent(lblBullPin)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(setComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(btnGenerate)
										.addComponent(spinner_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED))))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblRightClickTo)
							.addGap(12)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(bullPin, GroupLayout.PREFERRED_SIZE, 375, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnSave)
								.addComponent(btnExit)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(11)
							.addComponent(board, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblInventory)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(inventory, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblPressFFor)))
					.addContainerGap())
		);
		
		JSplitPane splitPane_2 = new JSplitPane();
		splitPane_2.setOrientation(JSplitPane.VERTICAL_SPLIT);
		inventory.setRowHeaderView(splitPane_2);
		
		JButton button_1 = new JButton("\u21BB");
		splitPane_2.setLeftComponent(button_1);
		button_1.setPreferredSize(new Dimension(27, 38));	

		
		JButton button_2 = new JButton("\u21C4");
		splitPane_2.setRightComponent(button_2);
		button_2.setPreferredSize(new Dimension(27, 10));	
		
		JPanel panel = new JPanel();
		inventory.setViewportView(panel);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 540, Short.MAX_VALUE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 90, Short.MAX_VALUE)
		);
		panel.setLayout(gl_panel);


		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setPreferredSize(new Dimension(100, 20));	

		bullPin.setColumnHeaderView(splitPane);
		
		JButton rotateButton = new JButton("\u21BB");
		rotateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		splitPane.setLeftComponent(rotateButton);
		rotateButton.setPreferredSize(new Dimension(50, 20));	
		
		JButton flipButton = new JButton("\u21C4");
		flipButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		splitPane.setRightComponent(flipButton);
		flipButton.setPreferredSize(new Dimension(40, 20));	
		
		JPanel panel_1 = new JPanel();
		bullPin.setViewportView(panel_1);

		
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
		
		board.addMouseListener(this);
	
	}

	

	@Override
	public void mouseClicked(MouseEvent me) {
		int pixRow = me.getY();
		int pixCol = me.getX();

		System.out.println(pixRow);
		System.out.println(pixCol);
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void quit(Builder parentView) {
		//parentView.setVisible(false);	
		BuildStart bs = new BuildStart();
		bs.setVisible(true);
	}
}
