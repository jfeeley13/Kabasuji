import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JToolBar;

import java.awt.BorderLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
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


public class Builder {

	private JFrame frame;
	private JTable table;
	private JTextField txtGame;
	private JTextField textField;
	private JTextField textField_1;

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
		frame.setBounds(100, 100, 730, 530);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		toolBar.setBackground(UIManager.getColor("MenuBar.selectionBackground"));
		
		JLabel lblBoardSize = new JLabel("Board Size:");
		lblBoardSize.setHorizontalAlignment(SwingConstants.CENTER);
		
		JSpinner spinner = new JSpinner();
		
		JLabel lblX = new JLabel("x");
		lblX.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JSpinner spinner_1 = new JSpinner();
		
		JComboBox levelComboBox = new JComboBox();
		levelComboBox.addItem("Release Level");
		levelComboBox.addItem("Lighning Level");
		levelComboBox.addItem("Puzzle Level");
		
		
		
		JComboBox setComboBox = new JComboBox();
		setComboBox.addItem("Red");
		setComboBox.addItem("Yellow");
		setComboBox.addItem("Green");
		setComboBox.addItem("Delete");
		
		JButton btnGenerate = new JButton("Generate");
		btnGenerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		JToggleButton tglbtnAddTile = new JToggleButton("Add Tile");
		tglbtnAddTile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
			}
		});
		
		JButton deltTileButton = new JButton("Delete Tile");
		deltTileButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		table.setRowSelectionAllowed(false);
		
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
		
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(12)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblBoardSize)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(spinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblX)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(spinner_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(levelComboBox, 0, 136, Short.MAX_VALUE)
									.addComponent(setComboBox, 0, 85, Short.MAX_VALUE)
									.addComponent(btnGenerate))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(tglbtnAddTile, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(deltTileButton))
								.addComponent(inventory, GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
								.addComponent(table, 0, 0, Short.MAX_VALUE))
							.addGap(37)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(btnUndo, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(btnTest, GroupLayout.PREFERRED_SIZE, 63, Short.MAX_VALUE))
									.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
										.addComponent(bullPin, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
										.addGap(6))))
							.addGap(6))
						.addComponent(toolBar, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 718, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblBoardSize)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(levelComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(setComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnGenerate)
							.addComponent(btnUndo)
							.addComponent(btnTest))
						.addComponent(spinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblX)
						.addComponent(spinner_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(tglbtnAddTile)
								.addComponent(deltTileButton))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(table, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE)
							.addComponent(inventory, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(bullPin, GroupLayout.PREFERRED_SIZE, 366, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnSave)
								.addComponent(btnExit))))
					.addContainerGap(22, Short.MAX_VALUE))
		);
		
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
}
