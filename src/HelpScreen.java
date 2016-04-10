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
		frame.getContentPane().setBackground(UIManager.getColor("Desktop.background"));
		
		JLabel lblHelp = new JLabel("Help");
		lblHelp.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lblHelp.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblHelp, BorderLayout.NORTH);
		
		JTextPane txtpnKabasujiTylerChaulk = new JTextPane();
		txtpnKabasujiTylerChaulk.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		txtpnKabasujiTylerChaulk.setText("Puzzle Level: It is possible to place all pieces in the bullpen into the board. You are given N moves to find a solution. Each piece is placed without overlapping any other piece on the board. \n\u2605\u2605\u2605 for placing all pieces \n\u2605\u2605 for placing all but 1 piece \n\u2605 for placing all but 2 pieces\n\r\nLighning Level: Complete as many moves within fixed time period. When a piece is played, its covered squares are MARKED and the piece disappears; a new piece replaces the old one in the bullpen\n\u2605\u2605\u2605 for placing all pieces \n\u2605\u2605 for marking all but 6\n\u2605 for for marking all but 12\n\nRelease Level: Covered numbers are \u201Ccollected\u201D. Goal is to accumulate THREE SETS of SIX NUMBERS of DIFFERENT COLORS. When a piece is played, its covered squares are MARKED and the piece disappears; a new piece replaces the old one in the bullpen\n\u2605\u2605\u2605 for releasing all 18 numbers\n\u2605\u2605 for releasing 2 complete sets\n\u2605 for releasing 1 complete set of same color");
		txtpnKabasujiTylerChaulk.setBackground(UIManager.getColor("Desktop.background"));
		frame.getContentPane().add(txtpnKabasujiTylerChaulk, BorderLayout.CENTER);
		frame.setBounds(100, 100, 550, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
