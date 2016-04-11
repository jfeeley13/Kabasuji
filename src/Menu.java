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


public class Menu {

	private JFrame frame;

	public static void openWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
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
	public Menu() {
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
		
		JToolBar toolBar = new JToolBar();
		toolBar.setEnabled(false);
		toolBar.setFloatable(false);
		Color myToolbarColor = Color.decode("#4b89d0");
		toolBar.setBackground(myToolbarColor);		//toolBar.setBackground(UIManager.getColor("MenuBar.selectionBackground"));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(144)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnLevelBuilder, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
						.addComponent(btnCustomLevels, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE))
					.addGap(170))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(124)
					.addComponent(lblKabasuji, GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
					.addGap(139))
				.addComponent(toolBar, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(169)
					.addComponent(btnPlay, GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
					.addGap(186))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblKabasuji, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnPlay, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addGap(24)
					.addComponent(btnCustomLevels)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnLevelBuilder)
					.addContainerGap(44, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
