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


public class Builder {

	private JFrame frame;
	private JTextField txtGame;
	private JTextField textField;
	private JTextField textField_1;
	int row;
	int col;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Builder window = new Builder();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Builder() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(UIManager.getColor("Desktop.background"));
		frame.setBounds(100, 100, 760, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	
		
		
		
		JToolBar toolBar = new JToolBar();	//toolbar
		toolBar.setFloatable(false);
		toolBar.setBackground(UIManager.getColor("MenuBar.selectionBackground"));
		
		JLabel lblBoardSize = new JLabel("Board Size:");	
		lblBoardSize.setHorizontalAlignment(SwingConstants.CENTER);
		
		final JSpinner spinner = new JSpinner();	//row spinner
		spinner.setModel(new SpinnerNumberModel(6, 1, 12, 1));
		//spinner.se
		spinner.setValue(6);
		
		JLabel lblX = new JLabel("x");
		lblX.setHorizontalAlignment(SwingConstants.LEFT);
		
		final JSpinner spinner_1 = new JSpinner();	//column spinner
		spinner_1.setModel(new SpinnerNumberModel(6, 1, 12, 1));
		spinner_1.setValue(6);
		
		JComboBox levelComboBox = new JComboBox();	//select which level to create
		levelComboBox.addItem("Release Level");
		levelComboBox.addItem("Lighning Level");
		levelComboBox.addItem("Puzzle Level");
		
		
		
		JComboBox setComboBox = new JComboBox();	//select create a set
		setComboBox.addItem("Red");
		setComboBox.addItem("Yellow");
		setComboBox.addItem("Green");
		setComboBox.addItem("Delete");
		
		JButton btnGenerate = new JButton("Generate Set");	//generate a random set
		btnGenerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
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

		
		
		JButton btnSave = new JButton("Save");
		
		JButton btnExit = new JButton("Exit");
		
		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 col = (Integer) spinner.getValue();
				 row = (Integer) spinner_1.getValue();
				
			}
		});
		
		
		
		JLabel lblInventory = new JLabel("Inventory:");
		
		JLabel lblBullPin = new JLabel("Bull Pin:");
		
		JPanel board = new JPanel();
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setModel(new SpinnerNumberModel(1, 1, 6, 1));
		
		JButton btnQuit = new JButton("Quit");
		
		JLabel lblPressFFor = new JLabel("Press F1 for Help");
		lblPressFFor.setFont(new Font("Lucida Grande", Font.ITALIC, 13));
		
		JButton btnChangeLevel = new JButton("New Level");
		
		JLabel lblRightClickTo = new JLabel("Right click to add/delete tile");
		lblRightClickTo.setFont(new Font("Lucida Grande", Font.ITALIC, 13));
		
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnQuit)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblPressFFor))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(12)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblInventory)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
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
								.addComponent(board, GroupLayout.PREFERRED_SIZE, 520, GroupLayout.PREFERRED_SIZE)
								.addComponent(inventory, GroupLayout.PREFERRED_SIZE, 575, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnUndo, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnTest, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblBullPin)
									.addGap(87)))
							.addGroup(groupLayout.createSequentialGroup()
								.addGap(6)
								.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
								.addContainerGap()))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(9)
							.addComponent(bullPin, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
							.addGap(6))))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(toolBar, GroupLayout.DEFAULT_SIZE, 743, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnUndo)
								.addComponent(btnTest)
								.addComponent(btnCreate)
								.addComponent(levelComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnChangeLevel))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblBullPin)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
									.addComponent(setComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGroup(groupLayout.createSequentialGroup()
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addComponent(btnGenerate)
											.addComponent(spinner_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(ComponentPlacement.RELATED)))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
									.addComponent(lblX)
									.addGap(24))
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
									.addComponent(spinner_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(12))
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(lblBoardSize)
									.addComponent(spinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.UNRELATED)
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
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnQuit)
								.addComponent(lblPressFFor))))
					.addContainerGap())
		);
		
		JPanel panel = new JPanel();
		inventory.setViewportView(panel);
		
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
		
		JLabel label_1 = new JLabel("           ");
		toolBar.add(label_1);
		
		JLabel lblTimer = new JLabel("  Timer:");
		toolBar.add(lblTimer);
		
		textField = new JTextField();
		textField.setText("00");
		toolBar.add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel(":");
		toolBar.add(label);
		
		textField_1 = new JTextField();
		textField_1.setText("00");
		toolBar.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_2 = new JLabel("                                                 ");
		toolBar.add(label_2);
		
		JLabel lblLevelBuilder = new JLabel("Level Builder    ");
		lblLevelBuilder.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		toolBar.add(lblLevelBuilder);
		groupLayout.setAutoCreateGaps(true);
		groupLayout.setAutoCreateContainerGaps(true);
		frame.getContentPane().setLayout(groupLayout);
	}
	
	/* public static boolean isCellVisible(JTable table, int rowIndex, int vColIndex) {
		    if (!(table.getParent() instanceof JViewport)) {
		      return false;
		    }
		    Point pt = viewport.getViewPosition();
		    rect.setLocation(rect.x - pt.x, rect.y - pt.y);
		    return new Rectangle(viewport.getExtentSize()).contains(rect);
		  }
	 
	 public static void scrollToVisible(JTable table, int rowIndex, int vColIndex) {
		    if (!(table.getParent() instanceof JViewport)) {
		      return;
		    }
		    Point pt = viewport.getViewPosition();
		    rect.setLocation(rect.x - pt.x, rect.y - pt.y);
		    viewport.scrollRectToVisible(rect);
		  }
		  */
}
