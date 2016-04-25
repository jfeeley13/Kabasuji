package views;

import gameControllers.QuitController;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class SaveMenu extends JFrame {

	private JPanel contentPane;
	Builder parentView;


	/**
	 * Create the frame.
	 */
	public SaveMenu(Builder model) {
		this.parentView=model;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 250, 450, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		Color myColor = Color.decode("#4169aa");
		getContentPane().setBackground(myColor);
		setContentPane(contentPane);
		
		JLabel lblAreYouSure = new JLabel("Are you sure you want to exit without saving?");
		lblAreYouSure.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblAreYouSure.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new QuitController(this, parentView, true));
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new QuitController(this, parentView, false));

		/*btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//SaveMenu frame = new SaveMenu();
				setVisible(false);
				parentView.dispose();
				
			}
		});
		*/
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblAreYouSure, GroupLayout.PREFERRED_SIZE, 440, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(91)
							.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
							.addGap(53)
							.addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(31)
					.addComponent(lblAreYouSure)
					.addPreferredGap(ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
					.addGap(74))
		);
		contentPane.setLayout(gl_contentPane);
	}
}