package views;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.GridLayout;
import javax.swing.SwingConstants;


public class LevelSelection {
	static JLabel lblNewLabel;
	JLabel label;
	private JFrame frame;
	

	/**
	 * Launch the application.
	 */
	public static void openWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LevelSelection window = new LevelSelection();
					window.frame.setLocationRelativeTo(null);
					
					window.frame.setVisible(true);
					window.frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LevelSelection() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		Color myColor = Color.decode("#4b89d0");
		frame.getContentPane().setBackground(myColor); //frame.getContentPane().setBackground(UIManager.getColor("ComboBox.selectionBackground"));
		frame.setBounds(100, 100, 500, 320);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel_2 = new JPanel();
		Color myColor2 = Color.decode("#4169aa");
		panel_2.setBackground(myColor2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(myColor2);
		
		JLabel lblPuzzleLevel = new JLabel("Puzzle Level");
		lblPuzzleLevel.setFont(new Font("Meiryo", Font.BOLD, 13));
		lblPuzzleLevel.setToolTipText("Puzzle Level is based on ...");
		
		JLabel label_2 = new JLabel("Lightning Level");
		label_2.setFont(new Font("Meiryo", Font.BOLD, 13));
		
		JLabel label_4 = new JLabel("Release Level");
		label_4.setFont(new Font("Meiryo", Font.BOLD, 13));
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu nw = new Menu();
				frame.dispose();
				Menu.openWindow();
			}
		});
		
		JButton button_9 = new JButton("1");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Level nw = new Level();
				frame.dispose();
				Level.openLevel("Release Level", 1);
			}
		});
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));
		panel_1.add(button_9);
		
		JLabel label_10 = new JLabel("         ");
		label_10.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(label_10);
		
		JButton button_10 = new JButton("2");
		panel_1.add(button_10);
		
		JLabel label_11 = new JLabel("locked    ");
		label_11.setHorizontalAlignment(SwingConstants.CENTER);
		label_11.setFont(new Font("Lucida Grande", Font.ITALIC, 8));
		panel_1.add(label_11);
		
		JButton button_11 = new JButton("3");
		panel_1.add(button_11);
		
		JLabel label_12 = new JLabel("locked    ");
		label_12.setHorizontalAlignment(SwingConstants.CENTER);
		label_12.setFont(new Font("Lucida Grande", Font.ITALIC, 8));
		panel_1.add(label_12);
		
		JButton button_12 = new JButton("4");
		panel_1.add(button_12);
		
		JLabel lblnoStars = new JLabel("locked    ");
		lblnoStars.setHorizontalAlignment(SwingConstants.CENTER);
		lblnoStars.setFont(new Font("Lucida Grande", Font.PLAIN, 8));
		panel_1.add(lblnoStars);
		
		JButton button_13 = new JButton("5");
		panel_1.add(button_13);
		
		JLabel lblLocked_2 = new JLabel("locked   ");
		lblLocked_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblLocked_2.setFont(new Font("Lucida Grande", Font.ITALIC, 8));
		panel_1.add(lblLocked_2);
		
		JButton btnNewButton = new JButton("1");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Level nw = new Level();
				frame.dispose();
				Level.openLevel("Puzzle Level", 1);
			}
		});
		panel_2.setLayout(new GridLayout(0, 2, 0, 0));
		panel_2.add(btnNewButton);
		
		JButton button = new JButton("2");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		lblNewLabel = new JLabel(" ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.YELLOW);
		panel_2.add(lblNewLabel);
		panel_2.add(button);
		
		label = new JLabel("locked    ");
		
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Lucida Grande", Font.ITALIC, 8));
		panel_2.add(label);
		
		JButton button_1 = new JButton("3");
		panel_2.add(button_1);
		
		JLabel label_3 = new JLabel("locked    ");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("Lucida Grande", Font.ITALIC, 8));
		panel_2.add(label_3);
		
		JButton button_2 = new JButton("4");
		panel_2.add(button_2);
		
		JLabel label_1 = new JLabel("locked    ");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Lucida Grande", Font.ITALIC, 8));
		panel_2.add(label_1);
		
		JButton button_3 = new JButton("5");
		panel_2.add(button_3);
		
		JLabel lblNoStars = new JLabel("locked    ");
		lblNoStars.setHorizontalAlignment(SwingConstants.CENTER);
		lblNoStars.setFont(new Font("Lucida Grande", Font.ITALIC, 8));
		panel_2.add(lblNoStars);
		
		JPanel panel = new JPanel();
		panel.setBackground(myColor2);
		
		JButton button_4 = new JButton("1");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Level nw = new Level();
				frame.dispose();
				Level.openLevel("Lightning Level", 1);
			}
		});
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		panel.add(button_4);
		
		JLabel label_5 = new JLabel("         ");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(label_5);
		
		JButton button_5 = new JButton("2");
		panel.add(button_5);
		
		JLabel label_6 = new JLabel("locked    ");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setFont(new Font("Lucida Grande", Font.ITALIC, 8));
		panel.add(label_6);
		
		JButton button_6 = new JButton("3");
		panel.add(button_6);
		
		JLabel label_7 = new JLabel("locked    ");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setFont(new Font("Lucida Grande", Font.ITALIC, 8));
		panel.add(label_7);
		
		JButton button_7 = new JButton("4");
		panel.add(button_7);
		
		JLabel label_8 = new JLabel("locked    ");
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setFont(new Font("Lucida Grande", Font.ITALIC, 8));
		panel.add(label_8);
		
		JButton button_8 = new JButton("5");
		panel.add(button_8);
		
		JLabel label_9 = new JLabel("locked    ");
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setFont(new Font("Lucida Grande", Font.ITALIC, 8));
		panel.add(label_9);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(31)
					.addComponent(lblPuzzleLevel)
					.addGap(71)
					.addComponent(label_2)
					.addPreferredGap(ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
					.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
					.addGap(51))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(14)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
					.addGap(37)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
					.addGap(36)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
					.addGap(35))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(419, Short.MAX_VALUE)
					.addComponent(btnExit)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPuzzleLevel)
						.addComponent(label_2)
						.addComponent(label_4))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnExit)
					.addGap(20))
		);
		frame.getContentPane().setLayout(groupLayout);
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
