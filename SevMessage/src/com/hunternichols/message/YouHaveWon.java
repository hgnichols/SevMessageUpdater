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

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;
import java.awt.Color;

public class YouHaveWon extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					YouHaveWon frame = new YouHaveWon();
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
	public YouHaveWon() {

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {

				System.exit(0);
			}
		});
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.YELLOW);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("YOU HAVE WON! WINNER!");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Microsoft Yi Baiti", Font.BOLD, 30));
		lblNewLabel.setBounds(10, 11, 414, 28);
		contentPane.add(lblNewLabel);

		JLabel lblCongradulations = new JLabel("CONGRATULATIONS!");
		lblCongradulations.setHorizontalAlignment(SwingConstants.CENTER);
		lblCongradulations.setFont(new Font("Microsoft Yi Baiti", Font.BOLD, 30));
		lblCongradulations.setBounds(10, 50, 414, 28);
		contentPane.add(lblCongradulations);

		JLabel lblYouHaveWon = new JLabel("YOU HAVE WON A FREE");
		lblYouHaveWon.setHorizontalAlignment(SwingConstants.CENTER);
		lblYouHaveWon.setFont(new Font("Microsoft Yi Baiti", Font.BOLD, 30));
		lblYouHaveWon.setBounds(10, 98, 414, 28);
		contentPane.add(lblYouHaveWon);

		JLabel lblTripToMarriage = new JLabel("TRIP TO MARRIAGE TOWN!");
		lblTripToMarriage.setHorizontalAlignment(SwingConstants.CENTER);
		lblTripToMarriage.setFont(new Font("Microsoft Yi Baiti", Font.BOLD, 30));
		lblTripToMarriage.setBounds(10, 142, 414, 28);
		contentPane.add(lblTripToMarriage);

		JLabel lblCongratulations = new JLabel("CONGRATULATIONS!");
		lblCongratulations.setHorizontalAlignment(SwingConstants.CENTER);
		lblCongratulations.setFont(new Font("Microsoft Yi Baiti", Font.BOLD, 30));
		lblCongratulations.setBounds(10, 182, 414, 28);
		contentPane.add(lblCongratulations);

		JLabel label_4 = new JLabel("YOU HAVE WON! WINNER!");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("Microsoft Yi Baiti", Font.BOLD, 30));
		label_4.setBounds(10, 222, 414, 28);
		contentPane.add(label_4);
		
		contentPane.repaint();
	}

	public void SpamWinner() {

		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int screenWidth = gd.getDisplayMode().getWidth() - 489;
		int screenHeight = gd.getDisplayMode().getHeight() - 355;
		Random rand = new Random();
		YouHaveWon n1;

		for (int x = 0; x < 70; x++) {

			int width = rand.nextInt(screenWidth);
			int height = rand.nextInt(screenHeight);

			n1 = new YouHaveWon();
			n1.setBounds(width, height, 489, 355);
			n1.setVisible(true);

			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
