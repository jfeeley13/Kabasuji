import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.table.DefaultTableModel;
import javax.swing.JToolBar;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JProgressBar;
import javax.swing.border.MatteBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JToggleButton;
import javax.swing.JSplitPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class Level {

	private JFrame frame;
	private JTable table_c;
	private JTable table;
	static String gameType;
	static int level;

	

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
	public Level() {
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
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBackground(UIManager.getColor("MenuBar.selectionBackground"));
		
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
		
		JLabel lblPressFFor = new JLabel("Press F1 for Help");
		lblPressFFor.setHorizontalAlignment(SwingConstants.LEFT);
		lblPressFFor.setFont(new Font("Lucida Grande", Font.ITALIC, 13));
		
		JPanel panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addComponent(toolBar, GroupLayout.DEFAULT_SIZE, 760, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(17)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 546, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(table_c, GroupLayout.PREFERRED_SIZE, 315, GroupLayout.PREFERRED_SIZE)
									.addGap(227))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(30)
							.addComponent(lblPressFFor)))
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
							.addGap(36)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 268, GroupLayout.PREFERRED_SIZE)
							.addGap(31)
							.addComponent(table_c, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnExit)
						.addComponent(lblPressFFor))
					.addGap(34))
		);
		
		JSplitPane splitPane = new JSplitPane();
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
		
		JPanel panel_1 = new JPanel();
		scrollPane.setViewportView(panel_1);
		

		
		JLabel lblNewLabel = new JLabel("Level:");
		toolBar.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("     ");
		lblNewLabel_1.setText(String.valueOf(level));
		toolBar.add(lblNewLabel_1);
		
		JLabel stars = new JLabel("\u2605\u2605\u2605");
		toolBar.add(stars);
		
		JLabel lblNewLabel_3 = new JLabel("                     ");
		toolBar.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel("\"Timer/Moves\":");
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.ITALIC, 13));
		toolBar.add(lblNewLabel_2);
		
		JLabel label = new JLabel("  00:00");
		toolBar.add(label);
		
		JLabel label_1 = new JLabel("                                                                       ");
		toolBar.add(label_1);
		
		JLabel lblLevel = new JLabel("");
		lblLevel.setText(gameType);
		
		lblLevel.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		toolBar.add(lblLevel);
		frame.getContentPane().setLayout(groupLayout);
	}
}
