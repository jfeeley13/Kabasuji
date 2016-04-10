import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

import javax.swing.JToolBar;
import javax.swing.UIManager;


public class SplashScreen {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SplashScreen window = new SplashScreen();
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
	public SplashScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		Color myColor = Color.decode("#4169aa");
		frame.getContentPane().setBackground(myColor); //frame.getContentPane().setBackground(UIManager.getColor("Desktop.background")); //#4169aa
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblKabasuji = new JLabel("KABASUJI");
		lblKabasuji.setFont(new Font("Lucida Grande", Font.BOLD, 36));
		
		JButton btnPlay = new JButton("PLAY");
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 LevelSelection newLevelSelectionWindow = new LevelSelection();
				// frame.dispose();													//closes current window
				 newLevelSelectionWindow.openWindow();
			}
		});
		
		JButton btnCustomLevels = new JButton("Custom Levels");
		
		JButton btnLevelBuilder = new JButton("Help");
		btnLevelBuilder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HelpScreen nw = new HelpScreen();
				
				nw.newwindow();
			}
		});
		
		JButton button = new JButton("Credits");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JToolBar toolBar = new JToolBar();
		Color myToolbarColor = Color.decode("#4b89d0");
		toolBar.setBackground(myToolbarColor);		//toolBar.setBackground(UIManager.getColor("MenuBar.selectionBackground"));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(144)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnLevelBuilder, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
						.addComponent(btnCustomLevels, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
						.addComponent(button, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE))
					.addGap(170))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(124, Short.MAX_VALUE)
					.addComponent(lblKabasuji, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
					.addGap(139))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(166)
					.addComponent(btnPlay, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(189, Short.MAX_VALUE))
				.addComponent(toolBar, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblKabasuji, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnPlay, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnCustomLevels)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnLevelBuilder)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(button)
					.addContainerGap(9, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
