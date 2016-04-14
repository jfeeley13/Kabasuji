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


public class LevelSelection {

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
		
		JPanel panel_2 = new JPanel();
		Color myColor2 = Color.decode("#4169aa");
		panel_2.setBackground(myColor2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(myColor2);
		
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
				nw.openWindow();
			}
		});
		
		JButton button_9 = new JButton("1");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Level nw = new Level();
				frame.dispose();
				nw.openLevel("Release Level", 1);
			}
		});
		
		JLabel label_10 = new JLabel("         ");
		
		JButton button_10 = new JButton("2");
		
		JLabel label_11 = new JLabel("locked    ");
		label_11.setFont(new Font("Lucida Grande", Font.ITALIC, 8));
		
		JButton button_11 = new JButton("3");
		
		JLabel label_12 = new JLabel("locked    ");
		label_12.setFont(new Font("Lucida Grande", Font.ITALIC, 8));
		
		JButton button_12 = new JButton("4");
		
		JLabel lblnoStars = new JLabel("locked    ");
		lblnoStars.setFont(new Font("Lucida Grande", Font.PLAIN, 8));
		
		JButton button_13 = new JButton("5");
		
		JLabel lblLocked_2 = new JLabel("locked   ");
		lblLocked_2.setFont(new Font("Lucida Grande", Font.ITALIC, 8));
		
		JButton btnNewButton = new JButton("1");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Level nw = new Level();
				frame.dispose();
				nw.openLevel("Puzzle Level", 1);
			}
		});
		
		JButton button = new JButton("2");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton button_1 = new JButton("3");
		
		JLabel label_3 = new JLabel("locked    ");
		label_3.setFont(new Font("Lucida Grande", Font.ITALIC, 8));
		
		JButton button_2 = new JButton("4");
		
		JLabel label_1 = new JLabel("locked    ");
		label_1.setFont(new Font("Lucida Grande", Font.ITALIC, 8));
		
		JButton button_3 = new JButton("5");
		
		JLabel lblNoStars = new JLabel("locked    ");
		lblNoStars.setFont(new Font("Lucida Grande", Font.ITALIC, 8));
		
		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("Desktop.background"));
		
		JButton button_4 = new JButton("1");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					Level nw = new Level();
					frame.dispose();
					nw.openLevel("Lightning Level", 1);
			}
		});
		
		JLabel label_5 = new JLabel("         ");
		
		JButton button_5 = new JButton("2");
		
		JLabel label_6 = new JLabel("locked    ");
		label_6.setFont(new Font("Lucida Grande", Font.ITALIC, 8));
		
		JButton button_6 = new JButton("3");
		
		JLabel label_7 = new JLabel("locked    ");
		label_7.setFont(new Font("Lucida Grande", Font.ITALIC, 8));
		
		JButton button_7 = new JButton("4");
		
		JLabel label_8 = new JLabel("locked    ");
		label_8.setFont(new Font("Lucida Grande", Font.ITALIC, 8));
		
		JButton button_8 = new JButton("5");
		
		JLabel label_9 = new JLabel("locked    ");
		label_9.setFont(new Font("Lucida Grande", Font.ITALIC, 8));
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
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(5)
					.addComponent(button_9)
					.addGap(5)
					.addComponent(label_10))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(5)
					.addComponent(button_10)
					.addGap(5)
					.addComponent(label_11))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(5)
					.addComponent(button_11)
					.addGap(5)
					.addComponent(label_12))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(5)
					.addComponent(button_12)
					.addGap(5)
					.addComponent(lblnoStars))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(6)
					.addComponent(button_13)
					.addGap(5)
					.addComponent(lblLocked_2))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(button_9)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(6)
							.addComponent(label_10)))
					.addGap(5)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(button_10)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(9)
							.addComponent(label_11)))
					.addGap(5)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(button_11)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(9)
							.addComponent(label_12)))
					.addGap(5)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(button_12)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(9)
							.addComponent(lblnoStars)))
					.addGap(5)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(button_13)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(9)
							.addComponent(lblLocked_2))))
		);
		panel_1.setLayout(gl_panel_1);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(button_4)
							.addGap(5)
							.addComponent(label_5))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(button_5)
							.addGap(5)
							.addComponent(label_6))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(button_6)
							.addGap(5)
							.addComponent(label_7))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(button_7)
							.addGap(5)
							.addComponent(label_8))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(button_8)
							.addGap(5)
							.addComponent(label_9))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(button_4)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(6)
							.addComponent(label_5)))
					.addGap(5)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(button_5)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(9)
							.addComponent(label_6)))
					.addGap(5)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(button_6)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(9)
							.addComponent(label_7)))
					.addGap(5)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(button_7)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(9)
							.addComponent(label_8)))
					.addGap(5)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(button_8)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(9)
							.addComponent(label_9))))
		);
		panel.setLayout(gl_panel);
		
		JLabel label = new JLabel("locked    ");
		label.setFont(new Font("Lucida Grande", Font.ITALIC, 8));
		
		JLabel label_13 = new JLabel("              ");
		label_13.setFont(new Font("Lucida Grande", Font.ITALIC, 8));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(btnNewButton)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label_13, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(button)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(button_1)
							.addGap(5)
							.addComponent(label_3))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(button_2)
							.addGap(5)
							.addComponent(label_1))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(button_3)
							.addGap(5)
							.addComponent(lblNoStars)))
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(label_13, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE))
					.addGap(5)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE))
					.addGap(5)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(button_1)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(9)
							.addComponent(label_3)))
					.addGap(5)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(button_2)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(9)
							.addComponent(label_1)))
					.addGap(5)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(button_3)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(9)
							.addComponent(lblNoStars))))
		);
		panel_2.setLayout(gl_panel_2);
		frame.getContentPane().setLayout(groupLayout);
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
