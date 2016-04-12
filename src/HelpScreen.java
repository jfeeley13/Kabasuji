import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Rectangle;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;


public class HelpScreen {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void newwindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HelpScreen window = new HelpScreen();
					window.frame.setLocationRelativeTo(null);
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
	public HelpScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		Color myColor = Color.decode("#4169aa");
		frame.getContentPane().setBackground(myColor);
		
		JLabel lblHelp = new JLabel("Help");
		lblHelp.setFont(new Font("Lucida Grande", Font.BOLD, 26));
		lblHelp.setHorizontalAlignment(SwingConstants.CENTER);
		
		JTextPane txtpnKabasujiTylerChaulk = new JTextPane();
		txtpnKabasujiTylerChaulk.setEditable(false);
		txtpnKabasujiTylerChaulk.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		txtpnKabasujiTylerChaulk.setText("Puzzle Level: It is possible to place all pieces in the bullpen into the board. You are given N moves to find a solution. Each piece is placed without overlapping any other piece on the board. \n\u2605\u2605\u2605 for placing all pieces \n\u2605\u2605 for placing all but 1 piece \n\u2605 for placing all but 2 pieces\n\r\nLighning Level: Complete as many moves within fixed time period. When a piece is played, its covered squares are MARKED and the piece disappears; a new piece replaces the old one in the bullpen\n\u2605\u2605\u2605 for placing all pieces \n\u2605\u2605 for marking all but 6\n\u2605 for for marking all but 12\n\nRelease Level: Covered numbers are \u201Ccollected\u201D. Goal is to accumulate THREE SETS of SIX NUMBERS of DIFFERENT COLORS. When a piece is played, its covered squares are MARKED and the piece disappears; a new piece replaces the old one in the bullpen\n\u2605\u2605\u2605 for releasing all 18 numbers\n\u2605\u2605 for releasing 2 complete sets\n\u2605 for releasing 1 complete set of same color");
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
					.addComponent(txtpnKabasujiTylerChaulk, GroupLayout.PREFERRED_SIZE, 303, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(btnExit)
					.addContainerGap())
		);
		frame.getContentPane().setLayout(groupLayout);
		frame.setBounds(100, 100, 550, 410);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
