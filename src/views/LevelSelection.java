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
	static JLabel lblNewLabel, label, label_1, label_2, label_3, label_5, label_6, label_7, label_8, label_9, label_10, label_11, label_12, label_13, label_14;
	static JLabel Puzzlestars[] = {lblNewLabel, label, label_1, label_2, label_3};
	static JLabel Lightningstars[] = {label_5, label_6, label_7, label_8, label_9};
	static JLabel Releasestars[] = {label_10, label_11, label_12, label_13, label_14};
	static JButton button_1, button_2, button_3, button_4, button_5, button_6,  button_7, button_8, button_9, button_10, button_11, button_12, button_13, button_14, button_15; 
	static JButton Puzzlebuttons[] = {button_1, button_2, button_3, button_4, button_5};
	static JButton Lightningbuttons[] = {button_6,  button_7, button_8, button_9, button_10};
	static JButton Releasebuttons[] = {button_11, button_12, button_13, button_14, button_15};
	
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
		
		//Puzzle level panel
		JPanel panel_2 = new JPanel();
		Color myColor2 = Color.decode("#4169aa");
		panel_2.setBackground(myColor2);
		panel_2.setLayout(new GridLayout(0, 2, 0, 0));

		//Lightning Level panel
		JPanel panel = new JPanel();
		panel.setBackground(myColor2);
		panel.setLayout(new GridLayout(0, 2, 0, 0));

		//Release Level panel
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(myColor2);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));
		
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
		

		
		
		//In a loop of 5 load arrays buttons/labels
		for(int i=0;i<5;i++){
			final int level=i+1;
			Puzzlestars[i] = new JLabel(" ");
			Puzzlestars[i].setHorizontalAlignment(SwingConstants.CENTER);
			Puzzlestars[i].setFont(new Font("Lucida Grande", Font.ITALIC, 8));
			Puzzlebuttons[i] = new JButton(" "+ level);
			panel_2.add(Puzzlebuttons[i]);
			panel_2.add(Puzzlestars[i]);
	
			//action listener for each button
			Puzzlebuttons[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Level nw = new Level();
					frame.dispose();
					Level.openLevel("Puzzle Level", level);
				}
			});
			
			//check level star array for current score
			Puzzlestars[i].setText(Level.starPArray[level]);
		//	System.out.println("P i is "+ Level.starPArray[level]);
			//if no score label locked
			if (Puzzlestars[i].getText()==(null)){
				if (level==1){										//level 1 is unlocked
					Puzzlestars[i].setText(" ");
				}
				else{
					Puzzlestars[i].setText("locked");
				}
			}
			else{
				Puzzlestars[i].setForeground(Color.YELLOW);			//label has a score, make it yellow 
				Puzzlestars[i+1].setText(" ");						//next label is unlocked
			}


			Lightningstars[i]= new JLabel("locked ");
			Lightningstars[i].setHorizontalAlignment(SwingConstants.CENTER);
			Lightningstars[i].setFont(new Font("Lucida Grande", Font.ITALIC, 8));
			Lightningbuttons[i] = new JButton(" "+ (i+1));
			panel.add(Lightningbuttons[i]);
			panel.add(Lightningstars[i]);
			
			Lightningbuttons[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Level nw = new Level();
					frame.dispose();
					Level.openLevel("Lightning Level", level);
				}
			});
			
			Lightningstars[i].setText(Level.starLArray[level]);
		//	System.out.println("L i is "+ Level.starLArray[level]);

			if (Lightningstars[i].getText()==(null)){
				if (level==1){
					Lightningstars[i].setText(" ");
				}
				else{
					Lightningstars[i].setText("locked");
				}
			}
			else{
				Lightningstars[i].setForeground(Color.YELLOW);
				Lightningstars[i+1].setText(" ");
			}

			Releasestars[i]= new JLabel("locked ");
			Releasestars[i].setHorizontalAlignment(SwingConstants.CENTER);
			Releasestars[i].setFont(new Font("Lucida Grande", Font.ITALIC, 8));
			Releasebuttons[i] = new JButton(" "+ (i+1));
			panel_1.add(Releasebuttons[i]);
			panel_1.add(Releasestars[i]);
			
			
			Releasebuttons[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Level nw = new Level();
					frame.dispose();
					Level.openLevel("Release Level", level);
				}
			});
			
			Releasestars[i].setText(Level.starRArray[level]);
			if (Releasestars[i].getText()==(null)){
				if (level==1){
					Releasestars[i].setText(" ");
				}
				else{
					Releasestars[i].setText("locked");
				}
			}
			else{
				Releasestars[i].setForeground(Color.YELLOW);
				Releasestars[i+1].setText(" ");
			}
		}

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

	
}
