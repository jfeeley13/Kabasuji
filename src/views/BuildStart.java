package views;

import builderControllers.CreateNewLevelController;
import builderControllers.LoadController;

import java.awt.Color;
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


public class BuildStart extends JFrame {

//	private JFrame frame;

//	public static void openWindow() {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					BuildStart window = new BuildStart();
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
	 * Create the application.
	 */
	public BuildStart() {
		super();
		initialize();
		
		//setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		//window.frame.setVisible(true);
		//window.frame.setResizable(false);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//frame = new JFrame();
		Color myColor = Color.decode("#4169aa");
		getContentPane().setBackground(myColor); //frame.getContentPane().setBackground(UIManager.getColor("Desktop.background")); //#4169aa
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblKabasuji = new JLabel("KABASUJI BUILDER");
		lblKabasuji.setFont(new Font("Lucida Grande", Font.BOLD, 36));
		
		JButton btnPlay = new JButton("Create Level");
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new CreateNewLevelController(BuildStart.this).process();
				// Builder newBuilderWindow = new Builder("Puzzle Level", 6, 6, "game1", 00);

				 //frame.dispose();													//closes current window
				 //newBuilderWindow.openBuildWindow("Puzzle Level", 6, 6);			//default puzzle with 6x6 board
			}
		});
		
		JButton btnCustomLevels = new JButton("Load Levels");
		btnCustomLevels.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LoadController("game11");	
			}
		});
		
		JButton btnLevelBuilder = new JButton("Help");
		btnLevelBuilder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HelpScreen nw = new HelpScreen();
				
				nw.newwindow();
			}
		});
		
		JToolBar toolBar = new JToolBar();
		toolBar.setEnabled(false);
		toolBar.setFloatable(false);
		Color myToolbarColor = Color.decode("#4b89d0");
		toolBar.setBackground(myToolbarColor);		//toolBar.setBackground(UIManager.getColor("MenuBar.selectionBackground"));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(toolBar, GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(49)
					.addComponent(lblKabasuji, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(214))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(153)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnLevelBuilder, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnCustomLevels, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
						.addComponent(btnPlay, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE))
					.addContainerGap(328, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblKabasuji, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
					.addGap(12)
					.addComponent(btnPlay, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnCustomLevels)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnLevelBuilder)
					.addContainerGap(50, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
	}
}
