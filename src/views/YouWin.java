package views;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;


public class YouWin {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void newwindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					YouWin window = new YouWin();
					window.frame.setLocationRelativeTo(null);
					window.frame.setUndecorated(true);
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
	public YouWin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		Color myColor = Color.decode("#4169aa");
		frame.getContentPane().setBackground(myColor);
		
		JLabel lblHelp = new JLabel("You win");
		lblHelp.setFont(new Font("Lucida Grande", Font.BOLD, 26));
		lblHelp.setHorizontalAlignment(SwingConstants.CENTER);
		
		JTextPane txtpnKabasujiTylerChaulk = new JTextPane();
		txtpnKabasujiTylerChaulk.setEditable(false);
		txtpnKabasujiTylerChaulk.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		txtpnKabasujiTylerChaulk.setText("Good job.");
		txtpnKabasujiTylerChaulk.setBackground(UIManager.getColor("Desktop.background"));
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Menu nw = new Menu();
				frame.dispose();
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblHelp, GroupLayout.PREFERRED_SIZE, 550, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(481)
							.addComponent(btnExit)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(txtpnKabasujiTylerChaulk, GroupLayout.PREFERRED_SIZE, 550, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(lblHelp)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtpnKabasujiTylerChaulk, GroupLayout.PREFERRED_SIZE, 333, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(btnExit)
					.addContainerGap())
		);
		frame.getContentPane().setLayout(groupLayout);
		frame.setBounds(100, 100, 600, 460);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
