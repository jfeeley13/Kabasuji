package views;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class SplashScreen {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Timer timer;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					final SplashScreen window = new SplashScreen();
					
					window.frame.setLocationRelativeTo(null);
					window.frame.setVisible(true);
					window.frame.setResizable(false);
					Timer timer = new Timer(1000, new ActionListener() {
						
			            @Override
			            public void actionPerformed(ActionEvent e) {

			            	Menu mainMenu = new Menu();
			            	mainMenu.openWindow();
							window.frame.dispose();
							((Timer)e.getSource()).stop();
							
			            }
			        });
					

			        timer.start();
			        
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
		frame.getContentPane().setBackground(myColor);
		
		JLabel lblCredits = new JLabel("KABASUJI");
		lblCredits.setFont(new Font("Lucida Grande", Font.BOLD, 34));
		lblCredits.setHorizontalAlignment(SwingConstants.CENTER);
		
		JTextPane txtpnAthenaProjectCs = new JTextPane();
		txtpnAthenaProjectCs.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		txtpnAthenaProjectCs.setBackground(myColor);
		txtpnAthenaProjectCs.setEditable(false);
		txtpnAthenaProjectCs.setText("\n    Tyler Chaulk, Juan Chavez Guerrero, Jordan Feeley, Alex Perucic ");
		
		JLabel lblAthenaProjectGroup = new JLabel("Athena Project Group CS 3733");
		lblAthenaProjectGroup.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblCredits, GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(131, Short.MAX_VALUE)
					.addComponent(lblAthenaProjectGroup)
					.addGap(106))
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(txtpnAthenaProjectCs, GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblCredits, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblAthenaProjectGroup)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtpnAthenaProjectCs, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		frame.getContentPane().setLayout(groupLayout);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}
