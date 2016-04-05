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


public class LevelSelection {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LevelSelection window = new LevelSelection();
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
	public LevelSelection() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(UIManager.getColor("ComboBox.selectionBackground"));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(UIManager.getColor("Desktop.background"));
		
		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("Desktop.background"));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(UIManager.getColor("Desktop.background"));
		
		JLabel lblPuzzleLevel = new JLabel("Puzzle Level");
		lblPuzzleLevel.setFont(new Font("Meiryo", Font.BOLD, 13));
		lblPuzzleLevel.setToolTipText("Puzzle Level is based on ...");
		
		JLabel label_2 = new JLabel("Lightning Level");
		label_2.setFont(new Font("Meiryo", Font.BOLD, 13));
		
		JLabel label_4 = new JLabel("Release Level");
		label_4.setFont(new Font("Meiryo", Font.BOLD, 13));
		
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(14)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(22, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(37)
					.addComponent(lblPuzzleLevel)
					.addPreferredGap(ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
					.addComponent(label_2)
					.addGap(43)
					.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
					.addGap(37))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(21, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_4)
						.addComponent(lblPuzzleLevel)
						.addComponent(label_2))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
						.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(37))
		);
		
		JButton button_9 = new JButton("1");
		panel_1.add(button_9);
		
		JLabel label_10 = new JLabel("\u2605\u2605\u2605");
		panel_1.add(label_10);
		
		JButton button_10 = new JButton("2");
		panel_1.add(button_10);
		
		JLabel label_11 = new JLabel("\u2605\u2605  ");
		panel_1.add(label_11);
		
		JButton button_11 = new JButton("3");
		panel_1.add(button_11);
		
		JLabel label_12 = new JLabel("         ");
		panel_1.add(label_12);
		
		JButton button_12 = new JButton("4");
		panel_1.add(button_12);
		
		JLabel lblnoStars = new JLabel("locked    ");
		lblnoStars.setFont(new Font("Lucida Grande", Font.PLAIN, 8));
		panel_1.add(lblnoStars);
		
		JButton button_13 = new JButton("5");
		panel_1.add(button_13);
		
		JLabel lblLocked_2 = new JLabel("locked   ");
		lblLocked_2.setFont(new Font("Lucida Grande", Font.ITALIC, 8));
		panel_1.add(lblLocked_2);
		
		JButton button_4 = new JButton("1");
		panel.add(button_4);
		
		JLabel label_5 = new JLabel("\u2605\u2605\u2605");
		panel.add(label_5);
		
		JButton button_5 = new JButton("2");
		panel.add(button_5);
		
		JLabel label_6 = new JLabel("\u2605\u2605   ");
		panel.add(label_6);
		
		JButton button_6 = new JButton("3");
		panel.add(button_6);
		
		JLabel label_7 = new JLabel("\u2605      ");
		panel.add(label_7);
		
		JButton button_7 = new JButton("4");
		panel.add(button_7);
		
		JLabel label_8 = new JLabel("          ");
		panel.add(label_8);
		
		JButton button_8 = new JButton("5");
		panel.add(button_8);
		
		JLabel lblLocked_1 = new JLabel("locked    ");
		lblLocked_1.setFont(new Font("Lucida Grande", Font.ITALIC, 8));
		panel.add(lblLocked_1);
		
		JButton btnNewButton = new JButton("1");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_2.add(btnNewButton);
		
		JButton button = new JButton("2");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JLabel lblNewLabel = new JLabel("\u2605\u2605\u2605");
		panel_2.add(lblNewLabel);
		panel_2.add(button);
		
		JLabel label = new JLabel("\u2605\u2605\u2605");
		panel_2.add(label);
		
		JButton button_1 = new JButton("3");
		panel_2.add(button_1);
		
		JLabel label_3 = new JLabel("\u2605      ");
		panel_2.add(label_3);
		
		JButton button_2 = new JButton("4");
		panel_2.add(button_2);
		
		JLabel lblLocked = new JLabel("            ");
		lblLocked.setFont(new Font("Lucida Grande", Font.PLAIN, 8));
		panel_2.add(lblLocked);
		
		JButton button_3 = new JButton("5");
		panel_2.add(button_3);
		
		JLabel lblNoStars = new JLabel("locked    ");
		lblNoStars.setFont(new Font("Lucida Grande", Font.ITALIC, 8));
		panel_2.add(lblNoStars);
		frame.getContentPane().setLayout(groupLayout);
	}
}
