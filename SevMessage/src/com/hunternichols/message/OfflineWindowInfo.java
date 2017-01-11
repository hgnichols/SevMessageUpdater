package com.hunternichols.message;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.SwingConstants;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class OfflineWindowInfo extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OfflineWindowInfo frame = new OfflineWindowInfo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public OfflineWindowInfo() {
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int width = gd.getDisplayMode().getWidth();
		int height = gd.getDisplayMode().getHeight();
		this.setBounds(width / 3 + 150 , height / 3, 397, 267);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("NOTICE! You are in offline mode!");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Microsoft Yi Baiti", Font.BOLD, 23));
		lblNewLabel.setBounds(-22, 11, 414, 24);
		contentPane.add(lblNewLabel);
		
		JTextArea txtrPleaseContactYour = new JTextArea();
		txtrPleaseContactYour.setFont(new Font("Microsoft Yi Baiti", Font.PLAIN, 22));
		txtrPleaseContactYour.setText("Please contact your system administrator immediately! (or check your internet connection) Once the problem has been solved you must press \"Exit Without Refresh\" in the options menu, and then start the application again.");
		txtrPleaseContactYour.setEditable(false);
		txtrPleaseContactYour.setLineWrap(true);
		txtrPleaseContactYour.setWrapStyleWord(true);
		txtrPleaseContactYour.setBounds(25, 58, 333, 148);
		contentPane.add(txtrPleaseContactYour);
	}
}
