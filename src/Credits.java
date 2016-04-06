import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextPane;


public class Credits {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Credits window = new Credits();
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
	public Credits() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(UIManager.getColor("Desktop.background"));
		
		JLabel lblCredits = new JLabel("Credits");
		lblCredits.setFont(new Font("Lucida Grande", Font.BOLD, 21));
		lblCredits.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblCredits, BorderLayout.NORTH);
		
		JTextPane txtpnAthenaProjectCs = new JTextPane();
		txtpnAthenaProjectCs.setBackground(UIManager.getColor("Desktop.background"));
		txtpnAthenaProjectCs.setEditable(false);
		txtpnAthenaProjectCs.setText("\t\t\t\t\t\t\t\tAthena Project CS3733 \n\t\t\t\t\t\t\t\t       Tyler Chaulk\n\t\t\t\t\t\t\t\t        Jordan Feeley\n\t\t\t\t\t\t\t\t        Juan Guerrero\n\t\t\t\t\t\t\t\t       Alex Perucic ");
		frame.getContentPane().add(txtpnAthenaProjectCs, BorderLayout.CENTER);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
